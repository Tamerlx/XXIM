package com.xxim.codec;

public class BaseDodec {
	protected byte[] buffer;
	public int cursor;
	
	public BaseDodec() {
		this.cursor = 0;
		this.buffer = null;
	}
	
	public void resetBuf(byte[] bytes) {
		this.buffer = bytes;
		this.cursor = 0;
	}
	
	public byte[] getBuffer() {
		return buffer;
	}
}
