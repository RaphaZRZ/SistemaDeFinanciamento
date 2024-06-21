package modelo;


public class Terreno extends Financiamento{
    private String tipoDeZona;

    public Terreno(double valorTerreno, int prazoFinanciamentoEmAnos, double taxaJurosAnual, String tipoDeZona) {
        super(valorTerreno, prazoFinanciamentoEmAnos, taxaJurosAnual);
        this.tipoDeZona = tipoDeZona;
    }

    // Acréscimo de 2% no valor da parcela
    public double calcularPagamentoMensal() {
        return ((this.valorImovel / this.prazoFinanciamentoEmMeses) * (1 + this.taxaJurosMensal)) * 1.02;
    }

    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.printf("Tipo de zona: %s\n", this.tipoDeZona);
    }
}
