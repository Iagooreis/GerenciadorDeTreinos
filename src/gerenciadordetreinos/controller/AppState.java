package gerenciadordetreinos.controller;

import gerenciadordetreinos.model.Usuario;

public final class AppState {

    private static Usuario usuarioAtual;   // começa null

    public static Usuario getUsuario()          { return usuarioAtual; }
    public static void    setUsuario(Usuario u) { usuarioAtual = u; }

    private AppState() {}   // impede instanciar

    // AppState.java  (no pacote controller)
    public static boolean temUsuario() {
        return usuarioAtual != null;
    }

}
