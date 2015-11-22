/**
 * 
 */
package com.cardsgame.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.security.PublicKey;

import javax.crypto.SealedObject;

import com.cardsgame.util.keys.KeysManager;

/**
 * @author tao
 *
 */
public class MessageHandler implements MessageHandlerInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cardsgame.server.MessageHandlerInterface#send(java.lang.Object)
	 */
	@Override
	public void sendMsg(Socket socket, Serializable message) throws Exception {
		PublicKey publicKey = null;
		if (message instanceof PositionInitData) {
			publicKey = KeysManager.getInstance().getUserPublicKey(((PositionInitData) message).getUserName());
		} else if (message instanceof Message) {
			publicKey = KeysManager.getInstance().getUserPublicKey(((Message) message).getUserName());
		}else if (message instanceof String) {
			sendString(socket, (String) message);
			return;
		}

		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		if (null != publicKey) {
			SealedObject sealedObject = Encryption.getInstance().encryptMessage(message, publicKey);
			oos.writeObject(sealedObject);
		} else {
			oos.writeObject(message);
		}
		oos.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cardsgame.server.MessageHandlerInterface#read(java.lang.Object)
	 */
	@Override
	public Object readMsg(Socket socket) throws Exception {
		// TODO Auto-generated method stub
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		Object obj = ois.readObject();
		if (obj instanceof SealedObject) {
			return Encryption.getInstance().decryptMessage((SealedObject) (ois.readObject()));
		}

		return obj;
	}

	public String readString(Socket socket) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		return ois.readUTF();
	}

	@Override
	public void sendString(Socket socket, String sMsg) throws Exception {
		// TODO Auto-generated method stub
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeUTF(sMsg);
		oos.flush();
	}

}
