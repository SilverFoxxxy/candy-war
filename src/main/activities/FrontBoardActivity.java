package main.activities;

import java.util.HashMap;
import java.util.Map;

import main.GrUI.Element;
import main.grui.ElementSource;

public class FrontBoardActivity extends Activity{
	
	BattlefieldActivity battlefield = new BattlefieldActivity();
	UnitsPanel uPanel = new UnitsPanel();
	double mana = 0.;
	double maxMana = 10.;
	String nowUnit = "";
	Map <String, Double> prices = new HashMap<>();
	
	private void initPrices() {
		prices.put("BearUnit", 2.);
		prices.put("DragonUnit", 6.);
	}
	
	public FrontBoardActivity() {
		super();
		initPrices();
		start();
	}
	
	public void start() {
		super.start();
		childActivities.put(battlefield.activityName, battlefield);
		childActivities.put(uPanel.activityName, uPanel);
	}
	
	private void checkButtons() {
		if (globalVar.containsKey("Cancel") && globalVar.get("Cancel") == 1) {
			globalVar.put("Cancel", 0);
			if (prices.containsKey(battlefield.nowUnit)) {
				mana += prices.get(battlefield.nowUnit);
				if (mana >= maxMana) {
					mana = maxMana;
				}
			}
			battlefield.nowUnit = "";
			nowUnit = "";
			for (String bName: uPanel.buttons) {
				if (globalVar.containsKey(bName) && globalVar.get(bName) == 1) {
					globalVar.put(bName, 0);
				}
			}
		}
		for (String bName: uPanel.buttons) {
			if (globalVar.containsKey(bName) && globalVar.get(bName) == 1) {
				nowUnit = bName;
				globalVar.put(bName, 0);
			}
		}
	}
	
	public void move() {
		if (prices.containsKey(nowUnit)) {
			if (mana >= prices.get(nowUnit)) {
				mana -= prices.get(nowUnit);
				battlefield.nowUnit = nowUnit;
				nowUnit = "";
			}
		}
		super.move();
		if (battlefield.nowUnit == "") {
			nowUnit = "";
		}
		mana += 0.015;
		if (mana >= maxMana) {
			mana = maxMana;
		}
		checkButtons();
	}
	
	private void showMana() {
		elems.add(new Element("mana", 1. - 1./30, 1. - mana / maxMana, 1./30, mana / maxMana, true, "Start", false));
	}
	
	public ElementSource show() {
		elems.clear();
		elems.add(super.show());
		showMana();
		//System.out.println(child);
		return elems;
	}
}
