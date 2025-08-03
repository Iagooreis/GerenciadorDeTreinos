package gerenciadordetreinos.view.swing;

import gerenciadordetreinos.model.Usuario;
import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class UserFormPanel extends JPanel {

    private final JTextField nomeField;
    private final JTextField idadeField;
    private final JTextField pesoField;
    private final JComboBox<String> objetivoBox;
    private final JButton salvarBtn;

    public UserFormPanel(Consumer<Usuario> aoSalvar) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo: Nome
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);
        nomeField = new JTextField(20);
        gbc.gridx = 1;
        add(nomeField, gbc);

        // Campo: Idade
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Idade:"), gbc);
        idadeField = new JTextField();
        gbc.gridx = 1;
        add(idadeField, gbc);

        // Campo: Peso
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Peso (kg):"), gbc);
        pesoField = new JTextField();
        gbc.gridx = 1;
        add(pesoField, gbc);

        // Campo: Objetivo
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Objetivo:"), gbc);
        objetivoBox = new JComboBox<>(new String[] {
                "Hipertrofia", "Força", "Resistência", "Funcional", "Cardiovascular", "HIIT"
        });
        gbc.gridx = 1;
        add(objetivoBox, gbc);

        // Botão
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        salvarBtn = new JButton("Salvar");
        add(salvarBtn, gbc);

        salvarBtn.addActionListener(e -> {
            if (validar()) {
                // cria o objeto
                gerenciadordetreinos.model.Usuario u = new gerenciadordetreinos.model.Usuario(getNome(), getIdade(), getObjetivo(), getPeso());
                aoSalvar.accept(u);
            }
        });
    }

    // Este método será chamado para obter os dados preenchidos
    public String getNome() { return nomeField.getText().trim(); }
    public int getIdade()    { return Integer.parseInt(idadeField.getText().trim()); }
    public double getPeso()  { return Double.parseDouble(pesoField.getText().trim()); }
    public String getObjetivo() { return (String) objetivoBox.getSelectedItem(); }

    // Validação simples
    private boolean validar() {
        try {
            if (getNome().isEmpty()) throw new Exception("Nome inválido.");
            if (getIdade() <= 0) throw new Exception("Idade inválida.");
            if (getPeso() <= 0) throw new Exception("Peso inválido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}

