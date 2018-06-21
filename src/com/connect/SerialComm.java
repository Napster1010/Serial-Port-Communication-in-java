package com.connect;

import java.io.PrintWriter;

import com.fazecast.jSerialComm.SerialPort;

public class SerialComm {

	public static void main(String[] args) throws Exception{

		SerialPort serialPorts[] = SerialPort.getCommPorts();
		for(SerialPort port: serialPorts)
		{
			System.out.println(port.getSystemPortName());
		}		
		
		SerialPort chosenPort = SerialPort.getCommPort(serialPorts[0].getSystemPortName());		
		chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
		if(chosenPort.openPort())
			System.out.println("Port opened succlessfully!");
		else
			System.out.println("Couldn't open the port !!");		

		
		//Create writer and listener objects				
		Thread writeThread = new Thread(new PortWriter(chosenPort));
		Thread listenerThread = new Thread(new PortListener(chosenPort));
		
		//writeThread.start();
		//listenerThread.start();		
		
		//chosenPort.closePort();
	}

}
