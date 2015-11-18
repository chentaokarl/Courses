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
public class NorthPanel extends JPanel {

	private static NorthPanel northPanel ;
	private javax.swing.JLabel northCardImg;
	private javax.swing.JLabel northCardsNum;
	private javax.swing.JLabel northPlayerImage;
	private javax.swing.JLabel northPlayerName;
	private javax.swing.JLabel northPoints;
	private javax.swing.JLabel northBid;
	private JLabel northTotalPoints;

	private NorthPanel() {
		super();
	}
	
	public static NorthPanel getInstance() {
		if (null == northPanel) {
			northPanel = new NorthPanel();
			northPanel.initComp();
		}
		return northPanel;
	}

	private void initComp() {

		northCardsNum = new javax.swing.JLabel();
		northPlayerName = new javax.swing.JLabel();
		northPoints = new javax.swing.JLabel();
		northTotalPoints = new JLabel();
		northBid = new javax.swing.JLabel();
		northPlayerImage = Util.getPlayerLabel("", null);
		northCardImg = Util.getaCardBackLabel("", null);

		northCardsNum.setFont(new Font("Tahoma", 0, 30));
		northPoints.setFont(new Font("Tahoma", 0, 30));
		northPlayerName.setFont(new Font("Tahoma", 0, 30));
		northBid.setFont(new Font("Tahoma", 0, 30));
		northTotalPoints.setFont(new Font("Tahoma", 0, 30));
		
		northCardsNum.setText("Cards Left:");
		northPlayerName.setText("north");
		northPoints.setText("Points:");
		northBid.setText("Bid: ");
		northTotalPoints.setText("Total Points:");

		javax.swing.GroupLayout northPanelLayout = new javax.swing.GroupLayout(northPanel);
        northPanel.setLayout(northPanelLayout);
        northPanelLayout.setHorizontalGroup(
            northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northPanelLayout.createSequentialGroup()
                .addContainerGap(799, Short.MAX_VALUE)
                .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northPanelLayout.createSequentialGroup()
                        .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northPanelLayout.createSequentialGroup()
                                .addComponent(northCardImg, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northPanelLayout.createSequentialGroup()
                                .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(northPoints)
                                    .addComponent(northCardsNum)
                                    .addComponent(northBid))
                                .addGap(139, 139, 139)))
                        .addGap(1206, 1206, 1206))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northPanelLayout.createSequentialGroup()
                        .addComponent(northPlayerName)
                        .addGap(1137, 1137, 1137))))
            .addGroup(northPanelLayout.createSequentialGroup()
                .addGap(1122, 1122, 1122)
                .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(northTotalPoints)
                    .addComponent(northPlayerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        northPanelLayout.setVerticalGroup(
            northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(northPanelLayout.createSequentialGroup()
                .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(northPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(northCardImg, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(northCardsNum))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(northPlayerName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(northPlayerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(northPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(northPoints)
                        .addGap(6, 6, 6)
                        .addComponent(northBid))
                    .addComponent(northTotalPoints)))
        );
	}

}
