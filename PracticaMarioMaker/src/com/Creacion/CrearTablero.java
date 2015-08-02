package com.Creacion;
import com.Objetos.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.Listas.*;
public class CrearTablero extends JPanel implements ActionListener {
	
	private O_Personaje personaje;
	private O_Goomba goomba;
	private Timer timer;
	private ListaO listao;
	public boolean bandera = true;

	
	public CrearTablero(){
		
		//setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new teclado());
		personaje = new O_Personaje();
		
		goomba = new O_Goomba();
		timer = new Timer(100, this);
		timer.start();
		listao = new ListaO();

	}


	
	public void paint(Graphics grafico){

			 super.paint(grafico);
				
				Graphics2D gr2 = (Graphics2D) grafico;
				gr2.drawImage(personaje.getImagen(), personaje.getX(), personaje.getY(), null);
				
				
				/* creacion de tablero */
				
				int fila = listao.getDibFila() + 1 ;
				int columna = listao.getDibColumna() +1;
				int ancho = 50, alto = 50;
				
				for(int i = 1; i <= fila; i++){ 
					grafico.drawLine(50, i * alto, (columna * 50), i * alto); // linea horizontal 
				} 
				
				for(int i = 1; i <= columna; i++){ 
					grafico.drawLine(i * ancho, 50, i * ancho, (fila *50) ); // linea vertical
				}

	}
	

	public void actionPerformed(ActionEvent e){
		this.personaje.mover();
		//this.goomba.mover();
		this.repaint();
	}
	
	

	
	private class teclado extends KeyAdapter{
		
		public void keyReleased(KeyEvent e) {
			personaje.keyReleased(e);

		}

		public void keyPressed(KeyEvent e) {
			personaje.keyPressed(e);
			
		}
	}

	/*
	public void setearPosicionImagen(int x, int y){
		
		//inicial es x = 50 y x = 75 por el momento
		int xf = x/50;
		int yf = (y-25)/50;
		if (x>=50){
			this.posicionX = xf*50;
			//this.setPosicionX(xf*50);
			System.out.println("Posicion x " + xf);
		}
		
		if (y>=50){
			this.posicionY = yf*50;
			//this.setPosicionY(yf*50);
			System.out.println("Posicion y " + yf + " " + posicionY );
		}
		


		
	}*/
	
	
}
