package com.main;

import com.xxim.XXIMRouteManager;
import com.xxim.transport.LogicConnection;
import com.xxim.transport.handler.ClientHandler;
import com.xxim.transport.handler.IProtocol;
import com.xxim.transport.impl.TcpConn;

public class Main {

	public static void main(String[] args) {
		LogicConnection tcpConn = new TcpConn();
		IProtocol handler = new ClientHandler();
		XXIMRouteManager manager = XXIMRouteManager.getInstance();
		manager.setup(tcpConn, 9999, handler);
		manager.startService();
	}

}
