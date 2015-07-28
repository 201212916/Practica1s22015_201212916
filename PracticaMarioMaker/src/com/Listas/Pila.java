package com.Listas;
import com.Nodos.*;

public class Pila {

	private NodoP primero = new NodoP();
	private NodoP ultimo = new NodoP();

	public Pila() {
		this.primero = null;
		this.ultimo = null;
	}

	public boolean Empty() {
		return this.primero == null ? true : false;
	}

	public Object push(Object dato) {

		NodoP nuevo = new NodoP(dato);

		if (Empty()) {
			this.primero = nuevo;
			this.ultimo = nuevo;

		} else {
			this.ultimo.setSiguiente(nuevo);
			this.ultimo = nuevo;
		}

		return dato;
	}

	public Object pop() {

		NodoP temporal = new NodoP();
		temporal = ultimo;

		ultimo.setSiguiente(null);
		ultimo = null;

		return temporal.getDato();

	}

	public void verLista() {

		NodoP temporal = new NodoP();
		temporal = primero;

		while (temporal != null) {

			System.out.println("* " + temporal.getDato());
			temporal = temporal.getSiguiente();
		}
	}

}
