# java.Swing

## JFrame
Cria janelas gráficas, tela principal que suporta botões, painéis, entre outros componentes.

### Métodos principais
Tornar janela visível: `setVisible(boolean visibility)`.

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
Tornar painel visível: `setVisible(boolean visibility)`.

Adicionar componentes ao painel: `add(Component comp)`.

Gerenciar layout, determinar como os componentes são organizados dentro do painel: `setLayout(LayoutManager mgr`.

Definir posicionamento, tamanho e largura do painel(só funciona com layout=null): `setBounds(int x, int y, int width, int height)`.

Definir cor de fundo do painel: `setBackground(Color bg)`.


## JRadioButton
Botões de opção (radio buttons) da interface gráfica, permite apenas que uma opção seja escolhida por vez.

### Métodos principais
Tornar botões de escolha visíveis: `setVisible(boolean visibility)`.

Definir posicionamento, tamanho e largura dos botões de escolha(só funciona com layout=null): `setBounds(int x, int y, int width, int height)`.

Definir o fundo como opaco: `setOpaque(boolean isOpaque)`.

Definir estilo, tamanho e tipo de fonte dos botões de escolha: `setFont(new Font("fontName", Font.[attribute], [size]))`.

Adicionar ActionListener aos botões de escolha para executar eventos de ação: `addActionListener(ActionListener l)`.


## JLabel
Exibe textos ou imagens em uma interface gráfica. Frequentemente usado para rotular outros componentes, 
como campos de texto, botões ou grupos de opções.

### Métodos principais
Tornar os textos visíveis: `setVisible(boolean visibility)`.

Definir posicionamento, tamanho e largura dos textos(só funciona com layout=null): `setBounds(int x, int y, int width, int height)`.

Definir estilo, tamanho e tipo de fonte dos textos: `setFont(new Font("fontName", Font.[attribute], [size]))`.


## JTextField
Caixa que permite a entrada de uma única linha de texto pelo usuário.

### Métodos principais
Tornar a caixa visivel: `setVisible(boolean visibility)`.

Definir posicionamento, tamanho e largura da caixa(só funciona com layout=null): `setBounds(int x, int y, int width, int height)`.

Definir estilo, tamanho e tipo de fonte do texto digitado: `setFont(new Font("fontName", Font.[attribute], [size]))`.

Retornar o texto inserido do campo: `getText()`.


## JComboBox
Caixa suspensa(drop-down) de itens.

## Métodos principais
Tornar caixa visivel: `setVisible(boolean visibility)`.
Adicionar item a caixa suspensa: `addItem(Object item)`.
Remover item da caixa suspensa: `addItem(Object item)`.
Retornar item selecionado da caixa suspensa: `getSelectedItem()`


## JButton
Botão interativo que responde a eventos de click.

## Métodos principais
Tornar botão visivel: `setVisible(boolean visibility)`.
Definir posicionamento, tamanho e largura do botão(só funciona com layout=null): `setBounds(int x, int y, int width, int height)`.
Definir estilo, tamanho e tipo de fonte do botão: `setFont(new Font("fontName", Font.[attribute], [size]))`.
Definir cor de fundo do botão: `setBackground(Color bg)`.
Adicionar ActionListener ao botão para executar eventos de ação: `addActionListener(ActionListener l)`.
Definir texto do botão: `setText(String text)`.



# painel

## PainelPrincipal
Classe responsável pela criação do painel principal, tem como parâmetros o ArrayList de Financiamentos e o último código
adicionado.

**12-34:** Instanciação das variáveis responsáveis pela interface num contexto global.

**42-44:** Método construtor, recebe como parâmetro o Array de financiamentos e o valor do código do financiamento
a ser cadastrado.

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

**17-36:** Instanciação das variáveis responsáveis pela interface num contexto global.

**41-45:** JFrame - Janela base utilizada por todas as classes herdeiras da mesma.

**49-53:** JPanel - Painel que contém a área em que serão apresentados os valores de cada financiamento.

**57-60:** JPanel - Painel que contém os botões baseado em qual função o usuário escolheu.

**64-67:** Loop que obtém o código de cada financiamento e os guarda num Array.

**71-73:** JComboBox - Permite a escolha de qual financimaneto será listado e/ou alterado por meio do código.

**77-96:** JLabel - Informações gerais do financiamento.

**100-124:** JLabel - Informações específicas do financiamento.

**128-133:** JButton - Voltar para o painel principal.


### Métodos
**138-147:** private void voltarParaMenuPrincipal(ActionEvent actionEvent) - Volta para o painel principal após clicar,
no botão voltar. Instancia o painel com o próximo código da lista de financiamentos para que os dados do próximo 
financiamento a serem salvos seja colocado numa nova posição. 
Caso a lista esteja vazia, instancia o painel com o código 0.

**149-155:** protected void ocultarJLabelsEspecificas() - Oculta as JLabels não relacionadas ao tipo de financiamento
escolhido por meio do método `setVisible(boolean visibility)`.



## WindowListar
**9-12:** Método construtor, recebe como parâmetro o Array de financiamentos e a quantidade de colunas(determina a 
quantidade de botões).

**14-18:** JComboBox - Escolher o financiamento desejado para exibir as informações do mesmo.


### Métodos
**21-59:** private void visualizarInformacoes(ActionEvent actionEvent) - Verifica o valor que está selecionado na
`jComboBoxListaDeFinanciamentos` e exibe as informações do financiamento cujo o ID é idêntico a esse valor por meio do
método `setVisible(boolean visibility)` que está sendo aplicado nas JLabels.



## WindowEditar
**18-27:** Instanciação das variáveis responsáveis pela interface num contexto global.

**30-32:** Método construtor, recebe como parâmetro o Array de financiamentos e a quantidade de colunas(determina a
quantidade de botões).

**34-35:** JComboBox - Escolher o financiamento desejado para alterar as informações do mesmo.

**39-53:** JTextField - Campo de texto dos valores obrigatórios do financiamento.

**57-77:** JTextField - Campo de texto dos valores específicos do financiamento.

**81-84:** JComboBox - Caixa drop-down para escolher o tipo de zona caso o financiamento seja do tipo terreno.

**88-93:** JButton - Botão para atualizar os dados do financiamento escolhido.


### Métodos
**101-158:** private void visualizarInformacoes(ActionEvent actionEvent) - Oculta a visibilidade das JLabel
específicas por meio do método `ocultarJLabelsEspecificas()`, verifica o tipo do financiamento, exibe as JLabel 
condizentes e por fim mostra os JTextField para que os valores possam ser alterados.

**162-223:** atualizarFinanciamentos(ActionEvent actionEvent) - Percorre o Array de financiamentos para encontrar o id
correspondente ao selecionado na JComboBox, analisa os novos valores informados e verifica se são ou não válidos.



## WindowExcluir
**10-27:** Utiliza o painel da classe WindowListar para criar seu próprio painel, porém com duas colunas.


### Métodos
**29-40:** private void excluir(ActionEvent actionEvent) - Percorre o Array de financiamentos para encontrar o id
correspondente ao selecionado na JComboBox, exclui todos os dados deste financiamento.