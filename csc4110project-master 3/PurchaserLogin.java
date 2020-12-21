import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

/**
 *
 * PurchaserLogin.java
 * Purpose: Use a login page, main page.
 *
 * @author Nolan Colter, go7391
 * @version 3.0 11/01/20
 */

public class PurchaserLogin extends JFrame {
    JButton addPurchaseOrderForm, addVendorList, addItemList, logout;

    public PurchaserLogin() {
        addPurchaseOrderForm = new JButton("Make Purchase Order");
        addPurchaseOrderForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PurchaseOrderForm temp = new PurchaseOrderForm();
                PurchaserLogin.this.dispose();
            }
        });

        addVendorList = new JButton("Add to Vendor List");
        addVendorList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VendorWriter temp = new VendorWriter();
                PurchaserLogin.this.dispose();
            }
        });

        addItemList = new JButton("Add to Item List");
        addItemList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemWriter temp = new ItemWriter();
                PurchaserLogin.this.dispose();
            }
        });

        logout = new JButton("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                PurchaserLogin.this.dispose();
            }
        });

        add(addPurchaseOrderForm);
        add(addVendorList);
        add(addItemList);
        add(logout);

        setTitle("Wayne State University Inc.");
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(350,250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new PurchaserLogin();
    }
}
