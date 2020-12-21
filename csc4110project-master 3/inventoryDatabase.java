//package com.inventory.DB;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/19/20
 *  @version 3.0 11/23/20
 *   @version 3.0 11/24/20
 *  @version 3.0 11/25/20
 *   @version 3.0 12/4/20
 *   @version 3.0 12/6/20
 *
 *  */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


//import com.inventory.jd.InventoryClass;

public  class inventoryDatabase  {

	private ArrayList<InventoryClass> list;

	public final int outOfStockIndicator=8;


	//			Reading From a File

	public inventoryDatabase() {
		super();
	}



	public   ArrayList<InventoryClass> readFromFile(String fileName)throws IOException, ClassNotFoundException {
		//Creating an ArrayList for storing list of objects coming from file
		list=new ArrayList<InventoryClass>();
		
		
		
		// Creating file object to tell compiler about destination file
		File file=new File(fileName);
		
		
		// Scanner is used to read data from anything here we are considering it to read file 
		Scanner scan=new Scanner(file);
	
		
		
		if(file.canRead()){

			
			// Iterating File getting fileData into the object 
			
			while(scan.hasNext()){
				InventoryClass ob=new InventoryClass();
				ob.setItemName(scan.next());
				ob.setItemCode(scan.next());
				ob.setVendorName(scan.next());
				ob.setQuantityOfProduct(scan.next());
				ob.setReceivedDate(scan.next());
				ob.setExpiryDate(scan.next());
				ob.setItemCategory(scan.next());
				ob.setTaxableStatus(scan.next());
				ob.setNotes(scan.next());
				
				//Storing these objects in a list
				list.add(ob);
			}
		}
		
		//Stop reading
		scan.close();

		
		//Returning list from function
		return list;
	}



	//					Searching Out Of Stock items

	public  ArrayList<InventoryClass> search() throws ClassNotFoundException, IOException{
		
		//Creating arrayList which will store inventory class objects
		ArrayList<InventoryClass>  outOfStocklist=new ArrayList<InventoryClass>();
		
		
		//Calling function which will read file and return the ArrayList which will store in list
		list=readFromFile("inventoryList.txt");

		for(int i=0;i<list.size();i++){
			
			
			//Getting the quantity of product
			String check=list.get(i).getQuantityOfProduct();
			
			//Converting quantity into string cox we have to perform arithmetic operations
			int indicator=Integer.parseInt(check);
			
			
			//outOfStockIndicator is a variable which will set limit of items out of stock
			if(indicator<outOfStockIndicator){
				InventoryClass ob=new InventoryClass();
				ob.setItemName(list.get(i).getItemName());
				ob.setItemCode(list.get(i).getItemCode());
				ob.setVendorName(list.get(i).getVendorName());      
				ob.setQuantityOfProduct(list.get(i).getQuantityOfProduct());
				ob.setReceivedDate(list.get(i).getReceivedDate());
				ob.setExpiryDate(list.get(i).getExpiryDate());
				ob.setItemCategory(list.get(i).getItemCategory());
				ob.setTaxableStatus(list.get(i).getTaxableStatus());
				ob.setNotes(list.get(i).getNotes());
				
				
				//Storing object into the list
				outOfStocklist.add(ob);
			}         
		}


		//Returning list from the function
		return outOfStocklist;
	}


	//Function will take 3 arguments if all three matches with the item details it will return this item

	public InventoryClass searchCompleteItem(String name,String code,String vendor) throws ClassNotFoundException, IOException {

		// Creating list to store objects from file
		list=readFromFile("inventoryList.txt");

		//Creating object to store that item
		InventoryClass ob=new InventoryClass();

		//Iterating the list if these matches the store it in inventoryClass object
		for(int i=0;i<list.size();i=i+1) {
			if(list.get(i).getItemName().equalsIgnoreCase(name)
					&& list.get(i).getItemCode().equalsIgnoreCase(code)
					&& list.get(i).getVendorName().equalsIgnoreCase(vendor)) {

				//Storing item into object

				ob.setItemName(list.get(i).getItemName());
				ob.setItemCode(list.get(i).getItemCode());
				ob.setVendorName(list.get(i).getVendorName());
				ob.setQuantityOfProduct(list.get(i).getQuantityOfProduct());
				ob.setReceivedDate(list.get(i).getReceivedDate());
				ob.setExpiryDate(list.get(i).getExpiryDate());
				ob.setItemCategory(list.get(i).getItemCategory());
				ob.setTaxableStatus(list.get(i).getTaxableStatus());
				ob.setNotes(list.get(i).getNotes());
				break;
			}

		}

		// Returning that object
		return ob;
	}

	public boolean searchItem(String name,String code,String vendor) throws ClassNotFoundException, IOException {

		// Creating list to store objects from file
		list=readFromFile("inventoryList.txt");

		boolean flag=false;
		//Iterating the list if these matches the store it in inventoryClass object
		for(int i=0;i<list.size();i=i+1) {
			if(list.get(i).getItemName().equalsIgnoreCase(name)
					&& list.get(i).getItemCode().equalsIgnoreCase(code)
					&& list.get(i).getVendorName().equalsIgnoreCase(vendor)) {

				flag=true;
				break;
			}

		}

		// Returning that object
		return flag;
	}

	
	//Function to write object into the file
	public void writeIntoFile(String fileName,ArrayList<InventoryClass> list) throws IOException {
		File file=new File(fileName);
		
		FileWriter fw=new FileWriter(file);
		PrintWriter pw=new PrintWriter(fw);
		for(int i=0;i<list.size();i++) {
			String text;
			text="\r\n"+list.get(i).getItemName()+" "+list.get(i).getItemCode()+" "+
					list.get(i).getVendorName()+" "+list.get(i).getQuantityOfProduct()+" "+
					list.get(i).getReceivedDate()+" "+list.get(i).getExpiryDate()+" "+
					list.get(i).getItemCategory()+" "+list.get(i).getTaxableStatus()+" "+
					list.get(i).getNotes();
			
			
			
			pw.write(text);
			
		}
		pw.close();

	}
	

}

