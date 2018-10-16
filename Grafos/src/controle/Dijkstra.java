package controle;

import java.util.ArrayList;
import modelo.Grafo;
import modelo.Rota;
import modelo.Vertice;

/**
 * @author Augusto
 */

public abstract class Dijkstra {

    public static Rota getRotaMenorDistancia (Grafo g, Vertice vInicial, Vertice vFinal) {
        //Criação do objeto Rota
        Rota r = new Rota(g);

        //Descartar casos irrelevantes
        if (vInicial.equals(vFinal)) return r;
        if (!g.possuiVertice(vInicial) || !g.possuiVertice(vFinal)) return r;

        //Setar inicialmente a distância do vértice inicial aos outros como Infinito, exceto ele mesmo
        for (int i = 0; i < g.getVertices().size(); i++) {
            g.getVertices().get(i).setDistanciaAcumulada(Float.POSITIVE_INFINITY);
            g.getVertices().get(i).setAberto(true);
        }
        vInicial.setDistanciaAcumulada(0.0f);
         
        //Verificar a partir dos vértices abertos com menor distância agregada
        while (hasNext(g)) {
            Vertice vAtual = getVerticeMenorDistancia(g);
            vAtual.setAberto(false);
            ArrayList<Vertice> vs = g.getIncidentes(vAtual);
            for (Vertice v: vs) {
                float dist = vAtual.getDistanciaAcumulada() + g.getDistanciaDireta(vAtual, v);
                if (dist < v.getDistanciaAcumulada()) {
                    v.setDistanciaAcumulada(dist);
                    v.setVertAnterior(vAtual);
                }
            }
        }
        
        //Montar a rota
        if (vFinal.getDistanciaAcumulada() != Float.POSITIVE_INFINITY) {
            Vertice v = vFinal;
            r.adicionarVertice(v);
            while (v.getVertAnterior() != null) {
                r.adicionarVertice(v.getVertAnterior());
                v = v.getVertAnterior();
            }
        }
        
        return r;
    }
    
    private static boolean hasNext (Grafo g) {
        for (Vertice v : g.getVertices()) if (v.isAberto()) return true;
        return false;
    }
    
    private static Vertice getVerticeMenorDistancia (Grafo g) {
        Vertice vMenor = null;
        for (Vertice vAtual : g.getVertices()) {
            if (vAtual.isAberto()) {
                if (vMenor == null) vMenor = vAtual;
                else if (vAtual.getDistanciaAcumulada() < vMenor.getDistanciaAcumulada()) vMenor = vAtual;
            }
        }
        return vMenor;
    }
}