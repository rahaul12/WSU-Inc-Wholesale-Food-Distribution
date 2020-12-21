import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 *
 * Purpose: Login page.
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Class that will run the application.
 *  * GUI interface for logging in.
 *  * Controls alerts given to restricted users.
 *  * Dictates the GUI display based on user login.
 *  * Interacts and stores information in Login.txt and Employee.txt
 *
 */
public class Login {
    JLabel username, password;
    JTextField textUserName;
    JPasswordField textPassword;
    JButton login, register;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    public Login() {
        File file = openFile("Login.txt");

        username = new JLabel("Enter Username: ");
        textUserName = new JTextField(20);
        password = new JLabel("Enter Password: ");
        textPassword = new JPasswordField(20);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(0, 1));
        login = new JButton("Login");

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = textUserName.getText();
                String password12 = textPassword.getText();

                try {
                    Scanner read = new Scanner(file);
                    boolean success = false;

                    // Authenticate login details
                    while (read.hasNext()) {
                        String s = read.nextLine();
                        String[] sArr = s.split(",");

                        // Username and password must be in login.txt file
                        if (user.equals(sArr[0]) && password12.equals(sArr[1])) {
                            success = true;
                            chooseUser(user, sArr);
                            break;
                        } else {
                            success = false; } }

                    if (!success) {
                        JOptionPane.showMessageDialog(null,
                                "Invalid Username or Password. Please create an account.",
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE); }
                    read.close();
                } catch (IOException | ParseException | ClassNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace(); } }
        });

        register = new JButton("Register");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register();
                frame.dispose();
                frame.setVisible(false); }
        });

        panel.add(username);
        panel.add(textUserName);
        panel.add(password);
        panel.add(textPassword);
        panel.add(login);
        panel.add(register);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login Page");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(250, 250);
    }

    // Check to see if there is a seasonal alert from vendor
    public void seasonal() throws FileNotFoundException {
        File file = openFile("SeasonalAlert.txt");
        Scanner read = new Scanner(file);
        String line = null;

        while (read.hasNext()) { line = read.nextLine(); }
        if (line.equals("true")) {
            JOptionPane.showMessageDialog(null, "Seasonal discounts for Vendors started.",
                    "ALERT", JOptionPane.INFORMATION_MESSAGE); }
        read.close(); }

    public File openFile(String name) {
        File file = new File(name);
        if (!file.exists()) {
            try {
                file.createNewFile();
                if (name.equals("SeasonalAlert.txt")) {
                    SeasonalFileWriter(file);
                } else if (name.equals("Login.txt")) {
                    LoginFileWriter(file); }
            } catch (IOException e) {
                e.printStackTrace(); } }
        return file; }

    private void SeasonalFileWriter(File file) {
        String output = "false\n";
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); } }

    private void LoginFileWriter(File file) {
        String output = "owner,pass1234,Owner,Owner\n";
        String output1 = "accountant,pass1234,Accountant,Accountant\n";
        String output2 = "inventory,pass1234,Inventory,Manager\n";
        String output3 = "sales,pass1234,Sales,Sales\n";
        String output4 = "purchaser,pass1234,Purchaser,Purchaser\n";
        String output5 = "vendor,pass1234,Vendor,Vendor\n";
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(output); writer.write(output1); writer.write(output2);
            writer.write(output3); writer.write(output4); writer.write(output5);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); } }

    public void chooseUser(String user, String[] userArr) throws IOException, ParseException, ClassNotFoundException {
        if (user.equals("owner")) {
            seasonal();
            new Owner();
            frame.dispose();
            frame.setVisible(false);
        } else if (user.equals("vendor")) {
            new SeasonalAlert();
            frame.dispose();
            frame.setVisible(false);
        } else if (user.equals("inventory")) {
            new HomeView();
            frame.dispose();
            frame.setVisible(false);
        } else if (user.equals("purchaser")) {
            new PurchaserLogin();
            frame.dispose();
            frame.setVisible(false);
        } else if (user.equals("accountant")) {
            new AccountantHomePage();
            frame.dispose();
            frame.setVisible(false);
        } else if (user.equals("sales")) {
            new SalesHomePage();
            frame.dispose();
            frame.setVisible(false);
        } else {
            restrictedEmployee(userArr); } }

    private void restrictedEmployee(String[] userArr) throws FileNotFoundException {
        File file = openFile("Employee.txt");
        Scanner read = new Scanner(file);

        while (read.hasNext()) {
            String employee = read.nextLine();
            String[] employeeArr = employee.split(",");

            // Check to see if name equals the restricted employee name
            if ((employeeArr[2]).equalsIgnoreCase("restricted") && userArr[2].equalsIgnoreCase(employeeArr[1])) {
                JOptionPane.showMessageDialog(null, "Account is restricted from viewing information.",
                        "ERROR", JOptionPane.INFORMATION_MESSAGE);
                break; }
            // Homepage for unrestricted users
            else {
                new Unrestricted();
                frame.dispose();
                frame.setVisible(false); }
            break; } }
}


