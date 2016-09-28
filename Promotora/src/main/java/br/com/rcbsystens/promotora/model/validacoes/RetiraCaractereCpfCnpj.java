package br.com.rcbsystens.promotora.model.validacoes;

public class RetiraCaractereCpfCnpj {
	public static String retira(String codigo){
		codigo = codigo.replace(("_"), "");
		codigo = codigo.replace(".", "");
		codigo = codigo.replace("/", "");
		codigo = codigo.replace("-", "");
		return codigo;
	}
	
}
