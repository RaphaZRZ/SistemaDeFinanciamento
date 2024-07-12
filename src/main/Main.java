package main;

import Painel.Painel;

public class Main {
    public static void main(String[] args) {
        new Painel();
    }
}

/*
import util.InterfaceUsuario;
import modelo.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Cria um vetor de financiamentos e a variável para escrever e ler dados
        var financiamentos = new ArrayList<Financiamento>();
        Scanner sc = new Scanner(System.in);
        FileWriter escritor;
        FileReader leitor;
        ObjectOutputStream outputStream;
        ObjectInputStream inputStream;


        // Lê o array financiamentos
        try {
            inputStream = new ObjectInputStream(new FileInputStream("financiamentos.obj"));

            Object objeto;

            while ((objeto = inputStream.readObject()) != null) {
                if (objeto instanceof Financiamento)
                    financiamentos.add(((Financiamento) objeto));
            }

            inputStream.close();
        } catch (ClassNotFoundException | FileNotFoundException | EOFException _) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Lê os dados de cada financiamento do arquivo financiamentos.txt
        try {
            leitor = new FileReader("financiamentos.txt");
            int caracterLido;

            System.out.println("Os financiamentos já cadastrados são:");

            while ((caracterLido = leitor.read()) != -1) {
                System.out.print((char) caracterLido);
            }

            leitor.close();

        } catch (FileNotFoundException _) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Início do loop
        while (true) {
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

            // Obtém a escolha do usuário para quebrar o loop
            System.out.println("Deseja financiar outro imóvel?: ");
            String escolha = sc.nextLine();
            if (!Objects.equals(escolha, "sim"))
                break;

            System.out.println();
        }

        // Escreve os dados de cada financiamento no arquivo financiamentos.txt
        for (Financiamento financiamento : financiamentos) {
            try {
                escritor = new FileWriter("financiamentos.txt", true);
                escritor.write(financiamento.toString());

                escritor.flush();
                escritor.close();
            } catch (FileNotFoundException _) {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Escreve o array financiamentos
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("financiamentos.obj"));

            for (Financiamento financiamento : financiamentos)
                outputStream.writeObject(financiamento);

            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
*/

