import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
/**
 *
 *
 * Purpose: Register users.
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Class that will register new users.
 *  * Interacts with login.txt and stores information in that file.
 *
 */
// Registering new user GUI
public class Register extends JFrame {
    JLabel firstname, lastname, username, password;
    JTextField textFirstName, textLastName, textUserName, textPassword;
    JButton save, cancel;

    public Register(){
        File file = openFile("Login.txt");
        firstname = new JLabel("Enter First Name: ");
        textFirstName = new JTextField(20);
        lastname = new JLabel("Enter Last Name: ");
        textLastName = new JTextField(20);
        username = new JLabel("Enter Username: ");
        textUserName= new JTextField(20);
        password = new JLabel("Enter Password: ");
        textPassword = new JTextField(20);
        save = new JButton("Save");

        save.addActionListener(new ActionListener() {
            @Override
            // Saving details into a login database
            public void actionPerformed(ActionEvent e) {
                UserInterface user = UserFactory.createUser();
                setUser(user);
                String output = getUser(user);
                try {
                    WriteFile(output, file);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        cancel = new JButton("Back");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                Register.this.dispose();
            }
        });

        add(firstname);
        add(textFirstName);
        add(lastname);
        add(textLastName);
        add(username);
        add(textUserName);
        add(password);
        add(textPassword);
        add(save);
        add(cancel);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(350,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setUser(UserInterface user){
        user.setFirstName(textFirstName.getText());
        user.setLastName(textLastName.getText());
        user.setUsername(textUserName.getText());
        user.setPassword(textPassword.getText());
    }

    private String getUser(UserInterface user){
        String output = user.getUsername() + "," + user.getPassword() + ","
                + user.getFirstName() + "," + user.getLastName() + "\n";
        return output;
    }

    private void WriteFile(String output, File file) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        writer.write(output);
        writer.close();
    }

    public File openFile(String name) {
        File file = new File(name);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
