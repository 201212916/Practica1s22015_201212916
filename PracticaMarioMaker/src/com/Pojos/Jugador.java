package com.Pojos;

public class Jugador {
	
	private String nombre, objeto;
	private int vida, monedas;
	
	public Jugador(){
		this.nombre = "";
		this.vida = 1;
		this.monedas = 0;
		this.objeto = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}	

}
