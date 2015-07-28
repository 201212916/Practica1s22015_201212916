package com.Main;
import com.Creacion.*;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Panel;


public class MenuMaker extends JFrame {
	
	public MenuMaker(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new Crear());
		setTitle("Escenario");
		setSize(1940, 1080);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(281, 152, 384, 188);
		getContentPane().add(panel);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setBounds(139, 90, 107, 22);
		getContentPane().add(mnNewMenu);
	}
}