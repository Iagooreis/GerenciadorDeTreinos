package gerenciadordetreinos;

import gerenciadordetreinos.model.Exercicio;
import gerenciadordetreinos.model.Treino;
import gerenciadordetreinos.model.Usuario;
import gerenciadordetreinos.util.InputHelper;
import gerenciadordetreinos.util.TreinosPredefinidos;

import java.util.List;
import java.util.Scanner;

public class MainCLI {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Usuario usuario = null;

        while (true) {
            System.out.println("\n=== GERENCIADOR DE TREINOS ===");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Criar / substituir treino predefinido");
            System.out.println("3. Editar treino");
            System.out.println("4. Listar exercícios");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();   // limpa o \n

            switch (opcao) {

                /* ---------- 1. Cadastro ---------- */
                case 1 -> {
                    String nome   = InputHelper.lerTextoNaoVazio(scanner, "Nome do usuário: ");
                    int    idade  = InputHelper.lerIntPositivo(scanner, "Idade: ");
                    String objetivo = InputHelper.lerTextoNaoVazio(scanner, "Objetivo (ex: hipertrofia): ");
                    double peso   = InputHelper.lerDoubleNaoNegativo(scanner, "Peso atual (kg): ");

                    usuario = new Usuario(nome, idade, objetivo, peso);
                    System.out.println("Usuário cadastrado com sucesso!");
                }

                /* ---------- 2. Criar OU substituir o único treino ---------- */
                case 2 -> {
                    if (usuario == null) {
                        System.out.println("Cadastre um usuário primeiro.");
                        continue;
                    }

                    // menu de tipos
                    System.out.println("Escolha o tipo de treino:");
                    System.out.println("1. Hipertrofia");
                    System.out.println("2. Força");
                    System.out.println("3. Resistência");
                    System.out.println("4. Funcional");
                    System.out.println("5. Cardiovascular");
                    System.out.println("6. HIIT");
                    System.out.print("Opção: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    Treino novoTreino = switch (tipo) {
                        case 1 -> TreinosPredefinidos.criarTreinoHipertrofia();
                        case 2 -> TreinosPredefinidos.criarTreinoForca();
                        case 3 -> TreinosPredefinidos.criarTreinoResistencia();
                        case 4 -> TreinosPredefinidos.criarTreinoFuncional();
                        case 5 -> TreinosPredefinidos.criarTreinoCardio();
                        case 6 -> TreinosPredefinidos.criarTreinoHIIT();
                        default -> null;
                    };

                    if (novoTreino == null) {
                        System.out.println("Opção inválida.");
                        continue;
                    }

                    /* se já existir treino, confirmar substituição */
                    if (usuario.temTreino()) {
                        System.out.println("Já existe um treino cadastrado (" +
                                usuario.getTreino().getTipo() + "). Substituir? (s/n): ");
                        String resp = scanner.nextLine().trim().toLowerCase();
                        if (!resp.equals("s")) {
                            System.out.println("Operação cancelada.");
                            continue;
                        }
                    }

                    usuario.definirTreino(novoTreino);
                    System.out.println("Treino salvo com sucesso!");
                }

                /* ---------- 3. Editar exercícios do treino único ---------- */
                case 3 -> {
                    if (usuario == null || !usuario.temTreino()) {
                        System.out.println("Cadastre um usuário e um treino primeiro.");
                        continue;
                    }

                    Treino treino = usuario.getTreino();
                    List<String> dias = treino.getDias();

                    if (dias.isEmpty()) {
                        System.out.println("Treino não contém dias cadastrados.");
                        continue;
                    }

                    // escolher dia
                    System.out.println("Dias disponíveis:");
                    for (int i = 0; i < dias.size(); i++) {
                        System.out.println(i + " - " + dias.get(i));
                    }
                    int diaIdx = scanner.nextInt();
                    scanner.nextLine();
                    if (diaIdx < 0 || diaIdx >= dias.size()) {
                        System.out.println("Dia inválido.");
                        continue;
                    }
                    String diaEscolhido = dias.get(diaIdx);

                    // lista de exercícios do dia
                    List<Exercicio> exercicios = treino.getExerciciosDoDia(diaEscolhido);
                    System.out.println("Exercícios de " + diaEscolhido + ":");
                    for (int i = 0; i < exercicios.size(); i++) {
                        System.out.println(i + " - " + exercicios.get(i));
                    }

                    System.out.println("1. Editar exercício");
                    System.out.println("2. Remover exercício");
                    System.out.println("3. Adicionar exercício");
                    int acao = scanner.nextInt();
                    scanner.nextLine();

                    switch (acao) {
                        case 1, 2 -> {
                            System.out.print("Escolha o número do exercício: ");
                            int exIndex = scanner.nextInt();
                            scanner.nextLine();
                            if (exIndex < 0 || exIndex >= exercicios.size()) {
                                System.out.println("Índice inválido.");
                                break;
                            }
                            if (acao == 1) {  // editar
                                Exercicio novoEx = InputHelper.criarExercicioViaScanner(scanner);
                                treino.editarExercicio(diaEscolhido, exIndex, novoEx);
                                System.out.println("Exercício editado com sucesso!");
                            } else {          // remover
                                treino.removerExercicio(diaEscolhido, exIndex);
                                System.out.println("Exercício removido com sucesso!");
                            }
                        }
                        case 3 -> { // adicionar
                            Exercicio novoEx = InputHelper.criarExercicioViaScanner(scanner);
                            treino.adicionarExercicio(diaEscolhido, novoEx);
                            System.out.println("Exercício adicionado com sucesso!");
                        }
                        default -> System.out.println("Ação inválida.");
                    }
                }

                /* ---------- 4. Listar exercícios (dia ou treino completo) ---------- */
                case 4 -> {
                    if (usuario == null || !usuario.temTreino()) {
                        System.out.println("Nada cadastrado ainda.");
                        continue;
                    }

                    Treino treino = usuario.getTreino();
                    System.out.println("Deseja ver:");
                    System.out.println("1. Exercícios de um dia específico");
                    System.out.println("2. Treino completo");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    if (escolha == 2) {
                        treino.listarTreinoCompleto();
                        continue;
                    }

                    List<String> dias = treino.getDias();
                    System.out.println("Dias disponíveis:");
                    for (int i = 0; i < dias.size(); i++) {
                        System.out.println(i + " - " + dias.get(i));
                    }
                    int diaIdx = scanner.nextInt();
                    scanner.nextLine();
                    if (diaIdx < 0 || diaIdx >= dias.size()) {
                        System.out.println("Dia inválido.");
                        continue;
                    }
                    String dia = dias.get(diaIdx);

                    System.out.println("Exercícios do dia " + dia + ":");
                    for (Exercicio e : treino.getExerciciosDoDia(dia)) {
                        System.out.println("  - " + e);
                    }
                }

                /* ---------- 5. Sair ---------- */
                case 5 -> {
                    System.out.println("Encerrando...");
                    return;
                }

                /* ---------- opção inexistente ---------- */
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
