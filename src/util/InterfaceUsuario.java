package util;

import Exceptions.ValorImovelInvalidoException;
import Exceptions.PrazoFinanciamentoInvalidoException;
import Exceptions.JurosFinanciamentoInvalidoException;
import Exceptions.ValorInvalidoException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class InterfaceUsuario {
    static Scanner sc = new Scanner(System.in);

    public static double validarValorImovel(float preco) throws ValorImovelInvalidoException{
        if (preco < 50000)
            throw new ValorImovelInvalidoException("O valor informado está fora dos limites permitidos.");

        return preco;
    }

    public static int validarPrazoDoFinanciamentoEmAnos(int prazo) throws PrazoFinanciamentoInvalidoException {
        if ((prazo < 1) || prazo > 35)
            throw new PrazoFinanciamentoInvalidoException("O valor informado está fora dos limites permitidos.");

        return prazo;
    }

    public static double validarTaxaDeJurosAnual(float juros) throws JurosFinanciamentoInvalidoException {
        if ((juros < 6) || (juros > 12))
            throw new JurosFinanciamentoInvalidoException("O valor informado está fora dos limites permitidos.");

        return juros;
    }


    // Casa
    public static double obterAreaTerreno() {
        while (true) {
            try {
                System.out.print("\nInforme em metros quadrados a área do terreno(mínimo 2,5 metros): ");
                double areaTerreno = sc.nextDouble();
                sc.nextLine();

                if (areaTerreno < 2.5)
                    throw new ValorInvalidoException("O valor informado está fora dos limites permitidos.");

                return areaTerreno;

            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número.");
                sc.nextLine();
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static double obterAreaConstruida(double areaTerreno) {
        while (true) {
            try {
                System.out.print("\nInforme em metros quadrados a área da casa: ");
                double areaConstruida = sc.nextDouble();
                sc.nextLine();

                if (areaConstruida > areaTerreno)
                    throw new ValorInvalidoException("Valor inválido. A área construída não pode ser maior que a área do terreno.");

                return areaConstruida;

            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número.");
                sc.nextLine();
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Apartamento
    public static int obterQuantidadeDeAndaresDoApartamento() {
        while (true) {
            try {
                System.out.print("\nInforme a quantidade de andares do apartamento(mínimo 4): ");
                int quantidadeDeAndaresDoApartamento = sc.nextInt();
                sc.nextLine();

                if (quantidadeDeAndaresDoApartamento < 4)
                    throw new ValorInvalidoException("O valor informado está fora dos limites permitidos.");

                return quantidadeDeAndaresDoApartamento;

            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número inteiro.");
                sc.nextLine();
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int obterQuantidadeDeVagasNoEstacionamento() {
        while (true) {
            try {
                System.out.print("\nInforme a quantidade de vagas do apartamento(mínimo 4): ");
                int quantidadeDeVagasNoApartamento = sc.nextInt();
                sc.nextLine();

                if (quantidadeDeVagasNoApartamento < 4)
                    throw new ValorInvalidoException("O valor informado está fora dos limites permitidos.");

                return quantidadeDeVagasNoApartamento;

            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número inteiro.");
                sc.nextLine();
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Terreno
    public static String obterTipoDeZona() {
        while (true) {
            try {
                System.out.print("\n1 - Residencial\n2 - Comercial\n\nInforme o tipo de zona do terreno: ");
                int tipoDeZona = sc.nextInt();
                sc.nextLine();

                if (tipoDeZona == 1)
                    return "Residencial";
                if (tipoDeZona == 2)
                    return "Comercial";

                System.out.println("Opção inválida");

            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número inteiro.");
                sc.nextLine();
            }
        }
    }
}