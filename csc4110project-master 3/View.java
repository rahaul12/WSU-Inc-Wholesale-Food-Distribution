import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * View.java
 * Purpose: Abstract class and abstract method for viewing each List.
 *      Includes View functionality for Item Details, Vendor Details, Purchase Orders.
 *
 * @author Nolan Colter, go7391
 * @version 1.0 11/30/20
 */

public abstract class View extends JFrame {
    public abstract void view(boolean b);
}

class ViewItem extends View {
    public void view(boolean b) {
        String[] columns = {"Item Name", "Vendor Name", "Creation Date", "Tax Status", "Item Cost", "Item Category",
                "Recieved Date", "Expiring Date", "Last Order Date", "Purchased Price", "Unit Measurement",
                "Quantity", "Selling Price", "Notes"};

        JTable ItemTable = new JTable();
        DefaultTableModel tableModel;

        tableModel = new DefaultTableModel(0, 2);
        tableModel.setColumnIdentifiers(columns);
        ItemTable.setModel(tableModel);

        BufferedReader reader;

        File file = new File("itemDetails.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            reader = new BufferedReader(new FileReader(file));
            String delimiter;
            while ((delimiter = reader.readLine()) != null) {
                tableModel.addRow(delimiter.split(","));
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
            e.printStackTrace();
        }

        this.add(new JScrollPane(ItemTable));
        this.setTitle("Item Details");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}

class ViewVendor extends View {
    public void view(boolean b) {
        String[] columns = {"Vendor Name", "Creation Date", "Address", "City", "State", "Zip",
                "Phone", "Email", "Last Order Amount", "Last Order Date", "Last Payment Date",
                "Last Payment Amount", "Balance", "Discount Date", "Credit",
                "Status", "Notes"};

        JTable vendorTable = new JTable();
        DefaultTableModel tableModel;

        tableModel = new DefaultTableModel(0, 2);
        tableModel.setColumnIdentifiers(columns);
        vendorTable.setModel(tableModel);

        BufferedReader reader;

        File file = new File("vendorList.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            reader = new BufferedReader(new FileReader(file));
            String delimiter;
            while ((delimiter = reader.readLine()) != null) {
                tableModel.addRow(delimiter.split(","));
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
            e.printStackTrace();
        }

        this.add(new JScrollPane(vendorTable));
        this.setTitle("Vendor Details");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}

class ViewPurchaseOrders extends View {
    public void view(boolean b) {
        String[] columns = {"Purchase Order", "Item Name", "Need By", "Quanitity",
                "Shipping Address"};

        JTable orderTable = new JTable();
        DefaultTableModel tableModel;

        tableModel = new DefaultTableModel(0, 2);
        tableModel.setColumnIdentifiers(columns);
        orderTable.setModel(tableModel);

        BufferedReader reader;

        File file = new File("purchaseOrder.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            reader = new BufferedReader(new FileReader(file));
            String delimiter;
            while ((delimiter = reader.readLine()) != null) {
                tableModel.addRow(delimiter.split(","));
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
            e.printStackTrace();
        }

        this.add(new JScrollPane(orderTable));
        this.setTitle("Purchase Order Details");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}