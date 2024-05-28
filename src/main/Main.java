package main;
import util.InterfaceUsuario;
import modelo.Financiamento;

public class Main {
    public static void main(String[] args) {
        double imovel1 = InterfaceUsuario.obterValorImovel();
        int parcela1 = InterfaceUsuario.obterQuantidadeDeParcelasDoFinanciamento();
        double taxa1 = InterfaceUsuario.obterTaxaDeJuros();
        Financiamento fin1 = new Financiamento(imovel1, parcela1, taxa1);
        fin1.mostrarInformacoes();
    }
}