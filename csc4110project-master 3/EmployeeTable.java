import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * Purpose: Display employee information using a table format.
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Class that will display stored information in Employee.txt
 *
 */

// View employee table
public class EmployeeTable extends JFrame{

    public EmployeeTable()
    {
        File file = openFile("Employee.txt");

        //headers for the table
        String[] columns = {"ID", "Name", "Access Level"};

        //Create Default Table
        JFrame frame = new JFrame();
        JTable contactTable = new JTable();
        DefaultTableModel tableModel;

        // specify number of columns
        tableModel = new DefaultTableModel(0,2);
        tableModel.setColumnIdentifiers(columns);
        contactTable.setModel(tableModel);

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        contactTable.setBackground(Color.LIGHT_GRAY);
        contactTable.setForeground(Color.black);
        Font font = new Font("",1,14);
        contactTable.setFont(font);
        contactTable.setRowHeight(30);
        parseFile(file, tableModel);

        //add the table to the frame
        this.add(new JScrollPane(contactTable));
        this.setTitle("Employee Table");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    private File openFile(String name){
        File file = new File(name);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private void parseFile (File file, DefaultTableModel tableModel){
        String line;
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(file));

            // Separate data by comma and add into each row
            while ((line = reader.readLine()) != null) {
                tableModel.addRow(line.split(","));
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
    }
}
