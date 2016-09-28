package br.com.rcbsystens.promotora.model.entidades.usuario;

import java.util.List;

import br.com.rcbsystens.promotora.model.dao.hibernate.DaoFactory;
import br.com.rcbsystens.promotora.model.validacoes.RetiraCaractereCpfCnpj;

public class UsuarioRN {
	private UsuarioDao usuarioDao;
	public UsuarioRN(){
		this.usuarioDao = DaoFactory.criarUsuarioDao();
	}
	
	/** 
	 * Criar uma funcao que pesquise se o cpf da pessoa que se refere o 
	 * usuario caso encontrato criar retornar os dados da pessoa e criar
	 * o login
	 * **/
	
	public String gerarLogin(Usuario usuario){
		return (String) RetiraCaractereCpfCnpj.retira(usuario.getPessoa().getCpf());
	}
	
	public void salvar(Usuario usuario) {
		// TODO Auto-generated method stub
		if (usuario.getId().equals(null) || usuario.getId().equals(0)){
			// necessidade de verificar duplicidade de login. 
			if (this.usuarioDao.buscaPorLogin(usuario.getLogin()).equals(null)) {
				this.usuarioDao.salvar(usuario);	
			}else{
				System.out.println("Login já resgristrado no sistema!");
			}
		}
	}

	public void atualizar(Usuario usuario){
		if(carregar(usuario.getId()).getLogin().equals(usuario.getLogin())){
			this.usuarioDao.atualizar(usuario);			
		}else {
			System.out.println("Login do usuario não pode ser alterado!");
		}
	}
	
	public void desativar(Usuario usuario) {
		if(usuario.isAtivo()){
			this.usuarioDao.desativar(usuario);
		}else{
			System.out.println("Não é possivel desativar um usuario inativo!");
		}
	}
	
	public Usuario carregar(Long id) {
		return this.usuarioDao.carregar(id);
	}
	
	public Usuario buscaPorLogin(String login) {
		return this.usuarioDao.buscaPorLogin(login);
	}
	
	public List<Usuario> listar() {
		return this.usuarioDao.listar();
	}
	
	
}
