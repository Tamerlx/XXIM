package com.xxim;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.xxim.client.AbstractClient;
import com.xxim.codec.XXIMPackageType;
import com.xxim.factory.ClientFactory;
import com.xxim.transport.LogicConnection;
import com.xxim.transport.handler.IForwardMessageStatus;
import com.xxim.transport.handler.IProtocol;

public class XXIMRouteManager {
	private final static XXIMRouteManager xximRouteManage = new XXIMRouteManager();
	
	//线程池
	private static ExecutorService exec;
	
	private LogicConnection logicConnection;
	
	private IProtocol handler;
	
	private XXIMRouteManager() {}
	public static XXIMRouteManager getInstance() {
		return xximRouteManage;
	}
	
	public synchronized void setup(LogicConnection logicConnection,int port,IProtocol handler) {
		if(exec == null) {
			exec = Executors.newCachedThreadPool();
		}
		this.logicConnection = logicConnection;
		this.logicConnection.startService(port);
		this.handler = handler;
	}
	
	public void startService() {
		Socket clientSocket = logicConnection.accept();
		String clientIp = clientSocket.getInetAddress().getHostAddress();
		int clientPort = clientSocket.getPort();
		String socketKey = clientIp + ":" + clientPort;
		XXIMContext context = XXIMContext.getInstance();
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				AbstractClient client = null;
				if(context.contains(socketKey)) {
					client = context.getClientById(socketKey);
				}else {
					client = ClientFactory.createClient(socketKey, clientSocket);
					context.setClient(socketKey, client);
				}
				byte[] bytes = new byte[1024];
	            int len = -1;
	            try {
	            		int tag = XXIMPackageType.HEADER;
					while((len=client.read(bytes)) != -1){
						int status = handler.forwardMessage(client, bytes, tag);
						switch (status) {
						case IForwardMessageStatus.BODYUNCOMPLETED:
							tag = XXIMPackageType.BODY;
							break;
						default:
							tag = XXIMPackageType.HEADER;
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		},socketKey);
		
		exec.execute(thread);
	}
}
