package com.Reportes;

import com.Main.*;
import com.Listas.*;

import java.io.*;

public class ArchivoListas {
	
	CargaObjetos carga;

	public ArchivoListas() {
		carga = new CargaObjetos();
	}

	public void generarArchivo() {
		String file = "src/com/Archivos/Listas.txt";
		String respuesta="";
		File f = new File(file);
		BufferedWriter bw;
		PrintWriter wr;

		try {
			FileWriter w = new FileWriter(f);
			bw = new BufferedWriter(w);
			wr = new PrintWriter(bw);
			wr.write("digraph G {\n\r");
			wr.write("\tnodesep=.05;\n\r");
			wr.write("\trankdir=LR;\n\r");
			wr.write("\tnode [shape=record,width=.1,height=.1];\n\r");

			respuesta += this.preGenerarArchivo(carga.getSuelo(), "Suelo");
			respuesta += this.preGenerarArchivo(carga.getPared(), "Pared");
			respuesta += this.preGenerarArchivo(carga.getVida(), "Vida");
			respuesta += this.preGenerarArchivo(carga.getMoneda(), "Moneda");
			respuesta += this.preGenerarArchivo(carga.getKoopa(), "Koopa");
			respuesta += this.preGenerarArchivo(carga.getGoomba(), "Goomba");
			respuesta += this.preGenerarArchivo(carga.getCastillo(), "Castillo");
			respuesta += this.preGenerarArchivo(carga.getJugador(), "Personaje");

			wr.write(respuesta);
			wr.write("}");
			wr.close();
			bw.close();

			this.crearDibujo(file);

		} catch (IOException e) {
			System.out.println("Hubo Error al escribir el archivo: " + e);
		}

	}

	private String preGenerarArchivo(ListaD objeto, String prefijo) {
		
		String retorno = "";
		retorno += "\tnodoTitulo" + prefijo + " [label = \"Lista " + prefijo + "\"]\n\r";
		retorno += "\tnodo" + prefijo + "0 [label = \"{Raiz |<s>}\"];\n\r";

		int size = objeto.getSize();

		// Crea los nodos con el nombre del objeto dentro
		for (int i = 1; i <= size; i++) {
			retorno += "\tnodo" + prefijo + "" + i + " [label = \"{<a>|"
					+ objeto.getNodo(i).getDato() + "|<s>}\"];\n\r";
		}
		
		retorno += "\tnodoNull" + prefijo + " [label = \"<n>null\"]\n\r";

		// Asigna los nodos creados a otros y los relaciona
		if (size == 0) {
			retorno += "\tnodo" + prefijo + "0:s -> nodoNull" + prefijo + ":n;\n\r";
		} else {
			for (int i = 0; i < size; i++) {
				retorno += "\tnodo" + prefijo + "" + i + ":s -> nodo" + prefijo + "" + (i + 1) + ":a;\n\r";
			}

			for (int i = size; i > 0; i--) {
				retorno += "\tnodo" + prefijo + "" + i + ":a -> nodo" + prefijo + "" + (i - 1) + ":s;\n\r";
			}

			retorno += "\tnodo" + prefijo + "" + size + ":s -> nodoNull" + prefijo + ":n;\n\r";
		}
		return retorno;
	}

	private void crearDibujo(String path) {
		try {

			//String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
			String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

			String fileInputPath = path;
			String fileOutputPath = "src/com/Archivos/Listas.jpg";

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
