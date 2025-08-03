package gerenciadordetreinos.model;

public class Exercicio {
    private String nome;
    private String grupoMuscular;
    private int series;
    private int repeticoes;
    private double carga;

    public Exercicio(String nome, String grupoMuscular, int series, int repeticoes, double carga) {
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.series = series;
        this.repeticoes = repeticoes;
        this.carga = carga;
    }

    public String getNome() {
        return nome;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }


    @Override
    public String toString() {
        return nome + " (" + grupoMuscular + ") - " +
                series + "x" + repeticoes + " @ " + carga + "kg";
    }
}
