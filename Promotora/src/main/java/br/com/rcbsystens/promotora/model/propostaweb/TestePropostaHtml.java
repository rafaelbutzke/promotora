package br.com.rcbsystens.promotora.model.propostaweb;

import br.com.rcbsystens.promotora.model.email.Email;

public class TestePropostaHtml {
	public static void main(String[] args) {
		PropostaParaEmailHtml pp = new PropostaParaEmailHtml();
		Email email = new Email();
		PropostaWeb proposta = new PropostaWeb();
		proposta.setFabricante("Fiat");
		email.enviarEmail("real.df@bbpromotora.com.br", "Teste html", pp.PropostaEmHtml(proposta));
	}
}
