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
public class WestPanel extends JPanel {

	private static WestPanel westPanel = new WestPanel();
	private javax.swing.JLabel westCardImg;
	private javax.swing.JLabel westCardsNum;
	private javax.swing.JLabel westPlayerImg;
	private javax.swing.JLabel westPlayerName;
	private javax.swing.JLabel westPoints;
	private javax.swing.JLabel westBid;
	
	private WestPanel() {
		super();
	}

	public static WestPanel getInstance() {
		westPanel.initComp();
		return westPanel;
	}

	private void initComp() {
		westPlayerImg = Util.getPlayerLabel("", null);
		westCardImg = Util.getaCardBackLabel("", null);
		westCardsNum = new javax.swing.JLabel();
		westPlayerName = new javax.swing.JLabel();
		westPoints = new javax.swing.JLabel();
		westBid = new javax.swing.JLabel();

		westCardsNum.setFont(new Font("Tahoma", 0, 30));
		westPoints.setFont(new Font("Tahoma", 0, 30));
		westPlayerName.setFont(new Font("Tahoma", 0, 30));
		westBid.setFont(new Font("Tahoma", 0, 30));

		westPlayerName.setText("west");
		westCardsNum.setText("Cards Left: ");
		westPoints.setText("Points: ");
		westBid.setText("Bid: ");

		javax.swing.GroupLayout westPanelLayout = new javax.swing.GroupLayout(westPanel);
		westPanel.setLayout(westPanelLayout);
		westPanelLayout.setHorizontalGroup(westPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(westPanelLayout.createSequentialGroup().addGroup(westPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(westPanelLayout.createSequentialGroup().addGap(124, 124, 124)
								.addComponent(westPlayerName))
						.addGroup(westPanelLayout.createSequentialGroup().addGap(72, 72, 72).addComponent(westPlayerImg)
								.addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(westPanelLayout.createSequentialGroup().addGap(77, 77, 77)
												.addComponent(westCardImg))
										.addGroup(westPanelLayout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(westPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(westPoints).addComponent(westCardsNum)))))
						.addGroup(westPanelLayout.createSequentialGroup().addGap(112, 112, 112).addComponent(westBid)))
						.addContainerGap(312, Short.MAX_VALUE)));
		westPanelLayout.setVerticalGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(westPanelLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(westPlayerName)
						.addGap(4, 4, 4)
						.addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(westPlayerImg)
								.addGroup(westPanelLayout.createSequentialGroup().addComponent(westCardImg)
										.addGap(17, 17, 17).addComponent(westCardsNum).addGap(18, 18, 18)
										.addComponent(westPoints)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
						.addComponent(westBid).addContainerGap()));
	}

}
