package br.com.rcbsystens.promotora.model.entidades.usuario;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

import br.com.rcbsystens.promotora.model.entidades.loja.Loja;
import br.com.rcbsystens.promotora.model.entidades.pessoa.PessoaFisica;
import br.com.rcbsystens.promotora.model.entidades.regiao.Regiao;
import br.com.rcbsystens.promotora.model.imutaveis.NiveisPermissao;
import br.com.rcbsystens.promotora.model.imutaveis.TipoUsuario;

@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1471996696271548222L;
	@Id
	@GeneratedValue
	private Long id;
	private boolean ativo;
	@Column (unique=true)
	@NaturalId
	private String login;
	private String apelido;
	private String senha;
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario; 
	private PessoaFisica pessoa;
	@Enumerated(EnumType.STRING)
	private NiveisPermissao nivelPermissao;
	private String servidorTelefone; 
	private String ramal; 
	private Regiao regiao;
	@ElementCollection(targetClass = Loja.class)
	@JoinTable(
			name = "usuario_lojas",
			uniqueConstraints = {@UniqueConstraint(columnNames={"usuario","lojas"})},
			joinColumns=@JoinColumn(name="usuario")
	)
	private Set<Loja> lojas;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login.toUpperCase();
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido.toUpperCase();
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public PessoaFisica getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}
	public NiveisPermissao getNivelPermissao() {
		return nivelPermissao;
	}
	public void setNivelPermissao(NiveisPermissao nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}
	public String getServidorTelefone() {
		return servidorTelefone;
	}
	public void setServidorTelefone(String servidorTelefone) {
		this.servidorTelefone = servidorTelefone.toUpperCase();
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal.toUpperCase();
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	public Set<Loja> getLojas() {
		return lojas;
	}
	public void setLojas(Set<Loja> lojas) {
		this.lojas = lojas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((lojas == null) ? 0 : lojas.hashCode());
		result = prime * result
				+ ((nivelPermissao == null) ? 0 : nivelPermissao.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((ramal == null) ? 0 : ramal.hashCode());
		result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime
				* result
				+ ((servidorTelefone == null) ? 0 : servidorTelefone.hashCode());
		result = prime * result
				+ ((tipoUsuario == null) ? 0 : tipoUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (ativo != other.ativo)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (lojas == null) {
			if (other.lojas != null)
				return false;
		} else if (!lojas.equals(other.lojas))
			return false;
		if (nivelPermissao != other.nivelPermissao)
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (ramal == null) {
			if (other.ramal != null)
				return false;
		} else if (!ramal.equals(other.ramal))
			return false;
		if (regiao == null) {
			if (other.regiao != null)
				return false;
		} else if (!regiao.equals(other.regiao))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (servidorTelefone == null) {
			if (other.servidorTelefone != null)
				return false;
		} else if (!servidorTelefone.equals(other.servidorTelefone))
			return false;
		if (tipoUsuario != other.tipoUsuario)
			return false;
		return true;
	}
}