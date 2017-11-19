package com.xxim.transport.handler;

import com.xxim.client.AbstractClient;
import com.xxim.codec.XXIMPackageType;

public interface IProtocol {

	public int forwardMessage(AbstractClient client, byte[] bytes, int tag);
	
}
