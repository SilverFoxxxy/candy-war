package main.activities;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;

import main.grui.ElementSource;

//import main.GrUI.Element;
//import main.sheet.Button;

public class MainActivity extends Activity{
	
	public MainActivity() {
		super();
		activityName = "Main";
		childActivities.put("Start", new StartActivity());
	}
	
	public void move() {
		/*ArrayList<String> toErase = new ArrayList<>();
		for (String actName: childActivities.keySet()) {
			//System.out.println(actName);
			Activity act = childActivities.get(actName);
			if (act.toRemove) {
				act.clear();
				toErase.add(actName);
			} else {
				act.move();
			}
		}
		for (String actName: toErase) {
			if (childActivities.containsKey(actName)) {
				childActivities.remove(actName);
			}
		}*/
		super.move();
	}
	
	public ElementSource show() {
		//System.out.println(childActivities.size());
		elems.clear();
		for (Activity a: childActivities.values()) {
			elems.add(a.show());
		}
		return elems;
	}
	
	/*public ArrayList<Element> show() {
		return startAct.show();
	}*/
}
