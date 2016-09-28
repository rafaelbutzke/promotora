package br.com.rcbsystens.promotora.model.entidades.regiao;

import java.util.List;

public interface RegiaoDao {
	public void salvar(Regiao regiao);
	public void atualizar(Regiao regiao);
	public Regiao carregar(Long id);
	public List<Regiao> listar();
}
