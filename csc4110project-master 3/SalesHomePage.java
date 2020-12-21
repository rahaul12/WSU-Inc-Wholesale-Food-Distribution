import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.*;
/**
 *
 * SalesHomePage.java
 * Purpose: Login Page
 *
 * @author Allen Paul, fw1067
 * @version 3.0 10/29/20
 */
public class SalesHomePage extends JFrame {
    JButton CustomerOrderFormb,CustomerDetailsFormb, logout;
    public SalesHomePage(){
        CustomerDetailsFormb = new JButton("Customer Details Form");
        CustomerDetailsFormb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerDetailsForm temp = new CustomerDetailsForm();
                SalesHomePage.this.dispose();
            }
        });

        CustomerOrderFormb = new JButton("Customer Order Form");
        CustomerOrderFormb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerOrderForm();
            }
        });

        logout = new JButton("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                SalesHomePage.this.dispose();
            }
        });

        add(CustomerDetailsFormb);
        add(CustomerOrderFormb);
        add(logout);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(350,250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}