package main.activities;

import java.util.Map;
import java.util.Vector;

import main.GrUI.Element;
import main.grui.ElementSource;

public class UnitsPanel extends Activity {
	
	Vector <String> buttons = new Vector<>();
	Vector <Boolean> pressed = new Vector<>();
	
	public UnitsPanel() {
		super();
		activityName = "UnitsPanel";
		start();
		x = 3./4.;
		y = 0.;
		w = 1. - x;
		h = 1.;
	}
	
	private void addButtons() {
		double n = buttons.size();
		if (buttons.size() == 0) {
			n = 1.;
		}
		for (int i = 0; i < buttons.size(); i++) {
			String name = buttons.get(i);
			pressed.add(false);
			elems.add(name, new Element(name, 0, i / n, 1., 1./ n, true, name, true, 0));
		}
	}
	
	public void updButtons(Map <String, Double> prices, double mana) {
		elems.clear();
		start(prices);
		double n = buttons.size();
		for (int i = 0; i < buttons.size(); i++) {
			String name = buttons.get(i);
						if (prices.containsKey(name) && mana < prices.get(name)) {
				elems.add(name, new Element(name, 0, i / n, 1., 1./ n, true, "Cancel", false, 0));
			} else {
				elems.add(name, new Element(name, 0, i / n, 1., 1./ n, true, name, true, 0));
			}
		}
	}
	
	public void start(Map <String, Double> prices) {
		//buttons.add("BearUnit");
		//buttons.add("DragonUnit");
		//buttons.add("GiantUnit");
		buttons = new Vector<>();
		for (String name: prices.keySet()) {
			buttons.add(name);
			pressed.add(false);
		}
		buttons.add("Cancel");
		//addButtons();
	}
	
	
	
	public void move() {
		
	}
	
	public ElementSource show() {
		return elems;
	}
}
