package br.com.rcbsystens.promotora.model.imutaveis;

public enum Prazos {
	DOZE("12"),
	VINTEQUATRO("24"),
	TRINTASEIS("36"),
	QUARENTAOITO("48"),
	SESSENTA("60");
	
	private String prazos;
	
	private Prazos (String prazos){
		this.prazos = prazos; 
	}
	
	public String getPrazos(){
		return this.prazos;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.prazos;
	}
}
