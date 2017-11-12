package com.xxim;

import java.util.HashMap;
import java.util.Map;

import com.xxim.factory.client.AbstractClient;

public class XXIMContext {
	private final static XXIMContext xximContext = new XXIMContext();
	
	private final Map<String,AbstractClient> clientMap = new HashMap<String,AbstractClient>();
	
	private XXIMContext() {
		
	}
	
	public static XXIMContext getInstance() {
		return xximContext;
	}
	
	public AbstractClient getClientById(String socketKey) {
		return clientMap.get(socketKey);
	}
	
	public void setClient(String socketKey,AbstractClient clientProtocol) {
		clientMap.put(socketKey, clientProtocol);
	}
	
	public boolean contains(String sockeyKey) {
		return clientMap.containsKey(sockeyKey);
	}
}
