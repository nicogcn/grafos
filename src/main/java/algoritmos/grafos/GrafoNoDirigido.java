/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.grafos;

/**
 *
 * @author SG702-21
 */
public class GrafoNoDirigido extends Grafo {
    
    public void addArista(String vertice1, String vertice2) {
        Vertice v1 = getVertice(vertice1);
        Vertice v2 = getVertice(vertice2);
        if (v1 != null && v2 != null) {
            v1.agregarArista(v2);
            v2.agregarArista(v1);
        }
    }
    
    public void addArista(String vertice1, String vertice2, String nombre) {
        Vertice v1 = getVertice(vertice1);
        Vertice v2 = getVertice(vertice2);
        if (v1 != null && v2 != null) {
            v1.agregarArista(v2, nombre);
            v2.agregarArista(v1, nombre);            
        }
    }    
}
