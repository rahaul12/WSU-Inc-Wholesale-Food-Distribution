//package com.inventory.presentation;

//import com.inventory.DB.SearchByCode;
//import com.inventory.DB.SearchByName;
//import com.inventory.DB.SearchByVendorName;
//import com.inventory.jd.InventoryClass;
//import com.inventory.jd.ValidateCodeQuantity;
//import com.inventory.jd.ValidateName;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 12/3/20
 * @version 3.0 12/4/20
 *
 */
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class SearchByVendorTableView extends JFrame {

    private JLabel title;
    private JTable table = new JTable();
    private SearchByVendorName obj=new SearchByVendorName();
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton back;
    private JButton search;


    public SearchByVendorTableView(){

        JFrame HomeFrame=new JFrame("Search By Vendor");
        HomeFrame.setLayout(null);
        HomeFrame.setBounds(300,100,500,500);
        HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title=new JLabel("Search By Vendor");
        title.setBounds(140,20,300,40);
        title.setBackground(Color.WHITE);
        title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        title.setForeground(Color.BLACK);
        HomeFrame.add(title);


        nameLabel=new JLabel("Enter Vendor's Name : ");
        nameLabel.setBounds(30,70,150,20);
        nameLabel.setBackground(Color.WHITE);
        nameLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
        nameLabel.setForeground(Color.BLACK);
        HomeFrame.add(nameLabel);

        nameField=new JTextField(20);
        nameField.setBackground(Color.WHITE);
        nameField.setBounds(160,70,150,20);
        HomeFrame.add(nameField);

        table=new JTable();

        search=new JButton("Search");
        search.setBounds(340,70,90,20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ValidateName ob=new ValidateName();

                if (!ob.validate(nameField.getText())) {
                    JOptionPane.showMessageDialog(null,"Invalid Input");
                }
                else{
                    SearchByVendorName name=new SearchByVendorName();

                    try {
                        ArrayList<InventoryClass> searchList=obj.search(nameField.getText());
                        if(searchList.size()==0){
                            JOptionPane.showMessageDialog(null,"No record Found");
                        }
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    try {
                        table.setModel(new FinalTableModel(obj.search(nameField.getText())));
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    table.setBounds(10, 100, 450, 300);
                    TableColumnModel colModel = table.getColumnModel();
                    colModel.getColumn(5).setPreferredWidth(150);
                    colModel.getColumn(4).setPreferredWidth(150);
                    table.setBackground(Color.WHITE);
                    table.setForeground(Color.BLACK);
                    HomeFrame.add(table);
                    nameField.setEditable(false);
                }

                }



        });

        HomeFrame.add(search);

        //          Table




        back=new JButton("Back");
        back.setBounds(180,410,100,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.DARK_GRAY);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeFrame.setVisible(false);
                new SearchingView().setVisible(true);
            }
        });
        HomeFrame.add(back);



        HomeFrame.setBackground(Color.WHITE);
        HomeFrame.setVisible(true);
    }
}
