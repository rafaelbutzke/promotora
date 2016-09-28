package br.com.rcbsystens.promotora.visao.bean;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
// @SessionScopeden
public class TesteBean {
	private String texto = new String();
	private String email = new String();
	private Date data;
	private Double valor = new Double(0);
	private BigDecimal valorBigDecimal = new BigDecimal(0);
	private BigDecimal valorComissao = new BigDecimal(0);
	private BigDecimal percentualComissao = new BigDecimal("0");
	private List<usuarioTeste> usuarios;
	private usuarioTeste user = new usuarioTeste();
	private Integer codigoDoUsuario = new Integer("0");
	
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	// df.format(today);

	

	public Integer getCodigoDoUsuario() {
		return codigoDoUsuario;
	}

	public void setCodigoDoUsuario(Integer codigoDoUsuario) {
		this.codigoDoUsuario = codigoDoUsuario;
	}

	public usuarioTeste getUser() {
		return user;
	}

	public void setUser(usuarioTeste user) {
		this.user = user;
	}

	public List<usuarioTeste> getUsuarios() {
		usuarios = new ArrayList<usuarioTeste>();
		usuarioTeste u1 = new usuarioTeste();
		usuarioTeste u2 = new usuarioTeste();
		usuarioTeste u3 = new usuarioTeste();
		u1.setCodigo(10);
		u1.setNome("Rafael Cristiano Butzke");
		u2.setCodigo(11);
		u2.setNome("Ligia Sandra Butzke");
		u3.setCodigo(12);
		u3.setNome("Clovis Roberto Butzke");
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		return usuarios;
	}

	public void setUsuarios(List<usuarioTeste> usuarios) {
		this.usuarios = usuarios;
	}

	public String getEmail() {
		return email.toLowerCase();
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	public BigDecimal getValorComissao() {
		return valorComissao;
	}

	public void setValorComissao(BigDecimal valorComissao) {
		this.valorComissao = valorComissao;
	}

	public String getTexto() {
		return texto.toUpperCase();
	}

	public void setTexto(String texto) {
		this.texto = texto.toUpperCase();
	}

	public Date getData() {
		return data;
	}

	public BigDecimal getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(BigDecimal percentualComissao) {
		this.percentualComissao = percentualComissao;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public BigDecimal getValorBigDecimal() {
		return valorBigDecimal;
	}

	public void setValorBigDecimal(BigDecimal valorBigDecimal) {
		this.valorBigDecimal = valorBigDecimal;
	}

	public void usuarioSelecionado() {
		
		 if (codigoDoUsuario != 0) {
			for (int i = 0; i < usuarios.size(); i++) {
				usuarioTeste verificaUsuario = usuarios.get(i);
				if (verificaUsuario.getCodigo().equals(codigoDoUsuario)){
					user = usuarios.get(i);
					System.out.println("Nome do usuário: "+user.getNome());
				}
			}
		} else{
			user = new usuarioTeste();
		}
		System.out.println(user.getNome());
	}

	public String salvar() {
		System.out.println("Clique no botao salvar....");
		System.out.println(user.getNome());
		BigDecimal subtracao = new BigDecimal(valorBigDecimal.toString());
		BigDecimal subtracao2 = new BigDecimal(0.0320);
		System.out.println("Salvando um teste: ");
		valorComissao = new BigDecimal(valorComissao.toString());
		System.out.println("Comissao capturada: "
				+ percentualComissao.toString());
		percentualComissao = percentualComissao.multiply(new BigDecimal(100));
		System.out.println("Percentual de comissão: " + percentualComissao
				+ "%");
		System.out.println("Comissao: "
				+ new BigDecimal("10000").multiply(valorComissao));
		System.out.println(this.texto);
		System.out.println(df.format(this.data));
		System.out.println(this.valor);
		System.out.println("email: " + this.email);
		System.out.println(this.valorBigDecimal.subtract(subtracao2));
		System.out.println("To stringa big decimal: "
				+ this.valorBigDecimal.toString());
		System.out.println(this.valorBigDecimal.subtract(subtracao));
		this.email = new String();
		this.texto = new String();
		this.data = null;
		this.valor = new Double(0);
		this.valorBigDecimal = new BigDecimal("0");
		this.valorComissao = new BigDecimal("0");
		this.percentualComissao = new BigDecimal("0");
		this.user = new usuarioTeste();
		System.out.println("***************************************************************************************************************");
		return "ok registro";
	}

}
