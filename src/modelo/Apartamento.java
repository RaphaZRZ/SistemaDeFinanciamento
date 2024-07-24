package modelo;


public class Apartamento extends Financiamento{
    private int quantidadeDeAndares;
    private int quantidadeDeVagasDoEstacionamento;

    public Apartamento(int codigo, String tipoDoImovel, double valorApartamento, int prazoFinanciamentoEmAnos, double taxaJurosAnual, int quantidadeDeAndares, int quantidadeDeVagasDoEstacionamento) {
        super(codigo, tipoDoImovel, valorApartamento, prazoFinanciamentoEmAnos, taxaJurosAnual);
        this.quantidadeDeAndares = quantidadeDeAndares;
        this.quantidadeDeVagasDoEstacionamento = quantidadeDeVagasDoEstacionamento;
    }

    // getters
    public int getQuantidadeDeAndares() {
        return quantidadeDeAndares;
    }

    public int getQuantidadeDeVagasDoEstacionamento() {
        return quantidadeDeVagasDoEstacionamento;
    }

    // Método PRICE
    public double calcularPagamentoMensal() {
        /*
        Esta fórmula apresenta resultados mais precisos, porém esta não é a fórmula contida nas instruções do projeto.

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

    public String toString() {
        return "Valor do imóvel: " + this.getValorImovel() + "\n" +
                "Valor do financiamento: " + this.calcularPagamentoDoFinanciamento() + "\n" +
                "Custo de cada parcela: " + this.calcularPagamentoMensal() + "\n" +
                "Quantidade de andres: " + this.quantidadeDeAndares + "\n" +
                "Quantidade de vagas no estacionamento: " + this.quantidadeDeVagasDoEstacionamento + "\n\n";
    }
}
