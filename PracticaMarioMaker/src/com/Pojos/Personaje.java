package com.Pojos;

public class Personaje extends Objeto {
	
	private String nombreJ;
	private int vida, monedas; 
	
	public Personaje(int numero){
		super(numero);
		this.nombreJ = "";
		this.vida = 1;
		this.monedas = 0;
		this.setNombre("Personaje_Principal");
		this.setImagenPath("/com/Imagenes/mario.png");
	}

	public String getNombreJ() {
		return nombreJ;
	}

	public void setNombreJ(String nombre) {
		this.nombreJ = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}


}
