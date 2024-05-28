package main;
import util.InterfaceUsuario;
import modelo.Financiamento;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Instancia quatro financiamentos
        for(int i = 0; i < 4; i++) {
            double valorImovel = InterfaceUsuario.obterValorImovel();
            int valorParcela = InterfaceUsuario.obterPrazoDoFinanciamentoEmAnos();
            double valorTaxa = InterfaceUsuario.obterTaxaDeJuros();
            Financiamento financiamento = new Financiamento(valorImovel, valorParcela, valorTaxa);
            financiamentos.add(financiamento);
        }

        double valorTotalDosImoveis = 0;
        double valorTotalDosFinanciamentos = 0;

        // Mostra o custo individual e total de cada imóvel e financiamento
        for(Financiamento financiamento : financiamentos) {
            financiamento.mostrarInformacoes();
            valorTotalDosImoveis += financiamento.getValorImovel();
            valorTotalDosFinanciamentos += financiamento.calcularPagamentoFinanciamento();
        }
        System.out.printf("\nO valor total de todos os imóveis será: R$%.2f\n", valorTotalDosImoveis);
        System.out.printf("O valor total de todos os financiamentos será: R$%.2f", valorTotalDosFinanciamentos);

    }
}