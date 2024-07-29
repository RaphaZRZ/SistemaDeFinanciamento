/*
Tentar utlilzar extend da classe WindowListar
 */
package Painel;

import Exceptions.*;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.ValidarValores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WindowExcluir extends WindowListar{
    JButton jButtonExcluir;

    public WindowExcluir(ArrayList<Financiamento> financiamentos) {
        super(financiamentos);

        jButtonExcluir = new JButton("Excluir");
        jButtonExcluir.setBounds(0, 100, 100, 100);
        add(jButtonExcluir);
        jButtonExcluir.addActionListener(this::excluir);
        setVisible(true);

    }

    private void excluir(ActionEvent actionEvent) {
        for (Financiamento financiamento : financiamentos) {
            if ((int) jComboBoxlistaDeFinanciamentos.getSelectedItem() == financiamento.getCodigo()) {
                financiamentos.remove(jComboBoxlistaDeFinanciamentos.getSelectedItem());
                ImageIcon icon = new ImageIcon("C:\\Users\\rapha\\OneDrive\\Desktop\\PUCPR\\Repositórios\\SistemaDeFinanciamento\\src\\Painel\\right.png");
                JOptionPane.showMessageDialog(null, "Informações excluídas.",
                        "Financiamento Excluído", JOptionPane.INFORMATION_MESSAGE, icon);
                break;
            }
        }
    }
}
