package algoritmos.grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EjemploRecorridoProfundidad2 {

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
	        Stack<Vertice> pila = new Stack<>();
	        List<Vertice> visitados = new ArrayList<>();
	               
	        pila.push(v);        
	        while ( pila.size() > 0 ) {
	            
	            Vertice visitando = pila.peek();            
	            if (!visitados.contains(visitando)) {
	                System.out.print(visitando.getDato());
	                System.out.print(" ");
	                visitados.add(visitando);
	            }            
	            Boolean hayCamino = false;                            
	            for( Vertice vi : visitando.getAdyacentes()) {
	                if ( !visitados.contains(vi)) {
	                    pila.push(vi);
	                    hayCamino = true;
	                    break;
	                }
	            }            
	            if (!hayCamino) {
	                pila.pop();
	            }                        
	        }                
	    
	    }    
	
//	    public static void recorrerBreathFirst(Vertice v) {
//	    
//	        Queue<Vertice> cola = new ArrayBlockingQueue<>(10);
//	        List<Vertice> visitados = new ArrayList<>();
//	        
//	        // inicia con v
//	        cola.add(v);
//	        
//	        // hay elementos a visitar ?
//	        while( cola.size() > 0) {
//	            Vertice visitando = cola.remove();
//	            visitados.add(visitando);
//	            
//	            System.out.print(visitando.getDato());
//	            System.out.print(" ");
//	            
//	            for ( Vertice vi : visitando.getAdyacentes()) {
//	                if (!visitados.contains(vi)) {
//	                    if (!cola.contains(vi)) {
//	                        cola.add(vi);                
//	                    }
//	                }
//	            }            
//	        }        
//	    }


}
