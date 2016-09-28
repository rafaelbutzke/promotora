package br.com.rcbsystens.promotora.model.entidades.pessoa;

import java.util.List;

public interface PessoaDao {
	public void salvar(Pessoa pessoa);
	public void atualizar(Pessoa pessoa);
	public Pessoa carregar(Long idPessoa);
	public Pessoa buscaPorCpf(String cpf);
	public Pessoa buscaPorCnpj(String cnpj);
	public List<Pessoa> buscaPorNome(String nome);
	public List<Pessoa> buscaPorRazaoSocial(String razaoSocial);
}
