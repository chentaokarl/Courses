/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
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
	private JLabel westTotalPoints;
	
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
		westTotalPoints = new JLabel();
		westBid = new javax.swing.JLabel();

		westCardsNum.setFont(new Font("Tahoma", 0, 30));
		westPoints.setFont(new Font("Tahoma", 0, 30));
		westPlayerName.setFont(new Font("Tahoma", 0, 30));
		westBid.setFont(new Font("Tahoma", 0, 30));
		westTotalPoints.setFont(new Font("Tahoma", 0, 30));

		westPlayerName.setText("west");
		westCardsNum.setText("Cards Left: ");
		westPoints.setText("Points: ");
		westBid.setText("Bid: ");
		westTotalPoints.setText("Total Points: ");

		javax.swing.GroupLayout westPanelLayout = new javax.swing.GroupLayout(westPanel);
        westPanel.setLayout(westPanelLayout);
        westPanelLayout.setHorizontalGroup(
            westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(westPanelLayout.createSequentialGroup()
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(westPlayerName)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, westPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, westPanelLayout.createSequentialGroup()
                                .addComponent(westTotalPoints)
                                .addGap(53, 53, 53))
                            .addComponent(westPlayerImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(westCardImg))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(westPoints)
                            .addComponent(westCardsNum)
                            .addComponent(westBid))))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        westPanelLayout.setVerticalGroup(
            westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(westPanelLayout.createSequentialGroup()
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(westPlayerName)
                        .addGap(1, 1, 1)
                        .addComponent(westPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(westTotalPoints))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(westCardImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(westCardsNum)
                        .addGap(7, 7, 7)
                        .addComponent(westPoints)))
                .addGap(7, 7, 7)
                .addComponent(westBid)
                .addContainerGap(95, Short.MAX_VALUE))
        );
	}

}
