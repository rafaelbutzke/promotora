package br.com.rcbsystens.promotora.model.entidades.regiao;

import java.util.List;

import org.hibernate.Session;

public class RegiaoDaoHibernate implements RegiaoDao{
	private Session sessao;
	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}
	@Override
	public void salvar(Regiao regiao) {
		// TODO Auto-generated method stub
		this.sessao.save(regiao);
	}
	@Override
	public void atualizar(Regiao regiao) {
		// TODO Auto-generated method stub
		this.sessao.update(regiao);
	}
	@Override
	public Regiao carregar(Long id) {
		// TODO Auto-generated method stub
		return (Regiao) this.sessao.get(Regiao.class, id);
	}
	@Override
	public List<Regiao> listar() {
		// TODO Auto-generated method stub
		return (List<Regiao>) this.sessao.createCriteria(Regiao.class).list();
	}
}
