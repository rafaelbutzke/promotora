package br.com.rcbsystens.promotora.model.propostaweb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.rcbsystens.promotora.model.dao.CepDao;
import br.com.rcbsystens.promotora.model.email.Email;
import br.com.rcbsystens.promotora.model.entidades.NumeroFormatado;
import br.com.rcbsystens.promotora.model.entidades.enderecos.Enderecos;
import br.com.rcbsystens.promotora.model.entidades.tabelas.Tabelas;
import br.com.rcbsystens.promotora.model.entidades.tabelas.TabelasDao;
import br.com.rcbsystens.promotora.model.imutaveis.ClassificacaoLocalTrabalho;
import br.com.rcbsystens.promotora.model.imutaveis.Escolaridade;
import br.com.rcbsystens.promotora.model.imutaveis.EstadoCivil;
import br.com.rcbsystens.promotora.model.imutaveis.Estados;
import br.com.rcbsystens.promotora.model.imutaveis.Nacionalidade;
import br.com.rcbsystens.promotora.model.imutaveis.RelacaoBancos;
import br.com.rcbsystens.promotora.model.imutaveis.Retorno;
import br.com.rcbsystens.promotora.model.imutaveis.Sexo;
import br.com.rcbsystens.promotora.model.imutaveis.StatusPropostaWeb;
import br.com.rcbsystens.promotora.model.imutaveis.TipoResidencia;
import br.com.rcbsystens.promotora.model.imutaveis.TipoVeiculo;
import br.com.rcbsystens.promotora.model.pdf.PropostaWebEmPdf;

@ManagedBean(name="propostaBean")
@SessionScoped
public class PropostaBean implements Serializable{
	private static final long serialVersionUID = -6182597447468577899L;

	private PropostaWeb proposta = new PropostaWeb();
	private Enderecos endereco;
	private CepDao consultaCep = new CepDao();
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private DateFormat dfSemHora = new SimpleDateFormat("dd/MM/yyyy");
	private NumeroFormatado numeroFormatado = new NumeroFormatado();
	private TabelasDao buscaTabela = new TabelasDao();
	private List<String> parcelas = new ArrayList<String>();
	private String processando = new String();
	private String cpfPesquisa;
	private String nomePesquisa;
	private List<PropostaWeb> listaPequisada = new ArrayList<PropostaWeb>();
	private StringBuffer simulacao = new StringBuffer();

	public void pesquisaPropostasPorCpf() {
		String cpf = getCpfPesquisa();
		listaPequisada = new PropostaWebRN().pesquisaPorCpf(cpf);
		setCpfPesquisa(new String());
		setNomePesquisa(new String());
	}

	public void pesquisaPropostaPorNome() {
		String nome = getNomePesquisa();
		System.out.println("Nome: " + nome);
		listaPequisada = new PropostaWebRN().pesquisaPorNome(nome);
		setCpfPesquisa(new String());
		setNomePesquisa(new String());
	}

	public void pesquisaPropostaTotal() {
		listaPequisada = new PropostaWebRN().listaTotal();
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public PropostaWeb getProposta() {
		return proposta;
	}

	public void setProposta(PropostaWeb proposta) {
		this.proposta = proposta;
	}

	public String getProcessando() {
		return processando;
	}

	public void setProcessando(String processando) {
		this.processando = processando;
	}

	public List<String> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<String> parcelas) {
		this.parcelas = parcelas;
	}

	public StringBuffer getSimulacao() {
		return simulacao;
	}

	public void setSimulacao(StringBuffer simulacao) {
		this.simulacao = simulacao;
	}

	public TipoVeiculo[] getTipoVeiculos() {
		return TipoVeiculo.values();
	}

	public Retorno[] getRetornos() {
		return Retorno.values();
	}

	public Estados[] getEstados() {
		return Estados.values();
	}

	public Nacionalidade[] getNacionalidades() {
		return Nacionalidade.values();
	}

	public Sexo[] getSexos() {
		return Sexo.values();
	}

	public EstadoCivil[] getEstadoCivils() {
		return EstadoCivil.values();
	}

	public Escolaridade[] getEscolariadades() {
		return Escolaridade.values();
	}

	public TipoResidencia[] getTipoResidencias() {
		return TipoResidencia.values();
	}

	public ClassificacaoLocalTrabalho[] getClassificacaoLocalTrabalhos() {
		return ClassificacaoLocalTrabalho.values();
	}

	public RelacaoBancos[] getRelacaoBancos() {
		return RelacaoBancos.values();
	}

	public StatusPropostaWeb[] getStatusPropostaWeb(){
		return StatusPropostaWeb.values();
	}
	
	public void chamaProposta() {
		System.out.println(proposta.getTipoVeiculo());
	}

	public String getCpfPesquisa() {
		return cpfPesquisa;
	}

