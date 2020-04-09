package main.activities;

import board.Board;
import board.TestBoard;

public class TestBoardActivity extends Activity {
	
	private Board testBoard;
	
	public TestBoardActivity() {
		super();
		activityName = "Test";
		testBoard = new TestBoard(7);
		
		testBoard.start();
		//TODO button to start the process
		
		/*if (globalVar.containsKey("StartTest")) {
			if (globalVar.get("StartTest") == 1) {
				testBoard.start();
			}
		}*/
		
	}
	
	public void move() {
		testBoard.move();
	}
	
	//public void show() {
	//	
	//}
}
