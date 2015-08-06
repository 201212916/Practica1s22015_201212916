package com.Objetos;

import com.Listas.*;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class O_Koopa {

		private String koopa = "/com/Imagenes/50/koopa50.png";
		private static int dx, dy, x=0, y=0;
		private Image imagen;
		private ListaO o;


		public O_Koopa(){
			o  = new ListaO();

			x= this.getX();
			y = this.getY();
			
			ImageIcon image = new ImageIcon(this.getClass().getResource(koopa));
			imagen = image.getImage();
			
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
		
	}
