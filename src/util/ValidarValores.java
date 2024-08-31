package util;

import exceptions.*;

import javax.swing.*;


public class ValidarValores {
    // Validação obrigatória para qualquer imóvel
    private static void valorImovel(float valor) throws ValorImovelInvalidoException{
        if (valor < 50000)
            throw new ValorImovelInvalidoException("O valor informado está fora dos limites permitidos.");
    }

    private static void prazoDoFinanciamentoEmAnos(int prazo) throws PrazoFinanciamentoInvalidoException {
        if ((prazo < 1) || prazo > 35)
            throw new PrazoFinanciamentoInvalidoException("O valor informado está fora dos limites permitidos.");
    }

    private static void taxaDeJurosAnual(float jurosAnual) throws JurosFinanciamentoInvalidoException {
        if ((jurosAnual < 6) || (jurosAnual > 12))
            throw new JurosFinanciamentoInvalidoException("O valor informado está fora dos limites permitidos.");
    }

    // Validação informações gerais de qualquer financiamento
    public static boolean financiamentoGeral(float valor, int prazo, float jurosAnual) {
        try {
            valorImovel(valor);
            prazoDoFinanciamentoEmAnos(prazo);
            taxaDeJurosAnual(jurosAnual);

            return true;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valores inválidos.",
                    "ERROR: Valores incompatíveis.", JOptionPane.ERROR_MESSAGE);
        } catch (ValorImovelInvalidoException e) {
            JOptionPane.showMessageDialog(null, "Insira um valor maior ou igual a R$50000.00.",
                    "ERROR: Valor do imóvel inválido.", JOptionPane.ERROR_MESSAGE);
        } catch (PrazoFinanciamentoInvalidoException e) {
            JOptionPane.showMessageDialog(null, "Insira um valor inteiro entre 0 e 36.",
                    "ERROR: Prazo do financiamento inválido.", JOptionPane.ERROR_MESSAGE);
        } catch (JurosFinanciamentoInvalidoException e) {
            JOptionPane.showMessageDialog(null, "Insira um valor maior ou igual a 6% e menor ou igual a 12%.",
                    "ERROR: Juros do financiamento inválido.", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }


    // Validação Apartamento
    private static void quantidadeDeAndares(int andares) throws QuantidadeDeAndaresInvalidaException {
        if (andares < 4)
            throw new QuantidadeDeAndaresInvalidaException("O valor informado está fora dos limites permitidos.");
    }

    private static void quantidadeDeVagas(int vagas, int andares) throws QuantidadeDeVagasInvalidaException {
        if (vagas < andares)
            throw new QuantidadeDeVagasInvalidaException("O valor informado está fora dos limites permitidos.");
    }

    public static boolean apartamento(int andares, int vagas) {
        try {
            quantidadeDeAndares(andares);
            quantidadeDeVagas(vagas, andares);

            return true;

        } catch (QuantidadeDeAndaresInvalidaException e) {
            JOptionPane.showMessageDialog(null, "Insira um valor inteiro maior ou igual a 4.",
                    "ERROR: Quantidade de andares inválida.", JOptionPane.ERROR_MESSAGE);
        } catch (QuantidadeDeVagasInvalidaException e) {
            JOptionPane.showMessageDialog(null, "Quantidade de vagas não pode ser inferior a quantidade de andares.",
                    "ERROR: Quantidade de vagas inválida.", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }


    // Validação Casa
    private static void areaTerreno(double terreno) throws AreaTerrenoInvalidaException {
        if (terreno < 2.5)
            throw new AreaTerrenoInvalidaException("O valor informado está fora dos limites permitidos.");
    }

    private static void areaConstruida(double construida, double terreno) throws AreaConstruidaInvalidaException {
        if (construida > terreno)
            throw new AreaConstruidaInvalidaException("Valor inválido. A área construída não pode ser maior que a área do terreno.");
    }

    public static boolean casa(double terreno, double construida) {
        try {
            areaTerreno(terreno);
            areaConstruida(construida, terreno);

            return true;

        } catch(AreaTerrenoInvalidaException e) {
            JOptionPane.showMessageDialog(null, "Área do terreno não pode ser inferior a 2,5 metros.",
                    "ERROR: Área do terreno inválida.", JOptionPane.ERROR_MESSAGE);
        } catch(AreaConstruidaInvalidaException e) {
            JOptionPane.showMessageDialog(null, "Área construida não pode ser superior a área do terreno.",
                    "ERROR: Área construída inválida.", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

}