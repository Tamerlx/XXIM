package com.xxim.factory.transport;

import com.xxim.factory.client.AbstractClient;

public interface ConnectionProtocol {
	public void startService() throws Exception;
	public void clientConnected(ConnectionProtocol conn, AbstractClient client);
	public void clientDisonnected(ConnectionProtocol conn, AbstractClient client);
}
