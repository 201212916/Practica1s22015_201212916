package com.Nodos;

public class NodoO {

		private Object Dato;
		private NodoO siguiente, anterior, arriba, abajo;
		
public NodoO(){
	this.Dato = null;
	this.siguiente = null;
	this.anterior = null;
	this.abajo = null;
	this.arriba = null;
}

public NodoO(Object dato){
	this.Dato = dato;
	this.siguiente = null;
	this.anterior = null;
	this.abajo = null;
	this.arriba = null;
}

public Object getDato() {
	return Dato;
}

public void setDato(Object dato) {
	Dato = dato;
}

public NodoO getSiguiente() {
	return siguiente;
}

public void setSiguiente(NodoO siguiente) {
	this.siguiente = siguiente;
}

public NodoO getAnterior() {
	return anterior;
}

public void setAnterior(NodoO anterior) {
	this.anterior = anterior;
}

public NodoO getArriba() {
	return arriba;
}

public void setArriba(NodoO arriba) {
	this.arriba = arriba;
}

public NodoO getAbajo() {
	return abajo;
}

public void setAbajo(NodoO abajo) {
	this.abajo = abajo;
}


}
