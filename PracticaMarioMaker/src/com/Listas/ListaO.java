package com.Listas;
import com.Nodos.*;

public class ListaO {
	
	public NodoO primero;
	public NodoO ultimo; 
	public NodoO arriba;
	public NodoO abajo;
	public NodoO raiz;
	
	public ListaO(){
		this.primero = null;
		this.ultimo = null;
		this.arriba = null;
		this.abajo = null;
		
		this.raiz = new NodoO();
	}
	
	public boolean esVacioFila(){
		return this.raiz.getAbajo() == null ? true : false ; 
	}
	
	public boolean esVacioColumna(){
		return this.raiz.getSiguiente() == null ? true : false ; 
	}
	
	public String verVacioFila(){
		return esVacioFila() ? "Esta vacio fila" : "No esta vacio fila";
	}

	public String verVacioColumna(){
		return esVacioColumna() ? "Esta vacio columna" : "No esta vacio columna";
	}
	
	public void agregarFila(Object dato){
		
		NodoO nodo = new NodoO(dato);
		
		try {
			if (esVacioFila()) {
				raiz.setAbajo(nodo);
				arriba = nodo;
				abajo = nodo;
			} else {
				abajo.setAbajo(nodo);
				abajo = nodo;
			}

			System.out.println("Se agrego un elemento a la fila '" + dato + "' a la lista");
			

		} catch (Exception e) {
			System.out.println("Ha ocurrido un error al momento de ingresar el elemento a la fila ERROR: " + e);
		}
	}

	
	public void agregarColumna(Object dato){
		
		NodoO nodo = new NodoO(dato);
		
		try {
			if (esVacioColumna()) {
				raiz.setSiguiente(nodo);
				primero = nodo;
				ultimo = nodo;
			} else {
				ultimo.setSiguiente(nodo);
				ultimo= nodo;
			}

			System.out.println("Se agrego un elemento a la columna: '" + dato + "' a la lista");
			

		} catch (Exception e) {
			System.out.println("Ha ocurrido un error al momento de ingresar el elemento a la columna ERROR: " + e);
		}
	}
	
	public int getNumFilas(){
		
		NodoO temporal;
		int contador = 0;

		
		temporal = raiz.getAbajo();
		while (temporal!=null){
			temporal = temporal.getAbajo();
			contador++;
		}
		
		return contador;
	}
	
	public int getNumColumnas(){
		
		NodoO temporal = new NodoO();
		int contador = 0;
		
		temporal = raiz.getSiguiente();
		while (temporal!=null){
			temporal = temporal.getSiguiente();
			contador++;
		}
		return contador;
	}
	
	public NodoO getNodoFila(int indice){
		NodoO temporal;

		if (!esVacioFila()) {
			temporal = raiz;
			for (int i = 1; i <=indice; i++) {
				temporal = temporal.getAbajo();
			}
			return temporal;
		} else {
			return null;
		}
	}
	
	public NodoO getNodoColumna(int indice){
		NodoO temporal;

		if (!esVacioColumna()) {
			temporal = raiz;
			for (int i = 1; i <=indice; i++) {
				temporal = temporal.getSiguiente();
			}
			return temporal;
		} else {
			return null;
		}
	}
	
	public void llenarMatriz(){
	
		for(int i = 1; i <=getNumFilas() ; i++){
			NodoO nodoF = new NodoO();
			for (int j = 1; j <= getNumColumnas(); j++){
				NodoO nodoC = new NodoO();
				
			}
		}
	}
	
	//matriz de 2x4
	
	
}
