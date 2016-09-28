package br.com.rcbsystens.promotora.model.entidades.instituicao;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.rcbsystens.promotora.model.entidades.bancos.Bancos;
//@Entity
public class Instituicao {
	@Id @GeneratedValue
	private long id;
	@Column(unique=true)
	private String codigoCorrespondente;
	private Bancos banco;
 
	
	
}