	public void setCpfPesquisa(String cpfPesquisa) {
		this.cpfPesquisa = cpfPesquisa;
	}

	public List<PropostaWeb> getListaPequisada() {
		return listaPequisada;
	}

	public void setListaPequisada(List<PropostaWeb> listaPequisada) {
		this.listaPequisada = listaPequisada;
	}
	
	public void buscaCep() {
		String cep = proposta.getResCep();
		endereco = consultaCep.Consulta(cep);
		if (endereco.getLogradouro() != null) {
			proposta.setResLogradouro(endereco.getLogradouro());
			proposta.setResBairro(endereco.getBairro());
			proposta.setResCidade(endereco.getCidade());
			proposta.setResUf(endereco.getEstado());
		}
	}

	public void informacaoEstadoCivil() {
		if (proposta.getEstadoCivilCliente().toString().equals("Casado")
				|| proposta.getEstadoCivilCliente().toString().equals("União Estavel")) {
			FacesContext context1 = FacesContext.getCurrentInstance();
			context1.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Estado Civil selecionado: " + proposta.getEstadoCivilCliente()
									.toString(),
					"Esta opção de estado civil selecionado, clik na aba conjuge e preencha os dados de seu companheiro!!!"));
		}
	}

	public void buscaCepComercial() {
		String cep2 = proposta.getComCep();
		Enderecos enderecoComercial = new Enderecos();
		enderecoComercial = consultaCep.Consulta(cep2);
		if (enderecoComercial.getLogradouro() != null) {
			proposta.setComLogradouro(enderecoComercial.getLogradouro());
			proposta.setComBairro(enderecoComercial.getBairro());
			proposta.setComCidade(enderecoComercial.getCidade());
			proposta.setComUf(enderecoComercial.getEstado());
		}
	}

	public void buscaCepComercialConjugue() {
		String cep3 = proposta.getComCep();
		Enderecos enderecoComercialConjugue = new Enderecos();
		enderecoComercialConjugue = consultaCep.Consulta(cep3);
		if (enderecoComercialConjugue.getLogradouro() != null) {
			proposta.setComLogradouro(enderecoComercialConjugue.getLogradouro());
			proposta.setComBairro(enderecoComercialConjugue.getBairro());
			proposta.setComCidade(enderecoComercialConjugue.getCidade());
			proposta.setComUf(enderecoComercialConjugue.getEstado());
		}
	}

	public void calculaValorFinanciado() {
		BigDecimal valorFinanciadoComEncargos;
		System.out.println(System.getProperty("user.name") + ": " + System.getProperty("user.home"));
		parcelas = new ArrayList<String>();
		BigDecimal tarifasBanco = new BigDecimal("1640.00");
		if (proposta.getTipoVeiculo() == null) {
			proposta.setTipoVeiculo(TipoVeiculo.USADO);
		}

		System.out.println(
				"Varlor compra: " + proposta.getValorCompra() + " Valor entrada: " + proposta.getValorEntrada());
		if (proposta.getValorCompra().doubleValue() != 0 && proposta.getValorEntrada().doubleValue() != 0) {

			BigDecimal valor1 = new BigDecimal(proposta.getValorCompra().toString());
			BigDecimal valor2 = new BigDecimal(proposta.getValorEntrada().toString());
			proposta.setValorFinanciado(valor1.subtract(valor2));
			System.out.println("Propsota id: "+ proposta.getId() + " Valor financiado: " + proposta.getValorFinanciado());
			

			if (proposta.getValorFinanciado().doubleValue() < 3000) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Valor financiado inferior ao mínimo de R$3.000,00.",
								"Infelizmente não financiamos valores inferiores a R$3.000,00!"));
			} else if (proposta.getValorFinanciado().doubleValue() <= 0) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Verifique seus dados!",
						"Valor da entrada, maior ou igual a valor da compra!"));
			}

			valorFinanciadoComEncargos = new BigDecimal(proposta.getValorFinanciado().toString());
			valorFinanciadoComEncargos = valorFinanciadoComEncargos.add(new BigDecimal(tarifasBanco.toString()));
			int ano = Integer.parseInt(proposta.getModelo());
			List<Tabelas> tab = new ArrayList<Tabelas>();

			boolean zero = false;
			System.out.println(proposta.getTipoVeiculo());
			System.out.println(proposta.getRetorno());

			if (proposta.getTipoVeiculo().toString().equals("Novo")) {
				valorFinanciadoComEncargos = valorFinanciadoComEncargos.subtract(new BigDecimal("350"));
				zero = true;
			} else if (proposta.getTipoVeiculo().toString().equals("Usado")) {
				zero = false;
			}

			if (proposta.getRetorno() == null) {
				proposta.setRetorno(Retorno.RTRES);
			}

			if (buscaTabela.consultaTabelaPorAno(ano) != null) {
				tab = buscaTabela.consultaTabelaPorAno(ano);
				for (int t = 0; t < tab.size(); t++) {
					System.out.println(" ");
					System.out.println("Codigo: " + tab.get(t).getCodigo() + " Prazos: " + tab.get(t).getPrazos().size()
							+ " De: " + tab.get(t).getModeloInicial() + " a " + tab.get(t).getModeloFinal());

					for (int i = 0; i < tab.get(t).getPrazos().size(); i++) {
						System.out.println("Prazo " + tab.get(t).getPrazos().get(i).getPrazo().toString() + " Entrada: "
								+ tab.get(t).getPrazos().get(i).getPercentualEntrada().multiply(new BigDecimal("100")));

						for (int j = 0; j < tab.get(t).getPrazos().get(i).getPlanos().size(); j++) {
							if (tab.get(t).getPrazos().get(i).getPlanos().get(j).getRetorno().toString()
									.equals(proposta.getRetorno().toString()) && tab.get(t).getZeroKm().equals(zero)
									&& proposta.getRetorno().toString().equals(
											tab.get(t).getPrazos().get(i).getPlanos().get(j).getRetorno().toString())) {
								StringBuffer coeficientes = new StringBuffer();
								coeficientes.append(tab.get(t).getPrazos().get(i).getPrazo().toString());
								coeficientes.append(" X R$ ");
								BigDecimal parcela = new BigDecimal("0");
								parcela = tab.get(t).getPrazos().get(i).getPlanos().get(j).getCoeficiente()
										.multiply(valorFinanciadoComEncargos);
								coeficientes.append(numeroFormatado.comDuasCasasDecimais(parcela).toString());
								coeficientes.append(" Parcela exclusiva pela Sul Financeira!");
								System.out.println(coeficientes);
								parcelas.add(coeficientes.toString());
							}
						}
					}
				}
			}
		}
	}

	public String enviar() {
		PropostaWebEmPdf propostaEmPdf = new PropostaWebEmPdf();
		Email email = new Email();
		Date dataHora = new Date();
		String nomeDoArquivo = new String();
		PropostaWebDao propostaDao = new PropostaWebDao();
		proposta.setDataDeEnvio(dataHora);
		System.out.println("Status proposta web: " + proposta.getStatus());
		if (proposta.getStatus()==null) {
			proposta.setStatus(StatusPropostaWeb.DIGITADO);
		}
		System.out.println("Salvando proposta: " + proposta.getId() + " valor financiado: " + proposta.getValorFinanciado());
		propostaDao.salvar(proposta);
		nomeDoArquivo = (proposta.getNomeCliente() + df.format(dataHora));
		nomeDoArquivo = nomeDoArquivo.replaceAll(":", "");
		nomeDoArquivo = nomeDoArquivo.replaceAll(" ", "");
		nomeDoArquivo = nomeDoArquivo.replaceAll("/", "");
		System.out.println(nomeDoArquivo);
		propostaEmPdf.preencher(nomeDoArquivo, proposta);
		
		/**
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successo",
				"Proposta de: " + proposta.getNomeCliente() + " enviada em: " + df.format(dataHora) + "."));
		**/
		String menssagem = new String();
		menssagem = proposta.getInformacoes();

		String destinatario = new String(
				"real.df@bbpromotora.com.br,propostas@rcbsystems.com.br,ligia@bbpromotora.com.br");
		if (proposta.getEmailVendedor() != null) {
			destinatario = destinatario + "," + proposta.getEmailVendedor();
		}
		String tilulo = new String("Proposta de: " + proposta.getNomeCliente() + " CPF: " + proposta.getCpfCliente()
				+ " enviada em: " + df.format(dataHora));
		System.out.println("Destinatario: " + destinatario);
		System.out.println("Titulo: " + tilulo);
		System.out.println("Mensagem: " + menssagem);
		System.out.println("Arquivo: " +System.getProperty("user.home") + "/promotora-tv1/" + nomeDoArquivo + ".pdf");
		email.enviarEmailComArquivo(destinatario, tilulo, menssagem, System.getProperty("user.home") + "/promotora-tv1/" + nomeDoArquivo + ".pdf");
		System.out.println("Proposta enviada em: " + df.format(dataHora));
		System.out.println("Nome: " + proposta.getNomeCliente());
		return "enviada";
	}

	public String redirecionaCadastroProposta(){
		System.out.println("Passou pelo redirecionar proposta...");
		calculaValorFinanciado();
		return "proposta";
	}
	
	public String novaProposta(){
		proposta = new PropostaWeb();
		pesquisaPropostaTotal();
		return "esteira";
	}
	public void onPropostaSelecionada(SelectEvent evento) {
		proposta = (PropostaWeb) evento.getObject();
		proposta = new PropostaWebDao().pesquisaPropostaPorId(proposta.getId());
		System.out.println("Passou pelo onPropostaSelecionada...");
	}
}
