package com.Listas;
import com.Main.*;
import com.Nodos.*;
import com.Reportes.*;
import com.Pojos.*;

public class ListaO {
	

	private NodoO primero;
	private NodoO ultimo;
	private NodoO arriba_;
	private NodoO abajo_;
	private NodoO raiz;
	private static int dibFila=0, dibColumna=0, limitefila=-50, limiteColumna=-50;
	private Objeto objeto;
	

	public ListaO() {
		
		this.objeto = new Objeto();
		this.primero = null;
		this.ultimo = null;
		this.arriba_ = null;
		this.abajo_ = null;

		this.raiz = new NodoO(0);
		
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

		NodoO nodo = new NodoO("-" + dato + "-");

		try {
			if (esVacioFila()) {
				raiz.setAbajo(nodo);
				arriba_ = nodo;
				abajo_ = nodo;
			} else {
				NodoO temporal = abajo_;
				
				temporal.setAbajo(nodo);
				abajo_ = nodo;
				abajo_.setArriba(temporal);
				
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

	public void eliminarFila(int fila){

			
			try{
				int nFilas = this.getNumFilas()-1;
				int nColumnas = this.getNumColumnas() - 1;
				
				if (nFilas == 1 && fila == 1){
					raiz.setAbajo(null);
					                            this.dibFila--;
				}else if (fila == 1 && nFilas >1) {

					NodoO tr = buscarNodo(1, 0);
					
					
					for (int i = nColumnas; i > 0; i--) {
						
						NodoO temporal = this.buscarNodo(fila, i);
						NodoO ar = this.buscarNodo(fila-1, i);
						NodoO ab = this.buscarNodo(fila+1, i);
//						System.out.println(temporal.getDato() + " *" + i);
						

						ar.setAbajo(ab);
						ab.setArriba(ar);
					}	
					
					raiz.setAbajo(tr.getAbajo());
					tr.getAbajo().setArriba(raiz);				
					this.dibFila--;
				}else if(fila == nFilas){
					
					for (int i = nColumnas; i >= 0; i--) {
						
						NodoO temporal = this.buscarNodo(fila, i);
						NodoO ar = this.buscarNodo(fila-1, i);
						ar.setAbajo(null);
						abajo_ = ar;
						//sig.setAnterior(ant);
					}
                                        this.dibFila--;
				}else if(fila > 1 && fila < nFilas){
					for (int i = nColumnas; i >= 0; i--) {
						
						NodoO temporal = this.buscarNodo(fila, i);
						NodoO ar = this.buscarNodo(fila-1, i);
						NodoO ab = this.buscarNodo(fila+1, i);	
						
						ar.setAbajo(ab);
						ab.setArriba(ar);
						

					}
                                        this.dibFila--;
				}else if (fila == 0){
					System.out.println("No se puede eliminar el nodo Raiz");
				}else{
					System.out.println("Indice no valido");				
				}
				this.dibujarMatriz();
			}catch(Exception e){
				System.out.println("Error en metodo eliminarFila() " );
				e.printStackTrace();
			}
	}
	
	
	
	public void eliminarColumna(int columna){
		
		try{
			int nFilas = this.getNumFilas()-1;
			int nColumnas = this.getNumColumnas() - 1;
			
			if (nColumnas == 1 && columna == 1){
				raiz.setSiguiente(null);
				                            this.dibColumna--;
			}else if (columna == 1 && nColumnas >1) {

				NodoO tr = buscarNodo(0, 1);
				
				for (int i = nFilas; i > 0; i--) {
					
					NodoO temporal = this.buscarNodo(i, columna);
					NodoO ant = temporal.getAnterior();
					NodoO sig = temporal.getSiguiente();	
					ant.setSiguiente(sig);
					sig.setAnterior(ant);
				}	
				
				raiz.setSiguiente(tr.getSiguiente());
				tr.getSiguiente().setAnterior(raiz);				
				                            this.dibColumna--;
			}else if(columna == nColumnas){
				
				for (int i = nFilas; i >= 0; i--) {
					
					NodoO temporal = this.buscarNodo(i, columna);
					NodoO ant = this.buscarNodo(i, columna-1);
					ant.setSiguiente(null);
					ultimo = ant;
					//sig.setAnterior(ant);
				}
                                                            this.dibColumna--;
			}else if(columna > 1 && columna < nColumnas){
				for (int i = nFilas; i >= 0; i--) {
					
					NodoO temporal = this.buscarNodo(i, columna);
					NodoO ant = temporal.getAnterior();
					NodoO sig = temporal.getSiguiente();	
					
					ant.setSiguiente(sig);
					sig.setAnterior(ant);
				}
                            this.dibColumna--;
			}else if (columna == 0){
				System.out.println("No se puede eliminar el nodo Raiz");
			}else{
				System.out.println("Indice no valido");				
			}
			this.dibujarMatriz();
		}catch(Exception e){
			System.out.println("Error en metodo eliminarColumna() " + e);
		}
	}
	
	public NodoO getNodoFila(int indice) {
		try{
			NodoO temporal;

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
			int limiteF = this.getNumFilas();
			int limiteC = this.getNumColumnas();
			
			if (fila >= limiteF){
				System.out.println("No exite tal fila");
				return null;
			}else if (columna >= limiteC){
				System.out.println("No exite tal columna");
				return null;
			}else{
			NodoO temporal = this.getNodoFila(fila);
			

			
			int contador = 0;

			while (contador != columna) {
				temporal = temporal.getSiguiente();

				contador++;
			}
			return temporal;


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

					NodoO temporal = this.getNodoFila(i);
					for (int j = 1; j < getNumColumnas(); j++) {

						NodoO nodoC = this.getNodoColumna(j);


						NodoO nuevo = new NodoO(i + "_" + j);


						nodoC.setAbajo(nuevo);
						nuevo.setArriba(nodoC);

						temporal.setSiguiente(nuevo);
						nuevo.setAnterior(temporal);


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
			  System.out.print("| " + raiz.getDato() +" |");
			 
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
//			 

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
			for (int i = 1; i <= 4; i++) {
			//	this.agregarColumnaI(i);
				this.agregarColumna();
			}
			
			for (int i = 1; i <= 2; i++) {
				//this.agregarFilaI(i);
				this.agregarFila();
			}


			//this.llenarMatriz();
			this.dibujarMatriz();
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

				NodoO nodoC = this.buscarNodo(limite-1, j);

				NodoO nuevo = new NodoO("null");

				nodoC.setAbajo(nuevo);
				nuevo.setArriba(nodoC);

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

				NodoO nuevo = new NodoO("null");


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
