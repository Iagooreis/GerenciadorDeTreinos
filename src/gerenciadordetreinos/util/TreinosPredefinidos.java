package gerenciadordetreinos.util;

import gerenciadordetreinos.model.Exercicio;
import gerenciadordetreinos.model.Treino;

public class TreinosPredefinidos {

    public static Treino criarTreinoHipertrofia() {
        Treino treino = new Treino("Hipertrofia");

        // Segunda - Peito e Tríceps
        treino.adicionarExercicio("Segunda", new Exercicio("Supino reto com barra", "Peito", 4, 10, 50));
        treino.adicionarExercicio("Segunda", new Exercicio("Supino inclinado com halteres", "Peito", 3, 10, 24));
        treino.adicionarExercicio("Segunda", new Exercicio("Crucifixo inclinado", "Peito", 3, 12, 16));
        treino.adicionarExercicio("Segunda", new Exercicio("Tríceps corda", "Tríceps", 3, 12, 25));
        treino.adicionarExercicio("Segunda", new Exercicio("Tríceps francês", "Tríceps", 3, 10, 20));

        // Terça - Pernas (ênfase em quadríceps e glúteos)
        treino.adicionarExercicio("Terça", new Exercicio("Agachamento livre", "Pernas", 4, 8, 70));
        treino.adicionarExercicio("Terça", new Exercicio("Leg press 45º", "Pernas", 4, 12, 200));
        treino.adicionarExercicio("Terça", new Exercicio("Cadeira extensora", "Pernas", 3, 15, 45));
        treino.adicionarExercicio("Terça", new Exercicio("Avanço com halteres", "Glúteos", 3, 12, 18));

        // Quarta - Costas e Bíceps
        treino.adicionarExercicio("Quarta", new Exercicio("Puxada frontal na barra", "Costas", 4, 10, 55));
        treino.adicionarExercicio("Quarta", new Exercicio("Remada curvada com barra", "Costas", 3, 10, 40));
        treino.adicionarExercicio("Quarta", new Exercicio("Remada unilateral com halter", "Costas", 3, 12, 24));
        treino.adicionarExercicio("Quarta", new Exercicio("Rosca direta", "Bíceps", 3, 10, 22));
        treino.adicionarExercicio("Quarta", new Exercicio("Rosca alternada", "Bíceps", 3, 12, 16));

        // Quinta - Ombros e Trapézio
        treino.adicionarExercicio("Quinta", new Exercicio("Desenvolvimento militar com barra", "Ombros", 4, 10, 30));
        treino.adicionarExercicio("Quinta", new Exercicio("Elevação lateral com halteres", "Ombros", 3, 15, 10));
        treino.adicionarExercicio("Quinta", new Exercicio("Elevação frontal", "Ombros", 3, 12, 8));
        treino.adicionarExercicio("Quinta", new Exercicio("Encolhimento com barra", "Trapézio", 3, 15, 35));

        // Sexta - Posterior de coxa + Panturrilha + Abdômen
        treino.adicionarExercicio("Sexta", new Exercicio("Stiff com halteres", "Posterior de coxa", 4, 10, 40));
        treino.adicionarExercicio("Sexta", new Exercicio("Mesa flexora", "Posterior de coxa", 3, 12, 35));
        treino.adicionarExercicio("Sexta", new Exercicio("Levantamento terra romeno", "Posterior de coxa", 3, 10, 50));
        treino.adicionarExercicio("Sexta", new Exercicio("Panturrilha no leg press", "Panturrilha", 4, 20, 100));
        treino.adicionarExercicio("Sexta", new Exercicio("Abdominal supra solo", "Abdômen", 3, 20, 0));
        treino.adicionarExercicio("Sexta", new Exercicio("Prancha isométrica", "Abdômen", 3, 60, 0)); // segundos

        return treino;
    }



