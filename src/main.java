import java.util.Scanner;
import br.com.alura.conversordemoedas.servicos.CambioService;
import br.com.alura.conversordemoedas.modelo.Conversao;

public class main {
    public static void main(String[] args) {
        // Cria um Scanner para ler entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Exibe o cabeçalho do programa
        System.out.println("=== CONVERSOR DE MOEDAS ===");
        System.out.println("(Use siglas como USD, BRL, EUR)");

        try {
            // Solicita a moeda de origem ao usuário
            System.out.print("Moeda de origem (ex: USD): ");
            String moedaOrigem = scanner.nextLine().toUpperCase();  // Converte para maiúsculas

            // Solicita a moeda de destino ao usuário
            System.out.print("Moeda de destino (ex: BRL): ");
            String moedaDestino = scanner.nextLine().toUpperCase();  // Converte para maiúsculas

            // Solicita o valor a ser convertido
            System.out.print("Valor para converter: ");
            double valor = scanner.nextDouble();

            // Cria o serviço de câmbio
            CambioService cambioService = new CambioService();

            // Executa a conversão de moedas
            Conversao conversao = cambioService.converter(moedaOrigem, moedaDestino, valor);

            // Verifica se a conversão foi bem sucedida
            if (conversao != null) {
                // Exibe o resultado da conversão
                System.out.println("\n" + conversao);
            } else {
                // Mensagem de erro caso a conversão falhe
                System.out.println("Não foi possível realizar a conversão. Verifique as moedas informadas.");
            }

        } catch (Exception e) {
            // Captura e exibe erros inesperados
            System.out.println("Erro: " + e.getMessage());
        } finally {
            // Garante que o scanner será fechado mesmo em caso de erro
            scanner.close();
        }
    }
}