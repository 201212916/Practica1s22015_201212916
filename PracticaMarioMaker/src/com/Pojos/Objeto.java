package com.Pojos;

public class Objeto {

	private String nombre, imagenPath;
	private int numero;
	
	public Objeto(int i){
		this.nombre = "";
		this.imagenPath = "";
		this.numero = i;
	}
	
	public Objeto(int i, String nombre){
		this.nombre = nombre;
		this.imagenPath = "";
		this.numero = i;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagenPath() {
		return imagenPath;
	}

	public void setImagenPath(String imagenPath) {
		this.imagenPath = imagenPath;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String toString(){
		return "* " + this.getNombre() + " Cantidad: " + this.getNumero();
	}
	
}
