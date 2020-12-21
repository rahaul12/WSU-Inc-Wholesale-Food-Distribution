/**
 *
 *
 * Purpose: Factory Design Pattern
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * User Factory class of Factory Design Pattern.
 *
 */
public class UserFactory {

    public static UserInterface createUser(){ return new User(); }
}
