package com.xxim.transport.handler;

import com.xxim.client.AbstractClient;
import com.xxim.codec.PackageDecoder;
import com.xxim.codec.PackageHeader;
import com.xxim.codec.PackageType;

public class ClientHandler implements IProtocol {

	@Override
	public int forwardMessage(AbstractClient client, byte[] bytes, int tag) {
		
		switch (tag) {
		case PackageType.HEADER:
			
			// 1. 从magic开始
			// 2. 不从magic开始，已经存在部分header
			PackageDecoder coder = new PackageDecoder();
			coder.resetBuf(bytes);
			
			PackageHeader header = new PackageHeader();
			int ret = -1;
			try {
				ret = header.unpackData(coder);
				
				if (ret == 0) {
					// 解析body
					// 1. bytes正好只含有body所有数据 return IForwardMessageStatus.COMPLETED;
					// 2. bytes未含有body所有数据 return IForwardMessageStatus.UNCOMPLETED;
					// 3. bytes含有body所有数据且有剩余，接续解析;
					
				}
				System.out.println(ret);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			// 解析body
			break;
		}

		
		
		return 0;
		
	}

}
