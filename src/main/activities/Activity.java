package main.activities;

import java.util.ArrayList;

import main.sheet.Sheet;

public class Activity {
	double x = 0, y = 0;
	double h = 1, w = 0;
	public ArrayList<Activity> childs = new ArrayList<>();
	public Sheet mainSheet = new Sheet();
}
