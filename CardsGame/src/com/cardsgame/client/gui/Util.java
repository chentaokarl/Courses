package com.cardsgame.client.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Util {
	public final static String DEFAULT_PLAYER_IMAGE = "images/player.jpg";
	public final static String DEFAULT_CARD_BACK_IMAGE = "images/card_back.jpg";
	public final static String DEFAULT_CARD_IMG_PREFIX = "images/";
	public final static String DEFAULT_CARD_IMG_SURFIX = ".jpg";
	public final static String DEFAULT_HINT = "Hint:\nWhen it's your turn,\ndouble click to play \nout one of your cards. ";
	private final static ImageIcon playerImage =  new ImageIcon(Util.class.getResource(DEFAULT_PLAYER_IMAGE));
	private final static ImageIcon cardbackImage =  new ImageIcon(Util.class.getResource(DEFAULT_CARD_BACK_IMAGE));
	private static boolean isMyTurnFlag = false; //to indicate my turn or not. Only In my turn, I can play out card.
	private static boolean gameStartFlag = false;// to indicate game starts or not.
	
	public static JLabel getPlayerLabel(String labelName, ImageIcon newImage) {
		if (null == newImage) {
			return new JLabel(labelName, playerImage, JLabel.CENTER);
		}else{
			return new JLabel(labelName, newImage, JLabel.CENTER);
		}
	}
	
	public static JLabel getaCardBackLabel(String labelName, ImageIcon newBImage) {
		if (null == newBImage) {
			return new JLabel(labelName, cardbackImage, JLabel.CENTER);
		}else{
			return new JLabel(labelName, newBImage, JLabel.CENTER);
		}
	}
	
	public static ImageIcon getImage(String imageName){
		return new ImageIcon(Util.class.getResource(DEFAULT_CARD_IMG_PREFIX + imageName + DEFAULT_CARD_IMG_SURFIX));
	}

	/**
	 * @return the isMyTurnFlag
	 */
	public static boolean isMyTurnFlag() {
		return isMyTurnFlag;
	}

	/**
	 * @param isMyTurnFlag the isMyTurnFlag to set
	 */
	public static void setMyTurnFlag(boolean isMyTurnFlag) {
		Util.isMyTurnFlag = isMyTurnFlag;
	}

	/**
	 * @return the gameStartFlag
	 */
	public static boolean isGameStartFlag() {
		return gameStartFlag;
	}

	/**
	 * @param gameStartFlag the gameStartFlag to set
	 */
	public static void setGameStartFlag(boolean gameStartFlag) {
		Util.gameStartFlag = gameStartFlag;
	}
	
}
