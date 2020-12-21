/**
 *
 *
 * Purpose: Open Closed Principle
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Interface for Employee
 *  * Implements OCP Design Pattern
 *
 */
public interface EmployeeInterface {
    int getID();

    void setID(int ID);

    String getName();

    void setName(String name);

    String getAccessLevel();

    void setAccessLevel(String accessLevel);
}
