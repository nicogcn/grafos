package algoritmos.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejemplo de Grafos
 */
public class EjemploGrafoConNombre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Grafo grafo = new GrafoNoDirigido();

        grafo.addVertice("Ibo");
        grafo.addVertice("Jaime");
        grafo.addVertice("Oscar");
        grafo.addVertice("Obama");

        grafo.addArista("Ibo", "Jaime", "UPC");
        grafo.addArista("Ibo", "Oscar", "UPC");
        grafo.addArista("Jaime", "Oscar", "UPC");

        grafo.addArista("Jaime", "Obama", "XXX");               
        
        System.out.println( grafo.getVertice("Jaime").getAdyacentes());
     
        List<Vertice> camino = new ArrayList<>();
        camino.add(grafo.getVertice("Ibo"));
        camino.add(grafo.getVertice("Jaime"));
        camino.add(grafo.getVertice("Obama"));
        
        Vertice anterior = null;
        for (Vertice v : camino ) {
            if (anterior != null) {
                System.out.println("\t" + anterior.caminoPara(v));
            }
            System.out.println(v.getDato());
            anterior = v;
        }
        
    }

}
