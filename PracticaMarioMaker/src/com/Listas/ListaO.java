package com.Listas;

import com.Nodos.*;

public class ListaO {

	public NodoO primero;
	public NodoO ultimo;
	public NodoO arriba;
	public NodoO abajo;
	public NodoO raiz;

	public ListaO() {
		this.primero = null;
		this.ultimo = null;
		this.arriba = null;
		this.abajo = null;

		this.raiz = new NodoO();
	}

	public boolean esVacioFila() {
		return this.raiz.getAbajo() == null ? true : false;
	}

	public boolean esVacioColumna() {
		return this.raiz.getSiguiente() == null ? true : false;
	}

	public String verVacioFila() {
		return esVacioFila() ? "Esta vacio fila" : "No esta vacio fila";
	}

	public String verVacioColumna() {
		return esVacioColumna() ? "Esta vacio columna"
				: "No esta vacio columna";
	}

	public void agregarFilaI(Object dato) {

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

		} catch (Exception e) {
			System.out
					.println("Ha ocurrido un error al momento de ingresar el elemento a la fila ERROR: "
							+ e);
		}
	}

	public void agregarColumnaI(Object dato) {

		NodoO nodo = new NodoO("*" + dato + "*");

		try {
			if (esVacioColumna()) {
				raiz.setSiguiente(nodo);
				primero = nodo;
				ultimo = nodo;
			} else {
				ultimo.setSiguiente(nodo);
				ultimo = nodo;
			}

		} catch (Exception e) {
			System.out
					.println("Ha ocurrido un error al momento de ingresar el elemento a la columna ERROR: "
							+ e);
		}
	}

	public int getNumFilas() {

		NodoO temporal;
		int contador = 0;

		temporal = raiz;
		while (temporal != null) {
			temporal = temporal.getAbajo();
			contador++;
		}

		return contador;
	}

	public int getNumColumnas() {

		NodoO temporal = new NodoO();
		int contador = 0;

		temporal = raiz;
		while (temporal != null) {
			temporal = temporal.getSiguiente();
			contador++;
		}
		return contador;
	}

	public NodoO getNodoFila(int indice) {
		NodoO temporal = new NodoO();

		if (!esVacioFila()) {
			temporal = raiz;
			for (int i = 1; i <= indice; i++) {
				temporal = temporal.getAbajo();
			}
			return temporal;
		} else {
			return null;
		}
	}

	public NodoO getNodoColumna(int indice) {
		try {
			NodoO temporal;
			if (!esVacioColumna()) {
				temporal = this.raiz;
				for (int i = 1; i <= indice; i++) {
					temporal = temporal.getSiguiente();
				}
				return temporal;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error en metodo getNodoColumna" + e);
			return null;
		}
	}

	public NodoO buscarNodo(int fila, int columna) {
		
		try {
			if (!esVacioColumna() && !esVacioFila()) {				
				NodoO temporal = this.getNodoFila(fila);	
				int contador=0;
				
				while(contador!=columna){
					temporal = temporal.getSiguiente();	
					contador++;
				}
				return temporal;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	public void insertarDato(Object dato, int fila, int columna) {
		NodoO nodo = new NodoO();
		nodo = this.buscarNodo(fila, columna);
		nodo.setDato(dato);
	}

	public void llenarMatriz() {

		try {
			if (!esVacioFila() || !esVacioColumna()) {

				for (int i = 1; i < getNumFilas(); i++) {
					
					NodoO nodoF = this.getNodoFila(i);
					NodoO temporal = nodoF;

					for (int j = 1; j < getNumColumnas(); j++) {
						
						NodoO nodoC = this.getNodoColumna(j);

						NodoO nuevo = new NodoO(i+"_" + j);

						nuevo.setArriba(nodoC);						
						nodoC.setAbajo(nuevo);

						nuevo.setAnterior(temporal);
						temporal.setSiguiente(nuevo);
						
						temporal = nuevo;
					}
				}
			} else {
				System.out.println("No se encuentra fila o columna a llenar");
			}
		} catch (Exception e) {
			System.out.println("Hubo error al llenar matriz " + e);
		}
	}
	
	public void dibujarMatriz(){
		
		NodoO temporalc = raiz.getSiguiente();
		NodoO temporalf = raiz.getAbajo();
	
		int contadorf = 1;
		int contadorc = 1;
		System.out.print("| i |");
		
		
		while(temporalc != null){
			System.out.print( temporalc.getDato() + " |");
			temporalc = temporalc.getSiguiente();
			contadorc++;
		}
		
		System.out.println();
		
		while(temporalf != null){
			System.out.println( "| " + temporalf.getDato() + " |");
			temporalf = temporalf.getAbajo();
			contadorf++;
		}

		
		for (int i = 1; i<contadorf; i++){
			for (int j = 1; j<contadorc; j++){
				System.out.print("| " + this.buscarNodo(i, j).getDato() + " ");
				System.out.print("fila " + i + " columna " + j);	
			}
			System.out.println();
		}
		
	}
	
	//crea una matriz de 2x4
	public void iniciarMatriz(){
		
		for (int i = 1; i<=2; i++){
			this.agregarFilaI(i);
		}
		
		for (int i = 1; i<=4; i++){
			this.agregarColumnaI(i);
		}
		
		this.llenarMatriz();
	}

	public void agregarFila(){
		
		int limite = getNumFilas();			
		this.agregarFilaI(limite);

		NodoO nodo = this.getNodoFila(limite);
		
		for (int j = 1; j < getNumColumnas(); j++) {
			
			NodoO nodoC = this.getNodoColumna(j);

			NodoO nuevo = new NodoO(limite+"_" + j);

			nuevo.setArriba(nodoC);						
			nodoC.setAbajo(nuevo);

			nuevo.setAnterior(nodo);
			nodo.setSiguiente(nuevo);
			
			nodo = nuevo;
		}
		
		this.dibujarMatriz();
	}
	
	public void agregarColumna(){

		int limite = getNumColumnas();
		this.agregarColumnaI(limite);
	
		NodoO nodo = this.getNodoColumna(limite);
		

		for (int i = 1; i < getNumFilas(); i++) {
			
			NodoO nodoF = this.buscarNodo(i, limite-1);
			
			NodoO nuevo = new NodoO(i+"_" + limite);

				nuevo.setArriba(nodo);						
				nodo.setAbajo(nuevo);

				nuevo.setAnterior(nodoF);
				nodoF.setSiguiente(nuevo);
			
		}
		
		this.dibujarMatriz();
		
		
	}

}
