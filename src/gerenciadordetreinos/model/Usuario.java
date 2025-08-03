package gerenciadordetreinos.model;

public class Usuario {

    /* ---- dados básicos ---- */
    private String nome;
    private int idade;
    private String objetivo;
    private double pesoAtual;

    /* ---- único plano de treino ---- */
    private Treino treinoAtual;   // pode ficar null (sem treino)

    /* ---- construtor “normal” ---- */
    public Usuario(String nome, int idade, String objetivo, double pesoAtual) {
        this.nome = nome;
        this.idade = idade;
        this.objetivo = objetivo;
        this.pesoAtual = pesoAtual;
    }

    /* ---- getters usados no fluxo ---- */
    public String getNome()      { return nome; }
    public int    getIdade()     { return idade; }
    public double getPesoAtual() { return pesoAtual; }

    /* ---- operações sobre o treino ---- */
    public boolean temTreino()            { return treinoAtual != null; }
    public Treino  getTreino()            { return treinoAtual; }

    /**
     * Define ou substitui o treino atual.
     * @return true se havia um treino que foi trocado
     */
    public boolean definirTreino(Treino novoTreino) {
        boolean havia = treinoAtual != null;
        treinoAtual = novoTreino;
        return havia;
    }
}
