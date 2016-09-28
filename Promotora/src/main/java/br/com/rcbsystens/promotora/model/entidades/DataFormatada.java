package br.com.rcbsystens.promotora.model.entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormatada {
	public String DataComHora(Date data) {
		if (data == null) {
			data = new Date();
		}
		DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return dataFormatada.format(data);
	}

	public String DataSemHora(Date data) {
		if (data == null) {
			data = new Date();
		}
		DateFormat dataFormata = new SimpleDateFormat("dd/MM/yyyy");
		return dataFormata.format(data);
	}

	public String DataSomenteMesAno(Date data) {
		if (data == null) {
			data = new Date();
		}
		DateFormat dataFormata = new SimpleDateFormat("MM/yyyy");
		return dataFormata.format(data);
	}
}
