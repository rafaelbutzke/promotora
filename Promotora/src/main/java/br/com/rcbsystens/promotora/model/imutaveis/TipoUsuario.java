package br.com.rcbsystens.promotora.model.imutaveis;

public enum TipoUsuario {
	EXTERNO("Externo"), 
	INTERNO("Interno"),
	VENDEDOR("Vendedor");
	
	private String tipoUsuario;
	
	private TipoUsuario(String tipoUsuario){
		this.tipoUsuario = tipoUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}
	@Override
	public String toString() {
		return this.tipoUsuario;
	}
}
