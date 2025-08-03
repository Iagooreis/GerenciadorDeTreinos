package gerenciadordetreinos.view.swing;

import gerenciadordetreinos.controller.AppState;
import gerenciadordetreinos.model.Exercicio;
import gerenciadordetreinos.model.Treino;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class TreinoViewerPanel extends JPanel {

    private final Treino treino;
    private final JList<String> listaDias;
    private final JTextArea     areaTexto;

    TreinoViewerPanel(Runnable voltarMenu) {
        if (!AppState.temUsuario() || !AppState.getUsuario().temTreino()) {
            throw new IllegalStateException("Sem treino cadastrado.");
        }
        this.treino = AppState.getUsuario().getTreino();

        setLayout(new BorderLayout(10, 10));

        /* ---- lista de dias + opção completa ---- */
        List<String> dias = new ArrayList<>();
        dias.add("Treino completo");
        dias.addAll(treino.getDias());

        listaDias = new JList<>(dias.toArray(new String[0]));
        listaDias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(listaDias), BorderLayout.WEST);

        /* ---- área de texto ---- */
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        /* ---- botão ---- */
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> voltarMenu.run());
        add(voltar, BorderLayout.SOUTH);

        /* ---- listener ---- */
        listaDias.addListSelectionListener(e -> mostrarSelecionado());

        // seleciona “Treino completo” por padrão
        listaDias.setSelectedIndex(0);
    }

    /* -------- helpers -------- */

    private void mostrarSelecionado() {
        if (listaDias.getSelectedIndex() == -1) return;

        StringBuilder sb = new StringBuilder();
        String escolha = listaDias.getSelectedValue();

        if ("Treino completo".equals(escolha)) {
            for (String dia : treino.getDias()) {
                sb.append(dia).append(":\n");
                imprimirExercicios(treino.getExerciciosDoDia(dia), sb);
                sb.append('\n');
            }
        } else {
            sb.append(escolha).append(":\n");
            imprimirExercicios(treino.getExerciciosDoDia(escolha), sb);
        }
        areaTexto.setText(sb.toString());
        areaTexto.setCaretPosition(0); // volta ao topo
    }

    private void imprimirExercicios(List<Exercicio> lista, StringBuilder sb) {
        for (Exercicio ex : lista) {
            sb.append(" • ").append(ex).append('\n');
        }
    }
}
