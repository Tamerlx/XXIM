package com.xxim.transport;
import java.net.Socket;

public abstract class LogicConnection {
	public abstract void startService(int port);
	public abstract Socket accept();
}
