import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 *
 * Purpose: Owner homepage.
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Class that displays Owner Homepage.
 *
 */
// Owner Homepage GUI
public class Owner extends JFrame {
    JButton addEmployee, viewEmployees, logout;
    public Owner(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        panel.setLayout(new GridLayout(0,1));

        addEmployee = new JButton("Add Employee");
        addEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeForm();
                Owner.this.dispose();
                frame.setVisible(false); }
        });

        viewEmployees = new JButton("View Employees");
        viewEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeTable();
            }
        });

        logout = new JButton("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                Owner.this.dispose();
                frame.setVisible(false); }
        });

        panel.add(addEmployee);
        panel.add(viewEmployees);
        panel.add(logout);
        /*setLayout(new FlowLayout());
        setVisible(true);
        setSize(350,250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
        frame.add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Owner Homepage");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(350,250);
    }
}
