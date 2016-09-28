package br.com.rcbsystens.promotora.model.entidades;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class NumeroFormatado {
	public NumberFormat bd = NumberFormat.getInstance(Locale.getDefault());
	
	public String comQuatroCasasDecimais(BigDecimal numero){
		bd.setMaximumFractionDigits(4);
		bd.setMinimumFractionDigits(4);
		return bd.format(numero);
	}
	
	public String comDuasCasasDecimais(BigDecimal numero){
		bd.setMaximumFractionDigits(2);
		bd.setMinimumFractionDigits(2);
		return bd.format(numero);
	}
}
