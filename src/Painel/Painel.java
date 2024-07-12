package Painel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Painel extends JFrame {

    //adicionando caixa de texto fora do construtor para utilizar a variável em outros métodos
    JTextField num1;
    JTextField num2;

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
        JRadioButton apartamentoButton = new JRadioButton("Apartamento");
        JRadioButton casaButton = new JRadioButton("Casa");
        JRadioButton terrenoButton = new JRadioButton("Terreno");

        apartamentoButton.setBounds(0, 80, 100, 25);
        apartamentoButton.setOpaque(false);
        casaButton.setBounds(0, 110, 100, 25);
        casaButton.setOpaque(false);
        terrenoButton.setBounds(0, 140, 100, 25);
        terrenoButton.setOpaque(false);

        panelInformacoesDoFinanciamento.add(apartamentoButton);
        panelInformacoesDoFinanciamento.add(casaButton);
        panelInformacoesDoFinanciamento.add(terrenoButton);

        // redioButtonsGroup Informações do tipo de financiamento
        ButtonGroup grupoTipoDeFinanciamentos = new ButtonGroup();
        grupoTipoDeFinanciamentos.add(apartamentoButton);
        grupoTipoDeFinanciamentos.add(casaButton);
        grupoTipoDeFinanciamentos.add(terrenoButton);

        // botão 1
        JButton buttonSoma = new JButton("SOMA");
        buttonSoma.setBounds(getX() / 2, 400, 200, 70);
        buttonSoma.setFont(new Font("Arial", Font.BOLD, 40));
        buttonSoma.setForeground(new Color(200, 200, 200));
        buttonSoma.setBackground(new Color(50, 50, 50));
        buttonSoma.addActionListener(this::botao1);
        add(buttonSoma);

        // JLabel Título
        JLabel title = new JLabel("SISTEMA DE FINANCIAMENTOS");
        title.setBounds(30, 25, 610, 50);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        panelTitulo.add(title);

        // JLabel Selecionar tipo de financiamento
        JLabel selecionarTipoDeFinanciamento = new JLabel("Escolha o imóvel que deseja financiar");
        selecionarTipoDeFinanciamento.setBounds(0, 0, 400, 100);
        selecionarTipoDeFinanciamento.setFont(new Font("Arial", Font.BOLD, 25));
        selecionarTipoDeFinanciamento.setForeground(new Color(225, 225, 225));
        panelInformacoesDoFinanciamento.add(selecionarTipoDeFinanciamento);


        setVisible(true);
    }

    // BOTÕES FUNÇÕES
    private void botao1(ActionEvent actionEvent) {
        try {
            Integer numero1 = Integer.parseInt(num1.getText());
            Integer numero2 = Integer.parseInt(num2.getText());
            int soma = numero1 + numero2;

            JOptionPane.showMessageDialog(null,
                    "A soma dos dois valores é: " + soma, "Soma de dois valores", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira dois números inteiros",
                    "ERRO: Valor inválido", JOptionPane.ERROR_MESSAGE);
        }
    }
}
