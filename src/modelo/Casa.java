package modelo;

public class Casa extends Financiamento{
    public Casa(double valorCasa, int prazoFinanciamentoEmAnos, double taxaJurosAnual) {
        super(valorCasa, prazoFinanciamentoEmAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        // Acréscima de R$80,00 em cada parcela
        return super.calcularPagamentoMensal() + 80;
    }
}
