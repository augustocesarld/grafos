package modelo;

import java.util.ArrayList;

/**
 * @author Augusto
 */

public class Grafo {
    
    private final ArrayList<Vertice> VERTICES = new ArrayList<>();
    private final ArrayList<Aresta> ARESTAS = new ArrayList<>();
    
    public ArrayList<Vertice> getVertices () {
        return VERTICES;
    }
    
    public boolean adicionarVertice (Vertice v) {
        boolean res = VERTICES.contains(v);
        if (!res) VERTICES.add(v);
        return !res;
    }
    
    public boolean removerVertice (Vertice v) {
        boolean res = VERTICES.contains(v);
        if (res) {
            for (Aresta a: ARESTAS) if (a.isAdjacente(v)) removerAresta(a);
            VERTICES.remove(v);
        }
        return res;
    }
    
    public boolean possuiVertice (Vertice v) {
        for (Vertice v1 : VERTICES) if (v1.equals(v)) return true;
        return false;
    }
    
    public ArrayList<Aresta> getArestas () {
        return ARESTAS;
    }
    
    public boolean adicionarAresta (Aresta a) {
        boolean res = ARESTAS.contains(a);
        if (!res) ARESTAS.add(a);
        return !res;
    }
    
    public boolean removerAresta (Aresta a) {
        boolean res = ARESTAS.contains(a);
        if (res) ARESTAS.remove(a);
        return res;
    }
    
    public ArrayList<Vertice> getIncidentes (Vertice v) {
        ArrayList<Vertice> vertices = new ArrayList<>();
        for (Aresta a : ARESTAS) if ((a.isDirigido() && a.getVertOrigem().equals(v)) || (!a.isDirigido() && (a.getVertOrigem().equals(v) || a.getVertDestino().equals(v)))) vertices.add(a.getVertDestino().equals(v)? a.getVertOrigem() : a.getVertDestino());
        return vertices;
    }
    
    public float getDistanciaDireta (Vertice v1, Vertice v2) {
        float distancia = Float.POSITIVE_INFINITY;
        for (Aresta a: ARESTAS) if ((a.isDirigido() && a.getVertOrigem().equals(v1) && a.getVertDestino().equals(v2)) || (!a.isDirigido() && (v1.equals(a.getVertOrigem()) || v1.equals(a.getVertDestino())) && (v2.equals(a.getVertOrigem()) || v2.equals(a.getVertDestino())))) if (a.getDistancia() < distancia) distancia = a.getDistancia();
        return distancia;
    }
}
