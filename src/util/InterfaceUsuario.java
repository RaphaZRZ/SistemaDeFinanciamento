package util;
import java.util.Scanner;


public class InterfaceUsuario {
    static Scanner sc = new Scanner(System.in);

    // Financiamento
    public static String obterTipoFinanciamento() {
        while (true) {
            System.out.print("\n1 - Casa\n2 - Apartamento\n3 - Terreno\n\nInforme o que deseja financiar: ");
            int escolha = sc.nextInt();
            sc.nextLine();

            if (escolha == 1)
                return "Casa";
            if (escolha == 2)
                return "Apartamento";
            if (escolha == 3)
                return "Terreno";

            System.out.println("Opção inválida");
        }
    }

    public static double obterValorImovel() {
        while (true) {
            System.out.print("\nInforme o valor do imóvel(mínimo R$50.000): ");
            double preco = sc.nextDouble();
            sc.nextLine();

            if (preco < 50000) {
                System.out.println("Valor inválido, tente novamente.");
                continue;
            }
            return preco;
        }
    }

    public static int obterPrazoDoFinanciamentoEmAnos() {
        while (true) {
            System.out.print("\nInforme o prazo do financiamento em anos(mínimo 1 | máximo 35): ");
            int prazoEmAnos = sc.nextInt();
            sc.nextLine();

            if ((prazoEmAnos < 1) || prazoEmAnos > 35) {
                System.out.println("Valor inválido, tente novamente.");
                continue;
            }
            return prazoEmAnos;
        }
    }

    public static double obterTaxaDeJurosAnual() {
        while (true) {
            System.out.print("\nInforme a taxa de juros anual(mínimo 6% | máximo 12%): ");
            double taxaDeJurosAnual = sc.nextDouble();
            sc.nextLine();

            if ((taxaDeJurosAnual < 6) || (taxaDeJurosAnual > 12)) {
                System.out.println("Valor inválido, tente novamente.");
                continue;
            }
            return taxaDeJurosAnual / 100;
        }
    }

    // Casa
    public static double obterAreaConstruida(double areaTerreno) {
        while (true) {
            System.out.print("\nInforme em metros quadrados a área da casa: ");
            double areaConstruida = sc.nextDouble();
            sc.nextLine();

            if (areaConstruida > areaTerreno) {
                System.out.println("A área construída não pode ser maior que a área do terreno.");
                continue;
            }

            if (areaConstruida < 2.5) {
                System.out.println("A área construída não pode ser inferior a 2,5 metros quadrados.");
                continue;
            }

            return areaConstruida;
        }
    }

    public static double obterAreaTerreno() {
        while (true) {
            System.out.print("\nInforme em metros quadrados a área do terreno: ");
            double areaTerreno = sc.nextDouble();
            sc.nextLine();

            if (areaTerreno < 2.5) {
                System.out.println("A área do terreno não pode ser inferior a 2,5 metros quadrados.");
                continue;
            }
            return areaTerreno;
        }
    }

    // Apartamento
    public static int obterQuantidadeDeAndaresDoApartamento() {
        System.out.print("\nInforme a quantidade de andares do apartamento: ");
        int quantidadeDeAndaresDoApartamento = sc.nextInt();
        sc.nextLine();
        return quantidadeDeAndaresDoApartamento;
    }

    public static int obterQuantidadeDeVagasNoEstacionamento() {
        System.out.print("\nInforme a quantidade de vagas do apartamento: ");
        int quantidadeDeVagasNoApartamento = sc.nextInt();
        sc.nextLine();
        return quantidadeDeVagasNoApartamento;
    }

    // Terreno
    public static String obterTipoDeZona() {
        while (true) {
            System.out.print("\n1 - Residencial\n2 - Comercial\n\nInforme o tipo de zona do terreno: ");
            int tipoDeZona = sc.nextInt();
            sc.nextLine();

            if (tipoDeZona == 1)
                return "Residencial";
            if (tipoDeZona == 2)
                return "Comercial";

            System.out.println("Opção inválida");
        }
    }
}