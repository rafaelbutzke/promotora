package br.com.rcbsystens.promotora.model.imutaveis;

//Referência para o banco de dados - maximo 10 caracteres
public enum Situacao {
	ATIVO("Ativo"), 
	INATIVO("Inativo");
	
	private String situacao;

	Situacao(String situacao) {
		this.situacao = situacao;
	}

	public String getSituacao() {
		return situacao;
	}

	@Override
	public String toString() {
		return situacao;
	}

}
