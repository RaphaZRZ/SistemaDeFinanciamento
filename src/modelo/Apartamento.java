package modelo;

public class Apartamento extends Financiamento{
    public Apartamento(double valorApartamento, int prazoFinanciamentoEmAnos, double taxaJurosAnual) {
        super(valorApartamento, prazoFinanciamentoEmAnos, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        /*
        Está fórmula apresenta resultados mais precisos, porém está não é a fórmula contida nas instruções do projeto.

        return ((this.valorImovel * Math.pow(1 + this.taxaJurosMensal, this.prazoFinanciamentoEmMeses)) /
                Math.pow(1 + this.taxaJurosMensal, this.prazoFinanciamentoEmMeses - 1)) / this.prazoFinanciamentoEmMeses;
         */
        return (this.valorImovel * Math.pow(1 + this.taxaJurosMensal, this.prazoFinanciamentoEmMeses)) /
                Math.pow(1 + this.taxaJurosMensal, this.prazoFinanciamentoEmMeses - 1);
    }
}
