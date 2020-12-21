//package com.inventory.DB;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 12/2/20
 * @version 3.0 11/29/20
 * @version 3.0 12/1/20
 *
 */
import java.io.IOException;
import java.util.ArrayList;


public class UpdateReceiveDate implements Updating{
	
	private ArrayList<InventoryClass> list;
	private inventoryDatabase obj=new inventoryDatabase();
	
	//Function will four arguments as a parameter first three are used for searching and fourth on



			//is for updating receivingDate of item

	@Override
	public  void updateItem(String name, String code, String vendor, String expiryDate) throws ClassNotFoundException, IOException {
		
		
		//Creating list of inventoryClass
		list=new ArrayList<InventoryClass>();
		boolean flag=false;
		
		
		//Reading from file and storing it into the list
		list=obj.readFromFile("inventoryList.txt");


		if(obj.searchItem(name,code,vendor)) {

			//Iterating list to find out item
			for (int i = 0; i < list.size(); i++) {

				//Condition to find out the item
				if (list.get(i).getItemName().equalsIgnoreCase(name)
						&& list.get(i).getItemCode().equalsIgnoreCase(code)
						&& list.get(i).getVendorName().equalsIgnoreCase(vendor)) {


					//If item found override or set the new value of receivedDate and store it in list
					list.get(i).setReceivedDate(expiryDate);

					flag = true;
				}
			}

			//Write the object into the file
			obj.writeIntoFile("inventoryList.txt", list);
			System.out.print("Record is Updated Successfully");
		}else{
			System.out.print("Record is not Updated");
		}
	}

}
