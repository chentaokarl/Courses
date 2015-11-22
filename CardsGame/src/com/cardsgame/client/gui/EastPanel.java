/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cardsgame.util.PositionData;

/**
 * @author Tao
 *
 */
public class EastPanel extends JPanel {
	private static EastPanel eastPanel;
	private javax.swing.JLabel eastBid;
	private javax.swing.JLabel eastCardImg;
	private javax.swing.JLabel eastCardsNum;
	private javax.swing.JLabel eastPlayerImg;
	private javax.swing.JLabel eastPlayerName;
	private javax.swing.JLabel eastPoints;
	private JLabel eastTotalPoints;

	private int positionNum = Integer.MIN_VALUE;

	private EastPanel() {
		super();
	}

	public static EastPanel getInstance() {
		if (null == eastPanel) {
			eastPanel = new EastPanel();
			eastPanel.initComp();
		}
		return eastPanel;
	}

	private void initComp() {
		eastPlayerImg = Util.getPlayerLabel("", null);
		eastCardImg = Util.getaCardBackLabel("", null);
		eastPlayerName = new javax.swing.JLabel();
		eastCardsNum = new javax.swing.JLabel();
		eastPoints = new javax.swing.JLabel();
		eastTotalPoints = new JLabel();
		eastBid = new javax.swing.JLabel();

		eastCardsNum.setFont(new Font("Tahoma", 0, 30));
		eastPoints.setFont(new Font("Tahoma", 0, 30));
		eastPlayerName.setFont(new Font("Tahoma", 0, 30));
		eastBid.setFont(new Font("Tahoma", 0, 30));
		eastTotalPoints.setFont(new Font("Tahoma", 0, 30));

		// eastPlayerImg.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("images/player.jpg")));
		// // NOI18N

		eastPlayerName.setText("east");

		// eastCardImg.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("images/card_back.jpg")));
		// // NOI18N

		eastCardsNum.setText("Cards Left: ");

		eastPoints.setText("Points:");

		eastBid.setText("Bid: ");

		eastTotalPoints.setText("Total Points: ");

		javax.swing.GroupLayout eastPanelLayout = new javax.swing.GroupLayout(eastPanel);
		eastPanel.setLayout(eastPanelLayout);
		eastPanelLayout
				.setHorizontalGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(eastPanelLayout.createSequentialGroup().addContainerGap().addGroup(eastPanelLayout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(eastPanelLayout.createSequentialGroup()
										.addGroup(eastPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(eastPoints).addComponent(eastBid))
										.addGap(96, 96, 96).addComponent(eastTotalPoints)
										.addContainerGap(36, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										eastPanelLayout.createSequentialGroup().addGroup(eastPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(eastPanelLayout.createSequentialGroup()
														.addGap(0, 0, Short.MAX_VALUE).addComponent(eastCardImg))
												.addGroup(eastPanelLayout.createSequentialGroup()
														.addComponent(eastCardsNum).addGap(0, 0, Short.MAX_VALUE)))
										.addGroup(eastPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(eastPanelLayout.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(eastPlayerImg,
																javax.swing.GroupLayout.PREFERRED_SIZE, 171,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(eastPanelLayout.createSequentialGroup().addGap(81, 81, 81)
														.addComponent(eastPlayerName)))
												.addGap(21, 21, 21)))));
		eastPanelLayout
				.setVerticalGroup(
						eastPanelLayout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(eastPanelLayout.createSequentialGroup().addGap(12, 12,
										12)
								.addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(eastPanelLayout.createSequentialGroup().addComponent(eastCardImg)
												.addGap(21, 21, 21).addComponent(eastCardsNum).addGap(4, 4, 4)
												.addComponent(eastPoints).addGap(3, 3, 3).addComponent(eastBid))
						.addGroup(eastPanelLayout.createSequentialGroup().addComponent(eastPlayerName).addGap(4, 4, 4)
								.addComponent(eastPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 146,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(eastTotalPoints)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	}

	/**
	 * @return the positionNum
	 */
	public int getPositionNum() {
		return positionNum;
	}

	/**
	 * @param positionNum
	 *            the positionNum to set
	 */
	public void setPositionNum(int positionNum) {
		this.positionNum = positionNum;
	}

	public void initData(PositionData positionData) {
		setPositionNum(positionData.getPositionNum());
		eastPlayerName.setText(positionData.getUserName());
		eastPlayerName.validate();
		eastPanel.validate();
	}

	public void updateData(PositionData positionData) {
		String newText = null;
		if (Integer.MIN_VALUE != positionData.getTotalPoints()) {
			eastTotalPoints.setText("" + positionData.getTotalPoints());
		} 
		if (Integer.MIN_VALUE != positionData.getCardsLeft()) {
			eastCardsNum.setText("" + positionData.getCardsLeft());
		} 
		if (Integer.MIN_VALUE != positionData.getCurrentRoundPoints()) {
			eastPoints.setText("" + positionData.getCurrentRoundPoints());
		} 
		if (Integer.MIN_VALUE != positionData.getBid()) {
			eastBid.setText("" + positionData.getBid());
		}
		if (null != positionData.getCardPlayed()) {
			CenterPanel.getInstance().updateEastCardPlayed(positionData.getCardPlayed());
		}
		
		eastTotalPoints.validate();
		eastCardsNum.validate();
		eastPoints.validate();
		eastBid.validate();
		eastPanel.validate();
	}

}
