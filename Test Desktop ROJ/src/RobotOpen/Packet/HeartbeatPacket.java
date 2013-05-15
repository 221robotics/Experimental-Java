package RobotOpen.Packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;




public class HeartbeatPacket implements Message{


//	robotlink.js for packet to send
	
	
	/*    
	      bufView[0] = 104; // h
          bufView[1] = 238; // 0xEE
          bufView[2] = 1;   // 0x01
          
    */
	
	
	
	
	
	
		@Override
	public ByteBuffer getMessage() {
		//Setup
		ByteBuffer buffer = ByteBuffer.allocate(3);		
		
		byte[] something = new byte[3];
		
		
		something[0] = 'h';
		something[1] = (byte) 0xEE;
		something[2] = 0X01;
		
		
		//Guts
		buffer.clear();
		buffer.order(ByteOrder.LITTLE_ENDIAN);		
		buffer.put(something);
						
		return buffer;
	}
	
	
	
	
	
	
	
	
	
}



