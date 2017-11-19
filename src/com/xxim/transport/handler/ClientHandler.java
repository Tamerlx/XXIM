package com.xxim.transport.handler;

import com.xxim.client.AbstractClient;
import com.xxim.codec.XXIMPackageCoder;
import com.xxim.codec.XXIMPackageHeader;

public class ClientHandler implements IProtocol {

	@Override
	public void forwardMessage(AbstractClient client, byte[] bytes) {
		XXIMPackageCoder coder = new XXIMPackageCoder();
		coder.resetBuf(bytes);
		XXIMPackageHeader header = new XXIMPackageHeader();
		int ret = header.unpackData(coder);
		System.out.println(ret);
	}

}
