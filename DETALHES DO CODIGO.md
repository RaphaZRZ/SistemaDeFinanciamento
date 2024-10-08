# painel

## PainelPrincipal
Classe responsável pela criação do painel principal, tem como parâmetros o ArrayList de Financiamentos e o último código
adicionado.


**13-34:** Instanciação das variáveis responsáveis pela interface num contexto global.

**47-52:** JFrame - Janela principal do programa que contém todas as funcionalidades do programa.
É possível alterar a dimensão, se pode ser redimensionado enquanto a aplicação está ativa, se o processamento é cortado
após fechar a aplicação, o posicionamento da janela principal e o seu layout.

**56-76:** JPanel - Separação de seções do programa, blocos com cores diferentes que contém diferentes informações. 
O painel azul no topo destaca o título do programa, o painel cinza claro à esquerda contém os campos para inserir 
os dados de um novo financiamento, já o painel cinza escuro à direita é dedicado aos botões de ação do usuário, 
como `Salvar`, `Listar`, `Editar` e `Excluir`. É possível alterar a dimensão, posicionamento e a cor dos painéis.

**80-107:** JRadioButton - Botões de seleção que permitem ao usuário escolher o tipo de imóvel a ser financiado. 
Há três opções: Apartamento, Casa e Terreno. Cada botão dispara um evento através do método a `addActionListener`, 
que chama a função `escolherTipoDoImovel` para definir o tipo de financiamento selecionado. 
O grupo de botões de rádio é gerenciado por um `ButtonGroup` para garantir que apenas uma opção seja selecionada 
por vez. As propriedades de opacidade, posição e a fonte do texto podem ser personalizadas conforme necessário.

**111-140:** JLabel obrigatória - Textos que aparecerão na tela independente de quais ações o usuário tomar. Contém o 
título, os textos para informar ao usuário o que deve ser feito e quais valores devem ser informados. É possível alterar
a dimensão, posicionamento, fonte e cor dos textos.

**144-168:** JLabel específica - Textos que aparecerão na tela somente quando o usuário selecionar o 
tipo de financiamento desejado. Contém informações para financiar um apartamento, casa ou terreno, textos para informar 
ao usuário quais valores devem ser inseridos. É possível alterar a dimensão, posicionamento, fonte e cor dos textos.

**172-186:** JTextField obrigatório - Caixa de texto utilizada pelo usuário para informar os valores gerais
do financiamento. É possível alterar a dimensão, posicionamento e a fonte do texto que será inserido no campo.

**190-210:** JTextField específica - Caixa de texto utilizada pelo usuário para informar os valores específicos 
do financiamento. É possível alterar a dimensão, posicionamento e a fonte do texto que será inserido no campo.

**190-210:** JTextField específica - Caixa de texto utilizada pelo usuário para informar os valores específicos
do financiamento. É possível alterar a dimensão, posicionamento e a fonte do texto que será inserido no campo.

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
conforme o tipo de financiamento escolhido pelo usuário

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

**-:** ...