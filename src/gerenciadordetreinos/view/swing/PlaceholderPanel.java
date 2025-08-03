package gerenciadordetreinos.view.swing;

import javax.swing.*;
import java.awt.*;

class PlaceholderPanel extends JPanel {

    PlaceholderPanel(String texto, Runnable voltarMenu) {
        setLayout(new BorderLayout(10,10));

        add(new JLabel(texto, SwingConstants.CENTER), BorderLayout.CENTER);

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> voltarMenu.run());
        add(voltar, BorderLayout.SOUTH);
    }
}
