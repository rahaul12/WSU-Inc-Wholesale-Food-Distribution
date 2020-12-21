//package com.inventory.presentation;

//
//import com.inventory.DB.SearchByCode;
//import com.inventory.DB.SearchByVendorName;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/12/20
 * @version 3.0 11/15/20
 * @version 3.0 11/18/20
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

import static javax.swing.JFrame.*;

public class SearchingView extends JFrame {
    private JPanel panel;

    private JLabel title;
    private JLabel nameLabel;
    private JLabel codeLabel;
    private JLabel vendorLabel;
    private JButton back;

    public SearchingView(){
// item can be search following button were created
        JFrame HomeFrame=new JFrame("Searching");
        HomeFrame.setLayout(null);
        HomeFrame.setBounds(300,100,500,400);
        HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel=new JPanel();
        panel.setBounds(0,0,500,400);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        title=new JLabel("Search Item");
        title.setBounds(160,30,300,40);
        title.setBackground(Color.WHITE);
        title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        title.setForeground(Color.BLACK);
        panel.add(title);

        nameLabel=new JLabel("1-Search by item Name");
        nameLabel.setBounds(50,120,340,20);
        nameLabel.setBackground(Color.WHITE);
        nameLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nameLabel.setForeground(Color.RED);
                HomeFrame.setVisible(false);
                try {
                    new SearchByNameTableView().setVisible(true);
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
        panel.add(nameLabel);


        codeLabel=new JLabel("2-Search by Item Code");
        codeLabel.setBounds(50,160,350,20);
        codeLabel.setBackground(Color.WHITE);
        codeLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
        codeLabel.setForeground(Color.BLACK);
        codeLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                codeLabel.setForeground(Color.RED);
                try {
                    SearchByCodeTableView obj=new SearchByCodeTableView();
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
        panel.add(codeLabel);

        vendorLabel=new JLabel("3-Search by Vendor Name");
        vendorLabel.setBounds(50,200,350,20);
        vendorLabel.setBackground(Color.WHITE);
        vendorLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));
        vendorLabel.setForeground(Color.BLACK);
        vendorLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vendorLabel.setForeground(Color.RED);
                SearchByVendorTableView obj=new SearchByVendorTableView();

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
// back button were used to get back to the Home screen
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

    public static void main(String [] args){
        SearchingView obj=new SearchingView();
    }


}
