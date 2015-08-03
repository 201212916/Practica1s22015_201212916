package com.Escenarios;

import com.Creacion.*;
import com.Objetos.*;
import com.Listas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class E_Escenario extends JFrame implements MouseListener {

	O_Personaje ob = new O_Personaje();
	ListaO o;
	CrearTablero c;

	public E_Escenario() {
		o = new ListaO();
		c = new CrearTablero();
		// se inicia la matriz de 2x4
		//o.iniciarMatriz();

		// llamada al evento click
		addMouseListener(this);

		/* Creacion de ventana */
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		getContentPane().add(c);

		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (pantalla.width - 1100)/2;
        System.out.println(width);

		setTitle("Escenario");
		setBounds(width, 210, 1100, 500);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	public int getPosicionX(MouseEvent e) {
		return (int) e.getPoint().getX();
	}

	public int getPosicionY(MouseEvent e) {
		return (int) e.getPoint().getY();
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		int x = this.getPosicionX(e);
		int y = this.getPosicionY(e);

		int limiteX = o.getNumColumnas() * 50;
		int limiteY = o.getNumFilas() * 50;

		System.out.println("limite x " + limiteX);
		System.out.println("limite y " + limiteY);
		int defaultX = 150;
		int defaultY = 50;

		int xf = x / 50;
		int yf = (y - 25) / 50;

		System.out.println("x " + x);
		System.out.println("y " + y);

		if (x >= defaultX || x <= limiteX) {
			if (y >= defaultY || y <= limiteY) {

				if (x >= 50) {
					ob.setX(xf * 50);
				}

				if (y >= 50) {
					ob.setY(yf * 50);
				}
			} else {
				System.out.println("Esta fuera del rango de la matriz, y");
			}
		} else {
			System.out.println("Esta fuera del rango de la matriz, x ");
		}

	}

}
