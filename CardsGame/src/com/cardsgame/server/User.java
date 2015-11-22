package com.cardsgame.server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class User {
	private Socket userSocket=null;
	private String userName = null;
	int bidNumber=0;
	int points=0;//0-13
	int cardsLeft=0;//0-13
	int totalScore=0;//total score of the whole game
	int currentScore=0;
	private String currentCard=null;
	private int positionNum = Integer.MIN_VALUE;
	private List<String> cardlist = new ArrayList<>();
	
	public User(Socket socket){
		userSocket = socket;
	}
	/**
	 * @return the userSocket
	 */
	public Socket getUserSocket() {
		return userSocket;
	}
	/**
	 * @param userSocket the userSocket to set
	 */
	public void setUserSocket(Socket userSocket) {
		this.userSocket = userSocket;
	}
	public String getCurrentCard() {
		return currentCard;
	}
	public void setCurrentCard(String currentCard) {
		this.currentCard = currentCard;
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
	 * @return the cardlist
	 */
	public List<String> getCardlist() {
		return cardlist;
	}
	/**
	 * @param cardlist the cardlist to set
	 */
	public void setCardlist(List<String> cardlist) {
		this.cardlist = cardlist;
	}
	
	
	
}
