import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * viewCustomerDetails.java
 * Purpose: viewing Customer Details Form
 *
 * @author Allen Paul, fw1067
 * @version 3.0 10/29/20
 */
public class viewCustomerDetails  extends JFrame {
    public viewCustomerDetails(boolean b) {
        String[] columns = {"Name", "Manager's Name", "Manager's Phone Number", "Creation Date",
                "Address", "City", "State", "Zip Code", "Phone", "Email Id", "Last Order Amount",
                "Last Order Date", "Last Payment Date", "Last Payment Amount", "Balance Amount",
                "Credit Amount", "Status", "Notes"};


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

                this.setTitle("Customer Details");
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.pack();
                this.setVisible(true);
            }

        }



