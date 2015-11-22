package com.cardsgame.client.gui;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;

import javax.naming.InitialContext;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.Position;

import com.cardsgame.util.Message;
import com.cardsgame.util.PositionData;
import com.cardsgame.util.PositionInitData;

/**
 *
 * @author Tao
 */
public class TableFrame extends javax.swing.JFrame {

	JPanel southPanel = SouthPanel.getInstance();
	JPanel northPanel = NorthPanel.getInstance();
	JPanel westPanel = WestPanel.getInstance();
	JPanel eastPanel = EastPanel.getInstance();
	JPanel centerPanel = CenterPanel.getInstance();
	private static TableFrame tableFrame = null;

	/**
	 * Creates new form NewJFrame
	 */
	public TableFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(westPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(15, 15, 15)
						.addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(eastPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(42, 42, 42))
				.addGroup(layout.createSequentialGroup()
						.addComponent(southPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(northPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(0, 0, 0)
						.addComponent(northPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addGap(5, 5, 5)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(centerPanel, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(westPanel, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(eastPanel,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)))
						.addGap(0, 0, 0).addComponent(southPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
		setTitle("Cards Game");
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static TableFrame getInstance() {
		if (null == tableFrame) {
			tableFrame = new TableFrame();
		}
		return tableFrame;
	}

	public static void main(String[] args) {
		TableFrame.getInstance();
		SouthPanel.getInstance().initCardsPanel(
				new String[] { "c1", "d2", "h3", "s4", "c5", "d6", "h7", "s8", "c9", "d10", "h11", "s12", "c13" });
		TableFrame.getInstance().showBidDialogue();
	}

	public void updateCenterTable(String cardName, int position) {
		if (SouthPanel.getInstance().getPositionNum() == position) {
			CenterPanel.getInstance().updateSouthCardPlayed(cardName);
		}else if (EastPanel.getInstance().getPositionNum() == position) {
			CenterPanel.getInstance().updateEastCardPlayed(cardName);
		}else if (NorthPanel.getInstance().getPositionNum() == position) {
			CenterPanel.getInstance().updateNorthCardPlayed(cardName);
		}else if (WestPanel.getInstance().getPositionNum() == position) {
			CenterPanel.getInstance().updateWestCardPlayed(cardName);
		}
		tableFrame.revalidate();
	}
	
	public void initNewData(PositionInitData initNewData){
		if (EastPanel.getInstance().getPositionNum() == initNewData.getPositionNum()) {
			EastPanel.getInstance().initData(initNewData);
		}else if (NorthPanel.getInstance().getPositionNum() == initNewData.getPositionNum()) {
			NorthPanel.getInstance().initData(initNewData);
		}else if (WestPanel.getInstance().getPositionNum() == initNewData.getPositionNum()) {
			WestPanel.getInstance().initData(initNewData);
		}
	}

	public void initTableData(int myPosition, PositionInitData[] initData) {
		SouthPanel.getInstance().setPositionNum(myPosition);
		for (int i = 0; i < initData.length; i++) {
			if (SouthPanel.getInstance().getPositionNum() == initData[i].getPositionNum()) {
				SouthPanel.getInstance().initData(initData[i]);
			} else {
				if (1 == SouthPanel.getInstance().getPositionNum()) {
					EastPanel.getInstance().setPositionNum(2);
					NorthPanel.getInstance().setPositionNum(3);
					WestPanel.getInstance().setPositionNum(4);
					if (2 == initData[i].getPositionNum()) {
						EastPanel.getInstance().initData(initData[i]);
					}else if (3 == initData[i].getPositionNum()) {
						NorthPanel.getInstance().initData(initData[i]);
					}else if (4 == initData[i].getPositionNum()) {
						WestPanel.getInstance().initData(initData[i]);
					}
				} else if (2 == SouthPanel.getInstance().getPositionNum()) {
					EastPanel.getInstance().setPositionNum(3);
					NorthPanel.getInstance().setPositionNum(4);
					WestPanel.getInstance().setPositionNum(1);
					if (3 == initData[i].getPositionNum()) {
						EastPanel.getInstance().initData(initData[i]);
					}else if (4 == initData[i].getPositionNum()) {
						NorthPanel.getInstance().initData(initData[i]);
					}else if (1 == initData[i].getPositionNum()) {
						WestPanel.getInstance().initData(initData[i]);
					}
				}else if (3 == SouthPanel.getInstance().getPositionNum()) {
					EastPanel.getInstance().setPositionNum(4);
					NorthPanel.getInstance().setPositionNum(1);
					WestPanel.getInstance().setPositionNum(2);
					if (4 == initData[i].getPositionNum()) {
						EastPanel.getInstance().initData(initData[i]);
					}else if (1 == initData[i].getPositionNum()) {
						NorthPanel.getInstance().initData(initData[i]);
					}else if (2 == initData[i].getPositionNum()) {
						WestPanel.getInstance().initData(initData[i]);
					}
				}else if (4 == SouthPanel.getInstance().getPositionNum()) {
					EastPanel.getInstance().setPositionNum(1);
					NorthPanel.getInstance().setPositionNum(2);
					WestPanel.getInstance().setPositionNum(3);
					if (1 == initData[i].getPositionNum()) {
						EastPanel.getInstance().initData(initData[i]);
					}else if (2 == initData[i].getPositionNum()) {
						NorthPanel.getInstance().initData(initData[i]);
					}else if (3 == initData[i].getPositionNum()) {
						WestPanel.getInstance().initData(initData[i]);
					}
				}
				
			}
		}

	}

	public void updateTableData(PositionData positionData) {
		if (SouthPanel.getInstance().getPositionNum() == positionData.getPositionNum()) {
			SouthPanel.getInstance().updateData(positionData);
		}else if (EastPanel.getInstance().getPositionNum() == positionData.getPositionNum()) {
			EastPanel.getInstance().updateData(positionData);
		}else if (NorthPanel.getInstance().getPositionNum() == positionData.getPositionNum()) {
			NorthPanel.getInstance().updateData(positionData);
		}else if (WestPanel.getInstance().getPositionNum() == positionData.getPositionNum()) {
			WestPanel.getInstance().updateData(positionData);
		}
	}
	
	public void clearTable(){
		
	}

	public void updateCenterInfo(String message) {
		CenterPanel.getInstance().updateCenterInfo(message);
	}
	
	public void showInfoDialogue(String infoString){
		JOptionPane.showMessageDialog(TableFrame.getInstance(), infoString);
	}
	
	public void showBidDialogue(){
		Integer[] possibilities = {0,1,2,3,4,5,6,7,8,9,10,11,12,13};
		Integer bidPoints = (Integer) JOptionPane.showInputDialog(TableFrame.getInstance(),
		                    "Please slect the points you want to bid: \n" + "(if you click 'Cancel', you bid 0)",
		                    "Bid",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    0);
		
		if (null == bidPoints) {
			bidPoints = 0;
		}
		//send bidPoints back to server
		System.out.println(bidPoints);
		Client.getInstance().new SendThread(bidPoints).start();
		
		
		//update south panel the points bid
		
		PositionData pd = new PositionData();
		pd.setBid(bidPoints);
		SouthPanel.getInstance().updateData(pd);
	}
	
	public void initCards(String[] cards){
		SouthPanel.getInstance().initCardsPanel(cards);
	}
}
