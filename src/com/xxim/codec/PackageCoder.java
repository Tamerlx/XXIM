package com.xxim.codec;

public class PackageCoder  extends BaseDodec{
	
	public void packByte(byte val) {
		if (buffer == null) {
			buffer = new byte[512]; // default 512 byte
		}
		buffer[(cursor++)] = val;
	}
	
	public void packShort(short val) {
		if (buffer == null) {
			buffer = new byte[512]; // default 512 byte
		}
		buffer[(cursor++)] = ((byte)(val>>8&0xFF));
		buffer[(cursor++)] = ((byte)(val&0xFF));
	}
	
	public void packInt(int val) {
		if (buffer == null) {
			buffer = new byte[512]; // default 512 byte
		}
		buffer[(cursor++)] = ((byte)(val>>24&0xFF));
		buffer[(cursor++)] = ((byte)(val>>16&0xFF));
		buffer[(cursor++)] = ((byte)(val>>8&0xFF));
		buffer[(cursor++)] = ((byte)(val&0xFF));
	}
	
	public void packLong(long val) {
		if (buffer == null) {
			buffer = new byte[512]; // default 512 byte
		}
		buffer[(cursor++)] = ((byte)(val>>56&0xFF));
		buffer[(cursor++)] = ((byte)(val>>48&0xFF));
		buffer[(cursor++)] = ((byte)(val>>40&0xFF));
		buffer[(cursor++)] = ((byte)(val>>32&0xFF));
		buffer[(cursor++)] = ((byte)(val>>24&0xFF));
		buffer[(cursor++)] = ((byte)(val>>16&0xFF));
		buffer[(cursor++)] = ((byte)(val>>8&0xFF));
		buffer[(cursor++)] = ((byte)(val&0xFF));
	}
	
	public void packLong(byte[] val) {
		if (buffer == null) {
			buffer = new byte[512]; // default 512 byte
		}
		for (byte b : val) {
			buffer[(cursor++)] = b;
		}
	}
}
