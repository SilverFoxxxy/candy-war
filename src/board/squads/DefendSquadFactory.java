package board.squads;

import board.Board;
import board.units.Bear;
import board.units.Dragon;
import board.units.Giant;
import board.units.MainBuilding;
import board.units.TriangleBuilding;
import board.units.Unit;
import main.activities.Point;

public class DefendSquadFactory implements SquadFactory {
	
	private Board board;
	
	public DefendSquadFactory(Board board) {
		this.board = board;
	}
	
	public Squad BearSquad() {
		Squad squad = new Squad();
		while (true) {
			Unit bear = new Bear(board, "Defence", "YellowBear");
			//bear.visionDist = 20;
			if (!squad.add(bear)) {
				break;
			}
		}
		return squad;
	}
	
	public Squad DragonSquad() {
		Squad squad = new Squad();
		while (true) {
			Unit drag = new Dragon(board, "Defence", "Dragon");
			//drag.visionDist = 45;
			if (!squad.add(drag)) {
				break;
			}
			break;
		}
		return squad;
	}
	
	public Squad GiantSquad() {
		Squad squad = new Squad();
		//while (true) {
			Unit giant = new Giant(board, "Defence", "DefGiant");
			squad.add(giant);
			//drag.visionDist = 100000;
			//drag.maxSpeed = 0.075;
			//if (!squad.add(drag)) {
			//	break;
			//}
		//}
		return squad;
	}
	
	public Unit Triangle(Point xy) {
		Unit unit = new TriangleBuilding(board, "Defence", "DefTriangle");
		unit.coords = xy;
		//unit.level = 5;
		return unit;
	}
	
	public Unit MainBuild(Point xy) {
		Unit unit = new MainBuilding(board, "Defence", "DefMain");
		unit.coords = xy;
		//unit.level = 5;
		return unit;
	}
}