    public static Treino criarTreinoForca() {
        Treino treino = new Treino("Força");

        // Segunda – Posterior + Core
        treino.adicionarExercicio("Segunda", new Exercicio("Levantamento terra romeno", "Posterior de coxa", 5, 5, 90));
        treino.adicionarExercicio("Segunda", new Exercicio("Mesa flexora pesada", "Posterior de coxa", 4, 6, 45));
        treino.adicionarExercicio("Segunda", new Exercicio("Stiff com barra", "Posterior de coxa", 4, 5, 80));
        treino.adicionarExercicio("Segunda", new Exercicio("Prancha com peso", "Abdômen", 3, 45, 10)); // 45s

        // Terça – Peito + Tríceps
        treino.adicionarExercicio("Terça", new Exercicio("Supino reto com barra", "Peito", 5, 5, 85));
        treino.adicionarExercicio("Terça", new Exercicio("Supino inclinado com halteres", "Peito", 4, 6, 28));
        treino.adicionarExercicio("Terça", new Exercicio("Mergulho em paralelas", "Tríceps", 4, 6, 0));
        treino.adicionarExercicio("Terça", new Exercicio("Tríceps testa com barra", "Tríceps", 3, 8, 25));

        // Quarta – Costas + Bíceps
        treino.adicionarExercicio("Quarta", new Exercicio("Barra fixa com peso", "Costas", 5, 5, 10));
        treino.adicionarExercicio("Quarta", new Exercicio("Remada curvada com barra", "Costas", 4, 6, 50));
        treino.adicionarExercicio("Quarta", new Exercicio("Remada cavalinho", "Costas", 4, 6, 40));
        treino.adicionarExercicio("Quarta", new Exercicio("Rosca direta com barra", "Bíceps", 4, 6, 25));

        // Quinta – Pernas (Quadríceps + Glúteos)
        treino.adicionarExercicio("Quinta", new Exercicio("Agachamento livre com barra", "Pernas", 5, 5, 100));
        treino.adicionarExercicio("Quinta", new Exercicio("Leg press pesado", "Pernas", 4, 6, 250));
        treino.adicionarExercicio("Quinta", new Exercicio("Cadeira extensora", "Pernas", 3, 8, 55));
        treino.adicionarExercicio("Quinta", new Exercicio("Avanço com halteres", "Glúteos", 3, 10, 20));

        // Sexta – Ombros + Trapézio + Abdômen
        treino.adicionarExercicio("Sexta", new Exercicio("Desenvolvimento militar com barra", "Ombros", 5, 5, 35));
        treino.adicionarExercicio("Sexta", new Exercicio("Elevação lateral", "Ombros", 3, 8, 12));
        treino.adicionarExercicio("Sexta", new Exercicio("Encolhimento com barra", "Trapézio", 4, 6, 50));
        treino.adicionarExercicio("Sexta", new Exercicio("Abdominal com anilha", "Abdômen", 3, 15, 10));

        return treino;
    }


