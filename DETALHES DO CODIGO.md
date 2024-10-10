# java.Swing

## JFrame
Cria janelas gráficas, tela principal que suporta botões, painéis, entre outros componentes.

### Métodos principais
Tornar janela visível: `setVisible(boolean visible)`.

Adicionar componentes a janela: `add(Component comp)`.

Gerenciar layout, determinar como os componentes são organizados dentro da janela: `setLayout(LayoutManager mgr`.

Inserir título na barra superior da janela: `setTitle("Title")`.

Alterar o tamanho da janela: `setSize(int width, int height)`.

Encerrar programa ao fechar a janela: `setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)`.

Impedir que o usuário redimensione a janela: `setResizable(false)`

Centralizar janela na tela ao abrir: `setLocationRelativeTo(null)`


## JPanel
Área de contenção ou contêiner que pode ser usada para organizar outros componentes gráficos.

### Métodos principais
Tornar painel visível: `setVisible(boolean visible)`.

Adicionar componentes ao painel: `add(Component comp)`.

Gerenciar layout, determinar como os componentes são organizados dentro do painel: `setLayout(LayoutManager mgr`.

Definir posicionamento, tamanho e largura do painel(só funciona com layout=null): `setBounds(int x, int y, int width, int height)`.

Definir cor de fundo do painel: `setBackground(Color bg)`.


## JRadioButton
Botões de opção (radio buttons) da interface gráfica, permite apenas que uma opção seja escolhida por vez.

### Métodos principais
Tornar botões de escolha visíveis: `setVisible(boolean visible)`.

Definir posicionamento, tamanho e largura dos botões de escolha(só funciona com layout=null): `setBounds(int x, int y, int width, int height)`.

Definir o fundo como opaco: `setOpaque(boolean isOpaque)`.

Definir estilo, tamanho e tipo de fonte dos botões de escolha: `setFont(new Font("fontName", Font.[attribute], [size]))`.

Adicionar ActionListener aos botões de escolha para executar eventos de ação: `addActionListener(ActionListener l)`.


## JLabel
Exibe textos ou imagens em uma interface gráfica. Frequentemente usado para rotular outros componentes, 
como campos de texto, botões ou grupos de opções.

### Métodos principais
Tornar os textos visíveis: `setVisible(boolean visible)`.

Definir posicionamento, tamanho e largura dos textos(só funciona com layout=null): `setBounds(int x, int y, int width, int height)`.

Definir estilo, tamanho e tipo de fonte dos textos: `setFont(new Font("fontName", Font.[attribute], [size]))`.


## JTextField
Caixa que permite a entrada de uma única linha de texto pelo usuário.

### Métodos principais
Tornar a caixa visivel: `setVisible(boolean visible)`.

Definir posicionamento, tamanho e largura da caixa(só funciona com layout=null): `setBounds(int x, int y, int width, int height)`.

Definir estilo, tamanho e tipo de fonte do texto digitado: `setFont(new Font("fontName", Font.[attribute], [size]))`.

Retornar o texto inserido do campo: `getText()`.


## JComboBox



# painel

## PainelPrincipal
Classe responsável pela criação do painel principal, tem como parâmetros o ArrayList de Financiamentos e o último código
adicionado.


**13-34:** Instanciação das variáveis responsáveis pela interface num contexto global.

**47-52:** JFrame - Janela principal que contém todos as funcionalidades do programa.

**56-76:** JPanel - Separação de seções do programa, blocos com cores diferentes que contém diferentes informações. 
O painel azul no topo destaca o título do programa, o painel cinza claro à esquerda contém os campos para inserir 
os dados de um novo financiamento, já o painel cinza escuro à direita é dedicado aos botões de ação do usuário, 
como `Salvar`, `Listar`, `Editar` e `Excluir`.

**80-107:** JRadioButton - Botões de seleção que permitem ao usuário escolher o tipo de imóvel a ser financiado. 
Há três opções: Apartamento, Casa e Terreno. Cada botão dispara um evento através do método a `addActionListener`, 
que chama a função `escolherTipoDoImovel` para definir o tipo de financiamento selecionado. 
O grupo de botões de rádio é gerenciado por um `ButtonGroup` para garantir que apenas uma opção seja selecionada 
por vez.

**111-140:** JLabel obrigatória - Textos que aparecerão na tela independente de quais ações o usuário tomar. Contém o 
título, os textos para informar ao usuário o que deve ser feito e quais valores devem ser informados. É possível alterar
a dimensão, posicionamento, fonte e cor dos textos.

**144-168:** JLabel específica - Textos que aparecerão na tela somente quando o usuário selecionar o 
tipo de financiamento desejado. Contém informações para financiar um apartamento, casa ou terreno, textos para informar 
ao usuário quais valores devem ser inseridos.

**172-186:** JTextField obrigatório - Caixa de texto utilizada pelo usuário para informar os valores gerais
do financiamento.

**190-210:** JTextField específica - Caixa de texto utilizada pelo usuário para informar os valores específicos 
do financiamento.

**214-217:** JComboBox - Seleciona o tipo do terreno, entre `Residencial` e `Comercial`.
É possível alterar a dimensão, posicionamento e os itens contidos na caixa.

**221-257:** JButton - Botões para Salvar/Listar/Editar/Excluir financiamentos, cada botão é configurado com seu próprio
método de ação. 
Os métodos são (`criarFinanciamentos`/`listarFinanciamentos`/`editarFinanciamentos`/`excluirFinanciamentos`).
É possível alterar a dimensão, posicionamento, cor, método a ser chamado, texto e fonte do botão.

**260-274:** Torna todos os componentes visíveis pelo método `setVisible(true)`, em seguida oculta apenas as informações
específicas até que as mesmas sejam solicitadas pelo usuário.


### Métodos

**279-308:** escolherTipoDoImovel(ActionEvent e) - Controla a visibilidade dos `JTextField` e `JLabel`específicos
conforme o tipo de financiamento escolhido pelo usuário.

**312-364** public void criarFinanciamentos(ActionEvent actionEvent) - Valida todas as informações informadas pelo 
usuário utilizando os métodos da classe `ValidarValores` e, se tudo estiver correto, instancia um novo financiamento e
o adiciona no array de financiamentos cadastrados.

**368:372** private void listarFinanciamentos(ActionEvent actionEvent) - Abre uma nova janela para listar os 
financiamentos, está é instanciada com o argumento de apenas 1 botão(voltar).

**376:380** private void listarFinanciamentos(ActionEvent actionEvent) - Abre uma nova janela para editar os 
financiamentos utilizando os métodos da classe `ValidarValores`, está é instanciada com o argumento 
de 2 botões(voltar e atualizar). Se os valores estiverem corretos, atualiza os valores do financiamento.

**384:387** private void listarFinanciamentos(ActionEvent actionEvent) - Abre uma nova janela para excluir os 
financiamentos, está é instanciada sem argumentos, porém contém 2 botões(voltar e excluir).



## WindowGeral
Classe que define o tamanho da janela aberta quando as funções listar/editar/excluir são chamadas.
Tem como parâmetro a quantidade de botões, geralmente entre 1 e 2.


**18-36:** Instanciação das variáveis responsáveis pela interface num contexto global.