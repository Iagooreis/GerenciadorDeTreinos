package gerenciadordetreinos.model;

import java.util.*;

public class Treino {
    private String tipo; // ex: "Hipertrofia"
    private Map<String, List<Exercicio>> rotinaPorDia; // chave: "Segunda", valor: lista de exercícios

    public Treino(String tipo) {
        this.tipo = tipo;
        this.rotinaPorDia = new LinkedHashMap<>(); // mantém ordem dos dias, se quisermos
    }

    public String getTipo() {
        return tipo;
    }

    public void adicionarExercicio(String diaSemana, Exercicio exercicio) {
        rotinaPorDia.putIfAbsent(diaSemana, new ArrayList<>());
        rotinaPorDia.get(diaSemana).add(exercicio);
    }

    public void removerExercicio(String diaSemana, int index) {
        List<Exercicio> lista = rotinaPorDia.get(diaSemana);
        if (lista != null && index >= 0 && index < lista.size()) {
            lista.remove(index);
        }
    }

    public void editarExercicio(String diaSemana, int index, Exercicio novoExercicio) {
        List<Exercicio> lista = rotinaPorDia.get(diaSemana);
        if (lista != null && index >= 0 && index < lista.size()) {
            lista.set(index, novoExercicio);
        }
    }

    public List<String> getDias() {
        return new ArrayList<>(rotinaPorDia.keySet());
    }

    public List<Exercicio> getExerciciosDoDia(String diaSemana) {
        return rotinaPorDia.getOrDefault(diaSemana, new ArrayList<>());
    }

    @Override
    public String toString() {
        return "Treino de " + tipo;
    }

    public void listarTreinoCompleto() {
        for (String dia : rotinaPorDia.keySet()) {
            System.out.println("\n" + dia + ":");
            for (Exercicio e : rotinaPorDia.get(dia)) {
                System.out.println("  - " + e);
            }
        }
    }
}