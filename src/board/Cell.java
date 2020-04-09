package board;

import java.util.ArrayList;

import board.squads.Squad;
import board.units.Unit;

public class Cell {
	public String type = "Groung";
	//public String atcType = "None";
	//public String defType = "None";
	public boolean isCastle = false;
	
	public Squad squad;
	
	public Cell() {
		type = "Ground";
	}
	
	public ArrayList<Unit> init() {
		return squad.init();
	}
}
