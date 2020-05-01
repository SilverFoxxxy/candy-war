package board;

import java.util.ArrayList;

import board.squads.Squad;
import board.squads.noSquad;
import board.units.Unit;

public class Cell {
	public String type = "Ground";
	//public String atcType = "None";
	//public String defType = "None";
	public boolean isCastle = false;
	
	public Squad squad = new noSquad();
	
	public Cell() {
		type = "Ground";
	}
	
	public ArrayList<Unit> init() {
		if (squad.maxsize == 0) {
			return new ArrayList<Unit>();
		}
		ArrayList<Unit> _units = squad.init();
		squad = new noSquad();
		return _units;
	}
}
