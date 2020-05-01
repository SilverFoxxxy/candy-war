package board;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import board.squads.AttackSquadFactory;
import board.squads.DefendSquadFactory;
import board.squads.SquadFactory;
import board.units.Unit;
//import main.GrUI.Element;
//import main.Universe;
import main.grui.ElementSource;

//import units.*;

public class Board {
	
	protected ElementSource elems;
	
	public boolean gameover = false;
	public boolean youWin = false;
	public double cellSize = 10;
	public int size = 3;
	public int side = 2;
	public Cell[][] cells;
	public Vector<Unit> buildings = new Vector<Unit>(); 
	
	protected SquadFactory defFact = new DefendSquadFactory(this);
	protected SquadFactory atcFact = new AttackSquadFactory(this);
	
	public Map <Integer, Unit> units = new HashMap<>();
	public Vector<Unit> newUnits = new Vector<>();
	public int maxID = 0;
	
	private void initCells() {
		cells = new Cell[size + 2 * side][size + 2 * side];
		for (int i = 0; i < size + 2 * side; i++) {
			for (int j = 0; j < size + 2 * side; j++) {
				cells[i][j] = new Cell();
			}
		}
	}
	
	public Board(int a) {
		elems = new ElementSource();
		size = a;
		initCells();
		//cells[0][0].isCastle = true;
	}
	
	protected void addUnit(Unit unit) {
		unit.ID = maxID;
		units.put(maxID, unit);
		maxID++;
	}
	
	public void addNewUnit(Unit unit) {
		newUnits.add(unit);
	}
	
	protected void setCell(int x, int y, String type) {
		if (x >= 0 && x < side + size &&
				y >= 0 && y < side + size) {
			cells[x + side][y + side].type = type;
		}
	}
	
	public ElementSource show() {
		return new ElementSource();
	}
	
	public void move() {}
	
	public void start() {}
	
	public void clear() {}
}
