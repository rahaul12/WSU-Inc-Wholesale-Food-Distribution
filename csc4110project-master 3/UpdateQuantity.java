//package com.inventory.DB;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/24/20
 * @version 3.0 11/26/20
 * @version 3.0 12/4/20
 * @version 3.0 12/5/20
 *
 */
import java.io.IOException;
import java.util.ArrayList;
//
//import com.inventory.jd.InventoryClass;

public class UpdateQuantity implements Updating{

	private ArrayList<InventoryClass> list;
	private inventoryDatabase obj=new inventoryDatabase();
	
	
	
	//Function will four arguments as a parameter first three are used for searching and fourth on
		//is for updating quantity of item
	@Override
	public  void updateItem(String name, String code, String vendor, String quantity) throws ClassNotFoundException, IOException {
		
		//Creating list of inventoryClass
		list=new ArrayList<InventoryClass>();
		
		//Reading from file and storing it into the list
		boolean flag=false;
		list=obj.readFromFile("inventoryList.txt");
		
		if(obj.searchItem(name,code,vendor)==true) {
			//Iterating list to find out item
			for (int i = 0; i < list.size(); i++) {
				//Condition to find out the item
				if (list.get(i).getItemName().equalsIgnoreCase(name)
						&& list.get(i).getItemCode().equalsIgnoreCase(code)
						&& list.get(i).getVendorName().equalsIgnoreCase(vendor)) {

					//If item found override or set the new value of quantity and store it in list
					list.get(i).setQuantityOfProduct(quantity);
					flag = true;

				}
			}

			//Write the object into the file
			obj.writeIntoFile("inventoryList.txt", list);

		}else{

			System.out.println("Record is not updated Coz item is not in the list  \r\n5");
		}
		

		



	}
	
	

}
