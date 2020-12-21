import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * AccountsPayableTest.java
 * Purpose: JUnit Testing
 *
 * @author Showrabh Dhar, ga5982
 * @version 3.0 10/29/20
 */

class AccountsPayableTest {

    @Test
    void getId() {
        AccountsPayable test = new AccountsPayable();
        test.setId(5);
        int num = test.getId();
        assertEquals(5,num);
    }

    @Test
    void getVendorName() {
        AccountsPayable test = new AccountsPayable();
        test.setVendorName("vendor");
        String str = test.getVendorName();
        assertEquals("vendor",str);
    }

    @Test
    void getPONumber() {
        AccountsPayable test = new AccountsPayable();
        test.setPONumber("1101AB");
        String str = test.getPONumber();
        assertEquals("1101AB",str);
    }

    @Test
    void getBalance() {
        AccountsPayable test = new AccountsPayable();
        test.setBalance(500.55);
        double num = test.getBalance();
        assertEquals(500.55,num);
    }

    @Test
    void getPaymentDate() {
        AccountsPayable test = new AccountsPayable();
        test.setPaymentDate("10/10/2020");
        String date = test.getPaymentDate();
        assertEquals("10/10/2020",date);
    }

    @Test
    void getCheckNumber() {
        AccountsPayable test = new AccountsPayable();
        test.setCheckNumber("99AB73Z");
        String str = test.getCheckNumber();
        assertEquals("99AB73Z",str);
    }

    @Test
    void getPayment() {
        AccountsPayable test = new AccountsPayable();
        test.setPayment(1592.45);
        double num = test.getPayment();
        assertEquals(1592.45,num);
    }

    @Test
    void getTotalPayableAmount() {
        AccountsPayable test = new AccountsPayable();
        test.setTotalPayableAmount(2499.74);
        double num = test.getTotalPayableAmount();
        assertEquals(2499.74,num);
    }

}