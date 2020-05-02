package board.units;

import java.util.Map;

import board.Board;

public class Giant extends Unit {
	
	public Giant(Board board, String _team, String imgName) {
		super(board);
		HP = 1000;
		ATC = 30;
		level = 3;
		team = _team;
		imgID = imgName;
		imgSize = 0.75;
		maxSpeed = 0.07;
	}
	
	public void hit() {
		Map <Integer, Unit> units = board.units;
		if (units.containsKey(targetID)) {
			if (coords.dist(units.get(targetID).coords) <= atcDist &&
					coolDown == 0) {
				units.get(targetID).HP -= ATC;
				coolDown = maxCoolDown;
			}
			if (coolDown > 0) {
				coolDown--;
			}
		}
	}
	
	private void findTarget() {
		Map <Integer, Unit> units = board.units;
		if (targetID == -1 || !units.containsKey(targetID)) {
			double minDist = 100000000.;
			int lastID = -1;
			for (Unit b: board.buildings) {
				if (coords.dist(b.coords) <= minDist &&
						team != b.team && !b.dead) {
					lastID = b.ID;
					minDist = coords.dist(b.coords);
					//speedXY = 
				}
			}
			targetID = lastID;
		}
	}
	
	private void move2Target() {
		Map <Integer, Unit> units = board.units;
		if (targetID != -1 && units.containsKey(targetID)) {
			if (coords.dist(units.get(targetID).coords) > closeDist) {
				speed = (units.get(targetID).coords.sub(coords));
				speed = speed.Normalize();
				speed = speed.mult(maxSpeed);
				coords = coords.add(speed);
			}
		}
	}
	
	public void move() {
		
		if (HP <= 0) {
			die();
		}
		
		findTarget();
		
		move2Target();
		
	}
	
}
