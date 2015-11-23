/**
 * 
 */
package com.cardsgame.util;

import java.io.Serializable;

/**
 * @author Tao
 *
 */
public class PositionData implements Serializable {
	private String userName = null;
	private String info = null;
	private  int positionNum = Integer.MIN_VALUE;
	private int cardsLeft = Integer.MIN_VALUE;
	private int currentRoundPoints = Integer.MIN_VALUE;
	private int totalPoints = Integer.MIN_VALUE;
	private int bid = Integer.MIN_VALUE;
	private String cardPlayed  = null;
	
	public PositionData() {
		// TODO Auto-generated constructor stub
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
	 * @return the cardsLeft
	 */
	public int getCardsLeft() {
		return cardsLeft;
	}

	/**
	 * @param cardsLeft the cardsLeft to set
	 */
	public void setCardsLeft(int cardsLeft) {
		this.cardsLeft = cardsLeft;
	}


	/**
	 * @return the totalPoints
	 */
	public int getTotalPoints() {
		return totalPoints;
	}

	/**
	 * @param totalPoints the totalPoints to set
	 */
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	/**
	 * @return the bid
	 */
	public int getBid() {
		return bid;
	}

	/**
	 * @param bid the bid to set
	 */
	public void setBid(int bid) {
		this.bid = bid;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the cardPlayed
	 */
	public String getCardPlayed() {
		return cardPlayed;
	}
	
	

	/**
	 * @return the currentRoundPoints
	 */
	public int getCurrentRoundPoints() {
		return currentRoundPoints;
	}

	/**
	 * @param currentRoundPoints the currentRoundPoints to set
	 */
	public void setCurrentRoundPoints(int currentRoundPoints) {
		this.currentRoundPoints = currentRoundPoints;
	}

	/**
	 * @param cardPlayed the cardPlayed to set
	 */
	public void setCardPlayed(String cardPlayed) {
		this.cardPlayed = cardPlayed;
	}
	
	
	
}
