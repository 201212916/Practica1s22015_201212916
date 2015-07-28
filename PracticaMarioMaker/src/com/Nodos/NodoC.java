package com.Nodos;

public class NodoC {

	private Object Dato;
	private NodoC siguiente;
	
	public NodoC(){
		this.Dato = null;
		this.siguiente = null;
	}
	
	public NodoC(Object dato){
		this.Dato = dato;
		this.siguiente = null;
	}
	
	public NodoC(Object dato, NodoC sig){
		this.Dato = dato;
		this.siguiente = sig;
	}

	public Object getDato() {
		return Dato;
	}

	public void setDato(Object dato) {
		Dato = dato;
	}

	public NodoC getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoC siguiente) {
		this.siguiente = siguiente;
	}
	
	
}
