/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Tao
 *
 */
public class SouthPanel extends JPanel {
	private static SouthPanel southPanel = new SouthPanel();
	private javax.swing.JLabel southCardsNum;
	private javax.swing.JPanel southCardsPanel;
	private javax.swing.JButton southPlayBtn;
	private javax.swing.JLabel southPlayerImg;
	private javax.swing.JLabel southPlayerName;
	private javax.swing.JLabel southPoints;
	private javax.swing.JTextArea southDisplayArea;
	private javax.swing.JScrollPane southJScrollPane1;
	private JLabel southBid;

	private SouthPanel() {
		super();
	}

	public static SouthPanel getInstance() {
		southPanel.initComp();
		return southPanel;
	}

	private void southPlayBtnActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}
	
	public void initCardsPanel(String[] cards){
		
	}

	private void initComp() {
		southPlayerImg = Util.getPlayerLabel("", null);
		southPlayerName = new javax.swing.JLabel();
		southCardsPanel = new javax.swing.JPanel();
		southCardsNum = new javax.swing.JLabel();
		southPoints = new javax.swing.JLabel();
		southBid = new javax.swing.JLabel();
		southPlayBtn = new javax.swing.JButton();
		southJScrollPane1 = new javax.swing.JScrollPane();
		southDisplayArea = new javax.swing.JTextArea();

		southCardsNum.setFont(new Font("Tahoma", 0, 30));
		southPoints.setFont(new Font("Tahoma", 0, 30));
		southPlayerName.setFont(new Font("Tahoma", 0, 30));
		southBid.setFont(new Font("Tahoma", 0, 30));

		javax.swing.GroupLayout southCardsPanelLayout = new javax.swing.GroupLayout(southCardsPanel);
		southCardsPanel.setLayout(southCardsPanelLayout);
		southCardsPanelLayout.setHorizontalGroup(southCardsPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1313, Short.MAX_VALUE));
		southCardsPanelLayout.setVerticalGroup(southCardsPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 241, Short.MAX_VALUE));

		southCardsNum.setText("Cards Left: ");
		southPlayerName.setText("south");
		southPoints.setText("Points: ");
		southBid.setText("Bid:");

		southPlayBtn.setText("Play");
		southPlayBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				southPlayBtnActionPerformed(evt);
			}
		});

		southDisplayArea.setColumns(20);
		southDisplayArea.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
		southDisplayArea.setRows(5);
		southDisplayArea.setText("Hint:\n1. Select one card of\nyours.\n2. Click 'Play'Button \nto play out cards.");
		southJScrollPane1.setViewportView(southDisplayArea);


		javax.swing.GroupLayout southPanelLayout = new javax.swing.GroupLayout(southPanel);
		southPanel.setLayout(southPanelLayout);
		southPanelLayout.setHorizontalGroup(southPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(southPanelLayout.createSequentialGroup()
						.addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(southPanelLayout.createSequentialGroup().addGap(239, 239, 239)
										.addComponent(southPlayerImg))
								.addGroup(southPanelLayout.createSequentialGroup().addGap(282, 282, 282)
										.addComponent(southPlayerName)))
						.addGap(154, 154, 154)
						.addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(southPanelLayout.createSequentialGroup().addComponent(southBid)
										.addGap(212, 212, 212).addComponent(southCardsNum).addGap(209, 209, 209)
										.addComponent(southPoints).addGap(252, 252, 252)
										.addComponent(southPlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(southPanelLayout.createSequentialGroup()
										.addComponent(southCardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(southJScrollPane1)))));
		southPanelLayout.setVerticalGroup(southPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(southPanelLayout.createSequentialGroup().addContainerGap().addGroup(southPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(southPlayerImg)
						.addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(southJScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(southCardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 18, 18)
						.addGroup(
								southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(southPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(southPlayerName).addComponent(southBid))
								.addComponent(southPlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(southPoints).addComponent(southCardsNum)))
						.addContainerGap(49, Short.MAX_VALUE)));
	}

}
