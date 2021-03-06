package com.Main;
import com.Listas.*;
import com.Pojos.*;

public class CargaObjetos {
	
	private static ListaD Goomba, Koopa, Suelo, Pared, Moneda, Vida, Castillo, Jugador;
	private static Personaje pojoPersonaje;
	private static Castillo pojoCastillo;
	private static Goomba pojoGommba;
	private static Koopa pojoKoopa;
	private static Suelo pojoSuelo;
	private static Pared pojoPared;
	private static Moneda pojoMoneda;
	private static Vida pojoVida;
	private static ListaD temporal;
	private static ListaD recuperar;
        private static ListaD recuperarOrtogonal;

	
	public CargaObjetos(){
		Goomba = new ListaD();
		Koopa = new ListaD();
		Suelo = new ListaD();
		Pared = new ListaD();
		Moneda = new ListaD();
		Vida = new ListaD();
		Castillo = new ListaD();
		Jugador = new ListaD();
		temporal = new ListaD();
		recuperar = new ListaD();
                recuperarOrtogonal = new ListaD();
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
	
	private void CargaGoomba(){
		try{
			for(int i= 0 ; i<5; i++){
				Goomba.agregarNodo(new Goomba(i+1,"Goomba_" + (i+1)));
			}	
		}catch(Exception e){
			System.out.println("Error en metodo CargaGoomba() " + e);
		}
	}
	
	private void CargaKoopa() {
		try {
			for (int i = 0; i < 5; i++) {
				Koopa.agregarNodo(new Koopa(i+1, "Koopa_" + (i+1)));
			}
		} catch (Exception e) {
			System.out.println("Error en metodo CargaKoopa() " + e);
		}
	}
	
	private void CargaSuelo() {
		try {
			for (int i = 0; i < 5; i++) {
				Suelo.agregarNodo(new Suelo(i+1, "Suelo_" + (i+1)));
			}
		} catch (Exception e) {
			System.out.println("Error en metodo CargaSuelo() " + e);
		}
	}
	
	private void CargaPared() {
		try {
			for (int i = 0; i < 5; i++) {
				Pared.agregarNodo(new Pared(i+1, "Pared_" + (i+1)));
			}
		} catch (Exception e) {
			System.out.println("Error en metodo CargaPared() " + e);
		}
	}
	
	private void CargaMoneda() {
		try {
			for (int i = 0; i < 5; i++) {
				Moneda.agregarNodo(new Moneda(i+1, "Moneda_" + (i+1)));
			}
		} catch (Exception e) {
			System.out.println("Error en metodo CargaMoneda() " + e);
		}
	}
	
	private void CargaVida() {
		try {
			for (int i = 0; i < 5; i++) {
				Vida.agregarNodo(new Vida(i+1,"Hongo_Vida_"+(i+1)));
			}
		} catch (Exception e) {
			System.out.println("Error en metodo CargaVida() " + e);
		}
	}
	
	private void CargaCastillo() {
		try {
			Castillo.agregarNodo(pojoCastillo = new Castillo(1,"Castillo_" + 1));
		} catch (Exception e) {
			System.out.println("Error en metodo CargaCastillo() " + e);
		}
	}
	
	private void CargaJugador() {
		try {
			Jugador.agregarNodo(pojoPersonaje = new Personaje(1,"Mario Bros"));
		} catch (Exception e) {
			System.out.println("Error en metodo CargaJugador() " + e);
		}
	}

	/* Getters and Setters de Listas */
	
	public ListaD getGoomba() {
		return Goomba;
	}

	public void setGoomba(ListaD goomba) {
		Goomba = goomba;
	}

	public ListaD getKoopa() {
		return Koopa;
	}

	public void setKoopa(ListaD koopa) {
		Koopa = koopa;
	}

	public ListaD getSuelo() {
		return Suelo;
	}

	public void setSuelo(ListaD suelo) {
		Suelo = suelo;
	}

	public ListaD getPared() {
		return Pared;
	}

	public void setPared(ListaD pared) {
		Pared = pared;
	}

	public ListaD getMoneda() {
		return Moneda;
	}

	public void setMoneda(ListaD moneda) {
		Moneda = moneda;
	}

	public ListaD getVida() {
		return Vida;
	}

	public void setVida(ListaD vida) {
		Vida = vida;
	}

	public ListaD getCastillo() {
		return Castillo;
	}

	public void setCastillo(ListaD castillo) {
		Castillo = castillo;
	}

	public ListaD getJugador() {
		return Jugador;
	}

	public void setJugador(ListaD jugador) {
		Jugador = jugador;
	}
	
	/*Fin de los getters y setters de las listas */
	
	/* Getters and Setters de los Pojos*/

	public Personaje getPojoPersonaje() {
		return pojoPersonaje;
	}


	public void setPojoPersonaje(Personaje pojoPersonaje) {
		CargaObjetos.pojoPersonaje = pojoPersonaje;
	}


	public Castillo getPojoCastillo() {
		return pojoCastillo;
	}


	public void setPojoCastillo(Castillo pojoCastillo) {
		CargaObjetos.pojoCastillo = pojoCastillo;
	}

	public Goomba getPojoGommba() {
		return pojoGommba;
	}


	public void setPojoGommba(Goomba pojoGommba) {
		this.pojoGommba = pojoGommba;
	}


	public Koopa getPojoKoopa() {
		return pojoKoopa;
	}


	public void setPojoKoopa(Koopa pojoKoopa) {
		this.pojoKoopa = pojoKoopa;
	}


	public Suelo getPojoSuelo() {
		return pojoSuelo;
	}


	public void setPojoSuelo(Suelo pojoSuelo) {
		this.pojoSuelo = pojoSuelo;
	}


	public Pared getPojoPared() {
		return pojoPared;
	}


	public void setPojoPared(Pared pojoPared) {
		this.pojoPared = pojoPared;
	}


	public Moneda getPojoMoneda() {
		return pojoMoneda;
	}


	public void setPojoMoneda(Moneda pojoMoneda) {
		this.pojoMoneda = pojoMoneda;
	}


	public Vida getPojoVida() {
		return pojoVida;
	}


	public void setPojoVida(Vida pojoVida) {
		this.pojoVida = pojoVida;
	}

	/*Fin de los getters y setters de pojos */
	
	/*Lista temporal de agregar al tablero */

	public ListaD getTemporal() {
		return temporal;
	}


	public void setTemporal(ListaD temporal) {
		this.temporal = temporal;
	}


	public ListaD getRecuperar() {
		return recuperar;
	}


	public void setRecuperar(ListaD recuperar) {
		this.recuperar = recuperar;
	}

        public ListaD getRecuperarOrtogonal() {
            return recuperarOrtogonal;
        }

        public void setRecuperarOrtogonal(ListaD recuperarOrtogonal) {
            this.recuperarOrtogonal = recuperarOrtogonal;
        }


	
}
