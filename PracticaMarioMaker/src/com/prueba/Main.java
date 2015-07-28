package com.prueba;
	import javax.swing.JFrame; 
	import java.awt.Graphics; 

	public class Main extends JFrame 
	{ 
	public Main() 
	{ 
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
	setSize(400,400); 
	setVisible(true); 
	} 

	public void paint(Graphics g) 
	{ 
	super.paint(g); 
	int ancho = 30, alto = 30; 
	for(int i = 1; i <= 10; i++){ 
	g.drawLine(30, i * alto, getSize().width - 100, i * alto); 
	g.drawLine(i * ancho, 30, i * ancho, getSize().height - 100); 
	} 
	} 

	public static void main(String[]args) 
	{ 
	Main m = new Main(); 
	} 
	}
	
	

