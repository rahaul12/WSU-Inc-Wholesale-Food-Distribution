/**
 *
 *
 * Purpose: Getters and setters for Users.
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Class that will initialize users when registering.
 *
 */
public class User implements UserInterface{
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public User(){}

    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
