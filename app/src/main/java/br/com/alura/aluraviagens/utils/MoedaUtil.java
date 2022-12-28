package br.com.alura.aluraviagens.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_SOLICITADO = "R$ ";

    public static String formataPreco(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return formatoBrasileiro.format(valor).replace(FORMATO_PADRAO, FORMATO_SOLICITADO);
    }


}
