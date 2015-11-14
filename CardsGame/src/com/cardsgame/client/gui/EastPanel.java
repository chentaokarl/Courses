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
public class EastPanel extends JPanel {
	private static EastPanel eastPanel = new EastPanel();
	private javax.swing.JLabel eastBid;
	private javax.swing.JLabel eastCardImg;
	private javax.swing.JLabel eastCardsNum;
	private javax.swing.JLabel eastPlayerImg;
	private javax.swing.JLabel eastPlayerName;
	private javax.swing.JLabel eastPoints;

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
		eastBid = new javax.swing.JLabel();

		eastCardsNum.setFont(new Font("Tahoma", 0, 30));
		eastPoints.setFont(new Font("Tahoma", 0, 30));
		eastPlayerName.setFont(new Font("Tahoma", 0, 30));
		eastBid.setFont(new Font("Tahoma", 0, 30));

		eastPlayerName.setText("east");
		eastCardsNum.setText("Cards Left: ");
		eastPoints.setText("Points:");
		eastBid.setText("Bid: ");

		javax.swing.GroupLayout eastPanelLayout = new javax.swing.GroupLayout(eastPanel);
		eastPanel.setLayout(eastPanelLayout);
		eastPanelLayout.setHorizontalGroup(eastPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eastPanelLayout.createSequentialGroup()
						.addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(eastPanelLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(eastCardImg).addGap(94, 94, 94))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										eastPanelLayout.createSequentialGroup().addGap(167, 167, 167)
												.addGroup(eastPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(eastPoints).addComponent(eastCardsNum))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119,
												Short.MAX_VALUE)))
						.addComponent(eastPlayerImg).addGap(76, 76, 76))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						eastPanelLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												eastPanelLayout.createSequentialGroup().addComponent(eastPlayerName)
														.addGap(142, 142, 142))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eastPanelLayout
										.createSequentialGroup().addComponent(eastBid).addGap(134, 134, 134)))));
		eastPanelLayout.setVerticalGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(eastPanelLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(eastPlayerName)
						.addGap(4, 4, 4)
						.addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(eastPlayerImg)
								.addGroup(eastPanelLayout.createSequentialGroup().addComponent(eastCardImg)
										.addGap(18, 18, 18).addComponent(eastCardsNum)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(eastPoints)))
						.addGap(18, 18, 18).addComponent(eastBid)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	}
}
