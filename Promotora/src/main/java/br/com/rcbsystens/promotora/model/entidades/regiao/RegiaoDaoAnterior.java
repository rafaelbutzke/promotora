package br.com.rcbsystens.promotora.model.entidades.regiao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rcbsystens.promotora.model.dao.JpaUtil;

public class RegiaoDaoAnterior {
	
	public void Salvar(Regiao regiao){
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			manager.getTransaction().begin();
			if(regiao.getId()==null){
				System.out.println("Tentando salvar...");
				manager.persist(regiao);
			} else{
				System.out.println("Tentando atualiza...");
				manager.merge(regiao);
			} 
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("Erro ao salvar Regiao: " + e.getMessage());
		}finally {
			manager.close();
		}
	}
	
	public Regiao BuscaPorId(Long idRegiao){
		Regiao regiao = new Regiao(); 
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Query query = manager.createNamedQuery("Regiao.BuscaPorId");
			query.setParameter("id", idRegiao);
			regiao = (Regiao)query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erro ao comsultar Regiao por id: " + e.getMessage());
		}finally {
			manager.close();
		}
		return regiao;
	}

	public List<Regiao> ListaCompleta(){
		List<Regiao> regioes = new ArrayList<Regiao>();
			EntityManager manager = JpaUtil.getEntityManager();
			try {
				Query query = manager.createNamedQuery("Regiao.ListaCompleta");
				regioes = query.getResultList();
			} catch (Exception e) {
				System.out.println("Erro ao listar Regioes: " + e.getMessage());
			}finally {
				manager.close();
			}
		return regioes;
	} 
}
