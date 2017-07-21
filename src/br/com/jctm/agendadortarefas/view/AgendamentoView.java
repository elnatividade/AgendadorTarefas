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
	

	
	
	public AgendamentoView() {
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
		pnlCamposAgendamentos.add(txfNome);
		txfNome.setColumns(10);
		
		lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(371, 16, 213, 14);
		pnlCamposAgendamentos.add(lblGrupo);
		
		txfGrupo = new JTextField();
		txfGrupo.setBounds(371, 32, 213, 20);
		pnlCamposAgendamentos.add(txfGrupo);
		txfGrupo.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(6, 63, 578, 14);
		pnlCamposAgendamentos.add(lblDescrio);
		
		txfDescricao = new JTextField();
		txfDescricao.setBounds(6, 79, 578, 20);
		pnlCamposAgendamentos.add(txfDescricao);
		txfDescricao.setColumns(10);
		
		lblCron = new JLabel("Cron");
		lblCron.setBounds(6, 110, 578, 14);
		pnlCamposAgendamentos.add(lblCron);
		
		txfCron = new JTextField();
		txfCron.setBounds(6, 126, 578, 20);
		pnlCamposAgendamentos.add(txfCron);
		txfCron.setColumns(10);
		
		pnlCamposTarefa = new JPanel();
		pnlCamposTarefa.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tarefa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCamposTarefa.setBounds(4, 175, 590, 66);
		pnlAgendamento.add(pnlCamposTarefa);
		pnlCamposTarefa.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 18, 355, 14);
		pnlCamposTarefa.add(lblTipo);
		
		btnAdicionarTarefa = new JButton("Adicionar Tarefa");
		btnAdicionarTarefa.setBounds(367, 34, 213, 23);
		pnlCamposTarefa.add(btnAdicionarTarefa);
		
		cbxTipoTarefa = new JComboBox();
		cbxTipoTarefa.setModel(new DefaultComboBoxModel(TipoTarefaEnum.values()));
		cbxTipoTarefa.setBounds(10, 35, 355, 20);
		pnlCamposTarefa.add(cbxTipoTarefa);
		
		btnCancelarAgendamento = new JButton("Cancelar");
		btnCancelarAgendamento.setBounds(254, 257, 89, 23);
		pnlAgendamento.add(btnCancelarAgendamento);
		
		AgendamentoViewListner ouvinte = new AgendamentoViewListner();
		btnAdicionarTarefa.addActionListener(ouvinte);
		btnCancelarAgendamento.addActionListener(ouvinte);
	}
	
	
	
	public void limparAgendamentoView(){
		txfNome.setText("");
		txfGrupo.setText("");
		txfDescricao.setText("");
		txfCron.setText("");
	}
	
	
	
	private class AgendamentoViewListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Adicionar Tarefa")){
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
				
			}else if(e.getActionCommand().equals("Cancelar")){
				dispose();
				
			}
			
		}
				
		
	}
		
}
