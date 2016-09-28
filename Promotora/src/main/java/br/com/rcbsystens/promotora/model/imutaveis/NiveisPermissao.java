package br.com.rcbsystens.promotora.model.imutaveis;

public enum NiveisPermissao {
	NIVEL00("Parceiro"),
	NIVEL01("Operador"),
	NIVEL02("Administrativo"),
	NIVEL03("Formalizacao"),
	NIVEL04("Financeiro"),
	NIVEL05("Super");
	
	private String nivelPermissao;
	
	private NiveisPermissao(String nivelPermissao){
		this.nivelPermissao = nivelPermissao;
	}

	public String getTipoUsuario() {
		return nivelPermissao;
	}
	@Override
	public String toString() {
		return this.nivelPermissao;
	}

}
