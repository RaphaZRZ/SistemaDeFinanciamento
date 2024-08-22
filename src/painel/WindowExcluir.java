package painel;

import modelo.Financiamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
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
