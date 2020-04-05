package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Display {
	public static void main(String[] args) {
		JFrame f = new JFrame("Panel Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new MyPanel(f);
        f.setLayout(null);
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);
        f.add(panel);  
        f.setSize(900,600);    
        f.setLayout(null);    
        f.setVisible(true);
	}
	
}