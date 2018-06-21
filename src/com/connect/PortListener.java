package com.connect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

public class PortListener implements Runnable{
	
	SerialPort chosenPort;
	
	public PortListener(SerialPort port) {
		this.chosenPort = port;
	}
	
	public void run()
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(chosenPort.getInputStream()));
		while(true)
		{
			try
			{
				while(reader.ready())
				{
						//char line = (char)reader.read();
						char line = (char)reader.read();
						System.out.print(line);					
				}	
			}catch(Exception e) {System.out.println("Exception caught !!");}	
		}
		
	}
}
