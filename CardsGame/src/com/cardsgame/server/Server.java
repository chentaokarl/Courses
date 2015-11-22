package com.cardsgame.server;

import javax.crypto.SealedObject;

import javax.security.auth.kerberos.KerberosTicket;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

import com.cardsgame.server.Server.SendMsg;
import com.cardsgame.util.Message;
import com.cardsgame.util.MessageHandler;
import com.cardsgame.util.MessageHandlerInterface;
import com.cardsgame.util.PositionInitData;
import com.cardsgame.util.keys.KeysManager;

import java.util.*;
import java.util.PrimitiveIterator.OfDouble;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.Dialog.ModalExclusionType;
import java.io.*;
/**
 * 
 */

/**
 * @author Tao
 *
 */

public class Server {
	private ServerSocket serverSocket = null;
	User[] user = new User[4];
	ArrayList<String> cards = new ArrayList();
	// initialize cards
	int winner = -1;

	public Server() {

		try {
			serverSocket = new ServerSocket(12345);
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + 12345);
			System.exit(-1);
		}
		initializeCards();
		setup();
		int starter = 0;
		while (winner < 0) {
			shuffle();
			sendCards(starter);
			Bid(starter);
			Play(starter);

			starter = (starter + 1) % 4;
		}
	}

	public static void main(String args[]) {
		Server server = new Server();
	}

	public List<String> getCards() {
		return cards;
	}

	// process
	public void initializeCards() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (i == 0)
					cards.add("h" + j);
				else if (i == 1)
					cards.add("s" + j);
				else if (i == 2)
					cards.add("d" + j);
				else
					cards.add("c" + j);
			}
		}
	}

	public void setup() {
		try {
			MessageHandlerInterface mhi = new MessageHandler();

			for (int i = 0; i < 4; i++) {
				System.out.println("Waiting for connection");
				this.user[i].setUserSocket(this.serverSocket.accept());
				user[i].setPositionNum(i + 1);
				String userName = "User" + (i + 1);
				user[i].setUserName(userName);
				System.out.println("User " + userName + " connected");
				Message sMsg = null;

				PositionInitData[] positionInitDatas = new PositionInitData[user.length];
				for (int k = 0; k < user.length; k++) {
					positionInitDatas[k] = new PositionInitData();
					positionInitDatas[k].setUserName(user[k].getUserName());
					positionInitDatas[k].setPositionNum(user[k].getPositionNum());
				}
				// send current user list to the other users in the list
				for (int j = 0; j <= i; j++) {
					if (j == i) {
						sMsg = new Message();
						sMsg.setPublicKey(KeysManager.getInstance().getMyPublicKey());
						sMsg.setUserName(userName);
						sMsg.setPositionInitDatas(positionInitDatas);
						mhi.sendMsg(user[i].getUserSocket(), sMsg);
					}else{
						//update old users' table
						mhi.sendMsg(user[i].getUserSocket(), positionInitDatas[i]);
					}
				}
				
				// read public key;
				// set user public key.
				String pk = mhi.readString(user[i].getUserSocket());
				KeysManager.getInstance().putUserPublicKey(user[i].getUserName(),
						KeysManager.getInstance().getUserPublicKey(pk));

				if (i != 3) {
					System.out.println("Waiting for " + (3 - i) + " more connections");
				} else
					System.out.println("Game Start");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public void sendCards(int starter) {
		MessageHandlerInterface mhiSend = new MessageHandler();
		int start = 0;
		int end = 12;
		for (int i = 0; i < 4; i++) {
			user[starter].setCardlist(cards.subList(start, end));
			mhiSend.sendMsg(user[i].getUserSocket(), (Serializable) cards.subList(start, end));
			start = start + 13;
			end = end + 13;
			starter++;
		}
	}

	public void Bid(int starter) {
		MessageHandlerInterface mhiBid = new MessageHandler();
		int bidN = -1;
		int k = starter;
		for (int i = 0; i < 4; i++) {
			k = k % 4;
			Message msg = new Message();
			// set toBidFlag==true
			msg.settoBidFlag(true);
			msg.setMessage("It's your turn to bid");
			try {
				mhiBid.sendMsg(this.user[i].getUserSocket(), msg);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			while (bidN < 0 || bidN > 13) {
				try {
					mhiBid.sendMsg(this.user[i].getUserSocket(), msg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					bidN = Integer.parseInt(mhiBid.readString(this.user[i].getUserSocket()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			user[k].bidNumber = bidN;
			// inform all the users the bid number of Useri
			for (int j = 0; j < 4; j++) {
				try {
					mhiBid.sendString(user[j].getUserSocket(), "User" + (k + 1) + " bid " + bidN);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			bidN = -1;
			k++;

		}
	}

	public void Play(int starter) {
		MessageHandlerInterface mhiPlay = new MessageHandler();
		String cardN = null;
		int roundStarter = starter;
		int j = starter;
		String roundSuit = null;
		// first round
		for (int k = 0; k < 13; k++) {
			j = roundStarter;
			for (int i = 0; i < 4; i++) {
				j = j % 4;
				Message msg = new Message();
				// set toPlayFlag==true
				msg.settoPlayFlag(true);
				msg.setMessage("It's your turn to play");
				try {
					mhiPlay.sendMsg(this.user[i].getUserSocket(), msg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// block till get valid cardN
				while (cardN == null && !cardisValid(user[i], cardN, roundSuit)) {
					try {
						cardN = mhiPlay.readString(this.user[i].getUserSocket());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				user[i].setCurrentCard(cardN);
				if (i == 0) {
					roundSuit = cardN.substring(0, 1);
				}
				cardN = null;
				user[i].cardsLeft = 12 - k;
				j++;
			}

			roundStarter = setRoundWinner(roundStarter);
			(user[roundStarter].points)++;
		}
		int temp = calWinner();
		// send Useri the information of himself
		for (int i = 0; i < 4; i++) {
			mhiPlay.senMsg(user[i].getUserSocket(), user[i]);
		}

		if (temp > 0) {
			winner = temp;
			// send winner to all
			for (int i = 0; i < 4; i++) {
				try {
					mhiPlay.sendString(user[i].getUserSocket(), "The winner is User" + winner);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// end game
		}
		;
	}

	public boolean cardisValid(User user, String card, String roundSuit) {
		if (user.cardlist.contains(card)) {
			if (roundSuit != null) {

				if (user.cardlist.contains(roundSuit + "1") || user.cardlist.contains(roundSuit + "2")
						|| user.cardlist.contains(roundSuit + "3") || user.cardlist.contains(roundSuit + "4")
						|| user.cardlist.contains(roundSuit + "5") || user.cardlist.contains(roundSuit + "6")
						|| user.cardlist.contains(roundSuit + "7") || user.cardlist.contains(roundSuit + "8")
						|| user.cardlist.contains(roundSuit + "9") || user.cardlist.contains(roundSuit + "10")
						|| user.cardlist.contains(roundSuit + "11") || user.cardlist.contains(roundSuit + "12")
						|| user.cardlist.contains(roundSuit + "13")) {
					if (card.substring(0, 1).equals(roundSuit)) {
						return true;
					} else
						return false;
				} else
					return true;
			} else
				return true;

		} else
			return false;
	}

	public int setRoundWinner(int roundStarter) {
		int i = roundStarter;
		int indexOfCurrentWinner = roundStarter;
		String suit = user[i].getCurrentCard().substring(0, 1);
		String number = user[i].getCurrentCard().substring(1);
		int tranferToNumber = Integer.parseInt(number);

		for (int j = 0; j < 3; j++) {
			i++;
			i = i % 4;
			// if the suit is the same as the first play
			if (user[i].getCurrentCard().substring(0, 1).equals(suit)) {

				String number1 = user[i].getCurrentCard().substring(1);
				int tranferToNumber1 = Integer.parseInt(number1);
				if (tranferToNumber1 > tranferToNumber) {
					indexOfCurrentWinner = i;
					tranferToNumber = tranferToNumber1;
				}
			}

		}
		return indexOfCurrentWinner;
	}

	public int calWinner() {
		int[] total = new int[4];
		for (int k = 0; k < 4; k++)
			total[k] = 0;
		boolean winnerFlag = false;
		for (int i = 0; i < 4; i++) {
			if (user[i].points >= user[i].bidNumber) {
				user[i].currentScore = user[i].points - user[i].bidNumber + 10 * user[i].bidNumber;
				user[i].totalScore += user[i].currentScore;
				if (user[i].totalScore > 250) {
					winnerFlag = true;
					total[i] = user[i].totalScore;
				}

			} else {
				user[i].currentScore = user[i].bidNumber * (-10);
				user[i].totalScore += user[i].currentScore;
				if (user[i].totalScore > 250) {
					winnerFlag = true;
					total[i] = user[i].totalScore;
				}
			}
			// send it to client
			currentScore[i] = user[i].currentScore;
		}
		int temp = 0;
		if (winnerFlag == true) {
			for (int j = 0; j < 3; j++) {
				if (total[temp] < total[j + 1])
					temp = j + 1;
			}
			return temp;
		} else
			return -1;

	}
}
