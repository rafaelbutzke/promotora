package br.com.rcbsystens.promotora.model.entidades.tabelas.prazo.planos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.rcbsystens.promotora.model.imutaveis.Retorno;

@Entity
public class Planos implements Serializable{
	private static final long serialVersionUID = -2218313976516305916L;
	@Id @GeneratedValue
	private long id;
	@Enumerated(EnumType.STRING)
	private Retorno retorno; 
	@Column(precision = 8,scale = 8)
	private BigDecimal coeficiente;
	
	//Construtor público sem parametos para implementação JPA; 
	public Planos(){}
	
	public Retorno getRetorno() {
		return retorno;
	}
	public void setRetorno(Retorno retorno) {
		this.retorno = retorno;
	}
	public BigDecimal getCoeficiente() {
		return coeficiente;
	}
	public void setCoeficiente(BigDecimal coeficiente) {
		this.coeficiente = coeficiente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coeficiente == null) ? 0 : coeficiente.hashCode());
		result = prime * result + ((retorno == null) ? 0 : retorno.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planos other = (Planos) obj;
		if (coeficiente == null) {
			if (other.coeficiente != null)
				return false;
		} else if (!coeficiente.equals(other.coeficiente))
			return false;
		if (retorno != other.retorno)
			return false;
		return true;
	}
	
}
