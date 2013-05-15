package RobotOpen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;


public class ROUDPReceiver implements Runnable {
	
	
	private static DatagramSocket 	socket;
	private static DatagramPacket	inPacket;
	private static byte[]			inBuf;
	private static  List<Object[]>	parameters;
	
	
	public ROUDPReceiver ( DatagramSocket Sock){
		socket = Sock;
		parameters = new ArrayList<Object[]>();
		
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
					//int  value	= data[3 + start];
					int  redux	= 0;
					
					//int ba = ((data[3 + start] << 8) | data[4 + start]);
					
					if(type == 0){
						break;						
					}
					
					String name = "";						
					//*System.out.println(""---------------");					
					//*System.out.println(""Type: " + (char)type + " [" + type + "]"); 
					
					switch (type){				
					case 'c':
						
						//*System.out.println(""Value: " + 	(byte) data[3 + start]); 
						
						start = 4;
						redux = 3;
													
						break;
					case 'i':
						//4 bytes							|0001|      
						//*System.out.println(""Value: " + 	  ((data[3 + start] << 8) | (data [4 + start] & 0xFF ))); 
						
						start = 5;
						redux = 4;
											
						break;
					case 'l':
						//8 bytes
						
						byte[] bytes = { 																
								data[6 + start],
								data[5 + start],
								data[4 + start],
								data[3 + start]									
						};	
						
						long value = 0;
						
						for (int oi = 0; oi < bytes.length; oi++)
						{
						   value = (value << 8) + (bytes[oi] & 0xff);
						}
						
						//*System.out.println(""Value: " + value); 
						
						start = 7;
						redux = 6;
												
						break;
					case 'f':
						//4 bytes	
						
						byte[] bytes_f = { 																
								data[6 + start],
								data[5 + start],
								data[4 + start],
								data[3 + start]									
						};					
						float f_data = ByteBuffer.wrap(bytes_f).order(ByteOrder.LITTLE_ENDIAN).getFloat();
												
						//*System.out.println(""Value: " + 	f_data); 					
						
						start = 7;
						redux = 6;
						
						break;
					}
					length -= redux;
					//System.out.println("Length Of Name: " + length );
					
					for (int ii = i; ii < length+i; ii++){
						name += (char)data[ii+redux];			
					}								
					//*System.out.println(""Name: " + name);
					//*System.out.println(""");	
					
					i += length + redux - 1;
				}
				
				//*System.out.println(""");		
				
				/*
				for(int ii = 0; ii < data.length; ii++){
					
						System.out.print("|" + (char) data[ii]);	
						
				}
				*/
				
				//*System.out.println(""Total Lenght: " + data.length);
				
				//*System.out.println(""---------------");
				
			
			break;
			
			
			
		case 'r':
			//Get Parameter Packet
			
			
			
			for(int offset = 0; offset < data.length; offset += 1){
				
			
			
			
				int length  = data[offset + 1] - 7;
				
				if (length > 0){
					
					int address = data[offset + 2];
					
					char type 	= (char) data[offset + 3];
						//Depending on type, you will use different amount of byrtes
						// data[4] - data[7] are the values
					
					String name = "";			
					for (int i = 1; i < length+1; i++){				
						name += (char) data[offset + i+7];	
					}
					
					//*System.out.println(""VARIABLE NAME: [" + name + "]");
					
					/*for(int ii = 0; ii < data.length; ii++){
						
						System.out.print("|" + (char) data[ii]);	
						
					}
					*/
					
					switch (type){
					
					case 'b': //Boolean - 1 byte (0x00 false, 0xFF true)
						//*System.out.println(""VALUE: " + data[offset + 4]);
						
						parameters.add(new Object[]{packParam(name, address, (boolean) (data[offset + 4]==0xFF))});
						
						break;
						
					case 'c': //Char - 1 byte (signed)
						//*System.out.println(""VALUE: " + data[offset + 4]);
						parameters.add(new Object[]{packParam(name, address, (char) data[offset + 4])});
						
						break;
		
					case 'i': //Int - 2 bytes (signed)
						//*System.out.println(""VALUE: " + ((data[offset + 5] << 8) | (data [4] & 0xFF )));
						parameters.add(new Object[]{packParam(name, address, (int) ((data[offset + 5] << 8) | (data[offset + 4] & 0xFF )))});
						
						break;
						
					case 'l': //Long - 4 bytes (signed)
						
		
						byte[] bytes = { 
								data[offset + 4],
								data[offset + 5],
								data[offset + 6],
								data[offset + 7]														
						};	
						
						long value = 0;
						
						/*for (int oi = 0; oi < bytes.length; oi++)
						{
						   value = (value << 8) + (bytes[oi] & 0xff);
						}*/
						
						//*System.out.println(""Value: " + value); 
						
						parameters.add(new Object[]{packParam(name, address, (long) value)});
						
						break;
		
					case 'f': //Float - 4 bytes (signed)
						
						byte[] bytes_f = { 																
								data[offset + 4],
								data[offset + 5],
								data[offset + 6],
								data[offset + 7]									
						};					
						float f_data = ByteBuffer.wrap(bytes_f).order(ByteOrder.LITTLE_ENDIAN).getFloat();
												
						//*System.out.println(""Value: " + 	f_data); 					
						parameters.add( new Object[]{packParam(name, address, (float) f_data)});
						
						
						break;
						
					}
					
										
					offset += data[1+offset] - 1;
								
					
				}else{
					
					offset = data.length;
					
				}
			}
			
			
			for(int depth = 0; depth < parameters.size(); depth ++){
				
				 Object[] c = parameters.get(depth);
				 
				 Object[] b = (Object[]) c[0];
								 
				 char Type = (char) b[0];
				 String Name = (String) b[1];
				 
			 
			 
			 
				System.out.println("NAME: " + Name);
				System.out.println("TYPE: " + Type);
				System.out.println("ADDR: " + b[2]);
				
					
				switch (Type){
					
				case 'b':						
					System.out.println("VALUE: " + ((boolean)  b[3]));						
					break;
				
				case 'c':						
					System.out.println("VALUE: " + ((char)  b[3]));						
					break;
				
				case 'i':						
					System.out.println("VALUE: " + ((int)  b[3]));						
					break;
				
				case 'l':						
					System.out.println("VALUE: " + ((long)  b[3]));						
					break;
				
				case 'f':						
					System.out.println("VALUE: " + ((float)  b[3]));						
					break;
				
					
					
				}
				
			}
			
		
		
			break;
			
		default:
			System.out.println("RECEIVED TYPE: " + (char) data[0]);
			
			for(int ii = 0; ii < data.length; ii++){
				
				System.out.print("|" + (char) data[ii]);	
				
			}
			
			break;
		
		}
		
	}
	
	
	private Object[] packParam(String name, int address, boolean value){		
		char type = 'b';				
		return  new Object[] { type, name, address, value};		
	}

	private Object[] packParam(String name, int address, char value){		
		char type = 'c';				
		return  new Object[] { type, name, address, value};		
	}

	private Object[] packParam(String name, int address, int value){		
		char type = 'i';				
		return  new Object[] { type, name, address, value};		
	}
	
	private Object[] packParam(String name, int address, long value){		
		char type = 'l';				
		return  new Object[] { type, name, address, value};		
	}
		
	private Object[] packParam(String name, int address, float value){		
		char type = 'f';				
		return  new Object[] { type, name, address, value};		
	}
	
	
	
	public List<Object[]> getParamsList(){
		return parameters;		
	}
	
	
	
	
	

}
