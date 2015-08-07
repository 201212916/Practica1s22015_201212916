package com.Escenarios;

import com.Creacion.*;
import com.Main.*;
import com.Objetos.*;
import com.Reportes.ArchivoOrtogonal;
import com.Reportes.ArchivoRecuperar;
import com.Listas.*;
import com.Reportes.ArchivoRecuperarOrtogonal;

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
	private O_Koopa obKoopa = new O_Koopa();
	
	private static ListaO o;
	private CrearTablero c;
	private CargaObjetos carga;
	private ArchivoOrtogonal archivoO;
	private ArchivoRecuperarOrtogonal archivoR;
	
	public E_ObjetosMenu objetosMenu;
	

	public E_Escenario(ListaO ortogonal, E_ObjetosMenu objetosMenu) {

		
		this.objetosMenu = objetosMenu;
		
		
		carga = new CargaObjetos();
		archivoO = new ArchivoOrtogonal(ortogonal);
		archivoR = new ArchivoRecuperarOrtogonal();

		o = ortogonal;
		c = new CrearTablero(carga, ortogonal,objetosMenu);
		
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

		int defaultX = 50;
		int defaultY = 50;

		int xf = x / 50;
		int yf = (y	) / 50;
		
		if (x >= defaultX && y >= defaultY) {
			if (x <= limiteX && y <= limiteY) {

//				if(objetosMenu.jRadioButton3.isSelected() && objetosMenu.jRadioButton4.isSelected()){
//				/* objeto personaje mover*/
//				if (x >= 50) {
//					ob.setX(xf * 50);
//				}
//
//				if (y >= 50) {
//					ob.setY(yf * 50);
//				}
//			}
//				else 
				if(objetosMenu.jRadioButton3.isSelected()){
					if(!carga.getTemporal().esVacio()){	
					String obj = c.obtenerObjeto(carga.getTemporal().getNodo(1).getDato().toString());
					String path = "/com/Imagenes/50/";
                                        
					switch(obj){
					case "Goomba": 
						path += "goomba50.png";
						break;
					case "Koopa" :
						path += "koopa50.png";
						break;
					case "Suelo" : 
						path += "suelo50.png";
						break;
					case "Pared" : 
						path += "pared50.png";
						break;
					case "Moneda" : 
						path += "moneda50.png";
						break;
					case "Hongo" : 
						path += "vida50.png";
						break;
					case "Jugador:" : 
						path += "mario50.png";
						break;
					case "Castillo" : 
						path += "castillo50.png";
						break;
					}

					if (!o.buscarNodo(yf, xf).getDato().equals("null")){
		                JOptionPane.showMessageDialog(null, "El lugar esta ocupado por otro objeto, no se puede insertar aca");						
					}else{
						c.crearArchivoTemporal(obj, xf*50, yf*50,path);
						o.insertarDato(carga.getTemporal().removePila(), yf, xf);
						
						if(obj.equals("Jugador:")){
							if (x >= 50) {
								ob.setX(xf * 50);
							}

							if (y >= 50) {
								ob.setY(yf * 50);
							}	
						}
						
						archivoO.generarArchivo();	
					}
					
				}}
				else if(objetosMenu.jRadioButton4.isSelected()){
					
					String objmat = o.buscarNodo(yf, xf).getDato().toString();
					String objel = c.obtenerObjeto(objmat);
					String path = "/com/Imagenes/50/";
					
					switch(objel){
					case "Goomba": 
						path += "goomba50.png";
						break;
					case "Koopa" :
						path += "koopa50.png";
						break;
					case "Suelo" : 
						path += "suelo50.png";
						break;
					case "Pared" : 
						path += "pared50.png";
						break;
					case "Moneda" : 
						path += "moneda50.png";
						break;
					case "Hongo" : 
						path += "vida50.png";
						break;
					case "Jugador:" : 
						path += "mario50.png";
						break;
					case "Castillo" : 
						path += "castillo50.png";
						break;
					}
					
					if (o.buscarNodo(yf, xf).getDato().equals("null")){
		                JOptionPane.showMessageDialog(null, "No hay ningun objeto aca a eliminar");						
					}else{
						carga.getRecuperarOrtogonal().agregarNodo(objmat);
						o.buscarNodo(yf, xf).setDato("null");
						c.crearArchivoRecuperar(objel, xf*50, yf*50,path);
						archivoR.generarArchivo();
						archivoO.generarArchivo();	
 
					}
				
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
