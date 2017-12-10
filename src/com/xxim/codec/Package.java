package com.xxim.codec;


public class Package {
	
	public PackageHeader header;
	public PackageBody	body;
	public BaseCodec codec;

	
	public PackageHeader getHeader() {
		if (header == null) {
			header = new PackageHeader();
		}
		return header;
	}
}
