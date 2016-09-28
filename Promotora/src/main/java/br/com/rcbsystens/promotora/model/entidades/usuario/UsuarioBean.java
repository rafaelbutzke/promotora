package br.com.rcbsystens.promotora.model.entidades.usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.rcbsystens.promotora.model.entidades.pessoa.PessoaFisica;
import br.com.rcbsystens.promotora.model.entidades.pessoa.PessoaRN;
import br.com.rcbsystens.promotora.model.imutaveis.NiveisPermissao;
import br.com.rcbsystens.promotora.model.imutaveis.TipoUsuario;

@ManagedBean
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private UsuarioRN usuarioRN = new UsuarioRN();
	private PessoaRN pessoaRN = new PessoaRN();
	private String cpf;
	private String confirmaSenha;
	
	public String novo() {
		this.usuario = new Usuario();
		usuario.setPessoa(new PessoaFisica());
		return "cadastroUsuario";
	}
	
	public String buscaPessoa(){
		System.out.println("Executou busca pessoa!");
		String cpf = this.getCpf();
		usuario.setPessoa((PessoaFisica)this.pessoaRN.buscaPorCpf(cpf));
		System.out.println(usuario.getPessoa().getIdPessoa());
		if(usuario.getPessoa().getIdPessoa()==null||usuario.getPessoa().getIdPessoa()==0){
			System.out.println("Pessoa não cadastrada, favor cadastrar!");
			return "cadastroPessoa";
		}else{
			this.usuario.setPessoa((PessoaFisica)this.pessoaRN.buscaPorCpf(cpf));
		 	System.out.println("Pessoa cadastrada!");
		 	return null;
		}
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (!usuario.getSenha().equals(getConfirmaSenha())) {
			this.usuarioRN.salvar(usuario);
			return "sucesso";
		}else {
			FacesMessage mensagem = new FacesMessage("A senha não foi confirmada corretamente!");
			context.addMessage(null, mensagem);
			return null;
		}

	}

	public TipoUsuario[] getTipoUsuarios() {
		return TipoUsuario.values();
	}

	public NiveisPermissao[] getNiveisPermissoes() {
		return NiveisPermissao.values();
	}

	// get´s e set´s
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioRN getUsuarioRN() {
		return usuarioRN;
	}

	public void setUsuarioRN(UsuarioRN usuarioRN) {
		this.usuarioRN = usuarioRN;
	}

	public PessoaRN getPessoaRN() {
		return pessoaRN;
	}

	public void setPessoaRN(PessoaRN pessoaRN) {
		this.pessoaRN = pessoaRN;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
}