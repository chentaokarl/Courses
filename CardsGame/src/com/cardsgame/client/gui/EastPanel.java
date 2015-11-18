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
public class EastPanel extends JPanel {
	private static EastPanel eastPanel;
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

		eastPlayerName.setText("east");
		eastCardsNum.setText("Cards Left: ");
		eastPoints.setText("Points:");
		eastBid.setText("Bid: ");
		eastTotalPoints.setText("Total Points: ");

		javax.swing.GroupLayout eastPanelLayout = new javax.swing.GroupLayout(eastPanel);
        eastPanel.setLayout(eastPanelLayout);
        eastPanelLayout.setHorizontalGroup(
            eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eastPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eastPanelLayout.createSequentialGroup()
                        .addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eastPoints)
                            .addComponent(eastBid))
                        .addGap(96, 96, 96)
                        .addComponent(eastTotalPoints)
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eastPanelLayout.createSequentialGroup()
                        .addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eastPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(eastCardImg))
                            .addGroup(eastPanelLayout.createSequentialGroup()
                                .addComponent(eastCardsNum)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eastPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eastPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(eastPanelLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(eastPlayerName)))
                        .addGap(21, 21, 21))))
        );
        eastPanelLayout.setVerticalGroup(
            eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eastPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eastPanelLayout.createSequentialGroup()
                        .addComponent(eastCardImg)
                        .addGap(21, 21, 21)
                        .addComponent(eastCardsNum)
                        .addGap(4, 4, 4)
                        .addComponent(eastPoints)
                        .addGap(3, 3, 3)
                        .addComponent(eastBid))
                    .addGroup(eastPanelLayout.createSequentialGroup()
                        .addComponent(eastPlayerName)
                        .addGap(4, 4, 4)
                        .addComponent(eastPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eastTotalPoints)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

	}
}
