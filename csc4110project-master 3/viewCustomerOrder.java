import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * viewCustomerOrder.java
 * Purpose: viewing Customer Order Form
 *
 * @author Allen Paul, fw1067
 * @version 3.0 10/29/20
 */
public class viewCustomerOrder  extends JFrame {
    public viewCustomerOrder(boolean b) {
        String[] columns = {"Customer", "Item Name", "Order Quantity", "Need by Date",
                "Shipping Information", "Notes"};


        JTable CustomerTable = new JTable();
        DefaultTableModel tableModel;

        tableModel = new DefaultTableModel(0, 2);
        tableModel.setColumnIdentifiers(columns);
        CustomerTable.setModel(tableModel);

        String line;
        BufferedReader reader;

        File file = new File("CustomerDetails.txt");
        if(!file.exists())
        {
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                tableModel.addRow(line.split(","));
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
            e.printStackTrace();
        }

        this.add(new JScrollPane(CustomerTable));

        this.setTitle("Customer Order Details");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

}



