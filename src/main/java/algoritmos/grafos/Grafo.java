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
            v1.agregarArista(v2);
        }
    }

    public void addArista(String vertice1, String vertice2, String nombre) {
        Vertice v1 = getVertice(vertice1);
        Vertice v2 = getVertice(vertice2);
        if (v1 != null && v2 != null) {
            v1.agregarArista(v2, nombre);
        }
    }
    public void imprimeVertices(){
    	int n = 1;
    	for (Vertice vertice : vertices) {
			System.out.println( "ver" + n + " " + vertice.getDato() );
			n++;
		}
    }    
}
