package br.com.rcbsystens.promotora.model.entidades.tabelas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestaTabelasConsulta {
	public static void main(String[] args) {
		TabelasDao tabelasDao = new TabelasDao();
		List<Tabelas> tab = new ArrayList<Tabelas>();
		tab = tabelasDao.consultaTodasAsTabelas();
		System.out.println(tab.size());
		
		for (int t = 0; t < tab.size(); t++) {
			System.out.println(" ");
			System.out.println("Codigo: "+tab.get(t).getCodigo() + " Prazos: " + tab.get(t).getPrazos().size() + " De: " + tab.get(t).getModeloInicial()+ " a " + tab.get(t).getModeloFinal() );
			
			for (int i = 0; i < tab.get(t).getPrazos().size(); i++) {
				System.out.println("Prazo " + tab.get(t).getPrazos().get(i).getPrazo()
						.toString() + " Entrada: " + tab.get(t).getPrazos().get(i)
						.getPercentualEntrada()
						.multiply(new BigDecimal("100")));
				StringBuffer coeficientes = new StringBuffer();
				for (int j = 0; j < tab.get(t).getPrazos().get(i).getPlanos().size(); j++) {
					if (tab.get(t).getPrazos().get(i).getPlanos().get(j).getRetorno() != null) {
						coeficientes.append(tab.get(t).getPrazos().get(i).getPlanos().get(j).getRetorno().toString());
						coeficientes.append(" - ");
						coeficientes.append(tab.get(t).getPrazos().get(i).getPlanos().get(j)
								.getCoeficiente().toString());
						coeficientes.append(" ");
					}
				}
				System.out.println(coeficientes);
			}

		}
		
	}
	
}
