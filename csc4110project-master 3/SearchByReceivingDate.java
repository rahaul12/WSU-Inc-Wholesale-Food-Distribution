//package com.inventory.DB;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/29/20
 * @version 3.0 12/1/20
 *
 */

//

public class SearchByReceivingDate implements Searching{
	
	private ArrayList<InventoryClass> list;
	private inventoryDatabase obj=new inventoryDatabase();

	
	
	//That overridden method will search the item on the basis on receiving date...if any item will be received today it will tell us
	
	@Override
	public ArrayList<InventoryClass> search(String date) throws ClassNotFoundException, IOException {
		
		//Reading items from a file and storing them into the list
		list=obj.readFromFile("inventoryList.txt");

		//Creating list which will store received Items 
		ArrayList<InventoryClass>  recList=new ArrayList<InventoryClass>();
		

		for(int i=0;i<list.size();i++){
			InventoryClass ob=new InventoryClass();
			
			//Condition to check if any item matches
			if(list.get(i).getReceivedDate().equals(date)){ 
				
				
				//Storing matching item into the object
				ob.setItemName(list.get(i).getItemName());
				ob.setItemCode(list.get(i).getItemCode());
				ob.setVendorName(list.get(i).getVendorName());
				ob.setQuantityOfProduct(list.get(i).getQuantityOfProduct());
				ob.setReceivedDate(list.get(i).getReceivedDate());
				ob.setExpiryDate(list.get(i).getExpiryDate());
				ob.setItemCategory(list.get(i).getItemCategory());
				ob.setTaxableStatus(list.get(i).getTaxableStatus());
				ob.setNotes(list.get(i).getNotes());
				
				
				//Storing these objects into the list
				recList.add(ob);
			}
		}
		
		//Returning list of items
		return recList;

	}
	
	public ArrayList<InventoryClass> searchRange(Date from,Date till) throws ParseException, ClassNotFoundException, IOException{
		list=obj.readFromFile("inventoryList.txt");
		ArrayList<InventoryClass>  recList=new ArrayList<InventoryClass>();
		for(int i=0;i<list.size();i++) {
			InventoryClass ob=new InventoryClass();
			Date listDate=new SimpleDateFormat("dd/MM/yyyy").parse(list.get(i).getReceivedDate());
			if(listDate.after(from) && listDate.before(till) || listDate.equals(till)) {
				ob.setItemName(list.get(i).getItemName());
				ob.setItemCode(list.get(i).getItemCode());
				ob.setVendorName(list.get(i).getVendorName());
				ob.setQuantityOfProduct(list.get(i).getQuantityOfProduct());
				ob.setReceivedDate(list.get(i).getReceivedDate());
				ob.setExpiryDate(list.get(i).getExpiryDate());
				ob.setItemCategory(list.get(i).getItemCategory());
				ob.setTaxableStatus(list.get(i).getTaxableStatus());
				ob.setNotes(list.get(i).getNotes());
				recList.add(ob);
			}
		}
		return recList;
	}

}
