package main;

import java.util.ArrayList;

import main.activities.Activity;

public class Universe {
	int singleton = 0;
	//ArrayList <Activity> activities = new ArrayList<>();
	
	Activity activity = new Activity();
	
	public Universe() {
		singleton = 1;
	}
	
	public void move() {
		
	}
}
