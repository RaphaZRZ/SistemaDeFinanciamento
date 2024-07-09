package Painel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Painel extends JFrame {

    //adicionando caixa de texto fora do construtor para utilizar a variável em outros métodos
    JTextField num1;
    JTextField num2;
    private JPanel panelMain;
    private JButton Soma;

    public Painel() {
        setTitle("Financiamentos");
        setSize(800, 600);
        getContentPane().setBackground(new Color(168, 234, 250));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        // botão 1
        JButton buttonSoma = new JButton("SOMA");
        buttonSoma.setBounds(getX() / 2, 400, 200, 70);
        buttonSoma.setFont(new Font("Arial", Font.BOLD, 40));
        buttonSoma.setForeground(new Color(200, 200, 200));
        buttonSoma.setBackground(new Color(50, 50, 50));
        buttonSoma.addActionListener(this::botao1);
        add(buttonSoma);

        // botão 2
        JButton jbuttonSubtracao = new JButton("SUBTRAÇÃO");
        jbuttonSubtracao.setBounds(0, 0, 200, 50);
        jbuttonSubtracao.setFont(new Font("Arial", Font.BOLD, 20));
        jbuttonSubtracao.setForeground(new Color(1, 106, 234));
        jbuttonSubtracao.setBackground(new Color(50, 50, 50));
        jbuttonSubtracao.addActionListener(this::botao2);
        add(jbuttonSubtracao);

        // Campo de texto
        num1 = new JTextField();
        num1.setBounds(130, 112, 100, 30);
        num1.setFont(new Font("Arial", Font.ITALIC, 20));
        add(num1);

        // Campo de texto2
        num2 = new JTextField();
        num2.setBounds(130, 187, 100, 30);
        num2.setFont(new Font("Arial", Font.ITALIC, 20));
        add(num2);

        // JLabel Título
        JLabel title = new JLabel("TÍTULO");
        title.setBounds(this.getX() / 2 + 75, 10, 400, 100);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        add(title);

        // JLabel texto1
        JLabel jLabel1 = new JLabel("1° número:  ");
        jLabel1.setBounds(0, 75, 400, 100);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 25));
        add(jLabel1);

        // JLabel texto2
        JLabel jLabel2 = new JLabel("2° número:  ");
        jLabel2.setBounds(0, 150, 400, 100);
        jLabel2.setFont(new Font("Arial", Font.BOLD, 25));
        add(jLabel2);

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

    private void botao2(ActionEvent actionEvent) {
        try {
            Integer numero1 = Integer.parseInt(num1.getText());
            Integer numero2 = Integer.parseInt(num2.getText());
            int subtracao = numero1 - numero2;

            JOptionPane.showMessageDialog(null,
                    "A subtração dos dois valores é: " + subtracao, "Subtração de dois valores", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira dois números inteiros",
                    "ERRO: Valor inválido", JOptionPane.ERROR_MESSAGE);
        }


    }
}
