package br.com.rcbsystens.promotora.model.dao.hibernate;

import br.com.rcbsystens.promotora.model.entidades.enderecos.CepDao;
import br.com.rcbsystens.promotora.model.entidades.enderecos.CepDaoHibernate;
import br.com.rcbsystens.promotora.model.entidades.pessoa.PessoaDao;
import br.com.rcbsystens.promotora.model.entidades.pessoa.PessoaDaoHibernate;
import br.com.rcbsystens.promotora.model.entidades.regiao.RegiaoDao;
import br.com.rcbsystens.promotora.model.entidades.regiao.RegiaoDaoHibernate;
import br.com.rcbsystens.promotora.model.entidades.usuario.UsuarioDao;
import br.com.rcbsystens.promotora.model.entidades.usuario.UsuarioDaoHibernate;
import br.com.rcbsystens.promotora.model.propostaweb.PropostaDaoHibernate;
import br.com.rcbsystens.promotora.model.propostaweb.PropostaWebDao2;

public class DaoFactory {
	public static UsuarioDao criarUsuarioDao() {
		UsuarioDaoHibernate usuarioDao = new UsuarioDaoHibernate();
		usuarioDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDao; 
	}
	public static PessoaDao criarPessoaDao(){
		PessoaDaoHibernate pessoaDao = new PessoaDaoHibernate();
		pessoaDao.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		return pessoaDao;
	}
	public static RegiaoDao criarRegiaoDao(){
		RegiaoDaoHibernate regiaoDao = new RegiaoDaoHibernate();
		regiaoDao.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		return regiaoDao;
	}
	public static PropostaWebDao2 criarPropostaWebDao(){
		PropostaDaoHibernate propostaDaoHibernate = new PropostaDaoHibernate();
		propostaDaoHibernate.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		return propostaDaoHibernate;
	}
	public static CepDao criarCepDao(){
		CepDaoHibernate cepDaoHibernate = new CepDaoHibernate();
		cepDaoHibernate.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		return cepDaoHibernate;
	}
}
