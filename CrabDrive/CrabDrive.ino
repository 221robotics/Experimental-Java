#include <SPI.h>
#include <SD.h>
#include <Ethernet.h>
#include <Servo.h>
#include <EEPROM.h>
#include <RobotOpen.h>



/* I/O Setup */
ROJoystick front_left(1);         // Joystick #1
ROJoystick front_right(2);         // Joystick #2

/*
ROJoystick back_right(3);         // Joystick #3
ROJoystick back_left(4);         // Joystick #4
*/


ROPWM leftDrive(0);
ROPWM rightDrive(1);
ROPWM leftSteer(2);
ROPWM rightSteer(3);

//leftEncoder = INT0
//rightEncoder = INT1

ROAnalog leftAbsEncoder(0); //leftAbsEncoder.read();
ROAnalog rightAbsEncoder(1);

/*
public CrabDriveModule front_left 	= new CrabDriveModule(joystick1);
public CrabDriveModule front_right	= new CrabDriveModule(joystick2);
public CrabDriveModule back_left 	= new CrabDriveModule(joystick3);
public CrabDriveModule back_right 	= new CrabDriveModule(joystick4);
*/







void setup()
{
  /* Initiate comms */
  RobotOpen.begin(&enabled, &disabled, &timedtasks);
}


/* This is your primary robot loop - all of your code
 * should live here that allows the robot to operate
 */
void enabled() {
  
  
  
  
  
  //need to translate steering values from 255 to angle 
  //and then pull the angle of the robot and pump it 
  //into the PID to control it
  
  
  
  
  
  
  
  
  
  
  
  
  leftSteer.write(front_left.leftX());
  leftDrive.write(front_left.leftY());

  rightSteer.write(front_right.leftX());
  rightDrive.write(front_right.leftY());
  
}


/* This is called while the robot is disabled
 * All outputs are automatically disabled (PWM, Solenoid, Digital Outs)
 */
void disabled() {
  // safety code
}


/* This loop ALWAYS runs - only place code here that can run during a disabled state
 * This is also a good spot to put driver station publish code
 */
void timedtasks() {
  
  
  
  
  
  
  
  RODashboard.publish("Uptime Seconds", ROStatus.uptimeSeconds());
}


// !!! DO NOT MODIFY !!!
void loop() {
  RobotOpen.syncDS();
}
