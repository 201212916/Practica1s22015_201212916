package com.Listas;

import com.Nodos.*;

public class ListaD {

	private NodoD primero, ultimo;

	public ListaD() {
		this.primero = null;
		this.ultimo = null;
	}

	public boolean esVacio() {
		return this.primero == null && this.ultimo == null ? true : false;
	}

	public void agregarNodo(Object dato) {

		try {

			NodoD nodo = new NodoD(dato);
			NodoD temporal = new NodoD();

			if (esVacio()) {
				primero = nodo;
				ultimo = nodo;
			} else {
				temporal = ultimo;
				ultimo.setSiguiente(nodo);
				ultimo = nodo;
				nodo.setAnterior(temporal);
			}

		} catch (Exception e) {
			System.out.println("Error en metodo agregarNodo() " + e);
		}
	}

	public int getIndiceNodo(Object dato) {
		int contador = -1;
		try {

			if (!esVacio()) {
				NodoD temporal = primero;
				contador = 1;

				while (temporal != null) {
					if (temporal.getDato().equals(dato)) {
						return contador;
					}
					temporal = temporal.getSiguiente();
					contador++;
				}
				;
				return contador;
			} else {
				return contador;
			}

		} catch (Exception e) {
			System.out.println("Error en metodo getIndiceNodo() " + e);
			return contador;
		}

	}

	public NodoD getNodo(int posicion) {
		try {
			NodoD temporal = null;

			if (!esVacio()) {
				if(posicion <0){
					System.out.println("No existe un nodo con indice negativo");
					return temporal;
				}
				else if (posicion == 0 ){
					System.out.println("No Se puede eliminar la raiz de la lista");
					return temporal;
				}
				else{
					temporal = primero;
					for (int i = 1; i < posicion; i++) {
						temporal = temporal.getSiguiente();
					}
					return temporal;			
				} 
			}
			else{
				return temporal;
			}
		} catch (Exception e) {
			System.out.println("Error en metodo getNodo() " + e);
			return null;
		}

	}
	
	public int getTamaño(){
		int contador = 0;
		NodoD nodo = new NodoD();
		nodo = primero;
		while(nodo!=null){
			nodo = nodo.getSiguiente();
			contador++;
		}
		return contador;
	}

	public void getAnterior(Object dato) {
		try {
			int indice = this.getIndiceNodo(dato);
			NodoD nodo = this.getNodo(indice);

			System.out.println("El anterior a ese nodo es "
					+ nodo.getAnterior().getDato());

		} catch (Exception e) {
			System.out.println("Error en metodo getAnterior() " + e);
		}
	}

	public void getSiguiente(Object dato) {
		try {
			int indice = this.getIndiceNodo(dato);
			NodoD nodo = this.getNodo(indice);
			System.out.println("El siguiente a ese nodo es "
					+ nodo.getSiguiente().getDato());

		} catch (Exception e) {
			System.out.println("Error en metodo getSiguiente() " + e);
		}
	}

	public void verLista() {
		try{
			NodoD temporal = new NodoD();

			temporal = primero;

			if (esVacio()) {
				System.out.println("La lista esta vacia");
			} else {

				while (temporal != null) {
					System.out.println(temporal.getDato());
					temporal = temporal.getSiguiente();
				}

			}

		} catch (Exception e) {
			System.out.println("Error en metodo verLista() " + e);
		}
	}

	public void remove(int i) {
		try {
			
			NodoD dato = this.getNodo(i);
			
			if (!esVacio() && dato != null) {
				if (this.getTamaño()==1 && i==1){
					primero = null;
					ultimo = null;
				}
				else if (i==1 && this.getTamaño()>1) {
					NodoD temporal = new NodoD();
					temporal = getNodo(i+1);
					primero.setSiguiente(null);
					primero = temporal;
				}
				else if (i >1 && this.getTamaño() == i) {

					NodoD temporal = new NodoD();
					temporal = ultimo.getAnterior();
					temporal.setSiguiente(null);
					ultimo = temporal;
				}
				else {
					NodoD temporal = new NodoD();
					temporal = getNodo(i);
					
					temporal.getAnterior().setSiguiente(temporal.getSiguiente());
					temporal.getSiguiente().setAnterior(temporal.getAnterior());

					temporal.setSiguiente(null);
					temporal = null;
				}
			} else {
				System.out.println("El nodo no existe");
			}

		} catch (Exception e) {
			System.out.println("Error al remover");
		}
	}
	
	public void removePila(){
		this.remove(this.getTamaño());
	}
	
	public void removeCola(){
		this.remove(1);
	}
	
}
