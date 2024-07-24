package modelo;


public class Terreno extends Financiamento{
    private String tipoDeZona;

    public Terreno(int codigo, double valorTerreno, int prazoFinanciamentoEmAnos, double taxaJurosAnual, String tipoDeZona) {
        super(codigo, valorTerreno, prazoFinanciamentoEmAnos, taxaJurosAnual);
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

    public String toString() {
        return "Valor do imóvel: " + this.getValorImovel() + "\n" +
                "Valor do financiamento: " + this.calcularPagamentoDoFinanciamento() + "\n" +
                "Custo de cada parcela: " + this.calcularPagamentoMensal() + "\n" +
                "Tipo de zona: " + this.tipoDeZona + "\n\n";
    }
}
