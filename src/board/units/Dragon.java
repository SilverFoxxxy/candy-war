package board.units;

import java.util.Map;
import java.util.Vector;

import board.Board;

public class Dragon extends Unit {
	
	public Dragon(Board board, String team, String imgName) {
		super(board);
		this.team = team;
		this.imgID = imgName;
		imgSize = 0.5;
		size = 6;
		maxSpeed = 0.15;
		visionDist = 55;
		atcDist = visionDist;
		maxHP = 300;
		HP = 300;
		ATC = 3;
		maxCoolDown = 35;
		coolDown = maxCoolDown;
		level = 4;
	}
	
	public void hit() {
		Map <Integer, Unit> units = board.units;
		Vector <Unit> newUnits = board.newUnits;
		if (units.containsKey(targetID)) {
			if (coords.dist(units.get(targetID).coords) <= atcDist &&
					coolDown == 0) {
				String fireballID = "FireBall";
				if (team == "Attack") {
					fireballID = "Blue" + fireballID;
				}
				newUnits.add(new DragonFireBall(board, coords, units.get(targetID).coords, units.get(targetID).level, team, fireballID));
				coolDown = maxCoolDown;
				//System.out.println("DragonBall");
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
				if (coords.dist(nowUnit.coords) <= minDist &&
						team != nowUnit.team && nowUnit.level != 5) {
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
