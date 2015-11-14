/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
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
	private JLabel card1 = new JLabel();
	private JLabel card2 = new JLabel();
	private JLabel card3 = new JLabel();
	private JPanel jPanel1 = new JPanel();

	private SouthPanel() {
		super();
	}

	public static SouthPanel getInstance() {
		southPanel.initComp();
		return southPanel;
	}

	private void southPlayBtnActionPerformed(java.awt.event.ActionEvent evt) {
		initCardsPanel(new String[] { "c8", "d9" });
	}
	
	private void card1MouseClicked(MouseEvent evt) {
		JLabel source = (JLabel) evt.getSource();
		jPanel1.remove(source);
		source = null;
		jPanel1.repaint();
		jPanel1.validate();
		southCardsPanel.validate();
		southPanel.validate();
	}

	public void initCardsPanel(String[] cards) {
		 for (int i = 0; i < cards.length; i++) {
		 JLabel card = new JLabel(new
		 ImageIcon(SouthPanel.class.getResource("images/" + cards[i] +
		 ".jpg")));
		 jPanel1.add(card);
		 }
		jPanel1.repaint();
		jPanel1.validate();
		southCardsPanel.validate();
		southPanel.validate();
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
	        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
	        ImageIcon ccc = new ImageIcon(SouthPanel.class.getResource("images/c3.jpg"));
	        card1.setIcon(ccc);
//	        card1.setSize(ccc.getIconWidth(), ccc.getIconHeight());
//	        jPanel1.setBounds(200, 0, 400, 300);
			card2.setIcon(new ImageIcon(SouthPanel.class.getResource("images/d4.jpg")));
			 card1.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		            	if (evt.getClickCount() == 2) {
		            		card1MouseClicked(evt);
						}
		            }
		        });
			 card2.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		            	if (evt.getClickCount() == 2) {
		            		card1MouseClicked(evt);
						}
		            }
		        });
			jPanel1.add(card1);
			jPanel1.add(card2);

	        southCardsPanel.setLayout(southCardsPanelLayout);
	        southCardsPanelLayout.setHorizontalGroup(
	            southCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, southCardsPanelLayout.createSequentialGroup()
	                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        southCardsPanelLayout.setVerticalGroup(
	            southCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, southCardsPanelLayout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(13, 13, 13))
	        );
		
		
		// southCardsPanelLayout.setHorizontalGroup(southCardsPanelLayout
		// .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
		// 1313, Short.MAX_VALUE));
		// southCardsPanelLayout.setVerticalGroup(southCardsPanelLayout
		// .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
		// 241, Short.MAX_VALUE));

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
						.addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(southPanelLayout.createSequentialGroup().addGap(154, 154, 154)
										.addComponent(southBid).addGap(212, 212, 212).addComponent(southCardsNum)
										.addGap(209, 209, 209).addComponent(southPoints).addGap(252, 252, 252)
										.addComponent(southPlayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(500, Short.MAX_VALUE))
								.addGroup(southPanelLayout.createSequentialGroup().addGap(92, 92, 92)
										.addComponent(southCardsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(southJScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314,
												javax.swing.GroupLayout.PREFERRED_SIZE)))));
		southPanelLayout.setVerticalGroup(southPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(southPanelLayout.createSequentialGroup()
						.addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(southPanelLayout.createSequentialGroup().addContainerGap()
										.addGroup(southPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(southPlayerImg).addComponent(southJScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE, 249,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(southPanelLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(
										southCardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
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
						.addContainerGap(40, Short.MAX_VALUE)));
	}

}
