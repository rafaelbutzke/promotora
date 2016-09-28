package br.com.rcbsystens.promotora.model.entidades.loja;

import java.util.List;

import br.com.rcbsystens.promotora.model.entidades.pessoa.PessoaDao;
import br.com.rcbsystens.promotora.model.entidades.pessoa.PessoaJuridica;
import br.com.rcbsystens.promotora.model.entidades.regiao.Regiao;
import br.com.rcbsystens.promotora.model.entidades.regiao.RegiaoDaoAnterior;

public class TestaLoja {
	public static void main(String[] args) {

		Loja loja = new Loja();
		Regiao regiao = new RegiaoDaoAnterior().BuscaPorId(new Long(2));
		System.out.println(regiao.getDescricao());
		loja.setRegiao(regiao);
		loja.setCodigoLoja("1012");
		PessoaJuridica pj = new PessoaJuridica();
		pj.setIdPessoa(9);
		pj.setCnpj("025.007.589-074");
		pj.setRazaoSocial("bb veiculos");
		pj.setNomeFantasia("bb veiculos");
		new PessoaDao().Salvar(pj);
		loja.setPesssoaJuridica(pj);
		new LojaDao().Salvar(loja);

		//List<Loja> lojas = new LojaDao().PesquisaLojasPorRegiao(new Long(1));
		List<Loja> lojas = new LojaDao().ListaCompletaOrdenadaPorRegiao();
		Long verifica = new Long(0);
		for (int i = 0; i < lojas.size(); i++) {
			if (!verifica.equals(lojas.get(i).getRegiao().getId())){
				verifica = lojas.get(i).getRegiao().getId();
				System.out.println("Regiao: "+lojas.get(i).getRegiao().getDescricao());	
			}
			System.out.println("Codigo: " +lojas.get(i).getCodigoLoja()+" Nome: " + lojas.get(i).getPesssoaJuridica().getRazaoSocial());
		}
		
	}

}
