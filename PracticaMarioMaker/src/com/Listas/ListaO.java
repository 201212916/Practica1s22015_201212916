package com.Listas;
import com.Main.*;
import com.Nodos.*;

public class ListaO {

	public NodoO primero;
	public NodoO ultimo;
	public NodoO arriba;
	public NodoO abajo;
	public NodoO raiz;
	
	private static int dibFila=2, dibColumna=4, limitefila=150, limiteColumna=50;
	

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
		return esVacioColumna() ? "Esta vacio columna" : "No esta vacio columna";
	}

	public void agregarFilaI(Object dato) {

		NodoO nodo = new NodoO(dato);

		try {
			if (esVacioFila()) {
				raiz.setAbajo(nodo);
				arriba = nodo;
				abajo = nodo;
			} else {
				NodoO temporal = abajo;
				
				temporal.setAbajo(nodo);
				abajo = nodo;
				abajo.setArriba(temporal);
				
			}

		} catch (Exception e) {
			System.out.println("Error en metodo agregarFilaI() " + e);
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
				NodoO temporal = ultimo;

				temporal.setSiguiente(nodo);
				ultimo = nodo;
				ultimo.setAnterior(temporal);
				
			}

		} catch (Exception e) {
			System.out.println("Error en metodo agregarColumnaI() "+ e);
		}
	}

	public int getNumFilas() {
		int contador = 0;
		try{
			NodoO temporal;
			temporal = raiz;
			while (temporal != null) {
				temporal = temporal.getAbajo();
				contador++;
			}
			return contador;	
		}catch(Exception e){
			System.out.println("Error en getNumFilas(), no se pudo obtener el numero de filas " + e);
			return contador;
		}
		
	}

	public int getNumColumnas() {
		int contador = 0;
		
		try{
			NodoO temporal = new NodoO();
			temporal = raiz;
			while (temporal != null) {
				temporal = temporal.getSiguiente();
				contador++;
			}
			return contador;	
		}catch(Exception e){
			System.out.println("Error en getNumColumnas(), no se pudo obtener el numero de columnas " + e);
			return contador;
		}
		
	}

	public void eliminarFila(){
		
		try{
			int fila = this.getNumFilas() - 1;				
			
			
			for (int i = getNumColumnas()-1; i >= 0; i--) {
				
				NodoO fin = this.buscarNodo(fila , i);
				NodoO temporal = fin.getArriba();	

				temporal.setAbajo(null);
				fin = null;
			}
			
			this.dibujarMatriz();
			
		}catch(Exception e){
			System.out.println("Error en metodo eliminarFila() " + e);
		}
		
	}
	
	public void eliminarColumna(){
		
		try{
			
			int columna = this.getNumColumnas() - 1;				
			for (int i = getNumFilas()-1; i >= 0; i--) {
				

				NodoO fin = this.buscarNodo(i, columna);
				NodoO temporal = fin.getAnterior();	
				temporal.setSiguiente(null);
				fin = null;

			}	
			
				
			this.dibujarMatriz();
			
		}catch(Exception e){
			System.out.println("Error en metodo eliminarColumna() " + e);
		}
	}
	
	public NodoO getNodoFila(int indice) {
		try{
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
		}catch (Exception e) {
			System.out.println("Error en metodo getNodoFila() " + e);
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
			System.out.println("Error en metodo getNodoColumna() " + e);
			return null;
		}
	}

	public NodoO buscarNodo(int fila, int columna) {
		try {
			if (!esVacioColumna() && !esVacioFila()) {
				NodoO temporal = this.getNodoFila(fila);
				int contador = 0;

				while (contador != columna) {
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
		try {
			NodoO nodo = new NodoO();
			nodo = this.buscarNodo(fila, columna);
			nodo.setDato(dato);
		} catch (Exception e) {
			System.out.println("Error en insertarDato(), no se encuentra la fila o columna indicada");
		}

	}
	
	public void llenarMatriz() {
		try {
			if (!esVacioFila() || !esVacioColumna()) {

				for (int i = 1; i < getNumFilas(); i++) {

					NodoO nodoF = this.getNodoFila(i);
					NodoO temporal = nodoF;

					for (int j = 1; j < getNumColumnas(); j++) {

						NodoO nodoC = this.getNodoColumna(j);

						NodoO nuevo = new NodoO(i + "_" + j);

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
			System.out.println("Error en metodo llenarMatriz() " + e);
		}
	}
	
	public void dibujarMatriz() {
		try{
			NodoO temporalc = raiz.getSiguiente();
			NodoO temporalf = raiz.getAbajo();
			
			
			  int contadorf = 1; 
			  int contadorc = 1; 
			  System.out.print("| i |");
			 
			  //Se sustituye por los metodos getnumfilas y getnumcolumnas
			  while(temporalc != null){
			  		System.out.print( temporalc.getDato() + " |"); 
			 		temporalc = temporalc.getSiguiente(); 
			  		contadorc++; 
			 }
			  
			  System.out.println();
			  
			  while(temporalf != null){ 
			  		System.out.println( "| " +	temporalf.getDato() + " |"); 
			  		temporalf = temporalf.getAbajo();
			  		contadorf++; 
			  }
			 

			for (int i = 1; i < this.getNumFilas(); i++) {
				for (int j = 1; j < this.getNumColumnas(); j++) {
					System.out.print("| " + this.buscarNodo(i, j).getDato() + " ");
					System.out.print("fila " + i + " columna " + j);
				}
				System.out.println();
			}
			System.out.println();
			
		}catch (Exception e) {
			System.out.println("Error en metodo dibujarMatriz() " + e);
		}
	}

	/* crea la matriz inicial de 2x4 */

	public void iniciarMatriz() {
		try{
			for (int i = 1; i <= 2; i++) {
				this.agregarFilaI(i);
			}

			for (int i = 1; i <= 4; i++) {
				this.agregarColumnaI(i);
			}

			this.llenarMatriz();
		}catch(Exception e){
			System.out.println("Error en metodo iniciarMatriz() " + e);					
		}

	}

	public void agregarFila() {
		
		
		try{

			int limite = getNumFilas();
			this.agregarFilaI(limite);

			NodoO nodo = this.getNodoFila(limite);

			for (int j = 1; j < getNumColumnas(); j++) {

				NodoO nodoC = this.getNodoColumna(j);

				NodoO nuevo = new NodoO(limite + "_" + j);

				nuevo.setArriba(nodoC);
				nodoC.setAbajo(nuevo);

				nuevo.setAnterior(nodo);
				nodo.setSiguiente(nuevo);

				nodo = nuevo;
			}

			this.dibFila++;
			this.limiteColumna += 50;
			this.dibujarMatriz();

		}catch(Exception e){
			System.out.println("Error en metodo agregarFila() " + e);					
		}
		
	}

	public void agregarColumna() {
	
		try{
			int limite = getNumColumnas();
			this.agregarColumnaI(limite);

			NodoO nodo = this.getNodoColumna(limite);

			for (int i = 1; i < getNumFilas(); i++) {

				NodoO nodoF = this.buscarNodo(i, limite - 1);

				NodoO nuevo = new NodoO(i + "_" + limite);

				nuevo.setArriba(nodo);
				nodo.setAbajo(nuevo);

				nuevo.setAnterior(nodoF);
				nodoF.setSiguiente(nuevo);
			}
			
			this.dibColumna++;
			this.limitefila += 50;
			this.dibujarMatriz();
			
		}catch(Exception e){
			System.out.println("Error en metodo agregarFila() " + e);					
		}
		

	}
	/*Getters and Setters */

	public int getDibFila() {
		return dibFila;
	}

	public void setDibFila(int dibFila) {
		this.dibFila = dibFila;
	}

	public int getDibColumna() {
		return dibColumna;
	}

	public void setDibColumna(int divColumna) {
		this.dibColumna = divColumna;
	}

	public int getLimitefila() {
		return limitefila;
	}

	public void setLimitefila(int limitefila) {
		ListaO.limitefila = limitefila;
	}

	public int getLimiteColumna() {
		return limiteColumna;
	}

	public void setLimiteColumna(int limiteColumna) {
		ListaO.limiteColumna = limiteColumna;
	}



}
