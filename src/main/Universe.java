package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.GrUI.Element;
import main.activities.Activity;
import main.activities.MainActivity;

public class Universe {
	int singleton = 0;
	//ArrayList <Activity> activities = new ArrayList<>();
	
	public static Map <String, Element> elems = new HashMap<>();
	public static Map <String, Integer> globalVar = new HashMap<>();
	
	ArrayList <String> keys = new ArrayList<>();
	
	Activity mainActivity = new MainActivity();
	
	//Map <String, Integer> lobalVar = new HashMagp<>();
	
	public Universe() {
		singleton = 1;
		//elems = new HashMap<>();
		//globalVar = new HashMap<>();
		//Map <String, Element> kek = elems;
		//kek.put("Start", new Element("Start", 1/3., 1/3., 1/3., 1/3., true, 0, true));
		//elems.put("Start", new Element("Start", 1/3., 1/3., 1/3., 1/3., true, 0, true));
		
	}
	
	public Map <String, Element> show() {
		return elems;
	}
	
	public void move() {
		
	}
}
