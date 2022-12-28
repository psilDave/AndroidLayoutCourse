package br.com.alura.aluraviagens.utils;

public class DiasUtil {

    public static final String SINGULAR = "dia";
    public static final String PLURAL = SINGULAR + "s";

    public static String formataDia(int dias) {
        if (dias > 1) {
            return dias + " " + PLURAL;
        } else {
            return dias + " " + SINGULAR;
        }
    }

}
