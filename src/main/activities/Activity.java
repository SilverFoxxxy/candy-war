package main.activities;

import java.util.ArrayList;
import java.util.Map;

import main.GrUI;
import main.GrUI.Element;
import main.Universe;
import main.sheet.Sheet;

public class Activity {
	double x = 0, y = 0;
	double h = 1, w = 0;
	public Map <String, Element> elems;
	public Map <String, Integer> globalVar;
	public ArrayList<Activity> childs;
	public Sheet mainSheet;
	//public static GrUI grui;
	
	public Activity(){
		x = 0; y = 0;
		h = 1; w = 0;
		childs = new ArrayList<>();
		globalVar = Universe.globalVar;
		elems = Universe.elems;
		//grui = new GrUI();
		Sheet mainSheet = new Sheet();
	}
	
	public void move() {}
	
	public ArrayList<GrUI.Element> show() {
		ArrayList<GrUI.Element> elems = new ArrayList<>();
		return elems;
	}
	
}
