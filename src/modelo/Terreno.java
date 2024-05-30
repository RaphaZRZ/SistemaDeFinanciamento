package modelo;

public class Terreno extends Financiamento{
    public Terreno(double valorTerreno, int prazoFinanciamentoEmAnos, double taxaJurosAnual) {
        super(valorTerreno, prazoFinanciamentoEmAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        // Acréscima de 2% em cada parcela com juros já inclusos
        // ARRUMAR     ///     ARRUMAR     ///     ARRUMAR     ///     ARRUMAR     ///
        return super.calcularPagamentoMensal() + (calcularPagamentoMensal() * 2 / 100);
    }
}
