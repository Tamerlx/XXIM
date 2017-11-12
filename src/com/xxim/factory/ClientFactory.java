package com.xxim.factory;

import java.net.Socket;

import com.xxim.factory.client.AbstractClient;
import com.xxim.factory.client.XXIMClient;

public class ClientFactory {

	public static AbstractClient createClient(String socketKey,Socket socket) {
		return new XXIMClient(socketKey,socket);
	}
}
