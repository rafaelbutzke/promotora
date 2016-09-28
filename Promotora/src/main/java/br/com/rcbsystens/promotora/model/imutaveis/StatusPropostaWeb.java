package br.com.rcbsystens.promotora.model.imutaveis;

public enum StatusPropostaWeb {
	ANALISE("Analise"),
	APROVADO("Aprovado"),
	DIGITADO("Digitado"),
	PAGO("Pago"),
	PENDENTE("Pendente"),
	REPROVADO("Reprovado");
	
	private String statusPropostaWeb;
	
	private StatusPropostaWeb(String statusPropostaWeb) {
		// TODO Auto-generated constructor stub
		this.statusPropostaWeb = statusPropostaWeb;
	}
	
	public String getStatusPropostaWeb(){
		return this.statusPropostaWeb;
	}
	
	@Override
	public String toString() {
		return statusPropostaWeb;
	}
}
