package br.com.rcbsystens.promotora.model.validacoes;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validacoes.validaPreenchimento")
@RequestScoped
public class ValidaPreenchimento implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		System.out.println(arg1.getId().toString());
		String valorDigitado = arg2.toString();
		valorDigitado = valorDigitado.replaceAll("_", "");
		System.out.println(valorDigitado);
		if ((valorDigitado.toString().equals("vw") || valorDigitado.toString()
				.equals("VW")) && (arg1.getId().equals("fabricante"))) {
			valorDigitado = "valido";
		}
		if ((valorDigitado.toString().equals("gm") || valorDigitado.toString()
				.equals("GM")) && (arg1.getId().equals("fabricante"))) {
			valorDigitado = "valido";
		}
		if ((valorDigitado.toString().equals("jac") || valorDigitado.toString()
				.equals("JAC")) && (arg1.getId().equals("fabricante"))) {
			valorDigitado = "valido";
		}
		if ((valorDigitado.toString().equals("gmc") || valorDigitado.toString()
				.equals("GMC")) && (arg1.getId().equals("fabricante"))) {
			valorDigitado = "valido";
		}
		if ((valorDigitado.toString().equals("kia") || valorDigitado.toString()
				.equals("KIA")) && (arg1.getId().equals("fabricante"))) {
			valorDigitado = "valido";
		}
		if ((valorDigitado.toString().equals("ram") || valorDigitado.toString()
				.equals("RAM")) && (arg1.getId().equals("fabricante"))) {
			valorDigitado = "valido";
		}
		if ((valorDigitado.toString().equals("tac") || valorDigitado.toString()
				.equals("TAC")) && (arg1.getId().equals("fabricante"))) {
			valorDigitado = "valido";
		}
		if ((valorDigitado.toString().equals("jpx") || valorDigitado.toString()
				.equals("JPX")) && (arg1.getId().equals("fabricante"))) {
			valorDigitado = "valido";
		}
		if ((valorDigitado.toString().equals("mg") || valorDigitado.toString()
				.equals("MG")) && (arg1.getId().equals("fabricante"))) {
			valorDigitado = "valido";
		}
		if ((valorDigitado.toString().equals("ssp") || valorDigitado.toString()
				.equals("SSP")) && (arg1.getId().equals("orgaoEmissor"))) {
			valorDigitado = "valido";
		}
		if ((valorDigitado.toString().equals("cbm") || valorDigitado.toString()
				.equals("CBM")) && (arg1.getId().equals("orgaoEmissor"))) {
			valorDigitado = "valido";
		}

		// comparação para retornar a resposta correta para o cliente;
		String identificacao = new String();
		if (arg1.getId().equals("fabricante")) {
			identificacao = "Fabricante:";
		} else if (arg1.getId().equals("valorCompra")) {
			identificacao = "Valor compra:";
		} else if (arg1.getId().equals("nomeCliente")) {
			identificacao = "Nome cliente:";
		} else if (arg1.getId().equals("modeloVeiculo")) {
			identificacao = "Modelo Veículo:";
		} else if (arg1.getId().equals("ano")) {
			identificacao = "Ano:";
		} else if (arg1.getId().equals("modelo")) {
			identificacao = "Modelo:";
		} else if (arg1.getId().equals("valorEntrada")) {
			identificacao = "Valor Entrada:";
		} else if (arg1.getId().equals("numeroRg")) {
			identificacao = "Numero RG:";
		} else if (arg1.getId().equals("naturalidade")) {
			identificacao = "Naturalidade:";
		} else if (arg1.getId().equals("Pai")) {
			identificacao = "Nome do pai:";
		} else if (arg1.getId().equals("Mae")) {
			identificacao = "Nome da mãe:";
		}else if (arg1.getId().equals("resLogradouro")) {
			identificacao = "Logradouro residencial:";
		}else if (arg1.getId().equals("resBairro")) {
			identificacao = "Bairro residencial:";
		}else if (arg1.getId().equals("resCidade")) {
			identificacao = "Cidade residencial:";
		}else if (arg1.getId().equals("empresaCliente")) {
			identificacao = "Empresa:";
		}else if (arg1.getId().equals("cargoCliente")) {
			identificacao = "Cargo:";
		}else if (arg1.getId().equals("salarioCliente")) {
			identificacao = "Salário:";
		}else if (arg1.getId().equals("comLogradouro")) {
			identificacao = "Logradouro:";
		}else if (arg1.getId().equals("comBairro")) {
			identificacao = "Bairro:";
		}else if (arg1.getId().equals("comCidade")) {
			identificacao = "Cidade:";
		}else if (arg1.getId().equals("referenciaPessoal1")) {
			identificacao = "Referencia pessoal 1:";
		}else if (arg1.getId().equals("agenciaCliente")) {
			identificacao = "Agencia:";
		}else if (arg1.getId().equals("contaCliente")) {
			identificacao = "Conta: ";
		}

		if (valorDigitado.toString().equals("")) {
			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, identificacao,
					"Necessário preenchimento!");
			throw new ValidatorException(mensagem);
		} else if ((valorDigitado.toString().equals("0.0"))
				|| (valorDigitado.toString().equals("0"))
				|| (valorDigitado.toString().equals("0.00"))) {
			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, identificacao,
					"Necessário preenchimento!");
			throw new ValidatorException(mensagem);
		} else if (valorDigitado.toString().length() < 4) {
			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, identificacao,
					"Informação incorreta!");
			throw new ValidatorException(mensagem);
		}

	}

}
