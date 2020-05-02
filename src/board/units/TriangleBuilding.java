package board.units;

import board.Board;

public class TriangleBuilding extends Building {

	public TriangleBuilding(Board board, String Team, String imgID) {
		super(board);
		this.imgID = imgID;
		this.team = Team;
		this.HP = 1200;
		this.imgSize = 1.50;
		// TODO Auto-generated constructor stub
	}
	
}
