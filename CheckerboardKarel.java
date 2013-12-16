/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * Karel will draw a checkerboard using beepers. 
 * Karel will instantiate SuperKarel Class, additional turnRight() and turnAround()
 * method are available.
 * Karel will adapt to various checkboard sizes, and he will never stop until finished his job!
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	
	public void run() {
		
		// draw the first line
		drawRow();         // draw check pattern in a row
		adjustToNorth();
		while(frontIsClear()) { // check if the the front of Karel is clear
			move();             // Karel moves to the next row
			if(rightIsBlocked()) { // Karel's right is blocked --> Karel needs to draw from West to East
				turnLeft();
			}
			if (leftIsBlocked()) { // Karel's left is blocked --> Karel needs to draw from East to West
				turnRight();
			}
			drawRow();         // draw check pattern in a row
			adjustToNorth();
		}
	}
	
	// method to draw a check pattern in a row
	private void drawRow () {
		putBeeper();	// always put down the first beeper
		
		while(frontIsClear()) {
			
			// move twice to the next location for putting down a beeper
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			} 
		}
	}
	
	// method to adjust Karel's direction to face North
	// pre-condition : Karel faces any direction
	// post-condition: Karel is facing North
	private void adjustToNorth(){
		if (facingEast()) {
			turnLeft();
		}
		if (facingWest()) {
			turnRight();
		}
		if(facingSouth()) {
			turnAround();
		}
		if(facingNorth()){
			
		}
	}
	
}
