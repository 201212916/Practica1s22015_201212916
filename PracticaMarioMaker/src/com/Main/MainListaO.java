package com.Main;
import com.Listas.*;

public class MainListaO {
	
	
	public static void main(String [] args){
		
		ListaO o = new ListaO();
		
		System.out.println(o.verVacioFila());
		
		o.agregarFila(1);
		o.agregarFila(2);
		System.out.println(o.verVacioFila());		
		System.out.println(o.verVacioColumna());
		
		o.agregarColumna('A');
		o.agregarColumna('B');
		o.agregarColumna('C');
		o.agregarColumna('D');
		
		System.out.println(o.verVacioColumna());
		
		System.out.println(o.verVacioFila());
		
		System.out.println(o.getNumFilas());
		System.out.println(o.getNumColumnas());
		
		System.out.println(o.getNodoColumna(3).getDato());
		
	}
	

}
