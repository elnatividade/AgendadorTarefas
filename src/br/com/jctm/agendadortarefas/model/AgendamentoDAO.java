package br.com.jctm.agendadortarefas.model;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class AgendamentoDAO {
	
	private final String PROP_NOME = "TAREFA.NOME"; 	
	private final String PROP_GRUPO = "TAREFA.GRUPO"; 	
	private final String PROP_DESCRICAO = "TAREFA.DESCRICAO"; 	
	private final String PROP_CRON = "TAREFA.CRON"; 	
	private final String PROP_TIPOTAREFA = "TAREFA.TIPO_TAREFA"; 	

	public boolean salvarAgendamento(AgendamentoModel agendamento) {
		Boolean ok = false;
		String nome = agendamento.getNome();
		String grupo = agendamento.getGrupo();
		String descricao = agendamento.getDescricao();
		String cron = agendamento.getCron();
		String tipoTarefa = agendamento.getTipoTarefa();
				
		Properties propriedades = new Properties();
		propriedades.setProperty(PROP_NOME, nome);
		propriedades.setProperty(PROP_GRUPO, grupo);
		propriedades.setProperty(PROP_DESCRICAO, descricao);
		propriedades.setProperty(PROP_CRON, cron);
		propriedades.setProperty(PROP_TIPOTAREFA, tipoTarefa);
		
		String caminho = new StringBuilder().append("./tarefas/").append(nome).append(".properties").toString();
		File arquivo = new File(caminho);
		
		if(arquivo.isFile()&& arquivo.exists())arquivo.delete();
			
		FileOutputStream arquivoSaida = null;
		
		try {
			arquivoSaida = new FileOutputStream(arquivo);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		
		try {
			propriedades.store(arquivoSaida, "");
			ok = true;
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally{
			if (arquivoSaida != null){
				try {
					arquivoSaida.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ok;
		
	}

	
	
	public ArrayList<AgendamentoModel> listarTodosAgendamentos() {
		ArrayList<AgendamentoModel> listaAgendamentos = new ArrayList<AgendamentoModel>();
		FileInputStream fis = null;
		File diretorio = new File("./tarefas/");
		File[] arquivos = diretorio.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return (pathname.getName().endsWith(".properties")) ? true : false;
			}
		});
		
		for (File arquivo : arquivos) {
			Properties propriedades = new Properties();
			try {
				fis = new FileInputStream(arquivo);
				propriedades.load(fis);
				String nome = propriedades.getProperty(PROP_NOME);
				String grupo = propriedades.getProperty(PROP_GRUPO);
				String descricao = propriedades.getProperty(PROP_DESCRICAO);
				String cron = propriedades.getProperty(PROP_CRON);
				String tipoTarefa = propriedades.getProperty(PROP_TIPOTAREFA);
				AgendamentoModel agendamento = new AgendamentoModel(nome, grupo, descricao, cron, tipoTarefa);
				listaAgendamentos.add(agendamento);
								
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
				
			}finally{
				if(fis != null){
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		return listaAgendamentos;
	}



	public boolean excluirAgendamento(String nome) {
		File arquivo = new File("./tarefas/" + nome  + ".properties");
		return arquivo.delete();
		
	}
	
	
	
}
