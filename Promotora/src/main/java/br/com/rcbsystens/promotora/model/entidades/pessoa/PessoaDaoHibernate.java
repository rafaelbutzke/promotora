package br.com.rcbsystens.promotora.model.entidades.pessoa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class PessoaDaoHibernate implements PessoaDao {
	private Session sessao;

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public void salvar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		this.sessao.save(pessoa);

	}

	@Override
	public void atualizar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		this.sessao.update(pessoa);
	}

	@Override
	public Pessoa carregar(Long idPessoa) {
		// TODO Auto-generated method stub
		return (Pessoa) this.sessao.get(Pessoa.class, idPessoa);
	}

	@Override
	public Pessoa buscaPorCpf(String cpf) {
		// TODO Auto-generated method stub
		System.out.println(cpf);
		String hql = "select pf from PessoaFisica pf where pf.cpf = :cpf";
		Query consulta = this.sessao.createQuery(hql);
		consulta.setString("cpf", cpf);
		System.out.println(consulta.uniqueResult());
		if (consulta.uniqueResult() != null) {
			System.out.println("Retornou diferente de null!");
			return (PessoaFisica) consulta.uniqueResult();
		} else {
			System.out.println("Retornou nulo!");
			return (PessoaFisica) new PessoaFisica();
		}
	}

	@Override
	public Pessoa buscaPorCnpj(String cnpj) {
		// TODO Auto-generated method stub
		String hql = "select pj from PessoaJuridica pj where pj.cnpj = :cnpj";
		Query consulta = this.sessao.createQuery(hql);
		consulta.setString("cnpj", cnpj);
		return (Pessoa) consulta.uniqueResult();
	}

	@Override
	public List<Pessoa> buscaPorNome(String nome) {
		// TODO Auto-generated method stub
		String hql = "select pf from PessoaFisica pf where pf.nome like :nome";
		Query consulta = this.sessao.createQuery(hql);
		consulta.setString("nome", ("%" + nome + "%"));
		return (List<Pessoa>) consulta.list();
	}

	@Override
	public List<Pessoa> buscaPorRazaoSocial(String razaoSocial) {
		// TODO Auto-generated method stub
		String hql = "select pj from PessoaJuridica pj where pj.razaoSocial like :razaoSocial";
		Query consulta = this.sessao.createQuery(hql);
		consulta.setString("razaoSocial", ("%" + razaoSocial + "%"));
		return (List<Pessoa>) consulta.list();
	}

}
