package board.units;

import board.Board;

public class MainBuilding extends Building {

	public MainBuilding(Board board, String Team, String imgID) {
		super(board);
		this.imgID = imgID;
		this.team = Team;
		this.HP = 2500;
		this.imgSize = 2.;
		// TODO Auto-generated constructor stub
	}
}
