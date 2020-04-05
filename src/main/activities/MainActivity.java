package main.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.GrUI.Element;
//import main.sheet.Button;

public class MainActivity extends Activity{
	Map <String, Activity> activities = new HashMap<>();
	
	public MainActivity() {
		super();
		activities.put("Start", new StartActivity());
	}
	
	public void move() {
		
	}
	
	/*public ArrayList<Element> show() {
		return startAct.show();
	}*/
}
