package board.units;

import board.Board;

public class Building extends Unit {
	
	public Building(Board board) {
		super(board);
		this.level = 6;
		maxSpeed = 0.;
	}
	
	public void move() {
		if (HP <= 0) {
			dead = true;
		}
	}
	
	public void hit() {}
}
