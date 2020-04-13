package board;

import java.util.ArrayList;

//import board.units.Dragon;
import board.units.Unit;
import main.GrUI.Element;
import main.activities.Point;
import main.grui.ElementSource;

public class TestBoard extends Board {
	public TestBoard(int sz) {
		super(sz);
		int n = side * 2 + size;
		for (int i = 0; i < side * 2 + size; i++) {
			for (int j = 0; j < side * 2 + size; j++) {
				if (i < side || i >= side + size ||
						j < side || j >= side + size) {
					cells[i][j].squad = atcFact.BearSquad();
				} else {
					cells[i][j].squad = defFact.BearSquad();
				}
			}
		}
		cells[n / 2][n / 2].squad = defFact.DragonSquad();
		cells[0][0].squad = atcFact.DragonSquad();
	}
	
	public void start() {
		for (int i = 0; i < 2 * side + size; i++) {
			for (int j = 0; j < 2 * side + size; j++) {
				ArrayList<Unit> newUnits = cells[i][j].init();
				for (Unit unit: newUnits) {
					unit.coords = (new Point(cellSize * i, cellSize * j)).add(
							(unit.coords).mult(cellSize));
					//TODO Norma()
					addUnit(unit);
				}
			}
		}
	}
	
	private void addUnits() {
		for (Unit unit: newUnits) {
			addUnit(unit);
		}
		newUnits.clear();
	}
	
	private void remove(Unit unit) {
		elems.remove("Unit" + unit.ID);
		int unitID = unit.ID;
		if (units.containsKey(unitID)) {
			units.remove(unitID);
		}
	}
	
	private void killUnits() {
		ArrayList <Unit> toDie = new ArrayList<>();
		for (int unitID: units.keySet()) {
			Unit unit = units.get(unitID);
			if (unit.dead) {
				toDie.add(unit);
			}
		}
		for (Unit unit: toDie) {
			remove(unit);
		}
	}
	
	private void moveUnits() {
		for (int unitID: units.keySet()) {
			Unit unit = units.get(unitID);
			unit.move();
		}
	}
	
	private void hitUnits() {
		for (int unitID: units.keySet()) {
			Unit unit = units.get(unitID);
			unit.hit();
		}
	}
	
	private void drawBoard() {
		double n = size + 2 * side;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				elems.add("Сell" + i + " " + j,
						new Element(("cell" + i) + j,
								i / n, j / n, 1 / n, 1 / n,
								false, "Chocolate", false, 2));
			}
		}
		
		for (int unitID: units.keySet()) {
			Unit unit = units.get(unitID);
			Point coords = unit.coords;
			coords = coords.mult(1./ ((side * 2 + size) * cellSize));
			double unitSize = unit.imgSize * (1. / n);
			elems.add("Unit" + unitID, new Element("Unit" + unitID,
						coords.x - unitSize / 2, coords.y - unitSize / 2, unitSize, unitSize,
						false, unit.imgID, false, unit.level));
		}
	}
	
	public ElementSource show() {
		return elems;
	}
	
	public void move() {
		
		addUnits();
		
		killUnits();
		
		moveUnits();
		
		drawBoard();
		
		hitUnits();
	}
	
	public void clear() {
		//TODO
	}
}
