/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {
	
	public void run() {
		moveToNewspaper();
		pickUpNewspaper();
		returnToOrigin();
	}

	private void moveToNewspaper(){
		moveToWall();
		creepToNewspaper();
	}
	
	// pre-condition : Karel must facing east
	// post-condition: Karel return to doorstep and still facing east
	private void pickUpNewspaper() {
		move();
		pickBeeper();
		moveBack();
	}
	
	// method to return Karel to it's cozy corner where the sofa is
	// pre-condition : Karel must facing north
	// post-condition: Karel return to his original position, and facing east 
	private void returnToOrigin() {
		if (facingEast()){
			turnLeft(); // facing north
		}
		if (facingWest()){
			turnRight();
		}
		if (facingSouth()){
			turnAround();
		}
		
		moveToWall();
		turnLeft();
		moveToWall();
		turnAround();
	}
	
	// method to move Karel to wall when he has to stop
	private void moveToWall() {
		while (frontIsClear()){
			move();
		}
	}
	
	// method to turn Karel around, i.e. facing east => facing west etc.
	// pre-condition : facing one direction
	// post-condition: facing the opposite direction
	private void turnAround() {
		turnLeft();
		turnLeft();
	}
	
	// method to turn Karel to the right
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	// method to move Karel backwards for one step, still facing the same direction
	private void moveBack() {
		turnAround();
		move();
		turnAround();
	}
	
	// method to creep Karel towards newspaper
	private void creepToNewspaper() {
		if (frontIsBlocked()){
			if (leftIsBlocked()){
				turnRight();
			} else {
				turnLeft();
			}
		}
		move(); // now maybe facing north or south
		
		if (facingNorth()){
			turnRight();
		}
		if (facingSouth()){
			turnLeft();
		}
		
	}
}
