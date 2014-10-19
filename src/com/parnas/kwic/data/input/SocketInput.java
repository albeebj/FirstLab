package com.parnas.kwic.data.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.parnas.kwic.constants.ConstantsUtil;
import com.parnas.kwic.data.interfaces.InputInterface;

public class SocketInput implements InputInterface{
	private ServerSocket serverSocket;
	private Socket socket;
	private int port;
	private BufferedReader br;
	private String temp;
	
	public SocketInput(int p) {
		this.port = p;
		try {
			serverSocket = new ServerSocket(port);
			socket = serverSocket.accept();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override
	public String getLine() {
		// TODO Auto-generated method stub
		try {
			temp = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (temp != null) 
			return temp;
		else {
			try {
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
			
	}
	
	
	@Override
	public ArrayList<String> getWholeFile() {
		// TODO Auto-generated method stub
		return null;
	}	
}
