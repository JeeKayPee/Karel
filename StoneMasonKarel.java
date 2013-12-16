/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.
 * Color tracing is added to the code to enable visual tracking of Karel's movement
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		
		while (frontIsClear()) {		// check if Karel is already on the right wall, pre-condition is Karel must facing east
			accendRepair();
			decend();
			moveToNextColumn();
			adjustToEast();
		} // M.H. first draft ends here, OBOB problem!
		
		// M.H. codes below are added in second draft to fix OBOB issue
		accendRepair();
		decend();
	}
	
	
	// method to move Karel up (north) and repair the column missing stones 
	// pre-condition : Karel can face any direction
	// post-condition: Karel accend to the top of the column and repaired missing stones along the way, facing north
	private void accendRepair(){
		// adjust Karel to face north
		adjustToNorth();
		
		while (frontIsClear()){
			paintCorner(RED);
			// repair
			repairStone();
			
			// accend one step up
			move();
		} // M.H. first draft ends here, OBOB problem!
		
		// M.H. codes below are added in second draft to fix OBOB issue
		repairStone();
		paintCorner(RED);
		
	}
	
	// method to adjust Karel facing North
	private void adjustToNorth(){
		if (facingEast()){
			turnLeft();
		}
		if (facingWest()){
			turnRight();
		}
		if (facingSouth()){
			turnAround();
		}
	}
	
	// method to adjust Karel facing East
	private void adjustToEast(){
		if (facingWest()){
			turnAround();
		}
		if (facingNorth()){
			turnRight();
		}
		if (facingSouth()){
			turnLeft();
		}	
	}
	
	// method to check if stones is missing, if it is, then put one stone (beeper)
	private void repairStone(){
		if(noBeepersPresent()){
			putBeeper();
		}
	}
	
	// method to decend Karel to bottom of the column
	private void decend(){
		turnAround();
		while(frontIsClear()){
			move();
		}
		adjustToEast();
	}
	
	// method to move Karel from one column to the next column needs repair
	// pre-condition : Karel must facing east
	// post-condition: Karel moves to the next column to repair, facing east
	private void moveToNextColumn(){
		adjustToEast();
		for (int i = 0; i < 4; i++) {
			move();  // next column is always 4 units away
			paintCorner(RED);
		}
		
	}

}
