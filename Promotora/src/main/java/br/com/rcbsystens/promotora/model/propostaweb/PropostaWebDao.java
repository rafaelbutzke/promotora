package br.com.rcbsystens.promotora.model.propostaweb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rcbsystens.promotora.model.dao.JpaUtil;
import br.com.rcbsystens.promotora.model.dao.hibernate.HibernateUtil;

public class PropostaWebDao {
	
	public void salvar(PropostaWeb proposta){
		EntityManager manager = JpaUtil.getEntityManager();
		Long verificaId = new Long(0);
		verificaId = proposta.getId();
		try {
			manager.getTransaction().begin();
			if(verificaId == null){
				manager.persist(proposta);
			} else {
				manager.merge(proposta);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Não foi possivel salvar proposta. Erro: ");
			e.printStackTrace();
			manager.getTransaction().rollback();
		}finally{
			manager.close();			
		}
	}
	public List<PropostaWeb> ListaPorpostas(){
		List<PropostaWeb> propostas = new ArrayList<PropostaWeb>();
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Query query = manager.createNamedQuery("PropostaWeb.ListaTotal");
			propostas = (List<PropostaWeb>)query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao listar todoas as propostas!" + e.getMessage());
		}finally {
			manager.close();
		}
		return propostas;
	}
	public List<PropostaWeb> pesquisaPropostasPorCpf(String cpf){
		List<PropostaWeb> retornoPesquisa = new ArrayList<PropostaWeb>();
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Query query = manager.createNamedQuery("PropostaWeb.PesquisaPorCpf");
			query.setParameter("cpf", cpf);
			retornoPesquisa = (List<PropostaWeb>)query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			manager.close();
		}
		return retornoPesquisa;
	}
	public List<PropostaWeb> pesquisaPropostasPorNome(String nome){
		List<PropostaWeb> retornoPesquisa = new ArrayList<PropostaWeb>();
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Query query = manager.createNamedQuery("PropostaWeb.PesquisaPorNome");
			query.setParameter("nome", nome);
			retornoPesquisa = (List<PropostaWeb>)query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			manager.close();
		}
		return retornoPesquisa;
	}
	public PropostaWeb pesquisaPropostaPorId(Long id){
		PropostaWeb proposta = new PropostaWeb();
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Query query = manager.createNamedQuery("PropostaWeb.PesquisaPorId");
			query.setParameter("id", id);
			proposta =(PropostaWeb)query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erro ao excutar pesquisa de Proposta por id: " + e.getMessage());
		}finally{
			manager.close();
		}
		return proposta;
	}
	
}
