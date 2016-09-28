package br.com.rcbsystens.promotora.model.imutaveis;


public enum TipoDeContrato {
	VEICULOS("Contrato veículos"),
	CONSIGNADO("Contrato consignado"),
	CONSORCIO("Contrato consórcio"),
	REFINVEICULOS("Refin veículos");
	
	private String tipoDeContrato;
	
	TipoDeContrato(String tipoDeContrato){
		this.tipoDeContrato = tipoDeContrato;
	}
	
	public String getTipoDeContrato(){
		return tipoDeContrato;
	}
	
	@Override
	public String toString() {
		return tipoDeContrato;
	}

}
