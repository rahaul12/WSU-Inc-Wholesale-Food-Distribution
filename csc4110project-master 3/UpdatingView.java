//package com.inventory.presentation;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/24/20
 * @version 3.0 12/5/20
 * @version 3.0 12/7/20

 *
 */


/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/04/20
 * @version 3.0 12/1/20
 * @version 3.0 12/3/20
 * @version 3.0 12/5/20
 *
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

//import com.inventory.DB.UpdateExpiryDate;
//import com.inventory.DB.UpdateReceiveDate;
//import com.inventory.jd.InventoryClass;

import javax.swing.*;

public class UpdatingView extends JFrame{

	private JPanel panel;
	private JLabel title;
	private JLabel nameLabel;
	private JLabel codeLabel;
	private JLabel vendorLabel;
	private JButton back;


	public UpdatingView(){
		JFrame HomeFrame=new JFrame("Updating");
		HomeFrame.setLayout(null);
		HomeFrame.setBounds(300,100,500,400);
		HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel=new JPanel();
		panel.setBounds(0,0,500,400);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

		title=new JLabel("Update Items");
		title.setBounds(160,30,300,40);
		title.setBackground(Color.WHITE);
		title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		title.setForeground(Color.BLACK);
		panel.add(title);

		nameLabel=new JLabel("1-Update quantity of item ");
		nameLabel.setBounds(50,120,340,20);
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		nameLabel.setForeground(Color.BLACK);
		nameLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nameLabel.setForeground(Color.RED);
				HomeFrame.setVisible(false);
				new UpdateQuantityView().setVisible(true);

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
		panel.add(nameLabel);

// last of item can be update using the date and item
		codeLabel=new JLabel("2-Update Expiry Date of an Item");
		codeLabel.setBounds(50,160,350,20);
		codeLabel.setBackground(Color.WHITE);
		codeLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		codeLabel.setForeground(Color.BLACK);
		codeLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				codeLabel.setForeground(Color.RED);
				HomeFrame.setVisible(false);
				new UpdateExpireDateView().setVisible(true);
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
		panel.add(codeLabel);

		vendorLabel=new JLabel("3-Update Receiving Date of an item");
		vendorLabel.setBounds(50,200,350,20);
		vendorLabel.setBackground(Color.WHITE);
		vendorLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		vendorLabel.setForeground(Color.BLACK);
		vendorLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vendorLabel.setForeground(Color.RED);

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
		panel.add(vendorLabel);

		back=new JButton("Back");
		back.setBounds(180,260,100,40);
		back.setBackground(Color.BLACK);
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
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		UpdatingView view=new UpdatingView();
	}
	
}
