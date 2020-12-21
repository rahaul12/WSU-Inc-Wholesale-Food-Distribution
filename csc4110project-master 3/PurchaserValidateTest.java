import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * ItemValidateTest.java
 * Purpose: TESTING - Getters & Setters
 *
 * @author Nolan Colter, go7391
 * @version 3.0 12/12/2020
 */

class PurchaserValidateTest {

    @Test
    void setItemName() {
        PurchaserValidate purchaser = new PurchaserValidate();
        purchaser.setItemName("test");
        assertTrue(purchaser.getItemName() == "test");
    }

    @Test
    void setVendorName() {
        PurchaserValidate purchaser = new PurchaserValidate();
        purchaser.setVendorName("test");
        assertTrue(purchaser.getVendorName() == "test");
    }
}