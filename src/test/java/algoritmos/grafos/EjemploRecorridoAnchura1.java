package algoritmos.grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class EjemploRecorridoAnchura1 {

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

        recorrerAnchura(grafo, "A");
        System.out.println("e");

    }

    public static void recorrerAnchura(Grafo grafo, String dato) {
        recorrerAnchura(grafo.getVertice(dato));
    }

    public static void recorrerAnchura(Vertice v) {

        Queue<Vertice> cola = new ArrayBlockingQueue<>(10);
        List<Vertice> visitados = new ArrayList<>();

        // inicia con v
        cola.add(v);

        // hay elementos a visitar ?
        while (cola.size() > 0) {
            Vertice visitando = cola.remove();
            visitados.add(visitando);

            System.out.print(visitando.getDato());
            System.out.print(" ");

            for (Vertice vi : visitando.getAdyacentes()) {
                if (!visitados.contains(vi)) {
                    if (!cola.contains(vi)) {
                        cola.add(vi);
                    }
                }
            }
        }
    }

}
