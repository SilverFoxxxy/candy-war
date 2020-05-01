package main.activities;

//import java.util.ArrayList;
//import java.util.Vector;
//import main.GrUI;
//import main.GrUI.Element;
import main.Universe;
//import main.sheet.Sheet;
import main.grui.ElementSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Activity {
	double x = 0, y = 0;
	double h = 1, w = 1;
	public String activityName;
	public ElementSource elems;
	public Vector <Activity> toAdd2Parent = new Vector<>();
	protected Map <String, Activity> childActivities = new HashMap<>();
	boolean toRemove = false;
	protected ArrayList<String> keys2Remove = new ArrayList<>();
	public static Map <String, Integer> globalVar = Universe.globalVar;
	
	//public static GrUI grui;
	//public ArrayList<Activity> childs;
	//public Sheet mainSheet;
	
	public Activity(){
		x = 0; y = 0;
		h = 1; w = 0;
		elems = new ElementSource();
		//childs = new ArrayList<>();
	}
	
	public void start() {}
	
	protected void removeChilds() {
		for (String key: keys2Remove) {
			if (childActivities.containsKey(key)) {
				Activity act = childActivities.get(key);
				act.clear();
				childActivities.remove(key);
				//System.out.println("removed " + key);
			}
		}
		keys2Remove = new ArrayList<>();
	}
	
	public void move() {
		keys2Remove = new ArrayList<>();
		Vector<Activity> toAdd = new Vector<>();
		for (String key: childActivities.keySet()) {
			Activity act = childActivities.get(key);
			toAdd.addAll(act.toAdd2Parent);
			act.toAdd2Parent.clear();
			if (act.toRemove) {
				keys2Remove.add(key);
			} else {
				act.move();
			}
		}
		for (Activity act: toAdd) {
			childActivities.put(act.activityName, act);
		}
		removeChilds();
	}
	
	public ElementSource show() {
		ElementSource elems = new ElementSource();
		for (Activity act: childActivities.values()) {
			ElementSource elemSource = act.show().copy();
			Point xy0 = new Point(act.x, act.y);
			Point wh = new Point(act.w, act.h);
			elemSource.setShape(xy0, wh);
			elems.add(elemSource);
		}
		return elems;
	}
	
	public void clear() {}
	
}
