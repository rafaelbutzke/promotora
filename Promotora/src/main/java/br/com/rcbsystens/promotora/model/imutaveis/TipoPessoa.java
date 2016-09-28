package br.com.rcbsystens.promotora.model.imutaveis;

public enum TipoPessoa {
	F("Pessoa Física"), J("Pessoa Jurídica");

	private String tipoPessoa;

	private TipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	@Override
	public String toString() {
		return tipoPessoa;
	}

}
