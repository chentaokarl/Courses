package com.cardsgame.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TableFrame extends JFrame{
	JPanel southPanel = new JPanel(new GridLayout(1,3).);
	JPanel northPanel = new JPanel();
	JPanel westPanel = new JPanel();
	JPanel eastPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	
	public TableFrame(Color myTeamColor, Color oppentColor) {
		setLayout(new BorderLayout());
		
		GridBagLayout
		setSize(1200, 900);
		setTitle("Cards Game");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		southPanel.setBackground(myTeamColor);
		northPanel.setBackground(myTeamColor);
		
		westPanel.setBackground(oppentColor);
		eastPanel.setBackground(oppentColor);
		
		centerPanel.setBackground(Color.gray);
		
		southPanel.setSize(this.getWidth(),this.getHeight()/3);
		northPanel.setSize(this.getWidth(),this.getHeight()/3);
		westPanel.setSize(this.getWidth()/4,this.getHeight()/3);
		eastPanel.setSize(this.getWidth()/4,this.getHeight()/3);
		
		add(southPanel, BorderLayout.SOUTH);
		add(northPanel, BorderLayout.NORTH);
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);
		add(centerPanel, BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		TableFrame tp = new TableFrame(Color.white,Color.green);
	}



}
