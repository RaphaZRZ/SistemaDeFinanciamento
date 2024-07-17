/*
Criar seleção entre dois tipos de zona em Terreno
Instanciar financiamentos
Salvar/Listar/Excluir financiamentos
 */

package Painel;

import Exceptions.*;
import util.ValidarValores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Painel extends JFrame {

    // Adicionando variáveis fora do construtor para utilizar a variável em outros métodos
    JRadioButton apartamentoButton;
    JRadioButton casaButton;
    JRadioButton terrenoButton;
    JTextField jTextFieldValorImovel;
    JTextField jTextFieldPrazoEmAnos;
    JTextField jTextFieldJurosAnual;
    JLabel jLabelQuantidadeDeAndares;
    JLabel jLabelQuantidadeDeVagasDoEstacionamento;
    JLabel jLabelAreaTerreno;
    JLabel jLabelAreaConstruida;
    JLabel jLabelTipoDeZona;
    JTextField jTextFieldQuantidadeDeAndares;
    JTextField jTextFieldQuantidadeDeVagas;
    JTextField jTextFieldAreaTerreno;
    JTextField jTextFieldAreaConstruida;
    JTextField jTextFieldZona;
    JButton salvarInformacoes;

    public Painel() {
        // JFrame
        setTitle("Financiamentos");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        // JPanel Titulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBounds(0, 0, 800, 100);
        panelTitulo.setBackground(new Color(168, 234, 250));
        panelTitulo.setLayout(null);
        add(panelTitulo);


        // JPanel InformacoesDoFinanciamento
        JPanel panelInformacoesDoFinanciamento = new JPanel();
        panelInformacoesDoFinanciamento.setBounds(0, 100, 330, 500);
        panelInformacoesDoFinanciamento.setBackground(new Color(127, 127, 127));
        panelInformacoesDoFinanciamento.setLayout(null);
        add(panelInformacoesDoFinanciamento);


        // radioButtons Informação do tipo de financiamento
        apartamentoButton = new JRadioButton("Apartamento");
        apartamentoButton.setOpaque(false);
        apartamentoButton.setBounds(0, 80, 150, 20);
        apartamentoButton.setFont(new Font("Arial", Font.BOLD, 20));
        apartamentoButton.addActionListener(this::tipoDoImovel);

        casaButton = new JRadioButton("Casa");
        casaButton.setOpaque(false);
        casaButton.setBounds(0, 120, 100, 20);
        casaButton.setFont(new Font("Arial", Font.BOLD, 20));
        casaButton.addActionListener(this::tipoDoImovel);

        terrenoButton = new JRadioButton("Terreno");
        terrenoButton.setOpaque(false);
        terrenoButton.setBounds(0, 160, 100, 20);
        terrenoButton.setFont(new Font("Arial", Font.BOLD, 20));
        terrenoButton.addActionListener(this::tipoDoImovel);

        panelInformacoesDoFinanciamento.add(apartamentoButton);
        panelInformacoesDoFinanciamento.add(casaButton);
        panelInformacoesDoFinanciamento.add(terrenoButton);


        // redioButtonsGroup Informações do tipo de financiamento
        ButtonGroup grupoTipoDeFinanciamentos = new ButtonGroup();
        grupoTipoDeFinanciamentos.add(apartamentoButton);
        grupoTipoDeFinanciamentos.add(casaButton);
        grupoTipoDeFinanciamentos.add(terrenoButton);


        // JLabel Título
        JLabel title = new JLabel("SISTEMA DE FINANCIAMENTOS");
        title.setBounds(30, 25, 610, 50);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        panelTitulo.add(title);


        // JLabel Selecionar tipo de financiamento
        JLabel selecionarTipoDeFinanciamento = new JLabel("Escolha o tipo do imóvel:");
        selecionarTipoDeFinanciamento.setBounds(0, 0, 400, 100);
        selecionarTipoDeFinanciamento.setFont(new Font("Arial", Font.BOLD, 25));
        selecionarTipoDeFinanciamento.setForeground(new Color(225, 225, 225));
        panelInformacoesDoFinanciamento.add(selecionarTipoDeFinanciamento);


        // JLabel Informações obrigatórias para todos os financiamentos
        JLabel valorImovel = new JLabel("Valor imóvel:");
        valorImovel.setBounds(69, 180, 400, 100);
        valorImovel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel prazoEmAnos = new JLabel("Prazo(em anos):");
        prazoEmAnos.setBounds(37, 230, 400, 100);
        prazoEmAnos.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel jurosAnual = new JLabel("Juros anual:");
        jurosAnual.setBounds(74, 280, 400, 100);
        jurosAnual.setFont(new Font("Arial", Font.BOLD, 20));

        panelInformacoesDoFinanciamento.add(valorImovel);
        panelInformacoesDoFinanciamento.add(prazoEmAnos);
        panelInformacoesDoFinanciamento.add(jurosAnual);


        // JLabel Informações específicas de cada imóvel a ser financiado
        jLabelQuantidadeDeAndares = new JLabel("Andares:");
        jLabelQuantidadeDeAndares.setBounds(107, 330, 400, 100);
        jLabelQuantidadeDeAndares.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelQuantidadeDeVagasDoEstacionamento = new JLabel("Vagas:");
        jLabelQuantidadeDeVagasDoEstacionamento.setBounds(127, 380, 400, 100);
        jLabelQuantidadeDeVagasDoEstacionamento.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelAreaTerreno = new JLabel("Área do terreno:");
        jLabelAreaTerreno.setBounds(37, 330, 400, 100);
        jLabelAreaTerreno.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelAreaConstruida = new JLabel("Área do construída:");
        jLabelAreaConstruida.setBounds(5, 380, 400, 100);
        jLabelAreaConstruida.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelTipoDeZona = new JLabel("Tipo de Zona:");
        jLabelTipoDeZona.setBounds(62, 330, 400, 100);
        jLabelTipoDeZona.setFont(new Font("Arial", Font.BOLD, 20));

        panelInformacoesDoFinanciamento.add(jLabelQuantidadeDeAndares);
        panelInformacoesDoFinanciamento.add(jLabelQuantidadeDeVagasDoEstacionamento);
        panelInformacoesDoFinanciamento.add(jLabelAreaTerreno);
        panelInformacoesDoFinanciamento.add(jLabelAreaConstruida);
        panelInformacoesDoFinanciamento.add(jLabelTipoDeZona);


        // Deixando as JLabels específicas invisíveis
        jLabelQuantidadeDeAndares.setVisible(false);
        jLabelQuantidadeDeVagasDoEstacionamento.setVisible(false);
        jLabelAreaTerreno.setVisible(false);
        jLabelAreaConstruida.setVisible(false);
        jLabelTipoDeZona.setVisible(false);


        // JTextField Informações obrigatórias para todos os financiamentos
        jTextFieldValorImovel = new JTextField("49999.99 > valor");
        jTextFieldValorImovel.setBounds(195,222,110,20);
        jTextFieldValorImovel.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldPrazoEmAnos = new JTextField("0 < prazo > 36");
        jTextFieldPrazoEmAnos.setBounds(195,272,110,20);
        jTextFieldPrazoEmAnos.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldJurosAnual = new JTextField("5% < juros > 13%");
        jTextFieldJurosAnual.setBounds(195,322,110,20);
        jTextFieldJurosAnual.setFont(new Font("Arial", Font.BOLD, 15));

        panelInformacoesDoFinanciamento.add(jTextFieldValorImovel);
        panelInformacoesDoFinanciamento.add(jTextFieldPrazoEmAnos);
        panelInformacoesDoFinanciamento.add(jTextFieldJurosAnual);

        // JTextField Informações específicas de cada imóvel a ser financiado
        jTextFieldQuantidadeDeAndares = new JTextField();
        jTextFieldQuantidadeDeAndares.setBounds(195,372,110,20);
        jTextFieldQuantidadeDeAndares.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldQuantidadeDeVagas = new JTextField();
        jTextFieldQuantidadeDeVagas.setBounds(195,422,110,20);
        jTextFieldQuantidadeDeVagas.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldAreaTerreno = new JTextField();
        jTextFieldAreaTerreno.setBounds(195,372,110,20);
        jTextFieldAreaTerreno.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldAreaConstruida = new JTextField();
        jTextFieldAreaConstruida.setBounds(195,422,110,20);
        jTextFieldAreaConstruida.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldZona = new JTextField();
        jTextFieldZona.setBounds(195,372,110,20);
        jTextFieldZona.setFont(new Font("Arial", Font.BOLD, 15));

        panelInformacoesDoFinanciamento.add(jTextFieldQuantidadeDeAndares);
        panelInformacoesDoFinanciamento.add(jTextFieldQuantidadeDeVagas);
        panelInformacoesDoFinanciamento.add(jTextFieldAreaTerreno);
        panelInformacoesDoFinanciamento.add(jTextFieldAreaConstruida);
        panelInformacoesDoFinanciamento.add(jTextFieldZona);

        setVisible(true);


        // Deixando os JTextFields específicos invisíveis
        jTextFieldQuantidadeDeAndares.setVisible(false);
        jTextFieldQuantidadeDeVagas.setVisible(false);
        jTextFieldAreaTerreno.setVisible(false);
        jTextFieldAreaConstruida.setVisible(false);
        jTextFieldZona.setVisible(false);


        // Criando um financiamento por meio do jButton salvarInformacoes
        salvarInformacoes = new JButton("Salvar");
        salvarInformacoes.setBounds(getX() / 2, 400, 200, 70);
        salvarInformacoes.setFont(new Font("Arial", Font.BOLD, 40));
        salvarInformacoes.setForeground(new Color(200, 200, 200));
        salvarInformacoes.setBackground(new Color(50, 50, 50));
        salvarInformacoes.addActionListener(this::criarFinanciamento);
        add(salvarInformacoes);
    }


    // Radiobuttons funções
    public void tipoDoImovel(ActionEvent e) {
        // Deixando as JLabels específicas invisíveis
        jLabelQuantidadeDeAndares.setVisible(false);
        jLabelQuantidadeDeVagasDoEstacionamento.setVisible(false);
        jLabelAreaTerreno.setVisible(false);
        jLabelAreaConstruida.setVisible(false);
        jLabelTipoDeZona.setVisible(false);

        // Deixando os JTextFields específicos invisíveis
        jTextFieldQuantidadeDeAndares.setVisible(false);
        jTextFieldQuantidadeDeVagas.setVisible(false);
        jTextFieldAreaTerreno.setVisible(false);
        jTextFieldAreaConstruida.setVisible(false);
        jTextFieldZona.setVisible(false);

        // Controlando a visibilidade de valores específicos
        if (e.getSource() == apartamentoButton) {
            jLabelQuantidadeDeAndares.setVisible(true);
            jLabelQuantidadeDeVagasDoEstacionamento.setVisible(true);
            jTextFieldQuantidadeDeAndares.setVisible(true);
            jTextFieldQuantidadeDeVagas.setVisible(true);
        } else if (e.getSource() == casaButton) {
            jLabelAreaTerreno.setVisible(true);
            jLabelAreaConstruida.setVisible(true);
            jTextFieldAreaTerreno.setVisible(true);
            jTextFieldAreaConstruida.setVisible(true);
        } else if (e.getSource() == terrenoButton) {
            jLabelTipoDeZona.setVisible(true);
            jTextFieldZona.setVisible(true);
        }
    }

    public void criarFinanciamento(ActionEvent e) {
        try {
            // Valores obrigatórias
            float valorImovel = Float.parseFloat(jTextFieldValorImovel.getText());
            int prazoFinanciamento = Integer.parseInt(jTextFieldPrazoEmAnos.getText());
            float jurosAnual = Float.parseFloat(jTextFieldJurosAnual.getText());

            ValidarValores.valorImovel(valorImovel);
            ValidarValores.prazoDoFinanciamentoEmAnos(prazoFinanciamento);
            ValidarValores.taxaDeJurosAnual(jurosAnual);

            // Valores específicos da classe Apartamento
            if (jLabelQuantidadeDeAndares.isVisible()) {
                int quantidadeDeAndares = Integer.parseInt(jTextFieldQuantidadeDeAndares.getText());
                int quantidadeDeVagas = Integer.parseInt((jTextFieldQuantidadeDeVagas.getText()));

                ValidarValores.quantidadeDeAndares(quantidadeDeAndares);
                ValidarValores.quantidadeDeVagas(quantidadeDeVagas, quantidadeDeAndares);
            }

            // Valores específicos da classe Casa
            else if (jLabelAreaTerreno.isVisible()) {
                double areaTerreno = Double.parseDouble(jTextFieldAreaTerreno.getText());
                double areaConstruida = Double.parseDouble(jTextFieldAreaConstruida.getText());

                ValidarValores.areaTerreno(areaTerreno);
                ValidarValores.areaConstruida(areaConstruida, areaTerreno);

            // Valores específicos da classe Terreno
            } else if (jLabelTipoDeZona.isVisible()) {
                System.out.println("b");

            // Tipo do imóvel não selecionado
            } else
                throw new TipoFinanciamentoInvalidoException("Imóvel inválido");

            System.out.println(valorImovel);
            System.out.println(prazoFinanciamento);
            System.out.println(jurosAnual);

            // Geral Exceptions
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "Valores inválidos.",
                    "ERROR: Valores incompatíveis.", JOptionPane.ERROR_MESSAGE);
        } catch (ValorImovelInvalidoException error) {
            JOptionPane.showMessageDialog(null, "Insira um valor maior ou igual a R$50000.00.",
                    "ERROR: Valor do imóvel inválido.", JOptionPane.ERROR_MESSAGE);
        } catch (PrazoFinanciamentoInvalidoException error) {
            JOptionPane.showMessageDialog(null, "Insira um valor inteiro entre 0 e 36.",
                    "ERROR: Prazo do financiamento inválido.", JOptionPane.ERROR_MESSAGE);
        } catch (JurosFinanciamentoInvalidoException error) {
            JOptionPane.showMessageDialog(null, "Insira um valor maior ou igual a 6% e menor ou igual a 12%.",
                    "ERROR: Juros do financiamento inválido.", JOptionPane.ERROR_MESSAGE);
        } catch (TipoFinanciamentoInvalidoException error) {
            JOptionPane.showMessageDialog(null, "Selecione o tipo do imóvel que deseja financiar.",
                    "ERROR: Tipo de imóvel inválido.", JOptionPane.ERROR_MESSAGE);

            // Apartamento Exceptions
        } catch (QuantidadeDeAndaresInvalidaException error) {
            JOptionPane.showMessageDialog(null, "Insira um valor inteiro maior ou igual a 4.",
                    "ERROR: Quantidade de andares inválida.", JOptionPane.ERROR_MESSAGE);
        } catch (QuantidadeDeVagasInvalidaException error) {
            JOptionPane.showMessageDialog(null, "Quantidade de vagas não pode ser inferior a quantidade de andares.",
                    "ERROR: Quantidade de vagas inválida.", JOptionPane.ERROR_MESSAGE);

            // Casa Exceptions
        } catch(AreaTerrenoInvalidaException error) {
            JOptionPane.showMessageDialog(null, "Área do terreno não pode ser inferior a 2,5 metros.",
                    "ERROR: Área do terreno inválida.", JOptionPane.ERROR_MESSAGE);
        } catch(AreaConstruidaInvalidaException error) {
            JOptionPane.showMessageDialog(null, "Área construida não pode ser superior a área do terreno.",
                    "ERROR: Área construída inválida.", JOptionPane.ERROR_MESSAGE);


            // Terreno Exceptions
        } /*catch() {

        }*/
    }
}