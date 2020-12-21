//package com.inventory.presentation;

//import com.inventory.DB.UpdateReceiveDate;
//import com.inventory.jd.ValidateCodeQuantity;
//import com.inventory.jd.ValidateDate;
//import com.inventory.jd.ValidateName;

/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/13/20
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpiryRangeView extends JFrame {

    private JLabel title;
    private JLabel startLabel;
    private JLabel endLabel;
    private JTextField startField;
    private JTextField endField;

    public  ExpiryRangeView(){

        JFrame HomeFrame=new JFrame("Expiring Range");
        HomeFrame.setLayout(null);
        HomeFrame.setBounds(300,100,500,500);
        HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        title=new JLabel("Expiring Range");
        title.setBounds(160,20,300,40);
        title.setBackground(Color.WHITE);
        title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        title.setForeground(Color.BLACK);
        HomeFrame.add(title);

        startLabel=new JLabel("Enter Starting range  : ");
        startLabel.setBounds(60,110,200,20);
        startLabel.setBackground(Color.WHITE);
        startLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
        startLabel.setForeground(Color.BLACK);
        HomeFrame.add(startLabel);

        startField=new JTextField(20);
        startField.setBackground(Color.WHITE);
        startField.setBounds(250,110,200,20);
        HomeFrame.add(startField);

        endLabel=new JLabel("Enter Ending Range : ");
        endLabel.setBounds(60,170,200,20);
        endLabel.setBackground(Color.WHITE);
        endLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
        endLabel.setForeground(Color.BLACK);
        HomeFrame.add(endLabel);

        endField=new JTextField(20);
        endField.setBackground(Color.WHITE);
        endField.setBounds(250,170,200,20);
        HomeFrame.add(endField);



        JButton back=new JButton("Back");
        back.setBounds(110,290,100,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.DARK_GRAY);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });
        HomeFrame.add(back);


        JButton search=new JButton("Search");
        search.setBounds(280,290,100,40);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.DARK_GRAY);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ValidateDate dt=new ValidateDate();
                if(!dt.validate(endField.getText()) || !dt.validate(startField.getText())){
                    JOptionPane.showMessageDialog(null,"Invalid user credentials...MM/dd/yyyy");
                }else{
                    HomeFrame.setVisible(false);
                    try {
                        Date start=new SimpleDateFormat("MM/dd/yyyy").parse(startField.getText());
                        Date end=new SimpleDateFormat("MM/dd/yyyy").parse(endField.getText());
                        new ExpiryRangeViewTable(start,end).setVisible(true);
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }

                }

            }
        });
        HomeFrame.add(search);




        HomeFrame.setBackground(Color.WHITE);
        HomeFrame.setVisible(true);

    }


    public  static void main(String [] args){
        ExpiryRangeView view=new ExpiryRangeView();
    }
}
