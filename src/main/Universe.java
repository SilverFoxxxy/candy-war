package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

//import javax.swing.JPanel;

import main.GrUI.Element;
import main.activities.Activity;
import main.activities.MainActivity;

public class Universe {
	int singleton = 0;
	//ArrayList <Activity> activities = new ArrayList<>();
	
	public static Vector <Map <String, Element> > elems = 
			new Vector<>(Arrays.asList(new HashMap<>(), new HashMap<>(),
				new HashMap<>(), new HashMap<>(), new HashMap<>(),
				new HashMap<>(), new HashMap<>(), new HashMap<>(),
				new HashMap<>()));
	public static Map <String, Integer> globalVar = new HashMap<>();
	
	ArrayList <String> keys = new ArrayList<>();
	
	Activity mainActivity = new MainActivity();
	
	public static MyPanel panel;
	
	public Universe(MyPanel panel) {
		singleton = 1;
	}
	
	public Vector <Map <String, Element> > show() {
		return elems;
	}
	
	public void move() {
		for (String key: keys) {
			if (key == "space") {
				globalVar.put("space", 1);
			}
		}
		mainActivity.move();
	}
}
