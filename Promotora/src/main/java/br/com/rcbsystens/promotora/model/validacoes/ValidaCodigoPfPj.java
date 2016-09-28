package br.com.rcbsystens.promotora.model.validacoes;


import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator ("validacoes.validaCodigoCliente")
@RequestScoped
public class ValidaCodigoPfPj implements Validator{
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valorTela) throws ValidatorException{
		String codigo = (String) valorTela;
		String codigoSemCaracteres = RetiraCaractereCpfCnpj.retira(codigo);
		if(codigoSemCaracteres.equals("")){
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"CPF ou CNPJ ", " está em branco!");
			throw new ValidatorException(mensagem);
		} else if(!validaCodigoCliente(codigoSemCaracteres)){
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"CPF ou CNPJ: ", codigo + " inválido!");
			throw new ValidatorException(mensagem);
		} 
	}

	public boolean validaCodigoCliente(String codigoCliente) {
		char ponto = '.';
		if (codigoCliente.length() > 3) {
			char caractere = codigoCliente.charAt(2);
			if (ponto == caractere) {
				StringBuffer deletarCaracteres = new StringBuffer(codigoCliente);
				deletarCaracteres.deleteCharAt(2);
				deletarCaracteres.deleteCharAt(5);
				deletarCaracteres.deleteCharAt(8);
				deletarCaracteres.deleteCharAt(12);
				codigoCliente = new String(deletarCaracteres);
			}

			caractere = codigoCliente.charAt(3);
			if (ponto == caractere) {
				StringBuffer deletarCaracteres = new StringBuffer(codigoCliente);
				deletarCaracteres.deleteCharAt(3);
				deletarCaracteres.deleteCharAt(6);
				deletarCaracteres.deleteCharAt(9);
				codigoCliente = new String(deletarCaracteres);
			}
		}

		if ((codigoCliente.length() < 11) || (codigoCliente.length() > 14)) {
			return false;
		}

		// valida��o do CPF
		if (codigoCliente.length() == 11) {

			int digito10 = 0;
			int digito11 = 0;

			int[] digitos = new int[codigoCliente.length()];
			for (int i = 0; i < codigoCliente.length(); i++) {
				digitos[i] = Integer
						.parseInt(codigoCliente.substring(i, i + 1)); // transforma
																		// a
																		// string
																		// CPF
																		// ou
																		// CNPJ
																		// en um
																		// arrey
																		// de
																		// inteiros

				if (i < 9) {
					digito10 += ((i + 1) * digitos[i]);
				}
				if (i < 10) {
					digito11 += (i * digitos[i]);
				}
			}

			if ((digito10 % 11) == 10) // transforma o digito verificador de 10
										// em 0.
				digito10 = 11;

			if ((digito11 % 11) == 10) // transforma o digito verificador de 10
										// em 0.
				digito11 = 11;

			if (((digito10 % 11) == digitos[9])
					&& ((digito11 % 11) == digitos[10])) {
				return true;
			} else {
				return false;
			}
		} // fim da valida��o do
			// CPF===========================================================

		// valida��o do CNPJ

		else {
			int digito13 = 0;
			int digito14 = 0;
			int j = 6;
			int k = 5;
			int[] digitos = new int[codigoCliente.length()];
			for (int i = 0; i < codigoCliente.length(); i++) {
				digitos[i] = Integer
						.parseInt(codigoCliente.substring(i, i + 1)); // transforma
																		// a
																		// string
																		// CPF
																		// ou
																		// CNPJ
																		// en um
																		// arrey
																		// de
																		// inteiros

				if (i < 12) {
					digito13 += j * digitos[i];
				}
				if (i < 13) {
					digito14 += k * digitos[i];
				}
				if (k == 9) {
					k = 1;
				}
				if (j == 9) {
					j = 1;
				}
				j++;
				k++;
			}

			if ((digito13 % 11) == 10) // transforma o digito verificador de 10
										// em 0.
				digito13 = 11;

			if ((digito14 % 11) == 10) // transforma o digito verificador de 10
										// em 0.
				digito14 = 11;

			if (((digito13 % 11) == digitos[12])
					&& ((digito14 % 11) == digitos[13])) {
				return true;
				
			} else {
				return false;
			}
		}
	}
}
