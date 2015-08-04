package com.Escenarios;

import com.Creacion.*;
import com.Main.*;
import com.Objetos.*;
import com.Reportes.ArchivoOrtogonal;
import com.Listas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

	private O_Personaje ob = new O_Personaje();
	private static ListaO o;
	private CrearTablero c;
	private CargaObjetos carga;
	private ArchivoOrtogonal archivoO;

	public E_Escenario(ListaO ortogonal) {

		carga = new CargaObjetos();
		archivoO = new ArchivoOrtogonal(ortogonal);

		o = ortogonal;
		c = new CrearTablero(carga, ortogonal);
		
		// llamada al evento click
		addMouseListener(this);

		/* Creacion de ventana */
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		getContentPane().add(c);

		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (pantalla.width - 1100)/2;
        

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
		
		int defaultX = 50;
		int defaultY = 50;

		int xf = x / 50;
		int yf = (y	) / 50;

		System.out.println(limiteX+ " = " + x);
		System.out.println(limiteY+ " = " + y);
		
		if (x >= defaultX && y >= defaultY) {
			if (x <= limiteX && y <= limiteY) {

				/* objeto personaje mover*/
//				if (x >= 50) {
//					ob.setX(xf * 50);
//				}
//
//				if (y >= 50) {
//					ob.setY(yf * 50);
//				}

				if(!carga.getTemporal().esVacio()){
					o.insertarDato(carga.getTemporal().removePila(), yf, xf);
					archivoO.generarArchivo();					
				}
				
			} else {
				System.out.println("Esta fuera del rango de la matriz, y");
				JOptionPane.showMessageDialog(null, "rango limite fuera");
			}
		} else {
			System.out.println("Esta fuera del rango de la matriz, x ");
			JOptionPane.showMessageDialog(null, "rango default fuera");
		}

	}

}
