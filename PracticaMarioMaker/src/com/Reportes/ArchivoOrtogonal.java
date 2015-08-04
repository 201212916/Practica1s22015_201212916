package com.Reportes;
import com.Listas.*;
import com.Main.CargaObjetos;

import java.io.*;

public class ArchivoOrtogonal {
	
	public ListaO ortogonal;
	
	public ArchivoOrtogonal(ListaO carga) {
		ortogonal = carga;
	}

	public void generarArchivo() {
	
		String file = "src/com/Archivos/Ortogonal.txt";
		String respuesta = "";
		File f = new File(file);
		BufferedWriter bw;
		PrintWriter wr;

		try {
			FileWriter w = new FileWriter(f);
			bw = new BufferedWriter(w);
			wr = new PrintWriter(bw);
			wr.write("digraph G {\n\r");
			wr.write("\tnode [shape=record,width=.1,height=.1];\n\r");
			wr.write("\tnodoTituloSuelo [label = \"Matriz ortogonal\"]\n\r");
			wr.write("\tnodesep=.05;\n\r");
			wr.write("\trankdir=LR;\n\r");
			wr.write("\tnodoR [label = \"{<r>raiz|<s>}\"];\n\r");

			respuesta += this.generarNodos(ortogonal);
			
			System.out.println("1ra repuestas");
			respuesta += this.generarUnionesAsc(ortogonal);
			System.out.println("2da repuestas");
			//respuesta += this.generarUnionesDsc(ortogonal);
			wr.write(respuesta);
			wr.write("}");
			wr.close();
			bw.close();

			this.crearDibujo(file);

		} catch (IOException e) {
			System.out.println("Hubo Error al escribir el archivo: " + e);
		}

	}

	private String generarNodos(ListaO objeto) {
		String retorno = "";
		int nFilas = objeto.getNumFilas() - 1;
		int nColumnas = objeto.getNumColumnas() - 1;
		
		if(objeto.esVacioFila()){
			for (int i = 1; i <= nColumnas; i++) {
				retorno += "\tnodoM" + i + "Null [label = \"{<a>|<n>null|<s>}\"];\n\r";
				retorno += "\tnodoC" + i + " [label = \"{<a>|<c1>Columna " + i + "|<s>}\"];\n\r";
			}			

		}else if (objeto.esVacioColumna()){
			for (int i = 1; i <= nFilas; i++) {
				retorno += "\tnodo" + i + "MNull [label = \"{null}\"];\n\r";
			}			
		}else{
	
			for (int i = 1; i <= nFilas; i++) {
				retorno += "\tnodoF" + i + " [label = \"{<f>Fila " + objeto.buscarNodo(i, 0).getDato() + "|<s>}\"];\n\r";
				retorno += "\tnodo" + i + "MNull [label = \"{null}\"];\n\r";
			}
	
			retorno += "\tnodoFNull [label = \"{<n>null|<s>}\"];\n\r";
	
			for (int i = 1; i <= nColumnas; i++) {
				retorno += "\tnodoC" + i + " [label = \"{<a>|<c1>Columna " + objeto.buscarNodo(0, i).getDato() + "|<s>}\"];\n\r";
				retorno += "\tnodoM" + i + "Null [label = \"{<a>|<n>null|<s>}\"];\n\r";
			}
	
			retorno += "\tnodoCNull [label = \"{null}\"];\n\r";
	
			for (int i = 1; i <= nFilas; i++) {
				for (int j = 1; j <= nColumnas; j++) {
					retorno += "\tnodo" + i + "" + j + " [label = \"{<a>|<o>" 
							+ objeto.buscarNodo(i, j).getDato() +  "|<s>}\"];\n\r";
				}
	
			}
		}
		return retorno;
	}

