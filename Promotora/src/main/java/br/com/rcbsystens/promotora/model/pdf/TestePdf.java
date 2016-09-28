package br.com.rcbsystens.promotora.model.pdf;

import java.math.BigDecimal;

import br.com.rcbsystens.promotora.model.propostaweb.PropostaWeb;

public class TestePdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropostaWeb proposta = new PropostaWeb();
		PropostaWebEmPdf pdf = new PropostaWebEmPdf();
		BigDecimal financiado = new BigDecimal("0");
		proposta.setFabricante("FIAT");
		proposta.setModeloVeiculo("GRAND SIENA ATRATTIVE 1.4");
		proposta.setAno("2014");
		proposta.setModelo("2015");
		proposta.setValorCompra(new BigDecimal("15000.01"));
		proposta.setValorEntrada(new BigDecimal("5000.00"));
		financiado = proposta.getValorCompra().subtract(proposta.getValorEntrada());
		System.out.println(financiado);
		proposta.setValorFinanciado(financiado);
		System.out.println(proposta.getValorFinanciado());
		pdf.preencher("rafael", proposta);
	}
}
