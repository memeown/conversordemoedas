package br.com.alura.conversordemoedas.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

// Classe utilitária para formatação de números
public class Formatador {
    // Método para formatar números com 2 casas decimais e separadores
    public static String formatarNumero(double valor) {
        // Cria um formatador para o padrão brasileiro
        DecimalFormat formato = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

        // Formata o número
        return formato.format(valor);
    }
}