/**
 * 
 */
package com.cardsgame.util;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.print.DocFlavor.STRING;

/**
 * @author Tao
 *
 */
public class Message implements Serializable {
	private String userName = null;
	private PublicKey publicKey = null;
	private String message=null;
	private boolean toBidFlag=false;
	private boolean toPlayFlag=false;
	private int positionNum = Integer.MIN_VALUE;
	
	private PositionInitData[] positionInitDatas = null;
	
	public Message(){
		
	}

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
	public void setMessage(String message) {
		this.message = message;

	}
	public String getMessage(){
		return this.message;
	}
	
	/**
	 * @return the positionNum
	 */
	public int getPositionNum() {
		return positionNum;
	}
	/**
	 * @return the toBidFlag
	 */
	public boolean isToBidFlag() {
		return toBidFlag;
	}

	/**
	 * @param toBidFlag the toBidFlag to set
	 */
	public void setToBidFlag(boolean toBidFlag) {
		this.toBidFlag = toBidFlag;
	}

	/**
	 * @return the toPlayFlag
	 */
	public boolean isToPlayFlag() {
		return toPlayFlag;
	}

	/**
	 * @param toPlayFlag the toPlayFlag to set
	 */
	public void setToPlayFlag(boolean toPlayFlag) {
		this.toPlayFlag = toPlayFlag;
	}

	/**
	 * @param positionNum the positionNum to set
	 */
	public void setPositionNum(int positionNum) {
		this.positionNum = positionNum;
	}

	public PositionInitData[] getPositionInitDatas() {
		return positionInitDatas;
	}

	public void setPositionInitDatas(PositionInitData[] positionInitDatas) {
		this.positionInitDatas = positionInitDatas;
	}
	
	

}
