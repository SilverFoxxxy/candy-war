package board.squads;

import board.units.Bear;
import board.units.Dragon;
import board.units.Unit;
//import board.units.Unit;

public class AttackSquadFactory implements SquadFactory {
	
	public Squad BearSquad() {
		Squad squad = new Squad();
		while (true) {
			Unit bear = new Bear("Attack", "BlueBear");
			bear.visionDist = 100000;
			if (!squad.add(bear)) {
				break;
			}
		}
		return squad;
	}
	
	public Squad DragonSquad() {
		Squad squad = new Squad();
		while (true) {
			Unit drag = new Dragon("Attack", "Dragon");
			drag.visionDist = 100000;
			drag.maxSpeed = 0.075;
			if (!squad.add(drag)) {
				break;
			}
		}
		return squad;
	}
}
