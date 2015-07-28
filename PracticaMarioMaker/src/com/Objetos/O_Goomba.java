package com.Objetos;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class O_Goomba {
	
	public class O_Personaje {

		private String personaje = "/com/Imagenes/goomba.png";
		
		private int dx, dy, x, y;
			
		private Image imagen;
		
		public O_Personaje(){
			this.x = 50;
			this.y = 60;
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
				this.dx = -1;
			}
			
			if(key == KeyEvent.VK_RIGHT){
				this.dx = 1;
			}
			
			if(key == KeyEvent.VK_UP){
				this.dy = -1;
			}
			
			if(key == KeyEvent.VK_DOWN){
				this.dy = 1;
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
}
