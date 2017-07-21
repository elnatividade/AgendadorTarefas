package br.com.jctm.agendadortarefas.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;

import br.com.jctm.agendadortarefas.controler.AgendamentoControler;
import br.com.jctm.agendadortarefas.model.AgendamentoModel;
import br.com.jctm.agendadortarefas.model.AgendamentoTableModel;



public class AgendadorTarefasView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnlAgendamentoTarefas;
	private JPanel pnlAgendamentos;
	private JButton btnPararAgendametos;
	private JButton btnAdicionarAgendamento;
	private JButton btnRemoverAgendamento;
	private JButton btnExecutarAgendamentos;
	private static JTable tblListaAgendamentos;
	private ArrayList<AgendamentoModel> listaAgendamentos;

	
	
	public AgendadorTarefasView() {
		setTitle("Agendador de Tarefas");
		this.listaAgendamentos = new AgendamentoControler().listarTodosAgendamentos();
		inicializarComponentes();
	}

	

	private void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 355);
		pnlAgendamentoTarefas = new JPanel();
		pnlAgendamentoTarefas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlAgendamentoTarefas);
		pnlAgendamentoTarefas.setLayout(null);
		
		pnlAgendamentos = new JPanel();
		pnlAgendamentos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Agendamentos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlAgendamentos.setBounds(10, 0, 614, 268);
		pnlAgendamentoTarefas.add(pnlAgendamentos);
		pnlAgendamentos.setLayout(null);
		
		JScrollPane spnlTabelaAgendamentos = new JScrollPane();
		spnlTabelaAgendamentos.setBounds(12, 21, 589, 218);
		pnlAgendamentos.add(spnlTabelaAgendamentos);
		
		tblListaAgendamentos = new JTable(new AgendamentoTableModel(listaAgendamentos));
		spnlTabelaAgendamentos.setViewportView(tblListaAgendamentos);
		
		btnAdicionarAgendamento = new JButton("+");
		btnAdicionarAgendamento.setBounds(12, 244, 297, 15);
		pnlAgendamentos.add(btnAdicionarAgendamento);
		
		btnRemoverAgendamento = new JButton("-");
		btnRemoverAgendamento.setBounds(304, 244, 297, 15);
		pnlAgendamentos.add(btnRemoverAgendamento);
		
		btnExecutarAgendamentos = new JButton("Executar Agendamentos");
		btnExecutarAgendamentos.setBounds(9, 272, 292, 33);
		pnlAgendamentoTarefas.add(btnExecutarAgendamentos);
		
		btnPararAgendametos = new JButton("Parar Agendamentos");
		btnPararAgendametos.setBounds(331, 272, 292, 33);
		pnlAgendamentoTarefas.add(btnPararAgendametos);
		
		
		AgendadorTarefasMainListner ouvinte = new AgendadorTarefasMainListner();
		btnAdicionarAgendamento.addActionListener(ouvinte);
		btnPararAgendametos.addActionListener(ouvinte);
		btnExecutarAgendamentos.addActionListener(ouvinte);	
		btnRemoverAgendamento.addActionListener(ouvinte);
	}
	
	
	
	public static void atualizarTabelaAgendamentos(){
		ArrayList<AgendamentoModel>listaAgendamentos = new AgendamentoControler().listarTodosAgendamentos();
		AgendamentoTableModel agendamentoTableModel = new AgendamentoTableModel(listaAgendamentos);
		tblListaAgendamentos.setModel(agendamentoTableModel);
	}
	
	
		
	private class AgendadorTarefasMainListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("+")){
				AgendamentoView agendamentoView = new AgendamentoView();
				agendamentoView.setLocationRelativeTo(null);
				agendamentoView.setVisible(true);
			
			}else if(e.getActionCommand().equals("-")){
				JOptionPane.showMessageDialog(null, "Remover Agendamento");
				int index = tblListaAgendamentos.getSelectedRow();
				String nome = "";
				AgendamentoControler agendamentoControler = new AgendamentoControler();
				agendamentoControler.removerAgendamento(nome);
				
			}else if(e.getActionCommand().equals("Executar Agendamentos")){
				JOptionPane.showMessageDialog(null, "Executar Agendamentos");
				
			}else if(e.getActionCommand().equals("Parar Agendamentos")){
				JOptionPane.showMessageDialog(null, "Parar Agendamentos");
				
			}
			
		}
			
	}
}
