package visao;

import modelo.Grafo;

/**
 * @author Augusto
 */

public class TBM_Vertice extends javax.swing.table.AbstractTableModel{
    
    private final String [] colunas = {"Descrição", "Grau", "Grau Entrada", "Grau Saída"};
    private final Grafo g;
    
    public TBM_Vertice (Grafo g) {
        this.g = g;
    }
    
    @Override
    public int getRowCount() {
        return g.getVertices().size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int index) {
        return colunas[index];
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0: return g.getVertices().get(row).getDescricao();
            case 1: return g.getVertices().get(row).getGrau();
            case 2: return g.getVertices().get(row).getGrauEntrada();
            case 3: return g.getVertices().get(row).getGrauSaida();
            default: return "-";
        }
    }
    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 0) g.getVertices().get(row).setDescricao(String.valueOf(value));
        atualizar();
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
      return col == 0;
    }
    
    public void atualizar () {
        fireTableDataChanged();
    }
}