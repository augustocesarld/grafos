package modelo;

import java.util.ArrayList;

/**
 * @author Augusto
 */

public class Rota {
    
    private final ArrayList<Vertice> rota = new ArrayList<>();
    private Grafo g;
    
    public Rota (Grafo g) {
        this.g = g;
    }
    
    public void adicionarVertice (Vertice v) {
        rota.add(0, v);
    }
    
    public boolean removerVertice (Vertice v) {
        return rota.remove(rota);
    }
    
    public float getDistancia () {
        if (rota.size() == 1) return Float.POSITIVE_INFINITY;
        else if (rota.size() <= 0) return 0.0f;
        return rota.get(rota.size()-1).getDistanciaAcumulada();
    }
    
    @Override
    public String toString () {
        if (rota.size() < 1) return "Sem Rota";
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < rota.size(); i++) {
            sb.append(rota.get(i).getDescricao());
            if (i < rota.size() - 1) sb.append(" -> ");
        }
        return sb.toString();
    }
}
