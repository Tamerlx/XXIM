package com.xxim.factory;

import java.net.Socket;

import com.xxim.client.AbstractClient;
import com.xxim.client.Client;

public class ClientFactory {

	public static AbstractClient createClient(String socketKey,Socket socket) {
		return new Client(socketKey,socket);
	}
}
