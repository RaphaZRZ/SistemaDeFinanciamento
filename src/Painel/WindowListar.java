package Painel;
/*
VARRER O VETOR DE FINANCIAMENTO E VER SE O ÍNDICE CONDIZ COM O CASO SELECIONADO, CASO SIM DEVO MOSTRAR AS INFORMAÇÕES
 */

import modelo.Financiamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class WindowListar extends JFrame{
    JButton voltar;
    JComboBox jComboBoxlistaDeFinanciamentos;
    ArrayList<Financiamento> financiamentos;


    WindowListar(ArrayList<Financiamento> f) {
        // JFrame para a opção listar
        this.financiamentos = f;
        setTitle("Financiamentos realizados");
        setSize(400, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        // JButton Voltar(retorna para a tela inicial)
        voltar = new JButton("Voltar");
        voltar.setBounds(225, 481, 150, 70);
        voltar.setFont(new Font("Arial", Font.BOLD, 40));
        voltar.setForeground(new Color(200, 200, 200));
        voltar.setBackground(new Color(50, 50, 50));
        voltar.addActionListener(this::voltar);
        add(voltar);


        // JComboBox Lista de financiamentos já registrados
        Integer[] codigos = {0, 1, 2, 3, 4};
        jComboBoxlistaDeFinanciamentos = new JComboBox(codigos);
        jComboBoxlistaDeFinanciamentos.setBounds(97,50,190,20);
        add(jComboBoxlistaDeFinanciamentos);


        // Mostrando informações
        for (int i = 0; i < financiamentos.size(); i++) {
            if (i == financiamentos.get(i).getCodigo()) {
                System.out.println("Informações");
            }
        }

        setVisible(true);
    }

    private void voltar(ActionEvent actionEvent) {
        dispose();
        new Painel();
    }
}
