package com.Pojos;

public class Suelo extends Objeto{
	
	public Suelo(int numero, String nombre){
		super(numero, nombre);
		this.setNombre(nombre);
		this.setImagenPath("/com/Imagenes/suelo.png");
	}

}
