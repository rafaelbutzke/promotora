package br.com.rcbsystens.promotora.model.imutaveis;

public enum TipoResidencia {
	PROPRIA("Própria"),
	ALUGADA("Alugada"),
	FUNCIONAL("Funcional"),
	DEFAMILIARES("De familiares");
	
	private String tipoResidencia;
	
	private TipoResidencia(String tipoResidencia){
		this.tipoResidencia = tipoResidencia;
	}
	
	public String getTipoResidencia(){
		return tipoResidencia;
	}
	
	@Override
	public String toString(){
		return tipoResidencia; 
	}
}
