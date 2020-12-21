//package com.inventory.presentation;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/13/20
 *
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


import javax.swing.*;

public class ExpiringItemsView extends JFrame {


	private JPanel panel;
	private JLabel title;
	private JLabel expireDayLabel;
	private JLabel expireRangeLabel;
	private JButton back;


	private InventoryController obj=new InventoryController();

	public ExpiringItemsView() throws ClassNotFoundException, IOException, ParseException {

		JFrame HomeFrame=new JFrame("Expiry Items");
		HomeFrame.setLayout(null);
		HomeFrame.setBounds(300,100,500,400);
		HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel=new JPanel();
		panel.setBounds(0,0,500,400);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

		title=new JLabel("Expiry Item Details");
		title.setBounds(160,30,300,40);
		title.setBackground(Color.WHITE);
		title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		title.setForeground(Color.BLACK);
		panel.add(title);

		expireDayLabel=new JLabel("1-View the List Of Items Expiring Today");
		expireDayLabel.setBounds(50,120,300,20);
		expireDayLabel.setBackground(Color.WHITE);
		expireDayLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		expireDayLabel.setForeground(Color.BLACK);
		expireDayLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expireDayLabel.setForeground(Color.RED);
				try {
						new ExpireTodayTableView().setVisible(true);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				} catch (ParseException parseException) {
					parseException.printStackTrace();
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		panel.add(expireDayLabel);


		expireRangeLabel=new JLabel("1-View the List Of Items within Expiry Range");
		expireRangeLabel.setBounds(50,160,300,20);
		expireRangeLabel.setBackground(Color.WHITE);
		expireRangeLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		expireRangeLabel.setForeground(Color.BLACK);
		expireRangeLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				expireRangeLabel.setForeground(Color.RED);
				HomeFrame.setVisible(false);
				new ExpiryRangeView().setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		panel.add(expireRangeLabel);

// back button were created in the For the Expireitem
		back=new JButton("Back");
		back.setBounds(180,240,100,40);
		back.setBackground(Color.RED);
		back.setForeground(Color.DARK_GRAY);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeFrame.setVisible(false);
				try {
					new HomeView().setVisible(true);
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				} catch (ParseException parseException) {
					parseException.printStackTrace();
				}
			}
		});
		panel.add(back);


		panel.setVisible(true);
		HomeFrame.add(panel);



		HomeFrame.setBackground(Color.WHITE);
		HomeFrame.setVisible(true);


		
	}

	
	
}
