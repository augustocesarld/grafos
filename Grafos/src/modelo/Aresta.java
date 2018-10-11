package modelo;

/**
 * @author Augusto
 */
    
public class Aresta {
    
    private Vertice vOrigem, vDestino;
    private float distancia;
    private boolean dirigido;

    public Aresta(Vertice vOrigem, Vertice vDestino, float distancia, boolean dirigido) {
        this.vOrigem = vOrigem;
        this.vDestino = vDestino;
        this.distancia = distancia;
        this.dirigido = dirigido;
        aumentarGrau();
    }
    
    private void aumentarGrau () {
        vOrigem.setGrau(vOrigem.getGrau() + 1);
        vOrigem.setGrauSaida(vOrigem.getGrauSaida() + 1);
        vDestino.setGrau(vDestino.getGrau() + 1);
        vDestino.setGrauEntrada(vDestino.getGrauEntrada() + 1);
        if (!dirigido) {
            vDestino.setGrauSaida(vDestino.getGrauSaida() + 1);
            vOrigem.setGrauEntrada(vOrigem.getGrauEntrada() + 1);
        }
    }
    
    public boolean isAdjacente (Vertice v) {
        return vOrigem.equals(v) || vDestino.equals(v);
    }

    public Vertice getVertOrigem() {
        return vOrigem;
    }

    public void setVertOrigem(Vertice vOrigem) {
        this.vOrigem = vOrigem;
    }

    public Vertice getVertDestino() {
        return vDestino;
    }

    public void setVertDestino(Vertice vDestino) {
        this.vDestino = vDestino;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public boolean isDirigido() {
        return dirigido;
    }

    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }

    @Override
    public boolean equals (Object o) {
        try {
            Aresta a = (Aresta) o;
            return a.getVertDestino() == this.getVertDestino() && a.getVertOrigem() == this.getVertOrigem() && a.isDirigido() == this.isDirigido() && a.getDistancia() == this.getDistancia();
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public String toString () {
        return "(" + vOrigem + ") " + (dirigido?"->":"<->") + " (" + vDestino +  ") Distância: " + distancia;
    }
    
}
