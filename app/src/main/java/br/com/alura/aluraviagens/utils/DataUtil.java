package br.com.alura.aluraviagens.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.aluraviagens.model.Pacote;

public class DataUtil {

    public static final String FORMATACAO_DATA_BR = "dd/MM";

    public static String formataData(Pacote pacote){
        Calendar diaAtual = Calendar.getInstance();
        Calendar diaFinal = Calendar.getInstance();
        diaFinal.add(Calendar.DATE, pacote.getDias());
        SimpleDateFormat formatoBrasileiroDate = new SimpleDateFormat(FORMATACAO_DATA_BR);

        String diaAtualFormatado = formatoBrasileiroDate.format(diaAtual.getTime());
        String diaFinalFormatado = formatoBrasileiroDate.format(diaFinal.getTime());

        return diaAtualFormatado + " - " + diaFinalFormatado + " de " + diaFinal.get(Calendar.YEAR);
    }


}
