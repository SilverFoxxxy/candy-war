package main.activities;

import main.GrUI.Element;

public class StartActivity extends Activity{
	
	public StartActivity() {
		super();
		activityName = "Start";
		elemsVec.get(1).put("Start", new Element("Start", 1/3., 1/3., 1/3., 1/3., true, "YellowBear", true));
	}
	
	public void move() {
		if (globalVar.containsKey("Start")) {
			if (globalVar.get("Start") == 1) {
				toRemove = true;
				removeElem("Start");
				//System.out.println("startt remove");
				activities.put("Test", new TestBoardActivity());
			}
		}
	}
	/*public ArrayList<Element> show() {
		return elems;
	}*/
}
