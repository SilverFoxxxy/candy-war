package board.squads;

import board.units.Unit;
import main.activities.Point;

public interface SquadFactory {
	
	//public Factory() {}
	
	public default Squad BearSquad() {return new Squad();}
	
	public default Squad DragonSquad() {return new Squad();}
	
	public default Squad GiantSquad() {return new Squad();}
	
	public default Squad SquadByName(String name) {
		switch (name) {
		case "BearUnit":
			return BearSquad();
		case "DragonUnit":
			return DragonSquad();
		case "GiantUnit":
			return GiantSquad();
		default:
			return new Squad();
		}
	}
	
	public default Unit Triangle(Point xy) {return new Unit(0);}
	
	public default Unit MainBuild(Point xy) {return new Unit(0);}
	
}
