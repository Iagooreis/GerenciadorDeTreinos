# Gerenciador de Treinos 🏋️‍♂️

Projeto Java para gerenciamento de treinos físicos, com suporte a interface gráfica (Swing) e interface via terminal (CLI). Permite cadastrar usuários, associar treinos e exercícios por dia da semana e editar cada sessão de treino de forma simples e eficaz.

## ✨ Funcionalidades

- Cadastro de usuário com nome e peso
- Treinos predefinidos (Força, Hipertrofia, HIIT)
- Associação de exercícios por dia da semana
- Edição de treinos (inserir, remover e atualizar exercícios)
- Visualização dos treinos cadastrados
- Interface gráfica moderna (Swing) ou uso via terminal (modo texto)

## 📁 Estrutura do Projeto

```
GerenciadorDeTreinos/
├── src/
│   └── gerenciadordetreinos/
│       ├── MainCLI.java            # Interface terminal
│       ├── controller/             # Controle de estado da aplicação
│       ├── model/                  # Classes de domínio: Usuario, Treino, Exercicio
│       ├── util/                   # Utilitários: input, treinos predefinidos
│       └── view/swing/             # Interface gráfica (Swing)
│           └── MainSwing.java      # Ponto de entrada da GUI
├── .gitignore
└── README.md
```

## ▶️ Como executar

### 1. Requisitos

- Java 17 ou superior
- IntelliJ IDEA (ou outra IDE compatível com projetos Java)

### 2. Executar no IntelliJ

- Abra o IntelliJ e selecione "Open" na pasta `GerenciadorDeTreinos`
- Execute uma das opções:
  - `MainCLI.java` → Modo terminal
  - `MainSwing.java` → Modo gráfico (Swing)

### 3. Compilar via terminal

```bash
cd src
javac gerenciadordetreinos/MainCLI.java
java gerenciadordetreinos.MainCLI
```

Ou para a interface gráfica:

```bash
javac gerenciadordetreinos/view/swing/MainSwing.java
java gerenciadordetreinos.view.swing.MainSwing
```

> 💡 Dica: Certifique-se de estar com o Java configurado no PATH do seu sistema.

## 🛠 Tecnologias usadas

- Java 17
- Biblioteca padrão (Swing para GUI)
- IntelliJ IDEA como ambiente de desenvolvimento

## 🧾 Licença

Este projeto é de uso educacional/pessoal. Sinta-se livre para usar e modificar.
