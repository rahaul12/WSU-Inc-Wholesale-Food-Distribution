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
 * Purpose: Vendor's homepage
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Class that will allow Vendors to set the seasonal discount alert.
 *  * Interacts with SeasonalAlert.txt and Login.java
 *
 */
// Seasonal alert GUI for Vendor
public class SeasonalAlert extends JFrame {
    JButton turnOn, turnOff, logout;
    String alert;

    public SeasonalAlert(){
        File file = openFile("SeasonalAlert.txt");

        // Save action into database
        turnOn = new JButton("Turn On Seasonal Discount Alerts");
        turnOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alert = "true\n";
                try { fileWrite(file, alert); } catch (IOException ioException) { ioException.printStackTrace(); } }
        });

        // Save action into database
        turnOff = new JButton("Turn Off Seasonal Discount Alerts");
        turnOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alert = "false\n";
                try { fileWrite(file, alert); } catch (IOException ioException) { ioException.printStackTrace(); } }
        });

        logout = new JButton("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                SeasonalAlert.this.dispose(); }
        });

        add(turnOn);
        add(turnOff);
        add(logout);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(250,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        return file; }

    private void fileWrite(File file, String alert) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        writer.write(alert);
        writer.close(); }
}
