package painel;

import modelo.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class WindowListar extends WindowGeral{
    WindowListar(ArrayList<Financiamento> financiamentos, int colunas) {
        super(financiamentos, colunas);
        this.financiamentos = financiamentos;

        jComboBoxListaDeFinanciamentos.addActionListener(this::visualizarInformacoes);
        panelInformacoesDoFinanciamento.add(jComboBoxListaDeFinanciamentos);


        setVisible(true);
    }


    private void visualizarInformacoes(ActionEvent actionEvent) {
        ocultarJLabelsEspecificas();

        label:
        for (Financiamento financiamento : financiamentos) {
            if ((int) jComboBoxListaDeFinanciamentos.getSelectedItem() == financiamento.getCodigo()) {
                jLabelTipoImovel.setText("Tipo do imóvel: " + financiamento.getTipoDoImovel());
                jLabelValorImovel.setText("Valor do imóvel: " + financiamento.getValorImovel());
                jLabelPrazoEmAnos.setText("Prazo(em anos): " + financiamento.getPrazoFinanciamentoEmAnos());
                jLabelJurosAnual.setText("Juros anual: " + financiamento.getTaxaJurosAnual());

                // Jlabels da classe Apartamento
                switch (financiamento) {
                    case Apartamento apartamento:
                        int andares = apartamento.getQuantidadeDeAndares();
                        int vagas = apartamento.getQuantidadeDeVagasDoEstacionamento();

                        jLabelQuantidadeDeAndares.setVisible(true);
                        jLabelQuantidadeDeVagasDoEstacionamento.setVisible(true);
                        jLabelQuantidadeDeAndares.setText("Andares: " + andares);
                        jLabelQuantidadeDeVagasDoEstacionamento.setText("Vagas: " + vagas);
                        break label;

                    //  Jlabels da classe Casa
                    case Casa casa:
                        double areaTerreno = casa.getAreaTerreno();
                        double areaConstruida = casa.getAreaConstruida();

                        jLabelAreaTerreno.setVisible(true);
                        jLabelAreaConstruida.setVisible(true);
                        jLabelAreaTerreno.setText("Área do terreno: " + areaTerreno);
                        jLabelAreaConstruida.setText("Área construída: " + areaConstruida);
                        break label;

                    //  Jlabels da classe Terreno
                    case Terreno terreno:
                        String tipoDeZona = terreno.getTipoDeZona();

                        jLabelTipoDeZona.setVisible(true);
                        jLabelTipoDeZona.setText("Tipo de Zona: " + tipoDeZona);
                        break label;
                    default:
                        break;
                }
            }
        }
    }
}