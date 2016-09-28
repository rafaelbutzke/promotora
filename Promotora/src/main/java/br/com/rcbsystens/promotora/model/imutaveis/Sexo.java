package br.com.rcbsystens.promotora.model.imutaveis;

public enum Sexo {
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String sexo;
	
	private Sexo(String sexo){
		this.sexo = sexo;
	}

	public String getSexo(){
		return sexo;
	}
	
	@Override
	public String toString(){
		return sexo; 
	}
}
