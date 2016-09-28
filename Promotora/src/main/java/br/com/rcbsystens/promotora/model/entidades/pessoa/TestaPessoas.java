package br.com.rcbsystens.promotora.model.entidades.pessoa;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.com.rcbsystens.promotora.model.dao.hibernate.DaoFactory;
import br.com.rcbsystens.promotora.model.dao.hibernate.HibernateUtil;
import br.com.rcbsystens.promotora.model.entidades.telefones.Telefones;
import br.com.rcbsystens.promotora.model.imutaveis.Nacionalidade;
import br.com.rcbsystens.promotora.model.imutaveis.TipoPessoa;
import br.com.rcbsystens.promotora.model.imutaveis.TipoTelefone;
import br.com.rcbsystens.promotora.web.filter.ConexaoHibernateFilter;

public class TestaPessoas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PessoaFisica pf = new PessoaFisica(); 
		PessoaJuridica pj = new PessoaJuridica();
		//List<Telefones> telefones = new ArrayList<Telefones>();
		Set<Telefones> telefones = new HashSet<Telefones>();
		Telefones tel1 = new Telefones();
		Telefones tel2 = new Telefones();
		
		tel1.setDdd("61");
		tel1.setTipoTelefone(TipoTelefone.CELULAR);
		tel1.setTelefone("82019697");

		tel2.setDdd("61");
		tel2.setTipoTelefone(TipoTelefone.RESIDENCIAL);
		tel2.setTelefone("30480215");

		telefones.add(tel1);
		telefones.add(tel2);
		
		pf.setCpf("025.007.589-07");
		pf.setNome("RAFAEL CRISTIANO BUTZKE2");
		pf.setNacionalidade(Nacionalidade.BRASILEIRO);
		pf.setTelefones(telefones);
		pf.setDataNascimento(new Date());
		pf.setMae("ADONIDA INES BUTZKE");
		pf.setPai("ARMANDO BUTZKE");
		pf.setTelefones(telefones);
		pf.setTipoPessoa(TipoPessoa.F);
		
		pj.setCnpj("07.924.497/0001-83");
		pj.setRazaoSocial("butzke e butzke");
		pj.setTelefones(telefones);
		pj.setTipoPessoa(TipoPessoa.J);
		
		PessoaDao pessoaDao;
		pessoaDao = DaoFactory.criarPessoaDao();
		
		Pessoa consulta = pessoaDao.buscaPorCnpj(pj.getCnpj());
		
		PessoaJuridica pj2 = (PessoaJuridica) consulta;
		
		System.out.println(pj2.getRazaoSocial());
		
		//System.out.println("Salvando PF.......");
		//pessaoDao.Salvar(pf);
		
		//System.out.println("Salvando PJ.......");
		//pessaoDao1.Salvar(pj);
		
		
		
	}

}
