package painel;

import modelo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class WindowListar extends WindowGeral{
    JComboBox jComboBoxlistaDeFinanciamentos;


    WindowListar(ArrayList<Financiamento> financiamentos, int colunas) {
        super(financiamentos, colunas);
        this.financiamentos = financiamentos;


        // JComboBox Lista de financiamentos já registrados
        jComboBoxlistaDeFinanciamentos = new JComboBox(codigosArray);
        jComboBoxlistaDeFinanciamentos.setBounds(50,25,190,20);
        jComboBoxlistaDeFinanciamentos.addActionListener(this::visualizarInformacoes);
        panelInformacoesDoFinanciamento.add(jComboBoxlistaDeFinanciamentos);


        setVisible(true);
    }


    private void visualizarInformacoes(ActionEvent actionEvent) {
        // Controlando a visibilidade de valores específicos
        jLabelQuantidadeDeAndares.setVisible(false);
        jLabelQuantidadeDeVagasDoEstacionamento.setVisible(false);
        jLabelAreaTerreno.setVisible(false);
        jLabelAreaConstruida.setVisible(false);
        jLabelTipoDeZona.setVisible(false);

        /*
        Varre o ArrayList de financiamentos para encontrar o financiamento que possui o código identico ao informado pelo usuário,
        em seguida mostra todas as informações pertinentes controlando a visibilidade de cada JLabel.
         */
        for (Financiamento financiamento : financiamentos) {
            if ((int) jComboBoxlistaDeFinanciamentos.getSelectedItem() == financiamento.getCodigo()) {
                jLabelTipoImovel.setText("Tipo do imóvel: " + financiamento.getTipoDoImovel());
                jLabelValorImovel.setText("Valor do imóvel: " + financiamento.getValorImovel());
                jLabelPrazoEmAnos.setText("Prazo(em anos): " + financiamento.getPrazoFinanciamentoEmAnos());
                jLabelJurosAnual.setText("Juros anual: " + financiamento.getTaxaJurosAnual());

                // Jlabels da classe Apartamento
                if (financiamento instanceof Apartamento) {
                    int andares = ((Apartamento) financiamento).getQuantidadeDeAndares();
                    int vagas = ((Apartamento) financiamento).getQuantidadeDeVagasDoEstacionamento();

                    jLabelQuantidadeDeAndares.setVisible(true);
                    jLabelQuantidadeDeVagasDoEstacionamento.setVisible(true);
                    jLabelQuantidadeDeAndares.setText("Andares: " + andares);
                    jLabelQuantidadeDeVagasDoEstacionamento.setText("Vagas: " + vagas);
                    break;

                //  Jlabels da classe Casa
                } else if (financiamento instanceof Casa) {
                    double areaTerreno = ((Casa) financiamento).getAreaTerreno();
                    double areaConstruida = ((Casa) financiamento).getAreaConstruida();

                    jLabelAreaTerreno.setVisible(true);
                    jLabelAreaConstruida.setVisible(true);
                    jLabelAreaTerreno.setText("Área do terreno: " + areaTerreno);
                    jLabelAreaConstruida.setText("Área construída: " + areaConstruida);
                    break;

                //  Jlabels da classe Terreno
                } else if (financiamento instanceof Terreno){
                    String tipoDeZona = ((Terreno) financiamento).getTipoDeZona();

                    jLabelTipoDeZona.setVisible(true);
                    jLabelTipoDeZona.setText("Tipo de Zona: " + tipoDeZona);
                    break;
                }
            }
        }
    }
}