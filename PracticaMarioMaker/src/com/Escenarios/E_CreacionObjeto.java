package com.Escenarios;
import javax.swing.JFrame;

import java.awt.event.ActionListener;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class E_CreacionObjeto extends JFrame {
	private JTextField textField;
	public E_CreacionObjeto() {
        setBounds(0,0,300,300);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        JLabel lblNuevoObjeto = new JLabel("Nuevo Objeto");
        lblNuevoObjeto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblNuevoObjeto.setBounds(23, 11, 126, 28);
        getContentPane().add(lblNuevoObjeto);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Goomba", "Koopa", "Pared", "Suelo", "Moneda", "Hongo Vida"}));
        comboBox.setBounds(33, 56, 114, 20);
        getContentPane().add(comboBox);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(33, 99, 46, 14);
        getContentPane().add(lblNombre);
        
        JButton boton1=new JButton("Agregar");
        boton1.setBounds(89,172,100,28);
        getContentPane().add(boton1);
        
   

	}
}
