/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * Karel will draw a checkerboard using beepers. 
 * Karel will instantiate SuperKarel Class, additional turnRight() and turnAround()
 * method are available.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	
	public void run() {
		
		while(frontIsClear()) { // check if the the front of Karel is clear
			drawRow();         // draw check pattern in a row
			adjustNorth();
			
		}
	}
	
	// method to draw a check pattern in a row
	private void drawRow () {
		
	}
	
	// method to adjust Karel's direction to face North
	// pre-condition : Karel faces any direction
	// post-condition: Karel is facing North
	private void adjustNorth(){
		if (facingEast()) {
			turnLeft();
		}
		if (facingWest()) {
			turnRight();
		}
		if(facingSouth()) {
			turnAround();
		}
	}
	
}
