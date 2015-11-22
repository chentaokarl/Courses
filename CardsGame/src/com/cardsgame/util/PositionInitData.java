/**
 * 
 */
package com.cardsgame.util;

import java.io.Serializable;

/**
 * @author Chen
 *
 */
public class PositionInitData implements Serializable{
	private String userName = null;
	private int positionNum = Integer.MIN_VALUE;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPositionNum() {
		return positionNum;
	}
	public void setPositionNum(int positionNum) {
		this.positionNum = positionNum;
	}
	
	
}
