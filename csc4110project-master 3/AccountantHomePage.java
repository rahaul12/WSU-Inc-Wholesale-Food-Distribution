import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * AccountantHomePage.java
 * Purpose: Page will be set as the homepage for the Accountant
 *
 * @author Showrabh Dhar, ga5982
 * @version 3.0 10/29/20
 */
//Home Page for Accountant. Will have all appropriate buttons for Accountant and will lead them to features requested.

public class AccountantHomePage extends JFrame{

    public AccountantHomePage() {

        InvoiceAlert alert = new InvoiceAlert();
        alert.readTextFile();

//Creating Buttons and Frame
        JFrame frame = new JFrame();

        JButton CreateAccPayInfo = new JButton("Create Account's Payable Information");
        JButton CreateInvoices = new JButton("Create New Invoice");
        JButton viewAccPayInfo = new JButton("View Account's Payable Information");
        JButton viewInvoices = new JButton("View Invoices");
        JButton returnToLoginPage = new JButton("Return to Login Page");
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        panel.setLayout(new GridLayout(0,1));

//Following Buttons will lead to class files that will run action mentioned
        panel.add(CreateAccPayInfo);
        CreateAccPayInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountsPayForm temp = new AccountsPayForm();
                frame.setVisible(false);
                frame.dispose();
            }
        });

        panel.add(viewAccPayInfo);
        viewAccPayInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewAccountsPayInfo temp = new ViewAccountsPayInfo();
                frame.dispose();
            }
        });

        panel.add(CreateInvoices);
        CreateInvoices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InvoiceForm temp = new InvoiceForm();
                frame.setVisible(false);
                frame.dispose();
            }
        });

        panel.add(viewInvoices);
        viewInvoices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewInvoices temp = new ViewInvoices(true);
                frame.dispose();
            }
        });

        panel.add(returnToLoginPage);
        returnToLoginPage.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                frame.setVisible(false);
            }
        }));

//Formatting
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Wayne State University Inc");
        frame.pack();
        frame.setVisible(true);
    }
}


