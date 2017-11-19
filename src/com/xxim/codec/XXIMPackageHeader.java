package com.xxim.codec;

/**
 * 	| Magic(2 byte) | Version（1byte）| BodyLength (4byte) | SecType (1byte) | Timeout (1byte) | Magic (2 byte)|
 * 
 * @author liuxu
 *
 */
public class XXIMPackageHeader {

	public char magic_1 = 0xb0;
	public char magic_2 = 0xb0;
	public char version;
	public int bodyLength;
	public char secType;
	public short timeout;
}
