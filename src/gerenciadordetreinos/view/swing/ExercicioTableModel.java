package gerenciadordetreinos.view.swing;

import gerenciadordetreinos.model.Exercicio;

import javax.swing.table.AbstractTableModel;
import java.util.List;

class ExercicioTableModel extends AbstractTableModel {

    private static final String[] COLS = {
            "Nome", "Grupo", "Séries", "Reps", "Carga (kg)"
    };

    private List<Exercicio> dados;

    ExercicioTableModel(List<Exercicio> lista) {
        this.dados = lista;
    }

    /* ---------- API util ---------- */
    void setExercicios(List<Exercicio> lista) {
        this.dados = lista;
        fireTableDataChanged();
    }

    Exercicio get(int row)          { return dados.get(row); }
    void add(Exercicio e)           { dados.add(e); fireTableDataChanged(); }
    void set(int row, Exercicio e)  { dados.set(row, e); fireTableRowsUpdated(row, row); }
    void remove(int row)            { dados.remove(row); fireTableRowsDeleted(row, row); }

    /* ---------- AbstractTableModel ---------- */
    @Override public int getRowCount()                 { return dados.size(); }
    @Override public int getColumnCount()              { return COLS.length; }
    @Override public String getColumnName(int col)     { return COLS[col]; }

    @Override
    public Object getValueAt(int row, int col) {
        Exercicio ex = dados.get(row);
        return switch (col) {
            case 0 -> ex.getNome();
            case 1 -> ex.getGrupoMuscular();
            case 2 -> ex.getSeries();
            case 3 -> ex.getRepeticoes();
            case 4 -> ex.getCarga();
            default -> "";
        };
    }

    @Override public Class<?> getColumnClass(int col) {
        return switch (col) {
            case 2, 3          -> Integer.class;
            case 4             -> Double.class;
            default            -> String.class;
        };
    }

    @Override public boolean isCellEditable(int r, int c) { return false; }
}
