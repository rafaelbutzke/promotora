package br.com.rcbsystens.promotora.model.entidades.veiculo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.rcbsystens.promotora.model.imutaveis.TipoChassi;
@Entity
public class Veiculo {
	@Id @GeneratedValue
	private long id; 
	private String codigoFipe; 
	private String modeloDetran; 
	private String anoFabricacao;
	private String anoModelo; 
	private String placa; 
	private String renavam;
	@Enumerated(EnumType.STRING)
	private TipoChassi tipoChassi;
	private String chassi; 
	
}
