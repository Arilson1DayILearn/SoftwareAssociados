package br.com.zbs.sindicato.application.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Moeda {
	
	private BigDecimal valor;
	private static final String UNIDADE_MONETARIA = "R$";
	private static final DecimalFormat FORMATO = new DecimalFormat(UNIDADE_MONETARIA + " #,###,##0.00");
	
	public Moeda(String valor) {		
		this.valor = new BigDecimal(valor);
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getValorFormatado() {
		return FORMATO.format(valor);
	}

	
}
