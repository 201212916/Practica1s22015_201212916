package com.Pojos;

public class Castillo extends Objeto{
	
	public Castillo(int numero, String nombre){
		super(numero,nombre);
		this.setNombre(nombre);
		this.setImagenPath("/com/Imagenes/castillo.png");
	}
}
