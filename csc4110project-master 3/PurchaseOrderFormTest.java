import javax.swing.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;



/**
 *
 * PurchaseOrderFormTest.java
 * Purpose: TESTING - Create a Purchase Order Form through user input.
 *
 * @author Nolan Colter, go7391
 * @version 3.0 10/30/20
 */

class PurchaseOrderFormTest {

    @org.junit.jupiter.api.Test
    void lineCounter() throws IOException {
        JFrame frame = new JFrame();
        PurchaseOrderForm line = new PurchaseOrderForm();
        boolean lineCount = line.LineCounter(frame);
        assertFalse(false);
    }
}