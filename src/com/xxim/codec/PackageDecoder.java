package com.xxim.codec;

public class PackageDecoder extends BaseDodec {

	public byte unpackByte() throws Exception {
		if (buffer.length < cursor + 1) {
			throw new RuntimeException("PACK_LENGTH_ERROR");
		}
		return buffer[(cursor++)];
	}
	
	public short unpackShort() throws Exception {
		if (buffer.length < cursor + 2) {
			throw new RuntimeException("PACK_LENGTH_ERROR");
		}
	    short retval = 0;
	    for (int i=0;i<2;i++){
	        retval<<=8;
	        retval |=(buffer[(cursor++)] & 0xFF);
	    }
	    return retval;
	}
	
	public int unpackInt() throws Exception {
		if (buffer.length < cursor + 4) {
			throw new RuntimeException("PACK_LENGTH_ERROR");
		}
		int retval = 0;
		for (int i = 0; i < 4; i++) {
			retval<<=8;
	        retval |=(buffer[(cursor++)] & 0xFF);
		}
		return retval;
	}
	
	public long unpackLong() throws Exception {
		if (buffer.length < cursor + 8) {
			throw new RuntimeException("PACK_LENGTH_ERROR");
		}
		long retval = 0;
		for (int i = 0; i < 8; i++) {
			retval<<=8;
	        retval |=(buffer[(cursor++)] & 0xFF);
		}
		return retval;
	}
	
	public byte[] unpackBytes(int len) throws Exception {
		if (len <= 0) return null;
		if (buffer.length < cursor + len) {
			throw new RuntimeException("PACK_LENGTH_ERROR");
		}
		byte[] retbytes = new byte[len];
		for (int i = 0; i < len; i++) {
			retbytes[i] = buffer[(cursor++)];
		}
		return retbytes;
	}
}
