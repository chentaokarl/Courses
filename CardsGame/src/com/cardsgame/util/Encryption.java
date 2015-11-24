package com.cardsgame.util;
//
//import java.io.Serializable;
//import java.security.Key;
//import java.security.PublicKey;
//
//import javax.crypto.Cipher;
//import javax.crypto.SealedObject;
//
//import com.cardsgame.util.keys.KeysManager;
//
public class Encryption {
//	public static final String ALGORITHM = "RSA";
//	public static final String SYM_ALGORITHM = "AES";
//	public static final String PADDING = "RSA/ECB/PKCS1Padding";
//	public static final String SYM_PADDING = "AES/CBC/PKCS5Padding";
//	private static Encryption encryption = null;
//
//	private Encryption() {
//
//	}
//
//	public static Encryption getInstance() {
//		if (null == encryption) {
//			encryption = new Encryption();
//		}
//		return encryption;
//	}
//
//	public SealedObject encryptMessage(Serializable message, PublicKey publicKey) throws Exception {
//		// get an RSA cipher object
//		final Cipher cipher = Cipher.getInstance(PADDING);
//		// encrypt object using the public key
//		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//		
//		return new SealedObject(message, cipher);
//	}
//
//	public Object decryptMessage(SealedObject rcv) throws Exception {
//		// get an RSA cipher object
//		final Cipher cipher = Cipher.getInstance(PADDING);
//
//		// decrypt object using the public key
//		cipher.init(Cipher.DECRYPT_MODE, KeysManager.getInstance().getMyPrivateKey());
//
//		return rcv.getObject(cipher);
//	}
//	
//	public SealedObject encryptSymMessage(Serializable message, Key sKey) throws Exception {
//		// get an RSA cipher object
//		final Cipher cipher = Cipher.getInstance(SYM_PADDING);
//		// encrypt object using the public key
//		cipher.init(Cipher.ENCRYPT_MODE, sKey);
//		
//		return new SealedObject(message, cipher);
//	}
//
//	public Object decryptSymMessage(SealedObject rcv) throws Exception {
//		// get an RSA cipher object
//		final Cipher cipher = Cipher.getInstance(SYM_PADDING);
//
//		// decrypt object using the public key
//		cipher.init(Cipher.DECRYPT_MODE, KeysManager.getInstance().getSymKey());
//
//		return rcv.getObject(cipher);
//	}
//
}
