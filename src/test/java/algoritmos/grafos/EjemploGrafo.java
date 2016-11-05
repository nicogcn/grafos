package algoritmos.grafos;

/**
 * Ejemplo de Grafos
 */
public class EjemploGrafo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        grafo.addVertice("A");
        grafo.addVertice("B");

        grafo.addArista("A", "B");

    }

}
