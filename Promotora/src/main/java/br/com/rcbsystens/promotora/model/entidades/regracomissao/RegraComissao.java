package br.com.rcbsystens.promotora.model.entidades.regracomissao;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.rcbsystens.promotora.model.imutaveis.TipoDeContrato;

public class RegraComissao {
	@Id @GeneratedValue
	private long id;
	private TipoDeContrato tipoDeContrato; 
	
}
