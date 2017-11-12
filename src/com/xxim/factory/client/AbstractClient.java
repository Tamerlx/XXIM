package com.xxim.factory.client;

import java.net.Socket;

import com.xxim.utils.StringUtil;

public abstract class AbstractClient {

	private String id;
	private Socket socket;
	
	public AbstractClient(String id,Socket socket) {
		if(StringUtil.isEmpty(id)) {
			throw new RuntimeException("id is null");
		}
		if(socket == null) {
			throw new RuntimeException("socket is null");
		}
		this.id = id;
		this.socket = socket;
	}
}
