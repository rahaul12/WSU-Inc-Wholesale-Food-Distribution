import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 *
 * Purpose: Employee GUI to store user input
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Class that will display the Employee GUI.
 *  * Stores information from user input to Employee.txt
 *
 */

// Adding Employees into Database GUI
public class EmployeeForm  extends JFrame{

    EmployeeDB employeeDB = null;
    JLabel name, accessLevel;
    JTextField textName;
    JButton register, cancel;
    JComboBox textAccessLevel;
    String level[] = {"Restricted", "Unrestricted"};

    public EmployeeForm(){
        employeeDB = EmployeeDB.getInstance();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        name = new JLabel("Enter name of employee: ");
        textName = new JTextField(20);

        accessLevel = new JLabel("Restrict or Unrestrict: ");
        textAccessLevel = new JComboBox(level);

        panel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        panel.setLayout(new GridLayout(0,1));

        register = new JButton("Add Employee");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeInterface employee = EmployeeFactory.createEmployee();
                setEmployee(employee);
                String output = output(employee);
                employeeDB.writeEmployee(output);
                employeeDB.incrementEmployeeCount(employee.getID());
            }
        });

        cancel = new JButton("Back");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Owner();
                EmployeeForm.this.dispose();
                frame.setVisible(false); }
        });

        panel.add(name);
        panel.add(textName);
        panel.add(accessLevel);
        panel.add(textAccessLevel);
        panel.add(register);
        panel.add(cancel);
        frame.add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Employee Registration");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(350,250);
    }


    //Create employee objects from form
    private void setEmployee(EmployeeInterface employee){
        employee.setID(employeeDB.getNextId());
        employee.setName(textName.getText());
        employee.setAccessLevel(textAccessLevel.getSelectedItem().toString());
    }

    private String output(EmployeeInterface employee){
        String output = employee.getID() + "," + employee.getName() + "," + employee.getAccessLevel() + "\n";
        return output;
    }

}
