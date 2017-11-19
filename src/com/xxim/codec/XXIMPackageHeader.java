package com.xxim.codec;

/**
 * 	| Magic(2 byte) | Version（1byte）| BodyLength (4byte) | SecType (1byte) | Timeout (1byte) | Magic (2 byte)|
 * 
 * @author liuxu
 *
 */
public class XXIMPackageHeader {

	public byte magicHeader_0;
	public byte magicHeader_1;
	public char version;
	public int bodyLength;
	public char secType;
	public short timeout;
	
	public int unpackData(XXIMPackageCoder pcoder) {
		
		return 0;
	}
}
