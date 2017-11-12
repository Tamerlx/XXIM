package com.xxim.factory.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.xxim.utils.StringUtil;

public abstract class AbstractClient {

	private String socketKey;
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	public AbstractClient(String socketKey,Socket socket) {
		if(StringUtil.isEmpty(socketKey)) {
			throw new RuntimeException("id is null");
		}
		if(socket == null) {
			throw new RuntimeException("socket is null");
		}
		this.socketKey = socketKey;
		this.socket = socket;
	}
	
	public int read(byte[] bytes) throws IOException {
		if(inputStream == null) {
			inputStream = socket.getInputStream();
		}
		return inputStream.read(bytes);
	}
	
	public void write(byte[] bytes) throws IOException {
		if(outputStream == null) {
			outputStream = socket.getOutputStream();
		}
		outputStream.write(bytes);
		outputStream.flush();
	}
}
