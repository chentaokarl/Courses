/**
 * 
 */
package com.cardsgame.client.gui;

import javax.swing.JPanel;

/**
 * @author Tao
 *
 */
public class CenterPanel extends JPanel {

	private static CenterPanel centerPanel = new CenterPanel();
	
	private CenterPanel(){
		super();
	}
	public static CenterPanel getInstance(){
		centerPanel.initComp();
		return centerPanel;
	}
	private void initComp() {
		// TODO Auto-generated method stub
		
	}

}
