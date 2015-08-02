package com.Escenarios;

import com.Listas.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class E_Objetos extends JFrame implements ActionListener {
	    JButton boton1;
	    ListaO o;
	    
	    public E_Objetos() {

	        setBounds(0,0,1100,200);
	        setVisible(true);
	        setLocationRelativeTo(null);
	        getContentPane().setLayout(null);	    	
	    	o = new ListaO();
	    	o.iniciarMatriz();
	    	
	    	

	        boton1=new JButton("Finalizar");
	        boton1.setBounds(350,10,100,30);
	        getContentPane().add(boton1);
	        
	        JLabel lblFormaDeSacar = new JLabel("Forma de sacar Objetos");
	        lblFormaDeSacar.setBounds(24, 48, 143, 21);
	        getContentPane().add(lblFormaDeSacar);
	        
	        JRadioButton rdbtnMetodoPila = new JRadioButton("Metodo Pila");
	        rdbtnMetodoPila.setBounds(58, 102, 109, 23);
	        getContentPane().add(rdbtnMetodoPila);
	        
	        JRadioButton rdbtnMetodoCola = new JRadioButton("Metodo Cola");
	        rdbtnMetodoCola.setBounds(58, 76, 109, 23);
	        getContentPane().add(rdbtnMetodoCola);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.WHITE);
	        panel.setBounds(173, 50, 75, 75);
	        getContentPane().add(panel);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(Color.WHITE);
	        panel_1.setBounds(258, 50, 75, 75);
	        getContentPane().add(panel_1);
	        
	        JPanel panel_2 = new JPanel();
	        panel_2.setBackground(Color.WHITE);
	        panel_2.setBounds(343, 50, 75, 75);
	        getContentPane().add(panel_2);
	        
	        JPanel panel_3 = new JPanel();
	        panel_3.setBackground(Color.WHITE);
	        panel_3.setBounds(428, 50, 75, 75);
	        getContentPane().add(panel_3);
	        
	        JPanel panel_4 = new JPanel();
	        panel_4.setBackground(Color.WHITE);
	        panel_4.setBounds(513, 50, 75, 75);
	        getContentPane().add(panel_4);
	        
	        JPanel panel_5 = new JPanel();
	        panel_5.setBackground(Color.WHITE);
	        panel_5.setBounds(598, 50, 75, 75);
	        getContentPane().add(panel_5);
	        
	        JPanel panel_6 = new JPanel();
	        panel_6.setBackground(Color.WHITE);
	        panel_6.setBounds(683, 50, 75, 75);
	        getContentPane().add(panel_6);
	        
	        JPanel panel_7 = new JPanel();
	        panel_7.setBackground(Color.WHITE);
	        panel_7.setBounds(768, 50, 75, 75);
	        getContentPane().add(panel_7);
	        
	        JMenu mnArchivo = new JMenu("Archivo");
	        mnArchivo.setBounds(0, 0, 107, 22);
	        getContentPane().add(mnArchivo);
	        
	        JMenuItem mntmSalir = new JMenuItem("Salir");
	        mnArchivo.add(mntmSalir);

	        
	        
	        
	        
	        
	        boton1.addActionListener(this);
	        

	    }
	    
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource()==boton1) {
	            o.agregarColumna();
	        }
	    }
	}


