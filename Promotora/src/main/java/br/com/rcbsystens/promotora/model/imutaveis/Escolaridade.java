package br.com.rcbsystens.promotora.model.imutaveis;

public enum Escolaridade {
	
	PRIMEIRO("Primeiro Grau"),
	SEGUNDO("Segundo Grau"),
	SUPERIORC("Superior Completo"),
	SUPERIORI("Superior Incompleto"),
	POS("Pós Graduado");
	
	private String escolaridade;
	
	private Escolaridade(String escolaridade){
		this.escolaridade = escolaridade;
	}
	
	public String getEscolaridade(){
		return this.escolaridade;
	}
	
	@Override
	public String toString(){
		return this.escolaridade;
	}
}
