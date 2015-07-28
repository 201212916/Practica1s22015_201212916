package com.Main;
import com.Listas.*;

public class MainListaO {
	
	
	public static void main(String [] args){
		
		ListaO o = new ListaO();
		
		o.iniciarMatriz();
		
		o.dibujarMatriz();
		
		o.agregarFila();
		
		o.agregarColumna();
		
		//new MenuMaker(); //llamada a la clase menu maker que crea la ventana inicial
		
		//o.insertarDato("qwerty", 3, 5);
		
		//o.insertarDato("*_*", 1, 1);
		
		//o.insertarDato("*_*", 1, 1);

		//o.dibujarMatriz();
		
		o.eliminarFila();
		
		//o.eliminarColumna();
		

		o.insertarDato("*_*", 3, 5);

		
		
	}
	

}
