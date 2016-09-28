package br.com.rcbsystens.promotora.model.imutaveis;
//Referência para o banco de dados - maximo 35 caracteres
public enum ClassificacaoLocalTrabalho {
	AUTONOMO("Autônomo"),
	SOCIO("Sócio Proprietário"),
	EMPRESA_PRIVADA("Funcionário empresa privada"), 
	PUBLICO_MUNICIPAL("Funcionário público municipal"),
	PUBLICO_ESTADUAL("Funcionário público estadual"),
	PUBLICO_FEDERAL("Funcionário público federal"), 
	CONTRATO_TRABALHO("Contrato de trabalho temporário"), 
	PROFISSIONAL_LIBERAL("Profissional liberal");

	private String classificacaoLocalTrabalho;

	private ClassificacaoLocalTrabalho(String classificacaoLocalTrabalho) {
		this.classificacaoLocalTrabalho = classificacaoLocalTrabalho;
	}

	public String getClassificacaoLocalTrabalho() {
		return this.classificacaoLocalTrabalho;
	}

	@Override
	public String toString() {
		return this.classificacaoLocalTrabalho;
	}

}
