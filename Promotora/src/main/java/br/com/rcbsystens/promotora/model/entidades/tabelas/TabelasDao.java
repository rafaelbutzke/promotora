package br.com.rcbsystens.promotora.model.entidades.tabelas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rcbsystens.promotora.model.dao.JpaUtil;

public class TabelasDao {
	public void salvar(Tabelas tabela){
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			manager.getTransaction().begin();
			if(tabela.getId()==null){
				manager.persist(tabela);	
			}else{
				manager.merge(tabela);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("Não foi possivel salvar tabela. Erro: ");
			e.printStackTrace();
		}finally{
			manager.close();			
		}
	}

	public void expirar(Tabelas tabela){
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Date dataExpira = new Date();
			tabela.setVigencia(dataExpira);
			manager.getTransaction().begin();
			manager.merge(tabela);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Não foi possível expirar tabela" + e.getMessage());
		}finally{
			manager.close();
		}
	}
	
	public List<Tabelas> consultaTabelaPorAno(int ano){
		List<Tabelas> tabelas = new ArrayList<Tabelas>();
		EntityManager manager=JpaUtil.getEntityManager();
		try {
			Query query = manager.createNamedQuery("Tabelas.buscaAno");
			query.setParameter("ano", ano);
			tabelas = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao retorna consulta Tabelas por ano. Erro: "+e.getMessage());
		}finally{
			manager.close();
		}
		return tabelas;
	}
	
	public List<Tabelas> consultaTodasAsTabelas(){
		List<Tabelas> tabelas = new ArrayList<Tabelas>();
		EntityManager manager=JpaUtil.getEntityManager();
		try {
			Query query = manager.createNamedQuery("Tabelas.retornaTodos");
			tabelas = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao retorna consulta Tabelas. Erro: "+e.getMessage());
		}finally{
			manager.close();
		}
		return tabelas;
	}
	
	public List<Tabelas> consultaTabelasAtivas(){
		List<Tabelas> tabelas = new ArrayList<Tabelas>();
		Date data = new Date();
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Query query = manager.createNamedQuery("Tabelas.buscaTabelasAtivas");
			query.setParameter("dataAtual", data);
			tabelas = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao retornar tabelas ativas. Erro "+e.getMessage());
		} finally{
			manager.close();
		}
		return tabelas;
	}
}
