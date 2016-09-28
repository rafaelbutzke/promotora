package br.com.rcbsystens.promotora.model.imutaveis;

public enum TipoVeiculo {
	
	NOVO("Novo"), 
	USADO("Usado");

	private String tipoVeiculo;

	TipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getTipoTelefone() {
		return tipoVeiculo;
	}

	@Override
	public String toString() {
		return tipoVeiculo;
	}

}
