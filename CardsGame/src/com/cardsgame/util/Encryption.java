package com.cardsgame.util;

import java.security.PublicKey;

import javax.crypto.Cipher;	
import javax.crypto.SealedObject;

import com.cardsgame.util.keys.KeysManager;

public class Encryption {
	public static final String ALGORITHM = "RSA";
	public static final String PADDING = "RSA/ECB/PKCS1Padding";

	public SealedObject encryptMessage(Message message, PublicKey publicKey) throws Exception {
		// get an RSA cipher object
		final Cipher cipher = Cipher.getInstance(PADDING);

		// encrypt object using the public key
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		return new SealedObject(new Message(), cipher);
	}

	public Message decryptMessage(SealedObject rcv) throws Exception {
		// get an RSA cipher object
		final Cipher cipher = Cipher.getInstance(PADDING);

		// decrypt object using the public key
		cipher.init(Cipher.DECRYPT_MODE, KeysManager.getInstance().getMyPrivateKey());

		return (Message) rcv.getObject(cipher);
	}

}
