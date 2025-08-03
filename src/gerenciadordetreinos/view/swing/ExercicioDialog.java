package gerenciadordetreinos.view.swing;

import gerenciadordetreinos.model.Exercicio;

import javax.swing.*;
import java.awt.*;

class ExercicioDialog extends JDialog {

    private JTextField nomeField     = new JTextField(20);
    private JTextField grupoField    = new JTextField(15);
    private JSpinner   seriesSpin    = new JSpinner(new SpinnerNumberModel(3, 1, 99, 1));
    private JSpinner   repsSpin      = new JSpinner(new SpinnerNumberModel(10, 1, 200, 1));
    private JSpinner   cargaSpin     = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.5));
    private Exercicio  resultado     = null;

    ExercicioDialog(Window owner, Exercicio existente) {
        super(owner, "Exercício", ModalityType.APPLICATION_MODAL);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill   = GridBagConstraints.HORIZONTAL;

        int y = 0;
        add(new JLabel("Nome:"),           gbc(0,y)); add(nomeField,  gbc(1,y++));
        add(new JLabel("Grupo muscular:"), gbc(0,y)); add(grupoField, gbc(1,y++));
        add(new JLabel("Séries:"),         gbc(0,y)); add(seriesSpin, gbc(1,y++));
        add(new JLabel("Repetições:"),     gbc(0,y)); add(repsSpin,   gbc(1,y++));
        add(new JLabel("Carga (kg):"),     gbc(0,y)); add(cargaSpin,  gbc(1,y++));

        JButton ok  = new JButton("OK");
        JButton cancel = new JButton("Cancelar");
        JPanel  botoes = new JPanel();
        botoes.add(ok); botoes.add(cancel);
        gbc.gridx=0; gbc.gridy=y; gbc.gridwidth=2;
        add(botoes, gbc);

        /* Pré-preenche se for edição */
        if (existente != null) {
            nomeField.setText(existente.getNome());
            grupoField.setText(existente.getGrupoMuscular());
            seriesSpin.setValue(existente.getSeries());
            repsSpin.setValue(existente.getRepeticoes());
            cargaSpin.setValue(existente.getCarga());
        }

        ok.addActionListener(e -> {
            if (nomeField.getText().trim().isEmpty() ||
                    grupoField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,"Nome e grupo são obrigatórios","Erro",JOptionPane.ERROR_MESSAGE);
                return;
            }
            resultado = new Exercicio(
                    nomeField.getText().trim(),
                    grupoField.getText().trim(),
                    (Integer) seriesSpin.getValue(),
                    (Integer) repsSpin.getValue(),
                    ((Number) cargaSpin.getValue()).doubleValue());
            dispose();
        });
        cancel.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(owner);
    }

    Exercicio getResultado() { return resultado; }

    private GridBagConstraints gbc(int x,int y){
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(5,5,5,5);
        g.fill   = GridBagConstraints.HORIZONTAL;
        g.gridx=x; g.gridy=y;
        return g;
    }
}
