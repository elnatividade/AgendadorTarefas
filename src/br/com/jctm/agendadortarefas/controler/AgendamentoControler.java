package br.com.jctm.agendadortarefas.controler;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import br.com.jctm.agendadortarefas.model.AgendamentoDAO;
import br.com.jctm.agendadortarefas.model.AgendamentoModel;



public class AgendamentoControler {
	
	private AgendamentoDAO dao;
	
	
	
	public AgendamentoControler(){
		this.dao = new AgendamentoDAO();
	}

	
	
	public void adicionarAgendamento(HashMap<String, String> dadosTela) {
		
		String nome = dadosTela.get("nome");
		String grupo = dadosTela.get("grupo");
		String descricao = dadosTela.get("descricao");
		String cron = dadosTela.get("cron");
		String tipoTarefa = dadosTela.get("tipoTarefa");
		
		AgendamentoModel agendamento = new AgendamentoModel(nome, grupo, descricao, cron, tipoTarefa);
					
		if(dao.salvarAgendamento(agendamento)){
			JOptionPane.showMessageDialog(null, "Agendamento Salvo");
		};
		
	}

	
	
	public ArrayList<AgendamentoModel> listarTodosAgendamentos() {
		return dao.listarTodosAgendamentos();
		
		
	}



	public boolean removerAgendamento(String nome) {
		return dao.excluirAgendamento(nome);
			
	}
		
	
	
}
