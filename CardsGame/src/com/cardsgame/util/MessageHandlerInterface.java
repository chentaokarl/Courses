package com.cardsgame.util;

import java.io.IOException;
import java.net.Socket;
import java.security.PublicKey;

public interface MessageHandlerInterface {
	public void sendMsg(Socket socket, Message message) throws Exception;

	public Message readMsg(Socket socket) throws Exception;

	public String readString(Socket socket) throws Exception;

	public void sendString(Socket socket, String sMsg) throws Exception;
	
}
