package com.Nodos;

public class NodoD {
	
	private Object Dato;
	private NodoD siguiente, anterior;
	
	public NodoD(){
		this.Dato = null;
		this.siguiente = null;
		this.anterior = null;
	}
	
	public NodoD(Object dato){
		this.Dato = dato;
		this.siguiente = null;
		this.anterior = null;		
	}

	public Object getDato() {
		return Dato;
	}

	public void setDato(Object dato) {
		Dato = dato;
	}

	public NodoD getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoD siguiente) {
		this.siguiente = siguiente;
	}

	public NodoD getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoD anterior) {
		this.anterior = anterior;
	}
	

}
