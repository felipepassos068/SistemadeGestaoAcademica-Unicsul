# 🎓 Sistema de Gestão Acadêmica - Unicsul

Este é um sistema desktop desenvolvido em **Java** utilizando a biblioteca **Swing** para interface gráfica. O objetivo da aplicação é gerenciar o cadastro de alunos em diferentes campi da universidade, utilizando **Árvores Binárias de Busca (BST)** para o armazenamento e organização eficiente dos dados.

## 🚀 Funcionalidades

O sistema oferece três operações principais através de uma interface gráfica amigável:

1.  **Cadastrar Aluno:**
    * Permite inserir um aluno em um campus específico.
    * **Validação Global:** O sistema verifica se o aluno já existe em *qualquer* campus antes de cadastrar (evita duplicidade).
    * Os alunos são inseridos na árvore de forma ordenada (alfabética).
2.  **Localizar Aluno:**
    * Busca em todos os campi cadastrados.
    * Retorna o nome do campus onde o aluno estuda, caso encontrado.
3.  **Listar Alunos:**
    * Exibe todos os alunos de um campus selecionado.
    * A listagem é apresentada em **ordem alfabética** (graças ao percurso "in-order" da Árvore Binária).

## 🏫 Campi Disponíveis

O sistema gerencia múltiplas árvores binárias, uma para cada unidade:
* Anália Franco
* Guarulhos
* Liberdade
* Paulista
* São Miguel
* Santo Amaro
* Villa Lobos

## 🛠️ Aspectos Técnicos

Este projeto é um ótimo exemplo de aplicação de Estruturas de Dados:

* **Árvore Binária de Busca (BST):** Cada nó contém o nome do aluno. A inserção e busca possuem complexidade média de *O(log n)*.
* **Recursividade:** Os métodos de inserção, busca e listagem (`inserirRec`, `buscarRec`, `listarRec`) utilizam recursão para navegar nos nós.
* **Map (LinkedHashMap):** Utilizado para gerenciar a coleção de campi, associando o nome do campus (String) à sua respectiva árvore (ArvoreBinaria).
* **Java Swing:** Uso de `JFrame`, `JOptionPane`, `JPanel` e `JScrollPane` para interação com o usuário.

## 💻 Como Rodar o Projeto

### Pré-requisitos
* Ter o [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/downloads/) instalado (versão 8 ou superior).

### Passo a Passo

1.  **Clone o repositório** ou baixe o arquivo de código.
2.  Certifique-se de que o arquivo se chama **`SistemaUnicsulGUI.java`**.
3.  Abra o terminal (ou CMD) na pasta do arquivo.
4.  **Compile o código:**
    ```bash
    javac SistemaUnicsulGUI.java
    ```
5.  **Execute a aplicação:**
    ```bash
    java SistemaUnicsulGUI
    ```

## 📂 Estrutura do Código

* **`class Node`**: Define a estrutura do nó da árvore (nome, esquerda, direita).
* **`class ArvoreBinaria`**: Contém a lógica da estrutura de dados (inserir, buscar, listar).
* **`class SistemaUnicsulGUI`**: Gerencia a interface gráfica e a lógica de negócios (interação entre os campi).

## ⚠️ Observação Importante

O sistema utiliza armazenamento em **memória volátil** (RAM). Isso significa que, ao fechar a aplicação, os dados cadastrados serão perdidos. Para persistência de dados, seria necessário implementar conexão com Banco de Dados ou salvamento em arquivos (txt/json).


---

Felipe Passos de Albuquerque
.
