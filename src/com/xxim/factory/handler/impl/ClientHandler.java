package com.xxim.factory.handler.impl;

import com.xxim.factory.client.AbstractClient;
import com.xxim.factory.handler.HandlerProtocol;

public class ClientHandler implements HandlerProtocol {

	@Override
	public void forwardMessage(AbstractClient client, byte[] bytes) {
		System.out.println(new String(bytes));

	}

}
