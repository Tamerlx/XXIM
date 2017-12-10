package com.xxim.transport.handler;

import com.xxim.client.AbstractClient;
import com.xxim.codec.Package;
import com.xxim.codec.PackageBody;
import com.xxim.codec.PackageDecoder;
import com.xxim.codec.PackageHeader;
import com.xxim.codec.PackageType;
import com.xxim.codec.protobuf.PBMessage;

public class ClientHandler implements IProtocol {
	
	public Package currentPackage;
	
	@Override
	public int forwardMessage(AbstractClient client, byte[] bytes, int tag) {
		
		switch (tag) {
		case PackageType.HEADER:
			// 1. 从magic开始
			// 2. 不从magic开始，已经存在部分header
			PackageDecoder coder = new PackageDecoder();
			coder.resetBuf(bytes);
			if (currentPackage == null) {
				currentPackage = new Package();
			}
			
			int ret = -1;
			try {
				ret = currentPackage.getHeader().unpackData(coder);
				
				if (ret == 0) {
					// 解析body
					// 1. bytes正好只含有body所有数据 return IForwardMessageStatus.COMPLETED;
					// 2. bytes未含有body所有数据 return IForwardMessageStatus.UNCOMPLETED;
					// 3. bytes含有body所有数据且有剩余，接续解析;
					PackageHeader header = currentPackage.getHeader();
					System.out.println((char)header.magicHeader_0);
					System.out.println((char)header.magicHeader_1);
					int bodylength = header.bodyLength;
					PackageBody body = new PackageBody();
					byte[] bytes_body = coder.unpackBytes(bodylength);
					PBMessage.pbmessage  pmsg= body.decode(bytes_body);
					
					System.out.println(pmsg);
				}
//				System.out.println(ret);
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
