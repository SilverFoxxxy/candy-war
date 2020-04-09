package board.squads;

import board.units.Bear;
import board.units.Dragon;
import board.units.Unit;

public class DefendSquadFactory implements SquadFactory {
	
	public DefendSquadFactory() {}
	
	public Squad BearSquad() {
		Squad squad = new Squad();
		while (true) {
			Unit bear = new Bear("Defense", "YellowBear");
			bear.visionDist = 20;
			if (!squad.add(bear)) {
				break;
			}
		}
		return squad;
	}
	
	public Squad DragonSquad() {
		Squad squad = new Squad();
		while (true) {
			Unit drag = new Dragon("Defense", "Dragon");
			drag.visionDist = 45;
			if (!squad.add(drag)) {
				break;
			}
		}
		return squad;
	}
	
}
