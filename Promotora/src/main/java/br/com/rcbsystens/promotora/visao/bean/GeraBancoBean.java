package br.com.rcbsystens.promotora.visao.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rcbsystens.promotora.model.entidades.tabelas.Tabelas;
import br.com.rcbsystens.promotora.model.entidades.tabelas.TabelasDao;
import br.com.rcbsystens.promotora.model.entidades.tabelas.prazo.Prazo;
import br.com.rcbsystens.promotora.model.entidades.tabelas.prazo.planos.Planos;
import br.com.rcbsystens.promotora.model.imutaveis.Prazos;
import br.com.rcbsystens.promotora.model.imutaveis.Retorno;

@ManagedBean
@RequestScoped
public class GeraBancoBean {
	public static void main(String[] args) {
		GeraBancoBean gb = new GeraBancoBean();
		gb.gerar();
	}
	public void gerar(){
		EntityManagerFactory fabrica = Persistence
				.createEntityManagerFactory("promotora");
		fabrica.close();
		
		//gera tabelas
		Tabelas tab = new Tabelas();
		List<Prazo> prazos = new ArrayList<Prazo>();
		Prazo prazo = new Prazo();
		Prazo prazo1 = new Prazo();
		Planos plano = new Planos();
		Planos plano1 = new Planos();
		Planos plano2 = new Planos();
		Planos plano3 = new Planos();
		List<Planos> planos = new ArrayList<Planos>();
		TabelasDao tabelasDao = new TabelasDao();
		tab = new Tabelas();
		
		plano.setRetorno(Retorno.RZERO);
		plano.setCoeficiente(new BigDecimal("0.096962"));
		planos.add(plano);

		plano1.setRetorno(Retorno.RUM);
		plano1.setCoeficiente(new BigDecimal("0.098119"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RDOIS);
		plano2.setCoeficiente(new BigDecimal("0.099277"));
		planos.add(plano2);
		
		plano3.setRetorno(Retorno.RTRES);
		plano3.setCoeficiente(new BigDecimal("0.100435"));
		planos.add(plano3);

		prazo.setPrazo(Prazos.DOZE);
		prazo.setPlanos(planos);
		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazos.add(prazo);

		plano = new Planos();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();
		planos = new ArrayList<Planos>();

		plano.setRetorno(Retorno.RZERO);
		plano.setCoeficiente(new BigDecimal("0.054190"));
		planos.add(plano);

		plano1.setRetorno(Retorno.RUM);
		plano1.setCoeficiente(new BigDecimal("0.054837"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RDOIS);
		plano2.setCoeficiente(new BigDecimal("0.055484"));
		planos.add(plano2);
		
		plano3.setRetorno(Retorno.RTRES);
		plano3.setCoeficiente(new BigDecimal("0.056131"));
		planos.add(plano3);
		
		prazo1.setPrazo(Prazos.VINTEQUATRO);
		prazo1.setPercentualEntrada(new BigDecimal("0.2"));
		prazo1.setPlanos(planos);
		prazos.add(prazo1);

		plano = new Planos();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();
		prazo1 = new Prazo();
		planos = new ArrayList<Planos>();

		plano.setRetorno(Retorno.RZERO);
		plano.setCoeficiente(new BigDecimal("0.039869"));
		planos.add(plano);

		plano1.setRetorno(Retorno.RUM);
		plano1.setCoeficiente(new BigDecimal("0.040345"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RDOIS);
		plano2.setCoeficiente(new BigDecimal("0.040821"));
		planos.add(plano2);
		
		plano3.setRetorno(Retorno.RTRES);
		plano3.setCoeficiente(new BigDecimal("0.041297"));
		planos.add(plano3);
		
		prazo1.setPrazo(Prazos.TRINTASEIS);
		prazo1.setPercentualEntrada(new BigDecimal("0.2"));
		prazo1.setPlanos(planos);
		prazos.add(prazo1);

		plano = new Planos();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();
		prazo1 = new Prazo();
		planos = new ArrayList<Planos>();

		plano.setRetorno(Retorno.RZERO);
		plano.setCoeficiente(new BigDecimal("0.032267"));
		planos.add(plano);

		plano1.setRetorno(Retorno.RUM);
		plano1.setCoeficiente(new BigDecimal("0.032653"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RDOIS);
		plano2.setCoeficiente(new BigDecimal("0.033038"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RTRES);
		plano3.setCoeficiente(new BigDecimal("0.033424"));
		planos.add(plano3);
		
		prazo1.setPrazo(Prazos.QUARENTAOITO);
		prazo1.setPercentualEntrada(new BigDecimal("0.2"));
		prazo1.setPlanos(planos);
		prazos.add(prazo1);

		plano = new Planos();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();
		prazo1 = new Prazo();
		planos = new ArrayList<Planos>();

		plano.setRetorno(Retorno.RZERO);
		plano.setCoeficiente(new BigDecimal("0.028084"));
		planos.add(plano);

		plano1.setRetorno(Retorno.RUM);
		plano1.setCoeficiente(new BigDecimal("0.028420"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RDOIS);
		plano2.setCoeficiente(new BigDecimal("0.028756"));
		planos.add(plano2);
		
		plano3.setRetorno(Retorno.RTRES);
		plano3.setCoeficiente(new BigDecimal("0.029091"));
		planos.add(plano3);

		prazo1.setPrazo(Prazos.SESSENTA);
		prazo1.setPercentualEntrada(new BigDecimal("0.4"));
		prazo1.setPlanos(planos);
		prazos.add(prazo1);

		tab.setModeloInicial(2015);
		tab.setModeloFinal(2015);
		tab.setZeroKm(true);
		tab.setPrazos(prazos);
		tab.setCodigo("ZERO1");

		Calendar c = Calendar.getInstance();
		c.set(2020, Calendar.JANUARY, 01, 00, 00, 00);
		tab.setVigencia(c.getTime());
		System.out.println(c.getTime());

		Tabelas tab2 = new Tabelas();
		List<Prazo> prazos2 = new ArrayList<Prazo>();
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		plano = new Planos();
		tabelasDao.salvar(tab);

		tab2.setZeroKm(false);
		tab2.setCodigo("DE0A3");
		tab2.setModeloInicial(2012);
		tab2.setModeloFinal(2015);
		Calendar c1 = Calendar.getInstance();
		c1.set(2020, Calendar.JANUARY,01,00,00,00);
		tab2.setVigencia(c1.getTime());
		
		// 12
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.097362"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.098525"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.099687"));
		planos.add(plano3);
		
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.100850"));
		planos.add(plano);

		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.DOZE);
		prazo.setPlanos(planos);
		prazos2.add(prazo);
		// 24
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();
		
		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.054502"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.055152"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.055803"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.056453"));
		planos.add(plano);

		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.VINTEQUATRO);
		prazo.setPlanos(planos);
		prazos2.add(prazo);
		// 36
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.039819"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.040295"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.040771"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.041246"));
		planos.add(plano);
		
		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.TRINTASEIS);
		prazo.setPlanos(planos);
		prazos2.add(prazo);

