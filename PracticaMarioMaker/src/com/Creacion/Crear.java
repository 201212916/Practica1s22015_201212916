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

public class Crear extends JPanel implements ActionListener {
	
	private O_Personaje personaje;
	private O_Goomba goomba;
	private Timer timer;
	
	public Crear(){
		
		//setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new teclado());
		personaje = new O_Personaje();
		goomba = new O_Goomba();
		timer = new Timer(100, this);
		timer.start();
	}
	
	public void paint(Graphics grafico){
		super.paint(grafico);
		
		Graphics2D gr2 = (Graphics2D) grafico;
		gr2.drawImage(personaje.getImagen(), personaje.getX(), personaje.getY(), null);
		
		
		int ancho = 79, alto = 82; 
		for(int i = 1; i <= 10; i++){ 
		grafico.drawLine(79, i * alto, getSize().width - 100, i * alto); 
		grafico.drawLine(i * ancho, 79, i * ancho, getSize().height - 100); 
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

}
