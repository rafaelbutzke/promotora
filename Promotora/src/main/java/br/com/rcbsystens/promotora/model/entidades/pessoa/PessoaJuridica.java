package br.com.rcbsystens.promotora.model.entidades.pessoa;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.rcbsystens.promotora.model.entidades.emails.Emails;
import br.com.rcbsystens.promotora.model.entidades.enderecos.Enderecos;
import br.com.rcbsystens.promotora.model.entidades.referenciabancaria.ReferenciaBancaria;
import br.com.rcbsystens.promotora.model.entidades.referencias.Referencias;
import br.com.rcbsystens.promotora.model.entidades.socios.Socios;
import br.com.rcbsystens.promotora.model.entidades.telefones.Telefones;
@NamedQueries({
	@NamedQuery(name="PessoaJuridica.buscaPorCnpj", query="SELECT t FROM PessoaJuridica t WHERE t.cnpj = :cnpj")
	})
@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class PessoaJuridica extends Pessoa implements Serializable {
	private static final long serialVersionUID = -1015529164497013542L;
	@Column(unique = true, length=19)
	private String cnpj;
	@Column(length=200)
	private String razaoSocial;
	@Column(length=200)
	private String nomeFantasia;
	@Temporal(TemporalType.DATE)
	private Date fundacao;
	@Column(length=20)
	private String inscricaoEstadual;
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pj_enderecos", joinColumns=@JoinColumn(name = "id_pj"))
	private Set<Enderecos> enderecos;
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pj_telefones", joinColumns=@JoinColumn(name = "id_pj"))
	private Set<Telefones> telefones;
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pj_referencias", joinColumns=@JoinColumn(name = "id_pj"))
	private Set<Referencias> referencias;
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pj_ref_bancaria", joinColumns=@JoinColumn(name = "id_pj"))
	private Set<ReferenciaBancaria> referenciaBancarias;
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pj_emails", joinColumns=@JoinColumn(name = "id_pj"))
	private Set<Emails> emails;
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pj_socios", joinColumns=@JoinColumn(name = "id_pj"))
	private Set<Socios> socios;
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial.toUpperCase();
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia.toUpperCase();
	}
	public Date getFundacao() {
		return fundacao;
	}
	public void setFundacao(Date fundacao) {
		this.fundacao = fundacao;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual.toUpperCase();
	}
	public Set<Enderecos> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(Set<Enderecos> enderecos) {
		this.enderecos = enderecos;
	}
	public Set<Telefones> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<Telefones> telefones) {
		this.telefones = telefones;
	}
	public Set<Referencias> getReferencias() {
		return referencias;
	}
	public void setReferencias(Set<Referencias> referencias) {
		this.referencias = referencias;
	}
	public Set<ReferenciaBancaria> getReferenciaBancarias() {
		return referenciaBancarias;
	}
	public void setReferenciaBancarias(Set<ReferenciaBancaria> referenciaBancarias) {
		this.referenciaBancarias = referenciaBancarias;
	}
	public Set<Emails> getEmails() {
		return emails;
	}
	public void setEmails(Set<Emails> emails) {
		this.emails = emails;
	}
	public Set<Socios> getSocios() {
		return socios;
	}
	public void setSocios(Set<Socios> socios) {
		this.socios = socios;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((fundacao == null) ? 0 : fundacao.hashCode());
		result = prime * result + ((inscricaoEstadual == null) ? 0 : inscricaoEstadual.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result + ((referenciaBancarias == null) ? 0 : referenciaBancarias.hashCode());
		result = prime * result + ((referencias == null) ? 0 : referencias.hashCode());
		result = prime * result + ((socios == null) ? 0 : socios.hashCode());
		result = prime * result + ((telefones == null) ? 0 : telefones.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaJuridica other = (PessoaJuridica) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (emails == null) {
			if (other.emails != null)
				return false;
		} else if (!emails.equals(other.emails))
			return false;
		if (enderecos == null) {
			if (other.enderecos != null)
				return false;
		} else if (!enderecos.equals(other.enderecos))
			return false;
		if (fundacao == null) {
			if (other.fundacao != null)
				return false;
		} else if (!fundacao.equals(other.fundacao))
			return false;
		if (inscricaoEstadual == null) {
			if (other.inscricaoEstadual != null)
				return false;
		} else if (!inscricaoEstadual.equals(other.inscricaoEstadual))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (referenciaBancarias == null) {
			if (other.referenciaBancarias != null)
				return false;
		} else if (!referenciaBancarias.equals(other.referenciaBancarias))
			return false;
		if (referencias == null) {
			if (other.referencias != null)
				return false;
		} else if (!referencias.equals(other.referencias))
			return false;
		if (socios == null) {
			if (other.socios != null)
				return false;
		} else if (!socios.equals(other.socios))
			return false;
		if (telefones == null) {
			if (other.telefones != null)
				return false;
		} else if (!telefones.equals(other.telefones))
			return false;
		return true;
	}
}