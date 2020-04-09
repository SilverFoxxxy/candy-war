package board.units;

import java.util.Map;
import java.util.Vector;

import board.Board;
import board.Point;

public class Unit {
	//TODO id
	//protected Board board;
	protected Map<Integer, Unit> units = null;
	
	protected Vector<Unit> newUnits = new Vector<>();
	
	protected int targetID = -1;
	
	public String imgID = "Start";
	
	public double imgSize = 1;
	
	protected int ID = -1;
	
	public int targetLevel = 1;
	
	public int level = 1;
	
	public String team = "Attack";
	
	public double visionDist = 20;
	
	public double targetDist = 15;
	
	public double atcDist = 5;
	
	public double closeDist = 3;
	
	public int maxCoolDown = 10;
	
	public int maxHP = 100;
	
	public double maxSpeed = 0.1;
	
	public int coolDown = 0;
	
	public int HP = 0;
	
	public int ATC = 10;
	
	public Point speed = new Point(0, 0);
	
	public Point coords;
	
	public int size = 2;
	
	public boolean dead = false;
	
	public Unit() {
		units = Board.units;
		newUnits = Board.newUnits;
	}
	
	public void die() {
		dead = true;
	}
	
	public void hit() {}
	
	//Point coords;
	public void move() {}
}
