//package com.inventory.presentation;
//
//import com.inventory.DB.inventoryDatabase;
//import com.inventory.jd.InventoryController;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/22/20
 *
 *
 *
 */
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;


public class ListOfOutOfStockItems extends JFrame {


    private JLabel title;
    private JTable table = new JTable();
    private InventoryController obj=new InventoryController();
    private JButton back;

    public ListOfOutOfStockItems() throws IOException, ClassNotFoundException {
// list of item if there are stock or out stock can see

        JFrame HomeFrame=new JFrame("List Of Items");
        HomeFrame.setLayout(null);
        HomeFrame.setBounds(300,100,500,500);
        HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title=new JLabel("List of Out Of Stock Items");
        title.setBounds(130,20,300,40);
        title.setBackground(Color.WHITE);
        title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        title.setForeground(Color.BLACK);
        HomeFrame.add(title);

        table=new JTable();
        //   table.setModel(new FinalTableModel(obj.readFromFile("inventoryList.txt"));
        table.setModel(new FinalTableModel(obj.outOfStockitemsInList()));
        table.setBounds(10,80,450,300);
        TableColumnModel colModel=table.getColumnModel();
        colModel.getColumn(5).setPreferredWidth(150);
        colModel.getColumn(4).setPreferredWidth(150);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        HomeFrame.add(table);

        back=new JButton("Back");
        back.setBounds(180,390,100,40);
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
        HomeFrame.add(back);

        HomeFrame.setBackground(Color.WHITE);
        HomeFrame.setVisible(true);


    }

}
