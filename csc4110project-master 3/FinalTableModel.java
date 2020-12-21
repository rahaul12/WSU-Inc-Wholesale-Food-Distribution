//package com.inventory.presentation;

//import com.inventory.jd.InventoryClass;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/11/20
 * @version 3.0 11/16/20
 * @version 3.0 11/18/20
 */
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class FinalTableModel extends AbstractTableModel {

    private ArrayList<InventoryClass> list=new ArrayList<InventoryClass>();
    private String[] columnNames={"Item Name", "Item Code","Vendor Name",
                                    "Quantity","Receiving Date","Expiry Date",
                                    "Category","taxable status","Notes"};

    public FinalTableModel(ArrayList<InventoryClass> list){
        this.list=list;
    }


    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){

            case 0:
            case 8:
            case 7:
            case 6:
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
                return String.class;
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InventoryClass obj=list.get(rowIndex);
        switch (columnIndex){

            case 0:
                return obj.getItemName();
            case 1:
                return obj.getItemCode();
            case 2:
                return obj.getVendorName();
            case 3:
                return obj.getQuantityOfProduct();
            case 4:
                return obj.getReceivedDate();
            case 5:
                return obj.getExpiryDate();
            case 6:
                return obj.getItemCategory();
            case  7:
                return obj.getTaxableStatus();
            case 8:
                return obj.getNotes();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
