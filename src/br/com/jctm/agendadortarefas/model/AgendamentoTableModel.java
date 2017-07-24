package br.com.jctm.agendadortarefas.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class AgendamentoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private String[] colunas;
	private ArrayList<AgendamentoModel> listaAgendamentos;
	

	
	public AgendamentoTableModel(ArrayList<AgendamentoModel> listaAgendamentos){
		this.colunas = new String[]{"Nome", "Descrição", "Tipo de Tarefa", "Cron"};
		this.listaAgendamentos = listaAgendamentos;
	}
	
	
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	
	
	@Override
	public int getRowCount() {
		return listaAgendamentos.size();
	}

	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
        case 0: return listaAgendamentos.get(rowIndex).getNome();
        case 1: return listaAgendamentos.get(rowIndex).getDescricao();		
        case 2: return listaAgendamentos.get(rowIndex).getTipoTarefa();
        case 3: return listaAgendamentos.get(rowIndex).getCron();
		}
		return null;
	}



	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	
	
	public AgendamentoModel getLinhaAgendamento(int rowIndex){
		return listaAgendamentos.get(rowIndex);
		
	}
		
		
}
