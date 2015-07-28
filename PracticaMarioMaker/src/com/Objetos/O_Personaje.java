package com.Objetos;
import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class O_Personaje {

	private String personaje = "/com/Imagenes/mario.png";
	
	private int dx, dy, x, y;
		
	private Image imagen;
	
	public O_Personaje(){
		this.x = 79;
		this.y = 79;
		ImageIcon image = new ImageIcon(this.getClass().getResource(personaje));
		imagen = image.getImage();
		
	}
	
	public void mover(){
		this.x += dx;
		this.y += dy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagen() {
		return imagen;
	}
	
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			this.dx = -79;
		}
		
		if(key == KeyEvent.VK_RIGHT){
			this.dx = 79;
		}
		
		if(key == KeyEvent.VK_UP){
			this.dy = -82;
		}
		
		if(key == KeyEvent.VK_DOWN){
			this.dy = 82;
		}
	}
	
	public void keyReleased(KeyEvent e){
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			this.dx = 0;
		}
		
		if(key == KeyEvent.VK_RIGHT){
			this.dx = 0;
		}
		
		if(key == KeyEvent.VK_UP){
			this.dy = 0;
		}
		
		if(key == KeyEvent.VK_DOWN){
			this.dy = 0;
		}
	}
}
