package com.Escenarios;
import com.Listas.*;
import com.Reportes.*;
import com.Main.*;
import com.Pojos.*;
import com.Nodos.*;
import com.Creacion.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class E_ObjetosMenu extends javax.swing.JFrame {

    public static ListaO o;
    public E_CreacionObjeto crearObjeto; 
    public E_EditarObjeto editarObjeto;
    public E_EditarJugador editarJugador;
    public E_ResumenObjeto resumenObjeto;
    public E_EliminarObjeto eliminarObjeto;
    public E_Juego juego;
    public ArchivoListas archivoL;
    public ArchivoOrtogonal archivoO;
    public ArchivoRecuperar archivoR;
    public ArchivoRecuperarOrtogonal archivoRO;
    public ArchivoImagen archivoI;
    public CargaObjetos carga;
    public static CrearTablero c;
        
    public E_ObjetosMenu() {
        initComponents();
        
        
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/com/Imagenes/fondo.jpg"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());

        
        
        
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (pantalla.width - 1100)/2;
        setBounds(width, 5, 1100, 200);
        
        setResizable(false);
        
        crearObjeto = new E_CreacionObjeto();
        editarObjeto = new E_EditarObjeto();
        editarJugador = new E_EditarJugador();
        juego = new E_Juego();
        archivoI = new ArchivoImagen();
        o = new ListaO();
        carga = new CargaObjetos();
        carga.ejecutar();
        o.iniciarMatriz();
        c = new CrearTablero();
        resumenObjeto = new E_ResumenObjeto();
        eliminarObjeto = new E_EliminarObjeto();
        archivoL = new ArchivoListas();
        archivoO = new ArchivoOrtogonal(o);     
        archivoR = new ArchivoRecuperar();
        archivoRO = new ArchivoRecuperarOrtogonal();
        archivoL.generarArchivo();
        archivoO.generarArchivo();
        
        jRadioButton1.setSelected(true);
        jRadioButton3.setSelected(true);
      
//        jButton6.setSize(75, 75);
//        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource(carga.getPojoPersonaje().getImagenPath())));

    }
    
    
    public int validarCadena(String cadena){
    	Pattern pat = Pattern.compile("[1-9]");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
        	return Integer.parseInt(cadena);
        } else {
        	return 201212916;
        }
    }
    
    	public void limpiarArchivoTemporal(){
		String file = "src/com/Archivos/Temporal.txt";
		File f = new File(file);
		BufferedWriter bw;
		PrintWriter wr;

		try {
			FileWriter w = new FileWriter(f);
			bw = new BufferedWriter(w);
			wr = new PrintWriter(bw);
			wr.write("");
			wr.close();
			bw.close();

		} catch (IOException e) {
			System.out.println("Hubo Error al escribir el archivoTemporal: "
					+ e);
		}

	}
        
        public void eliminarItems(int fila, int columna){
            String objmat = o.buscarNodo(fila, columna).getDato().toString();
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
					
						carga.getRecuperarOrtogonal().agregarNodo(objmat);
						c.crearArchivoRecuperar(objel, columna*50, fila*50,path);
						archivoRO.generarArchivo();	
        
    
        }

    public ListaO getO() {
		return o;
	}


	public void setO(ListaO o) {
		this.o = o;
	}


	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setBounds(new java.awt.Rectangle(133, 5, 1100, 200));
        setResizable(false);

        jRadioButton1.setText("Modo Pila");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Modo Cola");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Forma de sacar objetos");

        jButton1.setText("Agregar fila");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar columna");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar fila");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar columna");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/75/goomba75.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/75/koopa75.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/75/mario75.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/75/pared75.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/75/moneda75.PNG"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/75/vida75.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/75/castillo75.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/75/suelo75.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Agregar objeto");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("Eliminar objeto");
        jRadioButton4.setFocusable(false);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Objetos");

        jMenuItem2.setText("Agregar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem5.setText("Modificar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem9.setText("Eliminar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");

        jMenuItem6.setText("Imagen Lista Objetos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Imagen Matriz Ortogonal");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Vista");

        jMenuItem8.setText("Resumen de objetos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuItem10.setText("Objetos eliminados de listas");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuItem11.setText("Objetos eliminados de matriz");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuBar1.add(jMenu6);

        jMenu4.setText("Jugador");

        jMenuItem3.setText("Editar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ayuda");

        jMenuItem4.setText("Creditos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton1))
                    .addComponent(jLabel1))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton4)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    	crearObjeto.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        editarObjeto.ejecutar();
        editarObjeto.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        editarJugador.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if((o.getNumFilas()-1) < 9){
            o.agregarFila();
            archivoO.generarArchivo();
        }else{
            JOptionPane.showMessageDialog(null, "Numero maximo de filas es 9");   
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if ((o.getNumColumnas()-1)<20){
            o.agregarColumna();
            archivoO.generarArchivo();
        }else{
            JOptionPane.showMessageDialog(null, "Numero maximo de columnas es 20");   
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        archivoI.abrirImagenLista();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        archivoI.abrirImagenOrtogonal();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

		
		if (o.esVacioColumna() || o.esVacioFila()) {
			JOptionPane.showMessageDialog(null, "Matriz ortogonal vacia");
		} else {
			String seleccion = JOptionPane.showInputDialog(null,
					"Ingrese numero de fila", JOptionPane.QUESTION_MESSAGE);

			int fila = this.validarCadena(seleccion);

			if (fila != 201212916 && fila < o.getNumFilas()) {
                            for(int i=1; i<o.getNumColumnas();i++){
                                if(!o.buscarNodo(fila, i).getDato().equals("null")){
                                    this.eliminarItems(fila, i);
                                }
                            }
				o.eliminarFila(fila);
				archivoO.generarArchivo();
                                
                                
                                
			} else {
				JOptionPane.showMessageDialog(
						null,
						"Indice de fila invalido, indices validos: 1-" + (o.getNumFilas() - 1));
			}

		}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
		
    	if (o.esVacioColumna() || o.esVacioFila()) {
			JOptionPane.showMessageDialog(null, "Matriz ortogonal vacia");
		} else {
			String seleccion = JOptionPane.showInputDialog(null, "Ingrese numero de Columna",
					JOptionPane.QUESTION_MESSAGE);
			
			int columna = this.validarCadena(seleccion);
                    if (columna != 201212916 && columna < o.getNumColumnas()){
                    	for(int i=1; i<o.getNumFilas();i++){
                            if(!o.buscarNodo(i, columna).getDato().equals("null")){
                                this.eliminarItems(i, columna);
                            }
                        }
                            o.eliminarColumna(columna);
                            archivoO.generarArchivo();
                    }else{
                            JOptionPane.showMessageDialog(null, "Indice de columna invalido, indices validos: 1-" + (o.getNumColumnas()-1));
                    }
		}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //carga un goomba
    	if(!carga.getGoomba().esVacio()){
	    	if (carga.getTemporal().esVacio()){
                    if(jRadioButton1.isSelected()){
                        carga.getRecuperar().agregarNodo(carga.getGoomba().getNodo(carga.getGoomba().getSize()).getDato());
		        carga.getTemporal().agregarNodo(carga.getGoomba().removePila());                        
                    }else{
                        carga.getRecuperar().agregarNodo(carga.getGoomba().getNodo(1).getDato());
		        carga.getTemporal().agregarNodo(carga.getGoomba().removeCola());                        
                    }
                        archivoR.generarArchivo();
		        archivoL.generarArchivo();
	    	}else{
				JOptionPane.showMessageDialog(null, "Ya tiene un objeto Goomba seleccionado");
	    	}
    	}else{
                JOptionPane.showMessageDialog(null, "La lista de Goombas esta vacia");            
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //cargar el personaje
    	if(!carga.getJugador().esVacio()){
	    	if (carga.getTemporal().esVacio()){
                    
                    if(jRadioButton1.isSelected()){
                        carga.getRecuperar().agregarNodo(carga.getJugador().getNodo(carga.getJugador().getSize()).getDato());
		        carga.getTemporal().agregarNodo(carga.getJugador().removePila());
                    }else{
                        carga.getRecuperar().agregarNodo(carga.getJugador().getNodo(1).getDato());
		        carga.getTemporal().agregarNodo(carga.getJugador().removeCola());                        
                    }
                        archivoR.generarArchivo();
		        archivoL.generarArchivo();
	    	}else{
                    JOptionPane.showMessageDialog(null, "Ya tiene un objeto Jugador seleccionado");
	    	}
    	}else{
                JOptionPane.showMessageDialog(null, "Solo se puede agregar un personaje");            
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.limpiarArchivoTemporal();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //carga de un koopa
        if(!carga.getKoopa().esVacio()){
	    	if (carga.getTemporal().esVacio()){
                    if(jRadioButton1.isSelected()){
                        carga.getRecuperar().agregarNodo(carga.getKoopa().getNodo(carga.getKoopa().getSize()).getDato());
		        carga.getTemporal().agregarNodo(carga.getKoopa().removePila());                        
                    }else{
                        carga.getRecuperar().agregarNodo(carga.getKoopa().getNodo(1).getDato());
		        carga.getTemporal().agregarNodo(carga.getKoopa().removeCola());                        
                    }
                        archivoR.generarArchivo();
		        archivoL.generarArchivo();
	    	}else{
                    JOptionPane.showMessageDialog(null, "Ya tiene un objeto Koopa seleccionado");
	    	}
    	}else{
                JOptionPane.showMessageDialog(null, "La lista de Koopas esta vacia");            
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //Carga de una moneda
        if(!carga.getMoneda().esVacio()){
	    	if (carga.getTemporal().esVacio()){
                    if(jRadioButton1.isSelected()){
                        carga.getRecuperar().agregarNodo(carga.getMoneda().getNodo(carga.getMoneda().getSize()).getDato());
		        carga.getTemporal().agregarNodo(carga.getMoneda().removePila());                        
                    }else{
                        carga.getRecuperar().agregarNodo(carga.getMoneda().getNodo(1).getDato());
		        carga.getTemporal().agregarNodo(carga.getMoneda().removeCola());                        
                    }
                        archivoR.generarArchivo();
		        archivoL.generarArchivo();
	    	}else{
                    JOptionPane.showMessageDialog(null, "Ya tiene un objeto Moneda seleccionado");
	    	}
    	}else{
                JOptionPane.showMessageDialog(null, "La lista de Monedas esta vacia");            
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        //Cargar hongo vida
        
        if(!carga.getVida().esVacio()){
	    	if (carga.getTemporal().esVacio()){
                    if(jRadioButton1.isSelected()){
                        carga.getRecuperar().agregarNodo(carga.getVida().getNodo(carga.getVida().getSize()).getDato());
		        carga.getTemporal().agregarNodo(carga.getVida().removePila());                        
                    }else{
                        carga.getRecuperar().agregarNodo(carga.getVida().getNodo(1).getDato());
		        carga.getTemporal().agregarNodo(carga.getVida().removeCola());                        
                    }
                        archivoR.generarArchivo();
		        archivoL.generarArchivo();
	    	}else{
                    JOptionPane.showMessageDialog(null, "Ya tiene un objeto Hongo vida seleccionado");
	    	}
    	}else{
                JOptionPane.showMessageDialog(null, "La lista de Hongo vida esta vacia");            
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        //carga de suelo
        if(!carga.getSuelo().esVacio()){
	    	if (carga.getTemporal().esVacio()){
                    if(jRadioButton1.isSelected()){
                        carga.getRecuperar().agregarNodo(carga.getSuelo().getNodo(carga.getSuelo().getSize()).getDato());
		        carga.getTemporal().agregarNodo(carga.getSuelo().removePila());                        
                    }else{
                        carga.getRecuperar().agregarNodo(carga.getSuelo().getNodo(1).getDato());
		        carga.getTemporal().agregarNodo(carga.getSuelo().removeCola());                        
                    }
                        archivoR.generarArchivo();
		        archivoL.generarArchivo();
	    	}else{
                    JOptionPane.showMessageDialog(null, "Ya tiene un objeto Suelo seleccionado");
	    	}
    	}else{
                JOptionPane.showMessageDialog(null, "La lista de Suelo esta vacia");            
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        //carga de pared
        if(!carga.getPared().esVacio()){
	    	if (carga.getTemporal().esVacio()){
                    if (jRadioButton1.isSelected()){
                        carga.getRecuperar().agregarNodo(carga.getPared().getNodo(carga.getPared().getSize()).getDato());
		        carga.getTemporal().agregarNodo(carga.getPared().removePila());                        
                    }else{
                        carga.getRecuperar().agregarNodo(carga.getPared().getNodo(1).getDato());
		        carga.getTemporal().agregarNodo(carga.getPared().removeCola());                        
                    }
                        archivoR.generarArchivo();
		        archivoL.generarArchivo();
	    	}else{
                    JOptionPane.showMessageDialog(null, "Ya tiene un objeto Pared seleccionado");
	    	}
    	}else{
                JOptionPane.showMessageDialog(null, "La lista de Pared esta vacia");            
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        //carga de castillo
        if(!carga.getCastillo().esVacio()){
	    	if (carga.getTemporal().esVacio()){
                    if(jRadioButton1.isSelected()){
                        carga.getRecuperar().agregarNodo(carga.getCastillo().getNodo(carga.getCastillo().getSize()).getDato());
		        carga.getTemporal().agregarNodo(carga.getCastillo().removePila());                        
                    }else{
                        carga.getRecuperar().agregarNodo(carga.getCastillo().getNodo(1).getDato());
		        carga.getTemporal().agregarNodo(carga.getCastillo().removeCola());                        
                    }
                        archivoR.generarArchivo();
		        archivoL.generarArchivo();
	    	}else{
                    JOptionPane.showMessageDialog(null, "Ya tiene un objeto Castillo seleccionado");
	    	}
    	}else{
                JOptionPane.showMessageDialog(null, "Solo se puede agregar un castillo");            
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected()){
            jRadioButton2.setSelected(false);
            jRadioButton1.setSelected(true);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton2.isSelected()){
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(true);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
            JOptionPane.showMessageDialog(null, "Realizado por: Pablo David Say Garcia \n Carne: 201212916");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
    	resumenObjeto.actualizar();
        resumenObjeto.show();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        eliminarObjeto.ejecutar();
    	eliminarObjeto.show();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        archivoI.abrirImagenRecuperar();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        archivoI.abrirImagenRecuperarOrtogonal();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if(jRadioButton3.isSelected()){
            jRadioButton4.setSelected(false);
            jRadioButton3.setSelected(true);
            
            jButton6.setEnabled(true);
            jButton7.setEnabled(true);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);
            jButton10.setEnabled(true);
            jButton11.setEnabled(true);
            jButton12.setEnabled(true);
            jButton13.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        if(jRadioButton4.isSelected()){
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(true);
            
            jButton6.setEnabled(false);
            jButton7.setEnabled(false);
            jButton8.setEnabled(false);
            jButton9.setEnabled(false);
            jButton10.setEnabled(false);
            jButton11.setEnabled(false);
            jButton12.setEnabled(false);
            jButton13.setEnabled(false);
            
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    public javax.swing.JRadioButton jRadioButton3;
    public javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}
