package algoritmos.grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class GrafoKB extends GrafoNoDirigido{
	
	public GrafoKB(){
		grafoCrear();
	}

	public void grafoCrear(){
		try {            
			FileReader fr = new FileReader("src/test/java/algoritmos/grafos/pr.txt");
			BufferedReader br = new BufferedReader(fr);
			int u = 0;

			for (int i = 0; i < 3; i++) {	                
				String linea = br.readLine();
				String[] partes = linea.split("/");
				System.out.println("pelicula "+ (i + 1) +"= "+partes[0]);
				for (int j = 1; j < partes.length; j++) {
					System.out.println("actor " + j + "= "+partes[j]);
					if (getVertice(partes[j])==null) {
						addVertice(partes[j]);							
					}	                	
				}
				for (int j = 1; j < partes.length - 1 ; j++) {

					for (int j2 = j + 1; j2 < partes.length; j2++) {
						System.out.println(partes[j] + partes[j2] + partes[0]);
						addArista(partes[j], partes[j2], partes[0]);
						u++;

					}
				}                               
			}
			br.close(); 
			imprimeVertices();
			

		} catch (Exception e) {
			System.out.println("error aqui");
			e.printStackTrace();
		}

	}
	
	public void recorrerAnchura(Grafo grafo, String dato) {
        recorrerAnchura(grafo.getVertice(dato));
    }

    public static void recorrerAnchura(Vertice v) {

        Queue<Vertice> cola = new ArrayBlockingQueue<>(50000000);
        List<Vertice> visitados = new ArrayList<>();

        // inicia con v
        cola.add(v);
        int n = 0;
        // hay elementos a visitar ?
        while (cola.size() > 0) {
            Vertice visitando = cola.remove();
            visitados.add(visitando);
            n++;
            System.out.print(visitando.getDato() + " ........." + n + "\n");
            //System.out.print(" ");

            for (Vertice vi : visitando.getAdyacentes()) {
            	System.out.println(vi.getDato());
                if (!visitados.contains(vi)) {
                    if (!cola.contains(vi)) {
                    	System.out.println("cola " + vi.getDato());
                        cola.add(vi);
                    }
                }
            }
        }
    }

}
