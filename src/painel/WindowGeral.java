package painel;

import modelo.Financiamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;


/*
Essa classe define o tamanho da janela para as funções listar/editar/excluir.
Recebe como argumento a quantidade de botões, geralmente entre 1 e 2.
 */
public class WindowGeral extends JFrame {
    ImageIcon rightPNG = new ImageIcon(Objects.requireNonNull(getClass().getResource("right.png")));

    JPanel panelInformacoesDoFinanciamento;
    JPanel panelBotoes;
    JLabel jLabelTipoImovel;
    JLabel jLabelValorImovel;
    JLabel jLabelPrazoEmAnos;
    JLabel jLabelJurosAnual;
    JLabel jLabelQuantidadeDeAndares;
    JLabel jLabelQuantidadeDeVagasDoEstacionamento;
    JLabel jLabelAreaTerreno;
    JLabel jLabelAreaConstruida;
    JLabel jLabelTipoDeZona;
    JButton voltar;
    JComboBox<Integer> jComboBoxListaDeFinanciamentos;

    ArrayList<Financiamento> financiamentos;
    ArrayList<Integer> codigos = new ArrayList<>();
    Integer[] codigosArray;
    String caminhoArquivo;

    public WindowGeral(ArrayList<Financiamento> financiamentos, int botoes, String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;

        // JFrame janela de funções específicas.
        setTitle("Financiamentos");
        setSize(300, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        // JPanel InformacoesDoFinanciamento.
        panelInformacoesDoFinanciamento = new JPanel();
        panelInformacoesDoFinanciamento.setBounds(0, 0, 300, 380);
        panelInformacoesDoFinanciamento.setBackground(new Color(127, 127, 127));
        panelInformacoesDoFinanciamento.setLayout(null);
        add(panelInformacoesDoFinanciamento);


        // JPanel Botões, painel que contém os botões baseado em qual função o usuário escolheu.
        panelBotoes = new JPanel();
        panelBotoes.setBounds(0, 380, 284, 81);
        panelBotoes.setLayout(new GridLayout(1, botoes));
        add(panelBotoes);


        // Loop for para obter todos os códigos de cada financiamento.
        for (Financiamento financiamento : financiamentos)
            codigos.add(financiamento.getCodigo());
        // Transforma o ArrayList em um Array normal para poder ser utilizado como parâmetro na criação da comboBox.
        codigosArray = codigos.toArray(new Integer[0]);


        // JComboBox Lista de financiamentos já registrados
        jComboBoxListaDeFinanciamentos = new JComboBox<>(codigosArray);
        jComboBoxListaDeFinanciamentos.setBounds(50, 25, 190, 20);
        panelInformacoesDoFinanciamento.add(jComboBoxListaDeFinanciamentos);


        // JLabel Informações obrigatórias para todos os financiamentos.
        jLabelTipoImovel = new JLabel("Tipo do imóvel:");
        jLabelTipoImovel.setBounds(21, 40, 400, 100);
        jLabelTipoImovel.setFont(new Font("Arial", Font.ITALIC, 20));

        jLabelValorImovel = new JLabel("Valor do imóvel:");
        jLabelValorImovel.setBounds(13, 90, 400, 100);
        jLabelValorImovel.setFont(new Font("Arial", Font.ITALIC, 20));

        jLabelPrazoEmAnos = new JLabel("Prazo(em anos):");
        jLabelPrazoEmAnos.setBounds(10, 140, 400, 100);
        jLabelPrazoEmAnos.setFont(new Font("Arial", Font.ITALIC, 20));

        jLabelJurosAnual = new JLabel("Juros anual:");
        jLabelJurosAnual.setBounds(49, 190, 400, 100);
        jLabelJurosAnual.setFont(new Font("Arial", Font.ITALIC, 20));

        panelInformacoesDoFinanciamento.add(jLabelTipoImovel);
        panelInformacoesDoFinanciamento.add(jLabelValorImovel);
        panelInformacoesDoFinanciamento.add(jLabelPrazoEmAnos);
        panelInformacoesDoFinanciamento.add(jLabelJurosAnual);


        // JLabel Informações específicas de cada imóvel financiado.
        jLabelQuantidadeDeAndares = new JLabel("Andares: ");
        jLabelQuantidadeDeAndares.setBounds(79, 240, 400, 100);
        jLabelQuantidadeDeAndares.setFont(new Font("Arial", Font.ITALIC, 20));

        jLabelQuantidadeDeVagasDoEstacionamento = new JLabel("Vagas: ");
        jLabelQuantidadeDeVagasDoEstacionamento.setBounds(97, 290, 400, 100);
        jLabelQuantidadeDeVagasDoEstacionamento.setFont(new Font("Arial", Font.ITALIC, 20));

        jLabelAreaTerreno = new JLabel("Área do terreno: ");
        jLabelAreaTerreno.setBounds(14, 240, 400, 100);
        jLabelAreaTerreno.setFont(new Font("Arial", Font.ITALIC, 20));

        jLabelAreaConstruida = new JLabel("Área construída: ");
        jLabelAreaConstruida.setBounds(13, 290, 400, 100);
        jLabelAreaConstruida.setFont(new Font("Arial", Font.ITALIC, 20));

        jLabelTipoDeZona = new JLabel("Tipo de Zona: ");
        jLabelTipoDeZona.setBounds(35, 240, 400, 100);
        jLabelTipoDeZona.setFont(new Font("Arial", Font.ITALIC, 20));

        panelInformacoesDoFinanciamento.add(jLabelQuantidadeDeAndares);
        panelInformacoesDoFinanciamento.add(jLabelQuantidadeDeVagasDoEstacionamento);
        panelInformacoesDoFinanciamento.add(jLabelAreaTerreno);
        panelInformacoesDoFinanciamento.add(jLabelAreaConstruida);
        panelInformacoesDoFinanciamento.add(jLabelTipoDeZona);


        // JButton Voltar(retorna para o JFrame principal).
        voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial", Font.BOLD, 25));
        voltar.setForeground(new Color(200, 200, 200));
        voltar.setBackground(new Color(50, 50, 50));
        voltar.addActionListener(this::voltarParaMenuPrincipal);
        panelBotoes.add(voltar);

        ocultarJLabelsEspecificas();
    }

    private void voltarParaMenuPrincipal(ActionEvent actionEvent) {
        dispose();

        try {
            new PainelPrincipal(financiamentos, codigos.getLast() + 1, caminhoArquivo);

        } catch (NoSuchElementException e) {
            new PainelPrincipal(financiamentos, 0, caminhoArquivo);
        }
    }

    protected void ocultarJLabelsEspecificas() {
        jLabelQuantidadeDeAndares.setVisible(false);
        jLabelQuantidadeDeVagasDoEstacionamento.setVisible(false);
        jLabelAreaTerreno.setVisible(false);
        jLabelAreaConstruida.setVisible(false);
        jLabelTipoDeZona.setVisible(false);
    }
}