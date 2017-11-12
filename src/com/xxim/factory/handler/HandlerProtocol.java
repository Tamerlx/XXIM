package com.xxim.factory.handler;

import com.xxim.factory.client.AbstractClient;

public interface HandlerProtocol {

	public void forwardMessage(AbstractClient client,byte[] bytes);
	
}
