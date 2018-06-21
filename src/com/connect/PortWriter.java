package com.connect;

import java.io.PrintWriter;

import com.fazecast.jSerialComm.SerialPort;

public class PortWriter implements Runnable{
	
	SerialPort chosenPort;
	
	public PortWriter(SerialPort port) {
		this.chosenPort = port;
	}
	
	public void run()
	{
		PrintWriter writer = new PrintWriter(chosenPort.getOutputStream());
		
		while(true)
		{
			writer.println("#CC");
			writer.println("#MNMANATEC");
			writer.flush();
			try{
				Thread.sleep(1000);
			}catch(Exception e) {}			
		}
	}
}
