package com.Pojos;

public class Moneda extends Objeto{

	public Moneda(int numero){
		super(numero);
		this.setNombre("Moneda");
		this.setImagenPath("/com/Imagenes/moneda.png");
	}
}
