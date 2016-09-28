package br.com.rcbsystens.promotora.model.entidades.tabelas.prazo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.rcbsystens.promotora.model.entidades.tabelas.prazo.planos.Planos;
import br.com.rcbsystens.promotora.model.imutaveis.Prazos;

@Entity
public class Prazo implements Serializable {
	
	private static final long serialVersionUID = -9146306453214182141L;

	@Id @GeneratedValue
	private long id; 
	@Enumerated(EnumType.STRING)
	private Prazos prazo; 
	private BigDecimal percentualEntrada; 
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="prazo_id")
	private List<Planos> planos = new ArrayList<Planos>();
	
	//Construtor público sem parametos para implementação JPA; 
	public Prazo(){}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Prazos getPrazo() {
		return prazo;
	}
	public void setPrazo(Prazos prazo) {
		this.prazo = prazo;
	}
	public BigDecimal getPercentualEntrada() {
		return percentualEntrada;
	}
	public void setPercentualEntrada(BigDecimal percentualEntrada) {
		this.percentualEntrada = percentualEntrada;
	}
	public List<Planos> getPlanos() {
		return planos;
	}
	public void setPlanos(List<Planos> planos) {
		this.planos = planos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime
				* result
				+ ((percentualEntrada == null) ? 0 : percentualEntrada
						.hashCode());
		result = prime * result + ((planos == null) ? 0 : planos.hashCode());
		result = prime * result + ((prazo == null) ? 0 : prazo.hashCode());
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
		Prazo other = (Prazo) obj;
		if (id != other.id)
			return false;
		if (percentualEntrada == null) {
			if (other.percentualEntrada != null)
				return false;
		} else if (!percentualEntrada.equals(other.percentualEntrada))
			return false;
		if (planos == null) {
			if (other.planos != null)
				return false;
		} else if (!planos.equals(other.planos))
			return false;
		if (prazo != other.prazo)
			return false;
		return true;
	}
}
