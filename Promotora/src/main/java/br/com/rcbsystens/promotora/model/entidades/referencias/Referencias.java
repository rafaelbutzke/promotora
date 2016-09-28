package br.com.rcbsystens.promotora.model.entidades.referencias;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.rcbsystens.promotora.model.entidades.telefones.Telefones;
import br.com.rcbsystens.promotora.model.imutaveis.VinculoReferencia;

@Entity
public class Referencias implements Serializable {
	private static final long serialVersionUID = 3754460190906323282L;
	@Id @GeneratedValue
	private long id;
	private String nomeReferencia;
	private VinculoReferencia vinculoReferencia;
	private Telefones telefone;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeReferencia() {
		return nomeReferencia;
	}
	public void setNomeReferencia(String nomeReferencia) {
		this.nomeReferencia = nomeReferencia.toUpperCase();
	}
	public VinculoReferencia getVinculoReferencia() {
		return vinculoReferencia;
	}
	public void setVinculoReferencia(VinculoReferencia vinculoReferencia) {
		this.vinculoReferencia = vinculoReferencia;
	}
	public Telefones getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefones telefone) {
		this.telefone = telefone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((nomeReferencia == null) ? 0 : nomeReferencia.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		result = prime
				* result
				+ ((vinculoReferencia == null) ? 0 : vinculoReferencia
						.hashCode());
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
		Referencias other = (Referencias) obj;
		if (id != other.id)
			return false;
		if (nomeReferencia == null) {
			if (other.nomeReferencia != null)
				return false;
		} else if (!nomeReferencia.equals(other.nomeReferencia))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (vinculoReferencia != other.vinculoReferencia)
			return false;
		return true;
	}
}