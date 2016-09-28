package br.com.rcbsystens.promotora.model.entidades.regiao;


import java.io.Serializable;

import javax.persistence.*;

@NamedQueries({
	@NamedQuery(name="Regiao.BuscaPorId", query="SELECT t FROM Regiao t WHERE t.id = :id"),
	@NamedQuery(name="Regiao.ListaCompleta",query="SELECT t FROM Regiao t")
})

@Entity
public class Regiao implements Serializable {
	private static final long serialVersionUID = -1290311469304675406L;

	@Id @GeneratedValue
	private Long id;
	@Column(unique=true)
	private String descricao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Regiao other = (Regiao) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}