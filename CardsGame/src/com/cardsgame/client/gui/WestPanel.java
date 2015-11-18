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
                        .addGap(13, 13, 13)
                        .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(westPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(westTotalPoints)))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(westPlayerName)))
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(westCardImg))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(westCardsNum)
                            .addComponent(westPoints)
                            .addComponent(westBid))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        westPanelLayout.setVerticalGroup(
            westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(westPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addComponent(westPlayerName)
                        .addGap(3, 3, 3)
                        .addComponent(westPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(westTotalPoints)
                            .addComponent(westPoints)))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addComponent(westCardImg)
                        .addGap(18, 18, 18)
                        .addComponent(westCardsNum)))
                .addGap(4, 4, 4)
                .addComponent(westBid)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}

}