    public static Treino criarTreinoResistencia() {
        Treino treino = new Treino("Resistência");

        // Segunda – Parte superior (resistência muscular)
        treino.adicionarExercicio("Segunda", new Exercicio("Flexão de braço", "Peito / Tríceps", 3, 20, 0));
        treino.adicionarExercicio("Segunda", new Exercicio("Remada invertida", "Costas", 3, 15, 0));
        treino.adicionarExercicio("Segunda", new Exercicio("Prancha com toques nos ombros", "Core / Ombros", 3, 30, 0)); // 30s

        // Terça – Cardiorrespiratório e abdômen
        treino.adicionarExercicio("Terça", new Exercicio("Corrida leve", "Cardio", 1, 20, 0)); // 20 minutos
        treino.adicionarExercicio("Terça", new Exercicio("Abdominal infra", "Abdômen", 3, 25, 0));
        treino.adicionarExercicio("Terça", new Exercicio("Prancha lateral", "Core", 3, 30, 0)); // 30s cada lado

        // Quarta – Parte inferior (resistência muscular)
        treino.adicionarExercicio("Quarta", new Exercicio("Agachamento com peso corporal", "Pernas", 3, 25, 0));
        treino.adicionarExercicio("Quarta", new Exercicio("Avanço alternado", "Glúteos / Pernas", 3, 20, 0));
        treino.adicionarExercicio("Quarta", new Exercicio("Elevação de panturrilha", "Panturrilha", 3, 30, 0));

        // Quinta – Circuito funcional de corpo inteiro
        treino.adicionarExercicio("Quinta", new Exercicio("Burpees", "Corpo inteiro", 3, 15, 0));
        treino.adicionarExercicio("Quinta", new Exercicio("Mountain climbers", "Core / Cardio", 3, 40, 0)); // segundos
        treino.adicionarExercicio("Quinta", new Exercicio("Polichinelos", "Cardio", 3, 50, 0));
        treino.adicionarExercicio("Quinta", new Exercicio("Saltos verticais", "Pernas / Cardio", 3, 15, 0));

        // Sexta – Cardio + pliometria
        treino.adicionarExercicio("Sexta", new Exercicio("Pular corda", "Cardio", 3, 60, 0)); // 60s
        treino.adicionarExercicio("Sexta", new Exercicio("Salto sobre banco", "Pernas", 3, 12, 0));
        treino.adicionarExercicio("Sexta", new Exercicio("Corrida estacionária", "Cardio", 3, 60, 0));

        return treino;
    }

    public static Treino criarTreinoFuncional() {
        Treino treino = new Treino("Funcional");

        // Segunda – Core e mobilidade
        treino.adicionarExercicio("Segunda", new Exercicio("Prancha frontal", "Core", 3, 45, 0)); // segundos
        treino.adicionarExercicio("Segunda", new Exercicio("Prancha lateral", "Core", 3, 30, 0));
        treino.adicionarExercicio("Segunda", new Exercicio("Mobilidade de quadril com elástico", "Quadril", 3, 10, 0));

        // Terça – Pernas + coordenação
        treino.adicionarExercicio("Terça", new Exercicio("Agachamento com salto", "Pernas", 3, 12, 0));
        treino.adicionarExercicio("Terça", new Exercicio("Avanço com rotação de tronco", "Pernas / Core", 3, 10, 0));
        treino.adicionarExercicio("Terça", new Exercicio("Subida no banco com joelhada", "Pernas / Coordenação", 3, 10, 0));

        // Quarta – Parte superior + equilíbrio
        treino.adicionarExercicio("Quarta", new Exercicio("Flexão de braço alternada", "Peito / Ombros", 3, 15, 0));
        treino.adicionarExercicio("Quarta", new Exercicio("Puxada unilateral com elástico", "Costas", 3, 12, 10));
        treino.adicionarExercicio("Quarta", new Exercicio("Equilíbrio em um pé + rotação de ombro", "Coordenação", 3, 12, 0));

        // Quinta – Corpo inteiro (empurrar + agachar)
        treino.adicionarExercicio("Quinta", new Exercicio("Agachamento com peso corporal", "Pernas", 3, 20, 0));
        treino.adicionarExercicio("Quinta", new Exercicio("Flexão de braço com joelho ao cotovelo", "Peito / Core", 3, 12, 0));
        treino.adicionarExercicio("Quinta", new Exercicio("Burpee leve (sem salto)", "Corpo inteiro", 3, 10, 0));

        // Sexta – Agilidade e pliometria leve
        treino.adicionarExercicio("Sexta", new Exercicio("Pular corda", "Cardio / Coordenação", 3, 60, 0));
        treino.adicionarExercicio("Sexta", new Exercicio("Salto lateral com apoio único", "Pernas", 3, 12, 0));
        treino.adicionarExercicio("Sexta", new Exercicio("Corrida em zig-zag com cones", "Agilidade", 3, 30, 0)); // segundos

        return treino;
    }


