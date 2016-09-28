package br.com.rcbsystens.promotora.model.entidades.regiao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
public class RegiaoBean {
	Regiao regiao = new Regiao();
	RegiaoRN regiaoRN = new RegiaoRN();

	public List<Regiao> getRegioes(){
		return this.regiaoRN.listar();
	}

}
