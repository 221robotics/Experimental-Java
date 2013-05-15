package RobotOpen.Packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SetParameterPacket implements Message{
	
	
	//	robotlink.js for packet to send
	
	byte[] something = new byte[512];	
	
	@Override
	public ByteBuffer getMessage() {
		//Setup
		ByteBuffer buffer = ByteBuffer.allocate(3);		
		
			
		
		something[0] = 's';	
		
		//Guts
		buffer.clear();
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		
		buffer.put(something);

		System.out.println("PARAM...");
		
		return buffer;
	}
	
	/*	
	Byte 0 - 0x73
	...
	(Parameter Address (0x00-0x63)
	Val1
	Val2
	Val3
	Val4
	*/
	
	public void setData (int address, byte[] data){	
		
		address++;
		
		something[address]   = data[0];
		something[address+1] = data[1];
		something[address+2] = data[2];
		something[address+3] = data[3];
		something[address+4] = data[0];
		
	}

	
	
}


