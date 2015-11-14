package com.cardsgame.client.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Util {
	public final static String DEFAULT_PLAYER_IMAGE = "images/player.jpg";
	public final static String DEFAULT_CARD_BACK_IMAGE = "images/card_back.jpg";
	private final static ImageIcon playerImage =  new ImageIcon(SouthPanel.class.getResource(DEFAULT_PLAYER_IMAGE));
	private final static ImageIcon cardbackImage =  new ImageIcon(SouthPanel.class.getResource(DEFAULT_CARD_BACK_IMAGE));
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
}
