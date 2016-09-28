package br.com.rcbsystens.promotora.model.validacoes;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validacoes.validaAnoModelo")
@RequestScoped
public class ValidaAnoModelo implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		String identificacao = new String();
		String valorDigitado = arg2.toString();
		valorDigitado = valorDigitado.replaceAll("_", "");
		int anoModelo = 0; 
		if (valorDigitado.length() > 1) {
			anoModelo = Integer.parseInt(valorDigitado);
		}

		if (arg1.getId().equals("ano")) {
			identificacao = "Ano:";
		} else if (arg1.getId().equals("modelo")) {
			identificacao = "Modelo:";
		}

		if (valorDigitado.toString().length() < 4) {
			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, identificacao,
					"Informação incorreta!");
			throw new ValidatorException(mensagem);
		} else if (arg1.getId().equals("modelo") && anoModelo < 2002) {
			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, identificacao,
					"Infelizmente nao financiamos veículos com modelo inferior a 2002!");
			throw new ValidatorException(mensagem);
		} else if (arg1.getId().equals("ano") && anoModelo < 2001) {
			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, identificacao,
					"Infelizmente nao financiamos veículos com modelo inferior a 2001!");
			throw new ValidatorException(mensagem);
		}
	}
}
