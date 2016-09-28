package br.com.rcbsystens.promotora.model.entidades.socios;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import br.com.rcbsystens.promotora.model.entidades.pessoa.Pessoa;
import br.com.rcbsystens.promotora.model.imutaveis.TipoPessoa;

@Entity
public class Socios implements Serializable {
	private static final long serialVersionUID = 5418427181561313234L;
	@Id
	@GeneratedValue
	private long id;
	
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	private Pessoa pessoa;
	private BigDecimal percentualParticipacao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public BigDecimal getPercentualParticipacao() {
		return percentualParticipacao;
	}
	public void setPercentualParticipacao(BigDecimal percentualParticipacao) {
		this.percentualParticipacao = percentualParticipacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime
				* result
				+ ((percentualParticipacao == null) ? 0
						: percentualParticipacao.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result
				+ ((tipoPessoa == null) ? 0 : tipoPessoa.hashCode());
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
		Socios other = (Socios) obj;
		if (id != other.id)
			return false;
		if (percentualParticipacao == null) {
			if (other.percentualParticipacao != null)
				return false;
		} else if (!percentualParticipacao.equals(other.percentualParticipacao))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (tipoPessoa != other.tipoPessoa)
			return false;
		return true;
	}
	
}
