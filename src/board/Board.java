package board;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import board.squads.AttackSquadFactory;
import board.squads.DefendSquadFactory;
import board.squads.SquadFactory;
import board.units.Unit;
import main.GrUI.Element;
import main.Universe;

//import units.*;

public class Board {
	
	public Vector <Map <String, Element> > elemsVec = Universe.elems;
	protected SquadFactory defFact = new DefendSquadFactory();
	protected SquadFactory atcFact = new AttackSquadFactory();
	public double cellSize = 10;
	public int size = 3;
	public int side = 2;
	public int maxID = 0;
	public Cell[][] cells;
	
	public static Map <Integer, Unit> units = new HashMap<>();
	public static Vector<Unit> newUnits = new Vector<>();
	
	public Board(int a) {
		size = a;
		cells = new Cell[size + 2 * side][size + 2 * side];
		for (int i = 0; i < size + 2 * side; i++) {
			for (int j = 0; j < size + 2 * side; j++) {
				cells[i][j] = new Cell();
			}
		}
		cells[size / 2 + side][size / 2 + side].isCastle = true;
		//cells[0][0].isCastle = true;
	}
	
	public void setCell(int x, int y, String type) {
		if (x >= 0 && x < side + size &&
				y >= 0 && y < side + size) {
			cells[x + side][y + side].type = type;
		}
	}
	
	public void move() {}
	
	public void start() {}
}
