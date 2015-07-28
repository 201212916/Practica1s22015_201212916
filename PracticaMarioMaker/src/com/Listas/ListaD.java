package com.Listas;

import com.Nodos.*;

public class ListaD {

	public NodoD primero, ultimo;

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

			System.out.println("Se inserto: " + dato);

		} catch (Exception e) {
			System.out.println("Error en metodo agregarNodo() " + e);
		}
	}

	// revisar metodo, variable contador.
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
				return -1;
			} else {
				return -1;
			}

		} catch (Exception e) {
			System.out.println("Error en metodo getIndiceNodo() " + e);
			return -1;
		}

	}

	public NodoD getNodo(int posicion) {
		try {
			NodoD temporal;

			if (!esVacio()) {
				temporal = primero;
				for (int i = 1; i < posicion; i++) {
					temporal = temporal.getSiguiente();
				}
				return temporal;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error en metodo getNodo() " + e);
			return null;
		}

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
					System.out.print(" | " + temporal.getDato());
					temporal = temporal.getSiguiente();
				}

			}

		} catch (Exception e) {
			System.out.println("Error en metodo verLista() " + e);
		}
	}

	public void remove() {
		try {
			if (!esVacio()) {
				if (ultimo == primero) {
					primero = null;
					ultimo = null;
				} else {
					NodoD temporal = new NodoD();
					temporal = ultimo.getAnterior();
					temporal.setSiguiente(null);
					ultimo = temporal;
				}
			} else {
				System.out.println("La lista esta vacia por eso no se remueve");
			}

		} catch (Exception e) {
			System.out.println("Error al remover");
		}
	}

}
