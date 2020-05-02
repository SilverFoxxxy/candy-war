package board;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Vector;
import java.util.Map;
import java.util.Random;

import board.units.Unit;
import main.GrUI.Element;
import main.activities.FrontBoardActivity;
import main.activities.Point;
import main.grui.ElementSource;
import testrandom.TestRandom;

public class Battlefield extends Board {
	
	public Map <String, Double> prices = FrontBoardActivity.prices;
	
	public Map <String, Integer> globalVar = new HashMap<>();
	
	public String nowUnit = "";
	
	public Battlefield(int sz) {
		super(sz);
		int n = size;
		for (int i = 0; i < size; i++) {
			cells[i][0].squad = defFact.BearSquad();
			cells[i][size - 1].squad = atcFact.BearSquad();
		}
		cells[n - 1][n - 1].squad = atcFact.DragonSquad();
		cells[0][0].squad = defFact.DragonSquad();
	}
	
	//buildings = new Vector<Unit>();
	
	private void addBuildings() {
		double n = size;
		buildings.add(atcFact.Triangle(((new Point(1. / n, (n - 0.5) / n))).mult(size * cellSize)));
		buildings.add(atcFact.Triangle((new Point((n - 1.) / n, (n - 0.5) / n)).mult(size * cellSize)));
		buildings.add(defFact.Triangle((new Point(1. / n, 0.5 / n)).mult(size * cellSize)));
		buildings.add(defFact.Triangle((new Point((n - 1.) / n, 0.5 / n)).mult(size * cellSize)));
		buildings.add(atcFact.MainBuild((new Point(1. / 2, (n - 0.5) / n)).mult(size * cellSize)));
		buildings.add(defFact.MainBuild((new Point(1. / 2, 0.5 / n)).mult(size * cellSize)));
		for (Unit b: buildings) {
			addUnit(b);
		}
	}
	
	public void start() {
		addBuildings();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
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
		double n = size;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				elems.add("Сell" + i + " " + j,
						new Element(("cell" + i) + j,
								i / n, j / n, 1. / n, 1. / n,
								false, "Chocolate", false, 2));
			}
		}
		
		for (int unitID: units.keySet()) {
			Unit unit = units.get(unitID);
			Point coords = unit.coords;
			coords = coords.mult(1./ ((size) * cellSize));
			double unitSize = unit.imgSize * (1. / n);
			elems.add("Unit" + unitID, new Element("Unit" + unitID,
						coords.x - unitSize / 2, coords.y - unitSize / 2, unitSize, unitSize,
						false, unit.imgID, false, unit.level));
		}
		
		/*for (int i = 0; i < buildings.size(); i++) {
			Unit b = buildings.get(i);
			Point coords = b.coords;
			//coords = coords.mult(1./ ((size) * cellSize));
			double unitSize = b.imgSize * (1. / n);
			//System.out.println(b.imgID + " coords");
			//System.out.println(coords.x + " " + coords.y);
			elems.add("Building" + i, new Element("Building" + i,
						coords.x - unitSize / 2, coords.y - unitSize / 2, unitSize, unitSize,
						false, b.imgID, false, b.level));
		}*/
	}
	
	private void checkBuildings() {
		int atcCnt = 0;
		int defCnt = 0;
		for (Unit b: buildings) {
			if (!b.dead) {
				if (b.team == "Attack") {
					atcCnt++;
				} else {
					defCnt++;
				}
			}
		}
		if (atcCnt == 0) {
			gameover = true;
		}
		if (defCnt == 0) {
			youWin = true;
			gameover = true;
		}
	}
	
	public ElementSource show() {
		return elems;
	}
	
	private void checkButtons() {
		for (int i = 0; i < size; i++) {
			String _key = "putUnit" + i;
			if (globalVar.containsKey(_key) && globalVar.get(_key) == 1) {
				//System.out.println("HEHHEHEHE");
				globalVar.put(_key, 0);
				//System.out.println(atcFact.SquadByName(nowUnit).maxsize);
				cells[i][size - 1].squad = atcFact.SquadByName(nowUnit);
				//System.out.println(atcFact.SquadByName(nowUnit).maxsize);
				nowUnit = "";
				Cell nowCell = cells[i][size - 1];
				int _i = i;
				int _j = size - 1;
				//System.out.println(nowCell.squad.maxsize);
				ArrayList<Unit> newUnits = nowCell.init();
				for (Unit unit: newUnits) {
					unit.coords = (new Point(cellSize * _i, cellSize * _j)).add(
							(unit.coords).mult(cellSize));
					//System.out.println(unit.coords.x + " " + unit.coords.y);
					//TODO Norma()
					addUnit(unit);
				}
			}
		}
		if (nowUnit != "") {
			double n = size;
			for (int i = 0; i < size; i++) {
				//System.out.println("buttons added");
				elems.add(new Element("putUnit" + i, i/n, 1. - 1./n, 1./n, 1./n, true, "putUnit", true, 7));
				elems.add(new Element("_putUnit" + i, i/n, 1. - 1./n, 1./n, 1./n, true, "putUnit", false, 7));
			}
		}
	}
	
	private double mana = 0.;
	private double maxMana = 10.;
	private int chosen = -1;
	private String chosenName = "";
	
	private void oppositeMove() {
		mana += 0.015;
		if (mana >= maxMana) {
			mana = maxMana;
		}
		if (chosen == -1) {
			chosen = TestRandom.randInRange(0, 10000);
			chosen %= prices.size();
			//System.out.println(chosen);
		}
		int kek = 0;
		for (String name: prices.keySet()) {
			if (kek == chosen) {
				chosenName = name;
			}
			kek++;
		}
		if (prices.containsKey(chosenName) && mana >= prices.get(chosenName) + 1.) {
			chosen = -1;
			mana -= prices.get(chosenName) + 1.;
			int i = TestRandom.randInRange(0, 10000);
			//System.out.println(i);
			i %= size;
			cells[i][0].squad = defFact.SquadByName(chosenName);
			//System.out.println(atcFact.SquadByName(nowUnit).maxsize);
			//System.out.println(chosenName);
			chosenName = "";
			Cell nowCell = cells[i][0];
			int _i = i;
			int _j = 0;
			
			ArrayList<Unit> newUnits = nowCell.init();
			for (Unit unit: newUnits) {
				unit.coords = (new Point(cellSize * _i, cellSize * _j)).add(
						(unit.coords).mult(cellSize));
				//System.out.println(unit.coords.x + " " + unit.coords.y);
				//TODO Norma()
				addUnit(unit);
			}
			
			//System.out.println("OHOHOHOHOHOHO");
		}
	}
	
	public void move() {
		elems.clear();
		addUnits();
		
		oppositeMove();
		
		killUnits();
		
		moveUnits();
		
		drawBoard();
		
		hitUnits();
		
		checkBuildings();
		
		checkButtons();
	}
	
	public void clear() {
		//TODO
	}
}
