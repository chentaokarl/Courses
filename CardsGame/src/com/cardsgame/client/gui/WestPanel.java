/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cardsgame.util.PositionData;
import com.cardsgame.util.PositionInitData;

/**
 * @author Tao
 *
 */
public class WestPanel extends JPanel {

	private static WestPanel westPanel ;
	private javax.swing.JLabel westCardImg;
	private javax.swing.JLabel westCardsNum;
	private javax.swing.JLabel westPlayerImg;
	private javax.swing.JLabel westPlayerName;
	private javax.swing.JLabel westPoints;
	private javax.swing.JLabel westBid;
	private JLabel westTotalPoints;
	private int positionNum = Integer.MIN_VALUE;
	
	private WestPanel() {
		super();
	}

	public static WestPanel getInstance() {
		if (null == westPanel) {
			westPanel = new WestPanel();
			westPanel.initComp();
		}
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

		westPlayerName.setText("  ");
		westCardsNum.setText("Cards Left:  ");
		westPoints.setText("Points:  ");
		westBid.setText("Bid:  ");
		westTotalPoints.setText("Total Points: ");


		javax.swing.GroupLayout westPanelLayout = new javax.swing.GroupLayout(westPanel);
        westPanel.setLayout(westPanelLayout);
        westPanelLayout.setHorizontalGroup(
            westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(westPanelLayout.createSequentialGroup()
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(westPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(westTotalPoints)))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(westPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(westCardImg))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(westCardsNum)
                            .addComponent(westPoints)
                            .addComponent(westBid))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        westPanelLayout.setVerticalGroup(
            westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(westPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, westPanelLayout.createSequentialGroup()
                        .addComponent(westPlayerName)
                        .addGap(7, 7, 7)
                        .addComponent(westPlayerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addComponent(westCardImg)
                        .addGap(18, 18, 18)
                        .addComponent(westCardsNum)))
                .addGap(6, 6, 6)
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(westTotalPoints)
                    .addComponent(westPoints))
                .addGap(4, 4, 4)
                .addComponent(westBid)
                .addContainerGap(104, Short.MAX_VALUE))
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
		westPlayerName.setText(positionData.getUserName());
		westPlayerImg.setIcon(Util.playerImage);
		westPlayerImg.validate();
		westPlayerName.revalidate();
		westPlayerName.repaint();
		repaint();
		revalidate();

	}

	public void updateData(PositionData positionData) {
		String newText = null;
		if (Integer.MIN_VALUE != positionData.getTotalPoints()) {
			westTotalPoints.setText("TotalPoints:" + positionData.getTotalPoints());
		} 
		if (Integer.MIN_VALUE != positionData.getCardsLeft()) {
			westCardsNum.setText("Card Left:" + positionData.getCardsLeft());
		} 
		if (Integer.MIN_VALUE != positionData.getCurrentRoundPoints()) {
			westPoints.setText("Points:" + positionData.getCurrentRoundPoints());
		} 
		if (Integer.MIN_VALUE != positionData.getBid()) {
			westBid.setText("Bid:" + positionData.getBid());
		}
		
		if (null != positionData.getCardPlayed()) {
			CenterPanel.getInstance().updateWestCardPlayed(positionData.getCardPlayed());
		}
		westTotalPoints.validate();
		westCardsNum.validate();
		westPoints.validate();
		westBid.validate();

		repaint();
		revalidate();
}

}
