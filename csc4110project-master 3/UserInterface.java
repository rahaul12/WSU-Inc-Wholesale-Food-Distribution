/**
 *
 *
 * Purpose: Open Closed Principle
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Interface for Users
 *  * Implements OCP Design Pattern
 *
 */
public interface UserInterface {
    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    String getUsername();
    void setUsername(String username);

    String getPassword();
    void setPassword(String password);
}
