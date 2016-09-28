package br.com.rcbsystens.promotora.model.imutaveis;

public enum Retorno {
	
	RZERO("R0"), 
	RUM("R1"),
	RDOIS("R2"),
	RTRES("R3");
	

	private Retorno(String retorno) {
		this.retorno = retorno;
	}
	
	private String retorno;

	public String getRetorno() {
		return retorno;
	}

	@Override
	public String toString() {
		return retorno;
	}


}
