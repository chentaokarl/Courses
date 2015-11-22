package com.cardsgame.util;

import java.awt.image.renderable.RenderableImage;
import java.io.Serializable;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;

import com.cardsgame.util.keys.KeysManager;

public class Encryption {
	public static final String ALGORITHM = "RSA";
	public static final String PADDING = "RSA/ECB/PKCS1Padding";
	private static Encryption encryption = null;

	private Encryption() {

	}

	public static Encryption getInstance() {
		if (null == encryption) {
			encryption = new Encryption();
		}
		return encryption;
	}

	public SealedObject encryptMessage(Serializable message, PublicKey publicKey) throws Exception {
		// get an RSA cipher object
		final Cipher cipher = Cipher.getInstance(PADDING);
		// encrypt object using the public key
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return new SealedObject(message, cipher);
	}

	public Object decryptMessage(SealedObject rcv) throws Exception {
		// get an RSA cipher object
		final Cipher cipher = Cipher.getInstance(PADDING);

		// decrypt object using the public key
		cipher.init(Cipher.DECRYPT_MODE, KeysManager.getInstance().getMyPrivateKey());

		return rcv.getObject(cipher);
	}

}
