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
		cleanUp();
		
	}
	
	// method to decend Karel to 1st Street
	// pre-condition: Karel could face any direction
	// post-condition: Karel decend to first Street, facing West
	private void decend() {
		// Karel facing south, prepare to decend
		adjustToSouth();
		// decending
		moveToWall();
		// Karel facing West
		adjustToWest();
	}
	
	// method to adjust Karel to South
	private void adjustToSouth(){
		if(facingNorth()) turnAround();
		if(facingWest())  turnLeft();
		if(facingEast())  turnRight();
	}
	
	// methid to adjust Karel to West
	private void adjustToWest() {
		if(facingNorth()) turnLeft();
		if(facingSouth()) turnRight();
		if(facingEast()) turnAround();
	}
	
	private void moveToWall() {
		while(frontIsClear()) {
			move();
		}
	}
	

}
