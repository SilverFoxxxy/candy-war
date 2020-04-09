package board;

import java.util.ArrayList;

//import board.units.Dragon;
import board.units.Unit;
import main.GrUI.Element;

public class TestBoard extends Board {
	public TestBoard(int sz) {
		super(sz);
		/*for (int i = 0; i < side * 2 + size; i++) {
			for (int j = 0; j < side * 2 + size; j++) {
				if ((i + j) % 2 == 0) {
					cells[i][j].squad = atcFact.BearSquad();
				} else {
					cells[i][j].squad = defFact.BearSquad();
				}
			}
		}*/
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
	
	private void addUnit(Unit unit) {
		units.put(maxID, unit);
		maxID++;
	}
	
	public void start() {
		/*Unit drag = new Dragon("Defense", "Dragon");
		drag.coords = new Point((2 * side + size) * cellSize / 2.,
				(2 * side + size) * cellSize / 2.);
		units.put(-2, drag);
		Unit drag1 = new Dragon("Attack", "Dragon");
		drag1.visionDist = 100000;
		drag1.maxSpeed = 0.15;
		drag1.closeDist = 25;
		drag1.coords = new Point(2.,
				2.);
		units.put(-3, drag1);*/
		for (int i = 0; i < 2 * side + size; i++) {
			for (int j = 0; j < 2 * side + size; j++) {
				ArrayList<Unit> newUnits = cells[i][j].init();
				for (Unit unit: newUnits) {
					unit.coords = (new Point(cellSize * i, cellSize * j)).add(
							(unit.coords).mult(cellSize));
					//TODO Norma()
					units.put(maxID, unit);
					maxID++;
				}
				
			}
		}
	}
	
	public void move() {
		for (Unit unit: newUnits) {
			addUnit(unit);
		}
		newUnits.clear();
		double n = 2 * side + size;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				//System.out.println(i + " " + j);
				elemsVec.get(2).put("cell" + i + " " + j, new Element(("cell" + i) + j, i / n, j / n, 1 / n, 1 / n, false, "Chocolate", false, 2));
			}
		}
		
		ArrayList <Integer> toDie = new ArrayList<>();
		for (int unitID: units.keySet()) {
			Unit unit = units.get(unitID);
			if (unit.dead) {
				toDie.add(unitID);
			}
		}
		for (int unitID: toDie) {
			elemsVec.get(units.get(unitID).level).remove("Unit" + unitID);
			units.remove(unitID);
		}
		for (int unitID: units.keySet()) {
			Unit unit = units.get(unitID);
			unit.move();
		}
		for (int unitID: units.keySet()) {
			Unit unit = units.get(unitID);
			//System.out.println(unitID);
			Point coords = unit.coords;
			coords = coords.mult(1./ ((side * 2 + size) * cellSize));
			//System.out.println(coords.x);
			double unitSize = unit.imgSize * (1. / n);
			elemsVec.get(unit.level).put("Unit" + unitID, new Element("Unit" + unitID,
						coords.x - unitSize / 2, coords.y - unitSize / 2, unitSize, unitSize,
						false, unit.imgID, false, unit.level));
			/*if (unit.team == "Attack") {
				elemsVec.get(3).put("Unit" + unitID, new Element("Unit" + unitID,
						coords.x - unitSize / 2, coords.y - unitSize / 2, unitSize, unitSize,
						false, 1, false, 2));
			} else {
				elemsVec.get(3).put("Unit" + unitID, new Element("Unit" + unitID,
						coords.x - unitSize / 2, coords.y - unitSize / 2, unitSize, unitSize,
						false, 2, false, 2));
			}*/
		}
		for (int unitID: units.keySet()) {
			Unit unit = units.get(unitID);
			unit.hit();
		}
	}
}
