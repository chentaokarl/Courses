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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(eastPanelLayout.createSequentialGroup()
                        .addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eastPanelLayout.createSequentialGroup()
                                    .addComponent(eastCardsNum)
                                    .addGap(131, 131, 131))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eastPanelLayout.createSequentialGroup()
                                    .addComponent(eastCardImg)
                                    .addGap(95, 95, 95)))
                            .addGroup(eastPanelLayout.createSequentialGroup()
                                .addComponent(eastBid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eastPanelLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(eastPlayerName))
                            .addComponent(eastPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99))
                    .addGroup(eastPanelLayout.createSequentialGroup()
                        .addComponent(eastPoints)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eastTotalPoints)
                        .addGap(124, 124, 124))))
        );
        eastPanelLayout.setVerticalGroup(
            eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eastPanelLayout.createSequentialGroup()
                .addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eastPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(eastPlayerName)
                        .addGap(4, 4, 4)
                        .addComponent(eastPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eastPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(eastCardImg)
                        .addGap(18, 18, 18)
                        .addComponent(eastCardsNum)
                        .addGap(5, 5, 5)
                        .addGroup(eastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eastPoints)
                            .addComponent(eastTotalPoints))
                        .addGap(6, 6, 6)
                        .addComponent(eastBid)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

	}
}
