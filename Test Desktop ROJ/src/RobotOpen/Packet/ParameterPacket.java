package RobotOpen.Packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ParameterPacket implements Message{
	
	
	//	robotlink.js for packet to send
	
	
	/*    
        bufView[0] = 103; // g
        bufView[1] = 234; // 0xEA
        bufView[2] = 65;  // 0x41
          
    */
			
	@Override
	public ByteBuffer getMessage() {
		//Setup
		ByteBuffer buffer = ByteBuffer.allocate(3);		
		
		byte[] something = new byte[3];		
		
		something[0] = 'g';
		something[1] = (byte) 0xEA;
		something[2] = 0X41;		
		
		//Guts
		buffer.clear();
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		
		buffer.put(something);
			
	/*	
		buffer.putChar('h');
		buffer.put((byte) 0xEE); 
		buffer.put((byte) 0x01);
	*/
		//crc somehow ...? 
		
		
		System.out.println("PARAM...");
		
		return buffer;
	}
	
}
