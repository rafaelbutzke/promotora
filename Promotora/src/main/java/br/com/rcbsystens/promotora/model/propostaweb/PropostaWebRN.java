package br.com.rcbsystens.promotora.model.propostaweb;

import java.util.List;

import br.com.rcbsystens.promotora.model.dao.hibernate.DaoFactory;

public class PropostaWebRN {
	private PropostaWebDao2 propostaWebDao2;
	
	public PropostaWebRN() {
		this.propostaWebDao2=DaoFactory.criarPropostaWebDao();
	}
	
	public List<PropostaWeb> listaTotal(){
		return this.propostaWebDao2.listaGeralPorpostas();
	}
	
	public void salvarProposta(PropostaWeb proposta){
		this.propostaWebDao2.salvar(proposta);
	}
	
	public List<PropostaWeb> pesquisaPorNome(String nome){
		nome = "%" + nome + "%";
		if (!nome.equals("%%")) {
			return this.propostaWebDao2.pesquisaPropostasPorNome(nome);
		} else{
			return null;
		}
	}
	
	public List<PropostaWeb> pesquisaPorCpf(String cpf){
		return this.propostaWebDao2.pesquisaPropostasPorCpf(cpf);
	}
	
	
	
}
