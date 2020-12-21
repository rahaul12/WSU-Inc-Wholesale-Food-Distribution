import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 *
 * Purpose: JUnit Testing for User.java
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/13/20
 *  * Implements four JUnit Tests.
 *
 */

class UserTest {

    @Test
    void getFirstName() {
        User user = new User();
        user.setFirstName("Salsabil");
        String firstName = user.getFirstName();
        assertEquals("Salsabil",firstName);

        User user1 = new User();
        user1.setFirstName("John");
        String firstName1 = user1.getFirstName();
        assertEquals("John",firstName1);

        assertNotEquals(firstName,firstName1);
    }

    @Test
    void getLastName() {
        User user = new User();
        user.setLastName("Bakth");
        String lastName = user.getLastName();
        assertEquals("Bakth",lastName);

        User user1 = new User();
        user1.setLastName("Smith");
        String lastName1 = user1.getLastName();
        assertEquals("Smith",lastName1);

        assertNotEquals(lastName,lastName1);
    }

    @Test
    void getUsername() {
        User user = new User();
        user.setUsername("salsabil1999");
        String username = user.getUsername();
        assertEquals("salsabil1999",username);

        User user1 = new User();
        user1.setUsername("john20");
        String username1 = user1.getUsername();
        assertEquals("john20",username1);

        assertNotEquals(username1, username);
    }

    @Test
    void getPassword() {
        User user = new User();
        user.setPassword("pass1234");
        String password = user.getPassword();
        assertEquals("pass1234", password);

        User user1 = new User();
        user1.setPassword("P@ss!");
        String password1 = user1.getPassword();
        assertEquals("P@ss!", password1);

        assertNotEquals(password,password1);
    }
}