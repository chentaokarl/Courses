package com.cardsgame.server;

import java.net.Socket;
import java.security.PublicKey;

public class User {
	private Socket userSocket=null;
	//boolean toPlayFlag=false;
	//boolean toBidFlag=false;
	int bidNumber=0;
	int points=0;//0-13
	int cardsLeft=0;//0-13
	int totalScore=0;//total score of the whole game
	int currentScore=0;
	private String currentCard=null;
	private PublicKey userPublicKey = null;
	
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
	 * @return the userPublicKey
	 */
	public PublicKey getUserPublicKey() {
		return userPublicKey;
	}
	/**
	 * @param userPublicKey the userPublicKey to set
	 */
	public void setUserPublicKey(PublicKey userPublicKey) {
		this.userPublicKey = userPublicKey;
	}

	
	
}
