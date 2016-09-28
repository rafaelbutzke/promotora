package br.com.rcbsystens.promotora.model.entidades.referenciabancaria;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.rcbsystens.promotora.model.entidades.bancos.Bancos;

@Entity
public class ReferenciaBancaria implements Serializable {
	private static final long serialVersionUID = -1666088900030227438L;
	@Id @GeneratedValue
	private long id;
	private Bancos bancos;
	@Column(length=6)
	private String agencia;
	@Column(length=20)
	private String conta;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Bancos getBancos() {
		return bancos;
	}
	public void setBancos(Bancos bancos) {
		this.bancos = bancos;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia.toUpperCase();
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta.toUpperCase();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((bancos == null) ? 0 : bancos.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		ReferenciaBancaria other = (ReferenciaBancaria) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (bancos == null) {
			if (other.bancos != null)
				return false;
		} else if (!bancos.equals(other.bancos))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
