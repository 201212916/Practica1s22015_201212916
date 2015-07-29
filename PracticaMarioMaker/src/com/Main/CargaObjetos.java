package com.Main;
import com.Listas.*;

public class CargaObjetos {
	Pila listaGoomba;
	Pila listaKoopa;
	
	public CargaObjetos(){
		listaGoomba = new Pila();
		listaKoopa = new Pila();
		this.CargaGooba();
		this.CargaKoopa();
		
	}
	
	public void CargaGooba(){

		for(int i= 0 ; i<15; i++){
			listaGoomba.push("Objeto goomba " + i);
			//System.out.println("Objeto goomba " + i);
		}
	}
	
	public void CargaKoopa(){

		
		for(int i= 0 ; i<15; i++){
			listaKoopa.push("Objeto Koopa " + i);
			//System.out.println("Objeto Koopa " + i);
		}
	}

}
