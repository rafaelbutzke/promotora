package br.com.rcbsystens.promotora.model.propostaweb;

import java.util.Date;
import java.util.List;

public interface PropostaWebDao2 {
	
	public void salvar(PropostaWeb proposta);
	public List<PropostaWeb> listaGeralPorpostas();
	public List<PropostaWeb> pesquisaPropostasPorCpf(String cpf);
	public List<PropostaWeb> pesquisaPropostasPorNome(String nome);
	public List<PropostaWeb> listaPropostaPorIntervalo(Date inicio, Date fim);
	public PropostaWeb pesquisaPropostaPorId(Long id);
}
