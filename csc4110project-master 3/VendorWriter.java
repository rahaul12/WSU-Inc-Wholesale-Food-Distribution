import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JFrame;

/**
 *
 * VendorWriter.java
 * Purpose: Write to Vendor Details file from user input.
 *
 * @author Nolan Colter, go7391
 * @version 3.0 11/30/20
 */

public class VendorWriter {

    //create fields to store data
    JTextField vendorName, creationDate, address, city, state, zipCode, phone, email,
            lastOrderAmount, lastOrderDate, lastPaymentDate, lastPaymentAmount, balance,
            seasonDiscountStartDate, creditAmount, status, notes;

    //create text file or add to existing
    public VendorWriter() {

        File file = new File("vendorList.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //general buttons
        JFrame frame = new JFrame();
        JButton submit = new JButton("Submit");
        JButton backButton = new JButton("Back");
        JButton view = new JButton("View Vendor Details");
        JPanel panel = new JPanel();


        //labels and text fields
        JLabel vendorLabel = new JLabel("Vendor Name: ");
        vendorName = new JTextField();

        JLabel creationLabel = new JLabel("Creation Date: ");
        creationDate = new JTextField();

        JLabel addressLabel = new JLabel("Address: ");
        address = new JTextField();

        JLabel cityLabel = new JLabel("City: ");
        city = new JTextField();

        JLabel stateLabel = new JLabel("State: ");
        state = new JTextField();

        JLabel zipCodeLabel = new JLabel("Zip Code: ");
        zipCode = new JTextField();

        JLabel phoneLabel = new JLabel("Phone: ");
        phone = new JTextField();

        JLabel emailLabel = new JLabel("Email: ");
        email = new JTextField();

        JLabel lastOrderAmountLabel = new JLabel("Last Order Amount: ");
        lastOrderAmount = new JTextField();

        JLabel lastOrderDateLabel = new JLabel("Last Order Date: ");
        lastOrderDate = new JTextField();

        JLabel lastPaymentDateLabel = new JLabel("Last Payment Date: ");
        lastPaymentDate = new JTextField();

        JLabel lastPaymentAmountLabel = new JLabel("Last Payment Amount: ");
        lastPaymentAmount = new JTextField();

        JLabel balanceLabel = new JLabel("Balance: ");
        balance = new JTextField();

        JLabel seasonDiscountDateLabel = new JLabel("Season Discount Date: ");
        seasonDiscountStartDate = new JTextField();

        JLabel creditAmountLabel = new JLabel("Credit Amount: ");
        creditAmount = new JTextField();

        JLabel statusLabel = new JLabel("Status: ");
        status = new JTextField();

        JLabel notesLabel = new JLabel("Notes: ");
        notes = new JTextField();


        //layouts
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout(0,1));

        //input panels
        panel.add(vendorLabel);
        panel.add(vendorName);
        panel.add(creationLabel);
        panel.add(creationDate);
        panel.add(addressLabel);
        panel.add(address);
        panel.add(cityLabel);
        panel.add(city);
        panel.add(stateLabel);
        panel.add(state);
        panel.add(zipCodeLabel);
        panel.add(zipCode);
        panel.add(phoneLabel);
        panel.add(phone);
        panel.add(emailLabel);
        panel.add(email);
        panel.add(lastOrderAmountLabel);
        panel.add(lastOrderAmount);
        panel.add(lastOrderDateLabel);
        panel.add(lastOrderDate);
        panel.add(lastPaymentAmountLabel);
        panel.add(lastPaymentAmount);
        panel.add(lastPaymentDateLabel);
        panel.add(lastPaymentDate);
        panel.add(balanceLabel);
        panel.add(balance);
        panel.add(seasonDiscountDateLabel);
        panel.add(seasonDiscountStartDate);
        panel.add(creditAmountLabel);
        panel.add(creditAmount);
        panel.add(statusLabel);
        panel.add(status);
        panel.add(notesLabel);
        panel.add(notes);

        panel.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = vendorName.getText() + ", " + creationDate.getText() + ", " +
                        address.getText() + ", " + city.getText() + ", " +
                        state.getText() + ", " + zipCode.getText() + ", " +
                        phone.getText() + ", " + email.getText() + ", " + "$" +
                        lastOrderAmount.getText() + ", " +
                        lastOrderDate.getText() + ", " + lastPaymentDate.getText() + ", " + "$" +
                        lastPaymentAmount.getText() + ", " + "$" + balance.getText() + ", " +
                        seasonDiscountStartDate.getText() + ", " + "$" + creditAmount.getText() + ", " +
                        status.getText() + ", " + notes.getText() + System.lineSeparator();
                System.out.println("Submitted");

                VendorWriter limitFile = new VendorWriter();
                try {
                    if (limitFile.LineCounter(frame)) {
                        try{
                            FileWriter writer = new FileWriter(file, true);
                            writer.write(text);
                            writer.close();
                            System.out.println("Submitted into Text File");

                        } catch (IOException ex){
                            ex.printStackTrace();
                        }
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
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
                ViewVendor viewVendor = new ViewVendor();
                viewVendor.view(true);
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public boolean LineCounter(JFrame frame) throws IOException {
        boolean b = true;
        BufferedReader reader = new BufferedReader(new FileReader("vendorList.txt"));
        int lineCount = 0;
        while (reader.readLine() != null)
            lineCount++;
        if (lineCount + 1 > 50) {
            JOptionPane.showMessageDialog(frame, "Vendor Limit Has Been Reached",
                    "Vendor Limit", JOptionPane.WARNING_MESSAGE);
            b = false;
        }
        reader.close();
        return b;
    }
}
