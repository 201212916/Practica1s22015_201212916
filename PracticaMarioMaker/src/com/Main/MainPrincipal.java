package com.Main;
import com.Creacion.*;
import com.Listas.*;

public class MainPrincipal {

	
	public static void main(String[] args) {
		
		//MainListaO c = new MainListaO();
		
		CargaObjetos c = new CargaObjetos();
		
		c.Moneda.verLista();
		c.Moneda.removeCola();
		
		c.Moneda.verLista();
	}

}
