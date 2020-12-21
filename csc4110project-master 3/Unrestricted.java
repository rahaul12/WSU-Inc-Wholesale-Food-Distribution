import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.*;
/**
 *
 *
 * Purpose: Regular users homepage.
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Class that will display regular users homepage.
 *  * Interacts with login.java
 *
 */
// Unrestricted user GUI
public class Unrestricted extends JFrame {
    JLabel header;
    JButton logout;
    public Unrestricted(){
        header = new JLabel("Welcome to WSU Inc. Wholesale Food Distribution");
        logout = new JButton("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                Unrestricted.this.dispose();

            }
        });
        add(header);
        add(logout);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(350,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
