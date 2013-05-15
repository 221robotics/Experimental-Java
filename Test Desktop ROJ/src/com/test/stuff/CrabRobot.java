package com.test.stuff;

import RobotOpen.GamePad;
import RobotOpen.RobotOpenRobot;

public class CrabRobot extends RobotOpenRobot{
	
	public CrabDriveModule front_left 	= new CrabDriveModule(joystick1);
	public CrabDriveModule front_right	= new CrabDriveModule(joystick2);
	public CrabDriveModule back_left 	= new CrabDriveModule(joystick3);
	public CrabDriveModule back_right 	= new CrabDriveModule(joystick4);

	
	
	
	public CrabRobot(){
		//Set IP
		
		
	}
	
}
