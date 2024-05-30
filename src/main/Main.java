package main;

import util.InterfaceUsuario;
import modelo.*;

import java.util.ArrayList;

/*
Arrumar precificação
 */


public class Main {
    public static void main(String[] args) {
        var financiamentos = new ArrayList<Financiamento>();

        // Pede apenas uma vez asinformação para facilitar os testes
        double valorImovel = InterfaceUsuario.obterValorImovel();
        int prazoDoFinanciomentoEmAnos = InterfaceUsuario.obterPrazoDoFinanciamentoEmAnos();
        double valorTaxa = InterfaceUsuario.obterTaxaDeJuros();

        // Cria financiamentos de diferentes imóveis
        financiamentos.add(new Casa(valorImovel, prazoDoFinanciomentoEmAnos, valorTaxa));
        financiamentos.add(new Casa(200000, 30, 10));

        financiamentos.add(new Apartamento(valorImovel, prazoDoFinanciomentoEmAnos, valorTaxa));
        financiamentos.add(new Apartamento(200000, 30, 10));

        financiamentos.add(new Terreno(valorImovel, prazoDoFinanciomentoEmAnos, valorTaxa));

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