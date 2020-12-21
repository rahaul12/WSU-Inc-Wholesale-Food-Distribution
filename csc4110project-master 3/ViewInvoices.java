import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Able to View Invoices

/**
 *
 * AccountantHomePage.java
 * Purpose: Page will be used to View Invoices in a table
 *
 * @author Showrabh Dhar, ga5982
 * @version 3.0 10/29/20
 */

public class ViewInvoices extends JFrame{

    public ViewInvoices(boolean b){

        String[] columns = {"Customer","invoiceNumber","invoiceDate","orderDate","PONumber","item","quantityShipped",
                            "totalCostOfItem","totalCustomerBalance","totalPayableAmount","taxRate","taxAmount",
                            "salesPerson","deliveredDate","Notes"};

        JTable invoiceTable = new JTable();
        DefaultTableModel tableModel;
        tableModel = new DefaultTableModel(0,2);
        tableModel.setColumnIdentifiers(columns);
        invoiceTable.setModel(tableModel);

//Create file if it does not exist
        String line;
        BufferedReader reader;
        File file = new File("Invoices.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//Reads file
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

        this.add(new JScrollPane(invoiceTable));

        this.setTitle("View Invoice Table");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

}

