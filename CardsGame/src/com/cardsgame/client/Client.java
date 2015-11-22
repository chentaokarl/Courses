/**
 * 
 */
package com.cardsgame.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.PublicKey;

import com.cardsgame.client.gui.SouthPanel;
import com.cardsgame.client.gui.TableFrame;
import com.cardsgame.util.Message;
import com.cardsgame.util.MessageHandler;
import com.cardsgame.util.MessageHandlerInterface;
import com.cardsgame.util.keys.KeysManager;

/**
 * @author Tao
 *
 */
public class Client {
	Socket clientSocket = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	Message sMsm = null;
	MessageHandlerInterface messageHandler = null;
	public static final String SERVER_NAME = "server";
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 9999;

	private Client() {
		try {
			if (connect()) {
				messageHandler = new MessageHandler();
				Message msg = (Message) messageHandler.readMsg(clientSocket);
				init(msg);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean connect() throws Exception {
		try {
			clientSocket = new Socket(SERVER_IP, SERVER_PORT);
			return true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void init(Message msg) {
		if (null != msg.getPublicKey()) {
			KeysManager.getInstance().putUserPublicKey(SERVER_NAME, msg.getPublicKey());
		}
		TableFrame.getInstance();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Client();
	}

}
