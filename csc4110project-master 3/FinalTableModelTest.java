import org.junit.jupiter.api.Test;

import java.io.IOException;

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
class FinalTableModelTest {

    @Test
    void getRowCount() throws IOException, ClassNotFoundException {
        InventoryController inventory = new InventoryController();
        FinalTableModel j = new FinalTableModel(inventory.todayExpiringList());
        int rowCount = j.getRowCount();

        InventoryController inventory1 = new InventoryController();
        FinalTableModel table = new FinalTableModel(inventory1.todayExpiringList());
        int rowCount1 = table.getRowCount();
        assertEquals(rowCount,rowCount1);

    }

    @Test
    void getColumnCount() throws IOException, ClassNotFoundException {
        InventoryController inventory = new InventoryController();
        FinalTableModel j = new FinalTableModel(inventory.todayExpiringList());
        int count = j.getColumnCount();
        assertEquals(9,count);

    }



    @Test
    void getValueAt() throws IOException, ClassNotFoundException {
        InventoryController inventory = new InventoryController();
        FinalTableModel j = new FinalTableModel(inventory.todayExpiringList());
        Object value = j.getValueAt(0,1);
        InventoryController inventory1 = new InventoryController();
        FinalTableModel j1 = new FinalTableModel(inventory1.todayExpiringList());
        Object value1 = j1.getValueAt(0,1);
        assertEquals(value,value1);
    }

    @Test
    void getColumnName() throws IOException, ClassNotFoundException {
        InventoryController inventory = new InventoryController();
        FinalTableModel j = new FinalTableModel(inventory.todayExpiringList());
        String count = j.getColumnName(0);
        assertEquals("Item Name",count);
    }
}