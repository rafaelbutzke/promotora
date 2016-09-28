package br.com.rcbsystens.promotora.model.imutaveis;
//Referência para o banco de dados - maximo 15 caracteres
public enum TipoTelefone {
	RESIDENCIAL("Residencial"), 
	CELULAR("Celular"), 
	COMERCIAL("Comercial"), 
	REFERENCIA("Referencia"), 
	OUTRAS_RENDAS("Outras Rendas");

	private String tipoTelefone;

	TipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	@Override
	public String toString() {
		return tipoTelefone;
	}

}
