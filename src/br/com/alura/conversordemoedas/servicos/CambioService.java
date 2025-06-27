package br.com.alura.conversordemoedas.servicos;

import br.com.alura.conversordemoedas.api.ExchangeRateAPI;
import br.com.alura.conversordemoedas.modelo.Conversao;

// Serviço responsável por orquestrar a conversão de moedas
public class CambioService {
    // Método principal que realiza a conversão
    public Conversao converter(String moedaOrigem, String moedaDestino, double valor) {
        try {
            // Obtém a taxa de câmbio da API
            ExchangeRateAPI api = new ExchangeRateAPI();
            double taxa = api.getTaxaCambio(moedaOrigem, moedaDestino);

            // Verifica se a taxa foi obtida com sucesso
            if (taxa > 0) {
                // Calcula o valor convertido
                double valorConvertido = valor * taxa;

                // Cria e retorna o objeto de conversão
                return new Conversao(moedaOrigem, moedaDestino, valor, valorConvertido, taxa);
            }
        } catch (Exception e) {
            // Log de erro (em aplicação real, usar sistema de logging)
            System.out.println("Erro no serviço de câmbio: " + e.getMessage());
        }

        // Retorna null em caso de falha
        return null;
    }
}