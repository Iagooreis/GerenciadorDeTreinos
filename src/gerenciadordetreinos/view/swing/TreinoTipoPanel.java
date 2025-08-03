package gerenciadordetreinos.view.swing;

import gerenciadordetreinos.controller.AppState;
import gerenciadordetreinos.model.Treino;
import gerenciadordetreinos.util.TreinosPredefinidos;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

class TreinoTipoPanel extends JPanel {

    TreinoTipoPanel(Runnable voltarMenu) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill   = GridBagConstraints.HORIZONTAL;
        gbc.gridx  = 0;

        // -------- mapa opção → fábrica de treino --------
        Map<String, Treino> opcoes = new LinkedHashMap<>();
        opcoes.put("Hipertrofia",    TreinosPredefinidos.criarTreinoHipertrofia());
        opcoes.put("Força",          TreinosPredefinidos.criarTreinoForca());
        opcoes.put("Resistência",    TreinosPredefinidos.criarTreinoResistencia());
        opcoes.put("Funcional",      TreinosPredefinidos.criarTreinoFuncional());
        opcoes.put("Cardiovascular", TreinosPredefinidos.criarTreinoCardio());
        opcoes.put("HIIT",           TreinosPredefinidos.criarTreinoHIIT());

        // -------- lista (JList) com as opções --------
        JList<String> list = new JList<>(opcoes.keySet().toArray(new String[0]));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(6);
        JScrollPane scroll = new JScrollPane(list);

        gbc.gridy = 0;
        add(new JLabel("Escolha o tipo de treino:"), gbc);

        gbc.gridy = 1;
        add(scroll, gbc);

        // -------- botões --------
        JPanel botoes = new JPanel();
        JButton criarBtn  = new JButton("Criar / substituir");
        JButton voltarBtn = new JButton("Voltar");

        botoes.add(criarBtn);
        botoes.add(voltarBtn);

        gbc.gridy = 2;
        add(botoes, gbc);

        // --- ações ---
        criarBtn.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um tipo primeiro.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String chave  = list.getSelectedValue();
            Treino novo   = opcoes.get(chave);

            // usuário deve existir
            var usuario = AppState.getUsuario();

            if (usuario.temTreino()) {
                int resp = JOptionPane.showConfirmDialog(this,
                        "Um treino ("+usuario.getTreino().getTipo()+") já existe.\nSubstituir?",
                        "Confirmar", JOptionPane.YES_NO_OPTION);
                if (resp != JOptionPane.YES_OPTION) return;
            }

            usuario.definirTreino(novo);
            JOptionPane.showMessageDialog(this, "Treino salvo com sucesso!");
            voltarMenu.run();
        });

        voltarBtn.addActionListener(e -> voltarMenu.run());
    }
}
