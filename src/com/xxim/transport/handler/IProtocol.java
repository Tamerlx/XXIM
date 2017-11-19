package com.xxim.transport.handler;

import com.xxim.client.AbstractClient;

public interface IProtocol {

	public void forwardMessage(AbstractClient client,byte[] bytes);
	
}
