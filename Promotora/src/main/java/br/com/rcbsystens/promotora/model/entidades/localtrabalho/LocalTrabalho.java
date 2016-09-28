package br.com.rcbsystens.promotora.model.entidades.localtrabalho;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.rcbsystens.promotora.model.entidades.enderecos.Enderecos;
import br.com.rcbsystens.promotora.model.entidades.telefones.Telefones;
import br.com.rcbsystens.promotora.model.imutaveis.ClassificacaoLocalTrabalho;
import br.com.rcbsystens.promotora.model.imutaveis.Situacao;

@Entity
public class LocalTrabalho implements Serializable {
	private static final long serialVersionUID = 1803896131699460385L;
	@Id @GeneratedValue
	private long id;
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Situacao situacao;
	@Enumerated(EnumType.STRING)
	@Column(length=40)
	private ClassificacaoLocalTrabalho classificacaoLocalTrabalho;
	@Column(length=160)
	private String empresa;
	@Column(length=19)
	private String cnpj;
	@Column(length=50)
	private String funcao;
	@Temporal(TemporalType.DATE)
	private Calendar dataAdmissao;
	@OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="lt_telefones", joinColumns=@JoinColumn(name = "id_lt"))
	private Set<Telefones> telefones;
	@OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="lt_enderecos", joinColumns=@JoinColumn(name = "id_lt"))
	private Set<Enderecos> enderecos;
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
	public ClassificacaoLocalTrabalho getClassificacaoLocalTrabalho() {
		return classificacaoLocalTrabalho;
	}
	public void setClassificacaoLocalTrabalho(
			ClassificacaoLocalTrabalho classificacaoLocalTrabalho) {
		this.classificacaoLocalTrabalho = classificacaoLocalTrabalho;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa.toUpperCase();
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao.toUpperCase();
	}
	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public Set<Telefones> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<Telefones> telefones) {
		this.telefones = telefones;
	}
	public Set<Enderecos> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(Set<Enderecos> enderecos) {
		this.enderecos = enderecos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((classificacaoLocalTrabalho == null) ? 0
						: classificacaoLocalTrabalho.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result
				+ ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result
				+ ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result
				+ ((telefones == null) ? 0 : telefones.hashCode());
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
		LocalTrabalho other = (LocalTrabalho) obj;
		if (classificacaoLocalTrabalho != other.classificacaoLocalTrabalho)
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (enderecos == null) {
			if (other.enderecos != null)
				return false;
		} else if (!enderecos.equals(other.enderecos))
			return false;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (id != other.id)
			return false;
		if (situacao != other.situacao)
			return false;
		if (telefones == null) {
			if (other.telefones != null)
				return false;
		} else if (!telefones.equals(other.telefones))
			return false;
		return true;
	}
}