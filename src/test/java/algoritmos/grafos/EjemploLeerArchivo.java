package algoritmos.grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class EjemploLeerArchivo {

	public static void main(String[] args) {
		try {

			Grafo grafo = new GrafoNoDirigido();

			FileReader fr = new FileReader("src/test/java/algoritmos/grafos/movies.txt");
			BufferedReader br = new BufferedReader(fr);
			int u = 0;
			String linea = null;
			while ((linea = br.readLine())!= null) {	                
				
				String[] partes = linea.split("/");
				//System.out.println("pelicula "+ (i + 1) +"= "+partes[0]);
				for (int j = 1; j < partes.length; j++) {
					//System.out.println("actor " + j + "= "+partes[j]);
					if (grafo.getVertice(partes[j])==null) {
						grafo.addVertice(partes[j]);							
					}	else {
						//System.out.println(partes[j]);
					}
				}
				for (int j = 1; j < partes.length - 1 ; j++) {

					for (int j2 = j + 1; j2 < partes.length; j2++) {
						//System.out.println(partes[j] + partes[j2] + partes[0]);
						grafo.addArista(partes[j], partes[j2], partes[0]);
						u++;

					}
				}


				
			}
			br.close(); 
			//grafo.imprimeVertices();
			//recorrerAnchura(grafo,"nodo8");
			System.out.println(numeroBacon(grafo.getVertice("Guzmán, Luis (I)"), grafo.getVertice("Calfa, Don")));
			System.out.println(numeroBacon(grafo.getVertice("Rain, Douglas"), grafo.getVertice("Cage, Nicolas")));
			System.out.println(numeroBacon(grafo.getVertice("Levin, Darlene"), grafo.getVertice("McNab, Mercedes")));
		} catch (Exception e) {
			System.out.println("error aqui");
			e.printStackTrace();
		}

	}
	public static void recorrerAnchura(Grafo grafo, String dato) {
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

	public static int numeroBacon(Vertice v, Vertice Busc) {

		Queue<Vertice> cola = new ArrayBlockingQueue<>(50000000);
		List<Vertice> visitados = new ArrayList<>();
		List<String> pelis = new ArrayList<>();

		// inicia con v
		cola.add(v);
		int n = 0;
		// hay elementos a visitar ?
		Vertice ant = null;
		while (cola.size() > 0) {


			Vertice visitando = cola.remove();
			if (ant != null) {

				if (ant.caminoPara(visitando)!=null) {
					if (!pelis.contains(ant.caminoPara(visitando))) {
						pelis.add(ant.caminoPara(visitando));
					}

				}

			}
			visitados.add(visitando);
			n++;



			for (Vertice vi : visitando.getAdyacentes()) {            	
				if (vi.getDato().equals(Busc.getDato())) {
					cola.clear();    				
					pelis.add(visitando.caminoPara(vi));
					break;
				}else{
					if (!visitados.contains(vi)) {
						if (!cola.contains(vi)) {                        	
							cola.add(vi);
						}
					}
				}

			}            
			ant = visitando;
		}		
		return pelis.size();
	}

}
