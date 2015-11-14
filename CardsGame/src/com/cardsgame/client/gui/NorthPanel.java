/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;

/**
 * @author Tao
 *
 */
public class NorthPanel extends JPanel {

	private static NorthPanel northPanel = new NorthPanel();
	private javax.swing.JLabel northCardImg;
	private javax.swing.JLabel northCardsNum;
	private javax.swing.JLabel northPlayerImage;
	private javax.swing.JLabel northPlayerName;
	private javax.swing.JLabel northPoints;
	private javax.swing.JLabel northBid;

	private NorthPanel() {
		super();
	}
	
	public static NorthPanel getInstance() {
		northPanel.initComp();
		return northPanel;
	}

	private void initComp() {

		northCardsNum = new javax.swing.JLabel();
		northPlayerName = new javax.swing.JLabel();
		northPoints = new javax.swing.JLabel();
		northBid = new javax.swing.JLabel();
		northPlayerImage = Util.getPlayerLabel("", null);
		northCardImg = Util.getaCardBackLabel("", null);

		northCardsNum.setFont(new Font("Tahoma", 0, 30));
		northPoints.setFont(new Font("Tahoma", 0, 30));
		northPlayerName.setFont(new Font("Tahoma", 0, 30));
		northBid.setFont(new Font("Tahoma", 0, 30));
		
		northCardsNum.setText("Cards Left:");
		northPlayerName.setText("north");
		northPoints.setText("Points:");

		northBid.setText("Bid: ");

		javax.swing.GroupLayout northPanelLayout = new javax.swing.GroupLayout(northPanel);
		northPanel.setLayout(northPanelLayout);
		northPanelLayout.setHorizontalGroup(northPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(northPanelLayout.createSequentialGroup().addContainerGap(917, Short.MAX_VALUE)
						.addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										northPanelLayout.createSequentialGroup().addComponent(northPlayerName)
												.addGap(909, 909, 909))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										northPanelLayout.createSequentialGroup().addGroup(northPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(northPoints)
												.addGroup(northPanelLayout.createSequentialGroup()
														.addGroup(northPanelLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																		northPanelLayout.createSequentialGroup()
																				.addComponent(northCardImg)
																				.addGap(82, 82, 82))
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																		northPanelLayout.createSequentialGroup()
																				.addComponent(northCardsNum)
																				.addGap(122, 122, 122)))
														.addComponent(northPlayerImage)))
												.addGap(864, 864, 864))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northPanelLayout
										.createSequentialGroup().addComponent(northBid).addGap(916, 916, 916)))));
		northPanelLayout
				.setVerticalGroup(
						northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(northPanelLayout.createSequentialGroup().addContainerGap()
										.addComponent(northPlayerName).addGap(8, 8, 8)
										.addGroup(northPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(northPanelLayout.createSequentialGroup()
														.addComponent(northCardImg)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(northCardsNum)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(northPoints)).addComponent(northPlayerImage))
						.addGap(18, 18, 18).addComponent(northBid)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

}
