package br.com.rcbsystens.promotora.model.propostaweb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.rcbsystens.promotora.model.imutaveis.ClassificacaoLocalTrabalho;
import br.com.rcbsystens.promotora.model.imutaveis.Escolaridade;
import br.com.rcbsystens.promotora.model.imutaveis.EstadoCivil;
import br.com.rcbsystens.promotora.model.imutaveis.Estados;
import br.com.rcbsystens.promotora.model.imutaveis.Nacionalidade;
import br.com.rcbsystens.promotora.model.imutaveis.RelacaoBancos;
import br.com.rcbsystens.promotora.model.imutaveis.Retorno;
import br.com.rcbsystens.promotora.model.imutaveis.Sexo;
import br.com.rcbsystens.promotora.model.imutaveis.StatusPropostaWeb;
import br.com.rcbsystens.promotora.model.imutaveis.TipoResidencia;
import br.com.rcbsystens.promotora.model.imutaveis.TipoVeiculo;

@NamedQueries({
	@NamedQuery(name="PropostaWeb.ListaTotal",query="SELECT proposta FROM PropostaWeb proposta ORDER BY proposta.dataDeEnvio DESC"),
	@NamedQuery(name="PropostaWeb.PesquisaPorCpf",query="SELECT proposta FROM PropostaWeb proposta WHERE proposta.cpfCliente = :cpf ORDER BY proposta.dataDeEnvio DESC"),
	@NamedQuery(name="PropostaWeb.PesquisaPorNome",query="SELECT proposta FROM PropostaWeb proposta WHERE proposta.nomeCliente LIKE :nome ORDER BY proposta.nomeCliente ASC"),
	@NamedQuery(name="PropostaWeb.PesquisaPorId",query="SELECT proposta FROM PropostaWeb proposta WHERE proposta.id = :id"),
	@NamedQuery(name="PropostaWeb.PesquisaPorPeriodo",query="SELECT proposta FROM PropostaWeb proposta WHERE proposta.dataDeEnvio BETWEEN :dataInicial AND :dataFinal ORDER BY proposta.dataDeEnvio DESC")
})

@Entity
public class PropostaWeb implements Serializable {
	private static final long serialVersionUID = 526060821233863162L;
	
