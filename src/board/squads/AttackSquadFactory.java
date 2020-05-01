package board.squads;

import board.Board;
import board.units.Bear;
import board.units.Dragon;
import board.units.MainBuilding;
import board.units.TriangleBuilding;
import board.units.Unit;
//import board.units.Unit;
import main.activities.Point;

public class AttackSquadFactory implements SquadFactory {
	
	private Board board;
	
	public AttackSquadFactory(Board board) {
		this.board = board;
	}
	
	public Squad BearSquad() {
		Squad squad = new Squad();
		while (true) {
			Unit bear = new Bear(board, "Attack", "BlueBear");
			//bear.visionDist = 100000;
			if (!squad.add(bear)) {
				break;
			}
		}
		return squad;
	}
	
	public Squad DragonSquad() {
		Squad squad = new Squad();
		while (true) {
			Unit drag = new Dragon(board, "Attack", "Dragon");
			//drag.visionDist = 100000;
			//drag.maxSpeed = 0.075;
			if (!squad.add(drag)) {
				break;
			}
		}
		return squad;
	}
	
	public Squad SquadByName(String name) {
		if (name == "BearUnit") {
			System.out.println("bear");
			return BearSquad();
		} else {
			System.out.println("dear");
			return DragonSquad();
		}
	}
	
	public Unit Triangle(Point xy) {
		Unit unit = new TriangleBuilding(board, "Attack", "AtcTriangle");
		unit.coords = xy;
		//unit.level = 5;
		return unit;
	}
	
	public Unit MainBuild(Point xy) {
		Unit unit = new MainBuilding(board, "Attack", "AtcMain");
		unit.coords = xy;
		//unit.level = 5;
		return unit;
	}
}
