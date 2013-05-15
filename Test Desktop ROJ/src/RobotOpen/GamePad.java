package RobotOpen;

public class GamePad {

	
	public static byte LeftX;
	public static byte LeftY;
	public static byte RightX;
	public static byte RightY;
	public static byte ButtonA;
	public static byte ButtonB;
	public static byte ButtonX;
	public static byte ButtonY;
	public static byte LeftShoulder;
	public static byte RightShoulder;
	public static byte LeftTrigger;
	public static byte RightTrigger;
	public static byte Select;
	public static byte Start;
	public static byte LeftStickButton;
	public static byte RightStickButton;
	public static byte Up;
	public static byte Down;
	public static byte Left;
	public static byte Right;
	public static byte Aux1;
	public static byte Aux2;
	public static byte Aux3;
	public static byte Aux4;
	
		
	
	private static byte[] data;
	
	public GamePad(){
		LeftX   	=	127;  		// Analog Left X Axis
		LeftY   	= 	127;  		// Analog Left Y Axis
		RightX  	= 	127;  		// Analog Right X Axis
		RightY  	=   127;  		// Analog Right Y Axis
		ButtonA			=	0;   	// Button A
		ButtonB			=	0;   	// Button B
		ButtonX			=	0;   	// Button X
		ButtonY			=	0;   	// Button Y
		LeftShoulder		=	0;   	// Left Shoulder
		RightShoulder		=	0;   	// Right Shoulder
		LeftTrigger			=	0;   	// Left Trigger
		RightTrigger		=	0;   	// Right Trigger
		Select				=	0;   	// Select
		Start				=	0;   	// Start
		LeftStickButton		=	0;   	// Left Stick Button
		RightStickButton	=	0;   	// Right Stick Button
		Up					=	0;   	// Up
		Down				=	0;   	// Down
		Left				=	0;   	// Left
		Right				=	0;   	// Right
		Aux1				=	0;   	// Aux
		Aux2				=	0;   	// Aux
		Aux3				=	0;   	// Aux
		Aux4				=	0;   	// Aux			
	}
	
	public byte [] GetData(){	
	
		data = new byte[]{			
				 LeftX, 
				 LeftY,  
				 RightX,  
				 RightY,  	
				 ButtonA,			
				 ButtonB,			
				 ButtonX,			
				 ButtonY,			
				 LeftShoulder,	
				 RightShoulder,	
				 LeftTrigger,	
				 RightTrigger,	
				 Select,			
				 Start,			
				 LeftStickButton,
				 RightStickButton,
				 Up,				
				 Down,			
				 Left,			
				 Right,			
				 Aux1,			
				 Aux2,			
				 Aux3,			
				 Aux4			
		};					
		return data;		
	}	

	
	
	
	
}
	
	
	
	
	
	
