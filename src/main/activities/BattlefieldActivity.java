package main.activities;

import board.Battlefield;
//import board.Board;
import main.grui.ElementSource;

public class BattlefieldActivity extends Activity {
	
	public String nowUnit = "";
	
	private Battlefield battlefield;
	
	public BattlefieldActivity() {
		super();
		//TODO button to start the process
		activityName = "Battlefield";
		x = 0.;
		y = 0.;
		w = 3./4.;
		h = 1.;
		battlefield = new Battlefield(7);
		battlefield.globalVar = globalVar;
		battlefield.start();
	}
	
	public void move() {
		battlefield.nowUnit = nowUnit;
		/*if (globalVar.containsKey("space")) {
			if (globalVar.get("space") == 1) {
				globalVar.put("space", 0);
				testBoard.kill();
				testBoard = new TestBoard(TestRandom.randInRange(5, 9));
				testBoard.start();
			}
		}*/
		battlefield.move();
		if (battlefield.gameover) {
			battlefield = new Battlefield(7);
			battlefield.start();
		}
		nowUnit = battlefield.nowUnit;
	}
	
	public ElementSource show() {
		return battlefield.show();
	}
	
	public void clear() {
		battlefield.clear();
	}
}
