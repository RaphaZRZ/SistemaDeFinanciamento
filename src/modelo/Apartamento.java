package modelo;


public class Apartamento extends Financiamento{
    private int quantidadeDeAndares;
    private int quantidadeDeVagasDoEstacionamento;

    public Apartamento(double valorApartamento, int prazoFinanciamentoEmAnos, double taxaJurosAnual, int quantidadeDeAndares, int quantidadeDeVagasDoEstacionamento) {
        super(valorApartamento, prazoFinanciamentoEmAnos, taxaJurosAnual);
        this.quantidadeDeAndares = quantidadeDeAndares;
        this.quantidadeDeVagasDoEstacionamento = quantidadeDeVagasDoEstacionamento;
    }

    // Método PRICE
    public double calcularPagamentoMensal() {
        /*
        Esta fórmula apresenta resultados mais precisos, porém está não é a fórmula contida nas instruções do projeto.

        return ((this.valorImovel * Math.pow(1 + this.taxaJurosMensal, this.prazoFinanciamentoEmMeses)) /
                Math.pow(1 + this.taxaJurosMensal, this.prazoFinanciamentoEmMeses - 1)) / this.prazoFinanciamentoEmMeses;
         */
        return (this.valorImovel * Math.pow(1 + this.taxaJurosMensal, this.prazoFinanciamentoEmMeses)) /
                Math.pow(1 + this.taxaJurosMensal, this.prazoFinanciamentoEmMeses - 1);
    }


    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.printf("Quantidade de andres: %d\nQuantidade de vagas no estacionamento: %d\n",
                this.quantidadeDeAndares, this.quantidadeDeVagasDoEstacionamento);
    }
}
