package RobotOpen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import com.test.stuff.Controller;

public class ROUDPReceiver implements Runnable {
	
	
	private static DatagramSocket 	socket;
	private static DatagramPacket	inPacket;
	private static byte[]			inBuf;
	
	
	
	public ROUDPReceiver ( DatagramSocket Sock){
		socket = Sock;
				
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){			
			
			inBuf = new byte[512];
			inPacket = new DatagramPacket(inBuf, inBuf.length);
			
			try {
				socket.receive(inPacket);
				
				ParsePacket(inPacket.getData());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
	
	
	private void ParsePacket(byte[] data){
		
		
		
		switch (data[0]){
		
		case 'd':
			//Published Data. 
			//Break down based on type of data thats been passed
				int start	= 0;
		
				
				for (int i = 1; i < data.length; i++ ){
				
					start = i -1;
					
					byte length = data[1 + start];
					byte type	= data[2 + start];
					int  value	= data[3 + start];
					int  redux	= 0;
					
					
					if(type == 0){
						break;						
					}
					
					String name = "";			
					
					System.out.println("---------------");					
					
					System.out.println("Type: " + (char)type + " [" + type + "]"); 
					
					switch (type){				
					case 'c':
						
						System.out.println("Value: " + 	(byte) data[3 + start]); 
						
						start = 4;
						redux = 3;
													
						break;
					case 'i':
						//4 bytes							|0001|      
						System.out.println("Value: " + 	  ((data[3 + start] << 8) | (data [4 + start] ))); 
						
						start = 5;
						redux = 4;
											
						break;
					case 'l':
						//8 bytes
						long l_data = (((data[3 + start] << 24) & 0xff000000)| ( (data [4 + start] << 16) & 0x00ff0000) | ( (data [5 + start] << 8) & 0x0000ff00)| (( 0x000000ff & data[6 + start])));

						System.out.println("Value: " + l_data); 
												
						start = 7;
						redux = 6;
												
						break;
					case 'f':
						//4 bytes						
						float f_data = Float.intBitsToFloat((0xff00 & (data[3 + start] << 8)) | (data [4 + start]));
								
						System.out.println("d3: " + 	(data[3 + start] << 8)); 					
						System.out.println("d4: " + 	data [4 + start]); 					
						
						
						
						
						System.out.println("Value: " + 	f_data); 					
						
						start = 7;
						redux = 6;
						
						break;
					}
					length -= redux;
					//System.out.println("Length Of Name: " + length );
					
					for (int ii = i; ii < length+i; ii++){
						name += (char)data[ii+redux];			
					}								
					System.out.println("Name: " + name);
					System.out.println("");	
					
					i += length + redux - 1;
				}
				
				System.out.println("");				
				for(int ii = 0; ii < data.length; ii++){
					
						System.out.print("|" + (char) data[ii]);	
						
				}
				
				System.out.println("Total Lenght: " + data.length);
				
				System.out.println("---------------");
				
			
			break;
		
		}
		
	}
	
	

}
