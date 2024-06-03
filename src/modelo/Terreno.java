package modelo;

public class Terreno extends Financiamento{
    public Terreno(double valorTerreno, int prazoFinanciamentoEmAnos, double taxaJurosAnual) {
        super(valorTerreno, prazoFinanciamentoEmAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() * 1.02;
    }
}
