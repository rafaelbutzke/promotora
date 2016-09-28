package br.com.rcbsystens.promotora.model.imutaveis;

//Referência para o banco de dados - maximo 15 caracteres
public enum TipoEnderecos {
	RESIDENCIAL("Residencial"), 
	TRABALHO("Trabalho"), 
	OUTRASRENDAS("Outras Rendas");
	
	private String tipoEndereco;

	TipoEnderecos(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	@Override
	public String toString() {
		return tipoEndereco;
	}

}
