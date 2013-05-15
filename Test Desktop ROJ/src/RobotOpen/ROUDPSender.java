package RobotOpen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

import RobotOpen.Packet.HeartbeatPacket;
import RobotOpen.Packet.JoystickPacket;
import RobotOpen.Packet.Message;


public class ROUDPSender implements Runnable{

	//socket.receive in a seperate thread. 
	
	private static 	DatagramPacket 	packet;// = new DatagramPacket();
	private static	ByteBuffer		buffer;
	private static  InetAddress		broadcast;
	private static  DatagramSocket 	socket;
	private static  JoystickPacket		joysticks;
	private static  HeartbeatPacket		heartbeat;
	
	private static 	Message			message;
	
	private static	boolean 		connection		=	false;		
	
	public ROUDPSender (JoystickPacket joyStick, DatagramSocket Sock){
		
		
		heartbeat = new HeartbeatPacket();
		joysticks = joyStick;
		
		//joysticks.joy1[1] = 100;
		
		byte[] duh = new byte[1];
		duh[0] = (byte) 0;
		
		packet = new DatagramPacket(duh, 1);	
		
		message = heartbeat;
				
		socket = Sock;
	
		
		try {
			broadcast = InetAddress.getAllByName("10.10.0.180")[0];
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}



	
	public void connect() {
		connection = true;		
	}
	
	public void disconnect() {
		connection = false;		
	}	
	
	public void JoystickMessage() {		
		message = joysticks;
	}


	public void HeartBeatMessage() {
		message = heartbeat;		
	}

	
	
	@Override
	public void run() {

		if(connection){
			buffer = message.getMessage();
			packet.setData(buffer.array());
			packet.setLength(buffer.capacity());
			
			packet.setAddress(broadcast);
			packet.setPort(22211);
			
			try {
				socket.send(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}










	
	
}
