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

    public static int obterQuantidadeDeParcelasDoFinanciamento() {
        while (true) {
            System.out.println();
            System.out.print("Informe em quantas parcelas deseja pagar o imóvel(mínimo 12 | máximo 420): ");
            int parcelas = sc.nextInt();
            sc.nextLine();

            if ((parcelas < 12) || parcelas > 420) {
                System.out.println("Valor inválido, tente novamente.");
                continue;
            }
            return parcelas;
        }
    }

    public static double obterTaxaDeJuros() {
        while (true) {
            System.out.println();
            System.out.print("Informe a taxa de juros(mínimo 6% | máximo 12%): ");
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
