package com.test.stuff;

import RobotOpen.GamePad;

public class CrabDriveModule {
	
	
	private GamePad module;
	
	public CrabDriveModule (GamePad joystick){
		//Repurposing the joystick a little bit
		//	* Heading - LeftX Axis
		//  * Velocity- LeftY Axis
		
		module = joystick;
				
	}
	
	public void setHeading(double deg){	
		
		//Reduce number to one rotation worth of degrees
		if(deg > 180){
			deg = 180;
		}
		
		if( deg < -180){			
			deg = -180;			
		}
			
		//Scale heading to 0-255, 255 being 180 degrees and 127 for 0 degree. Where 0 is forward		
		
		//-180-----0-----180 <- degrees in (deg)
		//  0-----127-----0  <- value writen to joystick
				
		byte value = (byte) (((deg / 180.0) * 127) + 127);
		
		module.LeftX =  value;		
	}
	
	public void setVelocity(int value){
		//value in m/s 
				
		module.LeftY =  (byte) value;		
		
	}
	

}
