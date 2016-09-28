package br.com.rcbsystens.promotora.model.entidades.pessoa;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import br.com.rcbsystens.promotora.model.entidades.localtrabalho.LocalTrabalho;
import br.com.rcbsystens.promotora.model.entidades.referenciabancaria.ReferenciaBancaria;
import br.com.rcbsystens.promotora.model.entidades.referencias.Referencias;
import br.com.rcbsystens.promotora.model.entidades.registrogeral.RegistroGeral;
import br.com.rcbsystens.promotora.model.entidades.telefones.Telefones;
import br.com.rcbsystens.promotora.model.imutaveis.Escolaridade;
import br.com.rcbsystens.promotora.model.imutaveis.EstadoCivil;
import br.com.rcbsystens.promotora.model.imutaveis.Estados;
import br.com.rcbsystens.promotora.model.imutaveis.Nacionalidade;
import br.com.rcbsystens.promotora.model.imutaveis.Sexo;
@NamedQueries({
	@NamedQuery(name="PessoaFisica.buscaPorCpf", query="SELECT t FROM PessoaFisica t WHERE t.cpf = :cpf")
	})
@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class PessoaFisica extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1986789606314828120L;
	@Column(unique = true, length=14) // 999.999.999-99
	private String cpf;
	@Column(length=200)
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Enumerated(EnumType.STRING)
	@Column(length=15)
	private EstadoCivil estadoCivil;
	@OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pf_reg_geral", joinColumns=@JoinColumn(name = "id_pf"))
	private Set<RegistroGeral> registroGeral;
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;	
	@Enumerated(EnumType.STRING)
	@Column(length=11) 
	private Nacionalidade nacionalidade; 
	@Column(length=60)
	private String naturalidade;
	@Enumerated(EnumType.STRING)
	@Column(length=25)
	private Estados estado;
	@Column(length=160)
	private String pai;
	@Column(length=160)
	private String mae;
	@OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pf_local_trab", joinColumns=@JoinColumn(name = "id_pf"))
	private Set<LocalTrabalho> locaisTrabalhos;
	@OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pf_enderecos", joinColumns=@JoinColumn(name = "id_pf"))
	private Set<Enderecos> enderecos;
	@OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pf_telefones", joinColumns=@JoinColumn(name = "id_pf"))
	private Set<Telefones> telefones;
	@OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pf_referencias", joinColumns=@JoinColumn(name = "id_pf"))
	private Set<Referencias> referencias;
	@OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pf_ref_bancaria", joinColumns=@JoinColumn(name = "id_pf"))
	private Set<ReferenciaBancaria> referenciaBancarias;
	@OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="pf_emails", joinColumns=@JoinColumn(name = "id_pf"))
	private Set<Emails> emails;
	
	public PessoaFisica(){}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.toUpperCase();
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Set<RegistroGeral> getRegistroGeral() {
		return registroGeral;
	}

	public void setRegistroGeral(Set<RegistroGeral> registroGeral) {
		this.registroGeral = registroGeral;
	}

	public Nacionalidade getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Nacionalidade nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade.toUpperCase();
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai.toUpperCase();
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae.toUpperCase();
	}

	public Set<LocalTrabalho> getLocaisTrabalhos() {
		return locaisTrabalhos;
	}

	public void setLocaisTrabalhos(Set<LocalTrabalho> locaisTrabalhos) {
		this.locaisTrabalhos = locaisTrabalhos;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result
				+ ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result
				+ ((escolaridade == null) ? 0 : escolaridade.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result
				+ ((locaisTrabalhos == null) ? 0 : locaisTrabalhos.hashCode());
		result = prime * result + ((mae == null) ? 0 : mae.hashCode());
		result = prime * result
				+ ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result
				+ ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pai == null) ? 0 : pai.hashCode());
		result = prime
				* result
				+ ((referenciaBancarias == null) ? 0 : referenciaBancarias
						.hashCode());
		result = prime * result
				+ ((referencias == null) ? 0 : referencias.hashCode());
		result = prime * result
				+ ((registroGeral == null) ? 0 : registroGeral.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result
				+ ((telefones == null) ? 0 : telefones.hashCode());
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
		PessoaFisica other = (PessoaFisica) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
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
		if (escolaridade != other.escolaridade)
			return false;
		if (estado != other.estado)
			return false;
		if (estadoCivil != other.estadoCivil)
			return false;
		if (locaisTrabalhos == null) {
			if (other.locaisTrabalhos != null)
				return false;
		} else if (!locaisTrabalhos.equals(other.locaisTrabalhos))
			return false;
		if (mae == null) {
			if (other.mae != null)
				return false;
		} else if (!mae.equals(other.mae))
			return false;
		if (nacionalidade != other.nacionalidade)
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pai == null) {
			if (other.pai != null)
				return false;
		} else if (!pai.equals(other.pai))
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
		if (registroGeral == null) {
			if (other.registroGeral != null)
				return false;
		} else if (!registroGeral.equals(other.registroGeral))
			return false;
		if (sexo != other.sexo)
			return false;
		if (telefones == null) {
			if (other.telefones != null)
				return false;
		} else if (!telefones.equals(other.telefones))
			return false;
		return true;
	}
}