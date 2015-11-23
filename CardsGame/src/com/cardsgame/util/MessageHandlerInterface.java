package com.cardsgame.util;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.security.PublicKey;

public interface MessageHandlerInterface {
	
	public void sendMsg(Socket socket, Serializable message) throws Exception;

	public Object readMsg(Socket socket) throws Exception;
	

//	public String readString(Socket socket) throws Exception;
//
//	public void sendString(Socket socket, String sMsg) throws Exception;

	
}
