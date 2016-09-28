package br.com.rcbsystens.promotora.model.imutaveis;
//Referência para o banco de dados - maximo 10 caracteres
public enum TipoChassi {
	NORMAL("Normal"), 
	REMARCADO("Remarcado");
	
	private String tipoChassi;

	TipoChassi(String tipoChassi) {
		this.tipoChassi = tipoChassi;
	}

	public String getTipoChassi() {
		return tipoChassi;
	}

	@Override
	public String toString() {
		return tipoChassi;
	}

}
