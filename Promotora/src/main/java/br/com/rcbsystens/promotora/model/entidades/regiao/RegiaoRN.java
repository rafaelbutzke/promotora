package br.com.rcbsystens.promotora.model.entidades.regiao;

import java.util.List;

import br.com.rcbsystens.promotora.model.dao.hibernate.DaoFactory;

public class RegiaoRN {
	
	private RegiaoDao regiaoDao;
	
	public RegiaoRN(){
		this.regiaoDao = DaoFactory.criarRegiaoDao();
	}

	public void salvar(Regiao regiao) {
		this.regiaoDao.salvar(regiao);
	}
	
	public void atualizar(Regiao regiao) {
		this.regiaoDao.atualizar(regiao);
		
	}
	
	public Regiao carregar(Long id) {
		return this.regiaoDao.carregar(id);
	}

	public List<Regiao> listar() {
		return this.regiaoDao.listar();
	}
}
