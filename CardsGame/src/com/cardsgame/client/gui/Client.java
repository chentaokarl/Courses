/**
 * 
 */
package com.cardsgame.client.gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.PublicKey;
import java.util.ArrayList;

import com.cardsgame.util.Message;
import com.cardsgame.util.MessageHandler;
import com.cardsgame.util.MessageHandlerInterface;
import com.cardsgame.util.PositionData;
import com.cardsgame.util.PositionInitData;
import com.cardsgame.util.keys.KeysManager;

/**
 * @author Tao
 *
 */
public class Client {
	Socket clientSocket = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	MessageHandlerInterface messageHandler = null;
	public static final String SERVER_NAME = "server";
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 9999;
	private boolean gameOverFlag = false;
	
	private static Client client = null;

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
			System.exit(-1);
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

	private void init(Message msg) throws Exception{
		if (null != msg.getPublicKey()) {
			KeysManager.getInstance().putUserPublicKey(SERVER_NAME, msg.getPublicKey());
		}
		
		TableFrame.getInstance().initTableData(msg.getPositionNum(),msg.getPositionInitDatas());
		new SendThread(KeysManager.getInstance().getMyPublicKey()).start();
		new ReadThread().start();
	}
	
	public static Client getInstance(){
		if (null == client) {
			client = new Client();
		}
		return client;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Client();
	}
	
	class ReadThread extends Thread{
		public ReadThread() {
		}
		@Override
		public void run() {
			MessageHandler messageHdler = new MessageHandler();
			Object message = null;
			try {
				while(!gameOverFlag){
					message = messageHdler.readMsg(clientSocket);
					if (message instanceof PositionData) {
						TableFrame.getInstance().updateTableData((PositionData)message);
					}else if (message instanceof Message) {
						TableFrame.getInstance().updateCenterInfo(((Message)message).getMessage());
						if(((Message)message).isToPlayFlag()){
							Util.setMyTurnFlag(true);
						}
					}else if (message instanceof PositionInitData) {
						TableFrame.getInstance().initNewData((PositionInitData)message);
					}else if (message instanceof ArrayList) {
						TableFrame.getInstance().initCards((String[]) ((ArrayList)message).toArray());
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class SendThread extends Thread{
		Serializable message = null;
		
		public SendThread(Serializable message) {
			this.message = message;
		}
		@Override
		public void run() {
			MessageHandler messageHdler = new MessageHandler();
			try {
				messageHdler.sendMsg(clientSocket, message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
