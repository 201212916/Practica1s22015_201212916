package com.Nodos;

public class NodoP {
	
	private Object Dato;
	private NodoP siguiente;
	
	public NodoP(){
	
		this.Dato = null;
		this.siguiente = null;
	}
	
	public NodoP(Object dato){
		
		this.Dato = dato;
		this.siguiente = null;
	}
	
	public NodoP(Object dato, NodoP sig){
		
		this.Dato = dato;
		this.siguiente = sig;
	}

	public Object getDato() {
		return Dato;
	}

	public void setDato(Object dato) {
		Dato = dato;
	}

	public NodoP getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoP siguiente) {
		this.siguiente = siguiente;
	}
	

}
