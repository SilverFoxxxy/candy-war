package board.units;

import java.util.Map;

import board.Board;
import main.activities.Point;

public class DragonFireBall extends Unit {
	double x0, y0, targetX, targetY;
	int targetLevel = 5;
	Point coords0;
	Point coords1;
	public DragonFireBall(Board board, Point coords0, Point coords1, int level, String team, String imgName) {
		super(board);
		this.team = team;
		imgID = imgName;
		imgSize = 0.35;
		this.coords = new Point(x0, y0);
		this.coords0 = coords0;
		this.coords1 = coords1;
		this.level = 5;
		this.targetLevel = level;
		this.atcDist = 5;
		maxHP = 1;
		HP = 1;
		ATC = 35;
		maxCoolDown = 20;
		coolDown = maxCoolDown;
	}
	
	public void hit() {
		if (coolDown == 0) {
			Map <Integer, Unit> units = board.units;
			for (Unit unit: units.values()) {
				if (unit.team != team && unit.level == targetLevel && coords.dist(unit.coords) <= atcDist) {
					unit.HP -= ATC;
				}
			}
			coolDown = maxCoolDown;
			die();
		}
		coolDown--;
		//System.out.println("fire " + coolDown);
	}
	
	public void move() {
		coords = (coords0.mult(coolDown)).add(coords1.mult((maxCoolDown - coolDown))).mult(1. / maxCoolDown);
		//System.out.println(coords.x);
	}
}
