package modelo;

public class Financiamento {
    protected double valorImovel;
    protected int prazoFinanciamentoEmAnos;
    protected double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamentoEmAnos, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamentoEmAnos = prazoFinanciamentoEmAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamentoEmAnos;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // setters
    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }

    public void setPrazoFinanciamento(int prazoFinanciamento) {
        this.prazoFinanciamentoEmAnos = prazoFinanciamento;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // métodos
    public double calcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamentoEmAnos * 12)) * (1 + (this.taxaJurosAnual / 12));
    }

    public double calcularPagamentoFinanciamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamentoEmAnos * 12;
    }

    public void mostrarInformacoes() {
        System.out.printf("\nValor do imóvel: R$%.2f\nValor do financiamento: R$%.2f\nCusto de cada parcela: R$%.2f\n",
                getValorImovel(), calcularPagamentoFinanciamento(), calcularPagamentoMensal());
    }

}
