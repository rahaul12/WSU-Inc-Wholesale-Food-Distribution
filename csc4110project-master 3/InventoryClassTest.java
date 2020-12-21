import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 12/13/20
 *
 *
 */
class InventoryClassTest {

    @Test
    void getExpiryDate() {
        InventoryClass j = new InventoryClass();
        j.setExpiryDate("12/12/2020");
        String date = j.getExpiryDate();


        assertEquals("12/12/2020",date);

    }

    @Test
    void getItemName() {
        InventoryClass j = new InventoryClass();
        j.setItemName("pencil");
        String name = j.getItemName();

        assertEquals("pencil",name);


    }

    @Test
    void getNotes() {
        InventoryClass j = new InventoryClass();
        j.setItemName("wood");
        String name = j.getNotes();

        assertEquals(null,name);




    }

    @Test
    void getItemCode() {
        InventoryClass j = new InventoryClass();
        j.setItemName("project");
        String name = j.getItemCode();

        assertEquals(null,name);
    }
}