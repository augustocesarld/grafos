package modelo;

/**
 * @author Augusto
 */

public class Vertice {
    
    private String descricao;
    private int grau, grauEntrada, grauSaida;

    public Vertice(String descricao) {
        this.descricao = descricao;
        this.grau = 0;
        this.grauEntrada = 0;
        this.grauSaida = 0;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public int getGrauEntrada() {
        return grauEntrada;
    }

    public void setGrauEntrada(int grauEntrada) {
        this.grauEntrada = grauEntrada;
    }

    public int getGrauSaida() {
        return grauSaida;
    }

    public void setGrauSaida(int grauSaida) {
        this.grauSaida = grauSaida;
    }
    
    @Override
    public boolean equals (Object o) {
        try {
            Vertice v = (Vertice) o;
            return v.getDescricao().equals(this.getDescricao()) && v.getGrau() == this.getGrau();
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public String toString () {
        return descricao;
    }
}