	@Id @GeneratedValue
	private long id;
	@Enumerated(EnumType.STRING)
	private TipoVeiculo tipoVeiculo;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataDeEnvio;
	@Enumerated(EnumType.STRING)
	private Retorno retorno;
	private String plano;
	@Column(length=160)
	private String cpfCliente;
	private String nomeCliente;
	private String paiCliente;
	private String maeCliente;
	@Temporal(value=TemporalType.DATE)
	private Date dataNascimentoCliente; 
	@Enumerated(EnumType.STRING)
	private Nacionalidade nacionalidadaCliente; 
	private String naturalidadeCliente; 
	@Enumerated(EnumType.STRING)
	private Estados ufNaturalidadeCliente; 
	private String registroGeralCliente; 
	private String orgaoEmissorCliente;
	@Enumerated(EnumType.STRING)
	private Estados ufOrgaoEmissorCliente; 
	@Temporal(value=TemporalType.DATE)
	private Date dataEmissaoCliente;
	@Enumerated(EnumType.STRING)
	private Sexo sexoCliente; 
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivilCliente;
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridadeCliente;
	private String foneResidencial;
	private String celularCliente;
	private String email; 
	@Enumerated(EnumType.STRING)
	private TipoResidencia tipoResidencia;
	private BigDecimal valorAluguel = new BigDecimal("0"); 
	@Temporal(value=TemporalType.DATE)
	private Date tempoResidencia; 
	private String resCep;
	private String resLogradouro; 
	private String resNumero; 
	private String resComplemento;
	private String resBairro; 
	private String resCidade;
	@Enumerated(EnumType.STRING)
	private Estados resUf;
	@Enumerated(EnumType.STRING)
	private ClassificacaoLocalTrabalho classificacaoLocalTrabalho;
	private String empresa;
	private String cnpj; 
	private String cargo; 
	private BigDecimal salario = new BigDecimal("0");
	private String provenienteRenda2;
	private BigDecimal renda2 = new BigDecimal("0");
	@Temporal(value=TemporalType.DATE)
	private Date dataAdmissao; 
	private String foneLocalTrabalho; 
	private String comCep;
	private String comLogradouro; 
	private String comNumero; 
	private String comComplemento;
	private String comBairro; 
	private String comCidade;
	@Enumerated(EnumType.STRING)
	private Estados comUf;
	private String referencia1;
	private String foneReferencia1;
	private String referencia2;
	private String foneReferencia2;
	private RelacaoBancos banco; 
	private String agencia; 
	private String conta;
	@Temporal(value=TemporalType.DATE)
	private Date abertura;
	private String cpfConjugue; 
	private String nomeConjugue; 
	private String paiConjugue; 
	private String maeConjugue;
	@Temporal(value=TemporalType.DATE)
	private Date dataNascimentoConjugue; 
	@Enumerated(EnumType.STRING)
	private Nacionalidade nacionalidadaConjugue; 
	private String naturalidadeConjugue; 
	@Enumerated(EnumType.STRING)
	private Estados ufNaturalidadeConjugue; 
	private String registroGeralConjugue; 
	private String orgaoEmissorConjugue;
	@Enumerated(EnumType.STRING)
	private Estados ufOrgaoEmissorConjugue;
	@Temporal(value=TemporalType.DATE)
	private Date dataEmissaoConjugue;
	@Enumerated(EnumType.STRING)
	private Sexo sexoConjugue; 
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridadeConjugue;
	private String celularConjugue;
	private String emailConjugue; 
	@Enumerated(EnumType.STRING)
	private ClassificacaoLocalTrabalho classificacaoLocalTrabalhoConjugue;
	private String empresaConjugue;
	private String cnpjConjugue; 
	private String cargoConjugue; 
	private BigDecimal salarioConjugue = new BigDecimal("0");
	private String provenienteRenda2Conjugue;
	private BigDecimal renda2Conjugue = new BigDecimal("0");
	@Temporal(value=TemporalType.DATE)
	private Date dataAdmissaoConjugue; 
	private String foneLocalTrabalhoConjugue; 
	private String comCepConjugue;
	private String comLogradouroConjugue; 
	private String comNumeroConjugue; 
	private String comComplementoConjugue;
	private String comBairroConjugue; 
	private String comCidadeConjugue;
	private String comUfConjugue;
	private RelacaoBancos bancoConjugue; 
	private String agenciaConjugue; 
	private String contaConjugue;
	@Temporal(value=TemporalType.DATE)
	private Date aberturaConjugue;
	private String fabricante;
	private String modeloVeiculo; 
	private String ano; 
	private String modelo; 
	private String informacoes;
	private BigDecimal valorCompra = new BigDecimal("0"); 
	private BigDecimal valorEntrada = new BigDecimal("0");
	private BigDecimal valorFinanciado = new BigDecimal("0");
	private Boolean verificacao; 
	@Enumerated(EnumType.STRING)
	private StatusPropostaWeb status;  
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date registroParecer; 
	private String parecer; 
	private String emailVendedor; 
	private String nomeVendedor;
	private String foneVendedor;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public Retorno getRetorno() {
		return retorno;
	}
	public void setRetorno(Retorno retorno) {
		this.retorno = retorno;
	}
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano = plano;
	}
	public String getFoneReferencia1() {
		return foneReferencia1;
	}
	public void setFoneReferencia1(String foneReferencia1) {
		this.foneReferencia1 = foneReferencia1;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente.toUpperCase();
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente.toUpperCase();
	}
	public String getPaiCliente() {
		return paiCliente;
	}
	public void setPaiCliente(String paiCliente) {
		this.paiCliente = paiCliente.toUpperCase();
	}
	public String getMaeCliente() {
		return maeCliente;
	}
	public void setMaeCliente(String maeCliente) {
		this.maeCliente = maeCliente.toUpperCase();
	}
	public Date getDataNascimentoCliente() {
		return dataNascimentoCliente;
	}
	public void setDataNascimentoCliente(Date dataNascimentoCliente) {
		this.dataNascimentoCliente = dataNascimentoCliente;
	}
	public Nacionalidade getNacionalidadaCliente() {
		return nacionalidadaCliente;
	}
	public void setNacionalidadaCliente(Nacionalidade nacionalidadaCliente) {
		this.nacionalidadaCliente = nacionalidadaCliente;
	}
	public String getNaturalidadeCliente() {
		return naturalidadeCliente;
	}
	public void setNaturalidadeCliente(String naturalidadeCliente) {
		this.naturalidadeCliente = naturalidadeCliente.toUpperCase();
	}
	public Estados getUfNaturalidadeCliente() {
		return ufNaturalidadeCliente;
	}
	public void setUfNaturalidadeCliente(Estados ufNaturalidadeCliente) {
		this.ufNaturalidadeCliente = ufNaturalidadeCliente;
	}
	public String getRegistroGeralCliente() {
		return registroGeralCliente;
	}
	public void setRegistroGeralCliente(String registroGeralCliente) {
		this.registroGeralCliente = registroGeralCliente.toUpperCase();
	}
	public String getOrgaoEmissorCliente() {
		return orgaoEmissorCliente;
	}
	public void setOrgaoEmissorCliente(String orgaoEmissorCliente) {
		this.orgaoEmissorCliente = orgaoEmissorCliente.toUpperCase();
	}
	public Estados getUfOrgaoEmissorCliente() {
		return ufOrgaoEmissorCliente;
	}
	public void setUfOrgaoEmissorCliente(Estados ufOrgaoEmissorCliente) {
		this.ufOrgaoEmissorCliente = ufOrgaoEmissorCliente;
	}
	public Date getDataEmissaoCliente() {
		return dataEmissaoCliente;
	}
	public void setDataEmissaoCliente(Date dataEmissaoCliente) {
		this.dataEmissaoCliente = dataEmissaoCliente;
	}
	public Sexo getSexoCliente() {
		return sexoCliente;
	}
	public void setSexoCliente(Sexo sexoCliente) {
		this.sexoCliente = sexoCliente;
	}
	public EstadoCivil getEstadoCivilCliente() {
		return estadoCivilCliente;
	}
	public void setEstadoCivilCliente(EstadoCivil estadoCivilCliente) {
		this.estadoCivilCliente = estadoCivilCliente;
	}
	public Escolaridade getEscolaridadeCliente() {
		return escolaridadeCliente;
	}
	public void setEscolaridadeCliente(Escolaridade escolaridadeCliente) {
		this.escolaridadeCliente = escolaridadeCliente;
	}
	public String getFoneResidencial() {
		return foneResidencial;
	}
	public void setFoneResidencial(String foneResidencial) {
		this.foneResidencial = foneResidencial.toUpperCase();
	}
	public String getCelularCliente() {
		return celularCliente;
	}
	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente.toUpperCase();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	public TipoResidencia getTipoResidencia() {
		return tipoResidencia;
	}
	public void setTipoResidencia(TipoResidencia tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}
	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public Date getTempoResidencia() {
		return tempoResidencia;
	}
	public void setTempoResidencia(Date tempoResidencia) {
		this.tempoResidencia = tempoResidencia;
	}
	public String getResCep() {
		return resCep;
	}
	public void setResCep(String resCep) {
		this.resCep = resCep.toUpperCase();
	}
	public String getResLogradouro() {
		return resLogradouro;
	}
	public void setResLogradouro(String resLogradouro) {
		this.resLogradouro = resLogradouro.toUpperCase();
	}
	public String getResNumero() {
		return resNumero;
	}
	public void setResNumero(String resNumero) {
		this.resNumero = resNumero.toUpperCase();
	}
	public String getResComplemento() {
		return resComplemento;
	}
	public void setResComplemento(String resComplemento) {
		this.resComplemento = resComplemento.toUpperCase();
	}
	public String getResBairro() {
		return resBairro;
	}
	public void setResBairro(String resBairro) {
		this.resBairro = resBairro.toUpperCase();
	}
	public String getResCidade() {
		return resCidade;
	}
	public void setResCidade(String resCidade) {
		this.resCidade = resCidade.toUpperCase();
	}
	public Estados getResUf() {
		return resUf;
	}
	public void setResUf(Estados resUf) {
		this.resUf = resUf;
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo.toUpperCase();
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public String getProvenienteRenda2() {
		return provenienteRenda2;
	}
	public void setProvenienteRenda2(String provenienteRenda2) {
		this.provenienteRenda2 = provenienteRenda2.toUpperCase();
	}
	public BigDecimal getRenda2() {
		return renda2;
	}
	public void setRenda2(BigDecimal renda2) {
		this.renda2 = renda2;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public String getFoneLocalTrabalho() {
		return foneLocalTrabalho;
	}
	public void setFoneLocalTrabalho(String foneLocalTrabalho) {
		this.foneLocalTrabalho = foneLocalTrabalho.toUpperCase();
	}
	public String getComCep() {
		return comCep;
	}
	public void setComCep(String comCep) {
		this.comCep = comCep.toUpperCase();
	}
	public String getComLogradouro() {
		return comLogradouro;
	}
	public void setComLogradouro(String comLogradouro) {
		this.comLogradouro = comLogradouro.toUpperCase();
	}
	public String getComNumero() {
		return comNumero;
	}
	public void setComNumero(String comNumero) {
		this.comNumero = comNumero.toUpperCase();
	}
	public String getComComplemento() {
		return comComplemento;
	}
	public void setComComplemento(String comComplemento) {
		this.comComplemento = comComplemento.toUpperCase();
	}
	public String getComBairro() {
		return comBairro;
	}
	public void setComBairro(String comBairro) {
		this.comBairro = comBairro.toUpperCase();
	}
	public String getComCidade() {
		return comCidade;
	}
	public void setComCidade(String comCidade) {
		this.comCidade = comCidade.toUpperCase();
	}
	public Estados getComUf() {
		return comUf;
	}
	public void setComUf(Estados comUf) {
		this.comUf = comUf;
	}
	public String getReferencia1() {
		return referencia1;
	}
	public void setReferencia1(String referencia1) {
		this.referencia1 = referencia1.toUpperCase();
	}
	public String getFoneRefencia1() {
		return foneReferencia1;
	}
	public void setFoneRefencia1(String foneRefencia1) {
		this.foneReferencia1 = foneRefencia1.toUpperCase();
	}
	public String getReferencia2() {
		return referencia2;
	}
	public void setReferencia2(String referencia2) {
		this.referencia2 = referencia2.toUpperCase();
	}
	public String getFoneReferencia2() {
		return foneReferencia2;
	}
	public void setFoneReferencia2(String foneReferencia2) {
		this.foneReferencia2 = foneReferencia2.toUpperCase();
	}

	public RelacaoBancos getBanco() {
		return banco;
	}
	public void setBanco(RelacaoBancos banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia.toUpperCase();
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta.toUpperCase();
	}
	public Date getAbertura() {
		return abertura;
	}
	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}
	public String getCpfConjugue() {
		return cpfConjugue;
	}
	public void setCpfConjugue(String cpfConjugue) {
		this.cpfConjugue = cpfConjugue.toUpperCase();
	}
	public String getNomeConjugue() {
		return nomeConjugue;
	}
	public void setNomeConjugue(String nomeConjugue) {
		this.nomeConjugue = nomeConjugue.toUpperCase();
	}
	public String getPaiConjugue() {
		return paiConjugue;
	}
	public void setPaiConjugue(String paiConjugue) {
		this.paiConjugue = paiConjugue.toUpperCase();
	}
	public String getMaeConjugue() {
		return maeConjugue;
	}
	public void setMaeConjugue(String maeConjugue) {
		this.maeConjugue = maeConjugue.toUpperCase();
	}
	public Date getDataNascimentoConjugue() {
		return dataNascimentoConjugue;
	}
	public void setDataNascimentoConjugue(Date dataNascimentoConjugue) {
		this.dataNascimentoConjugue = dataNascimentoConjugue;
	}
	public Nacionalidade getNacionalidadaConjugue() {
		return nacionalidadaConjugue;
	}
	public void setNacionalidadaConjugue(Nacionalidade nacionalidadaConjugue) {
		this.nacionalidadaConjugue = nacionalidadaConjugue;
	}
	public String getNaturalidadeConjugue() {
		return naturalidadeConjugue;
	}
	public void setNaturalidadeConjugue(String naturalidadeConjugue) {
		this.naturalidadeConjugue = naturalidadeConjugue.toUpperCase();
	}
	public Estados getUfNaturalidadeConjugue() {
		return ufNaturalidadeConjugue;
	}
	public void setUfNaturalidadeConjugue(Estados ufNaturalidadeConjugue) {
		this.ufNaturalidadeConjugue = ufNaturalidadeConjugue;
	}
	public String getRegistroGeralConjugue() {
		return registroGeralConjugue;
	}
	public void setRegistroGeralConjugue(String registroGeralConjugue) {
		this.registroGeralConjugue = registroGeralConjugue.toUpperCase();
	}
	public String getOrgaoEmissorConjugue() {
		return orgaoEmissorConjugue;
	}
	public void setOrgaoEmissorConjugue(String orgaoEmissorConjugue) {
		this.orgaoEmissorConjugue = orgaoEmissorConjugue.toUpperCase();
	}
	public Estados getUfOrgaoEmissorConjugue() {
		return ufOrgaoEmissorConjugue;
	}
	public void setUfOrgaoEmissorConjugue(Estados ufOrgaoEmissorConjugue) {
		this.ufOrgaoEmissorConjugue = ufOrgaoEmissorConjugue;
	}
	public Date getDataEmissaoConjugue() {
		return dataEmissaoConjugue;
	}
	public void setDataEmissaoConjugue(Date dataEmissaoConjugue) {
		this.dataEmissaoConjugue = dataEmissaoConjugue;
	}
	public Sexo getSexoConjugue() {
		return sexoConjugue;
	}
	public void setSexoConjugue(Sexo sexoConjugue) {
		this.sexoConjugue = sexoConjugue;
	}
	public Escolaridade getEscolaridadeConjugue() {
		return escolaridadeConjugue;
	}
	public void setEscolaridadeConjugue(Escolaridade escolaridadeConjugue) {
		this.escolaridadeConjugue = escolaridadeConjugue;
	}
	public String getCelularConjugue() {
		return celularConjugue;
	}
	public void setCelularConjugue(String celularConjugue) {
		this.celularConjugue = celularConjugue.toUpperCase();
	}
	public String getEmailConjugue() {
		return emailConjugue;
	}
	public void setEmailConjugue(String emailConjugue) {
		this.emailConjugue = emailConjugue.toUpperCase();
	}
	public ClassificacaoLocalTrabalho getClassificacaoLocalTrabalhoConjugue() {
		return classificacaoLocalTrabalhoConjugue;
	}
	public void setClassificacaoLocalTrabalhoConjugue(
			ClassificacaoLocalTrabalho classificacaoLocalTrabalhoConjugue) {
		this.classificacaoLocalTrabalhoConjugue = classificacaoLocalTrabalhoConjugue;
	}
	public String getEmpresaConjugue() {
		return empresaConjugue;
	}
	public void setEmpresaConjugue(String empresaConjugue) {
		this.empresaConjugue = empresaConjugue.toUpperCase();
	}
	public String getCnpjConjugue() {
		return cnpjConjugue;
	}
	public void setCnpjConjugue(String cnpjConjugue) {
		this.cnpjConjugue = cnpjConjugue.toUpperCase();
	}
	public String getCargoConjugue() {
		return cargoConjugue;
	}
	public void setCargoConjugue(String cargoConjugue) {
		this.cargoConjugue = cargoConjugue.toUpperCase();
	}
	public BigDecimal getSalarioConjugue() {
		return salarioConjugue;
	}
	public void setSalarioConjugue(BigDecimal salarioConjugue) {
		this.salarioConjugue = salarioConjugue;
	}
	public String getProvenienteRenda2Conjugue() {
		return provenienteRenda2Conjugue;
	}
	public void setProvenienteRenda2Conjugue(String provenienteRenda2Conjugue) {
		this.provenienteRenda2Conjugue = provenienteRenda2Conjugue.toUpperCase();
	}
	public BigDecimal getRenda2Conjugue() {
		return renda2Conjugue;
	}
	public void setRenda2Conjugue(BigDecimal renda2Conjugue) {
		this.renda2Conjugue = renda2Conjugue;
	}
	public Date getDataAdmissaoConjugue() {
		return dataAdmissaoConjugue;
	}
	public void setDataAdmissaoConjugue(Date dataAdmissaoConjugue) {
		this.dataAdmissaoConjugue = dataAdmissaoConjugue;
	}
	public String getFoneLocalTrabalhoConjugue() {
		return foneLocalTrabalhoConjugue;
	}
	public void setFoneLocalTrabalhoConjugue(String foneLocalTrabalhoConjugue) {
		this.foneLocalTrabalhoConjugue = foneLocalTrabalhoConjugue.toUpperCase();
	}
	public String getComCepConjugue() {
		return comCepConjugue;
	}
	public void setComCepConjugue(String comCepConjugue) {
		this.comCepConjugue = comCepConjugue.toUpperCase();
	}
	public String getComLogradouroConjugue() {
		return comLogradouroConjugue;
	}
	public void setComLogradouroConjugue(String comLogradouroConjugue) {
		this.comLogradouroConjugue = comLogradouroConjugue.toUpperCase();
	}
	public String getComNumeroConjugue() {
		return comNumeroConjugue;
	}
	public void setComNumeroConjugue(String comNumeroConjugue) {
		this.comNumeroConjugue = comNumeroConjugue.toUpperCase();
	}
	public String getComComplementoConjugue() {
		return comComplementoConjugue;
	}
	public void setComComplementoConjugue(String comComplementoConjugue) {
		this.comComplementoConjugue = comComplementoConjugue.toUpperCase();
	}
	public String getComBairroConjugue() {
		return comBairroConjugue;
	}
	public void setComBairroConjugue(String comBairroConjugue) {
		this.comBairroConjugue = comBairroConjugue.toUpperCase();
	}
	public String getComCidadeConjugue() {
		return comCidadeConjugue;
	}
	public void setComCidadeConjugue(String comCidadeConjugue) {
		this.comCidadeConjugue = comCidadeConjugue.toUpperCase();
	}
	public String getComUfConjugue() {
		return comUfConjugue;
	}
	public void setComUfConjugue(String comUfConjugue) {
		this.comUfConjugue = comUfConjugue.toUpperCase();
	}
	public RelacaoBancos getBancoConjugue() {
		return bancoConjugue;
	}
	public void setBancoConjugue(RelacaoBancos bancoConjugue) {
		this.bancoConjugue = bancoConjugue;
	}
	public String getAgenciaConjugue() {
		return agenciaConjugue;
	}
	public void setAgenciaConjugue(String agenciaConjugue) {
		this.agenciaConjugue = agenciaConjugue.toUpperCase();
	}
	public String getContaConjugue() {
		return contaConjugue;
	}
	public void setContaConjugue(String contaConjugue) {
		this.contaConjugue = contaConjugue.toUpperCase();
	}
	public Date getAberturaConjugue() {
		return aberturaConjugue;
	}
	public void setAberturaConjugue(Date aberturaConjugue) {
		this.aberturaConjugue = aberturaConjugue;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante.toUpperCase();
	}
	public String getModeloVeiculo() {
		return modeloVeiculo;
	}
	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo.toUpperCase();
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano.toUpperCase();
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo.toUpperCase();
	}
	public BigDecimal getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}
	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}
	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}
	public BigDecimal getValorFinanciado() {
		return valorFinanciado;
	}
	public void setValorFinanciado(BigDecimal valorFinanciado) {
		this.valorFinanciado = valorFinanciado;
	}
	public Boolean getVerificacao() {
		return verificacao;
	}
	public void setVerificacao(Boolean verificacao) {
		this.verificacao = verificacao;
	}
	public StatusPropostaWeb getStatus() {
		return status;
	}
	public void setStatus(StatusPropostaWeb status) {
		this.status = status;
	}
	public String getParecer() {
		return parecer;
	}
	public void setParecer(String parecer) {
		this.parecer = parecer.toUpperCase();
	}
	public Date getDataDeEnvio() {
		return dataDeEnvio;
	}
	public void setDataDeEnvio(Date dataDeEnvio) {
		this.dataDeEnvio = dataDeEnvio;
	}
	public Date getRegistroParecer() {
		return registroParecer;
	}
	public void setRegistroParecer(Date registroParecer) {
		this.registroParecer = registroParecer;
	}
	public String getEmailVendedor() {
		return emailVendedor;
	}
	public void setEmailVendedor(String emailVendedor) {
		this.emailVendedor = emailVendedor.toLowerCase();
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor.toUpperCase();
	}
	public String getFoneVendedor() {
		return foneVendedor;
	}
	public void setFoneVendedor(String foneVendedor) {
		this.foneVendedor = foneVendedor;
	}
}
