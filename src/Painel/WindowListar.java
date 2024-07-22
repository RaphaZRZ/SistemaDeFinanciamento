package Painel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WindowListar extends JFrame{
    JButton voltar;

    WindowListar() {
        // JFrame para a opção listar
        setTitle("Financiamentos realizados");
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        // JButton Voltar(retorna para a tela inicial)
        voltar = new JButton("Voltar");
        voltar.setBounds(250, 70, 150, 30);
        voltar.setFont(new Font("Arial", Font.BOLD, 40));
        voltar.setForeground(new Color(200, 200, 200));
        voltar.setBackground(new Color(50, 50, 50));
        voltar.addActionListener(this::voltar);
        add(voltar);

        setVisible(true);
    }

    private void voltar(ActionEvent actionEvent) {
        dispose();
        new Painel();
    }
}
