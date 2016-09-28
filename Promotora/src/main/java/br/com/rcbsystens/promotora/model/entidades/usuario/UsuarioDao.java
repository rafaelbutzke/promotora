package br.com.rcbsystens.promotora.model.entidades.usuario;

import java.util.List;

public interface UsuarioDao {
	public void salvar(Usuario usuario);
	public void atualizar(Usuario usuario);
	public void desativar(Usuario usuario);
	public Usuario carregar(Long id);
	public Usuario buscaPorLogin(String login);
	public List<Usuario> listar();

}
