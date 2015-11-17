/**
 * 
 */
package com.cardsgame.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.cardsgame.util.keys.KeysManager;

/**
 * @author Tao
 *
 */
public class Client {
	Socket clientSocket = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	com.cardsgame.util.Message sMsm = null;

	public boolean connect() {
		try {
			sMsm = new com.cardsgame.util.Message();
			sMsm.setPublicKey(KeysManager.getInstance().getMyPublicKey());
			clientSocket = new Socket("127.0.0.1", 9999);
			oos = new ObjectOutputStream(clientSocket.getOutputStream());
			ois = new ObjectInputStream(clientSocket.getInputStream());
			
			smsg.setName(name);
			smsg.setPsw(psw);
			oos.writeObject(smsg);
			msg = (Message) ois.readObject();
			flag = msg.getState();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
