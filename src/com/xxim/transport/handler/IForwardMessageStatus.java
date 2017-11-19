package com.xxim.transport.handler;

public interface IForwardMessageStatus {
	int ERROR = -1;
	int COMPLETED = 0;
	int HEADERUNCOMPLETED = 1;
	int BODYUNCOMPLETED = 2;
}
