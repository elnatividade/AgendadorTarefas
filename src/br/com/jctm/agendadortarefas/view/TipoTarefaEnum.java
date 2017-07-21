package br.com.jctm.agendadortarefas.view;

public enum TipoTarefaEnum {
	
	FTP(0,"Transmissão FTP"),
	ORGANIZAR(1, "Organizador de Arquivos");
		
	private int opcao;
	private String descricao;
	
	
	
	private TipoTarefaEnum(int opcao, String descricao){
		this.opcao = opcao;
		this.descricao = descricao;
	}
	
	
	
	public int getOpcao(){
		return this.opcao;
	}
	
	
	
	public String getDescricao(){
		return this.descricao;
	}
	
	
	
	public String toString(){
		return this.descricao;
	}

}
