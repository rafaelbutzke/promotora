package br.com.rcbsystens.promotora.model.entidades.pessoa;

import java.util.List;

import br.com.rcbsystens.promotora.model.dao.hibernate.DaoFactory;
import br.com.rcbsystens.promotora.model.imutaveis.TipoPessoa;

public class PessoaRN {
	private PessoaDao pessoaDao;
	public PessoaRN() {
		// TODO Auto-generated constructor stub
		this.pessoaDao = DaoFactory.criarPessoaDao();
	}

	public Pessoa carregar(Long idPessoa){
		if(this.pessoaDao.carregar(idPessoa).getTipoPessoa().equals(TipoPessoa.F)){
			return (PessoaFisica) this.pessoaDao.carregar(idPessoa);
		}else if(this.pessoaDao.carregar(idPessoa).getTipoPessoa().equals(TipoPessoa.J)){
			return (PessoaJuridica) this.pessoaDao.carregar(idPessoa);
		}else{
			System.out.println("Pessoa não encontrada!");
			return null;
		}
	}

	public void salvar(Pessoa pessoa) {
		this.pessoaDao.salvar(pessoa);
	}

	public void atualizar(Pessoa pessoa) {
		this.pessoaDao.atualizar(pessoa);
	}

	public Pessoa buscaPorCpf(String cpf) {
		return (PessoaFisica)this.pessoaDao.buscaPorCpf(cpf);
	}

	public Pessoa buscaPorCnpj(String cnpj) {
		return (PessoaJuridica)this.pessoaDao.buscaPorCnpj(cnpj);
	}

	public List<Pessoa> buscaPorNome(String nome) {
		return (List<Pessoa>) this.pessoaDao.buscaPorNome(nome);
	}

	public List<Pessoa> buscaPorRazaoSocial(String razaoSocial) {
		return (List<Pessoa>) this.pessoaDao.buscaPorRazaoSocial(razaoSocial);
	}

}
