package com.Pojos;

public class Goomba extends Objeto {
	
	public Goomba(int numero, String nombre){
		super(numero, nombre);
		this.setNombre(nombre);
		this.setImagenPath("/com/Imagenes/50/goomba50.png");
	}

}
