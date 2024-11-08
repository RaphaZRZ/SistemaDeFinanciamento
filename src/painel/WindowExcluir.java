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
    public WindowExcluir(ArrayList<Financiamento> financiamentos, String caminhoArquivo) {
        super(financiamentos, 2, caminhoArquivo);

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
            if ((int) jComboBoxListaDeFinanciamentos.getSelectedItem() == financiamentos.get(i).getCodigo()) {
                financiamentos.remove(financiamentos.get(i));
                JOptionPane.showMessageDialog(null, "Informações excluídas.",
                        "Financiamento Excluído", JOptionPane.INFORMATION_MESSAGE, rightPNG);
                util.serializarDesserializar.serializar(financiamentos, caminhoArquivo);
                dispose();
                new WindowExcluir(financiamentos, caminhoArquivo);
                break;
            }
        }
    }
}
