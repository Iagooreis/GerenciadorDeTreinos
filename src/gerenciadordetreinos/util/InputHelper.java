package gerenciadordetreinos.util;

import gerenciadordetreinos.model.Exercicio;

import java.util.Scanner;

public final class InputHelper {

    public static int lerIntPositivo(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                if (valor > 0) return valor;
            } else {
                scanner.nextLine(); // descarta texto inválido
            }
            System.out.println("Valor inválido. Digite um número inteiro positivo.");
        }
    }


    public static double lerDoubleNaoNegativo(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextDouble()) {
                double valor = scanner.nextDouble();
                scanner.nextLine();
                if (valor >= 0) return valor;
            } else {
                scanner.nextLine();
            }
            System.out.println("Valor inválido. Digite um número não-negativo.");
        }
    }


    public static String lerTextoNaoVazio(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) return texto;
            System.out.println("Campo não pode ficar vazio. Tente novamente.");
        }
    }



    public static Exercicio criarExercicioViaScanner(Scanner scanner) {

        String nome   = lerTextoNaoVazio(scanner, "Nome do exercício: ");
        String grupo  = lerTextoNaoVazio(scanner, "Grupo muscular: ");
        int series    = lerIntPositivo(scanner, "Séries: ");
        int reps      = lerIntPositivo(scanner, "Repetições: ");
        double carga  = lerDoubleNaoNegativo(scanner, "Carga (kg): ");

        return new Exercicio(nome, grupo, series, reps, carga);
    }

    // Construtor privado para impedir instanciação
    private InputHelper() { }
}
