package com;

import java.util.HashMap;
import java.util.Map;

import com.xxim.factory.client.AbstractClient;

public class XXIMContext {
	private static XXIMContext xximContext = new XXIMContext();
	
	private final Map<String,AbstractClient> clientMap = new HashMap<String,AbstractClient>();
	
	private XXIMContext() {
		
	}
	
	public static XXIMContext getInstance() {
		return xximContext;
	}
	
	public AbstractClient getClientById(String id) {
		return clientMap.get(id);
	}
	
	public void setClient(String id,AbstractClient clientProtocol) {
		clientMap.put(id, clientProtocol);
	}
}
