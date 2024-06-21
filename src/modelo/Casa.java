package modelo;


public class Casa extends Financiamento{
    private double areaTerreno;
    private double areaConstruida;

    public Casa(double valorCasa, int prazoFinanciamentoEmAnos, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorCasa, prazoFinanciamentoEmAnos, taxaJurosAnual);
        this.areaTerreno = areaTerreno;
        this.areaConstruida = areaConstruida;
    }

    // Acréscima de R$80,00 em cada parcela
    public double calcularPagamentoMensal() {
        return ((this.valorImovel / this.prazoFinanciamentoEmMeses) * (1 + this.taxaJurosMensal)) + 80;
    }

    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.printf("Área construída: %.2f metros quadrados\nÁrea do Terreno: %.2f metros quadrados\n",
                this.areaConstruida, this.areaTerreno);
    }
}
