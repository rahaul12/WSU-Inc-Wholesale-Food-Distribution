import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 *
 * CustomerDetailsForm.java
 * Purpose: Create CustomerDetailsForm
 *
 * @author Allen Paul, fw1067
 * @version 3.0 10/29/20
 */

public class CustomerDetailsForm {


    // DataFields
    JTextField Name,ManagersName, ManagersPhoneNumber, CreationDate,
            Address, City, State, ZipCode, Phone, EmailId, LastOrderAmount,
            LastOrderDate, LastPaymentDate, LastPaymentAmount, BalanceAmount,
            CreditAmount, Status, Notes;

    public CustomerDetailsForm() {
//Buttons
        JFrame frame = new JFrame();
        JButton submitButton = new JButton("Submit!");
        JButton backButton = new JButton("Back");
        JButton view = new JButton("View Customer Details");
        JPanel panel = new JPanel();
        JButton eraseButton = new JButton();

        JLabel NameLabel = new JLabel("Name: ");
        Name = new JTextField();
        JLabel ManagerNameLabel = new JLabel("Manager's Name: ");
        ManagersName = new JTextField();
        JLabel ManagerPhoneLabel = new JLabel("Manager Phone: ");
        ManagersPhoneNumber = new JTextField();
        JLabel creationDateLabel = new JLabel("Creation Date: (01/01/2020 FORMAT)");
        CreationDate = new JTextField();
        JLabel AddressLabel = new JLabel("Address: ");
        Address = new JTextField();
        JLabel CityLabel = new JLabel("City: ");
        City = new JTextField();
        JLabel StateLabel = new JLabel("State: ");
        State = new JTextField();
        JLabel ZipCodeLabel = new JLabel("Zip code: ");
        ZipCode = new JTextField();
        JLabel EmailIDLabel = new JLabel("Email: ");
        EmailId = new JTextField();
        JLabel PhoneLabel = new JLabel("Phone: ");
        Phone = new JTextField();
        JLabel LastOrderAmountLabel = new JLabel("Last Order Amount: ");
        LastOrderAmount = new JTextField();
        JLabel LastOrderDateLabel = new JLabel("Last Order Date: (01/01/2020 FORMAT)");
        LastOrderDate = new JTextField();
        JLabel LastPaymentDateLabel =  new JLabel("Last Payment Date:(01/01/2020 FORMAT)");
        LastPaymentDate = new JTextField();
        JLabel LastPaymentAmountLabel = new JLabel("Last Payment Amount: ");
        LastPaymentAmount = new JTextField();
        JLabel BalanceAmountLabel = new JLabel("Balance Amount: ");
        BalanceAmount = new JTextField();
        JLabel CreditAmountLabel = new JLabel("Credit Amount: ");
        CreditAmount = new JTextField();
        JLabel StatusLabel = new JLabel("Status: ");
        Status = new JTextField();
        JLabel NotesLabel = new JLabel("Notes: ");
        Notes = new JTextField();

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout(0,1));

        panel.add(NameLabel);
        panel.add(Name);
        panel.add(ManagerNameLabel);
        panel.add(ManagersName);
        panel.add(ManagerPhoneLabel);
        panel.add(ManagersPhoneNumber);
        panel.add(creationDateLabel);
        panel.add(CreationDate);
        panel.add(AddressLabel);
        panel.add(Address);
        panel.add(CityLabel);
        panel.add(City);
        panel.add(StateLabel);
        panel.add(State);
        panel.add(ZipCodeLabel);
        panel.add(ZipCode);
        panel.add(EmailIDLabel);
        panel.add(EmailId);
        panel.add(PhoneLabel);
        panel.add(Phone);
        panel.add(LastOrderAmountLabel);
        panel.add(LastOrderAmount);
        panel.add(LastOrderDateLabel);
        panel.add(LastOrderDate);
        panel.add(LastPaymentAmountLabel);
        panel.add(LastPaymentAmount);
        panel.add(LastPaymentDateLabel);
        panel.add(LastPaymentDate);
        panel.add(BalanceAmountLabel);
        panel.add(BalanceAmount);
        panel.add(CreditAmountLabel);
        panel.add(CreditAmount);
        panel.add(StatusLabel);
        panel.add(Status);
        panel.add(NotesLabel);
        panel.add(Notes);
//Check if file exists
        File file = new File("CustomerDetails.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalesValidation salesValidation = new SalesValidation();
                salesValidation.setName(Name.getText());
                salesValidation.setManagersName(ManagersName.getText());
                salesValidation.setManagersPhoneNumber(ManagersPhoneNumber.getText());
                salesValidation.setCreationDate(CreationDate.getText());
                salesValidation.setAddress(Address.getText());
                salesValidation.setCity(City.getText());
                salesValidation.setState(State.getText());
                salesValidation.setZipcode(Integer.parseInt(ZipCode.getText()));
                salesValidation.setPhone(Phone.getText());
                salesValidation.setEmailId(EmailId.getText());
                salesValidation.setLastOrderAmount(Integer.parseInt(LastOrderAmount.getText()));
                salesValidation.setLastOrderDate(LastOrderDate.getText());
                salesValidation.setLastPaymentDate(LastPaymentDate.getText());
                salesValidation.setBalanceAmount(Integer.parseInt(BalanceAmount.getText()));
                salesValidation.setCreditAmount(Integer.parseInt(CreditAmount.getText()));
                salesValidation.setStatus(Status.getText());
                salesValidation.setNotes(Notes.getText());
                String output = salesValidation.getName() + "," + salesValidation.getManagersName() + ","
                        + salesValidation.getManagersPhoneNumber() + "," + salesValidation.getCreationDate() + ","
                        + salesValidation.getAddress() + "," + salesValidation.getCity() + ","
                        + salesValidation.getState() + "," + salesValidation.getZipcode() + ","
                        + salesValidation.getPhone() + "," + salesValidation.getEmailId()
                        + "," + salesValidation.getLastOrderAmount() +","
                        +"$" + salesValidation.getOrderDate() + "," + salesValidation.getLastPaymentDate() + ","
                        + "$"+ salesValidation.getBalanceAmount() + "," + salesValidation.getCreditAmount() + ","
                        + salesValidation.getStatus() + "," + salesValidation.getNotes() + "\n";
                CustomerDetailsForm limitFile = new CustomerDetailsForm();
                System.out.println("Submitted into Text File");

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

        panel.add(view);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
//               viewCustomerDetails view = (viewCustomerDetails)table.getModel
                final viewCustomerDetails view = new viewCustomerDetails(true);
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

