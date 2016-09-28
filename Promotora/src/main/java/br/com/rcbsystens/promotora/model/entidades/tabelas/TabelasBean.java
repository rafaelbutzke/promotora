package br.com.rcbsystens.promotora.model.entidades.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.rcbsystens.promotora.model.imutaveis.Prazos;
import br.com.rcbsystens.promotora.model.imutaveis.Retorno;

@ManagedBean
@ViewScoped
public class TabelasBean {
	private TabelasDao tabelasDao = new TabelasDao();
	private Tabelas tabelaSelecionada = new Tabelas();
	private List<Tabelas> todasTabelas = new ArrayList<Tabelas>();
	
	@PostConstruct
	public void init(){
		System.out.println("iniciou....");
		todasTabelas = tabelasDao.consultaTodasAsTabelas();
	}

//	public void buscaTabelas(){
//		System.out.println("Busca tabelas.... ");
//		todasTabelas = tabelasDao.consultaTodasAsTabelas();
//	}
	
	
	public Tabelas getTabelaSelecionada() {
		return tabelaSelecionada;
	}

	public void setTabelaSelecionada(Tabelas tabelaSelecionada) {
		this.tabelaSelecionada = tabelaSelecionada;
	}

	public List<Tabelas> getTodasTabelas() {
		return todasTabelas;
	}

	public void setTodasTabelas(List<Tabelas> todasTabelas) {
		this.todasTabelas = todasTabelas;
	}
		
	public void onTabelaSelecionada(SelectEvent evento){
		setTabelaSelecionada((Tabelas) evento.getObject());
		System.out.println(tabelaSelecionada.getCodigo());
		System.out.println(tabelaSelecionada.getPrazos().get(0).getPlanos().get(0).getRetorno().toString());
	}
	
	public Retorno[] getRetornos(){
		return Retorno.values();
	}
	
	public Prazos[] getPrazos(){
		return Prazos.values();
	}
	
	public void salvaTabela(){
		System.out.println("Salvando... ");
		tabelasDao.salvar(tabelaSelecionada);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(
				null,
				new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Tabela alterada!" ,
						tabelaSelecionada.getCodigo().toString() +" alterada."));
		tabelaSelecionada = new Tabelas();
	}
	
	public void cancelaAlteracao(){
		System.out.println("Cancelando... ");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(
				null,
				new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Alteração cancelada!" ,
						tabelaSelecionada.getCodigo().toString() +" não alterada."));
		tabelaSelecionada = new Tabelas();
	}
}
