package br.com.rcbsystens.promotora.model.entidades.telefones;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.rcbsystens.promotora.model.imutaveis.Situacao;
import br.com.rcbsystens.promotora.model.imutaveis.TipoTelefone;

@Entity
public class Telefones implements Serializable{

	private static final long serialVersionUID = 2958962417449616788L;
	@Id @GeneratedValue
	private long id;
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Situacao situacao;
	@Enumerated(EnumType.STRING)
	@Column(length=15)
	private TipoTelefone tipoTelefone;
	private String ddd;
	private String telefone;

	public Telefones() {
		// TODO Auto-generated constructor stub
		this.setSituacao(Situacao.ATIVO);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result
				+ ((tipoTelefone == null) ? 0 : tipoTelefone.hashCode());
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
		Telefones other = (Telefones) obj;
		if (ddd == null) {
			if (other.ddd != null)
				return false;
		} else if (!ddd.equals(other.ddd))
			return false;
		if (id != other.id)
			return false;
		if (situacao != other.situacao)
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipoTelefone != other.tipoTelefone)
			return false;
		return true;
	}

}
