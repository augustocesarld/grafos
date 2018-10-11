package controle;

import java.util.ArrayList;
import modelo.Aresta;
import modelo.Grafo;
import modelo.Vertice;

/**
 * @author Augusto
 */

public abstract class Dijkstra {

    public static float getMenorDistancia (Grafo g, Vertice vInicial, Vertice vFinal) {
        //Descartar casos irrelevantes
        if (vInicial.equals(vFinal)) return 0.0f;
        if (!g.possuiVertice(vInicial) || !g.possuiVertice(vFinal)) return -1.0f;

        //Armazenar distância de cada vértice ao inicial
        float [] distancia = new float[g.getVertices().size()];
        boolean [] status = new boolean[g.getVertices().size()];
        
        //Setar inicialmente a distância do vértice inicial aos outros como Infinito, exceto ele mesmo
        for (int i = 0; i < distancia.length; i++) {
            distancia[i] = Float.POSITIVE_INFINITY;
            status[i] = true;
        }
        int indexInicial = getIndex(g, vInicial);
        distancia[indexInicial] = 0;
        int indexFinal = getIndex(g, vFinal);
         
        //Verificar a partir dos vértices abertos com menor distância agregada
        while (hasNext(status)) {
            int atual = getIndexMenorDistancia(status, distancia);
            status[atual] = false;
            ArrayList<Vertice> vs = g.getIncidentes(g.getVertices().get(atual));
            for (Vertice v: vs) {
                float dist = distancia[atual] + g.getDistanciaDireta(g.getVertices().get(atual), v);
                if (dist < distancia[getIndex(g, v)]) distancia[getIndex(g,v)] = dist;
            }
        }
        
        return distancia[indexFinal];
    }
    
    private static boolean hasNext (boolean [] status) {
        for (int i = 0; i < status.length; i++) if (status[i]) return true;
        return false;
    }
    
    private static int getIndex (Grafo g, Vertice v) {
        for (int i = 0; i < g.getVertices().size(); i++) if (g.getVertices().get(i).equals(v)) return i;
        return -1;
    }
    
    private static int getIndexMenorDistancia (boolean [] status, float [] distancia) {
        int indexMenor = -1;
        for (int i = 0; i < status.length; i++) {
            if (status[i]) {
                if (indexMenor == -1) indexMenor = i;
                else if (distancia[i] < distancia[indexMenor]) indexMenor = i;
            }
        }
        return indexMenor;
    }
}