package gerenciadordetreinos.view.swing;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(
            Runnable criarTreino,
            Runnable editarTreino,
            Runnable listarExercicios,
            Runnable sair) {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill   = GridBagConstraints.HORIZONTAL;
        gbc.gridx  = 0;

        int linha = 0;

        // Título
        JLabel titulo = new JLabel("Menu Principal", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 18f));
        gbc.gridy = linha++;
        add(titulo, gbc);

        // Botões
        JButton btnCriar  = new JButton("Criar / substituir treino");
        JButton btnEditar = new JButton("Editar treino");
        JButton btnListar = new JButton("Listar exercícios");
        JButton btnSair   = new JButton("Sair");

        btnCriar.addActionListener(e  -> criarTreino.run());
        btnEditar.addActionListener(e -> editarTreino.run());
        btnListar.addActionListener(e -> listarExercicios.run());
        btnSair.addActionListener(e   -> sair.run());

        for (JButton b : new JButton[]{btnCriar, btnEditar, btnListar, btnSair}) {
            gbc.gridy = linha++;
            add(b, gbc);
        }
    }
}
