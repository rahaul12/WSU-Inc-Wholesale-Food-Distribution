import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * SalesValidationTest.java
 * Purpose: Junit Test
 *
 * @author Allen Paul, fw1067
 * @version 3.0 10/29/20
 */
class SalesValidationTest {

    @Test
    void getCustomer() {
        SalesValidation test = new SalesValidation();
        test.setCustomer("bob");
        String str = test.getCustomer();
        assertEquals("bob",str);

    }

    @org.junit.jupiter.api.Test
    void getItemName() {
        SalesValidation test = new SalesValidation();
        test.setItemName("Carrots");
        String str = test.getItemName();
        assertEquals("Carrots",str);
    }

    @org.junit.jupiter.api.Test
    void getOrderDate() {
        SalesValidation test = new SalesValidation();
        test.setOrderDate("10/12/2020");
        String str = test.getOrderDate();
        assertEquals("10/12/2020",str);
    }

    @org.junit.jupiter.api.Test
    void getOrderQuantity() {
        SalesValidation test = new SalesValidation();
        test.setOrderQuantity(23);
        int num = test.getOrderQuantity();
        assertEquals(23,num);
    }

    @org.junit.jupiter.api.Test
    void getNeedByDate() {
        SalesValidation test = new SalesValidation();
        test.setCustomer("bob");
        String str = test.getCustomer();
        assertEquals("bob",str);
    }

    @org.junit.jupiter.api.Test
    void getShippedInfo() {
        SalesValidation test = new SalesValidation();
        test.setShippedInfo("UPS");
        String str = test.getShippedInfo();
        assertEquals("UPS",str);
    }

    @org.junit.jupiter.api.Test
    void getName() {
        SalesValidation test = new SalesValidation();
        test.setName("Joe");
        String str = test.getName();
        assertEquals("Joe",str);
    }

    @org.junit.jupiter.api.Test
    void getAddress() {
        SalesValidation test = new SalesValidation();
        test.setAddress("2020 Cherrylane");
        String str = test.getAddress();
        assertEquals("2020 Cherrylane",str);
    }
}