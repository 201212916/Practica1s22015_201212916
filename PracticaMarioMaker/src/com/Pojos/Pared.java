package com.Pojos;

public class Pared extends Objeto{

	public Pared(int numero, String nombre){
		super(numero, nombre);
		this.setNombre(nombre);
		this.setImagenPath("/com/Imagenes/pared.png");
	}
}
