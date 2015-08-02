package com.Main;
import com.Listas.*;
import com.Pojos.*;

public class CargaObjetosPila {
	
	Pila pilaGoomba, pilaKoopa, pilaSuelo, pilaPared, pilaMoneda, pilaVida, pilaCastillo, pilaJugador;
	
	public CargaObjetosPila(){
		pilaGoomba = new Pila(); 
		pilaKoopa = new Pila();
		pilaSuelo = new Pila();
		pilaPared = new Pila();
		pilaMoneda = new Pila();
		pilaVida = new Pila();
		pilaCastillo = new Pila();
		pilaJugador = new Pila();
		
		
		this.ejecutar();
		
	}
	
	public void ejecutar(){
		this.CargaGoomba();
		this.CargaKoopa();
		this.CargaSuelo();
		this.CargaPared();
		this.CargaMoneda();
		this.CargaVida();
		this.CargaCastillo();
		this.CargaJugador();
	}
	
	public void CargaGoomba(){
		try{
			for(int i= 0 ; i<5; i++){
				pilaGoomba.push(new Goomba(i+1));
			}	
		}catch(Exception e){
			System.out.println("Error en metodo CargaGoomba() " + e);
		}
	}
	
	public void CargaKoopa() {
		try {
			for (int i = 0; i < 5; i++) {
				pilaKoopa.push(new Koopa(i + 1));
			}
		} catch (Exception e) {
			System.out.println("Error en metodo CargaKoopa() " + e);
		}
	}
	
	public void CargaSuelo() {
		try {
			for (int i = 0; i < 5; i++) {
				pilaSuelo.push(new Suelo(i + 1));
			}
		} catch (Exception e) {
			System.out.println("Error en metodo CargaSuelo() " + e);
		}
	}
	
	public void CargaPared() {
		try {
			for (int i = 0; i < 5; i++) {
				pilaPared.push(new Pared(i + 1));
			}
		} catch (Exception e) {
			System.out.println("Error en metodo CargaPared() " + e);
		}
	}
	
	public void CargaMoneda() {
		try {
			for (int i = 0; i < 5; i++) {
				pilaMoneda.push(new Moneda(i + 1));
			}
		} catch (Exception e) {
			System.out.println("Error en metodo CargaMoneda() " + e);
		}
	}
	
	public void CargaVida() {
		try {
			for (int i = 0; i < 5; i++) {
				pilaVida.push(new Vida(i + 1));
			}
		} catch (Exception e) {
			System.out.println("Error en metodo CargaVida() " + e);
		}
	}
	
	public void CargaCastillo() {
		try {
			pilaCastillo.push(new Castillo(1));
		} catch (Exception e) {
			System.out.println("Error en metodo CargaCastillo() " + e);
		}
	}
	
	public void CargaJugador() {
		try {
			pilaJugador.push(new Personaje(1));
		} catch (Exception e) {
			System.out.println("Error en metodo CargaJugador() " + e);
		}
	}
	

}
