package com.Pojos;

public class Moneda extends Objeto{

	public Moneda(int numero, String nombre){
		super(numero, nombre);
		this.setNombre(nombre);
		this.setImagenPath("/com/Imagenes/50/moneda50.png");
	}
}
