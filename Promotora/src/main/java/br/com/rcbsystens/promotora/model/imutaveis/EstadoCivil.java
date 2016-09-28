package br.com.rcbsystens.promotora.model.imutaveis;
//Referência para o banco de dados - maximo 15 caracteres
public enum EstadoCivil {
	
	CASADO("Casado"), 
	DIVORSIADO("Divorciado"), 
	SOLTEIRO("Solteiro"), 
	UNIAO_ESTAVEL("União Estável");

	private String estadoCivil;

	private EstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	@Override
	public String toString() {
		return this.estadoCivil;
	}

}
