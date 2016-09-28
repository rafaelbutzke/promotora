package br.com.rcbsystens.promotora.model.entidades.pessoa;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import br.com.rcbsystens.promotora.model.email.Email;
import br.com.rcbsystens.promotora.model.entidades.emails.Emails;
import br.com.rcbsystens.promotora.model.entidades.enderecos.Enderecos;
import br.com.rcbsystens.promotora.model.entidades.localtrabalho.LocalTrabalho;
import br.com.rcbsystens.promotora.model.entidades.referencias.Referencias;
import br.com.rcbsystens.promotora.model.entidades.registrogeral.RegistroGeral;
import br.com.rcbsystens.promotora.model.entidades.telefones.Telefones;
import br.com.rcbsystens.promotora.model.imutaveis.Escolaridade;
import br.com.rcbsystens.promotora.model.imutaveis.EstadoCivil;
import br.com.rcbsystens.promotora.model.imutaveis.Estados;
import br.com.rcbsystens.promotora.model.imutaveis.Nacionalidade;
import br.com.rcbsystens.promotora.model.imutaveis.Sexo;
import br.com.rcbsystens.promotora.model.imutaveis.Situacao;
import br.com.rcbsystens.promotora.model.imutaveis.TipoPessoa;
import br.com.rcbsystens.promotora.model.imutaveis.TipoTelefone;

@ManagedBean
@ViewScoped
public class PessoaBean {
	private PessoaFisica pf = new PessoaFisica();
	private PessoaJuridica pj = new PessoaJuridica();
	private Pessoa pessoa = new Pessoa();
	private PessoaRN pessoaRN = new PessoaRN();
	private String tPessoa = new String(); 
	private RegistroGeral rg = new RegistroGeral();
	private Set<RegistroGeral> listaRg = new HashSet<RegistroGeral>();
	private Telefones telefone = new Telefones();
	private Set<Telefones> listaTelefones = new HashSet<Telefones>();
	private Enderecos residencia = new Enderecos();
	private Set<Enderecos> enderecosResidencias = new HashSet<Enderecos>();
	private Enderecos comercial = new Enderecos();
	private Set<Enderecos> enderecosComerciais = new HashSet<Enderecos>();
	private LocalTrabalho localTrabalho = new LocalTrabalho();
	private Set<LocalTrabalho> listaLocaisTrabalho = new HashSet<LocalTrabalho>(); 
	private Referencias referencia = new Referencias();
	private Set<Referencias> listaReferencias = new HashSet<Referencias>();
	private Emails email = new Emails();
	private Set<Email> listaEmail = new HashSet<Email>();
	
	public void verificaTipoPesso(){
		System.out.println("Verifica tipo pessoa!");
		if (pessoa.getTipoPessoa().equals(TipoPessoa.F)) {
			System.out.println("Pessoa fisica");
			tPessoa = "fisica";
		}
		if (pessoa.getTipoPessoa().equals(TipoPessoa.J)) {
			System.out.println("Pessoa juridica");
			tPessoa = "juridica";
		}
		System.out.println("Tipo pessoa: " + pessoa.getTipoPessoa() + " " + tPessoa);
	}
	
	public void adicionarRgPf(){
		System.out.println("Adicionar rg passou....");
		System.out.println(rg.getNumeroRegistro()+ rg.getDataEmissao()+ rg.getEstado()+ rg.getOrgaoEmissor());
		if (rg.getNumeroRegistro()==null || rg.getDataEmissao()==null || rg.getEstado()==null || rg.getOrgaoEmissor()==null || rg.getNumeroRegistro()=="" || rg.getOrgaoEmissor()==""){
			System.out.println("Favor cadastrar o rg completo!");
		}else{
			System.out.println("Rg adicionado");
			listaRg.add(rg);
			pf.setRegistroGeral(listaRg);
			rg = new RegistroGeral();
		}
	}
	
	public void editaRgSelecionado(SelectEvent evento){
		rg = new RegistroGeral();
		setRg((RegistroGeral)evento.getObject());
		listaRg.remove(rg);
	}
	
