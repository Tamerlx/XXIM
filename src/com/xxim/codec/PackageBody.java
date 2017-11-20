package com.xxim.codec;

import com.google.protobuf.InvalidProtocolBufferException;
import com.xxim.codec.protobuf.PBMessage;

public class PackageBody {
	
	public PBMessage.pbmessage decode(byte[] input) throws InvalidProtocolBufferException {
		return PBMessage.pbmessage.parseFrom(input);
		
	}
	
	public void encode() {
		
	}
}