	private String generarUnionesAsc(ListaO objeto) {
		String retorno = "";
		int nFilas = objeto.getNumFilas() - 1;
		int nColumnas = objeto.getNumColumnas() - 1;

		if(objeto.esVacioFila()){
			retorno += "\tnodoR:r ->Null:f [constraint=false] ;\n\r";
			retorno += "\tnodoR:s -> nodoC" + 1 + ":a ;\n\r";
			
			retorno += "\tedge [color=white];\n\r";
			retorno += "\tNull:s -> nodoM1Null:a;\n\r";

			
			for (int i = 1; i <nColumnas; i++) {
				retorno += "\tedge [color=white];\n\r";
				
				retorno += "\tnodoM" + i + "Null:s -> nodoM" + (i + 1) + "Null:a\n\r";
				retorno += "\tedge [color=black];\n\r";
				
				retorno += "\tnodoC" + i + ":c1-> nodoM" + i + "Null:n  [constraint=false];\n\r";
				retorno += "\tnodoC" + i + ":s -> nodoC" + (i+1) + ":a  ;\n\r";
			}
			retorno += "\tnodoC"+nColumnas+":c1 -> nodoM" + nColumnas + "Null [constraint=false];\n\r";
			retorno += "\tnodoC"+nColumnas+":s -> null ;\n\r";
			
			
		}else if (objeto.esVacioColumna()){
			retorno += "\tnodoR:s -> Null ;\n\r";
			retorno += "\tnodoR:r -> nodoF" + 1 + ":f [constraint=false];\n\r";
			for (int i = 1; i <nFilas; i++) {
				retorno += "\tnodoF" + i + ":f-> nodo" + i + "MNull;\n\r";
				retorno += "\tnodoF" + i + ":f -> nodoF" + (i+1) + ":f  [constraint=false];\n\r";
			}
			retorno += "\tnodoF"+nFilas+":f -> nodo" + nFilas + "MNull;\n\r";
			retorno += "\tnodoF"+nFilas+":f -> null [constraint=false];\n\r";
			

			
		}else{
		
		
		// Asignacion de nodos principales y nulos
		retorno += "\tnodoR:r -> nodoF1:f [constraint=false];\n\r";
		for (int i = 1; i < nFilas; i++) {
			retorno += "\tnodoF" + i + ":f-> nodoF" + (i + 1) + ":f [constraint=false];\n\r";
		}
		retorno += "\tnodoF" + nFilas + ":f-> nodoFNull [constraint=false];\n\r";

		retorno += "\tnodoR:s -> nodoC1:a;\n\r";
		for (int i = 1; i < nColumnas; i++) {
			retorno += "\tnodoC" + i + ":s -> nodoC" + (i + 1) + ":a;\n\r";
		}
		retorno += "\tnodoC" + nColumnas + ":s-> nodoCNull;\n\r";

		// Asignacion de nodos de subindice

		for (int i = 1; i <= nFilas; i++) {
			retorno += "\tnodoF" + i + ":s -> nodo" + i + "1:a;\n\r";
			for (int j = 1; j < nColumnas; j++) {
				retorno += "\tnodo" + i + "" + j + ":s -> nodo" + i + "" + (j + 1) + ":a;\n\r";
			}

		}

		for (int i = 1; i <= nColumnas; i++) {
			retorno += "\tnodoC" + i + ":c -> nodo1" + i + ":o [constraint = false];\n\r";
			for (int j = 1; j < nFilas; j++) {
				retorno += "\tnodo" + j + "" + i + ":c -> nodo" + (j + 1) + "" + i + ":o  [constraint = false];\n\r";
			}

		}

		// Asignacion de nodos nulos

		for (int i = 1; i < nFilas; i++) {
			retorno += "\tnodo" + i + "" + nColumnas + ":s -> nodo" + i + "MNull;\n\r";
		}
		retorno += "\tnodo" + nFilas + "" + nColumnas + ":s -> nodo" + nFilas + "MNull;\n\r";

		retorno += "\tedge [color=white];\n\r";
		retorno += "\tnodoFNull:s -> nodoM1Null:a;\n\r";

		for (int i = 1; i < nColumnas; i++) {
			retorno += "\tedge [color=white];\n\r";
			retorno += "\tnodoM" + i + "Null:s -> nodoM" + (i + 1) + "Null:a\n\r";
			retorno += "\tedge [color=black];\n\r";
			retorno += "\tnodo" + nFilas + "" + i + ":c -> nodoM" + i + "Null [constraint=false];\n\r";
		}
		retorno += "\tnodo" + nFilas + "" + nColumnas + ":c -> nodoM" + nColumnas + "Null  [constraint=false] ;\n\r";

		retorno += this.generarUnionesDsc(objeto);
		
		}
		return retorno;		
	}

	private String generarUnionesDsc(ListaO objeto) {
		String retorno = "";
		int nFilas = objeto.getNumFilas() - 1;
		int nColumnas = objeto.getNumColumnas() - 1;

		// Asignacion de nodos principales

		for (int i = nFilas; i > 1; i--) {
			retorno += "\tnodoF" + i + ":f-> nodoF" + (i - 1) + ":f [constraint=false];\n\r";
		}
		retorno += "\tnodoF1:f-> nodoR:r [constraint=false];\n\r";

		for (int i = nColumnas; i > 1; i--) {
			retorno += "\tnodoC" + i + ":a -> nodoC" + (i - 1) + ":s;\n\r";
		}
		retorno += "\tnodoC1:a-> nodoR:s;\n\r";

		// Asignacion de nodos de subindice

		for (int i = nFilas; i >= 1; i--) {
			retorno += "\tnodo" + i + "1:a -> nodoF" + i + ":a;\n\r";
			for (int j = nColumnas; j > 1; j--) {
				retorno += "\tnodo" + i + "" + j + ":a -> nodo" + i + "" + (j - 1) + ":s;\n\r";
			}
		}

		for (int i = nColumnas; i >= 1; i--) {
			retorno += "\tnodo1" + i + ":c -> nodoC" + i
					+ ":o [constraint = false];\n\r";
			for (int j = nFilas; j > 1; j--) {
				retorno += "\tnodo" + j + "" + i + ":o -> nodo" + (j - 1) + "" + i + ":c  [constraint = false];\n\r";
			}
		}
		return retorno;
	}

	private void crearDibujo(String path) {
		try {

			//String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
			String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

			String fileInputPath = path;
			String fileOutputPath = "src/com/Archivos/Ortogonal.jpg";

			String tParam = "-Tjpg";
			String tOParam = "-o";

			String[] cmd = new String[5];
			cmd[0] = dotPath;
			cmd[1] = tParam;
			cmd[2] = fileInputPath;
			cmd[3] = tOParam;
			cmd[4] = fileOutputPath;

			Runtime rt = Runtime.getRuntime();

			rt.exec(cmd);

			System.out.println("Cree el dibujo");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		}

	}
	

}
