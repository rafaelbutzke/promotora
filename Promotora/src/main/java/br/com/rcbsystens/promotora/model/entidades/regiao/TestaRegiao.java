package br.com.rcbsystens.promotora.model.entidades.regiao;

public class TestaRegiao {
	public static void main(String[] args) {
		Regiao regiao = new Regiao();
		regiao.setDescricao("Formosa2");
		RegiaoDaoAnterior dao = new RegiaoDaoAnterior();
		dao.Salvar(regiao);
	}
}
