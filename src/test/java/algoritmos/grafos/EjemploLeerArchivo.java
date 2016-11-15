package algoritmos.grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class EjemploLeerArchivo {

	public static void main(String[] args) {
		 try {
	            
	            Grafo grafo = new GrafoNoDirigido();
	            
	            FileReader fr = new FileReader("src/test/java/algoritmos/grafos/movies.txt");
	            BufferedReader br = new BufferedReader(fr);
	            
	            
	            for (int i = 0; i < 2; i++) {	                
	                String linea = br.readLine();
	                String[] partes = linea.split("/");
	                System.out.println("pelicula "+ (i + 1) +"= "+partes[0]);
	                for (int j = 1; j < partes.length; j++) {
	                	//System.out.println("actor " + j + "= "+partes[j]);
	                	if (grafo.getVertice(partes[j])==null) {
							grafo.addVertice(partes[j]);							
						} else {

						}
					}	        
	                
	                
	                /*for (int j = 1; j < partes.length; j++) {                    
	                    
	                    if (grafo.getVertice(partes[j])== null) { grafo.addVertice(partes[j]); }
	                   
	                    for (int k = j; k < partes.length; k++) {
	                        if (grafo.getVertice(partes[k])== null) { grafo.addVertice(partes[k]); }
	                        grafo.addArista(partes[j], partes[k], partes[0]);
	                    }
	                }*/
	                               
	            }
	            br.close(); 
	            grafo.imprimeVertices();
	           
	        } catch (Exception e) {
	            System.out.println("error");
	        }

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
