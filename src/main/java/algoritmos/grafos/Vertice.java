package algoritmos.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 * Vértice de un Grafo
 */
public class Vertice {

    String dato;
    
    List<Vertice> adyacentes = new ArrayList<>();

    public Vertice() {
    }

    public Vertice(String dato) {
        this.dato = dato;
    }

    public String getDato() {
        return dato;
    }

    
    
    public List<Vertice> getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(List<Vertice> aristas) {
        this.adyacentes = aristas;
    }
    
}
