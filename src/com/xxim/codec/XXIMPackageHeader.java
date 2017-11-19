package com.xxim.codec;

/**
 * 	| MAGIC_SOH (1 byte) | Version（1byte）| BodyLength (4byte) | SecType (1byte) | Timeout (1byte) | MAGIC_STX (1 byte)|
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
	
	public int unpackData(XXIMPackageCoder pcoder) throws Exception {
		byte m_0 = pcoder.unpackByte();
		if (m_0 != Const.MAGIC_SOH) {
			
		}
		
		byte m_1 = pcoder.unpackByte();
		if (m_1 != Const.MAGIC_STX) {
			
		}
		
		return 0;
	}
}
