package board.units;

public class Bear extends Unit{
	public Bear() {
		super();
	}
	public Bear(String team, String imgName) {
		super();
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
	
	public void move() {
		if (HP <= 0) {
			die();
		}
		if (units.containsKey(targetID)) {
			if (coords.dist(units.get(targetID).coords) > targetDist) {
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
		if (targetID != -1) {
			if (coords.dist(units.get(targetID).coords) > closeDist) {
				speed = (units.get(targetID).coords.sub(coords));
				speed = speed.Normalize();
				speed = speed.mult(maxSpeed);
				coords = coords.add(speed);
			}
		}
	}
}
