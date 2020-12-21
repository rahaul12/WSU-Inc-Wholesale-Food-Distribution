import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.*;

class Sales extends JFrame {
    JButton CustomerOrderFormb,CustomerDetailsFormb, logout;
    public Sales(){
        CustomerDetailsFormb = new JButton("Customer Details Form");
        CustomerDetailsFormb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerDetailsForm temp = new CustomerDetailsForm();
                Sales.this.dispose();
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
                Sales.this.dispose();
            }
        });

        add(CustomerDetailsFormb);
        add(CustomerOrderFormb);
        add
                (logout);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(350,250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}