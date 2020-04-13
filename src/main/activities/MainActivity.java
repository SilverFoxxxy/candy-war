package main.activities;

import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;

import main.grui.ElementSource;

//import main.GrUI.Element;
//import main.sheet.Button;

public class MainActivity extends Activity{
	
	public MainActivity() {
		super();
		activityName = "Main";
		activities.put("Start", new StartActivity());
	}
	
	public void move() {
		ArrayList<String> toErase = new ArrayList<>();
		for (String actName: activities.keySet()) {
			//System.out.println(actName);
			Activity act = activities.get(actName);
			if (act.toRemove) {
				act.clear();
				toErase.add(actName);
			} else {
				act.move();
			}
		}
		for (String actName: toErase) {
			if (activities.containsKey(actName)) {
				activities.remove(actName);
			}
		}
	}
	
	public ElementSource show() {
		elems.clear();
		for (Activity a: activities.values()) {
			elems.add(a.show());
		}
		return elems;
	}
	
	/*public ArrayList<Element> show() {
		return startAct.show();
	}*/
}
