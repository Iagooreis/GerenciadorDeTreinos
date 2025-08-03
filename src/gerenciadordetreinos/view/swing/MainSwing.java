package gerenciadordetreinos.view.swing;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MainSwing {

    public static void main(String[] args) {

        /* Toda GUI deve começar na Event Dispatch Thread */
        SwingUtilities.invokeLater(() -> {
            /* Tenta usar o look-and-feel nativo do SO (Windows, GTK, etc.)   */
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
            catch (Exception ignored) {}

            new MainFrame().setVisible(true);   // mostra a janela principal
        });
    }
}
