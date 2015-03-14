package org.calgarycommteams.scripting;


/**
 * Functions used to interface {@code Scripting} with the rest of the robot.
 * Functions will be under robot.*
 *
 * @since March 12 15
 * @author Daniel Doran
 */
public class RobotInterface {
	
	RobotInterface() {
		
	}
	
	public void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//TODO Functions called by the script to interact with the robot

}
