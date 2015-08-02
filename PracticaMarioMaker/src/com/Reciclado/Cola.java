package com.Reciclado;
import com.Nodos.*;

public class Cola {

	public NodoC primero;
	public NodoC ultimo;

	public Cola() {
		this.primero = null;
		this.ultimo = null;
	}

	public boolean isEmpty() {
		return primero == null && ultimo == null ? true : false;
	}

	public boolean add(Object dato) {
		try {
			NodoC nodoCola = new NodoC(dato);
			if (isEmpty()) {
				primero = nodoCola;
				ultimo = nodoCola;
			} else {
				ultimo.setSiguiente(nodoCola);
				ultimo = nodoCola;
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean remove() {
		try {
			if (!isEmpty()) {
				NodoC temporal = new NodoC();
				temporal = primero.getSiguiente();
				primero.setSiguiente(null);
				primero = temporal;
			} else {
				System.out.println("La cola esta vacia");
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Object getFirst() {
		return primero.getDato();
	}

	public Object getLast() {
		return ultimo.getDato();
	}

	public void verCola() {
		NodoC temporal = new NodoC();
		temporal = primero;
		String valor = "";

		while (temporal != null) {
			valor = valor + temporal.getDato() + "\n";
			temporal = temporal.getSiguiente();
		}
		System.out.println(valor);

	}

}
