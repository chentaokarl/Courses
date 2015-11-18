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
import javax.swing.JTextField;

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
	// private javax.swing.JTextArea southDisplayArea;
	// private javax.swing.JScrollPane southJScrollPane1;
	private JLabel southBid;
	private JPanel cardsDisplayPanel = new JPanel();
	private JLabel southTotalPoints;
	private JTextField southInfoField;

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

	private void cardMouseClicked(MouseEvent evt) {
		if (Util.isMyTurnFlag()) {

			JLabel source = (JLabel) evt.getSource();
			// TableFrame.updateCenterTable(source.getName(), -1);
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
		southInfoField = new JTextField();

		// southDisplayArea = new javax.swing.JTextArea();

		 southCardsNum.setFont(new Font("Tahoma", 0, 30));
		 southPoints.setFont(new Font("Tahoma", 0, 30));
		 southPlayerName.setFont(new Font("Tahoma", 0, 30));
		 southBid.setFont(new Font("Tahoma", 0, 30));
		 southTotalPoints.setFont(new Font("Tahoma", 0, 30));

		southCardsNum.setText("Cards Left: ");
		southPlayerName.setText("south");
		southPoints.setText("Points: ");
		southBid.setText("Bid:");
		southTotalPoints.setText("Total Points: ");

		cardsDisplayPanel.setLayout(new javax.swing.BoxLayout(cardsDisplayPanel, javax.swing.BoxLayout.LINE_AXIS));


		// card1.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/com/GUI/d4.jpg"))); //
		// NOI18N
		// card1.addMouseListener(new java.awt.event.MouseAdapter() {
		// public void mouseClicked(java.awt.event.MouseEvent evt) {
		// cardMouseClicked(evt);
		// }
		// });
		// cardsDisplayPanel.add(card1);


        JLabel card1 = new JLabel();
        card1.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/d4.jpg"))); // NOI18N
        card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardMouseClicked(evt);
            }
        });
        cardsDisplayPanel.add(card1);

        javax.swing.GroupLayout southCardsPanelLayout = new javax.swing.GroupLayout(southCardsPanel);
        southCardsPanel.setLayout(southCardsPanelLayout);
        southCardsPanelLayout.setHorizontalGroup(
            southCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southCardsPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cardsDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1347, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        southCardsPanelLayout.setVerticalGroup(
            southCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southCardsPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cardsDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        southPlayerName.setText("south");

        southInfoField.setText("Cards Left : Points: TotalPoints: Bid: ");
        southInfoField.setFont(new Font("Tahoma", 0, 30));
//        southInfoField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                southInfoFieldActionPerformed(evt);
//            }
//        });

        javax.swing.GroupLayout southPanelLayout = new javax.swing.GroupLayout(southPanel);
        southPanel.setLayout(southPanelLayout);
        southPanelLayout.setHorizontalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(southPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(southPlayerName))
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(southCardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(southInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, 1383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        southPanelLayout.setVerticalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addComponent(southPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(southPlayerName))
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addComponent(southCardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(southInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
	}

	protected void initLabelMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub

	}

}
