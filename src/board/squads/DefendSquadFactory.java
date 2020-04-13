package board.squads;

import board.Board;
import board.units.Bear;
import board.units.Dragon;
import board.units.Unit;

public class DefendSquadFactory implements SquadFactory {
	
	private Board board;
	
	public DefendSquadFactory(Board board) {
		this.board = board;
	}
	
	public Squad BearSquad() {
		Squad squad = new Squad();
		while (true) {
			Unit bear = new Bear(board, "Defense", "YellowBear");
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
			Unit drag = new Dragon(board, "Defense", "Dragon");
			drag.visionDist = 45;
			if (!squad.add(drag)) {
				break;
			}
		}
		return squad;
	}
	
}
