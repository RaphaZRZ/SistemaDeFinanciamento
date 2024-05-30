package modelo;

public class Apartamento extends Financiamento{
    public Apartamento(double valorApartamento, int prazoFinanciamentoEmAnos, double taxaJurosAnual) {
        super(valorApartamento, prazoFinanciamentoEmAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        // Financiamento com sistema de amortização chamado PRICE.
        double taxaJurosMensal = this.taxaJurosAnual / 12;
        int prazoFinanciamentoEmMeses = this.prazoFinanciamentoEmAnos * 12;
        return (this.valorImovel * Math.pow(1 + taxaJurosMensal, prazoFinanciamentoEmMeses))/Math.pow(1 + taxaJurosMensal, prazoFinanciamentoEmMeses - 1);
    }
}
