package modelo;

import java.io.Serializable;


public abstract class Financiamento implements Serializable {
    protected int codigo;
    protected double valorImovel;
    protected int prazoFinanciamentoEmAnos;
    protected int prazoFinanciamentoEmMeses;
    protected double taxaJurosAnual;
    protected double taxaJurosMensal;

    public Financiamento(int codigo, double valorImovel, int prazoFinanciamentoEmAnos, double taxaJurosAnual) {
        this.codigo = codigo;
        this.valorImovel = valorImovel;
        this.prazoFinanciamentoEmAnos = prazoFinanciamentoEmAnos;
        this.taxaJurosAnual = taxaJurosAnual;
        this.prazoFinanciamentoEmMeses = this.prazoFinanciamentoEmAnos * 12;
        this.taxaJurosMensal = this.taxaJurosAnual / 12;
    }

    // getters
    public int getCodigo() {
        return codigo;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamentoEmAnos() {
        return prazoFinanciamentoEmAnos;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // setters
    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }

    public void setPrazoFinanciamentoEmAnos(int prazoFinanciamentoEmAnos) {
        this.prazoFinanciamentoEmAnos = prazoFinanciamentoEmAnos;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // métodos
    public double calcularPagamentoMensalSemJuros() {
        return (this.valorImovel / this.prazoFinanciamentoEmMeses);
    }

    public abstract double calcularPagamentoMensal();

    public double calcularPagamentoDoFinanciamento() {
        return this.calcularPagamentoMensal() * (this.prazoFinanciamentoEmMeses);
    }

    public void mostrarInformacoes() {
        System.out.printf("\nValor do imóvel: R$%.2f\nValor do financiamento: R$%.2f\nCusto de cada parcela: R$%.2f\n",
                getValorImovel(), calcularPagamentoDoFinanciamento(), calcularPagamentoMensal());
    }

    public abstract String toString();

}
