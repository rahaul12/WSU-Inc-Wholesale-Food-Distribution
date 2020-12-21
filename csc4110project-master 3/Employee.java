/**
 *
 *
 * Purpose: Setters and Getters for Employee Object.
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Class that initializes Employee information
 *
 */

//Initialize employees when added to Employee database
public class Employee implements EmployeeInterface {
    private int ID;
    private String Name;
    private String AccessLevel;

    public Employee(){}


    @Override
    public int getID() {
        return ID;
    }
    @Override
    public void setID(int ID) {
        this.ID = ID;
    }
    @Override
    public String getName() { return Name; }
    @Override
    public void setName(String name) {
        Name = name;
    }
    @Override
    public String getAccessLevel() {
        return AccessLevel;
    }
    @Override
    public void setAccessLevel(String accessLevel) {
        AccessLevel = accessLevel;
    }
}


