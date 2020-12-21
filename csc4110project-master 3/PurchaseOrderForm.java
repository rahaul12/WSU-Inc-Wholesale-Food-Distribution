import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 *
 * PurchaseOrderForm.java
 * Purpose: Create a Purchase Order Form through user input.
 *
 * @author Nolan Colter, go7391
 * @version 3.0 10/29/20
 */

public class PurchaseOrderForm {
    JTextField purchaseOrderNum, itemName, needByDate, quantity, shippingAddress;

    public PurchaseOrderForm() {
        File file = new File("purchaseOrder.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JFrame frame = new JFrame("Purchase Order Form");
        frame.setLayout(new FlowLayout());
        JButton submit = new JButton("Submit");
        JButton backButton = new JButton("Back");
        JButton view = new JButton("View Purchase Orders");
        JPanel panel = new JPanel();

        JLabel purchaseOrderNumLabel = new JLabel("Purchase Order Number: ");
        purchaseOrderNum = new JTextField();
        JLabel itemNameLabel = new JLabel("Item Name: ");
        itemName = new JTextField();
        JLabel needByDateLabel = new JLabel("Need By Date: ");
        needByDate = new JTextField();
        JLabel quantityLabel = new JLabel("Quantity: ");
        quantity = new JTextField();
        JLabel shippingAddressLabel = new JLabel("Shipping Address: ");
        shippingAddress = new JTextField();

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout(0,1));

        panel.add(purchaseOrderNumLabel);
        panel.add(purchaseOrderNum);
        panel.add(itemNameLabel);
        panel.add(itemName);
        panel.add(needByDateLabel);
        panel.add(needByDate);
        panel.add(quantityLabel);
        panel.add(quantity);
        panel.add(shippingAddressLabel);
        panel.add(shippingAddress);

        panel.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String output = purchaseOrderNum.getText() + "," + itemName.getText() + ","
                        + needByDate.getText() + "," + quantity.getText() + ","
                        + shippingAddress.getText() + System.lineSeparator();

                PurchaseOrderForm limitFile = new PurchaseOrderForm();
                try {
                    if (limitFile.LineCounter(frame)) {
                        try{
                            FileWriter writer = new FileWriter(file, true);
                            writer.write(output);
                            writer.close();
                            System.out.println("Submitted into Text File");

                        } catch (IOException ex){
                            ex.printStackTrace();
                        }
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                InvoiceAlert alert = new InvoiceAlert();
                alert.createFilesIfNotExists();
                frame.dispose();
            }
        });

        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PurchaserLogin view = new PurchaserLogin();
                frame.setVisible(false);
            }
        });

        panel.add(view);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewPurchaseOrders viewOrders = new ViewPurchaseOrders();
                viewOrders.view(true);
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public boolean LineCounter(JFrame frame) throws IOException {
        boolean b = true;
        BufferedReader reader = new BufferedReader(new FileReader("purchaseOrder.txt"));
        int lineCount = 0;
        while (reader.readLine() != null)
            lineCount++;
        if (lineCount + 1 > 20) {
            JOptionPane.showMessageDialog(frame, "Purchase Order Limit Has Been Reached",
                    "Purchase Order Limit", JOptionPane.WARNING_MESSAGE);
            b = false;
        }
        reader.close();
        return b;
    }
}