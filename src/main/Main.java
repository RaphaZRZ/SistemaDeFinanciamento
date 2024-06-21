/*
    Arrumar problema da classe abstrata não abstrata de Financiamento
 */

package main;

import util.InterfaceUsuario;
imp ort modelo.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        var financiamentos = new ArrayList<Financiamento>();

        // Pede apenas uma vez asinformação para facilitar os testes
        String tipoFinanciamento = InterfaceUsuario.obterTipoFinanciamento();
        double valorImovel = InterfaceUsuario.obterValorImovel();
        int prazoDoFinanciomentoEmAnos = InterfaceUsuario.obterPrazoDoFinanciamentoEmAnos();
        double valorTaxaDeJurosAnual = InterfaceUsuario.obterTaxaDeJurosAnual();

        // Instancia um objeto do tipo de financiamento escolhido
        switch (tipoFinanciamento) {
            case "Casa" -> {
                double areaTerreno = InterfaceUsuario.obterAreaTerreno();
                double areaConstruida = InterfaceUsuario.obterAreaConstruida(areaTerreno);
                financiamentos.add(new Casa(valorImovel, prazoDoFinanciomentoEmAnos, valorTaxaDeJurosAnual, areaConstruida, areaTerreno));
            }
            case "Apartamento" -> {
                int quantidadeDeAndares = InterfaceUsuario.obterQuantidadeDeAndaresDoApartamento();
                int quantidadeDeVagasDoEstacionamento = InterfaceUsuario.obterQuantidadeDeVagasNoEstacionamento();
                financiamentos.add(new Apartamento(valorImovel, prazoDoFinanciomentoEmAnos, valorTaxaDeJurosAnual, quantidadeDeAndares, quantidadeDeVagasDoEstacionamento));
            }
            case "Terreno" -> {
                String tipoDeZona = InterfaceUsuario.obterTipoDeZona();

                financiamentos.add(new Terreno(valorImovel, prazoDoFinanciomentoEmAnos, valorTaxaDeJurosAnual, tipoDeZona));
            }
        }

        //  Adiciona objetos ao array de financiamentos
        financiamentos.add(new Casa(300000, 12, 12, 35.2, 40));
        financiamentos.add(new Apartamento(400000, 25, 10, 5, 33));
        financiamentos.add(new Terreno(200000, 30, 8, "Comercial"));

        // Mostra o custo individual e total de cada imóvel e financiamento
        double valorTotalDosImoveis = 0;
        double valorTotalDosFinanciamentos = 0;
        for(Financiamento financiamento : financiamentos) {
            financiamento.mostrarInformacoes();
            valorTotalDosImoveis += financiamento.getValorImovel();
            valorTotalDosFinanciamentos += financiamento.calcularPagamentoDoFinanciamento();
        }
        System.out.printf("\nO valor total de todos os imóveis será: R$%.2f\n", valorTotalDosImoveis);
        System.out.printf("O valor total de todos os financiamentos será: R$%.2f", valorTotalDosFinanciamentos);

    }
}