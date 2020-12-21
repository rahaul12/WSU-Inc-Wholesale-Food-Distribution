import javax.swing.*;
import java.io.*;

/**
 *
 * InvoiceAlert.java
 * Purpose: Page will be used to hold functionality of Alerting the Accountant about Invoices that are needed
 *
 * @author Showrabh Dhar, ga5982
 * @version 3.0 10/29/20
 */

public class InvoiceAlert {
    private static final String INVOICE_ALERT_FILE= "InvoiceAlert.txt";

    private File file = new File(INVOICE_ALERT_FILE);


    public InvoiceAlert() {
    }

    public void createFilesIfNotExists() {
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter writer = new FileWriter(file,false);
                writer.write("true");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                FileWriter writer = new FileWriter(file, false);
                writer.write("true");
                writer.flush();
                writer.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void readTextFile() {
        String line;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));

            if ((line = reader.readLine()).equals("true")) {
                JOptionPane.showMessageDialog(null, "A Purchase Order has been created. " +
                        "Please Create an Invoice!", "Invoice Notification", JOptionPane.WARNING_MESSAGE);

                PrintWriter writer = new PrintWriter(file);
                writer.print("false");
                writer.close();
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
            e.printStackTrace();
        }
    }



}
