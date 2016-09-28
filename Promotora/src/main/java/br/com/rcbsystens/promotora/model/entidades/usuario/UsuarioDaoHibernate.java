package br.com.rcbsystens.promotora.model.entidades.usuario;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDaoHibernate implements UsuarioDao {

	private Session sessao;
	public void setSession(Session sessao){
		this.sessao = sessao; 
	}
	
	@Override
	public void salvar(Usuario usuario) {
		// TODO Auto-generated method stub
		this.sessao.save(usuario);
	}

	@Override
	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		this.sessao.update(usuario);
	}

	@Override
	public void desativar(Usuario usuario) {
		// TODO Auto-generated method stub
		usuario.setAtivo(false);
		this.sessao.update(usuario);
	}

	@Override
	public Usuario carregar(Long id) {
		// TODO Auto-generated method stub
		return (Usuario) this.sessao.get(Usuario.class, id); 
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		// TODO Auto-generated method stub
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.sessao.createQuery(hql);
		return (Usuario) consulta.uniqueResult();
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return this.sessao.createCriteria(Usuario.class).list();
	}
}
