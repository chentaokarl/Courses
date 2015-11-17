/**
 * 
 */
package com.cardsgame.util;

import java.io.Serializable;
import java.security.PublicKey;

import javax.print.DocFlavor.STRING;

/**
 * @author Tao
 *
 */
public class Message implements Serializable {
	private String userName = null;
	private PublicKey publicKey = null;

	/**
	 * @return the publicKey
	 */
	public PublicKey getPublicKey() {
		return publicKey;
	}

	/**
	 * @param publicKey the publicKey to set
	 */
	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
