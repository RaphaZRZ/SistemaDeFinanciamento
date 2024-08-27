/*
Arrumar JComboBox editar, item sempre em residencial
 */

package painel;

import exceptions.*;
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
    JComboBox jComboBoxlistaDeFinanciamentos;
    JTextField jTextFieldValorImovel;
    JTextField jTextFieldPrazoEmAnos;
    JTextField jTextFieldJurosAnual;
    JTextField jTextFieldQuantidadeDeAndares;
    JTextField jTextFieldQuantidadeDeVagas;
    JTextField jTextFieldAreaTerreno;
    JTextField jTextFieldAreaConstruida;
    JComboBox jComboBoxTipoDeZona;
    JButton jButtonAtualizar;


    WindowEditar(ArrayList<Financiamento> financiamentos, int colunas) {
        super(financiamentos, colunas);
        this.financiamentos = financiamentos;


        // JComboBox Lista de financiamentos já registrados
        jComboBoxlistaDeFinanciamentos = new JComboBox(codigosArray);
        jComboBoxlistaDeFinanciamentos.setBounds(50,25,190,20);
        jComboBoxlistaDeFinanciamentos.addActionListener(this::visualizarInformacoes);
        panelInformacoesDoFinanciamento.add(jComboBoxlistaDeFinanciamentos);


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
        jComboBoxTipoDeZona = new JComboBox(zonas);
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
            if ((int) jComboBoxlistaDeFinanciamentos.getSelectedItem() == financiamento.getCodigo()) {
                jLabelTipoImovel.setText("Tipo do imóvel: " + financiamento.getTipoDoImovel());
                jTextFieldValorImovel.setText(Double.toString(financiamento.getValorImovel()));
                jTextFieldPrazoEmAnos.setText(Integer.toString(financiamento.getPrazoFinanciamentoEmAnos()));
                jTextFieldJurosAnual.setText(Double.toString(financiamento.getTaxaJurosAnual()));

                // Jlabels e JTextFields da classe Apartamento
                if (financiamento instanceof Apartamento) {
                    jTextFieldQuantidadeDeAndares.setText(Integer.toString(((Apartamento) financiamento).getQuantidadeDeAndares()));
                    jTextFieldQuantidadeDeVagas.setText(Integer.toString(((Apartamento) financiamento).getQuantidadeDeVagasDoEstacionamento()));


                    jLabelQuantidadeDeAndares.setVisible(true);
                    jLabelQuantidadeDeVagasDoEstacionamento.setVisible(true);
                    jTextFieldQuantidadeDeAndares.setVisible(true);
                    jTextFieldQuantidadeDeVagas.setVisible(true);
                    break;

                // Jlabels e JTextFields da classe Casa
                } else if (financiamento instanceof Casa) {
                    jTextFieldAreaTerreno.setText(Double.toString(((Casa) financiamento).getAreaTerreno()));
                    jTextFieldAreaConstruida.setText(Double.toString(((Casa) financiamento).getAreaConstruida()));

                    jLabelAreaTerreno.setVisible(true);
                    jLabelAreaConstruida.setVisible(true);
                    jTextFieldAreaTerreno.setVisible(true);
                    jTextFieldAreaConstruida.setVisible(true);
                    break;

                // Jlabels e JTextFields da classe Terreno
                } else if (financiamento instanceof Terreno){
                    jLabelTipoDeZona.setVisible(true);
                    jComboBoxTipoDeZona.setVisible(true);
                    break;
                }
            }
        }
    }


    // JButton Atualizar
    private void atualizarFinanciamentos(ActionEvent actionEvent) {
        for (Financiamento financiamento : financiamentos) {
            if ((int) jComboBoxlistaDeFinanciamentos.getSelectedItem() == financiamento.getCodigo()) {
                try {
                    // Valida os valores obrigatórios alterados
                    float valorImovel = Float.parseFloat(jTextFieldValorImovel.getText());
                    int prazoFinanciamento = Integer.parseInt(jTextFieldPrazoEmAnos.getText());
                    float jurosAnual = Float.parseFloat(jTextFieldJurosAnual.getText());

                    ValidarValores.valorImovel(valorImovel);
                    ValidarValores.prazoDoFinanciamentoEmAnos(prazoFinanciamento);
                    ValidarValores.taxaDeJurosAnual(jurosAnual);


                    // Valida os valores obrigatórios alterados
                    if (financiamento instanceof Apartamento) {
                        int quantidadeDeAndares = Integer.parseInt(jTextFieldQuantidadeDeAndares.getText());
                        int quantidadeDeVagas = Integer.parseInt((jTextFieldQuantidadeDeVagas.getText()));

                        ValidarValores.quantidadeDeAndares(quantidadeDeAndares);
                        ValidarValores.quantidadeDeVagas(quantidadeDeVagas, quantidadeDeAndares);

                        ((Apartamento) financiamento).setQuantidadeDeAndares(quantidadeDeAndares);
                        ((Apartamento) financiamento).setQuantidadeDeVagasDoEstacionamento(quantidadeDeVagas);

                    } else if (financiamento instanceof Casa) {
                        double areaTerreno = Double.parseDouble(jTextFieldAreaTerreno.getText());
                        double areaConstruida = Double.parseDouble(jTextFieldAreaConstruida.getText());

                        ValidarValores.areaTerreno(areaTerreno);
                        ValidarValores.areaConstruida(areaConstruida, areaTerreno);

                        ((Casa) financiamento).setAreaTerreno(areaTerreno);
                        ((Casa) financiamento).setAreaConstruida(areaConstruida);

                    } else if (financiamento instanceof Terreno) {
                        String tipoDeZona = (String)jComboBoxTipoDeZona.getSelectedItem();

                        ((Terreno) financiamento).setTipoDeZona(tipoDeZona);
                    }

                    financiamento.setValorImovel(valorImovel);
                    financiamento.setPrazoFinanciamentoEmAnos(prazoFinanciamento);
                    financiamento.setTaxaJurosAnual(jurosAnual);

                    ImageIcon icon = new ImageIcon("C:\\Users\\rapha\\OneDrive\\Desktop\\PUCPR\\Repositórios\\SistemaDeFinanciamento\\src\\Painel\\right.png");
                    JOptionPane.showMessageDialog(null, "Informações atualizadas.",
                            "Financiamento Atualizado", JOptionPane.INFORMATION_MESSAGE, icon);


                // Geral Exceptions
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Valores inválidos.",
                            "ERROR: Valores incompatíveis.", JOptionPane.ERROR_MESSAGE);
                } catch (ValorImovelInvalidoException e) {
                    JOptionPane.showMessageDialog(null, "Insira um valor maior ou igual a R$50000.00.",
                            "ERROR: Valor do imóvel inválido.", JOptionPane.ERROR_MESSAGE);
                } catch (PrazoFinanciamentoInvalidoException e) {
                    JOptionPane.showMessageDialog(null, "Insira um valor inteiro entre 0 e 36.",
                            "ERROR: Prazo do financiamento inválido.", JOptionPane.ERROR_MESSAGE);
                } catch (JurosFinanciamentoInvalidoException e) {
                    JOptionPane.showMessageDialog(null, "Insira um valor maior ou igual a 6% e menor ou igual a 12%.",
                            "ERROR: Juros do financiamento inválido.", JOptionPane.ERROR_MESSAGE);

                // Apartamento Exceptions
                } catch (QuantidadeDeAndaresInvalidaException e) {
                    JOptionPane.showMessageDialog(null, "Insira um valor inteiro maior ou igual a 4.",
                            "ERROR: Quantidade de andares inválida.", JOptionPane.ERROR_MESSAGE);
                } catch (QuantidadeDeVagasInvalidaException e) {
                    JOptionPane.showMessageDialog(null, "Quantidade de vagas não pode ser inferior a quantidade de andares.",
                            "ERROR: Quantidade de vagas inválida.", JOptionPane.ERROR_MESSAGE);

                // Casa Exceptions
                } catch(AreaTerrenoInvalidaException e) {
                    JOptionPane.showMessageDialog(null, "Área do terreno não pode ser inferior a 2,5 metros.",
                            "ERROR: Área do terreno inválida.", JOptionPane.ERROR_MESSAGE);
                } catch(AreaConstruidaInvalidaException e) {
                    JOptionPane.showMessageDialog(null, "Área construida não pode ser superior a área do terreno.",
                            "ERROR: Área construída inválida.", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
