package com.Reciclado;
import com.Nodos.*;

public class Pila {

	public NodoP primero;
	public NodoP ultimo;

	public Pila() {
		this.primero = null;
		this.ultimo = null;
	}

	public boolean Empty() {
		return primero == null && ultimo== null ? true : false;
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

		try{
			
			NodoP temporal = new NodoP();

			if(!Empty()){
				
			//	temporal = primero;
				
			//	while(temporal!=null){
			//		temporal = temporal.getSiguiente();
			//	}				
				
				temporal = ultimo;
				//temporal2 = temporal;

				ultimo.setSiguiente(null);

				ultimo = null;
				
				System.out.println("if " + ultimo);
				

				return temporal.getDato();
			}else{
				return "";
			}
		}catch(Exception e){
			return "";
		}


	}

	public void verLista() {

		NodoP temporal = new NodoP();
		temporal = primero;
		String valor = "";

		while (temporal != null) {
			valor = valor + temporal.getDato() + "\n";
			temporal = temporal.getSiguiente();
		}
		System.out.println(valor);
	}

}
