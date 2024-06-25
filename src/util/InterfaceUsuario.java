package util;

import Exceptions.ValorInvalidoException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class InterfaceUsuario {
    static Scanner sc = new Scanner(System.in);

    // Financiamento
    public static String obterTipoFinanciamento() {
        while (true) {
            try {
                System.out.print("\n1 - Casa\n2 - Apartamento\n3 - Terreno\n\nInforme o que deseja financiar: ");
                int escolha = sc.nextInt();
                sc.nextLine();

                if (escolha == 1)
                    return "Casa";
                if (escolha == 2)
                    return "Apartamento";
                if (escolha == 3)
                    return "Terreno";

                System.out.println("Opção inexistente");

            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número inteiro.");
                sc.nextLine();
            }
        }
    }

    public static double obterValorImovel(){
        while (true) {
            try {
                System.out.print("\nInforme o valor do imóvel(mínimo R$50.000): ");
                double preco = sc.nextDouble();
                sc.nextLine();

                if (preco < 50000)
                    throw new ValorInvalidoException("O valor informado está fora dos limites permitidos.");

                return preco;

            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número.");
                sc.nextLine();
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int obterPrazoDoFinanciamentoEmAnos() {
        while (true) {
            try {
                System.out.print("\nInforme o prazo do financiamento em anos(mínimo 1 | máximo 35): ");
                int prazoEmAnos = sc.nextInt();
                sc.nextLine();

                if ((prazoEmAnos < 1) || prazoEmAnos > 35)
                    throw new ValorInvalidoException("O valor informado está fora dos limites permitidos.");

                return prazoEmAnos;

            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número inteiro.");
                sc.nextLine();
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static double obterTaxaDeJurosAnual() {
        while (true) {
            try {
                System.out.print("\nInforme a taxa de juros anual(mínimo 6% | máximo 12%): ");
                double taxaDeJurosAnual = sc.nextDouble();
                sc.nextLine();

                if ((taxaDeJurosAnual < 6) || (taxaDeJurosAnual > 12))
                    throw new ValorInvalidoException("O valor informado está fora dos limites permitidos.");

                return taxaDeJurosAnual / 100;

            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número.");
                sc.nextLine();
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
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