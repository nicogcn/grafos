package algoritmos.grafos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Vértice de un Grafo
 */
public class Vertice {

    String dato;
    
    List<Vertice> adyacentes = new ArrayList<>();

    Map<Vertice, String> mapaAdyacentes = new HashMap<>();
    
    public Vertice() {
    }

    public Vertice(String dato) {
        this.dato = dato;
    }

    public String getDato() {
        return dato;
    }

    //---

    public void agregarArista(Vertice vertice) {
        String nombre = UUID.randomUUID().toString();
        mapaAdyacentes.put(vertice, nombre);
    }
    
    public void agregarArista(Vertice vertice, String nombre) {
        mapaAdyacentes.put(vertice, nombre);
    }
        
    public Collection<Vertice> getAdyacentes() {
        return mapaAdyacentes.keySet();
    }
    
    public String caminoPara(Vertice v) {
        return mapaAdyacentes.get(v);
    }
    @Override
    public boolean equals(Object o) {
		if (o instanceof Vertice && ((Vertice) o).getDato().equals(this.dato)) {
			return true;
		}else {
			return false;
		}
	}
    @Override
    public String toString() {
        return "{" + dato + "}";
    }
    
}
