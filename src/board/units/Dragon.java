package board.units;

public class Dragon extends Unit {
	
	public Dragon(String team, String imgName) {
		super();
		this.team = team;
		this.imgID = imgName;
		imgSize = 0.5;
		size = 6;
		maxSpeed = 0;
		visionDist = 55;
		targetDist = visionDist;
		atcDist = targetDist;
		maxHP = 300;
		HP = 300;
		ATC = 3;
		maxCoolDown = 35;
		coolDown = maxCoolDown;
		level = 4;
	}
	
	public void hit() {
		if (units.containsKey(targetID)) {
			if (coords.dist(units.get(targetID).coords) <= atcDist &&
					coolDown == 0) {
				String fireballID = "FireBall";
				if (team == "Attack") {
					fireballID = "Blue" + fireballID;
				}
				newUnits.add(new DragonFireBall(coords, units.get(targetID).coords, units.get(targetID).level, team, fireballID));
				coolDown = maxCoolDown;
				//System.out.println("DragonBall");
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
				if (coords.dist(nowUnit.coords) <= minDist &&
						team != nowUnit.team && nowUnit.level <= level) {
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
