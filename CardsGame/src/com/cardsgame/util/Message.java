/**
 * 
 */
package com.cardsgame.util;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.List;

import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.print.DocFlavor.STRING;

/**
 * @author Tao
 *
 */
public class Message implements Serializable {
	private String userName = null;
	private PublicKey publicKey = null;
	private List<String> userList = null;
	private String message=null;
	private boolean toBidFlag=false;
	private boolean toPlayFlag=false;
	private int positionNum = Integer.MIN_VALUE;
	private PositionData updateData = null;
	
	private PositionData[] positionDatas = null; 
	
	public Message(){
		
	}
	/**
	 * @return the userList
	 */
	public List<String> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<String> userList) {
		this.userList = userList;
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
	public boolean gettoBidFlag(){
		return this.toBidFlag;
	}
	public void settoBidFlag(boolean flag){
		this.toBidFlag=flag;
	}
	public boolean gettoPlayFlag(){
		return this.toPlayFlag;
	}
	public void settoPlayFlag(boolean flag){
		this.toPlayFlag=flag;
	}
	/**
	 * @return the positionNum
	 */
	public int getPositionNum() {
		return positionNum;
	}
	/**
	 * @param positionNum the positionNum to set
	 */
	public void setPositionNum(int positionNum) {
		this.positionNum = positionNum;
	}
	/**
	 * @return the positionDatas
	 */
	public PositionData[] getPositionDatas() {
		return positionDatas;
	}
	/**
	 * @param positionDatas the positionDatas to set
	 */
	public void setPositionDatas(PositionData[] positionDatas) {
		this.positionDatas = positionDatas;
	}
	/**
	 * @return the updateData
	 */
	public PositionData getUpdateData() {
		return updateData;
	}
	/**
	 * @param updateData the updateData to set
	 */
	public void setUpdateData(PositionData updateData) {
		this.updateData = updateData;
	}
	
	

}
