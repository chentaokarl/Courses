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

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

import com.cardsgame.util.Message;
import com.cardsgame.util.MessageHandler;
import com.cardsgame.util.MessageHandlerInterface;
import com.cardsgame.util.PositionData;
import com.cardsgame.util.PositionInitData;

/**
 * @author Tao
 *
 */
public class Client {
	public Socket clientSocket = null;
	 public ObjectOutputStream oos = null;
	 public ObjectInputStream ois = null;
	MessageHandlerInterface messageHandler = null;
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 9999;
	private boolean gameOverFlag = false;
	private String clientUserName = null;

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
			System.setProperty("javax.net.ssl.trustStore", "src/mysocket.jks");
		    System.setProperty("javax.net.ssl.trustStorePassword", "mysocket");
			SocketFactory factory = SSLSocketFactory.getDefault();  
			clientSocket = factory.createSocket(SERVER_IP, SERVER_PORT);  
//			oos = new ObjectOutputStream(clientSocket.getOutputStream());
//			ois = new ObjectInputStream(clientSocket.getInputStream());
//			mhi = new MessageHandler();
//			clientSocket = new Socket(SERVER_IP, SERVER_PORT);
			return true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void init(Message msg) throws Exception {
//		if (null != msg.getPublicKey()) {
//			KeysManager.getInstance().putUserPublicKey(Util.SERVER_NAME, msg.getPublicKey());
//		}
		clientUserName = msg.getPositionInitDatas()[msg.getPositionNum() - 1].getUserName();
		TableFrame.getInstance(messageHandler,clientSocket).initTableData(msg.getPositionNum(), msg.getPositionInitDatas());
//		KeysManager.getInstance().putUserSymKey(Util.SERVER_NAME, KeysManager.getInstance().getSymKey());
//		messageHandler.sendMsg(clientSocket, KeysManager.getInstance().getSymKey());
//		messageHandler.sendMsg(clientSocket, "cccc");
//		new ReadThread().start();

		Object message = null;
		try {
			messageHandler = new MessageHandler();
			while (!gameOverFlag) {
				message = messageHandler.readMsg(clientSocket);
				Util.setMyTurnFlag(false);
				if (message instanceof String) {
					String receivedMsg = (String) message;
					if (receivedMsg.contains(Util.CARD_DELIMITER)) {
						TableFrame.getInstance(messageHandler,clientSocket).initCards(receivedMsg.split(Util.CARD_DELIMITER));
						continue;
					}
					if (receivedMsg.startsWith(Util.IDENTIFER_ERROR)) {
						TableFrame.getInstance(messageHandler,clientSocket).showInfoDialogue(receivedMsg);
					}
					String[] receivedData = null;
					receivedData = receivedMsg.split(Util.DELIMITER);
					PositionData pdData = new PositionData();
					if (receivedMsg.startsWith(Util.IDENTIFER_CARDPLAYED)) {
						pdData.setPositionNum(Integer.parseInt(receivedData[1]));
						pdData.setCardPlayed(receivedData[2]);
					} else if (receivedMsg.startsWith(Util.IDENTIFER_ROUND_WINNER)) {
						pdData.setPositionNum(Integer.parseInt(receivedData[2]));
						pdData.setCurrentRoundPoints(Integer.parseInt(receivedData[3]));
						pdData.setInfo(receivedData[0] + receivedData[1]);
						TableFrame.getInstance(messageHandler,clientSocket).roundClear(pdData.getPositionNum());
					} else if (receivedMsg.startsWith(Util.IDENTIFER_GAME_WINNER)) {
						gameOverFlag = true;
						pdData.setInfo(receivedMsg);
						TableFrame.getInstance(messageHandler,clientSocket).showInfoDialogue(receivedMsg);
						
						wait(3000);
					}else {
						pdData.setPositionNum(Integer.parseInt(receivedData[0]));
						pdData.setBid(Integer.parseInt(receivedData[1]));
					}
					TableFrame.getInstance(messageHandler,clientSocket).updateTableData(pdData);
					TableFrame.getInstance(messageHandler,clientSocket).updateCenterInfo(pdData.getInfo() == null ? "" : pdData.getInfo());
				}else if (message instanceof PositionData) {
					TableFrame.getInstance(messageHandler,clientSocket).updateTableData((PositionData)message);
				} else if (message instanceof Message) {
					TableFrame.getInstance(messageHandler,clientSocket).updateCenterInfo(((Message) message).getMessage());
					if (((Message) message).isToBidFlag()) {
						Integer bidValue = -1;
						if (((Message) message).getMessage().startsWith("Error:")) {
							bidValue = TableFrame.getInstance(messageHandler,clientSocket).showBidDialogue(((Message) message).getMessage());
						}
//						messageHandler.sendMsg(clientSocket, "4");
						bidValue = TableFrame.getInstance(messageHandler,clientSocket).showBidDialogue("");
						sendMsg("" + bidValue);
//						Util.setMyTurnFlag(true);
					}
					if (((Message) message).isToPlayFlag()) {
						Util.setMyTurnFlag(true);
					}
				} else if (message instanceof PositionInitData) {
					TableFrame.getInstance(messageHandler,clientSocket).initNewData((PositionInitData) message);
				}
//				else if (message instanceof String[]) {
//					TableFrame.getInstance().initCards((String[])message);
//				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public static Client getInstance() {
		if (null == client) {
			client = new Client();
		}
		return client;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client.getInstance();
	}

//	class ReadThread extends Thread {
//		public ReadThread() {
//		}
//
//		@Override
//		public void run() {
////			MessageHandlerInterface messageHdler = null;
//			Object message = null;
//			try {
//				while (!gameOverFlag) {
////					messageHdler = new MessageHandler();
////					message = messageHdler.readMsg(clientSocket);
//					Util.setMyTurnFlag(false);
//					if (message instanceof String) {
//						String receivedMsg = (String) message;
//						if (receivedMsg.contains(Util.CARD_DELIMITER)) {
//							TableFrame.getInstance().initCards(receivedMsg.split(Util.CARD_DELIMITER));
//							continue;
//						}
//						String[] receivedData = null;
//						receivedData = receivedMsg.split(Util.DELIMITER);
//						PositionData pdData = new PositionData();
//						if (receivedMsg.startsWith(Util.IDENTIFER_CARDPLAYED)) {
//							pdData.setPositionNum(Integer.parseInt(receivedData[1]));
//							pdData.setCardPlayed(receivedData[2]);
//						} else if (receivedMsg.startsWith(Util.IDENTIFER_ROUND_WINNER)) {
//							pdData.setPositionNum(Integer.parseInt(receivedData[2]));
//							pdData.setCurrentRoundPoints(Integer.parseInt(receivedData[3]));
//							pdData.setInfo(receivedData[0] + receivedData[1]);
//							TableFrame.getInstance().roundClear(pdData.getPositionNum());
//						} else if (receivedMsg.startsWith(Util.IDENTIFER_GAME_WINNER)) {
//							gameOverFlag = true;
//							pdData.setInfo(receivedMsg);
//							TableFrame.getInstance().showInfoDialogue(receivedMsg);
//							
//							wait(3000);
//						}else {
//							pdData.setPositionNum(Integer.parseInt(receivedData[0]));
//							pdData.setBid(Integer.parseInt(receivedData[1]));
//						}
//						TableFrame.getInstance().updateTableData(pdData);
//						TableFrame.getInstance().updateCenterInfo(pdData.getInfo() == null ? "" : pdData.getInfo());
//					}else if (message instanceof PositionData) {
//						TableFrame.getInstance().updateTableData((PositionData)message);
//					} else if (message instanceof Message) {
//						TableFrame.getInstance().updateCenterInfo(((Message) message).getMessage());
//						if (((Message) message).isToBidFlag()) {
//							if (((Message) message).getMessage().startsWith("Error:")) {
////								TableFrame.getInstance().showBidDialogue(((Message) message).getMessage());
//							}
////							messageHdler.sendMsg(clientSocket, "4");
////							TableFrame.getInstance().showBidDialogue("");
//							Util.setMyTurnFlag(true);
//						}
//						if (((Message) message).isToPlayFlag()) {
//							Util.setMyTurnFlag(true);
//						}
//					} else if (message instanceof PositionInitData) {
//						TableFrame.getInstance().initNewData((PositionInitData) message);
//					}
////					else if (message instanceof String[]) {
////						TableFrame.getInstance().initCards((String[])message);
////					}
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

	class SendThread extends Thread {
		Serializable message = null;

		public SendThread(Serializable message) {
			this.message = message;
		}

		@Override
		public void run() {
			try {
				messageHandler.sendMsg(clientSocket, message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the clientSocket
	 */
	public Socket getClientSocket() {
		return clientSocket;
	}

	/**
	 * @param clientSocket the clientSocket to set
	 */
	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	
	public void sendMsg(Serializable sendMsg) throws Exception {
		messageHandler.sendMsg(clientSocket, sendMsg);
	}
	

}
