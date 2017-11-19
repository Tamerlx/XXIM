package com.xxim.transport.handler;

import com.xxim.client.AbstractClient;

public class ClientHandler implements HandlerProtocol {

	@Override
	public void forwardMessage(AbstractClient client, byte[] bytes) {
		System.out.println(new String(bytes));

	}

}
