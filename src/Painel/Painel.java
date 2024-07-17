/*
Instanciar financiamentos
Salvar/Listar/Excluir financiamentos
 */

package Painel;

import Exceptions.JurosFinanciamentoInvalidoException;
import Exceptions.PrazoFinanciamentoInvalidoException;
import Exceptions.ValorImovelInvalidoException;
import util.InterfaceUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Painel extends JFrame {

    // Adicionando variáveis fora do construtor para utilizar a variável em outros métodos
    JRadioButton apartamentoButton;
    JRadioButton casaButton;
    JRadioButton terrenoButton;
    JTextField jTextFieldValorImovel;
    JTextField jTextFieldPrazo;
    JTextField jTextFieldJurosAnual;
    JLabel jLabelQuantidadeDeAndares;
    JLabel jLabelQuantidadeDeVagasDoEstacionamento;
    JLabel jLabelAreaTerreno;
    JLabel jLabelAreaConstruida;
    JLabel jLabelTipoDeZona;
    JTextField jTextFieldAndares;
    JTextField jTextFieldVagas;
    JTextField jTextFieldTerreno;
    JTextField jTextFieldConstruida;
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
        panelInformacoesDoFinanciamento.setBounds(0, 100, 300, 500);
        panelInformacoesDoFinanciamento.setBackground(new Color(127, 127, 127));
        panelInformacoesDoFinanciamento.setLayout(null);
        add(panelInformacoesDoFinanciamento);


        // radioButtons Informação do tipo de financiamento
        apartamentoButton = new JRadioButton("Apartamento");
        apartamentoButton.setOpaque(false);
        apartamentoButton.setBounds(0, 80, 150, 20);
        apartamentoButton.setFont(new Font("Arial", Font.BOLD, 20));
        apartamentoButton.addActionListener(this::actionPerformed);

        casaButton = new JRadioButton("Casa");
        casaButton.setOpaque(false);
        casaButton.setBounds(0, 120, 100, 20);
        casaButton.setFont(new Font("Arial", Font.BOLD, 20));
        casaButton.addActionListener(this::actionPerformed);

        terrenoButton = new JRadioButton("Terreno");
        terrenoButton.setOpaque(false);
        terrenoButton.setBounds(0, 160, 100, 20);
        terrenoButton.setFont(new Font("Arial", Font.BOLD, 20));
        terrenoButton.addActionListener(this::actionPerformed);

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
        JLabel valorDoImovel = new JLabel("Valor imóvel:");
        valorDoImovel.setBounds(37, 180, 400, 100);
        valorDoImovel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel prazoEmAnos = new JLabel("Prazo(em anos):");
        prazoEmAnos.setBounds(5, 230, 400, 100);
        prazoEmAnos.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel taxaAnual = new JLabel("Juros anual:");
        taxaAnual.setBounds(42, 280, 400, 100);
        taxaAnual.setFont(new Font("Arial", Font.BOLD, 20));

        panelInformacoesDoFinanciamento.add(valorDoImovel);
        panelInformacoesDoFinanciamento.add(prazoEmAnos);
        panelInformacoesDoFinanciamento.add(taxaAnual);


        // JLabel Informações específicas de cada imóvel a ser financiado
        jLabelQuantidadeDeAndares = new JLabel("Andares:");
        jLabelQuantidadeDeAndares.setBounds(75, 330, 400, 100);
        jLabelQuantidadeDeAndares.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelQuantidadeDeVagasDoEstacionamento = new JLabel("Vagas:");
        jLabelQuantidadeDeVagasDoEstacionamento.setBounds(95, 380, 400, 100);
        jLabelQuantidadeDeVagasDoEstacionamento.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelAreaTerreno = new JLabel("Área do terreno:");
        jLabelAreaTerreno.setBounds(5, 330, 400, 100);
        jLabelAreaTerreno.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelAreaConstruida = new JLabel("Vagas:");
        jLabelAreaConstruida.setBounds(95, 380, 400, 100);
        jLabelAreaConstruida.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelTipoDeZona = new JLabel("Tipo de Zona:");
        jLabelTipoDeZona.setBounds(30, 330, 400, 100);
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
        jTextFieldValorImovel.setBounds(165,222,110,20);
        jTextFieldValorImovel.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldPrazo = new JTextField("0 < prazo > 36");
        jTextFieldPrazo.setBounds(165,272,110,20);
        jTextFieldPrazo.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldJurosAnual = new JTextField("5% < juros > 13%");
        jTextFieldJurosAnual.setBounds(165,322,110,20);
        jTextFieldJurosAnual.setFont(new Font("Arial", Font.BOLD, 15));

        panelInformacoesDoFinanciamento.add(jTextFieldValorImovel);
        panelInformacoesDoFinanciamento.add(jTextFieldPrazo);
        panelInformacoesDoFinanciamento.add(jTextFieldJurosAnual);

        // JTextField Informações específicas de cada imóvel a ser financiado
        jTextFieldAndares = new JTextField();
        jTextFieldAndares.setBounds(165,372,110,20);
        jTextFieldAndares.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldVagas = new JTextField();
        jTextFieldVagas.setBounds(165,422,110,20);
        jTextFieldVagas.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldTerreno = new JTextField();
        jTextFieldTerreno.setBounds(165,372,110,20);
        jTextFieldTerreno.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldConstruida = new JTextField();
        jTextFieldConstruida.setBounds(165,422,110,20);
        jTextFieldConstruida.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldZona = new JTextField();
        jTextFieldZona.setBounds(165,372,110,20);
        jTextFieldZona.setFont(new Font("Arial", Font.BOLD, 15));

        panelInformacoesDoFinanciamento.add(jTextFieldAndares);
        panelInformacoesDoFinanciamento.add(jTextFieldVagas);
        panelInformacoesDoFinanciamento.add(jTextFieldTerreno);
        panelInformacoesDoFinanciamento.add(jTextFieldConstruida);
        panelInformacoesDoFinanciamento.add(jTextFieldZona);

        setVisible(true);


        // Deixando os JTextFields específicos invisíveis
        jTextFieldAndares.setVisible(false);
        jTextFieldVagas.setVisible(false);
        jTextFieldTerreno.setVisible(false);
        jTextFieldConstruida.setVisible(false);
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
    public void actionPerformed(ActionEvent e) {
        // Deixando as JLabels específicas invisíveis
        jLabelQuantidadeDeAndares.setVisible(false);
        jLabelQuantidadeDeVagasDoEstacionamento.setVisible(false);
        jLabelAreaTerreno.setVisible(false);
        jLabelAreaConstruida.setVisible(false);
        jLabelTipoDeZona.setVisible(false);

        // Deixando os JTextFields específicos invisíveis
        jTextFieldAndares.setVisible(false);
        jTextFieldVagas.setVisible(false);
        jTextFieldTerreno.setVisible(false);
        jTextFieldConstruida.setVisible(false);
        jTextFieldZona.setVisible(false);

        // Controlando a visibilidade de valores específicos
        if (e.getSource() == apartamentoButton) {
            jLabelQuantidadeDeAndares.setVisible(true);
            jLabelQuantidadeDeVagasDoEstacionamento.setVisible(true);
            jTextFieldAndares.setVisible(true);
            jTextFieldVagas.setVisible(true);
        } else if (e.getSource() == casaButton) {
            jLabelAreaTerreno.setVisible(true);
            jLabelAreaConstruida.setVisible(true);
            jTextFieldTerreno.setVisible(true);
            jTextFieldConstruida.setVisible(true);
        } else if (e.getSource() == terrenoButton) {
            jLabelTipoDeZona.setVisible(true);
            jTextFieldZona.setVisible(true);
        }
    }

    public void criarFinanciamento(ActionEvent e) {
        try {
            float valorImovel = Float.parseFloat(jTextFieldValorImovel.getText());
            int prazoFinanciamento = Integer.parseInt(jTextFieldPrazo.getText());
            float jurosAnual = Float.parseFloat(jTextFieldJurosAnual.getText());

            InterfaceUsuario.validarValorImovel(valorImovel);
            InterfaceUsuario.validarPrazoDoFinanciamentoEmAnos(prazoFinanciamento);
            InterfaceUsuario.validarTaxaDeJurosAnual(jurosAnual);

            System.out.println(valorImovel);
            System.out.println(prazoFinanciamento);
            System.out.println(jurosAnual);
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
            JOptionPane.showMessageDialog(null, "Insira um valor entre entre 5% e 13%.",
                    "ERROR: Juros do financiamento inválido.", JOptionPane.ERROR_MESSAGE);
        }
    }
}