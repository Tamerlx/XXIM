package com.xxim.codec;

public class BaseCodec {
	protected byte[] buffer;
	public int cursor;
	
	public BaseCodec() {
		this.cursor = 0;
		this.buffer = null;
	}
	
	public byte[] getBuffer() {
		return buffer;
	}
}
