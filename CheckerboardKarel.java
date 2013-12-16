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
		
		// draw the first line
		drawRow();         // draw check pattern in a row
		adjustNorth();
		while(frontIsClear()) { // check if the the front of Karel is clear
			move();
			drawRow();         // draw check pattern in a row
			adjustNorth();
		}
	}
	
	// method to draw a check pattern in a row
	private void drawRow () {
		while(frontIsClear()) {
			putBeeper();
			
			// move twice to the next location for dropping a beeper
			for (int i = 0; i < 2; i ++) {
				if (frontIsClear()) {
					move();
				} else {
					break;
				}
			}
		}
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
