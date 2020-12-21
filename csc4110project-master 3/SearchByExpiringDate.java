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
 * @version 3.0 11/21/20
 * @version 3.0 11/24/20
 *@version 3.0 12/3/20
 *
 *
 */
//import com.inventory.jd.InventoryClass;

public class SearchByExpiringDate implements Searching{

	private ArrayList<InventoryClass> list;
	private inventoryDatabase obj=new inventoryDatabase();



	
	//That overridden method will search the item on the basis on expiring date...if any item will be expiring tommorrow it will tell us
	
	@Override
	public ArrayList<InventoryClass> search(String date) throws ClassNotFoundException, IOException {
		
		//Reading items from a file and storing them into the list
		list=obj.readFromFile("inventoryList.txt");
		
		
		//Creating list which will store expiry Items 
		ArrayList<InventoryClass>  expiryList=new ArrayList<InventoryClass>();
		for(int i=0;i<list.size();i++){

			
			//Condition to check if any item matches
			if(list.get(i).getExpiryDate().equals(date)){


				InventoryClass ob=new InventoryClass();
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
				expiryList.add(ob);
			}
		}
		
		//Returning list of items
		return expiryList;

	}
	
	
	
	//Function to search items on the basis of range 
	public ArrayList<InventoryClass> searchRange(Date from,Date till) throws ParseException, ClassNotFoundException, IOException{
		
		
		//Reading from file and storing in a list
		list=obj.readFromFile("inventoryList.txt");
		
		
		//Creating list to store items
		ArrayList<InventoryClass>  expiryList=new ArrayList<InventoryClass>();
		
		
		//Iterating list to check for items to match
		for(int i=0;i<list.size();i++) {
			InventoryClass ob=new InventoryClass();
			
			
			//Converting string into date object to perform operations
			Date listDate=new SimpleDateFormat("dd/MM/yyyy").parse(list.get(i).getExpiryDate());
			if(listDate.after(from) && listDate.before(till) || listDate.equals(till) || listDate.equals(from)) {
				ob.setItemName(list.get(i).getItemName());
				ob.setItemCode(list.get(i).getItemCode());
				ob.setVendorName(list.get(i).getVendorName());
				ob.setQuantityOfProduct(list.get(i).getQuantityOfProduct());
				ob.setReceivedDate(list.get(i).getReceivedDate());
				ob.setExpiryDate(list.get(i).getExpiryDate());
				ob.setItemCategory(list.get(i).getItemCategory());
				ob.setTaxableStatus(list.get(i).getTaxableStatus());
				ob.setNotes(list.get(i).getNotes());
				
				
				//Storing object into list
				expiryList.add(ob);
			}
		}
		
		
		//Returning list
		return expiryList;
	}

	

}
