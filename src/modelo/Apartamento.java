package modelo;

public class Apartamento extends Financiamento{
    public Apartamento(double valorApartamento, int prazoFinanciamentoEmAnos, double taxaJurosAnual) {
        super(valorApartamento, prazoFinanciamentoEmAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        // Financiamento com sistema de amortização chamado PRICE.
        // PARA ARRUMAR O CÁLCULO
        return (this.valorImovel * Math.pow(1 + this.taxaJurosMensal, this.prazoFinanciamentoEmMeses)) /
                (Math.pow(1 + this.taxaJurosMensal, this.prazoFinanciamentoEmMeses - 1));
    }
}
