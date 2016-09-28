package br.com.rcbsystens.promotora.model.entidades.tabelas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import br.com.rcbsystens.promotora.model.entidades.tabelas.prazo.Prazo;
@NamedQueries({
	@NamedQuery(name="Tabelas.retornaTodos", query = "SELECT t FROM Tabelas t"),
	@NamedQuery(name="Tabelas.buscaAno", query = "SELECT t FROM Tabelas t WHERE t.modeloFinal >= :ano AND t.modeloInicial <= :ano"),
	@NamedQuery(name="Tabelas.buscaTabelasAtivas", query = "SELECT t FROM Tabelas t WHERE t.vigencia >= :dataAtual")
})
@Entity
public class Tabelas implements Serializable {
	private static final long serialVersionUID = 2493755636141625933L;
	@Id @GeneratedValue
	private Long id; 
	@Column(unique=true)
	private String codigo; 
	private int modeloInicial;
	private int modeloFinal;
	private Boolean zeroKm;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn
	private List<Prazo> prazos = new ArrayList<Prazo>();
	@Temporal(TemporalType.DATE)
	private Date vigencia;
	
	//Construtor público sem parametos para implementação JPA; 
	public Tabelas(){}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo.toUpperCase();
	}
	public int getModeloInicial() {
		return modeloInicial;
	}
	public void setModeloInicial(int modeloInicial) {
		this.modeloInicial = modeloInicial;
	}
	public int getModeloFinal() {
		return modeloFinal;
	}
	public void setModeloFinal(int modeloFinal) {
		this.modeloFinal = modeloFinal;
	}
	public Boolean getZeroKm() {
		return zeroKm;
	}
	public void setZeroKm(Boolean zeroKm) {
		this.zeroKm = zeroKm;
	}
	public List<Prazo> getPrazos() {
		return prazos;
	}
	public void setPrazos(List<Prazo> prazos) {
		this.prazos = prazos;
	}
	public Date getVigencia() {
		return vigencia;
	}
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + modeloFinal;
		result = prime * result + modeloInicial;
		result = prime * result + ((prazos == null) ? 0 : prazos.hashCode());
		result = prime * result
				+ ((vigencia == null) ? 0 : vigencia.hashCode());
		result = prime * result + ((zeroKm == null) ? 0 : zeroKm.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tabelas other = (Tabelas) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id != other.id)
			return false;
		if (modeloFinal != other.modeloFinal)
			return false;
		if (modeloInicial != other.modeloInicial)
			return false;
		if (prazos == null) {
			if (other.prazos != null)
				return false;
		} else if (!prazos.equals(other.prazos))
			return false;
		if (vigencia == null) {
			if (other.vigencia != null)
				return false;
		} else if (!vigencia.equals(other.vigencia))
			return false;
		if (zeroKm == null) {
			if (other.zeroKm != null)
				return false;
		} else if (!zeroKm.equals(other.zeroKm))
			return false;
		return true;
	}
}
