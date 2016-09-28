package br.com.rcbsystens.promotora.model.propostaweb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.hibernate.Query;
import org.hibernate.Session;

public class PropostaDaoHibernate implements PropostaWebDao2 {
	private Session sessao;

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public void salvar(PropostaWeb proposta) {
		// TODO Auto-generated method stub
		try {
			this.sessao.save(proposta);
		} catch (Exception e) {
			System.out.println("Erro ao salvar proposta web, br.com.rcbsystens.promotora.model.propostaweb.PropsotaDaoHibernate.salvar: " + e.getMessage());
		}
	}

	@Override
	public List<PropostaWeb> listaGeralPorpostas() {
		// TODO Auto-generated method stub
		List<PropostaWeb> propostas = new ArrayList<PropostaWeb>();
		try {
			Query query = this.sessao.getNamedQuery("PropostaWeb.ListaTotal");
			propostas = query.list();
		} catch (Exception e) {
			System.out.println("Erro ao listar todoas as propostas, br.com.rcbsystens.promotora.model.propostaweb.PropsotaDaoHibernate.listaGeralProposta: " + e.getMessage());
		}
		return propostas;
	}

	@Override
	public List<PropostaWeb> pesquisaPropostasPorCpf(String cpf) {
		// TODO Auto-generated method stub
		List<PropostaWeb> propostas = new ArrayList<PropostaWeb>();
		try {
			Query query = this.sessao.getNamedQuery("PropostaWeb.PesquisaPorCpf");
			query.setString("cpf", cpf);
			propostas = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao listar todoas as propostas, br.com.rcbsystens.promotora.model.propostaweb.PropsotaDaoHibernate.pesquisaPropostaPorCpf: " + e.getMessage());
		}
		return propostas;
	}

	@Override
	public List<PropostaWeb> pesquisaPropostasPorNome(String nome) {
		// TODO Auto-generated method stub
		List<PropostaWeb> propostas = new ArrayList<PropostaWeb>();
		try {
			Query query = this.sessao.getNamedQuery("PropostaWeb.PesquisaPorNome");
			query.setString("nome", nome);
			propostas = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao listar todoas as propostas, br.com.rcbsystens.promotora.model.propostaweb.PropsotaDaoHibernate.pesquisaPropostaPorNome: " + e.getMessage());
		}
		return propostas;
	}

	@Override
	public List<PropostaWeb> listaPropostaPorIntervalo(Date inicio, Date fim) {
		// TODO Auto-generated method stub
		List<PropostaWeb> propostas = new ArrayList<PropostaWeb>();
		try {
			Query query = this.sessao.getNamedQuery("PropostaWeb.PesquisaPorPeriodo");
			query.setDate("dataInicial", inicio);
			query.setDate("dataFinal", fim);
			propostas = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return propostas;
	}

	@Override
	public PropostaWeb pesquisaPropostaPorId(Long id) {
		// TODO Auto-generated method stub
		PropostaWeb proposta = new PropostaWeb();
		try {
			Query query = this.sessao.getNamedQuery("PropostaWeb.PesquisaPorId");
			query.setLong("id", id);
			proposta = (PropostaWeb) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return proposta;
	}
	
}
