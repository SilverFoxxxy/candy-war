package main.activities;

import board.Board;
import board.TestBoard;
//import testrandom.TestRandom;

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
		/*if (globalVar.containsKey("space")) {
			if (globalVar.get("space") == 1) {
				globalVar.put("space", 0);
				testBoard.kill();
				testBoard = new TestBoard(TestRandom.randInRange(5, 9));
				testBoard.start();
			}
		}*/
		testBoard.move();
	}
	
	//public void show() {
	//	
	//}
}
