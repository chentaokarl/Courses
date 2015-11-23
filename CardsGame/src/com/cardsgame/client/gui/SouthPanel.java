/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cardsgame.util.MessageHandlerInterface;
import com.cardsgame.util.PositionData;
import com.cardsgame.util.PositionInitData;

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
	private int positionNum = Integer.MIN_VALUE;
	private MessageHandlerInterface messageHandler = null;
	private Socket clientSocket = null;
	

	private SouthPanel(MessageHandlerInterface mhi, Socket socket) {
		super();
		this.messageHandler = mhi;
		this.clientSocket = socket;
	}

	public static SouthPanel getInstance(MessageHandlerInterface messageHandler, Socket clientSocket) {
		if (null == southPanel) {
			southPanel = new SouthPanel(messageHandler,clientSocket);
			southPanel.initComp();
		}
		return southPanel;
	}

	private void cardMouseClicked(MouseEvent evt) {
		if (Util.isMyTurnFlag()) {
			JLabel source = (JLabel) evt.getSource();
//			PositionData positionData = new PositionData();
//			positionData.setPositionNum(positionNum);
//			positionData.setCardPlayed(source.getName());
			try {
//				Client.getInstance().sendMsg(source.getName());// send played card
//				Client.getInstance().messageHandler.sendMsg(Client.getInstance().getClientSocket(), source.getName());
				messageHandler.sendMsg(clientSocket, source.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			CenterPanel.getInstance().updateSouthCardPlayed(source.getName());
			cardsDisplayPanel.remove(source);
			source = null;
			cardsDisplayPanel.repaint();
			cardsDisplayPanel.validate();
			southCardsPanel.validate();
			southPanel.validate();
		} else {
			//warning to be done.
			TableFrame.getInstance(messageHandler, clientSocket).showInfoDialogue("Not your turn yet!");
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
		southPlayerImg = Util.getPlayerLabel("", Util.playerImage);
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

        southPlayerName.setText("null");

        southInfoField.setText("TotalPoints:	Cards Left:		Points:		Bid:	");
        southInfoField.setFont(new Font("Tahoma", 0, 30));
        southInfoField.setEditable(false);
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

	/**
	 * @return the positionNum
	 */
	public int getPositionNum() {
		return positionNum;
	}

	/**
	 * @param positionNum the positionNum to set
	 */
	public void setPositionNum(int positionNum) {
		this.positionNum = positionNum;
	}

	public void initData(PositionInitData initData) {
		setPositionNum(initData.getPositionNum());
		southPlayerName.setText(initData.getUserName());
		southPlayerImg.setIcon(Util.playerImage);
		southPlayerImg.validate();
		southPlayerName.validate();
		southCardsPanel.validate();
		repaint();
		revalidate();
	}
	
	//TotalPoints:Cards Left:		Points:		Bid:	
	public void updateData(PositionData positionData){
		String newText = null;
		if (Integer.MIN_VALUE != positionData.getTotalPoints()) {
			 newText = getDisplayString(southInfoField.getText().indexOf(":"), southInfoField.getText().indexOf("Cards Left:"), positionData.getTotalPoints());
		}
		if (Integer.MIN_VALUE != positionData.getCardsLeft()) {
			if (null != newText) {
				newText = getDisplayString(newText.indexOf("Cards Left:") + 10, newText.indexOf("Points:"), positionData.getCardsLeft());
			}else{
				newText = getDisplayString(southInfoField.getText().indexOf("Cards Left:") + 10, southInfoField.getText().indexOf("Points:"), positionData.getCardsLeft());
			}
		}
		if (Integer.MIN_VALUE != positionData.getCurrentRoundPoints()) {
			if (null != newText) {
				newText = getDisplayString(newText.indexOf("Points:") + 6, newText.indexOf("Bid:"), positionData.getCurrentRoundPoints());
			}else{
				newText = getDisplayString(southInfoField.getText().indexOf("Points:") + 6, southInfoField.getText().indexOf("Bid:"), positionData.getCurrentRoundPoints());
			}
		}
		if (Integer.MIN_VALUE != positionData.getBid()) {
			if (null != newText) {
				newText = getDisplayString(newText.lastIndexOf(":"), newText.length() - 1, positionData.getBid());
			}else{
				newText = getDisplayString(southInfoField.getText().lastIndexOf(":") , southInfoField.getText().length() - 1, positionData.getBid());
			}
		}
		
		southInfoField.setText(newText);
		southInfoField.repaint();
		southInfoField.revalidate();
		southCardsPanel.validate();
		repaint();
		revalidate();
}
	
	private String getDisplayString(int firstIndex, int secondIndex, int newData){
		StringBuilder displayStringBuilder = new StringBuilder();
		displayStringBuilder.append(southInfoField.getText().substring(0, firstIndex + 1));
		displayStringBuilder.append("  ");
		displayStringBuilder.append(newData);
		displayStringBuilder.append("	");
		displayStringBuilder.append(southInfoField.getText().substring(secondIndex));
		
		return displayStringBuilder.toString();
	}

}
