/*
Checar funcionalidade de todas funções
Criar função excluír
 */


package painel;

import exceptions.*;
import modelo.*;
import util.ValidarValores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Painel extends JFrame {
    ImageIcon rightPNG = new ImageIcon(getClass().getResource("right.png"));

    // Adicionando variáveis fora do construtor para utilizar em outros métodos
    JRadioButton apartamentoButton;
    JRadioButton casaButton;
    JRadioButton terrenoButton;
    JLabel jLabelQuantidadeDeAndares;
    JLabel jLabelQuantidadeDeVagas;
    JLabel jLabelAreaTerreno;
    JLabel jLabelAreaConstruida;
    JLabel jLabelTipoDeZona;
    JTextField jTextFieldValorImovel;
    JTextField jTextFieldPrazoEmAnos;
    JTextField jTextFieldJurosAnual;
    JTextField jTextFieldQuantidadeDeAndares;
    JTextField jTextFieldQuantidadeDeVagas;
    JTextField jTextFieldAreaTerreno;
    JTextField jTextFieldAreaConstruida;
    JComboBox<String> jComboBoxTipoDeZona;
    JButton jButtonSalvar;
    JButton listarFinanciamentos;
    JButton editarFinanciamentos;
    JButton excluirFinanciamentos;

    /*
    ArrayList financiamentos é utilizado para transitar os dados de cada financiamento registrado entre diferentes Classes.
    Código também interage com outras classes.
     */
    ArrayList<Financiamento> financiamentos;
    int codigo;


    /*
    Criação da interface gráfica principal, com as operações CRUD.
     */
    public Painel(ArrayList<Financiamento> financiamentos, int codigo) {
        this.financiamentos = financiamentos;
        this.codigo = codigo;

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
        panelInformacoesDoFinanciamento.setBounds(0, 100, 330, 500);
        panelInformacoesDoFinanciamento.setBackground(new Color(127, 127, 127));
        panelInformacoesDoFinanciamento.setLayout(null);
        add(panelInformacoesDoFinanciamento);


        // JPanel Botões de ação do usuário
        JPanel panelAcoesUsuario = new JPanel();
        panelAcoesUsuario.setBounds(330, 100, 360, 500);
        panelAcoesUsuario.setBackground(new Color(110, 110, 110));
        panelAcoesUsuario.setLayout(null);
        add(panelAcoesUsuario);


        // radioButtons Informação do tipo de financiamento
        apartamentoButton = new JRadioButton("Apartamento");
        apartamentoButton.setOpaque(false);
        apartamentoButton.setBounds(0, 80, 150, 20);
        apartamentoButton.setFont(new Font("Arial", Font.BOLD, 20));
        apartamentoButton.addActionListener(this::escolherTipoDoImovel);

        casaButton = new JRadioButton("Casa");
        casaButton.setOpaque(false);
        casaButton.setBounds(0, 120, 100, 20);
        casaButton.setFont(new Font("Arial", Font.BOLD, 20));
        casaButton.addActionListener(this::escolherTipoDoImovel);

        terrenoButton = new JRadioButton("Terreno");
        terrenoButton.setOpaque(false);
        terrenoButton.setBounds(0, 160, 100, 20);
        terrenoButton.setFont(new Font("Arial", Font.BOLD, 20));
        terrenoButton.addActionListener(this::escolherTipoDoImovel);

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
        JLabel valorImovel = new JLabel("Valor do imóvel:");
        valorImovel.setBounds(29, 180, 400, 100);
        valorImovel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel prazoEmAnos = new JLabel("Prazo(em anos):");
        prazoEmAnos.setBounds(27, 230, 400, 100);
        prazoEmAnos.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel jurosAnual = new JLabel("Juros anual:");
        jurosAnual.setBounds(64, 280, 400, 100);
        jurosAnual.setFont(new Font("Arial", Font.BOLD, 20));

        panelInformacoesDoFinanciamento.add(valorImovel);
        panelInformacoesDoFinanciamento.add(prazoEmAnos);
        panelInformacoesDoFinanciamento.add(jurosAnual);


        // JLabel Informações específicas de cada imóvel a ser financiado
        jLabelQuantidadeDeAndares = new JLabel("Andares:");
        jLabelQuantidadeDeAndares.setBounds(97, 330, 400, 100);
        jLabelQuantidadeDeAndares.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelQuantidadeDeVagas = new JLabel("Vagas:");
        jLabelQuantidadeDeVagas.setBounds(117, 380, 400, 100);
        jLabelQuantidadeDeVagas.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelAreaTerreno = new JLabel("Área do terreno:");
        jLabelAreaTerreno.setBounds(27, 330, 400, 100);
        jLabelAreaTerreno.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelAreaConstruida = new JLabel("Área construída:");
        jLabelAreaConstruida.setBounds(25, 380, 400, 100);
        jLabelAreaConstruida.setFont(new Font("Arial", Font.BOLD, 20));

        jLabelTipoDeZona = new JLabel("Tipo de Zona:");
        jLabelTipoDeZona.setBounds(52, 330, 400, 100);
        jLabelTipoDeZona.setFont(new Font("Arial", Font.BOLD, 20));

        panelInformacoesDoFinanciamento.add(jLabelQuantidadeDeAndares);
        panelInformacoesDoFinanciamento.add(jLabelQuantidadeDeVagas);
        panelInformacoesDoFinanciamento.add(jLabelAreaTerreno);
        panelInformacoesDoFinanciamento.add(jLabelAreaConstruida);
        panelInformacoesDoFinanciamento.add(jLabelTipoDeZona);


        // JTextField Informações obrigatórias para todos os financiamentos
        jTextFieldValorImovel = new JTextField("50000");
        jTextFieldValorImovel.setBounds(185,222,110,20);
        jTextFieldValorImovel.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldPrazoEmAnos = new JTextField("8");
        jTextFieldPrazoEmAnos.setBounds(185,272,110,20);
        jTextFieldPrazoEmAnos.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldJurosAnual = new JTextField("8");
        jTextFieldJurosAnual.setBounds(185,322,110,20);
        jTextFieldJurosAnual.setFont(new Font("Arial", Font.BOLD, 15));

        panelInformacoesDoFinanciamento.add(jTextFieldValorImovel);
        panelInformacoesDoFinanciamento.add(jTextFieldPrazoEmAnos);
        panelInformacoesDoFinanciamento.add(jTextFieldJurosAnual);


        // JTextField Informações específicas de cada imóvel a ser financiado
        jTextFieldQuantidadeDeAndares = new JTextField();
        jTextFieldQuantidadeDeAndares.setBounds(185,372,110,20);
        jTextFieldQuantidadeDeAndares.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldQuantidadeDeVagas = new JTextField();
        jTextFieldQuantidadeDeVagas.setBounds(185,422,110,20);
        jTextFieldQuantidadeDeVagas.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldAreaTerreno = new JTextField();
        jTextFieldAreaTerreno.setBounds(185,372,110,20);
        jTextFieldAreaTerreno.setFont(new Font("Arial", Font.BOLD, 15));

        jTextFieldAreaConstruida = new JTextField();
        jTextFieldAreaConstruida.setBounds(185,422,110,20);
        jTextFieldAreaConstruida.setFont(new Font("Arial", Font.BOLD, 15));


        panelInformacoesDoFinanciamento.add(jTextFieldQuantidadeDeAndares);
        panelInformacoesDoFinanciamento.add(jTextFieldQuantidadeDeVagas);
        panelInformacoesDoFinanciamento.add(jTextFieldAreaTerreno);
        panelInformacoesDoFinanciamento.add(jTextFieldAreaConstruida);


        // JComboBox Tipo de zona do terreno
        String[] zonas = {"Residencial", "Comercial"};
        jComboBoxTipoDeZona = new JComboBox<>(zonas);
        jComboBoxTipoDeZona.setBounds(185,372,110,20);
        panelInformacoesDoFinanciamento.add(jComboBoxTipoDeZona);


        // JButton Salvar(cria um financiamento)
        jButtonSalvar = new JButton("Salvar");
        jButtonSalvar.setBounds(27, 30, 300, 70);
        jButtonSalvar.setFont(new Font("Arial", Font.BOLD, 40));
        jButtonSalvar.setForeground(new Color(200, 200, 200));
        jButtonSalvar.setBackground(new Color(50, 50, 50));
        jButtonSalvar.addActionListener(this::criarFinanciamentos);
        panelAcoesUsuario.add(jButtonSalvar);


        // JButton Listar(lista todos os financiamentos)
        listarFinanciamentos = new JButton("Listar");
        listarFinanciamentos.setBounds(27, 140, 300, 70);
        listarFinanciamentos.setFont(new Font("Arial", Font.BOLD, 40));
        listarFinanciamentos.setForeground(new Color(200, 200, 200));
        listarFinanciamentos.setBackground(new Color(50, 50, 50));
        listarFinanciamentos.addActionListener(this::listarFinanciamentos);
        panelAcoesUsuario.add(listarFinanciamentos);


        // JButton Editar(edita um financiamento)
        editarFinanciamentos = new JButton("Editar");
        editarFinanciamentos.setBounds(27, 250, 300, 70);
        editarFinanciamentos.setFont(new Font("Arial", Font.BOLD, 40));
        editarFinanciamentos.setForeground(new Color(200, 200, 200));
        editarFinanciamentos.setBackground(new Color(50, 50, 50));
        editarFinanciamentos.addActionListener(this::editarFinanciamentos);
        panelAcoesUsuario.add(editarFinanciamentos);


        // JButton Excluir(exclui um financiamentos)
        excluirFinanciamentos = new JButton("Excluir");
        excluirFinanciamentos.setBounds(27, 360, 300, 70);
        excluirFinanciamentos.setFont(new Font("Arial", Font.BOLD, 40));
        excluirFinanciamentos.setForeground(new Color(200, 200, 200));
        excluirFinanciamentos.setBackground(new Color(50, 50, 50));
        excluirFinanciamentos.addActionListener(this::excluirFinanciamentos);
        panelAcoesUsuario.add(excluirFinanciamentos);


        setVisible(true);


        // Deixando as JLabels/JTextFields/JComboBox específicos invisíveis
        jLabelQuantidadeDeAndares.setVisible(false);
        jLabelQuantidadeDeVagas.setVisible(false);
        jLabelAreaTerreno.setVisible(false);
        jLabelAreaConstruida.setVisible(false);
        jLabelTipoDeZona.setVisible(false);

        jTextFieldQuantidadeDeAndares.setVisible(false);
        jTextFieldQuantidadeDeVagas.setVisible(false);
        jTextFieldAreaTerreno.setVisible(false);
        jTextFieldAreaConstruida.setVisible(false);
        jComboBoxTipoDeZona.setVisible(false);
    }


    // Radiobuttons metódo
    public void escolherTipoDoImovel(ActionEvent e) {
        // Deixando as JLabels/JTextFields/JComboBox específicos invisíveis
        jLabelQuantidadeDeAndares.setVisible(false);
        jLabelQuantidadeDeVagas.setVisible(false);
        jLabelAreaTerreno.setVisible(false);
        jLabelAreaConstruida.setVisible(false);
        jLabelTipoDeZona.setVisible(false);

        jTextFieldQuantidadeDeAndares.setVisible(false);
        jTextFieldQuantidadeDeVagas.setVisible(false);
        jTextFieldAreaTerreno.setVisible(false);
        jTextFieldAreaConstruida.setVisible(false);
        jComboBoxTipoDeZona.setVisible(true);

        // Controlando a visibilidade de valores específicos
        if (e.getSource() == apartamentoButton) {
            jLabelQuantidadeDeAndares.setVisible(true);
            jLabelQuantidadeDeVagas.setVisible(true);
            jTextFieldQuantidadeDeAndares.setVisible(true);
            jTextFieldQuantidadeDeVagas.setVisible(true);
        } else if (e.getSource() == casaButton) {
            jLabelAreaTerreno.setVisible(true);
            jLabelAreaConstruida.setVisible(true);
            jTextFieldAreaTerreno.setVisible(true);
            jTextFieldAreaConstruida.setVisible(true);
        } else if (e.getSource() == terrenoButton) {
            jLabelTipoDeZona.setVisible(true);
            jComboBoxTipoDeZona.setVisible(true);
        }
    }


    // JButtom Salvar
    /*
    Válida se todos os dados estão corretos antes de salvar o financiamento no ArrayList Financiamentos.
     */
    public void criarFinanciamentos(ActionEvent actionEvent) {
        try {
            int controle = 0;

            // Valores obrigatórias
            float valorImovel = Float.parseFloat(jTextFieldValorImovel.getText());
            int prazoFinanciamento = Integer.parseInt(jTextFieldPrazoEmAnos.getText());
            float jurosAnual = Float.parseFloat(jTextFieldJurosAnual.getText());

            if (ValidarValores.financiamentoGeral(valorImovel, prazoFinanciamento, jurosAnual)) {
                // Valores específicos da classe Apartamento
                if (jLabelQuantidadeDeAndares.isVisible()) {
                    int quantidadeDeAndares = Integer.parseInt(jTextFieldQuantidadeDeAndares.getText());
                    int quantidadeDeVagas = Integer.parseInt((jTextFieldQuantidadeDeVagas.getText()));

                    if (ValidarValores.apartamento(quantidadeDeAndares, quantidadeDeVagas)) {
                        financiamentos.add(new Apartamento(codigo, "Apartamento", valorImovel, prazoFinanciamento, jurosAnual, quantidadeDeAndares, quantidadeDeVagas));
                        controle = 1;
                    }

                    // Valores específicos da classe Casa
                } else if (jLabelAreaTerreno.isVisible()) {
                    double areaTerreno = Double.parseDouble(jTextFieldAreaTerreno.getText());
                    double areaConstruida = Double.parseDouble(jTextFieldAreaConstruida.getText());

                    if (ValidarValores.casa(areaTerreno, areaConstruida)) {
                        financiamentos.add(new Casa(codigo, "Casa", valorImovel, prazoFinanciamento, jurosAnual, areaTerreno, areaConstruida));
                        controle = 1;
                    }

                    // Valores específicos da classe Terreno
                } else if (jLabelTipoDeZona.isVisible()) {
                    String tipoDeZona = (String) jComboBoxTipoDeZona.getSelectedItem();
                    financiamentos.add(new Terreno(codigo, "Terreno", valorImovel, prazoFinanciamento, jurosAnual, tipoDeZona));
                    controle = 1;

                    // Tipo do imóvel não selecionado
                } else
                    throw new TipoFinanciamentoInvalidoException("Imóvel inválido");

                if (controle == 1) {
                    JOptionPane.showMessageDialog(null, "financiamento aprovado.",
                            "Financiamento Realizado", JOptionPane.INFORMATION_MESSAGE, rightPNG);
                    codigo += 1;
                }
            }

        } catch (TipoFinanciamentoInvalidoException e) {
            JOptionPane.showMessageDialog(null, "Selecione o tipo do imóvel que deseja financiar.",
                    "ERROR: Tipo de imóvel inválido.", JOptionPane.ERROR_MESSAGE);

        }
    }


    // JButton Listar
    private void listarFinanciamentos(ActionEvent actionEvent) {
        dispose();
        // O número de colunas é necessário para fazer o encaixe do segundo botão na função excluir
        new WindowListar(financiamentos, 1);
    }


    // JButton Editar
    private void editarFinanciamentos(ActionEvent actionEvent) {
        dispose();
        new WindowEditar(financiamentos, 2);
    }


    // JButton excluir
    private void excluirFinanciamentos(ActionEvent actionEvent) {
        dispose();
        new WindowExcluir(financiamentos);
    }
}