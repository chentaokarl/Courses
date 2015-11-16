package com.cardsgame.server;
import  javax.crypto.SealedObject;
import javax.security.auth.kerberos.KerberosTicket;

import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

import com.cardsgame.util.Message;
/**
 * 
 */

/**
 * @author Tao
 *
 */
public class ServerEncript {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			SealedObject so = new SealedObject(new Message(), Cipher.getInstance("RSA/ECB/PKCS1Padding"));
//			Cipher c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			KeyPairGenerator kg=KeyPairGenerator.getInstance("RSA");
			  KeyPair key=kg.generateKeyPair();
			  System.out.println(key.getPublic());
			  System.out.println(key.getPrivate().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
