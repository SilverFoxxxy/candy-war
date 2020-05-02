package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.Rectangle;
//import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.awt.geom.Ellipse2D;
//import java.awt.geom.Line2D;
//import java.awt.geom.RoundRectangle2D;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.Vector;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import ImageSource.ImageSource;
import main.GrUI.Element;
import main.grui.ElementSource;

public class MyPanel extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Timer timer = new Timer(30, this);
	
	JFrame frame;
	
	Universe universe = new Universe(this);
	
	ImageSource imgSrc = new ImageSource();
	
	Map <String, JButton> panelButtons = new HashMap<>();
	
	public MyPanel(JFrame frame) {
		this.frame = frame;
		timer.start();
		frame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					universe.keys.add("enter");
				}
				if (key == KeyEvent.VK_SPACE) {
					universe.keys.add("space");
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
			Universe.globalVar.put(name, 1);
			//System.out.println(name + " pressed // globalVar = " + ((int)(Universe.globalVar.get(name))));
		}
	}
	
	public void addButton(Element el) {
		double W = frame.getWidth();
		double H = frame.getHeight() - 20;
		if (H <= 0.) {
			H = 10.;
		}
		JButton button = new JButton((imgSrc.iconSource.get(el.imgID)));
		button.setBounds((int)(el.x0 * W), (int)(el.y0 * H), 
				(int)(el.w * W), (int)(el.h * H));
		ActionListener actlist = new TestActionListener(el.name);
		button.addActionListener(actlist);
		Universe.globalVar.put(el.name, 0);
		panelButtons.put(el.name, button);
		this.add(button);
		this.validate();
		//this.remove(panelButtons.get(el.name));
		//this.validate();
	}
	
	public void removeButton(String elName) {
		if (panelButtons.containsKey(elName)) {
			this.remove(panelButtons.get(elName));
			panelButtons.remove(elName);
		}
		//System.out.println(elName + " removed");
		this.validate();
	}
	
	private void checkButtons(Map <String, Element> m) {
		Vector <String> toRemove = new Vector<>();
		for (String elName: panelButtons.keySet()) {
			if (!m.containsKey(elName)) {
				toRemove.add(elName);
			}
		}
		for (String elName: toRemove) {
			removeButton(elName);
			panelButtons.remove(elName);
		}
	}
	
	public void paint(Graphics g) {
		ElementSource elSource = universe.show();
		Map <String, Element> buttons = elSource.showButtons();
		Vector <Map <String, Element> > elemsVec = elSource.show();
		checkButtons(buttons);
		this.setSize(frame.getSize().width, frame.getSize().height - 10);
		setBackground(Color.lightGray);
		double W = frame.getWidth();
		double H = frame.getHeight() - 20;
		if (H <= 0.) {
			H = 10.;
		}
		Graphics2D g2 = (Graphics2D) g;
		Shape rectShape = new Rectangle(0, 0, frame.getWidth(), frame.getHeight());
		g2.fill(rectShape);
		super.paint(g);
		for (Map<String, Element> elems: elemsVec) {
			for (Element el : elems.values()) {
		        if (el.isButton) {
		        	//System.out.println(el.name);
		        	//System.out.println(el.x0 + " " + el.y0 + " " + el.h + " " + el.w);
					if (!el.buttonAdded && !panelButtons.containsKey(el.name)) {
						addButton(el);
						System.out.println("button added - " + el.name);
						el.buttonAdded = true;
					} else {
						panelButtons.get(el.name).setBounds((int)(el.x0 * W), (int)(el.y0 * H), 
					(int)(el.w * W), (int)(el.h * H));
					}
		        } else {
		        	g.drawImage(imgSrc.imgSource.get(el.imgID), (int)(el.x0 * W), (int)(el.y0 * H),
		        			(int)(el.w * W) + 1, (int)(el.h * H) + 1, null);
				}
			}
		}
		/*g2.setColor(Color.BLUE);
		
		Shape circle = new Ellipse2D.Double(100, 100, 100, 100);
		g2.fill(circle);*/
	}
	
	//public int cnt = 0;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//cnt++;
		//System.out.println(cnt);
		repaint();
		universe.move();
	}
}
