package br.com.rcbsystens.promotora.model.entidades.pessoa;

import java.io.Serializable;

import javax.persistence.*;

import br.com.rcbsystens.promotora.model.entidades.usuario.Usuario;
import br.com.rcbsystens.promotora.model.imutaveis.TipoPessoa;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable{
	private static final long serialVersionUID = -8570503901548764773L;

	@Id @GeneratedValue
	private Long idPessoa;
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id",nullable=false)
	private Usuario usuario;

	public Long getIdPessoa() {
		return idPessoa;
	}
	

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPessoa ^ (idPessoa >>> 32));
		result = prime * result + ((tipoPessoa == null) ? 0 : tipoPessoa.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (idPessoa != other.idPessoa)
			return false;
		if (tipoPessoa != other.tipoPessoa)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}	