	public void adicionarTelefonePf(){
		System.out.println("Adicionar telefone passou....");
		if (telefone.getDdd()==null || telefone.getTipoTelefone()==null || telefone.getTelefone()==null || telefone.getDdd()=="" || telefone.getTelefone()=="") {
			System.out.println("Favor cadastrar o telefone completo");
		} else {
			int encontrou = 0;
			for (Telefones testaTelefones : listaTelefones) {
				if ((telefone.getDdd()+telefone.getTelefone()).equals(testaTelefones.getDdd()+testaTelefones.getTelefone())) {
					encontrou = 1;
				}
				System.out.println("Valor do encontrou: " + encontrou);
			} 
			
			if (encontrou == 0)	{
				System.out.println("Telefone adicionado");
				telefone.setSituacao(Situacao.ATIVO);
				listaTelefones.add(telefone);
				pf.setTelefones(listaTelefones);
				System.out.println(telefone.getTipoTelefone()+ " " + telefone.getDdd() + " " +telefone.getTelefone());
				telefone = new Telefones();
			} else{
				System.out.println("Telefone ja foi adicionado");
			}		
		}
		
	}
	
	public void editaTelefoneSelecionado(SelectEvent evento){
		telefone = new Telefones();
		setTelefone((Telefones)evento.getObject());
		listaTelefones.remove(telefone);
	}
	
	public TipoPessoa[] getTipoPessoas(){
		return TipoPessoa.values();
	}
	
	public Nacionalidade[] getNacionalidades(){
		return Nacionalidade.values();
	}
	
	public TipoTelefone[] getTipoTelefones(){
		return TipoTelefone.values();
	}
	
	public Estados[] getEstados(){
		return Estados.values();
	}
	
	public Sexo[] getGeneros(){
		return Sexo.values();
	}
	
	public EstadoCivil[] getEstadoCivil(){
		return EstadoCivil.values();
	}
	
	public Escolaridade[] getEscolaridades(){
		return Escolaridade.values();
	}
	
	public void chamar(){

	}
	// get end set
	
	
	
	public Set<Telefones> getListaTelefones() {
		return listaTelefones;
	}

	public Enderecos getResidencia() {
		return residencia;
	}

	public void setResidencia(Enderecos residencia) {
		this.residencia = residencia;
	}

	public Set<Enderecos> getEnderecosResidencias() {
		return enderecosResidencias;
	}

	public void setEnderecosResidencias(Set<Enderecos> enderecosResidencias) {
		this.enderecosResidencias = enderecosResidencias;
	}

	public Enderecos getComercial() {
		return comercial;
	}

	public void setComercial(Enderecos comercial) {
		this.comercial = comercial;
	}

	public Set<Enderecos> getEnderecosComerciais() {
		return enderecosComerciais;
	}

	public void setEnderecosComerciais(Set<Enderecos> enderecosComerciais) {
		this.enderecosComerciais = enderecosComerciais;
	}

	public Set<LocalTrabalho> getListaLocaisTrabalho() {
		return listaLocaisTrabalho;
	}

	public void setListaLocaisTrabalho(Set<LocalTrabalho> listaLocaisTrabalho) {
		this.listaLocaisTrabalho = listaLocaisTrabalho;
	}

	public Set<Referencias> getListaReferencias() {
		return listaReferencias;
	}

	public void setListaReferencias(Set<Referencias> listaReferencias) {
		this.listaReferencias = listaReferencias;
	}

	public Set<Email> getListaEmail() {
		return listaEmail;
	}

	public void setListaEmail(Set<Email> listaEmail) {
		this.listaEmail = listaEmail;
	}

	public LocalTrabalho getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(LocalTrabalho localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public Referencias getReferencia() {
		return referencia;
	}

	public void setReferencia(Referencias referencia) {
		this.referencia = referencia;
	}

	public Emails getEmail() {
		return email;
	}

	public void setEmail(Emails email) {
		this.email = email;
	}

	public void setListaTelefones(Set<Telefones> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}
	
	public Telefones getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefones telefone) {
		this.telefone = telefone;
	}
	
	public PessoaFisica getPf() {
		return pf;
	}

	public void setPf(PessoaFisica pf) {
		this.pf = pf;
	}

	public PessoaJuridica getPj() {
		return pj;
	}

	public void setPj(PessoaJuridica pj) {
		this.pj = pj;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaRN getPessoaRN() {
		return pessoaRN;
	}

	public void setPessoaRN(PessoaRN pessoaRN) {
		this.pessoaRN = pessoaRN;
	}

	public String gettPessoa() {
		return tPessoa;
	}

	public void settPessoa(String tPessoa) {
		this.tPessoa = tPessoa;
	}

	public RegistroGeral getRg() {
		return rg;
	}

	public void setRg(RegistroGeral rg) {
		this.rg = rg;
	}

	public Set<RegistroGeral> getListaRg() {
		return listaRg;
	}

	public void setListaRg(Set<RegistroGeral> listaRg) {
		this.listaRg = listaRg;
	}
	
	
	
}
