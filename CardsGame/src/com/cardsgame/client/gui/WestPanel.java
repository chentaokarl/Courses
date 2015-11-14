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
                        .addGap(72, 72, 72)
                        .addComponent(westPlayerImg))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(westPlayerName))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(westTotalPoints)))
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(westPoints)
                            .addComponent(westBid)
                            .addComponent(westCardsNum)))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(westCardImg)))
                .addContainerGap(307, Short.MAX_VALUE))
        );
        westPanelLayout.setVerticalGroup(
            westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(westPanelLayout.createSequentialGroup()
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(westPlayerName)
                        .addGap(4, 4, 4)
                        .addComponent(westPlayerImg)
                        .addGap(6, 6, 6)
                        .addComponent(westTotalPoints))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(westCardImg)
                        .addGap(18, 18, 18)
                        .addComponent(westCardsNum)
                        .addGap(8, 8, 8)
                        .addComponent(westPoints)
                        .addGap(11, 11, 11)
                        .addComponent(westBid)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}

}
