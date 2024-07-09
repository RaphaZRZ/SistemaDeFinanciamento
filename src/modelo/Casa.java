package modelo;

import Exceptions.AcrescimoMaiorQueJurosException;


public class Casa extends Financiamento{
    private double areaTerreno;
    private double areaConstruida;

    public Casa(double valorCasa, int prazoFinanciamentoEmAnos, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorCasa, prazoFinanciamentoEmAnos, taxaJurosAnual);
        this.areaTerreno = areaTerreno;
        this.areaConstruida = areaConstruida;
    }

    // Acréscimo de no máximo R$80,00 em cada parcela, porém o acréscimo não pode ser superior aos juros da parcela.
    public double calcularPagamentoMensal() {
        // Cálculo do pagamento mensal com juros porém sem o acréscimo.
        double mensalidadeComJuros = ((this.valorImovel / this.prazoFinanciamentoEmMeses) * (1 + this.taxaJurosMensal));
        double diferencaEntreMensalidadeComJurosSemJuros = mensalidadeComJuros - calcularPagamentoMensalSemJuros();

        try {
            if (diferencaEntreMensalidadeComJurosSemJuros < 80)
                throw new AcrescimoMaiorQueJurosException("O acréscimo não pode ser superior ao valor dos juros.");

            return mensalidadeComJuros + 80;

        } catch (AcrescimoMaiorQueJurosException e) {
            return ((this.valorImovel / this.prazoFinanciamentoEmMeses) * (1 + this.taxaJurosMensal)) + diferencaEntreMensalidadeComJurosSemJuros;
        }
    }

    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.printf("Área construída: %.2f metros quadrados\nÁrea do Terreno: %.2f metros quadrados\n",
                this.areaConstruida, this.areaTerreno);
    }

    public String toString() {
        return "Valor do imóvel: " + this.getValorImovel() + "\n" +
                "Valor do financiamento: " + this.calcularPagamentoDoFinanciamento() + "\n" +
                "Custo de cada parcela: " + this.calcularPagamentoMensal() + "\n" +
                "Área construída: " + this.areaConstruida + " metros quadrados\n" +
                "Área do Terreno: " + this.areaTerreno + " metros quadrados\n\n";
    }
}
