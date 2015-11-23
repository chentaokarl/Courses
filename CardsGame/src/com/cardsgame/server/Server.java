package com.cardsgame.server;

/**
 * 
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;

import com.cardsgame.client.gui.Util;
import com.cardsgame.util.Message;
import com.cardsgame.util.MessageHandler;
import com.cardsgame.util.MessageHandlerInterface;
import com.cardsgame.util.PositionData;
import com.cardsgame.util.PositionInitData;

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
			System.setProperty("javax.net.ssl.keyStore", "src/mysocket.jks");
		    System.setProperty("javax.net.ssl.keyStorePassword", "mysocket");
//			serverSocket = new ServerSocket(12345);
			 ServerSocketFactory factory = SSLServerSocketFactory.getDefault();  
			 serverSocket = factory.createServerSocket(9999);  
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not listen on port: " + 9999);
			System.exit(-1);
		}
		
		try {
			initializeCards();
			setup();
			int starter = 0;
			while (winner < 0) {
				shuffle();
				sendCards(0);
				Bid(0);
				Play(0);

				starter = (starter + 1) % 4;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			for (int j = 1; j <= 13; j++) {
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

	public void setup() throws Exception{
			MessageHandlerInterface mhi = new MessageHandler();

			for (int i = 0; i < 4; i++) {
				System.out.println("Waiting for connection");
				user[i] = new User(serverSocket.accept());
				user[i].setPositionNum(i + 1);
				String userName = "User" + (i + 1);
				user[i].setUserName(userName);
				System.out.println("User " + userName + " connected");
				Message sMsg = null;

				PositionInitData[] positionInitDatas = new PositionInitData[i + 1];
				for (int k = 0; k < positionInitDatas.length; k++) {
					positionInitDatas[k] = new PositionInitData();
					positionInitDatas[k].setUserName(user[k].getUserName());
					positionInitDatas[k].setPositionNum(user[k].getPositionNum());
				}
				// send current user list to the other users in the list
				for (int j = 0; j <= i; j++) {
					if (j == i) {
						sMsg = new Message();
//						sMsg.setPublicKey(KeysManager.getInstance().getMyPublicKey());
						sMsg.setPositionInitDatas(positionInitDatas);
						sMsg.setPositionNum(user[i].getPositionNum());
						mhi.sendMsg(user[i].getUserSocket(), sMsg);
					} else {
						// update old users' table
						mhi.sendMsg(user[j].getUserSocket(), positionInitDatas[i]);
					}
				}

				// read public key;
				// set user public key.
//				Key symKey = (Key) mhi.readMsg(user[i].getUserSocket());
//				KeysManager.getInstance().putUserSymKey(user[i].getUserName(), symKey);
//				System.out.println(mhi.readMsg(user[i].getUserSocket()));

				if (i != 3) {
					System.out.println("Waiting for " + (3 - i) + " more connections");
				} else
					System.out.println("Game Start");

			}

	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public void sendCards(int starter) throws Exception {
		MessageHandlerInterface mhiSend = new MessageHandler();
		int start = 0;
		int end = 13;
		for (int i = 0; i < 4; i++) {
			starter = starter % 4;
			user[starter].setCardlist(cards.subList(start, end));
//			ArrayList<String> cardsSubList = (ArrayList<String>) cards.subList(start, end).toArray();
			StringBuilder cardsString = new StringBuilder();
			for(String card : cards.subList(start, end)){
				cardsString.append(card.trim());
				cardsString.append(Util.CARD_DELIMITER);
			}
			mhiSend.sendMsg(user[i].getUserSocket(), cardsString.substring(0, cardsString.lastIndexOf(Util.CARD_DELIMITER)));
			start = start + 13;
			end = end + 13;
			starter++;
		}
	}

	public void Bid(int starter) {
		MessageHandlerInterface mhiBid = new MessageHandler();
		int bidN = -1;
		for (int i = 0; i < 4; i++) {
			Message msg = new Message();
			// set toBidFlag==true
			msg.setToBidFlag(true);
			msg.setMessage("It's your turn to bid");

			while (bidN < 0 || bidN > 13) {
				try {
					mhiBid.sendMsg(this.user[i].getUserSocket(), msg);
					mhiBid = new MessageHandler();
					bidN = Integer.parseInt((String) mhiBid.readMsg(this.user[i].getUserSocket()));
					System.out.println(user[i].getUserName() + ":"+bidN);
					if (bidN < 0 || bidN > 13) {
						msg.setMessage("Error: Not right data format. Please bid 0-13!");
					}
				} catch (NumberFormatException e) {
					bidN = -1;
					msg.setMessage("Error: Not right data format. Please bid 0-13!");
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			user[i].bidNumber = bidN;

			// inform all the users the bid number of User i
			for (int j = 0; j < 4; j++) {
				try {
					if (j != i) {
						mhiBid.sendMsg(user[j].getUserSocket(), user[i].getPositionNum() + Util.DELIMITER + bidN);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			bidN = -1;

		}
	}

	public void Play(int starter) throws Exception {
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
				msg.setToPlayFlag(true);
				msg.setMessage(user[j].getUserName() + "'s turn to play");
				try {
					mhiPlay.sendMsg(this.user[j].getUserSocket(), msg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// block till get valid cardN
				while (cardN == null || !cardisValid(user[j], cardN, roundSuit)) {
					try {
						cardN = (String) mhiPlay.readMsg(this.user[j].getUserSocket());
					} catch (Exception e) {
						cardN = null;
						e.printStackTrace();
					}

				}
				user[j].getCardlist().remove(cardN); // remove card from current
														// cards list
				user[j].setCurrentCard(cardN);
				if (i == 0) {
					roundSuit = cardN.substring(0, 1);
				}

				// send the card user played to other users
				PositionData cardPlayData = new PositionData();
				cardPlayData.setCardPlayed(cardN);
				cardPlayData.setPositionNum(user[j].getPositionNum());
				cardPlayData.setCardsLeft(user[j].getCardlist().size());
				for (int l = 0; l < user.length; l++) {
					mhiPlay.sendMsg(this.user[l].getUserSocket(), cardPlayData);
				}

				cardN = null;
				user[j].cardsLeft = 12 - k;
				j++;

			}

			roundStarter = setRoundWinner(roundStarter);
			(user[roundStarter].points)++;
			// send winner to users
			for (int l = 0; l < user.length; l++) {
				mhiPlay.sendMsg(this.user[l].getUserSocket(),
						Util.IDENTIFER_ROUND_WINNER + Util.DELIMITER + user[roundStarter].getUserName() + Util.DELIMITER
								+ user[roundStarter].getPositionNum() + Util.DELIMITER + user[roundStarter].points);
			}
		}
		int temp = calWinner();

		if (temp >= 0) {
			winner = temp;
			// send winner to all
			for (int i = 0; i < 4; i++) {
				try {
					mhiPlay.sendMsg(user[i].getUserSocket(), Util.IDENTIFER_GAME_WINNER +  Util.DELIMITER + user[winner].getUserName() + " and " +user[winner + 2].getUserName() + ". TotalPoints=" + user[winner].totalScore);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// end game
		} else {
			//upate users' data
			PositionData roundEndData = null;
			for (int l = 0; l < user.length; l++) {
				roundEndData = new PositionData();
				roundEndData.setBid(0);
				roundEndData.setCardsLeft(0);
				roundEndData.setCurrentRoundPoints(0);
				roundEndData.setTotalPoints(user[l].totalScore);
				roundEndData.setPositionNum(user[l].getPositionNum());
				mhiPlay.sendMsg(this.user[l].getUserSocket(), roundEndData);
			}
		}
	}

	public boolean cardisValid(User user, String card, String roundSuit) {
		if (null == card) {
			return false;
		}
		if (user.getCardlist().contains(card)) {
			if (roundSuit != null) {

				if (user.getCardlist().contains(roundSuit + "1") || user.getCardlist().contains(roundSuit + "2")
						|| user.getCardlist().contains(roundSuit + "3") || user.getCardlist().contains(roundSuit + "4")
						|| user.getCardlist().contains(roundSuit + "5") || user.getCardlist().contains(roundSuit + "6")
						|| user.getCardlist().contains(roundSuit + "7") || user.getCardlist().contains(roundSuit + "8")
						|| user.getCardlist().contains(roundSuit + "9") || user.getCardlist().contains(roundSuit + "10")
						|| user.getCardlist().contains(roundSuit + "11")
						|| user.getCardlist().contains(roundSuit + "12")
						|| user.getCardlist().contains(roundSuit + "13")) {
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
		int teamCurrentTricks = user[0].points + user[2].points;
		int teamTotalBid = user[0].bidNumber + user[2].bidNumber;
		if (teamCurrentTricks >= teamTotalBid) {
			user[0].currentScore = teamCurrentTricks - teamTotalBid + 10 * teamTotalBid;
			user[0].totalScore += user[0].currentScore;
			user[0].points = 0;
			user[2].totalScore = user[0].totalScore;
			user[2].points = 0;
		}

		teamCurrentTricks = user[1].points + user[3].points;
		teamTotalBid = user[1].bidNumber + user[3].bidNumber;
		if (teamCurrentTricks >= teamTotalBid) {
			user[1].currentScore = teamCurrentTricks - teamTotalBid + 10 * teamTotalBid;
			user[1].totalScore += user[1].currentScore;
			user[1].points = 0;
			user[3].totalScore = user[1].totalScore;
			user[3].points = 0;
		}

		if (user[0].totalScore > 250 && user[1].totalScore > 250) {
			if (user[0].totalScore > user[1].totalScore) {
				return 0;
			} else {
				return 1;
			}
		}

		if (user[0].totalScore > 250) {
			return 0;
		}

		if (user[1].totalScore > 250) {
			return 1;
		}
		//
		// for (int i = 0; i < 4; i++) {
		// if (user[i].points >= user[i].bidNumber) {
		// user[i].currentScore = user[i].points - user[i].bidNumber + 10 *
		// user[i].bidNumber;
		// user[i].totalScore += user[i].currentScore;
		// if (user[i].totalScore > 250) {
		// winnerFlag = true;
		// total[i] = user[i].totalScore;
		// }
		//
		// } else {
		// user[i].currentScore = user[i].bidNumber * (-10);
		// user[i].totalScore += user[i].currentScore;
		// if (user[i].totalScore > 250) {
		// winnerFlag = true;
		// total[i] = user[i].totalScore;
		// }
		// }
		// send it to client
		// currentScore[i] = user[i].currentScore;
		// }
		// int temp = 0;
		// if (winnerFlag == true) {
		// for (int j = 0; j < 3; j++) {
		// if (total[temp] < total[j + 1])
		// temp = j + 1;
		// }
		// return temp;
		// } else
		return -1;

	}
}
