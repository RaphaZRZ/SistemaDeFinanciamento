/*
Arrumar JComboBox editar, item sempre em residencial
 */

package painel;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.ValidarValores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class WindowEditar extends WindowGeral {
    JComboBox<Integer> jComboBoxListaDeFinanciamentos;
    JTextField jTextFieldValorImovel;
    JTextField jTextFieldPrazoEmAnos;
    JTextField jTextFieldJurosAnual;
    JTextField jTextFieldQuantidadeDeAndares;
    JTextField jTextFieldQuantidadeDeVagas;
    JTextField jTextFieldAreaTerreno;
    JTextField jTextFieldAreaConstruida;
    JComboBox<String> jComboBoxTipoDeZona;
    JButton jButtonAtualizar;


    WindowEditar(ArrayList<Financiamento> financiamentos, int colunas) {
        super(financiamentos, colunas);
        this.financiamentos = financiamentos;


        // JComboBox Lista de financiamentos já registrados
        jComboBoxListaDeFinanciamentos = new JComboBox<>(codigosArray);
        jComboBoxListaDeFinanciamentos.setBounds(50,25,190,20);
        jComboBoxListaDeFinanciamentos.addActionListener(this::visualizarInformacoes);
        panelInformacoesDoFinanciamento.add(jComboBoxListaDeFinanciamentos);


        // JTextField Informações obrigatórias de cada imóvel financiado
        jTextFieldValorImovel = new JTextField();
        jTextFieldValorImovel.setBounds(165,131,110,20);
        jTextFieldValorImovel.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldPrazoEmAnos = new JTextField();
        jTextFieldPrazoEmAnos.setBounds(165,181,110,20);
        jTextFieldPrazoEmAnos.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldJurosAnual = new JTextField();
        jTextFieldJurosAnual.setBounds(165,231,110,20);
        jTextFieldJurosAnual.setFont(new Font("Arial", Font.BOLD, 15));

        panelInformacoesDoFinanciamento.add(jTextFieldValorImovel);
        panelInformacoesDoFinanciamento.add(jTextFieldPrazoEmAnos);
        panelInformacoesDoFinanciamento.add(jTextFieldJurosAnual);


        // JTextField Informações específicas de cada imóvel financiado
        jTextFieldQuantidadeDeAndares = new JTextField();
        jTextFieldQuantidadeDeAndares.setBounds(165,281,110,20);
        jTextFieldQuantidadeDeAndares.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldQuantidadeDeVagas = new JTextField();
        jTextFieldQuantidadeDeVagas.setBounds(165,331,110,20);
        jTextFieldQuantidadeDeVagas.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldAreaTerreno = new JTextField();
        jTextFieldAreaTerreno.setBounds(165,281,110,20);
        jTextFieldAreaTerreno.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldAreaConstruida = new JTextField();
        jTextFieldAreaConstruida.setBounds(165,331,110,20);
        jTextFieldAreaConstruida.setFont(new Font("Arial", Font.BOLD, 15));


        panelInformacoesDoFinanciamento.add(jTextFieldQuantidadeDeAndares);
        panelInformacoesDoFinanciamento.add(jTextFieldQuantidadeDeVagas);
        panelInformacoesDoFinanciamento.add(jTextFieldAreaTerreno);
        panelInformacoesDoFinanciamento.add(jTextFieldAreaConstruida);


        // JComboBox Tipo de zona do terreno
        String[] zonas = {"Residencial", "Comercial"};
        jComboBoxTipoDeZona = new JComboBox<>(zonas);
        jComboBoxTipoDeZona.setBounds(165,281,110,20);
        panelInformacoesDoFinanciamento.add(jComboBoxTipoDeZona);


        // JButton Salvar(atualiza os valores do financiamento)
        jButtonAtualizar = new JButton("Atualizar");
        jButtonAtualizar.setFont(new Font("Arial", Font.BOLD, 25));
        jButtonAtualizar.setForeground(new Color(200, 200, 200));
        jButtonAtualizar.setBackground(new Color(50, 50, 50));
        jButtonAtualizar.addActionListener(this::atualizarFinanciamentos);
        panelBotoes.add(jButtonAtualizar);


        setVisible(true);


        // Deixando os JTextFields e JComboBox específicos invisíveis
        jTextFieldQuantidadeDeAndares.setVisible(false);
        jTextFieldQuantidadeDeVagas.setVisible(false);
        jTextFieldAreaTerreno.setVisible(false);
        jTextFieldAreaConstruida.setVisible(false);
        jComboBoxTipoDeZona.setVisible(false);
    }


    private void visualizarInformacoes(ActionEvent actionEvent) {
        // Controlando a visibilidade de valores específicos
        jLabelQuantidadeDeAndares.setVisible(false);
        jLabelQuantidadeDeVagasDoEstacionamento.setVisible(false);
        jLabelAreaTerreno.setVisible(false);
        jLabelAreaConstruida.setVisible(false);
        jLabelTipoDeZona.setVisible(false);

        jTextFieldQuantidadeDeAndares.setVisible(false);
        jTextFieldQuantidadeDeVagas.setVisible(false);
        jTextFieldAreaTerreno.setVisible(false);
        jTextFieldAreaConstruida.setVisible(false);
        jComboBoxTipoDeZona.setVisible(false);

        /*
        Varre o ArrayList de financiamentos para encontrar o financiamento que possui o código identico ao informado pelo usuário,
        em seguida mostra todas as informações pertinentes controlando a visibilidade de cada JLabel.
         */

        for (Financiamento financiamento : financiamentos) {
            if ((int) jComboBoxListaDeFinanciamentos.getSelectedItem() == financiamento.getCodigo()) {
                jLabelTipoImovel.setText("Tipo do imóvel: " + financiamento.getTipoDoImovel());
                jTextFieldValorImovel.setText(Double.toString(financiamento.getValorImovel()));
                jTextFieldPrazoEmAnos.setText(Integer.toString(financiamento.getPrazoFinanciamentoEmAnos()));
                jTextFieldJurosAnual.setText(Double.toString(financiamento.getTaxaJurosAnual()));

                // Jlabels e JTextFields da classe Apartamento
                switch (financiamento) {
                    case Apartamento apartamento:
                        jTextFieldQuantidadeDeAndares.setText(Integer.toString(apartamento.getQuantidadeDeAndares()));
                        jTextFieldQuantidadeDeVagas.setText(Integer.toString(apartamento.getQuantidadeDeVagasDoEstacionamento()));


                        jLabelQuantidadeDeAndares.setVisible(true);
                        jLabelQuantidadeDeVagasDoEstacionamento.setVisible(true);
                        jTextFieldQuantidadeDeAndares.setVisible(true);
                        jTextFieldQuantidadeDeVagas.setVisible(true);
                        break;

                    // Jlabels e JTextFields da classe Casa
                    case Casa casa:
                        jTextFieldAreaTerreno.setText(Double.toString(casa.getAreaTerreno()));
                        jTextFieldAreaConstruida.setText(Double.toString(casa.getAreaConstruida()));

                        jLabelAreaTerreno.setVisible(true);
                        jLabelAreaConstruida.setVisible(true);
                        jTextFieldAreaTerreno.setVisible(true);
                        jTextFieldAreaConstruida.setVisible(true);
                        break;

                    // Jlabels e JTextFields da classe Terreno
                    case Terreno _:
                        jLabelTipoDeZona.setVisible(true);
                        jComboBoxTipoDeZona.setVisible(true);
                        break;

                    default:
                        break;
                }
            }
        }
    }


    // JButton Atualizar
    private void atualizarFinanciamentos(ActionEvent actionEvent) {
        for (Financiamento financiamento : financiamentos) {
            if ((int) jComboBoxListaDeFinanciamentos.getSelectedItem() == financiamento.getCodigo()) {
                try {
                    int controle = 0;

                    // Valida os valores obrigatórios alterados
                    float valorImovel = Float.parseFloat(jTextFieldValorImovel.getText());
                    int prazoFinanciamento = Integer.parseInt(jTextFieldPrazoEmAnos.getText());
                    float jurosAnual = Float.parseFloat(jTextFieldJurosAnual.getText());

                    if (ValidarValores.financiamentoGeral(valorImovel, prazoFinanciamento, jurosAnual)) {
                        switch (financiamento) {
                            case Apartamento apartamento -> {
                                int quantidadeDeAndares = Integer.parseInt(jTextFieldQuantidadeDeAndares.getText());
                                int quantidadeDeVagas = Integer.parseInt((jTextFieldQuantidadeDeVagas.getText()));

                                if (ValidarValores.apartamento(quantidadeDeAndares, quantidadeDeVagas)) {
                                    apartamento.setQuantidadeDeAndares(quantidadeDeAndares);
                                    apartamento.setQuantidadeDeVagasDoEstacionamento(quantidadeDeVagas);
                                    controle = 1;
                                }
                            }

                            case Casa casa -> {
                                double areaTerreno = Double.parseDouble(jTextFieldAreaTerreno.getText());
                                double areaConstruida = Double.parseDouble(jTextFieldAreaConstruida.getText());

                                if (ValidarValores.casa(areaTerreno, areaConstruida)) {
                                    casa.setAreaTerreno(areaTerreno);
                                    casa.setAreaConstruida(areaConstruida);
                                    controle = 1;
                                }
                            }

                            case Terreno terreno -> {
                                String tipoDeZona = (String) jComboBoxTipoDeZona.getSelectedItem();

                                terreno.setTipoDeZona(tipoDeZona);
                                controle = 1;
                            }

                            default -> {
                            }
                        }

                        financiamento.setValorImovel(valorImovel);
                        financiamento.setPrazoFinanciamentoEmAnos(prazoFinanciamento);
                        financiamento.setTaxaJurosAnual(jurosAnual);

                        if (controle == 1) {
                            JOptionPane.showMessageDialog(null, "Informações atualizadas.",
                                    "Financiamento Atualizado", JOptionPane.INFORMATION_MESSAGE, rightPNG);
                            }
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Valores inválidos.",
                            "ERROR: Valores incompatíveis.", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
