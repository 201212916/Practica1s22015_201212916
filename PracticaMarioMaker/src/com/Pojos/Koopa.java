package com.Pojos;

public class Koopa extends Objeto {

	public Koopa(int numero,String nombre){
		super(numero,nombre);
		this.setNombre(nombre);
		this.setImagenPath("/com/Imagenes/koopa.png");
	}

}
