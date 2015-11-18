/**
 * 
 */
package com.cardsgame.client.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

/**
 * @author Tao
 *
 */
public class CenterPanel extends JPanel {

	private static CenterPanel centerPanel;
	private javax.swing.JTextArea centerDisplayArea;
	private javax.swing.JLabel centerECardPlayed;
	private javax.swing.JLabel centerNCardPlayed;
	private javax.swing.JLabel centerSCardPlayed;
	private javax.swing.JLabel centerWCardPlayed;
	private javax.swing.JScrollPane jScrollPane1;
//	private javax.swing.JPanel centerECardPanel;
//	private javax.swing.JPanel centerNCardPanel;
//	private javax.swing.JPanel centerSCardPanel;
//	private javax.swing.JPanel centerWCardPanel;
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

	public void changeCardPlayed(String imgName, String position) {
		if (position.equals(""+myPosition) || position.equals("-1")) {
			centerSCardPlayed.setIcon(Util.getImage(imgName));
		}else if (position.equals(centerWCardPlayed.getName())) {
			centerWCardPlayed.setIcon(Util.getImage(imgName));
		}else if (position.equals(centerECardPlayed.getName())) {
			centerECardPlayed.setIcon(Util.getImage(imgName));
		}else if (position.equals(centerNCardPlayed.getName())) {
			centerNCardPlayed.setIcon(Util.getImage(imgName));
		}
		
		centerDisplayArea.setText(imgName);
		revalidate();
		repaint();
	}

//	private void cardMouseClicked(MouseEvent evt) {
//	}
//	
	public void InitCardLabelNum(int myPosition){
		this.myPosition = myPosition;
		centerSCardPlayed.setName("" + myPosition);
		int position = myPosition + 1;
		if (position > 4) {
			position = 1;
		}
		centerECardPlayed.setName("" + position);
		
		position ++;
		if (position > 4) {
			position = 1;
		}
		centerNCardPlayed.setName("" + position);
		
		position ++;
		if (position > 4) {
			position = 1;
		}
		centerWCardPlayed.setName("" + position);
	}

	private void initComp() {
		centerWCardPlayed = new javax.swing.JLabel();
		centerNCardPlayed = new javax.swing.JLabel();
		centerECardPlayed = new javax.swing.JLabel();
		centerSCardPlayed = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
//		centerWCardPanel = new javax.swing.JPanel();
//		centerECardPanel = new javax.swing.JPanel();
//		centerNCardPanel = new javax.swing.JPanel();
//		centerSCardPanel = new javax.swing.JPanel();

		centerDisplayArea = new javax.swing.JTextArea();

		centerWCardPlayed.setIcon(Util.getImage("blank"));
		centerNCardPlayed.setIcon(Util.getImage("blank"));
		centerECardPlayed.setIcon(Util.getImage("blank"));
		centerSCardPlayed.setIcon(Util.getImage("blank"));

//		centerWCardPanel.setBackground(Color.white);
//		centerECardPanel.setBackground(Color.white);
//		centerNCardPanel.setBackground(Color.white);
//		centerSCardPanel.setBackground(Color.white);

//		centerWCardPlayed.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseClicked(java.awt.event.MouseEvent evt) {
//				if (evt.getClickCount() == 2) {
//					cardMouseClicked(evt);
//				}
//			}
//
//		});

		centerDisplayArea.setColumns(20);
//		centerDisplayArea.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
		centerDisplayArea.setLineWrap(true);
		centerDisplayArea.setRows(5);
		centerDisplayArea.setEditable(false);
		jScrollPane1.setViewportView(centerDisplayArea);

//		centerWCardPanel.setLayout(new javax.swing.BoxLayout(centerWCardPanel, javax.swing.BoxLayout.LINE_AXIS));
//
//		centerWCardPanel.add(centerWCardPlayed);
//
//		centerECardPanel.setLayout(new javax.swing.BoxLayout(centerECardPanel, javax.swing.BoxLayout.LINE_AXIS));
//
//		centerECardPanel.add(centerECardPlayed);

//		centerNCardPanel.setLayout(new javax.swing.BoxLayout(centerNCardPanel, javax.swing.BoxLayout.LINE_AXIS));
//
//		centerNCardPanel.add(centerNCardPlayed);

//		centerSCardPanel.setLayout(new javax.swing.BoxLayout(centerSCardPanel, javax.swing.BoxLayout.LINE_AXIS));
//
//		centerSCardPanel.add(centerSCardPlayed);
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
