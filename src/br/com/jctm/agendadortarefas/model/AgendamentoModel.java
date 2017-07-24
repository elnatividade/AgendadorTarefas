package br.com.jctm.agendadortarefas.model;



public class AgendamentoModel {

	private String nome;
	private String grupo;
	private String descricao;
	private String cron;
	private String tipoTarefa;


	
	public AgendamentoModel() {
		super();
	}
	
	
	
	public AgendamentoModel(String nome, String grupo, String descricao,
			String cron, String tipoTarefa) {
		super();
		this.nome = nome;
		this.grupo = grupo;
		this.descricao = descricao;
		this.cron = cron;
		this.tipoTarefa = tipoTarefa;
	}



	public String getNome() {
		return nome;
	}



	public String getGrupo() {
		return grupo;
	}



	public String getDescricao() {
		return descricao;
	}



	public String getCron() {
		return cron;
	}



	public String getTipoTarefa() {
		return tipoTarefa;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public void setCron(String cron) {
		this.cron = cron;
	}



	public void setTipoTarefa(String tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}
	
	
		
}
