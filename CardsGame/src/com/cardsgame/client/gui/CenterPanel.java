/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.print.DocFlavor.STRING;
import javax.swing.JPanel;

/**
 * @author Tao
 *
 */
public class CenterPanel extends JPanel {

	private static CenterPanel centerPanel;
	private javax.swing.JTextArea centerPanelDisplay;
	private javax.swing.JLabel centerECardPlayed;
	private javax.swing.JLabel centerNCardPlayed;
	private javax.swing.JLabel centerSCardPlayed;
	private javax.swing.JLabel centerWCardPlayed;
	private javax.swing.JScrollPane jScrollPane1;
	private int i = 1;
	private int myPosition = 0;

	private CenterPanel() {
		super();
	}

	public static CenterPanel getInstance() {
		if (null == centerPanel) {
			centerPanel = new CenterPanel();
			centerPanel.setBackground(Color.WHITE);
			centerPanel.initComp();
		}
		return centerPanel;
	}
	
	public void updateSouthCardPlayed(String imgName){
		centerSCardPlayed.setIcon(Util.getImage(imgName));
		revalidate();
		repaint();
	}
	
	public void updateWestCardPlayed(String imgName){
		centerWCardPlayed.setIcon(Util.getImage(imgName));
		revalidate();
		repaint();
	}
	public void updateEastCardPlayed(String imgName){
		centerECardPlayed.setIcon(Util.getImage(imgName));
		revalidate();
		repaint();
	}
	public void updateNorthCardPlayed(String imgName){
		centerNCardPlayed.setIcon(Util.getImage(imgName));
		revalidate();
		repaint();
	}

	public void updateCenterInfo(String text){
		centerPanelDisplay.setText(text);
		revalidate();
		repaint();
	}
	
	public void clearCenter(int position){
		if (Util.isGameOverFlag()) {
			centerSCardPlayed.setIcon(Util.getImage("blank")); 
	        centerECardPlayed.setIcon(Util.getImage("blank")); 
	        centerNCardPlayed.setIcon(Util.getImage("blank")); 
	        centerWCardPlayed.setIcon(Util.getImage("blank")); 
		}
		
		
	}
//	public void changeCardPlayed(String imgName) {
//		if (position.equals(""+myPosition) || position.equals("-1")) {
//			centerSCardPlayed.setIcon(Util.getImage(imgName));
//		}else if (position.equals(centerWCardPlayed.getName())) {
//			centerWCardPlayed.setIcon(Util.getImage(imgName));
//		}else if (position.equals(centerECardPlayed.getName())) {
//			centerECardPlayed.setIcon(Util.getImage(imgName));
//		}else if (position.equals(centerNCardPlayed.getName())) {
//			centerNCardPlayed.setIcon(Util.getImage(imgName));
//		}
//		
//		centerPanelDisplay.setText(imgName);
//		revalidate();
//		repaint();
//	}

//	private void cardMouseClicked(MouseEvent evt) {
//	}
////	
//	public void InitCardLabelNum(int myPosition){
//		this.myPosition = myPosition;
//		centerSCardPlayed.setName("" + myPosition);
//		int position = myPosition + 1;
//		if (position > 4) {
//			position = 1;
//		}
//		centerECardPlayed.setName("" + position);
//		
//		position ++;
//		if (position > 4) {
//			position = 1;
//		}
//		centerNCardPlayed.setName("" + position);
//		
//		position ++;
//		if (position > 4) {
//			position = 1;
//		}
//		centerWCardPlayed.setName("" + position);
//	}

	private void initComp() {
		centerSCardPlayed = new javax.swing.JLabel();
        centerECardPlayed = new javax.swing.JLabel();
        centerNCardPlayed = new javax.swing.JLabel();
        centerWCardPlayed = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        centerPanelDisplay = new javax.swing.JTextArea();
        
		centerSCardPlayed.setIcon(Util.getImage("blank")); // NOI18N

        centerECardPlayed.setIcon(Util.getImage("blank")); // NOI18N

        centerNCardPlayed.setIcon(Util.getImage("blank")); // NOI18N

        centerWCardPlayed.setIcon(Util.getImage("blank")); // NOI18N

        centerPanelDisplay.setColumns(20);
        centerPanelDisplay.setLineWrap(true);
        centerPanelDisplay.setRows(5);
        centerPanelDisplay.setEditable(false);
        jScrollPane1.setViewportView(centerPanelDisplay);

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(centerNCardPlayed))
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(centerWCardPlayed)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(centerECardPlayed))
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(centerSCardPlayed))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addComponent(centerNCardPlayed, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(centerWCardPlayed, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(centerECardPlayed, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(centerSCardPlayed, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
	}

}
