/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Tao
 *
 */
public class EastPanel extends JPanel {
	private static EastPanel eastPanel = new EastPanel();
	private javax.swing.JLabel eastBid;
	private javax.swing.JLabel eastCardImg;
	private javax.swing.JLabel eastCardsNum;
	private javax.swing.JLabel eastPlayerImg;
	private javax.swing.JLabel eastPlayerName;
	private javax.swing.JLabel eastPoints;
	private JLabel eastTotalPoints;

	private EastPanel() {
		super();
	}

	public static EastPanel getInstance() {
		eastPanel.initComp();
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

		eastPlayerName.setText("east");
		eastCardsNum.setText("Cards Left: ");
		eastPoints.setText("Points:");
		eastBid.setText("Bid: ");
		eastTotalPoints.setText("Total Points: ");

		javax.swing.GroupLayout eastPanelLayout = new javax.swing.GroupLayout(eastPanel);
		eastPanel.setLayout(eastPanelLayout);
		eastPanelLayout.setHorizontalGroup(eastPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(eastPanelLayout.createSequentialGroup().addContainerGap(155, Short.MAX_VALUE)
						.addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												eastPanelLayout.createSequentialGroup().addComponent(eastCardsNum)
														.addGap(131, 131, 131))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												eastPanelLayout.createSequentialGroup().addComponent(eastCardImg)
														.addGap(95, 95, 95)))
								.addGroup(eastPanelLayout.createSequentialGroup().addComponent(eastPoints)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
								.addComponent(eastBid))
						.addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(eastPanelLayout.createSequentialGroup().addComponent(eastTotalPoints)
										.addContainerGap())
								.addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												eastPanelLayout.createSequentialGroup().addComponent(eastPlayerImg)
														.addGap(76, 76, 76))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												eastPanelLayout.createSequentialGroup().addComponent(eastPlayerName)
														.addGap(142, 142, 142))))));
		eastPanelLayout
				.setVerticalGroup(
						eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										eastPanelLayout.createSequentialGroup()
												.addGroup(eastPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(eastPanelLayout.createSequentialGroup()
																.addGap(23, 23, 23).addComponent(eastPlayerName)
																.addGap(4, 4, 4).addComponent(eastPlayerImg)
																.addGap(7, 7,
																		7)
																.addComponent(eastTotalPoints))
										.addGroup(eastPanelLayout.createSequentialGroup().addGap(34, 34, 34)
												.addComponent(eastCardImg).addGap(18, 18, 18).addComponent(eastCardsNum)
												.addGap(5, 5, 5).addComponent(eastPoints).addGap(6, 6, 6)
												.addComponent(eastBid)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	}
}
