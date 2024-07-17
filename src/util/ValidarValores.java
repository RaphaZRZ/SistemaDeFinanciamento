package util;

import Exceptions.*;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ValidarValores {
    static Scanner sc = new Scanner(System.in);

    // Validação obrigatória
    public static void valorImovel(float preco) throws ValorImovelInvalidoException{
        if (preco < 50000)
            throw new ValorImovelInvalidoException("O valor informado está fora dos limites permitidos.");
    }

    public static void prazoDoFinanciamentoEmAnos(int prazo) throws PrazoFinanciamentoInvalidoException {
        if ((prazo < 1) || prazo > 35)
            throw new PrazoFinanciamentoInvalidoException("O valor informado está fora dos limites permitidos.");
    }

    public static void taxaDeJurosAnual(float juros) throws JurosFinanciamentoInvalidoException {
        if ((juros < 6) || (juros > 12))
            throw new JurosFinanciamentoInvalidoException("O valor informado está fora dos limites permitidos.");
    }


    // Validação Apartamento
    public static void quantidadeDeAndares(int andares) throws QuantidadeDeAndaresInvalidaException {
        if (andares < 4)
            throw new QuantidadeDeAndaresInvalidaException("O valor informado está fora dos limites permitidos.");
    }

    public static void quantidadeDeVagas(int vagas, int andares) throws QuantidadeDeVagasInvalidaException {
        if (vagas < andares)
            throw new QuantidadeDeVagasInvalidaException("O valor informado está fora dos limites permitidos.");
    }


    // Validação Casa
    public static void areaTerreno(double terreno) throws AreaTerrenoInvalidaException {
        if (terreno < 2.5)
            throw new AreaTerrenoInvalidaException("O valor informado está fora dos limites permitidos.");
    }

    public static void areaConstruida(double construida, double terreno) throws AreaConstruidaInvalidaException {
        if (construida > terreno)
            throw new AreaConstruidaInvalidaException("Valor inválido. A área construída não pode ser maior que a área do terreno.");
    }


    // Validação Terreno
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