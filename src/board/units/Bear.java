package board.units;

import java.util.Map;

import board.Board;

public class Bear extends Unit{
	public Bear(Board board) {
		super(board);
	}
	
	public Bear(Board board, String team, String imgName) {
		super(board);
		this.team = team;
		this.imgID = imgName;
		imgSize = 0.2;
		maxSpeed = 0.1;
		level = 3;
		maxHP = 100;
		HP = 100;
		ATC = 10;
		maxCoolDown = 20;
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
		if (units.containsKey(targetID)) {
			if (coords.dist(units.get(targetID).coords) > visionDist) {
				targetID = -1;
			}
		} else {
			targetID = -1;
		}
		if (targetID == -1) {
			double minDist = visionDist;
			int lastID = -1;
			for (int unitID: units.keySet()) {
				Unit nowUnit = units.get(unitID);
				if (nowUnit.level == level && coords.dist(nowUnit.coords) <= minDist &&
						team != nowUnit.team) {
					lastID = unitID;
					minDist = coords.dist(nowUnit.coords);
					//speedXY = 
				}
			}
			targetID = lastID;
		}
		if (targetID == -1) {
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
		if (targetID != -1) {
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
