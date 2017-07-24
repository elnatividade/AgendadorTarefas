package br.com.jctm.agendadortarefas.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;

import br.com.jctm.agendadortarefas.controler.AgendamentoControler;
import br.com.jctm.agendadortarefas.model.AgendamentoModel;

public class AgendamentoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txfNome;
	private JTextField txfGrupo;
	private JTextField txfDescricao;
	private JTextField txfCron;
	private JPanel pnlCamposAgendamentos;
	private JPanel pnlAgendamento;
	private JLabel lblNewLabel;
	private JLabel lblGrupo;
	private JLabel lblCron;
	private JPanel pnlCamposTarefa;
	private JButton btnAdicionarTarefa;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxTipoTarefa;
	private JButton btnCancelarAgendamento;
	private AgendamentoModel agendamento;
	

	
	public AgendamentoView() {
		setTitle("Adicionar Agendamento");
		this.agendamento = new AgendamentoModel();
		this.agendamento.setNome("");
		this.agendamento.setGrupo("");
		this.agendamento.setDescricao("");
		this.agendamento.setCron("");
		inicializarComponentes();
	}

	
		
	public AgendamentoView(AgendamentoModel agendamento){
		setTitle("Editar Agendamento");
		this.agendamento = agendamento;
		inicializarComponentes();
		
	}

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 614, 330);
		pnlAgendamento = new JPanel();
		pnlAgendamento.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlAgendamento);
		pnlAgendamento.setLayout(null);
		
		pnlCamposAgendamentos = new JPanel();
		pnlCamposAgendamentos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Agendamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCamposAgendamentos.setBounds(4, 11, 590, 153);
		pnlAgendamento.add(pnlCamposAgendamentos);
		pnlCamposAgendamentos.setLayout(null);
		
		lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(6, 16, 355, 14);
		pnlCamposAgendamentos.add(lblNewLabel);
		
		txfNome = new JTextField();
		txfNome.setBounds(6, 32, 355, 20);
		txfNome.setColumns(10);
		txfNome.setText(agendamento.getNome());
		pnlCamposAgendamentos.add(txfNome);
		
		
		lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(371, 16, 213, 14);
		pnlCamposAgendamentos.add(lblGrupo);
		
		txfGrupo = new JTextField();
		txfGrupo.setBounds(371, 32, 213, 20);
		txfGrupo.setColumns(10);
		txfGrupo.setText(agendamento.getGrupo());
		pnlCamposAgendamentos.add(txfGrupo);
		
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(6, 63, 578, 14);
		pnlCamposAgendamentos.add(lblDescrio);
		
		txfDescricao = new JTextField();
		txfDescricao.setBounds(6, 79, 578, 20);
		txfDescricao.setColumns(10);
		txfDescricao.setText(agendamento.getDescricao());
		pnlCamposAgendamentos.add(txfDescricao);
		
		
		lblCron = new JLabel("Cron");
		lblCron.setBounds(6, 110, 578, 14);
		pnlCamposAgendamentos.add(lblCron);
		
		txfCron = new JTextField();
		txfCron.setBounds(6, 126, 578, 20);
		txfCron.setColumns(10);
		txfCron.setText(agendamento.getCron());
		pnlCamposAgendamentos.add(txfCron);
		
		
		pnlCamposTarefa = new JPanel();
		pnlCamposTarefa.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tarefa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCamposTarefa.setBounds(4, 175, 590, 66);
		pnlAgendamento.add(pnlCamposTarefa);
		pnlCamposTarefa.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 18, 355, 14);
		pnlCamposTarefa.add(lblTipo);
		
		btnAdicionarTarefa = new JButton("Adicionar Tarefa");
		btnAdicionarTarefa.setBounds(367, 34, 213, 20);
		pnlCamposTarefa.add(btnAdicionarTarefa);
		
		cbxTipoTarefa = new JComboBox();
		cbxTipoTarefa.setModel(new DefaultComboBoxModel(TipoTarefaEnum.values()));
		cbxTipoTarefa.setBounds(10, 34, 355, 20);
		pnlCamposTarefa.add(cbxTipoTarefa);
		
		btnCancelarAgendamento = new JButton("Cancelar");
		btnCancelarAgendamento.setBounds(254, 257, 89, 23);
		pnlAgendamento.add(btnCancelarAgendamento);
		
		btnAdicionarTarefa.addActionListener(new AdicionarTarefa());
		btnCancelarAgendamento.addActionListener(new CancelarTarefa());
		
				
		
	}
	
	
	
	private void limparAgendamentoView(){
		txfNome.setText("");
		txfGrupo.setText("");
		txfDescricao.setText("");
		txfCron.setText("");
	}
	
	
	
	private class AdicionarTarefa implements ActionListener{

		public void actionPerformed(ActionEvent ev) {
			HashMap<String, String> dadosTela = new HashMap<String, String>();
			dadosTela.put("nome", txfNome.getText());
			dadosTela.put("grupo", txfGrupo.getText());
			dadosTela.put("descricao", txfDescricao.getText());
			dadosTela.put("cron", txfCron.getText());
			dadosTela.put("tipoTarefa", cbxTipoTarefa.getSelectedItem().toString());
			AgendamentoControler agendamentoControler = new AgendamentoControler();
			agendamentoControler.adicionarAgendamento(dadosTela);
			limparAgendamentoView();
			AgendadorTarefasView.atualizarTabelaAgendamentos();	
			
		}
		
	}
	
	
	
	private class CancelarTarefa implements ActionListener{

		public void actionPerformed(ActionEvent ev) {
			dispose();
			
		}
		
	}
	
	
	
}
