package br.com.rcbsystens.promotora.model.email;

public class EmailTeste {
	public static void main(String[] args) {
		Email email = new Email();
		String menssagem = new String("<!DOCTYPE html><html><head><meta charset=utf-8><title>Email de proposta: </title></head><body><p> Teste pagina </p></body></html>");
		email.enviarEmail("rafael@bbpromotora.com.br", "Teste html", menssagem);
	}
}