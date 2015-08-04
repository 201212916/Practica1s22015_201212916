package com.Main;
import com.Creacion.*;
import com.Reportes.*;
import com.Listas.*;
import com.Pojos.*;
import com.Escenarios.*;

public class MainPrincipal {

	
	public static void main(String[] args) {
		E_ObjetosMenu e = new E_ObjetosMenu();		
		e.show();
//		//MainListaO c = new MainListaO();
		E_Escenario es = new E_Escenario(e.getO());
//		CargaObjetos c = new CargaObjetos();
//		
		
		E_Juego j = new E_Juego(e);
		j.show();
		
		E_Lateral l = new E_Lateral();
		l.show();
		
		//MenuMaker m = new MenuMaker();
		
//		c.ejecutar();
//		
		//c.getGoomba().verLista();
		
		
		//AGREGAR UN NUEVO NODO CON UN NOMBRE A LA LISTA GOOMBA
		//c.getGoomba().agregarNodo(new Goomba(c.getGoomba().getSize()+1,"Goomba_"+(c.getGoomba().getSize()+1)));
		
		//c.getGoomba().verLista();
		

		//es.show();		
		
		//e.show();

		//m.show();
		
//		ArchivoOrtogonal a = new ArchivoOrtogonal();
//		
//		a.generarArchivo();
//		
//		
//		ArchivoListas l = new ArchivoListas();
//		
//		l.generarArchivo();
//		
//		ArchivoImagen i = new ArchivoImagen();
//		
//		i.abrirImagenLista();
//		i.abrirImagenOrtogonal();
		

		

	}

}
