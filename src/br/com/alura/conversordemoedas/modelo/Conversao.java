package br.com.alura.conversordemoedas.modelo;

import br.com.alura.conversordemoedas.util.Formatador;

// Classe que representa uma operação de conversão de moeda
public class Conversao {
    // Atributos da conversão
    private String moedaOrigem;       // Moeda de origem (ex: USD)
    private String moedaDestino;      // Moeda de destino (ex: BRL)
    private double valorOriginal;     // Valor original a ser convertido
    private double valorConvertido;   // Valor após conversão
    private double taxaCambio;        // Taxa de câmbio utilizada

    // Construtor que inicializa todos os atributos
    public Conversao(String moedaOrigem, String moedaDestino,
                     double valorOriginal, double valorConvertido,
                     double taxaCambio) {
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        this.valorOriginal = valorOriginal;
        this.valorConvertido = valorConvertido;
        this.taxaCambio = taxaCambio;
    }

    // Método que retorna uma representação em string da conversão
    @Override
    public String toString() {
        return String.format("%s %s = %s %s\nTaxa: 1 %s = %.4f %s",
                Formatador.formatarNumero(valorOriginal), moedaOrigem,
                Formatador.formatarNumero(valorConvertido), moedaDestino,
                moedaOrigem, taxaCambio, moedaDestino);
    }

    // Getters para acessar os valores da conversão (opcional)
    public String getMoedaOrigem() { return moedaOrigem; }
    public String getMoedaDestino() { return moedaDestino; }
    public double getValorOriginal() { return valorOriginal; }
    public double getValorConvertido() { return valorConvertido; }
    public double getTaxaCambio() { return taxaCambio; }
}