//package com.inventory.presentation;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/30/20
 * @version 3.0 12/2/20
 * @version 3.0 12/3/20
 * @version 3.0 12/5/20
 *
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//import com.inventory.DB.UpdateExpiryDate;
//import com.inventory.DB.UpdateReceiveDate;
//import com.inventory.jd.ValidateCodeQuantity;
//import com.inventory.jd.ValidateDate;
//import com.inventory.jd.ValidateName;

import javax.swing.*;

public class UpdateReceiveDateView{

	private JLabel title;
	private JLabel nameLabel;
	private JTextField nameFied;
	private JLabel codeLabel;
	private JTextField codeField;
	private JTextField vendorField;
	private JLabel vendorLabel;
	private JLabel quantityLabel;
	private JTextField quantityField;
	private JButton back;
	private JButton search;

	public UpdateReceiveDateView(){
		JFrame frame=new JFrame("Update Quantity");
		frame.setLayout(null);
		frame.setBounds(300,100,500,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		title=new JLabel("Inventory Manager");
		title.setBounds(170,20,300,40);
		title.setBackground(Color.WHITE);
		title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		title.setForeground(Color.BLACK);
		frame.add(title);

		nameLabel=new JLabel("Enter Item's Name : ");
		nameLabel.setBounds(60,110,200,20);
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		nameLabel.setForeground(Color.BLACK);
		frame.add(nameLabel);

		nameFied=new JTextField(20);
		nameFied.setBackground(Color.WHITE);
		nameFied.setBounds(250,110,200,20);
		frame.add(nameFied);

		codeLabel=new JLabel("Enter Item's Code : ");
		codeLabel.setBounds(60,170,200,20);
		codeLabel.setBackground(Color.WHITE);
		codeLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		codeLabel.setForeground(Color.BLACK);
		frame.add(codeLabel);

		codeField=new JTextField(20);
		codeField.setBackground(Color.WHITE);
		codeField.setBounds(250,170,200,20);
		frame.add(codeField);

		vendorLabel=new JLabel("Enter Vendor's Name : ");
		vendorLabel.setBounds(60,230,200,20);
		vendorLabel.setBackground(Color.WHITE);
		vendorLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		vendorLabel.setForeground(Color.BLACK);
		frame.add(vendorLabel);

		vendorField=new JTextField(20);
		vendorField.setBackground(Color.WHITE);
		vendorField.setBounds(250,230,200,20);
		frame.add(vendorField);

		quantityLabel=new JLabel("Enter ReceiveDate MM/dd/yyy : ");
		quantityLabel.setBounds(60,290,200,20);
		quantityLabel.setBackground(Color.WHITE);
		quantityLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
		quantityLabel.setForeground(Color.BLACK);
		frame.add(quantityLabel);

		quantityField=new JTextField(20);
		quantityField.setBackground(Color.WHITE);
		quantityField.setBounds(250,290,200,20);
		frame.add(quantityField);

		back=new JButton("Back");
		back.setBounds(110,390,100,40);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.DARK_GRAY);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new UpdatingView().setVisible(true);

			}
		});
		frame.add(back);

		search=new JButton("Update");
		search.setBounds(280,390,100,40);
		search.setBackground(Color.BLACK);
		search.setForeground(Color.DARK_GRAY);
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ValidateName nm=new ValidateName();
				ValidateCodeQuantity vc=new ValidateCodeQuantity();
				ValidateDate d=new ValidateDate();
				if(!nm.validate(nameFied.getText() )|| !vc.validate(codeField.getText())
						|| !nm.validate(vendorField.getText()) || !d.validate(quantityField.getText())){
					JOptionPane.showMessageDialog(null,"Invalid User Credentials");
				}else{
					UpdateReceiveDate expire=new UpdateReceiveDate();
					try {

						expire.updateItem(nameFied.getText(),codeField.getText(),vendorField.getText(),quantityField.getText());
						JOptionPane.showMessageDialog(null,"Record is Updated Successfully");
					} catch (ClassNotFoundException classNotFoundException) {
						classNotFoundException.printStackTrace();
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}

			}
		});
		frame.add(search);








		frame.setVisible(true);
		frame.setBackground(Color.WHITE);

	}

}
