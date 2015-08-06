package com.Creacion;

import com.Objetos.*;
import com.Main.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.Escenarios.E_ObjetosMenu;
import com.Listas.*;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearTablero extends JPanel implements ActionListener {

	private O_Personaje personaje;
	private O_Koopa koopa;
	private O_Goomba goomba;
	
	private CargaObjetos carga;
	
	private Timer timer;
	private ListaO listao;
	private ImageIcon imageFondo;
	private Image imagenFondo;
	private static String objeto;
	
	public E_ObjetosMenu objetosMenu;

        public CrearTablero(){
            
        }
        
	public CrearTablero(CargaObjetos carga, ListaO listao,  E_ObjetosMenu objetosMenu) {
		
		this.objetosMenu = objetosMenu;
		
		personaje = new O_Personaje();
		goomba = new O_Goomba();
		koopa = new O_Koopa();
		
		objeto = "NADA";
		
		this.carga = carga;
		this.listao = listao;
		
		imageFondo = new ImageIcon(this.getClass().getResource("/com/Imagenes/fondo.jpg"));
		imagenFondo = imageFondo.getImage();
		
		timer = new Timer(100, this);
		timer.start();

		setFocusable(true);
		addKeyListener(new teclado());
		
		
		
		

	}
	
	public String obtenerObjeto(String cadena) {
		try{
			String[] palabras = cadena.split(" ");
			String[] objeto = palabras[1].split("_");

			return objeto[0].toString();
			
		}catch(Exception e){
			return cadena;
		}
		
	}

	public String[] obtenerArchivo(String cadena) {
		String[] objeto = cadena.split(" ");

		return objeto;
	}

	public void crearArchivoTemporal(String objeto, int fila, int columna,String path) {
		String recuperado = recuperarArchivoTemporal();
		String file = "src/com/Archivos/Temporal.txt";
		File f = new File(file);
		BufferedWriter bw;
		PrintWriter wr;

		try {
			FileWriter w = new FileWriter(f);
			bw = new BufferedWriter(w);
			wr = new PrintWriter(bw);
			wr.write(recuperado);
			wr.write(objeto + " " + fila + " " + columna + " " + path + "\n");
			wr.close();
			bw.close();

		} catch (IOException e) {
			System.out.println("Hubo Error al escribir el archivoTemporal: "
					+ e);
		}
	}
	
	public void crearArchivoRecuperar(String objeto, int fila, int columna,String path) {
		String recuperado = preCrearArchivoRecuperar(objeto, fila, columna, path);
		String file = "src/com/Archivos/Temporal.txt";
		File f = new File(file);
		BufferedWriter bw;
		PrintWriter wr;

		try {
			FileWriter w = new FileWriter(f);
			bw = new BufferedWriter(w);
			wr = new PrintWriter(bw);
			wr.write(recuperado);
			wr.close();
			bw.close();

		} catch (IOException e) {
			System.out.println("Hubo Error al escribir el archivoTemporal: "
					+ e);
		}
	}
	
	public String preCrearArchivoRecuperar(String objeto, int fila, int columna,String path){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String recuperado= "";
		String comp = objeto + " " + fila + " " + columna + " " + path;
		try {
			
			archivo = new File("src/com/Archivos/Temporal.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while ((linea = br.readLine()) != null) {	
				if (linea.equals(comp)){
					recuperado += "";
				}else{
					recuperado += linea + "\n";
				}		
			}
			return recuperado;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public String recuperarArchivoTemporal(){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String recuperado= "";
		try {
			
			archivo = new File("src/com/Archivos/Temporal.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while ((linea = br.readLine()) != null) {	
				recuperado += linea + "\n";
			}
			
			
			return recuperado;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public String[][] leerArchivoTemporal() {

		File archivo = null, archivo2 = null;
		FileReader fr = null, fr2 = null;
		BufferedReader br = null, br2 = null;
		int contador = 0;
		int size =0;
		try {
			
			archivo = new File("src/com/Archivos/Temporal.txt");
			archivo2 = new File("src/com/Archivos/Temporal.txt");
			fr = new FileReader(archivo);
			fr2 = new FileReader(archivo2);
			br = new BufferedReader(fr);
			br2 = new BufferedReader(fr2);

			String prueba;
			while ((prueba = br.readLine()) != null) {
				size++;
			}
			
			String adjunto[][] = new String[size][4];
			String linea;
			while ((linea = br2.readLine()) != null) {	
				String ob[] = this.obtenerArchivo(contador+ " " + linea);
				adjunto[contador] = this.obtenerArchivo(contador+ " " + linea);
				contador++;
			}
			
			
			return adjunto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void crearGraficos(Graphics gr2, String[][] objeto){
		for(int i=0; i<objeto.length ; i++ ){
				
				ImageIcon image = new ImageIcon(this.getClass().getResource(objeto[i][4]));
				Image imagen = image.getImage();
				
				if(objeto[i][4].equals("/com/Imagenes/50/mario50.png")){
					System.out.println("dentro de if de path mario MARIOASDIFAJODSFIAJSDOF");
					gr2.drawImage(personaje.getImagen(),personaje.getX(),personaje.getY(), null);
				}else{
					
				gr2.drawImage(imagen, Integer.parseInt(objeto[i][2]),Integer.parseInt(objeto[i][3]) , null);					

				}
		}

		
	}

	public void paint(Graphics grafico) {

		super.paint(grafico);

		Graphics2D gr2 = (Graphics2D) grafico;
		gr2.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);

//		if(koopa.getX()>0 && koopa.getY()>0){
//			if (objeto.equals("Goomba")){
//				
				
				crearGraficos(gr2, leerArchivoTemporal() );
//			}
//		
//		}


		/* creacion de tablero */

		int fila = listao.getDibFila() + 1;
		int columna = listao.getDibColumna() + 1;
		int ancho = 50, alto = 50;


		
		for (int i = 1; i <= fila; i++) {
			gr2.drawLine(50, i * alto, (columna * 50), i * alto); // linea
																		// horizontal
		}

		for (int i = 1; i <= columna; i++) {
			gr2.drawLine(i * ancho, 50, i * ancho, (fila * 50)); // linea
																		// vertical
		}

	}

	public void actionPerformed(ActionEvent e) {
		if(objetosMenu.jRadioButton3.isSelected() && objetosMenu.jRadioButton4.isSelected()){
			this.personaje.mover();
		}
		
		this.repaint();
	}

	private class teclado extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			personaje.keyReleased(e);

		}

		public void keyPressed(KeyEvent e) {
			personaje.keyPressed(e);

		}
	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	
}
