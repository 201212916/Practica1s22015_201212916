package com.Main;
import com.Creacion.*;
import com.Listas.*;
import com.Pojos.*;

public class MainPrincipal {

	
	public static void main(String[] args) {
		
		//MainListaO c = new MainListaO();
		
		CargaObjetos c = new CargaObjetos();
		
		c.getGoomba().verLista();
		
		
		//AGREGAR UN NUEVO NODO CON UN NOMBRE A LA LISTA GOOMBA
		c.getGoomba().agregarNodo(new Goomba(c.getGoomba().getTamaño()+1,"Goomba_"+(c.getGoomba().getTamaño()+1)));
		
		c.getGoomba().verLista();
		
		
	}

}
