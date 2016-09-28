package br.com.rcbsystens.promotora.model.autoexecucao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import br.com.rcbsystens.promotora.model.entidades.tabelas.Tabelas;
import br.com.rcbsystens.promotora.model.entidades.tabelas.TabelasDao;

public class AutoExecucao {
	Timer tempo;

	public AutoExecucao(int segundos) {
		tempo = new Timer();
		tempo.schedule(new Execucao(), 0, segundos * 1000);
	}

	public class Execucao extends TimerTask {
		@Override
		public void run() {
			// Aqui vc deve colocar toda a execução....
			System.out.println("Executado class AutoExecucao 'package br.com.rcbsystens.promotora.model.autoexecucao' em: " + new Date());
			//Criar função para envio e 
			TabelasDao buscaTabaelas = new TabelasDao();
			List<Tabelas> tabelas = new ArrayList<Tabelas>();
			if (buscaTabaelas.consultaTabelaPorAno(2010) != null){
			tabelas = buscaTabaelas.consultaTabelaPorAno(2010);
				System.out.println("Tabela: " + tabelas.get(0).getCodigo() + " Ano: " + tabelas.get(0).getModeloInicial() + " / " + tabelas.get(0).getModeloFinal());
			}
		}
	}
}
