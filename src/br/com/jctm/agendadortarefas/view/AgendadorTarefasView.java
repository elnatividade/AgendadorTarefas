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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		pnlAgendamentos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lista de Agendamentos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlAgendamentos.setBounds(10, 0, 614, 268);
		pnlAgendamentoTarefas.add(pnlAgendamentos);
		pnlAgendamentos.setLayout(null);
		
		JScrollPane spnlTabelaAgendamentos = new JScrollPane();
		spnlTabelaAgendamentos.setBounds(12, 21, 589, 218);
		pnlAgendamentos.add(spnlTabelaAgendamentos);
		
		tblListaAgendamentos = new JTable(new AgendamentoTableModel(listaAgendamentos));
		tblListaAgendamentos.addMouseListener(new EditarAgendamento());
		spnlTabelaAgendamentos.setViewportView(tblListaAgendamentos);
		
		btnAdicionarAgendamento = new JButton("+");
		btnAdicionarAgendamento.setBounds(12, 244, 297, 15);
		pnlAgendamentos.add(btnAdicionarAgendamento);
		
		btnRemoverAgendamento = new JButton("-");
		btnRemoverAgendamento.setBounds(304, 244, 297, 15);
		pnlAgendamentos.add(btnRemoverAgendamento);
		
		btnExecutarAgendamentos = new JButton("Executar Agendamentos");
		btnExecutarAgendamentos.setBounds(10, 272, 292, 33);
		pnlAgendamentoTarefas.add(btnExecutarAgendamentos);
		
		btnPararAgendametos = new JButton("Parar Agendamentos");
		btnPararAgendametos.setBounds(331, 272, 292, 33);
		pnlAgendamentoTarefas.add(btnPararAgendametos);
		
		
		btnAdicionarAgendamento.addActionListener(new AdicionarAgendamento());
		btnRemoverAgendamento.addActionListener(new RemoverAgendamento());
		btnExecutarAgendamentos.addActionListener(new ExecutarListaAgendamentos());	
		btnPararAgendametos.addActionListener(new PausarListaAgendamentos());
	}
	
	
	
	public static void atualizarTabelaAgendamentos(){
		ArrayList<AgendamentoModel>listaAgendamentos = new AgendamentoControler().listarTodosAgendamentos();
		AgendamentoTableModel agendamentoTableModel = new AgendamentoTableModel(listaAgendamentos);
		tblListaAgendamentos.setModel(agendamentoTableModel);
	}
	
	
	
	private class AdicionarAgendamento implements ActionListener{

		public void actionPerformed(ActionEvent ev) {
			AgendamentoView agendamentoView = new AgendamentoView();
			agendamentoView.setLocationRelativeTo(null);
			agendamentoView.setVisible(true);
			
		}
		
	}
	
	
	
	private class RemoverAgendamento implements ActionListener{

		public void actionPerformed(ActionEvent ev) {
			int posicaoLinha = tblListaAgendamentos.getSelectedRow();
			int posicaoColuna = 0;
			if(posicaoLinha >= 0){
				String nome  = (String) tblListaAgendamentos.getValueAt(posicaoLinha, posicaoColuna);
				AgendamentoControler agendamentoControler = new AgendamentoControler();
				if( agendamentoControler.removerAgendamento(nome)){
					AgendadorTarefasView.atualizarTabelaAgendamentos();
					JOptionPane.showMessageDialog(null, "Agendamento excluido");
					
				}else{
					JOptionPane.showMessageDialog(null, "Não foi possível excluir o agendamento");
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Selecione um agendamento na lista");
			}
			
		}
		
	}
	
	
	
	private class ExecutarListaAgendamentos implements ActionListener{

		public void actionPerformed(ActionEvent ev) {
			JOptionPane.showMessageDialog(null, "Executar Agendamentos");
			
		}
		
	}
	
	
	
	private class PausarListaAgendamentos implements ActionListener{

		public void actionPerformed(ActionEvent ev) {
			JOptionPane.showMessageDialog(null, "Pausar Agendamentos");
			
		}
		
	}
	
	
	
	public class EditarAgendamento extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2){
				int indexLinhaSelecionada = tblListaAgendamentos.getSelectedRow();
				AgendamentoTableModel model = (AgendamentoTableModel) tblListaAgendamentos.getModel();
				AgendamentoModel agendamento = model.getLinhaAgendamento(indexLinhaSelecionada);
				AgendamentoView agendamentoView = new AgendamentoView(agendamento);
				agendamentoView.setLocationRelativeTo(null);
				agendamentoView.setVisible(true);
			}
			
		}
	}
		
	
}
