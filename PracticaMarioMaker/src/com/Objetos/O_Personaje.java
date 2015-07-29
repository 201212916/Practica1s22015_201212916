package com.Objetos;
import com.Listas.*;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class O_Personaje {

	private String personaje = "/com/Imagenes/mario.png";
	private static int dx, dy, x=50, y=50;
	private Image imagen;
	private ListaO o;


	public O_Personaje(){
		o  = new ListaO();

		x= this.getX();
		y = this.getY();
		
		ImageIcon image = new ImageIcon(this.getClass().getResource(personaje));
		imagen = image.getImage();
		
	}

	public void mover(){

		if (this.x>=100 || this.dx>0){
			if (this.x <=o.getLimitefila() || this.dx<0){
					this.x += this.dx;
			}
		}

		if (this.y>=100 || this.dy>0){		
			if (this.y <= o.getLimiteColumna() || this.dy<0){
				this.y += this.dy;
			}
		}

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImagen() {
		return imagen;
	}
	
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			this.dx = -50;
		}
		
		if(key == KeyEvent.VK_RIGHT){
			this.dx = 50;
		}
		
		if(key == KeyEvent.VK_UP){
			this.dy = -50;
		}
		
		if(key == KeyEvent.VK_DOWN){
			this.dy = 50;
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
