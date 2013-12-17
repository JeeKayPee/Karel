/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * MidpointFindingKarel class 
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

/*
 * Implementation algorithm used in this class is not optimal, new algorithm 
 * will be continue explored.
 * 
 * Implementation details:
 * 
 * 6 * - * -  * -> *
 *   |             |
 * 5 *   * -> *    *
 *   |   |    |    |
 * 4 *   *    *    *
 * 	 |   |    |    |
 * 3 *   *    *    *
 *   |   |    |    |
 * 2 *   *    *    *
 *   |   |         |
 * 1 *   * <- *  - *
 *   1   2    3    4
 *   
 *   a world 4 by 6, middle point is 3 using this algorithm
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	
	public void run() {
		// mapping external walls
		mapExternal();
		
		// dive into internal spiral
		mapInternal();
		
		// move down to 1st Street
		decend();
		
		// set the marker beeper
		paintCorner(RED);
		
		// clean up trail
		//cleanUp();
		
	}
	
	// method to map the external circumference -- first round
	// pre-condition : Karel sits at 1st St. 1st Ave.
	// post-condition: Karel sits at 1st St. 2nd Ave. facing East
	private void mapExternal() {
		adjustToNorth();
		moveToWallWithBeepers();
		turnRight(); // adjust Karel to face East
		moveToWallWithBeepers();
		turnRight(); // adjust Karel to face South
		moveToWallWithBeepers();
		turnRight(); // adjust Karel to face West
		moveToWallWithBeepers(); 
		// at this time, Karel at 1st St. 1st Ave. back up one step
		adjustToEast();
		move();
	}
	
	// method to map the internal circumference -- second round
	// pre-condition : Karel finished exterior recon
	// post-condition: Karel reaches the central point of map, could be facing any direction
	private void mapInternal() {
		adjustToNorth();
		while (true) { // M.H. modify this condition
			moveToTrailingBeeper();
			turnRight();
			
			// determine if Karel reaches its destination -- middle point
			move();
			if(beepersPresent()) {
				paintCorner(BLUE);
				break;
			} else {
				moveBackward();
			}
		}
	}
	
	// method to move Karel until it hits trailing beeper, then Karel stops and back up one step
	private void moveToTrailingBeeper(){
		move();
		while(noBeepersPresent()){
			putBeeper();
			move();
		}
		// hits trailing beeper, Karel back up one step
		moveBackward();
	}
	
	// method to move Karel backward
	private void moveBackward () {
		turnAround();
		move();
		turnAround();
	}
	
	
	// method to decend Karel to 1st Street
	// pre-condition: Karel could face any direction
	// post-condition: Karel decend to first Street, facing West
	private void decend() {
		// Karel facing south, prepare to decend
		adjustToSouth();
		// decending
		moveToWall();
		// adjust Karel facing West
		turnRight();
	}
	
	// method to adjust Karel to South
	private void adjustToSouth(){
		if(facingNorth()) turnAround();
		if(facingWest())  turnLeft();
		if(facingEast())  turnRight();
	}
	
	// method to adjust Karel to North
	private void adjustToNorth(){
		if(facingSouth()) turnAround();
		if(facingWest())  turnRight();
		if(facingEast())  turnLeft();
	}
	
	private void adjustToEast(){
		if(facingNorth()) turnRight();
		if(facingWest())  turnAround();
		if(facingSouth()) turnLeft();
	}
	
	
	private void moveToWall() {
		while(frontIsClear()) {
			move();
		}
	}
	
	// method to move to wall while putting down beepers
	private void moveToWallWithBeepers() {
		while(frontIsClear()){
			putBeeper();
			move();
		}
	}

}
