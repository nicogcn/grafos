package algoritmos.grafos;

import java.util.ArrayList;
import java.util.List;

public class EjemploRecorridoProfundidad1 {

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        grafo.addVertice("A");
        grafo.addVertice("B");
        grafo.addVertice("C");
        grafo.addVertice("D");
        grafo.addVertice("E");
        grafo.addVertice("F");
        grafo.addVertice("G");

        grafo.addArista("A", "C");
        grafo.addArista("A", "B");
        grafo.addArista("A", "F");
        grafo.addArista("B", "D");
        grafo.addArista("C", "D");
        grafo.addArista("D", "E");
        grafo.addArista("E", "C");
        grafo.addArista("F", "G");

        recorrerProfundidad(grafo, "A");
        System.out.println("");

    }

    public static void recorrerProfundidad(Grafo grafo, String dato) {
        recorrerProfundidad(grafo.getVertice(dato));
    }

    public static void recorrerProfundidad(Vertice v) {
        List<Vertice> visitados = new ArrayList<Vertice>();
        recorrerProfundidad(v, visitados);
    }

    private static void recorrerProfundidad(Vertice v, List<Vertice> visitados) {
        if (v != null && visitados.contains(v) == false) {

            visitados.add(v);

            System.out.print(v.getDato());
            System.out.print(" ");

            for (Vertice adyacente : v.getAdyacentes()) {
                recorrerProfundidad(adyacente, visitados);
            }
        }
    }

}
