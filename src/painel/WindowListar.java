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

        for (Financiamento financiamento : financiamentos) {
            if ((int) jComboBoxListaDeFinanciamentos.getSelectedItem() == financiamento.getCodigo()) {
                jLabelTipoImovel.setText("Tipo do imóvel: " + financiamento.getTipoDoImovel());
                jLabelValorImovel.setText("Valor do imóvel: " + financiamento.getValorImovel());
                jLabelPrazoEmAnos.setText("Prazo(em anos): " + financiamento.getPrazoFinanciamentoEmAnos());
                jLabelJurosAnual.setText("Juros anual: " + financiamento.getTaxaJurosAnual());

                // Jlabels da classe Apartamento
                switch (financiamento) {
                    case Apartamento apartamento:
                        jLabelQuantidadeDeAndares.setVisible(true);
                        jLabelQuantidadeDeVagasDoEstacionamento.setVisible(true);
                        jLabelQuantidadeDeAndares.setText("Andares: " + apartamento.getQuantidadeDeAndares());
                        jLabelQuantidadeDeVagasDoEstacionamento.setText("Vagas: " + apartamento.getQuantidadeDeVagasDoEstacionamento());
                        break;

                    //  Jlabels da classe Casa
                    case Casa casa:
                        jLabelAreaTerreno.setVisible(true);
                        jLabelAreaConstruida.setVisible(true);
                        jLabelAreaTerreno.setText("Área do terreno: " + casa.getAreaTerreno());
                        jLabelAreaConstruida.setText("Área construída: " + casa.getAreaConstruida());
                        break;

                    //  Jlabels da classe Terreno
                    case Terreno terreno:
                        jLabelTipoDeZona.setVisible(true);
                        jLabelTipoDeZona.setText("Tipo de Zona: " + terreno.getTipoDeZona());
                        break;

                    default:
                        break;
                }
            }
        }
    }
}