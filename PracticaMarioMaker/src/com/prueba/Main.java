package com.prueba;
	import javax.swing.JFrame; 

import java.awt.Graphics; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

	public class Main extends JFrame 
	{ 
	public Main() 
	{ 
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
	setSize(400,400); 
	setVisible(true);
	

	} 

	public void paint(Graphics g) 
	{ 
	super.paint(g); 
	int ancho = 30, alto = 30; 
	for(int i = 1; i <= 10; i++){ 
	g.drawLine(30, i * alto, getSize().width - 100, i * alto); 
	g.drawLine(i * ancho, 30, i * ancho, getSize().height - 100); 
	} 
	} 
	
	//Construye una String con la posicion del cursor
	public String getPosicion(MouseEvent e) {
	     String pos="[ Posicion x="+e.getPoint().getX();
	     pos=pos+" ; y="+e.getPoint().getY()+ " ]";
	     return pos;
	}

	//Construyo un mensaje para indicar que botón se está pulsando
	public String getBoton(MouseEvent e){
	     String msg=null;
	     int result=e.getButton();
	     if (result==e.NOBUTTON)
	          msg=" - No pulsó ningún botón -";
	     else if (result==e.BUTTON1)
	         msg=" - Pulsó el botón nº 1 - ";
	     else if (result==e.BUTTON2)
	         msg=" - Pulsó el botón nº 2 - "; 
	     else if (result==e.BUTTON3)
	         msg=" - Pulsó el botón nº 3 - "; 

	     return msg;
	}


	public static void main(String[]args) 
	{ 
	Main m = new Main(); 
	

	} 
	}
	
	

