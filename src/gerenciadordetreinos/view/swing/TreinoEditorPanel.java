package gerenciadordetreinos.view.swing;

import gerenciadordetreinos.controller.AppState;
import gerenciadordetreinos.model.Exercicio;
import gerenciadordetreinos.model.Treino;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class TreinoEditorPanel extends JPanel {

    private final Treino treino;
    private final JList<String> listaDias;
    private final ExercicioTableModel model;
    private final JTable tabela;

    TreinoEditorPanel(Runnable voltarMenu) {

        // Confere se há treino
        if (!AppState.temUsuario() || !AppState.getUsuario().temTreino()) {
            throw new IllegalStateException("Usuário sem treino definido!");
        }
        this.treino = AppState.getUsuario().getTreino();

        setLayout(new BorderLayout(10, 10));

        /* ---- Dias (lado esquerdo) ---- */
        listaDias = new JList<>(treino.getDias().toArray(new String[0]));
        listaDias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(listaDias), BorderLayout.WEST);

        /* ---- Tabela de exercícios ---- */
        model  = new ExercicioTableModel(List.of()); // iniciamos vazio
        tabela = new JTable(model);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        /* ---- Botões ---- */
        JPanel botoes = new JPanel();
        JButton addBtn    = new JButton("Adicionar");
        JButton editBtn   = new JButton("Editar");
        JButton remBtn    = new JButton("Remover");
        JButton voltarBtn = new JButton("Voltar");

        botoes.add(addBtn);
        botoes.add(editBtn);
        botoes.add(remBtn);
        botoes.add(voltarBtn);
        add(botoes, BorderLayout.SOUTH);

        /* ---- Listeners ---- */
        // Carrega exercícios quando muda o dia
        listaDias.addListSelectionListener(e -> carregarDiaSelecionado());

        // Adicionar
        addBtn.addActionListener(e -> {
            if (!diaSelecionado()) return;

            ExercicioDialog dlg = new ExercicioDialog(
                    SwingUtilities.getWindowAncestor(this), null);
            dlg.setVisible(true);

            Exercicio ex = dlg.getResultado();
            if (ex != null) {
                treino.adicionarExercicio(dia(), ex); // altera só no Treino
                model.fireTableDataChanged();         // atualiza UI
            }
        });

        // Editar
        editBtn.addActionListener(e -> {
            if (!diaSelecionado()) return;
            int row = tabela.getSelectedRow();
            if (row == -1) { warn("Selecione um exercício."); return; }

            Exercicio original = model.get(row);
            ExercicioDialog dlg = new ExercicioDialog(
                    SwingUtilities.getWindowAncestor(this), original);
            dlg.setVisible(true);

            Exercicio novo = dlg.getResultado();
            if (novo != null) {
                treino.editarExercicio(dia(), row, novo); // altera no Treino
                model.fireTableRowsUpdated(row, row);      // refresca linha
            }
        });

        // Remover
        remBtn.addActionListener(e -> {
            if (!diaSelecionado()) return;
            int row = tabela.getSelectedRow();
            if (row == -1) { warn("Selecione um exercício."); return; }

            int resp = JOptionPane.showConfirmDialog(
                    this, "Remover exercício?", "Confirma",
                    JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                treino.removerExercicio(dia(), row); // remove no Treino
                model.fireTableDataChanged();        // atualiza tabela
            }
        });

        // Voltar ao menu
        voltarBtn.addActionListener(e -> voltarMenu.run());

        // Seleciona o primeiro dia por padrão
        if (!treino.getDias().isEmpty()) {
            listaDias.setSelectedIndex(0);
        }
    }

    /* ---------- Helpers ---------- */

    private void carregarDiaSelecionado() {
        if (diaSelecionado()) {
            model.setExercicios(treino.getExerciciosDoDia(dia()));
        }
    }

    private boolean diaSelecionado() {
        if (listaDias.getSelectedIndex() == -1) {
            warn("Selecione um dia primeiro.");
            return false;
        }
        return true;
    }

    private String dia() {
        return listaDias.getSelectedValue();
    }

    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg,
                "Aviso", JOptionPane.WARNING_MESSAGE);
    }
}
