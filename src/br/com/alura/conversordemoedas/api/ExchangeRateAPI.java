package br.com.alura.conversordemoedas.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Classe responsável pela comunicação com a API de câmbio
public class ExchangeRateAPI {
    private static final String API_KEY = "f2045d190015885f54f79bfc";
    // URL base da API
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    // Método para obter a taxa de câmbio entre duas moedas
    public double getTaxaCambio(String moedaOrigem, String moedaDestino) {
        try {
            // Constrói a URL completa para a requisição
            URL url = new URL(BASE_URL + moedaOrigem + "/" + moedaDestino);

            // Abre a conexão HTTP
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");  // Define o método como GET

            // Verifica se a resposta foi bem sucedida (código 200)
            if (conexao.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Lê a resposta da API
                BufferedReader leitor = new BufferedReader(
                        new InputStreamReader(conexao.getInputStream()));

                // Variáveis para processar a resposta
                String linha;
                StringBuilder respostaCompleta = new StringBuilder();

                // Lê cada linha da resposta
                while ((linha = leitor.readLine()) != null) {
                    respostaCompleta.append(linha);
                }
                leitor.close();  // Fecha o leitor

                // Converte a resposta para string
                String json = respostaCompleta.toString();

                // Procura pela taxa de câmbio no JSON (abordagem simples)
                // Encontra a posição do campo "conversion_rate"
                int inicio = json.indexOf("\"conversion_rate\":") + 18;
                // Encontra o fim do valor (próxima vírgula ou chave)
                int fim = json.indexOf(",", inicio);
                if (fim == -1) fim = json.indexOf("}", inicio);

                // Extrai o valor da taxa como string
                String taxaString = json.substring(inicio, fim);

                // Converte para double e retorna
                return Double.parseDouble(taxaString);
            } else {
                // Exibe erro se a resposta não for 200 OK
                System.out.println("Erro na API: Código " + conexao.getResponseCode());
            }
        } catch (Exception e) {
            // Exibe erros de conexão ou processamento
            System.out.println("Erro ao acessar a API: " + e.getMessage());
        }

        // Retorna -1 em caso de falha
        return -1;
    }
}