package com.Main;
import com.Creacion.*;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MenuMaker extends JFrame {
	
	public MenuMaker(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Crear());
		setTitle("Escenario");
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
	}
}