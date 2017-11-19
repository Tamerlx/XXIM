package com.xxim.transport.impl;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.xxim.transport.LogicConnection;

public class TcpConn extends LogicConnection{
	private ServerSocket serverSocket;
	@Override
	public void startService(int port) {
		try {
			if(serverSocket == null){
				serverSocket = new ServerSocket(port);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				serverSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public Socket accept() {
		try {
			return serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


}
