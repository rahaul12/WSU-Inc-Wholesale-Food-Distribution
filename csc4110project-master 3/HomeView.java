//package com.inventory.presentation;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/14/20
 *
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;

import java.awt.FlowLayout;

public class HomeView extends JFrame{



	private  JLabel title;

	private JLabel itemLabel;
	private JLabel outOfStockLabel;
	private JLabel ExpireLabel;
	private JLabel updateLabel;
	private JLabel Logout;
	private JLabel ReceivedLabel;
	private JLabel searchLabel;
	JButton logout;






	public HomeView() throws ClassNotFoundException, IOException, ParseException {


		JFrame HomeFrame=new JFrame("Inventory Manager");
		HomeFrame.setLayout(null);
		HomeFrame.setBounds(300,100,800,500);
		HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//				Setting Title


		title=new JLabel("Inventory Manager");
		title.setBounds(320,20,300,40);
		title.setBackground(Color.WHITE);
		title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		title.setForeground(Color.BLACK);
		HomeFrame.add(title);




		/*

		Setting the Labels for Menu

		 */


		//			Label for List of Items
		itemLabel=new JLabel("1-View the List Of Items");
		itemLabel.setBounds(90,130,300,20);
		itemLabel.setBackground(Color.WHITE);
		itemLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		itemLabel.setForeground(Color.BLACK);
		itemLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				itemLabel.setForeground(Color.RED);
				HomeFrame.setVisible(false);
				try {
					new ListOfItems().setVisible(true);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
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
		HomeFrame.add(itemLabel);


		//			Label for Out of Stock Items

		outOfStockLabel=new JLabel("2-View the List Of Out of Stock Items");
		outOfStockLabel.setBounds(90,160,300,20);
		outOfStockLabel.setBackground(Color.WHITE);
		outOfStockLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		outOfStockLabel.setForeground(Color.BLACK);
		outOfStockLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outOfStockLabel.setForeground(Color.RED);
				HomeFrame.setVisible(false);
				try {
					new ListOfOutOfStockItems().setVisible(true);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
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
		HomeFrame.add(outOfStockLabel);

		//			Label for Expiry Items


		ExpireLabel=new JLabel("3-View the List Of Expired Items");
		ExpireLabel.setBounds(90,190,300,20);
		ExpireLabel.setBackground(Color.WHITE);
		ExpireLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		ExpireLabel.setForeground(Color.BLACK);
		ExpireLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ExpireLabel.setForeground(Color.RED);
				HomeFrame.setVisible(false);
				try {
					new ExpiringItemsView().setVisible(true);
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				} catch (IOException ioException) {
					ioException.printStackTrace();
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
		HomeFrame.add(ExpireLabel);


		//			Label Fore Received Items


		ReceivedLabel=new JLabel("4-View the List Of Received Items");
		ReceivedLabel.setBounds(90,220,300,20);
		ReceivedLabel.setBackground(Color.WHITE);
		ReceivedLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		ReceivedLabel.setForeground(Color.BLACK);
		ReceivedLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReceivedLabel.setForeground(Color.RED);
				HomeFrame.setVisible(false);
				try {
					new RceivingItemView().setVisible(true);
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				} catch (IOException ioException) {
					ioException.printStackTrace();
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
		HomeFrame.add(ReceivedLabel);


		//			Label for Searching


		searchLabel=new JLabel("5-Search the Item");
		searchLabel.setBounds(90,250,300,20);
		searchLabel.setBackground(Color.WHITE);
		searchLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		searchLabel.setForeground(Color.BLACK);
		searchLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchLabel.setForeground(Color.RED);
				HomeFrame.setVisible(false);
				new SearchingView().setVisible(true);
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
		HomeFrame.add(searchLabel);


		//			Update Item


		updateLabel=new JLabel("6-Update Item");
		updateLabel.setBounds(90,280,300,20);
		updateLabel.setBackground(Color.WHITE);
		updateLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		updateLabel.setForeground(Color.BLACK);
		updateLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateLabel.setForeground(Color.RED);
				HomeFrame.setVisible(false);
				new UpdatingView().setVisible(true);
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
		HomeFrame.add(updateLabel);




		//logout form has created to bring this back to the user information

		Logout=new JLabel("Logout");
		Logout.setBounds(350,400,500,20);
		Logout.setBackground(Color.WHITE);
		Logout.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		Logout.setForeground(Color.BLACK);
		Logout.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Logout.setForeground(Color.RED);
				HomeFrame.setVisible(false);
//				new Login().setVisible(true);
				new Login();
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
		HomeFrame.add(Logout);
		HomeFrame.setBackground(Color.WHITE);
		HomeFrame.setVisible(true);







	}






//	public static void main(String [] args) throws ParseException, IOException, ClassNotFoundException {
//
//		HomeView view=new HomeView();
//
//	}
//



}
