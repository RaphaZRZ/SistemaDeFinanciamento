package util;
import java.util.Scanner;

public class InterfaceUsuario {
    static Scanner sc = new Scanner(System.in);

    public static double obterValorImovel() {
        while (true) {
            System.out.println();
            System.out.print("Informe o valor do imóvel(mínimo R$50.000): ");
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
}
