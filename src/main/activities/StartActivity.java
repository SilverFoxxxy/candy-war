package main.activities;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ImageIcon;

import main.GrUI;
import main.Universe;
import main.GrUI.Element;
import main.sheet.Button;

public class StartActivity extends Activity{
	//Button start;
	//ArrayList<Element> elems;
	public StartActivity() {
		//super();
		elems.put("Start", new Element("Start", 1/3., 1/3., 1/3., 1/3., true, 0, true));
		//super.Activity();
		//Image imgStart = new ImageIcon("res/img/start.png").getImage();
		//start = new Element("Start", 0.4, 0.4, 0.2, 0.2, imgStart, true);
		
	}
	
	public void move() {
		
	}
	/*public ArrayList<Element> show() {
		return elems;
	}*/
}
