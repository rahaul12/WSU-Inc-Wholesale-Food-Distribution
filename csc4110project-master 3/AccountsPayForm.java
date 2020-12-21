import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * AccountsPayForm.java
 * Purpose: Form for Accountant to create Accounts Payable Information
 *
 * @author Showrabh Dhar, ga5982
 * @version 3.0 10/29/20
 */

//Accounts Payable Information Form will store information into a file

public class AccountsPayForm {

    private boolean newRecord;

    JTextField vendorName, PONumber, balance, paymentDate, checkNumber, payment, totalPayableAmount, taxRate, taxAmount ;
    private AccountsPayable accountsPayable;
    private JFrame frame;

    public AccountsPayForm() {
        this(null);

    }

    public AccountsPayForm(AccountsPayable accountsPayable) {
        this.accountsPayable = accountsPayable;
        if(accountsPayable == null) {
            this.newRecord = true;
        }
        else{
            this.newRecord = false;
        }
        createGUI();
    }

    private void createGUI(){
//Creating Buttons and panels
        frame = new JFrame();
        JPanel panel = createFormPanel();

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Wayne State University Inc");
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel();

        addFormComponents(panel);
        if(accountsPayable != null) {
            setFieldValues();
        }

//Buttons will do what was mentioned. Submit will take in the values in textfield and store them into the file
        JButton submitButton = new JButton("Submit!");
        JButton backButton = new JButton("Back");
        JButton viewAccounts = new JButton("View Account's Payable Information");

        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFormData();
//                frame.dispose();
            }
        });
//Return to Home Page of Accountant
        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountantHomePage view = new AccountantHomePage();
                frame.setVisible(false);
                frame.dispose();
            }
        });

//View Account Payable Information in a table. Will lead to view file.
        panel.add(viewAccounts);
        viewAccounts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewAccountsPayInfo view = new ViewAccountsPayInfo();
                frame.dispose();
            }
        });
        return panel;
    }

    private void saveFormData() {
        if(newRecord) {
            accountsPayable = new AccountsPayable();
        }
        accountsPayable.setVendorName(vendorName.getText());
        accountsPayable.setPONumber(PONumber.getText());
        accountsPayable.setBalance(Double.parseDouble(balance.getText()));
        accountsPayable.setPaymentDate(paymentDate.getText());
        accountsPayable.setCheckNumber(checkNumber.getText());
        accountsPayable.setPayment(Double.parseDouble(payment.getText()));
        accountsPayable.setTotalPayableAmount(Double.parseDouble(totalPayableAmount.getText()));
        accountsPayable.setTaxRate(Double.parseDouble(taxRate.getText()));
        accountsPayable.setTaxAmount(Double.parseDouble(taxAmount.getText()));

        AccountsPayableFileManager accountsPayableFileManager = AccountsPayableFileManager.getInstance();
        if(newRecord) {
            accountsPayable.setId(accountsPayableFileManager.getNextId());
            accountsPayableFileManager.add(accountsPayable);
            JOptionPane.showMessageDialog(frame, "Created Invoice",
                    "Invoice Notification", JOptionPane.WARNING_MESSAGE);
        }
        else{
            accountsPayableFileManager.update(accountsPayable);
            JOptionPane.showMessageDialog(frame, "Reminder: Create an Invoice",
                    "Invoice Notification", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void addFormComponents(JPanel panel) {
        JLabel vendorLabel = new JLabel("Vendor Name: ");
        vendorName = new JTextField();
        JLabel PONumberLabel = new JLabel("Purchase Order Number: ");
        PONumber = new JTextField();
        JLabel balanceLabel = new JLabel("Balance: ");
        balance = new JTextField();
        JLabel paymentDateLabel = new JLabel("Payment Date: (01/01/2020 FORMAT)");
        paymentDate = new JTextField();
        JLabel checkNumberLabel = new JLabel("Check Number: ");
        checkNumber = new JTextField();
        JLabel paymentLabel = new JLabel("Payment: ");
        payment = new JTextField();
        JLabel totalPayableAmountLabel = new JLabel("Total Payable Amount: ");
        totalPayableAmount = new JTextField();
        JLabel taxRateLabel = new JLabel("Tax Rate: ");
        taxRate = new JTextField();
        JLabel taxAmountLabel= new JLabel("Taxed Amount: ");
        taxAmount = new JTextField();

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout(0,1));

//Letting the user view them on the GUI
        panel.add(vendorLabel);
        panel.add(vendorName);
        panel.add(PONumberLabel);
        panel.add(PONumber);
        panel.add(balanceLabel);
        panel.add(balance);
        panel.add(paymentDateLabel);
        panel.add(paymentDate);
        panel.add(checkNumberLabel);
        panel.add(checkNumber);
        panel.add(paymentLabel);
        panel.add(payment);
        panel.add(totalPayableAmountLabel);
        panel.add(totalPayableAmount);
        panel.add(taxRateLabel);
        panel.add(taxRate);
        panel.add(taxAmountLabel);
        panel.add(taxAmount);
    }

    private void setFieldValues() {
        vendorName.setText(accountsPayable.getVendorName());
        PONumber.setText(accountsPayable.getPONumber());
        balance.setText(accountsPayable.getBalance() + "");
        paymentDate.setText(accountsPayable.getPaymentDate());
        checkNumber.setText(accountsPayable.getCheckNumber());
        payment.setText(accountsPayable.getPayment() + "");
        totalPayableAmount.setText(accountsPayable.getTotalPayableAmount() + "");
        taxRate.setText(accountsPayable.getTaxRate() + "");
        taxAmount.setText(accountsPayable.getTaxAmount() + "");
    }
}


