package com.Reportes;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ArchivoImagen {

	public ArchivoImagen(){
		
	}
	
	public void abrirImagenLista(){
		try {
		     File path = new File ("src/com/Archivos/Listas.jpg");
		     Desktop.getDesktop().open(path);
		}catch (IOException ex) {
		     ex.printStackTrace();
		}	
	}
	
	public void abrirImagenOrtogonal(){
		try {
		     File path = new File ("src/com/Archivos/Ortogonal.jpg");
		     Desktop.getDesktop().open(path);
		}catch (IOException ex) {
		     ex.printStackTrace();
		}	
	}
        
        public void abrirImagenRecuperar(){
		try {
		     File path = new File ("src/com/Archivos/Recuperar.jpg");
		     Desktop.getDesktop().open(path);
		}catch (IOException ex) {
		     ex.printStackTrace();
		}	
	}
        
        public void abrirImagenRecuperarOrtogonal(){
		try {
		     File path = new File ("src/com/Archivos/RecuperarOrtogonal.jpg");
		     Desktop.getDesktop().open(path);
		}catch (IOException ex) {
		     ex.printStackTrace();
		}	
	}
	
}
