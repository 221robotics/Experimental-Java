package RobotOpen;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import RobotOpen.Packet.JoystickPacket;

public class RobotOpenRobot {
	
	private static  JoystickPacket joysticks 	= new JoystickPacket();	
	private ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
	private ROUDPSender 	udpSender;	
	private ROUDPReceiver 	udpReceiver;	
	
	
	private static DatagramSocket socket;
	
	public GamePad joystick1 = joysticks.joy1;
	public GamePad joystick2 = joysticks.joy2;
	public GamePad joystick3 = joysticks.joy3;
	public GamePad joystick4 = joysticks.joy4;
	
	public RobotOpenRobot(){	
				
		try {
			socket = new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		udpSender = new ROUDPSender(joysticks, socket);			
		udpReceiver = new ROUDPReceiver(socket);		
		threadPool.scheduleWithFixedDelay(udpSender, 0, 100, TimeUnit.MILLISECONDS);
		threadPool.scheduleWithFixedDelay(udpReceiver, 0, 50, TimeUnit.MILLISECONDS);
		
	
	}
	
	
	
	
	
	public void connect(){
		udpSender.connect();		
	}
	
	public void disconnect(){
		udpSender.disconnect();		
	}
	
	
	public void enable(){		
		udpSender.JoystickMessage();		
	}
	
	public void disable(){		
		udpSender.HeartBeatMessage();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
