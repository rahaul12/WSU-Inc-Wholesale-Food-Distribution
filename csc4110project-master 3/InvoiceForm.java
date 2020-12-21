import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 *
 * InvoiceForm.java
 * Purpose: Form will be used to create Invoices
 *
 * @author Showrabh Dhar, ga5982
 * @version 3.0 10/29/20
 */

//File will create Invoice Form and store information in a file

public class InvoiceForm {

    JTextField customer,invoiceNumber,invoiceDate,orderDate,PONumber,item,quantityShipped,
            totalCostOfItem,totalCustomerBalance,totalPayableAmount,taxRate,taxAmount,salesPerson,deliveredDate,notes;

    public InvoiceForm(){

//Creates file if it does not exist
        File file = new File("Invoices.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//Creates Buttons and Labels as well as Text fields for user to enter information
        JFrame frame = new JFrame();
        JButton submitButton = new JButton("Submit!");
        JButton backButton = new JButton("Back");
        JButton viewInvoicesPage = new JButton("View Invoice Forms");
        JPanel panel = new JPanel();

        JLabel customerLabel = new JLabel("Customer: ");
        customer = new JTextField();
        JLabel invoiceNumberLabel = new JLabel("Invoice Number: ");
        invoiceNumber = new JTextField();
        JLabel invoiceDateLabel = new JLabel("Invoice Date (01/01/2020 FORMAT): ");
        invoiceDate= new JTextField();
        JLabel orderDateLabel = new JLabel("Order Date (01/01/2020 FORMAT): ");
        orderDate= new JTextField();
        JLabel PONumberLabel = new JLabel("PO Number: ");
        PONumber = new JTextField();
        JLabel itemLabel = new JLabel("Item: ");
        item= new JTextField();
        JLabel quantityShippedLabel = new JLabel("Quantity Shipped: ");
        quantityShipped= new JTextField();
        JLabel totalCostOfItemLabel = new JLabel("Total Cost of Item: ");
        totalCostOfItem= new JTextField();
        JLabel totalCustomerBalanceLabel = new JLabel("Total Customer Balance: ");
        totalCustomerBalance= new JTextField();
        JLabel totalPayableAmountLabel = new JLabel("Total Payable Amount: ");
        totalPayableAmount= new JTextField();
        JLabel taxRateLabel = new JLabel("Tax Rate: ");
        taxRate= new JTextField();
        JLabel taxAmountLabel = new JLabel("Tax Amount: ");
        taxAmount= new JTextField();
        JLabel salesPersonLabel = new JLabel("Sales Person: ");
        salesPerson= new JTextField();
        JLabel deliveredDateLabel = new JLabel("Delivered Date (01/01/2020 FORMAT): ");
        deliveredDate= new JTextField();
        JLabel notesLabel = new JLabel("Notes: ");
        notes= new JTextField();

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout(0,1));

//display to user
        panel.add(customerLabel);
        panel.add(customer);
        panel.add(invoiceNumberLabel);
        panel.add(invoiceNumber);
        panel.add(invoiceDateLabel);
        panel.add(invoiceDate);
        panel.add(orderDateLabel);
        panel.add(orderDate);
        panel.add(PONumberLabel);
        panel.add(PONumber);
        panel.add(itemLabel);
        panel.add(item);
        panel.add(quantityShippedLabel);
        panel.add(quantityShipped);
        panel.add(totalCostOfItemLabel);
        panel.add(totalCostOfItem);
        panel.add(totalCustomerBalanceLabel);
        panel.add(totalCustomerBalance);
        panel.add(totalPayableAmountLabel);
        panel.add(totalPayableAmount);
        panel.add(taxRateLabel);
        panel.add(taxRate);
        panel.add(taxAmountLabel);
        panel.add(taxAmount);
        panel.add(salesPersonLabel);
        panel.add(salesPerson);
        panel.add(deliveredDateLabel);
        panel.add(deliveredDate);
        panel.add(notesLabel);
        panel.add(notes);

//Store information into file
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String output = customer.getText() + "," + invoiceNumber.getText() + ","
                        + invoiceDate.getText() + "," + orderDate.getText() + ","
                        + PONumber.getText() + "," + item.getText() + ","
                        + quantityShipped.getText() + "," + "$"+totalCostOfItem.getText() + ","
                        + "$"+totalCustomerBalance.getText() +","+ "$"+totalPayableAmount.getText()+","+
                        taxRate.getText()+","+"$"+taxAmount.getText()+","+salesPerson.getText()+","+
                        deliveredDate.getText()+","+notes.getText()+"\n";

                InvoiceForm limitFile = new InvoiceForm();

                try{
                    if (limitFile.LineCounter(frame)) {
                        try{
                            FileWriter writer = new FileWriter(file,true);
                            writer.write(output);
                            writer.close();
                            System.out.println("Submitted into Text File");
                        }catch (IOException ex){
                            ex.printStackTrace();
                        }
                        frame.dispose();
                    }
                } catch (IOException ex){
                    ex.printStackTrace();
                }

                frame.dispose();
            }
        });

//Returns to home
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountantHomePage view = new AccountantHomePage();
//                InvoiceAlert alert = new InvoiceAlert();
//                alert.createFilesIfNotExists();
                frame.setVisible(false);
            }
        });

        panel.add(backButton);

        panel.add(viewInvoicesPage);
        viewInvoicesPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewInvoices temp =  new ViewInvoices(true);
            }
        });


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Wayne State University Inc");
        frame.pack();
        frame.setVisible(true);

    }

    public boolean LineCounter(JFrame frame) throws IOException {
        boolean b = true;
        BufferedReader reader = new BufferedReader(new FileReader("Invoices.txt"));
        int lineCount = 0;
        while (reader.readLine() != null)
            lineCount++;
        if (lineCount + 1 > 20) {
            JOptionPane.showMessageDialog(frame, "Item Limit Has Been Reached",
                    "Item Limit ERROR", JOptionPane.WARNING_MESSAGE);
            b = false;
        }
        reader.close();
        return b;
    }
}
