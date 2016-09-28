package br.com.rcbsystens.promotora.model.imutaveis;

public enum Nacionalidade {
	
	BRASILEIRO("Brasileiro"), 
	ESTRANGEIRO("Estrangeiro");
	
	private String nacionalidade;

	private Nacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	@Override
	public String toString() {
		return nacionalidade;
	}


}
