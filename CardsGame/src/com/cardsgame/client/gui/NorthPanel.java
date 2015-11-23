/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.cardsgame.util.PositionData;
import com.cardsgame.util.PositionInitData;

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
	private JScrollPane northJScrollPane1;
	private JTextArea northDisplayArea;
	private int positionNum = Integer.MIN_VALUE;

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
		
		northJScrollPane1 = new javax.swing.JScrollPane();
		northDisplayArea = new javax.swing.JTextArea();
		
		northCardsNum.setFont(new Font("Tahoma", 0, 30));
		northPoints.setFont(new Font("Tahoma", 0, 30));
		northPlayerName.setFont(new Font("Tahoma", 0, 30));
		northBid.setFont(new Font("Tahoma", 0, 30));
		northTotalPoints.setFont(new Font("Tahoma", 0, 30));
		
		northCardsNum.setText("Cards Left:");
		northPlayerName.setText("null");
		northPoints.setText("Points:");
		northBid.setText("Bid: ");
		northTotalPoints.setText("Total Points:");
		
//		southDisplayArea.setEditable(false);

        northDisplayArea.setColumns(20);
        northDisplayArea.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        northDisplayArea.setLineWrap(true);
        northDisplayArea.setEditable(false);
        northDisplayArea.setRows(5);
        northDisplayArea.setText("Hint:\nWhen it's your turn,  double click to play out one of your cards. ");
        northJScrollPane1.setViewportView(northDisplayArea);

        javax.swing.GroupLayout northPanelLayout = new javax.swing.GroupLayout(northPanel);
        northPanel.setLayout(northPanelLayout);
        northPanelLayout.setHorizontalGroup(
            northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(northJScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(northPlayerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(northPanelLayout.createSequentialGroup()
                        .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(northPoints)
                                .addComponent(northCardsNum)
                                .addComponent(northBid))
                            .addGroup(northPanelLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(northCardImg)))
                        .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(northPanelLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(northTotalPoints))
                            .addGroup(northPanelLayout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(northPlayerName)))))
                .addContainerGap(595, Short.MAX_VALUE))
        );
        northPanelLayout.setVerticalGroup(
            northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(northPanelLayout.createSequentialGroup()
                .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(northJScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(northPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(northPanelLayout.createSequentialGroup()
                                .addComponent(northPlayerName)
                                .addGap(4, 4, 4)
                                .addComponent(northPlayerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(northPanelLayout.createSequentialGroup()
                                .addComponent(northCardImg, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(northCardsNum)))
                        .addGap(4, 4, 4)
                        .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(northPoints)
                            .addComponent(northTotalPoints))
                        .addGap(0, 0, 0)
                        .addComponent(northBid)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
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
	
	public void initData(PositionInitData positionData) {
		setPositionNum(positionData.getPositionNum());
		northPlayerName.setText(positionData.getUserName());
		northPlayerImage.setIcon(Util.playerImage);
		northPlayerImage.validate();
		northPlayerName.validate();
		repaint();
		revalidate();
}

	public void updateData(PositionData positionData) {
		String newText = null;
		if (Integer.MIN_VALUE != positionData.getTotalPoints()) {
			northTotalPoints.setText("" + positionData.getTotalPoints());
		} 
		if (Integer.MIN_VALUE != positionData.getCardsLeft()) {
			northCardsNum.setText("" + positionData.getCardsLeft());
		} 
		if (Integer.MIN_VALUE != positionData.getCurrentRoundPoints()) {
			northPoints.setText("" + positionData.getCurrentRoundPoints());
		} 
		if (Integer.MIN_VALUE != positionData.getBid()) {
			northBid.setText("" + positionData.getBid());
		}
		
		if (null != positionData.getCardPlayed()) {
			CenterPanel.getInstance().updateNorthCardPlayed(positionData.getCardPlayed());
		}
		northTotalPoints.validate();
		northCardsNum.validate();
		northPoints.validate();
		northBid.validate();
		repaint();
		revalidate();

	}

}
