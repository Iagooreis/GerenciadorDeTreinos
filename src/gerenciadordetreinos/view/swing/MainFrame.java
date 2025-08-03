package gerenciadordetreinos.view.swing;

import gerenciadordetreinos.controller.AppState;
import gerenciadordetreinos.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final CardLayout cards = new CardLayout();
    private final JPanel root     = new JPanel(cards);

    public MainFrame() {
        super("Gerenciador de Treinos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /* 1. Tela de cadastro */
        UserFormPanel cadastro = new UserFormPanel(this::usuarioSalvo);
        root.add(cadastro, "CADASTRO");

        /* 2. Menu principal – repare no 2º lambda */
        MenuPanel menu = new MenuPanel(
                () -> cards.show(root, "TREINO_TIPO"),
                this::abrirEditorTreino,                 // ← agora chama método
                this::abrirViewerTreino,
                this::encerrar);
        root.add(menu, "MENU");

        /* 3. Escolha de tipo de treino (já pronta) */
        TreinoTipoPanel telaTreino = new TreinoTipoPanel(() -> cards.show(root, "MENU"));
        root.add(telaTreino, "TREINO_TIPO");

        /* 4. EDITAR_TREINO: placeholder vazio     */
        root.add(new JPanel(), "EDITAR_TREINO");        // ← não cria o editor aqui

        /* 5. LISTAR_EXERCICIOS: ainda placeholder  */
        PlaceholderPanel telaListar = new PlaceholderPanel(
                "Tela de listagem (em construção)", () -> cards.show(root, "MENU"));
        root.add(telaListar, "LISTAR_EXERCICIOS");

        add(root);
        cards.show(root, "CADASTRO");
    }

    /* ---------- callbacks ---------- */

    /** chamado quando o usuário salva no formulário */
    private void usuarioSalvo(Usuario u) {
        AppState.setUsuario(u);
        JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
        cards.show(root, "MENU");
    }

    /** chamado pelo botão “Editar treino” do menu */
    private void abrirEditorTreino() {
        if (!AppState.temUsuario() || !AppState.getUsuario().temTreino()) {
            JOptionPane.showMessageDialog(this,
                    "Cadastre um usuário e crie um treino primeiro.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        /* cria o editor na hora */
        TreinoEditorPanel editor = new TreinoEditorPanel(() -> cards.show(root, "MENU"));
        root.add(editor, "EDITAR_TREINO_REAL");
        cards.show(root, "EDITAR_TREINO_REAL");
    }

    private void encerrar() {
        dispose();
    }
    private void abrirViewerTreino() {
        if (!AppState.temUsuario() || !AppState.getUsuario().temTreino()) {
            JOptionPane.showMessageDialog(this,
                    "Cadastre um usuário e crie um treino primeiro.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        TreinoViewerPanel viewer = new TreinoViewerPanel(() -> cards.show(root, "MENU"));
        root.add(viewer, "LISTAR_EXERCICIOS_REAL");
        cards.show(root, "LISTAR_EXERCICIOS_REAL");
    }

}
