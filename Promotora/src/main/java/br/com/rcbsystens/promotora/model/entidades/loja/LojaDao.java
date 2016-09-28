package br.com.rcbsystens.promotora.model.entidades.loja;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rcbsystens.promotora.model.dao.JpaUtil;
import br.com.rcbsystens.promotora.model.entidades.regiao.Regiao;

public class LojaDao {
	public void Salvar(Loja loja){
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			manager.getTransaction().begin();
			if (loja.getId()==null){
				manager.persist(loja);	
			}else{
				manager.merge(loja);
			}
			
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("Erro ao tentar salvar Loja: "+ e.getMessage());
		} finally{
			manager.close();
		}
	}
	public Loja PesquisaLojaPorId(long codigo){
		Loja loja = new Loja();
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Query query = manager.createNamedQuery("Loja.PesquisaPorId");
			query.setParameter("id", codigo);
			loja = (Loja) query.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Erro ao consultar Loja por Id" + e.getMessage());
		} finally{
			manager.close();
		}
		return loja;
	}
	
	public List<Loja> ListaCompletaOrdenadaPorRegiao(){
		List<Loja> lojas = new ArrayList<Loja>();
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Query query = manager.createNamedQuery("Loja.ListaCompletaPorRegiao");
			lojas = (List<Loja>) query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao consultar lista completeta de lojas: " + e.getMessage());
		}finally{
			manager.close();
		}
		return lojas;
	}
	
	public List<Loja> PesquisaLojasPorRegiao(Long idRegiao){
		List<Loja> lojas = new ArrayList<Loja>();
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Query query = manager.createNamedQuery("Loja.ListaPorRegiao");
			query.setParameter("idRegiao", idRegiao);
			lojas =(List<Loja>) query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao consultar Lojas por Regiao: "+ e.getMessage());
		}finally{
			manager.close();
		}
		return lojas;
	}

}
