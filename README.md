# ![Interface](https://github.com/user-attachments/assets/5b929ffe-e9ae-4ca2-83d9-ae1881c11e1d)
> Status: DESENVOLVIMENTO ⚠️

## Sobre o projeto:
Sistema que valida várias regras de negócio para criar um financiamento correto, contendo as operações CRUD e persistência de dados num file .json.

## Sobre o código:
- `\src\main` Contém o ArrayList de financiamentos, também inicia a janela criada pelo java.swing.
- `\src\painel` Contém todo código para que cada botão e janela funcione corretamente.
- `\src\modelo` Contém a classe Financiamento e suas especializações.
- `\scr\util` Contém as regras de negócio para validar cada financiamento.
- `\src\exceptions` Contém todas as exceções do código, geralmente relacionadas às regras de negócio.

## Atualizações:
*09/10/2024:* Explicação da classe `Painel` concluída.
              Explicação dos componentes utilizados da biblioteca `java.swing` concluída.

*08/10/2024:* Início da documentação do código para facilitar futuras alterações.

*20/09/2024:* Finalização da interface com a biblioteca java.swing.

*04/09/2024:* `jComboBoxListaDeFinanciamentos` foi realocada na classe `WindowGeral`.
Criação do método `ocultarJLabelsEspecificas` na classe `WindowGeral`.

*01/09/2024:* Substituição de `if/else` para `Switch/case`.
Finzalização da implementação dos métodos validadores com a utilização de uma variável de controle.

*30/08/2024:* Encapsulamento aprimorado da classe `ValidarValores`. 
Começo da implementação de métodos capazes de validar todas as informações de determinado tipo de financiamento.

*27/08/2024:* Criação da Classe `WindowGeral`(sendo a classe pais das classes `WindowListar`/`WindowEditar`/`WindowExcluir`).
              Começo da otimização do código.

*21/08/2024:* Documentação do processo para facilitar a criação de atualizações futuras.

*31/07/2024:* Implementação do botão `excluirFinanciamentos`(arrumar posição do botão).

*28/07/2024:* Implementação do botão `editarFinanciamentos`.

*24/07/2024:* Implementação do sistema de escolha do financiamento a ser mostrado na opção listar.

*23/07/2024:* Criação de código único para cada financiamento.
Criação de uma variável específica para identificar o tipo do imóvel a ser financiado.

*22/07/2024:* Começo da implementação da função listar.

*19/07/2024:* Implementação de todas as regras de negócio.
Implementação do botão Salvar.
Começo da implementação dos botões `listarFinanciamentos`/`editarFinanciamentos`/`excluirFinanciamentos`.

*17/07/2024:* Implementação das regras de negócio para financiamentos de casas e apartamentos.

*16/07/2024:* Criação de novas exceções.
Começo da implementação das regras de negócio.

*15/07/2024:* Implementação do controle de visibilidade de informações a depender do imóvel a ser financiado.

*12/07/2024:* Começo da implementação de uma interface gráfica por meio da biblioteca Swing.

*08/07/2024:* Persistência de dados com file `reader/writer` e `objectStream in/out`.

*25/06/2024:* Implementação de tratamentos de exceções com `try/catch`.
Implementação de exceções personalizadas.

*20/06/2024:* Implementação de novos atributos nas classes herdadas da classe `Financiamento`.

*04/06/2024:* Finalização dos cálculos da nova precificação, merge da branch com a `Main`.

*03/06/2024:* Criação da branch `NovaPrecificação`.

*30/05/2024:* Separação da classe `Financiamento` em subclasses.

*28/05/2024:* Criação das classes principais do projeto.