package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import ImageSource.ImageSource;
import main.GrUI.Element;
//import main.MyPanel.TestActionListener;
import main.Main.TestActionListener;

public class MyPanel extends JPanel implements ActionListener {
	
	Timer timer = new Timer(30, this);
	
	JFrame frame;
	
	Universe universe = new Universe();
	
	ImageSource imgSrc = new ImageSource();
	
	public MyPanel(JFrame frame) {
		this.frame = frame;
		
		//this.setSize(frame.getSize());
		
	    //this.validate();
	    //this.setBounds(10, 10, 20, 20);
	    //this.setBackground(Color.gray);
	    //this.setVisible(true);
	    //this.validate();
	    //frame.validate();
		timer.start();
		frame.addKeyListener(new KeyAdapter() {


			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					universe.keys.add("enter");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
		});
	}
	
	public class TestActionListener implements ActionListener {
		TestActionListener(String name) {
			this.name = name;
		}
		String name;
		public void actionPerformed(ActionEvent e) {
			universe.globalVar.put(name, 1);
		}
	}
	
	public void addButton(Element el) {
		double W = frame.getWidth();
		double H = frame.getHeight();
		JButton button = new JButton((imgSrc.iconSource.get(el.imgID)));
		button.setBounds((int)(el.x0 * W), (int)(el.y0 * H), 
				(int)(el.w * W), (int)(el.h * H));
		ActionListener actlist = new TestActionListener(el.name);
		button.addActionListener(actlist);
		this.add(button);
		this.validate();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//setBackground(Color.WHITE);
		Map <String, Element> elems = universe.show();
		double W = frame.getWidth();
		double H = frame.getHeight();
		for (Element el : elems.values()) {
	        //System.out.println(entry.getKey() + ":" + entry.getValue());
			//g.drawImage(imgSrc.imgSource.get(0), (int)(0 * W), (int)(0 * H), (int)(W), (int)(H), null);
			if (el.isButton) {
				if (!el.buttonAdded) {
					addButton(el);
					el.buttonAdded = true;
				} else {
					//if (el.toRemove) {
					//	
					//}
				}
			}else {
				g.drawImage(imgSrc.imgSource.get(el.imgID), (int)(el.x0 * W), (int)(el.y0 * H), (int)(el.w * W), (int)(el.h * H), null);
			}
		}
		/*g2.setColor(Color.BLUE);
		
		Shape circle = new Ellipse2D.Double(100, 100, 100, 100);
		g2.fill(circle);*/
		super.paint(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		universe.move();
	}
}
