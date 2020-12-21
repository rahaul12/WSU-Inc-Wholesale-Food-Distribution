import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 *
 * Purpose: JUnit Testing for EmployeeDB.java
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/13/20
 *  * Implements four JUnit Tests.
 *
 */

class EmployeeDBTest {

    @Test
    void getInstance() {
        EmployeeDB employeeDB1 = new EmployeeDB();
        EmployeeDB employeeDB11 = employeeDB1.getInstance();
        EmployeeDB employeeDB2 = new EmployeeDB();
        EmployeeDB employeeDB22 = employeeDB2.getInstance();
        assertEquals(employeeDB22, employeeDB11);

        EmployeeDB employeeDB111 = new EmployeeDB();
        EmployeeDB employeeDB1111 = employeeDB111.getInstance();
        EmployeeDB employeeDB222 = new EmployeeDB();
        EmployeeDB employeeDB2222 = employeeDB222.getInstance();
        assertEquals(employeeDB2222,employeeDB1111);

        assertNotEquals(employeeDB11,employeeDB1111);
    }

    @Test
    void getNextId() {
        EmployeeDB employeeDB = new EmployeeDB();
        int countID = employeeDB.getNextId();
        assertEquals(6, countID);
        assertNotEquals(110, countID);
        assertNotEquals(-11,countID);
    }

    @Test
    void getEmployeeCount() {
        EmployeeDB employeeDB = new EmployeeDB();
        int count = employeeDB.getEmployeeCount();
        assertEquals(5, count);
        assertNotEquals(0, count);
        assertNotEquals(-60, count);
    }

    @Test
    void openFile() {
        EmployeeDB employeeDB = new EmployeeDB();
        File file = employeeDB.openFile("Employee.txt");
        File file1 = new File("Employee.txt");
        assertEquals(file1, file);

        EmployeeDB employeeDB1 = new EmployeeDB();
        File file2 = employeeDB1.openFile("Login.txt");
        File file22 = new File("Login.txt");
        assertEquals(file2, file22);

        assertNotEquals(file,file2);
    }
}