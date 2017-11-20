package com.xxim.codec;

public class BaseDodec {
	protected byte[] buffer;
	public int cursor;
	
	public BaseDodec() {
		this.cursor = 0;
		this.buffer = null;
	}
	
	public byte[] getBuffer() {
		return buffer;
	}
}
