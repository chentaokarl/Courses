/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.Color;
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
	private static SouthPanel southPanel;
	private javax.swing.JLabel southCardsNum;
	private javax.swing.JPanel southCardsPanel;
	private javax.swing.JButton southPlayBtn;
	private javax.swing.JLabel southPlayerImg;
	private javax.swing.JLabel southPlayerName;
	private javax.swing.JLabel southPoints;
//	private javax.swing.JTextArea southDisplayArea;
//	private javax.swing.JScrollPane southJScrollPane1;
	private JLabel southBid;
	private JPanel cardsDisplayPanel = new JPanel();
	private JLabel southTotalPoints;

	private SouthPanel() {
		super();
	}

	public static SouthPanel getInstance() {
		if (null == southPanel) {
			southPanel = new SouthPanel();
			southPanel.initComp();
		}
		return southPanel;
	}

	private void southPlayBtnActionPerformed(java.awt.event.ActionEvent evt) {
		initCardsPanel(new String[] { "c8", "d9" });
	}

	private void cardMouseClicked(MouseEvent evt) {
		if (Util.isMyTurnFlag()) {

			JLabel source = (JLabel) evt.getSource();
			TableFrame.updateCenterTable(source.getName(), -1);
			cardsDisplayPanel.remove(source);
			source = null;
			cardsDisplayPanel.repaint();
			cardsDisplayPanel.validate();
			southCardsPanel.validate();
			southPanel.validate();
		} else {

		}
	}

	public void initCardsPanel(String[] cards) {
		for (int i = 0; i < cards.length; i++) {
			JLabel card = new JLabel(Util.getImage(cards[i]));
			card.setName(cards[i]);
			card.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					if (evt.getClickCount() == 2) {
						cardMouseClicked(evt);
					}
				}
			});
			cardsDisplayPanel.add(card);
		}
		cardsDisplayPanel.repaint();
		cardsDisplayPanel.validate();
		southCardsPanel.validate();
		southPanel.validate();
	}

	public void reset() {

	}

	private void initComp() {
		southPlayerImg = Util.getPlayerLabel("", null);
		southPlayerName = new javax.swing.JLabel();
		southCardsPanel = new javax.swing.JPanel();
		southCardsNum = new javax.swing.JLabel();
		southPoints = new javax.swing.JLabel();
		southTotalPoints = new JLabel();
		southBid = new javax.swing.JLabel();
		southPlayBtn = new javax.swing.JButton();
		
//		southDisplayArea = new javax.swing.JTextArea();

		southCardsNum.setFont(new Font("Tahoma", 0, 30));
		southPoints.setFont(new Font("Tahoma", 0, 30));
		southPlayerName.setFont(new Font("Tahoma", 0, 30));
		southBid.setFont(new Font("Tahoma", 0, 30));
		southTotalPoints.setFont(new Font("Tahoma", 0, 30));

		javax.swing.GroupLayout southCardsPanelLayout = new javax.swing.GroupLayout(southCardsPanel);
		cardsDisplayPanel.setLayout(new javax.swing.BoxLayout(cardsDisplayPanel, javax.swing.BoxLayout.LINE_AXIS));

        southCardsPanel.setLayout(southCardsPanelLayout);
        southCardsPanelLayout.setHorizontalGroup(
            southCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardsDisplayPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1528, Short.MAX_VALUE)
        );
        southCardsPanelLayout.setVerticalGroup(
            southCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southCardsPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cardsDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

		southCardsNum.setText("Cards Left: ");
		southPlayerName.setText("south");
		southPoints.setText("Points: ");
		southBid.setText("Bid:");
		southTotalPoints.setText("Total Points: ");

		southPlayBtn.setText("Play");
		// southPlayBtn.setVisible(false);
		southPlayBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				southPlayBtnActionPerformed(evt);
			}
		});

//		southDisplayArea.setColumns(20);
//		southDisplayArea.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
//		southDisplayArea.setRows(5);
//		southDisplayArea.setLineWrap(true);
//		southDisplayArea.setText(Util.DEFAULT_HINT);
//		southDisplayArea.setEditable(false);
//		southJScrollPane1.setViewportView(southDisplayArea);

		javax.swing.GroupLayout southPanelLayout = new javax.swing.GroupLayout(southPanel);
        southPanel.setLayout(southPanelLayout);
        southPanelLayout.setHorizontalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southPanelLayout.createSequentialGroup()
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(southPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(southPlayerName))
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(southTotalPoints)))
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(southCardsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(southBid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(southCardsNum)
                        .addGap(254, 254, 254)
                        .addComponent(southPoints)
                        .addGap(432, 432, 432))))
        );
        southPanelLayout.setVerticalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addComponent(southPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(southPlayerName)
                        .addGap(2, 2, 2)
                        .addComponent(southTotalPoints))
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addComponent(southCardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(southPoints)
                            .addComponent(southCardsNum)
                            .addComponent(southBid))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
	}

}
