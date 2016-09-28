package br.com.rcbsystens.promotora.model.entidades.loja;

import java.io.Serializable;

import javax.persistence.*;

import br.com.rcbsystens.promotora.model.entidades.pessoa.PessoaJuridica;
import br.com.rcbsystens.promotora.model.entidades.regiao.Regiao;
@NamedQueries({
	@NamedQuery(name="Loja.PesquisaPorId", query="SELECT l FROM Loja l where l.id = :id"),
	@NamedQuery(name="Loja.ListaCompletaPorRegiao", query="SELECT l FROM Loja l ORDER BY l.regiao, l.codigoLoja"),
	@NamedQuery(name="Loja.ListaPorRegiao", query="SELECT l FROM Loja l JOIN FETCH l.regiao r WHERE r.id = :idRegiao")
	})

@Entity
public class Loja implements Serializable{

	private static final long serialVersionUID = 46583499503880718L;
	
	@Id @GeneratedValue
	private Long id; 
	@Column(unique=true)
	private String codigoLoja;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="regiao")
	private Regiao regiao;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pessoaJuridica", unique=true)
	private PessoaJuridica pesssoaJuridica;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigoLoja() {
		return codigoLoja;
	}
	public void setCodigoLoja(String codigoLoja) {
		this.codigoLoja = codigoLoja.toUpperCase();
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	public PessoaJuridica getPesssoaJuridica() {
		return pesssoaJuridica;
	}
	public void setPesssoaJuridica(PessoaJuridica pesssoaJuridica) {
		this.pesssoaJuridica = pesssoaJuridica;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoLoja == null) ? 0 : codigoLoja.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((pesssoaJuridica == null) ? 0 : pesssoaJuridica.hashCode());
		result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
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
		Loja other = (Loja) obj;
		if (codigoLoja == null) {
			if (other.codigoLoja != null)
				return false;
		} else if (!codigoLoja.equals(other.codigoLoja))
			return false;
		if (id != other.id)
			return false;
		if (pesssoaJuridica == null) {
			if (other.pesssoaJuridica != null)
				return false;
		} else if (!pesssoaJuridica.equals(other.pesssoaJuridica))
			return false;
		if (regiao == null) {
			if (other.regiao != null)
				return false;
		} else if (!regiao.equals(other.regiao))
			return false;
		return true;
	}
}