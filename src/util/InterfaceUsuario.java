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
            int prazo = sc.nextInt();
            sc.nextLine();

            if ((prazo < 1) || prazo > 35) {
                System.out.println("Valor inválido, tente novamente.");
                continue;
            }
            return prazo;
        }
    }

    public static double obterTaxaDeJuros() {
        while (true) {
            System.out.print("\nInforme a taxa de juros(mínimo 6% | máximo 12%): ");
            double taxa = sc.nextDouble();
            sc.nextLine();

            if ((taxa < 6) || (taxa > 12)) {
                System.out.println("Valor inválido, tente novamente.");
                continue;
            }
            return taxa;
        }
    }
}
