//package com.inventory.DB;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/15/20
 * @version 3.0 11/16/20
 *
 */

public class SearchByVendorName implements Searching{

	private ArrayList<InventoryClass> list;
	private inventoryDatabase obj=new inventoryDatabase();

	
	
	//This overriden method will return the lists of item which have same vendor name same vendor can be supply by different vendors 
	@Override
	public ArrayList<InventoryClass> search(String name) throws ClassNotFoundException, IOException {



		//Creating list of inventoryClass objects
		ArrayList<InventoryClass> namelist=new ArrayList<InventoryClass>();
		
		
		//Reading from the file and storing it into the list
		list=obj.readFromFile("inventoryList.txt");



		//Iterating list to check IS PASSING name MATCHES WITH CODE IN LIST
		for(int i=0;i<list.size();i++){

			
			//If it matches then  storing item into the object
			InventoryClass ob=new InventoryClass();
			if(list.get(i).getVendorName().equalsIgnoreCase(name)){     
				ob.setItemName(list.get(i).getItemName());
				ob.setItemCode(list.get(i).getItemCode());
				ob.setVendorName(list.get(i).getVendorName());
				ob.setQuantityOfProduct(list.get(i).getQuantityOfProduct());
				ob.setReceivedDate(list.get(i).getReceivedDate());
				ob.setExpiryDate(list.get(i).getExpiryDate());
				ob.setItemCategory(list.get(i).getItemCategory());
				ob.setTaxableStatus(list.get(i).getTaxableStatus());
				ob.setNotes(list.get(i).getNotes());
				
				//Storing items in a list
				namelist.add(ob);                
			}
		}

		//Returning list
		return namelist;

	}



	

}
