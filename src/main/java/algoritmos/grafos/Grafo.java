package algoritmos.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 * Grafo
 */
public class Grafo {
    
    List<Vertice> vertices = new ArrayList<>();

    public Grafo() {
    }
        
    public Vertice addVertice(String dato){
        Vertice vertice = new Vertice(dato);
        vertices.add(vertice);
        return vertice;
    }
    
    public Vertice getVertice(String dato) {
        for(Vertice v : vertices) {
            if (v.getDato().equals(dato)){
                return v;
            }
        }
        return null;
    }
    
    public void addArista(String vertice1, String vertice2) {
        Vertice v1 = getVertice(vertice1);
        Vertice v2 = getVertice(vertice2);
        if (v1 != null && v2 != null) {
            v1.getAdyacentes().add(v2);
        }
    }
}
