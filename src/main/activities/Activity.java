package main.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

//import main.GrUI;
import main.GrUI.Element;
import main.Universe;
import main.sheet.Sheet;

public class Activity {
	double x = 0, y = 0;
	double h = 1, w = 0;
	public String activityName;
	public static Vector <Map <String, Element> > elemsVec = Universe.elems;
	public static Map <String, Integer> globalVar = Universe.globalVar;
	protected static Map <String, Activity> activities = new HashMap<>();
	public ArrayList<Activity> childs;
	public Sheet mainSheet;
	boolean toRemove = false;
	//public static GrUI grui;
	
	public Activity(){
		x = 0; y = 0;
		h = 1; w = 0;
		childs = new ArrayList<>();
	}
	
	public void move() {}
	
	public void show() {}
	
	public void clear() {}
	
	public static void removeElem(String elemName) {
		for (Map <String, Element> elems: elemsVec) {
			if (elems.containsKey(elemName)) {
				elems.get(elemName).toRemove = true;
			}
		}
	}
}