    public static Treino criarTreinoCardio() {
        Treino treino = new Treino("Cardiovascular");

        // Segunda – Corrida leve contínua (zona aeróbica)
        treino.adicionarExercicio("Segunda", new Exercicio("Corrida em esteira", "Cardio", 1, 30, 0)); // 30 minutos
        treino.adicionarExercicio("Segunda", new Exercicio("Caminhada leve", "Cardio", 1, 15, 0)); // aquecimento/desaquecimento

        // Terça – Ciclismo indoor
        treino.adicionarExercicio("Terça", new Exercicio("Bike ergométrica com resistência média", "Cardio", 1, 45, 0));
        treino.adicionarExercicio("Terça", new Exercicio("Alongamento ativo", "Mobilidade", 3, 30, 0)); // segundos

        // Quarta – Cardio funcional com peso corporal
        treino.adicionarExercicio("Quarta", new Exercicio("Polichinelos", "Cardio", 3, 50, 0));
        treino.adicionarExercicio("Quarta", new Exercicio("Mountain climbers", "Cardio/Core", 3, 40, 0));
        treino.adicionarExercicio("Quarta", new Exercicio("Corrida estacionária com joelhos altos", "Cardio", 3, 30, 0));

        // Quinta – Corrida intervalada (tiros)
        treino.adicionarExercicio("Quinta", new Exercicio("Tiro de corrida 1 min", "Cardio", 5, 1, 0)); // 5 tiros de 1 min
        treino.adicionarExercicio("Quinta", new Exercicio("Caminhada de recuperação 2 min", "Cardio", 5, 2, 0)); // 2 min entre tiros

        // Sexta – Elíptico + escada
        treino.adicionarExercicio("Sexta", new Exercicio("Elíptico com resistência leve", "Cardio", 1, 30, 0));
        treino.adicionarExercicio("Sexta", new Exercicio("Subida de escada ou step", "Cardio / Pernas", 3, 60, 0)); // 60 segundos

        return treino;
    }


    public static Treino criarTreinoHIIT() {
        Treino treino = new Treino("HIIT");

        // Segunda – HIIT com foco em pernas
        treino.adicionarExercicio("Segunda", new Exercicio("Agachamento com salto", "Pernas", 4, 20, 0));
        treino.adicionarExercicio("Segunda", new Exercicio("Afundo alternado com salto", "Pernas", 4, 20, 0));
        treino.adicionarExercicio("Segunda", new Exercicio("Corrida estacionária com joelhos altos", "Cardio", 4, 30, 0));

        // Terça – Sprints e Core
        treino.adicionarExercicio("Terça", new Exercicio("Sprint 30s", "Cardio", 6, 30, 0));
        treino.adicionarExercicio("Terça", new Exercicio("Mountain climbers", "Core", 4, 40, 0));
        treino.adicionarExercicio("Terça", new Exercicio("Prancha com toques nos ombros", "Core", 3, 40, 0));

        // Quarta – Corpo inteiro
        treino.adicionarExercicio("Quarta", new Exercicio("Burpees", "Corpo inteiro", 4, 15, 0));
        treino.adicionarExercicio("Quarta", new Exercicio("Jumping jacks", "Cardio", 4, 50, 0));
        treino.adicionarExercicio("Quarta", new Exercicio("Polichinelos com salto alto", "Cardio", 3, 30, 0));

        // Quinta – Foco em membros superiores
        treino.adicionarExercicio("Quinta", new Exercicio("Flexão de braço", "Peito", 4, 12, 0));
        treino.adicionarExercicio("Quinta", new Exercicio("Flexão diamante", "Tríceps", 3, 10, 0));
        treino.adicionarExercicio("Quinta", new Exercicio("Burpee com flexão", "Corpo inteiro", 3, 8, 0));

        // Sexta – HIIT funcional
        treino.adicionarExercicio("Sexta", new Exercicio("Corrida estacionária", "Cardio", 4, 40, 0));
        treino.adicionarExercicio("Sexta", new Exercicio("Pular corda", "Cardio", 4, 60, 0));
        treino.adicionarExercicio("Sexta", new Exercicio("Agachamento isométrico 30s", "Pernas", 3, 30, 0));

        return treino;
    }

}