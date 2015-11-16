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

	private static CenterPanel centerPanel = new CenterPanel();
	private javax.swing.JTextArea centerDisplayArea;
	private javax.swing.JLabel centerECardPlayed;
	private javax.swing.JLabel centerNCardPlayed;
	private javax.swing.JLabel centerSCardPlayed;
	private javax.swing.JLabel centerWCardPlayed;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel centerECardPanel;
	private javax.swing.JPanel centerNCardPanel;
	private javax.swing.JPanel centerSCardPanel;
	private javax.swing.JPanel centerWCardPanel;
	private int i = 1;

	private CenterPanel() {
		super();
	}

	public static CenterPanel getInstance() {
		centerPanel.setBackground(Color.WHITE);
		centerPanel.initComp();
		return centerPanel;
	}

	public void changeCardPlayed(String imgName) {
		centerWCardPlayed.setIcon(Util.getImage(imgName));
		centerECardPlayed.setIcon(Util.getImage(imgName));
		centerSCardPlayed.setIcon(Util.getImage(imgName));
		centerNCardPlayed.setIcon(Util.getImage(imgName));
		
		centerDisplayArea.setText(imgName);
		revalidate();
		repaint();
	}

	private void cardMouseClicked(MouseEvent evt) {
		changeCardPlayed("c" + i);
		i++;
	}

	private void initComp() {
		centerWCardPlayed = new javax.swing.JLabel();
		centerNCardPlayed = new javax.swing.JLabel();
		centerECardPlayed = new javax.swing.JLabel();
		centerSCardPlayed = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		centerWCardPanel = new javax.swing.JPanel();
		centerECardPanel = new javax.swing.JPanel();
		centerNCardPanel = new javax.swing.JPanel();
		centerSCardPanel = new javax.swing.JPanel();

		centerDisplayArea = new javax.swing.JTextArea();

		centerWCardPlayed.setIcon(Util.getImage("blank"));
		centerNCardPlayed.setIcon(Util.getImage("blank"));
		centerECardPlayed.setIcon(Util.getImage("blank"));
		centerSCardPlayed.setIcon(Util.getImage("blank"));

		centerWCardPanel.setBackground(Color.white);
		centerECardPanel.setBackground(Color.white);
		centerNCardPanel.setBackground(Color.white);
		centerSCardPanel.setBackground(Color.white);

		centerWCardPlayed.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					cardMouseClicked(evt);
				}
			}

		});

		centerDisplayArea.setColumns(20);
		centerDisplayArea.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
		centerDisplayArea.setLineWrap(true);
		centerDisplayArea.setRows(5);
		centerDisplayArea.setEditable(false);
		jScrollPane1.setViewportView(centerDisplayArea);

		centerWCardPanel.setLayout(new javax.swing.BoxLayout(centerWCardPanel, javax.swing.BoxLayout.LINE_AXIS));

		centerWCardPanel.add(centerWCardPlayed);

		centerECardPanel.setLayout(new javax.swing.BoxLayout(centerECardPanel, javax.swing.BoxLayout.LINE_AXIS));

		centerECardPanel.add(centerECardPlayed);

		centerNCardPanel.setLayout(new javax.swing.BoxLayout(centerNCardPanel, javax.swing.BoxLayout.LINE_AXIS));

		centerNCardPanel.add(centerNCardPlayed);

		centerSCardPanel.setLayout(new javax.swing.BoxLayout(centerSCardPanel, javax.swing.BoxLayout.LINE_AXIS));

		centerSCardPanel.add(centerSCardPlayed);

		javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addComponent(centerWCardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(centerECardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(centerNCardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(centerSCardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                .addComponent(centerNCardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(centerPanelLayout.createSequentialGroup()
                                .addComponent(centerWCardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(centerSCardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addComponent(centerECardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
	}

}
