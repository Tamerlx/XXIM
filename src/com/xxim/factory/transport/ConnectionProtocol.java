package com.xxim.factory.transport;

import com.xxim.factory.client.ClientProtocol;

public interface ConnectionProtocol {
	public void startService() throws Exception;
	public void clientConnected(ConnectionProtocol conn, ClientProtocol client);
	public void clientDisonnected(ConnectionProtocol conn, ClientProtocol client);
}
