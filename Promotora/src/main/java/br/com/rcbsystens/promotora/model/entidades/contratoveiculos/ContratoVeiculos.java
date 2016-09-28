package br.com.rcbsystens.promotora.model.entidades.contratoveiculos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.rcbsystens.promotora.model.entidades.instituicao.Instituicao;
import br.com.rcbsystens.promotora.model.entidades.loja.Loja;
import br.com.rcbsystens.promotora.model.entidades.veiculo.Veiculo;
import br.com.rcbsystens.promotora.model.imutaveis.TipoDeContrato;
import br.com.rcbsystens.promotora.model.imutaveis.TipoPessoa;

public class ContratoVeiculos {
	private long id;
	private String proposta;
	private String numeroContrato;
	@Enumerated(EnumType.STRING)
	@JoinColumn
	private TipoDeContrato tipoDeContrato;
	@OneToOne (cascade={CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn
	private Instituicao instituicao;
	@OneToOne (cascade={CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn
	private Loja loja;
	@OneToOne (cascade={CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn
	private Operador operador;
	@OneToOne (cascade={CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn
	private Vendedor vendedor; 
	private Tabela tabela;
	private double valorContrato; 
	private double valorTac;
	private TipoPessoa tipoCliente; 
	private List<Cliente> clientes; 
	private List<Veiculo> veiculos; 
	private List<Parcela> parcelas;
	private List<ObservacoesPublicas> observacoesPublicas; 
	private List<ObservacoesPrivadas> observacoesPrivadas; 
	
	
}