		// 48
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.032878"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.033271"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.033664"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.034057"));
		planos.add(plano);
		
		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.QUARENTAOITO);
		prazo.setPlanos(planos);
		prazos2.add(prazo);

		// 60
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.028579"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.028920"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.029262"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.029604"));
		planos.add(plano);
		
		prazo.setPercentualEntrada(new BigDecimal("0.4"));
		prazo.setPrazo(Prazos.SESSENTA);
		prazo.setPlanos(planos);
		prazos2.add(prazo);
		tab2.setPrazos(prazos2);
		tabelasDao.salvar(tab2);


		/** nova tabela **/
		tab2 = new Tabelas();
		prazos2 = new ArrayList<Prazo>();
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();

		tab2.setZeroKm(false);
		tab2.setCodigo("DE4A6");
		tab2.setModeloInicial(2009);
		tab2.setModeloFinal(2011);
		c1 = Calendar.getInstance();
		c1.set(2020, Calendar.JANUARY,01,00,00,00);
		tab2.setVigencia(c1.getTime());
		
		// 12
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.098863"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.100043"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.101223"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.102404"));
		planos.add(plano);
		
		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.DOZE);
		prazo.setPlanos(planos);
		prazos2.add(prazo);
		// 24
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();
		
		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.054809"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.055463"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.056117"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.056771"));
		planos.add(plano);
		
		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.VINTEQUATRO);
		prazo.setPlanos(planos);
		prazos2.add(prazo);
		// 36
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.040568"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.041053"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.041537"));
		planos.add(plano3);
		
		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.042022"));
		planos.add(plano);

		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.TRINTASEIS);
		prazo.setPlanos(planos);
		prazos2.add(prazo);

		// 48
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.033795"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.034199"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.034603"));
		planos.add(plano3);
		
		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.035006"));
		planos.add(plano);

		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.QUARENTAOITO);
		prazo.setPlanos(planos);
		prazos2.add(prazo);

		tab2.setPrazos(prazos2);
		tabelasDao.salvar(tab2);

		/** nova tabela **/
		tab2 = new Tabelas();
		prazos2 = new ArrayList<Prazo>();
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();

		tab2.setZeroKm(false);
		tab2.setCodigo("DE7A8");
		tab2.setModeloInicial(2007);
		tab2.setModeloFinal(2008);
		c1 = Calendar.getInstance();
		c1.set(2020, Calendar.JANUARY,01,00,00,00);
		tab2.setVigencia(c1.getTime());
		
		// 12
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.101441"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.102652"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.103864"));
		planos.add(plano3);
		
		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.105075"));
		planos.add(plano);

		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.DOZE);
		prazo.setPlanos(planos);
		prazos2.add(prazo);
		// 24
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();
		
		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.055658"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.056323"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.056987"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.057651"));
		planos.add(plano);
		
		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.VINTEQUATRO);
		prazo.setPlanos(planos);
		prazos2.add(prazo);
		// 36
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.041270"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.041763"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.042256"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.042749"));
		planos.add(plano);
		
		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.TRINTASEIS);
		prazo.setPlanos(planos);
		prazos2.add(prazo);

		// 48
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.034094"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.034501"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.034909"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.035316"));
		planos.add(plano);
		
		prazo.setPercentualEntrada(new BigDecimal("0.3"));
		prazo.setPrazo(Prazos.QUARENTAOITO);
		prazo.setPlanos(planos);
		prazos2.add(prazo);

		tab2.setPrazos(prazos2);
		tabelasDao.salvar(tab2);
		
		/** nova tabela **/
		tab2 = new Tabelas();
		prazos2 = new ArrayList<Prazo>();
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();

		tab2.setZeroKm(false);
		tab2.setCodigo("DE9A10");
		tab2.setModeloInicial(2005);
		tab2.setModeloFinal(2006);
		c1 = Calendar.getInstance();
		c1.set(2020, Calendar.JANUARY,01,00,00,00);
		tab2.setVigencia(c1.getTime());
		
		// 12
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.101762"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.102977"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.104192"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.105407"));
		planos.add(plano);
		
		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.DOZE);
		prazo.setPlanos(planos);
		prazos2.add(prazo);
		// 24
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();
		
		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.057231"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.057914"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.058597"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.059280"));
		planos.add(plano);
		
		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.VINTEQUATRO);
		prazo.setPlanos(planos);
		prazos2.add(prazo);
		// 36
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.042774"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.043285"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.043796"));
		planos.add(plano3);

		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.044307"));
		planos.add(plano);
		
		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.TRINTASEIS);
		prazo.setPlanos(planos);
		prazos2.add(prazo);

		// 48
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.036130"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.036561"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.036993"));
		planos.add(plano3);
		
		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.037425"));
		planos.add(plano);

		prazo.setPercentualEntrada(new BigDecimal("0.3"));
		prazo.setPrazo(Prazos.QUARENTAOITO);
		prazo.setPlanos(planos);
		prazos2.add(prazo);

		tab2.setPrazos(prazos2);
		tabelasDao.salvar(tab2);
		
		/** nova tabela **/
		tab2 = new Tabelas();
		prazos2 = new ArrayList<Prazo>();
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();

		tab2.setZeroKm(false);
		tab2.setCodigo("DE11A13");
		tab2.setModeloInicial(2002);
		tab2.setModeloFinal(2004);
		c1 = Calendar.getInstance();
		c1.set(2020, Calendar.JANUARY,01,00,00,00);
		tab2.setVigencia(c1.getTime());
		
		// 12
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.102946"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.104175"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.105404"));
		planos.add(plano3);
		
		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.106633"));
		planos.add(plano);

		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.DOZE);
		prazo.setPlanos(planos);
		prazos2.add(prazo);
		// 24
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();
		
		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.057525"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.058211"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.058897"));
		planos.add(plano3);
		
		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.059584"));
		planos.add(plano);

		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.VINTEQUATRO);
		prazo.setPlanos(planos);
		prazos2.add(prazo);
		// 36
		planos = new ArrayList<Planos>();
		plano1 = new Planos();
		plano2 = new Planos();
		plano3 = new Planos();
		prazo = new Prazo();

		plano1.setRetorno(Retorno.RZERO);
		plano1.setCoeficiente(new BigDecimal("0.043646"));
		planos.add(plano1);

		plano2.setRetorno(Retorno.RUM);
		plano2.setCoeficiente(new BigDecimal("0.044167"));
		planos.add(plano2);

		plano3.setRetorno(Retorno.RDOIS);
		plano3.setCoeficiente(new BigDecimal("0.044688"));
		planos.add(plano3);
		
		plano = new Planos();
		plano.setRetorno(Retorno.RTRES);
		plano.setCoeficiente(new BigDecimal("0.045209"));
		planos.add(plano);

		prazo.setPercentualEntrada(new BigDecimal("0.2"));
		prazo.setPrazo(Prazos.TRINTASEIS);
		prazo.setPlanos(planos);
		prazos2.add(prazo);

		tab2.setPrazos(prazos2);
		tabelasDao.salvar(tab2);
		
		System.out.println(tab2.getPrazos().size());

		for (int i = 0; i < tab2.getPrazos().size(); i++) {
			for (int j = 0; j < tab2.getPrazos().get(i).getPlanos().size(); j++) {
				if (tab.getPrazos().get(i).getPlanos().get(j).getRetorno()
						.toString()!=null) {
					System.out.println(tab2.getPrazos().get(i)
							.getPercentualEntrada()
							.multiply(new BigDecimal("100")));
					System.out.println(tab2.getPrazos().get(i).getPlanos()
							.get(j).getRetorno());
					System.out.println(tab2.getPrazos().get(i).getPrazo()
							.toString()
							+ " X "
							+ tab2.getPrazos().get(i).getPlanos().get(j)
									.getCoeficiente());
				}
			}
		}
	}
}
