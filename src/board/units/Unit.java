package board.units;

import board.Board;
import main.activities.Point;

public class Unit {
	
	// static maxID?
	
	public Board board;
	
	public int ID = -1;
	
	protected int targetID = -1;
	
	public String imgID = "Start";
	
	public String type;
	
	public double imgSize = 1;
	
	// highness of the minion:
	
	public int level = 1;
	
	public String team = "Attack";
	
	// vision - where the minion can see its targets
	// atcDist - can attack
	// closeDist - if further -> move closer
	
	public double visionDist = 20;
	
	public double atcDist = 5;
	
	public double closeDist = 3;
	
	public int maxCoolDown = 10;
	
	public int coolDown = 0;
	
	public int maxHP = 100;
	
	public int HP = 0;
	
	public int ATC = 10;
	
	public double maxSpeed = 0.1;
	
	public Point speed = new Point(0, 0);
	
	public Point coords;
	
	public int size = 2;
	
	public boolean dead = false;
	
	public Unit(Board board) {
		this.board = board;
	}
	
	public Unit(int kek) {}
	
	public void die() {
		dead = true;
	}
	
	public void hit() {}
	
	public void move() {}
}
