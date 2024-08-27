package painel;

import modelo.Financiamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class WindowExcluir extends WindowListar {
    JButton jButtonExcluir;

    /*
    Utiliza o painel da classe WindowListar para criar seu próprio painel, porém com duas colunas
    */
    public WindowExcluir(ArrayList<Financiamento> financiamentos) {
        super(financiamentos, 2);

        jButtonExcluir = new JButton("Excluir");
        jButtonExcluir.setFont(new Font("Arial", Font.BOLD, 25));
        jButtonExcluir.setForeground(new Color(200, 200, 200));
        jButtonExcluir.setBackground(new Color(50, 50, 50));
        jButtonExcluir.addActionListener(this::excluir);
        panelBotoes.add(jButtonExcluir);

        setVisible(true);

    }

    private void excluir(ActionEvent actionEvent) {
        for (int i = 0; i < financiamentos.size(); i++) {
            if ((int) jComboBoxlistaDeFinanciamentos.getSelectedItem() == financiamentos.get(i).getCodigo()) {
                financiamentos.remove(financiamentos.get(i));
                ImageIcon icon = new ImageIcon("C:\\Users\\rapha\\OneDrive\\Desktop\\PUCPR\\Repositórios\\SistemaDeFinanciamento\\src\\Painel\\right.png");
                JOptionPane.showMessageDialog(null, "Informações excluídas.",
                        "Financiamento Excluído", JOptionPane.INFORMATION_MESSAGE, icon);
                dispose();
                new WindowExcluir(financiamentos);
                break;
            }
        }
    }
}
