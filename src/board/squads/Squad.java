package board.squads;

import java.util.ArrayList;

import board.units.Unit;
import main.activities.Point;
import testrandom.TestRandom;

public class Squad {
	int maxsize = 12;
	public int size = 0;
	private ArrayList<Unit> units = new ArrayList<>();
	
	public Squad() {}
	
	public boolean add(Unit unit) {
		if (unit.size + size <= maxsize) {
			size += unit.size;
			unit.coords = new Point(TestRandom.randInRange(1, 9) / 10., 
					TestRandom.randInRange(1, 9) / 10.);
			units.add(unit);
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Unit> init() {return units;}
}
