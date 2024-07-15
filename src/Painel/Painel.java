/*
Implementar regras de negócio utilizadas na InterfaceUsuário para criar financiamentos
Salvar/Listar/Excluir financiamentos
 */

package Painel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Painel extends JFrame {

    // Adicionando variáveis fora do construtor para utilizar a variável em outros métodos
    JRadioButton apartamentoButton;
    JRadioButton casaButton;
    JRadioButton terrenoButton;
    JTextField valor;
    JTextField prazo;
    JTextField jurosAnual;
    JLabel quantidadeDeAndares;
    JLabel quantidadeDeVagasDoEstacionamento;
    JLabel areaTerreno;
    JLabel areaConstruida;
    JLabel tipoDeZona;
    JTextField andares;
    JTextField vagas;
    JTextField terreno;
    JTextField construida;
    JTextField zona;
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
        quantidadeDeAndares = new JLabel("Andares:");
        quantidadeDeAndares.setBounds(75, 330, 400, 100);
        quantidadeDeAndares.setFont(new Font("Arial", Font.BOLD, 20));

        quantidadeDeVagasDoEstacionamento = new JLabel("Vagas:");
        quantidadeDeVagasDoEstacionamento.setBounds(95, 380, 400, 100);
        quantidadeDeVagasDoEstacionamento.setFont(new Font("Arial", Font.BOLD, 20));

        areaTerreno = new JLabel("Área do terreno:");
        areaTerreno.setBounds(5, 330, 400, 100);
        areaTerreno.setFont(new Font("Arial", Font.BOLD, 20));

        areaConstruida = new JLabel("Vagas:");
        areaConstruida.setBounds(95, 380, 400, 100);
        areaConstruida.setFont(new Font("Arial", Font.BOLD, 20));

        tipoDeZona = new JLabel("Tipo de Zona:");
        tipoDeZona.setBounds(30, 330, 400, 100);
        tipoDeZona.setFont(new Font("Arial", Font.BOLD, 20));

        panelInformacoesDoFinanciamento.add(quantidadeDeAndares);
        panelInformacoesDoFinanciamento.add(quantidadeDeVagasDoEstacionamento);
        panelInformacoesDoFinanciamento.add(areaTerreno);
        panelInformacoesDoFinanciamento.add(areaConstruida);
        panelInformacoesDoFinanciamento.add(tipoDeZona);


        // Deixando as JLabels específicas invisíveis
        quantidadeDeAndares.setVisible(false);
        quantidadeDeVagasDoEstacionamento.setVisible(false);
        areaTerreno.setVisible(false);
        areaConstruida.setVisible(false);
        tipoDeZona.setVisible(false);


        // JTextField Informações obrigatórias para todos os financiamentos
        valor = new JTextField();
        valor.setBounds(165,222,110,20);
        valor.setFont(new Font("Arial", Font.BOLD, 15));

        prazo = new JTextField();
        prazo.setBounds(165,272,110,20);
        prazo.setFont(new Font("Arial", Font.BOLD, 15));

        jurosAnual = new JTextField();
        jurosAnual.setBounds(165,322,110,20);
        jurosAnual.setFont(new Font("Arial", Font.BOLD, 15));

        panelInformacoesDoFinanciamento.add(valor);
        panelInformacoesDoFinanciamento.add(prazo);
        panelInformacoesDoFinanciamento.add(jurosAnual);

        // JTextField Informações específicas de cada imóvel a ser financiado
        andares = new JTextField();
        andares.setBounds(165,372,110,20);
        andares.setFont(new Font("Arial", Font.BOLD, 15));

        vagas = new JTextField();
        vagas.setBounds(165,422,110,20);
        vagas.setFont(new Font("Arial", Font.BOLD, 15));

        terreno = new JTextField();
        terreno.setBounds(165,372,110,20);
        terreno.setFont(new Font("Arial", Font.BOLD, 15));

        construida = new JTextField();
        construida.setBounds(165,422,110,20);
        construida .setFont(new Font("Arial", Font.BOLD, 15));

        zona = new JTextField();
        zona.setBounds(165,372,110,20);
        zona.setFont(new Font("Arial", Font.BOLD, 15));

        panelInformacoesDoFinanciamento.add(andares);
        panelInformacoesDoFinanciamento.add(vagas);
        panelInformacoesDoFinanciamento.add(terreno);
        panelInformacoesDoFinanciamento.add(construida);
        panelInformacoesDoFinanciamento.add(zona);

        setVisible(true);


        // Deixando os JTextFields específicos invisíveis
        andares.setVisible(false);
        vagas.setVisible(false);
        terreno.setVisible(false);
        construida.setVisible(false);
        zona.setVisible(false);


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
        quantidadeDeAndares.setVisible(false);
        quantidadeDeVagasDoEstacionamento.setVisible(false);
        areaTerreno.setVisible(false);
        areaConstruida.setVisible(false);
        tipoDeZona.setVisible(false);

        // Deixando os JTextFields específicos invisíveis
        andares.setVisible(false);
        vagas.setVisible(false);
        terreno.setVisible(false);
        construida.setVisible(false);
        zona.setVisible(false);

        // Controlando a visibilidade de valores específicos
        if (e.getSource() == apartamentoButton) {
            quantidadeDeAndares.setVisible(true);
            quantidadeDeVagasDoEstacionamento.setVisible(true);
            andares.setVisible(true);
            vagas.setVisible(true);
        } else if (e.getSource() == casaButton) {
            areaTerreno.setVisible(true);
            areaConstruida.setVisible(true);
            terreno.setVisible(true);
            construida.setVisible(true);
        } else if (e.getSource() == terrenoButton) {
            tipoDeZona.setVisible(true);
            zona.setVisible(true);
        }
    }

    public void criarFinanciamento(ActionEvent e) {
        System.out.println("a");
    }
}