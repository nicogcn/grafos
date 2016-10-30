package algoritmos.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 * Vértice de un Grafo
 */
public class Vertice {

    String dato;
    
    List<Vertice> aristas = new ArrayList<>();

    public Vertice() {
    }

    public Vertice(String dato) {
        this.dato = dato;
    }

    public String getDato() {
        return dato;
    }

    
    
    public List<Vertice> getAristas() {
        return aristas;
    }

    public void setAristas(List<Vertice> aristas) {
        this.aristas = aristas;
    }
    
}
