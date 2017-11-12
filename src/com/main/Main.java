package com.main;

import com.xxim.XXIMRouteManager;
import com.xxim.factory.handler.HandlerProtocol;
import com.xxim.factory.handler.impl.ClientHandler;
import com.xxim.factory.transport.LogicConnection;
import com.xxim.factory.transport.impl.TcpConn;

public class Main {

	public static void main(String[] args) {
		LogicConnection tcpConn = new TcpConn();
		HandlerProtocol handler = new ClientHandler();
		XXIMRouteManager manager = XXIMRouteManager.getInstance();
		manager.setup(tcpConn, 9999, handler);
		manager.startService();
	}

}
