/**
 *
 *
 * Purpose: Factory Design Pattern
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Employee Factory class of Factory Design Pattern.
 *
 */
public class EmployeeFactory {

    public static EmployeeInterface createEmployee(){
        return new Employee();
    }
}
