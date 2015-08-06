package com.Pojos;

public class Personaje extends Objeto {
	
	private String nombreJ;
	private int vida, monedas; 
	
	public Personaje(int numero, String nombre){
		super(numero, nombre);
		this.nombreJ = "Player 1";
		this.vida = 1;
		this.monedas = 0;
		this.setNombre(nombre);
		this.setImagenPath("/com/Imagenes/50/mario50.png");
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

	public String toString(){
		return "* Jugador: " + this.getNombreJ() + " Personaje: " + this.getNombre();
	}

}
