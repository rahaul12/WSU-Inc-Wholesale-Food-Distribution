import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * ViewAccountsPayInfo.java
 * Purpose: Page will used to view Accounts Payable Information in a table
 *
 * @author Showrabh Dhar, ga5982
 * @version 3.0 10/29/20
 */

//File will allow user to view Accounts payable information in a table

public class ViewAccountsPayInfo extends JFrame {
    private List<String[]> dataRecordsList;
    private JTable accountTable;
//    private JFrame frame;


    public ViewAccountsPayInfo() {
        dataRecordsList = new ArrayList<>();

        String[] columns = {"ID", "Vendor","PO Number", "Balance", "Payment Date", "Check Number","Payment",
        "Total Payment Amount", "Tax Rate", "Tax Amount"};

        accountTable = new JTable();
        DefaultTableModel tableModel;

        tableModel = new DefaultTableModel(0,2);
        tableModel.setColumnIdentifiers(columns);
        accountTable.setModel(tableModel);

        AccountsPayableFileManager fileManager = AccountsPayableFileManager.getInstance();
        ArrayList<AccountsPayable> list = fileManager.getAccountsPayableList();

        for(AccountsPayable payable : list){
            String info = fileManager.getString(payable);
            String[] dataArray = info.split(",");
            dataRecordsList.add(dataArray);
            tableModel.addRow(dataArray);
        }
//Return back
        JButton backButton = new JButton("Back to Accountant Home Page");
        JButton editButton = new JButton("Edit");
        JPanel panel = new JPanel();

        panel.add(backButton);
        panel.add(editButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAccountantHomePage();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editSelectedRecord();
            }
        });

        this.add(new JScrollPane(accountTable), BorderLayout.CENTER);
        this.add(panel, BorderLayout.SOUTH);

        this.setTitle("View Account's Payable Information");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


    private void showAccountantHomePage() {
        AccountantHomePage view = new AccountantHomePage();
        this.setVisible(false);
    }

    private void editSelectedRecord() {
        int selectedRow = accountTable.getSelectedRow();
        String[] data = dataRecordsList.get(selectedRow);
        AccountsPayable accountsPayable = AccountsPayableFileManager.createAccountsPayableFromString(data);
        new AccountsPayForm(accountsPayable);
        this.setVisible(false);
    }


}



