package br.com.rcbsystens.promotora.model.imutaveis;
//Referência para o banco de dados - maximo 25 caracteres 
public enum VinculoReferencia {
	PAIS("Pais"), 
	IRMAOS("Irmãos"), 
	PARENTES("Parentes de segundo grau"), 
	AMIGOS("Amigos");
	
	private String vinculoReferencia;

	private VinculoReferencia(String vinculoReferencia) {
		this.vinculoReferencia = vinculoReferencia;
	}

	public String getVinculoReferencia() {
		return vinculoReferencia;
	}

	@Override
	public String toString() {
		return vinculoReferencia;
	}
}
