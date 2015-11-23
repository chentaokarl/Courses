//package com.cardsgame.util.keys;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.security.Key;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.SecureRandom;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.crypto.KeyGenerator;
//
//import com.cardsgame.util.Encryption;
//import com.cardsgame.util.EncryptionException;
//
//public class KeysManager {
//	private static KeysManager pKeyManager = new KeysManager();
//	private String keysPath = this.getClass().getResource("").getFile();
//
//	private static final String PRIVATE_KEY_FILE = "private.key";
//	private static final String PUBLIC_KEY_FILE = "public.key";
//
//	private PublicKey myPublicKey = null;
//	private PrivateKey myPrivateKey = null;
//
//	private Key symKey = null;
//
//	private Map<String, PublicKey> userPublicKeys = new HashMap<>();
//	private Map<String, Key> userSymKeys = new HashMap<>();
//
//	private KeysManager() {
//		generateMyKeyPair();
//		symKey = generateSymKey();
//	}
//
//	public static KeysManager getInstance() {
//		return pKeyManager;
//	}
//
//	public String getKeysPath() {
//		return keysPath;
//	}
//
//	public boolean checkKeyFile(String keyFileName) {
//		File keyFile = new File(getKeyPath(keyFileName));
//		if (keyFile.exists())
//			return true;
//		return false;
//	}
//
//	private String getKeyPath(String keyName) {
//		System.out.println(keysPath + keyName);
//		return keysPath + keyName;
//	}
//
//	protected void generateMyKeyPair() {
//		try {
//			if (checkKeyFile(PUBLIC_KEY_FILE) && checkKeyFile(PRIVATE_KEY_FILE)) {
//				return;
//			}
//			final KeyPairGenerator kg = KeyPairGenerator.getInstance(Encryption.ALGORITHM);
//			final KeyPair keyPair = kg.generateKeyPair();
//			myPrivateKey = keyPair.getPrivate();
//			myPublicKey = keyPair.getPublic();
//
//			File privateKeyFile = new File(PRIVATE_KEY_FILE);
//			File publicKeyFile = new File(PUBLIC_KEY_FILE);
//			if (privateKeyFile.exists()) {
//				privateKeyFile.delete();
//			}
//			if (publicKeyFile.exists()) {
//				publicKeyFile.delete();
//			}
//
//			privateKeyFile.createNewFile();
//			publicKeyFile.createNewFile();
//
//			// Saving the Public key in a file
//			ObjectOutputStream publicKeyOS = new ObjectOutputStream(new FileOutputStream(publicKeyFile));
//			publicKeyOS.writeObject(myPublicKey);
//			publicKeyOS.close();
//
//			// Saving the Private key in a file
//			ObjectOutputStream privateKeyOS = new ObjectOutputStream(new FileOutputStream(privateKeyFile));
//			privateKeyOS.writeObject(myPrivateKey);
//			privateKeyOS.close();
//
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public PublicKey getMyPublicKey() throws Exception {
//		if (null == myPublicKey) {
//			try {
//				myPublicKey = readPublicKey(PUBLIC_KEY_FILE);
//			} catch (EncryptionException e) {
//				// TODO Auto-generated catch block
//				if (e.getMessage().endsWith(PUBLIC_KEY_FILE)) {
//					generateMyKeyPair();
//				} else {
//					throw new Exception(e.getMessage(), e);
//				}
//			}
//		}
//
//		return myPublicKey;
//	}
//
//	public PrivateKey getMyPrivateKey() throws Exception {
//		if (null == myPrivateKey) {
//			try {
//				myPrivateKey = readPrivateKey(PRIVATE_KEY_FILE);
//			} catch (EncryptionException e) {
//				// TODO Auto-generated catch block
//				if (e.getMessage().endsWith(PRIVATE_KEY_FILE)) {
//					generateMyKeyPair();
//				} else {
//					throw new Exception(e.getMessage(), e);
//				}
//			}
//		}
//
//		return myPrivateKey;
//	}
//
//	private PublicKey readPublicKey(String keyFileName) throws Exception {
//		PublicKey publicKey = null;
//		if (!checkKeyFile(keyFileName)) {
//			throw new EncryptionException("No such key file : " + keyFileName);
//		}
//		ObjectInputStream inputStream = null;
//
//		try {
//			inputStream = new ObjectInputStream(new FileInputStream(getKeyPath(keyFileName)));
//			publicKey = (PublicKey) inputStream.readObject();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		return publicKey;
//	}
//
//	private PrivateKey readPrivateKey(String keyFileName) throws Exception {
//		PrivateKey privateKey = null;
//		if (!checkKeyFile(keyFileName)) {
//			throw new EncryptionException("No such key file : " + keyFileName);
//		}
//		ObjectInputStream inputStream = null;
//
//		try {
//			inputStream = new ObjectInputStream(new FileInputStream(getKeyPath(keyFileName)));
//			privateKey = (PrivateKey) inputStream.readObject();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return privateKey;
//	}
//
//	public void putUserPublicKey(String userName, PublicKey pbk) {
//		userPublicKeys.put(userName, pbk);
//	}
//
//	public PublicKey getUserPublicKey(String userName) throws EncryptionException {
//		if (null == userPublicKeys.get(userName)) {
//			// throw new EncryptionException("No public key for user " +
//			// userName );
//			return null;
//		}
//		return userPublicKeys.get(userName);
//	}
//
//	public Key generateSymKey() {
//		try {
//			KeyGenerator kg = KeyGenerator.getInstance(Encryption.SYM_ALGORITHM);
//			SecureRandom random = new SecureRandom();
//			kg.init(random);
//			symKey = kg.generateKey();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return symKey;
//	}
//	
//	public void putUserSymKey(String userName, Key sKey) {
//		userSymKeys.put(userName, sKey);
//	}
//
//	public Key getUserSymKey(String userName) throws EncryptionException {
//		if (null == userSymKeys.get(userName)) {
//			// throw new EncryptionException("No public key for user " +
//			// userName );
//			return null;
//		}
//		return userSymKeys.get(userName);
//	}
//
//	/**
//	 * @return the symKey
//	 */
//	public Key getSymKey() {
//		if (null == symKey) {
//			symKey = generateSymKey();
//		}
//		return symKey;
//	}
//
//	/**
//	 * @param symKey the symKey to set
//	 */
//	public void setSymKey(Key symKey) {
//		this.symKey = symKey;
//	}
//	
//	
//}
