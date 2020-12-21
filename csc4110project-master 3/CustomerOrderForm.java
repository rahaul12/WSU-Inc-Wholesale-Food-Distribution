import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class CustomerOrderForm {
    int limit = 50;
    int lines;
//DataFields

    JTextField Customer, ItemName, OrderDate, OrderQuantity,
            NeedbyDate, ShippedInfo, ONotes;

    public CustomerOrderForm() {
        //Buttons
        JFrame frame = new JFrame();
        JButton submitButton = new JButton("Submit!");
        JButton backButton = new JButton("Back");
        JButton view = new JButton("View Customer Order Details");
        JPanel panel = new JPanel();
        JButton eraseButton = new JButton();

        JLabel CustomerLabel = new JLabel("Customer Name: ");
        Customer = new JTextField();
        JLabel ItemNameLabel = new JLabel("Item Name: ");
        ItemName = new JTextField();
        JLabel OrderDateLabel = new JLabel("Order Date: ");
        OrderDate = new JTextField();
        JLabel OrderQuantityLabel = new JLabel("Order Quantity: ");
        OrderQuantity = new JTextField();
        JLabel NeedbyLabel = new JLabel("Need By Date: ");
        NeedbyDate = new JTextField();
        JLabel ShippedInfoLabel = new JLabel("Shipping Information: ");
        ShippedInfo = new JTextField();
        JLabel ONotesLabel = new JLabel("Order Notes: ");
        ONotes = new JTextField();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(CustomerLabel);
        panel.add(Customer);
        panel.add(ItemNameLabel);
        panel.add(ItemName);
        panel.add(OrderDateLabel);
        panel.add(OrderDate);
        panel.add(OrderQuantityLabel);
        panel.add(OrderQuantity);
        panel.add(NeedbyLabel);
        panel.add(NeedbyDate);
        panel.add(ShippedInfoLabel);
        panel.add(ShippedInfo);
        panel.add(ONotesLabel);
        panel.add(ONotes);


        //Check if file exists

        File file = new File("CustomerOrderForm.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Button Actions
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String output = Customer.getText() + "," + ItemName.getText() + ","
                        + OrderDate.getText() + "," + OrderQuantity.getText() + ","
                        + NeedbyDate.getText() + "," + ShippedInfo.getText() + ","
                        + ONotes.getText() + "," + "\n";
                CustomerOrderForm limitFile = new CustomerOrderForm();
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

        panel.add(backButton);
        backButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SalesHomePage();
                frame.setVisible(false);
            }
        }));


        panel.add(backButton);
        panel.add(view);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
//               viewCustomerDetails view = (viewCustomerDetails)table.getModel
                viewCustomerOrder view = new viewCustomerOrder(true);
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
        BufferedReader reader = new BufferedReader(new FileReader("CustomerOrderForm.txt"));
        int lineCount = 0;
        while (reader.readLine() != null)
            lineCount++;
        if (lineCount + 1 > 50) {
            JOptionPane.showMessageDialog(frame, "Customer Limit Has Been Reached",
                    "Customer Limit ERROR", JOptionPane.WARNING_MESSAGE);
            b = false;
        }
        reader.close();
        return b;
    }
}

