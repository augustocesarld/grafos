package visao;

import modelo.Grafo;

/**
 * @author Augusto
 */

public class TBM_Aresta extends javax.swing.table.AbstractTableModel{
    
    private final String [] colunas = {"Vértice Origem", "Vértice Destino", "Distância", "Dirigido"};
    private final Grafo g;
    
    public TBM_Aresta (Grafo g) {
        this.g = g;
    }
    
    @Override
    public int getRowCount() {
        return g.getArestas().size();
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
            case 0: return g.getArestas().get(row).getVertOrigem().getDescricao();
            case 1: return g.getArestas().get(row).getVertDestino().getDescricao();
            case 2: return g.getArestas().get(row).getDistancia();
            case 3: return g.getArestas().get(row).isDirigido()? "Sim" : "Não";
            default: return "-";
        }
    }
    @Override
    public void setValueAt(Object value, int row, int col) {
        try {
            if (col == 2) g.getArestas().get(row).setDistancia(Float.valueOf(String.valueOf(value)));
        } catch (Exception e) {
        }
        atualizar();
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
      return col == 2;
    }
    
    public void atualizar () {
        fireTableDataChanged();
    }
}