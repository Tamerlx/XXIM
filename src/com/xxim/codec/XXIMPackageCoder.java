package com.xxim.codec;

public class XXIMPackageCoder {

	private byte[] buffer;
	public int cursor;

	public XXIMPackageCoder() {
		this.cursor = 0;
	}

	public void resetBuf(byte[] bytes) {
		this.buffer = bytes;
	}

	public byte unpackByte() throws Exception {
		if (buffer.length < cursor + 1) {
			throw new RuntimeException("PACK_LENGTH_ERROR");
		}
		return buffer[(cursor++)];
	}

	public byte[] getBuffer() {
		return buffer;
	}

}
