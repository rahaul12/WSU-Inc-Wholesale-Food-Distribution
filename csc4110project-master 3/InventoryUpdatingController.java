//package com.inventory.jd;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/17/20
 *
 *
 *
 */
import java.io.IOException;
import java.util.ArrayList;



public class InventoryUpdatingController {

	inventoryDatabase db=new inventoryDatabase();
	private ArrayList<InventoryClass> list=new ArrayList<InventoryClass>();
	
	
	public void updateQuantity(String name, String code, String vendor, String quantity) throws ClassNotFoundException, IOException{
		UpdateQuantity up=new UpdateQuantity();
		up.updateItem(name, code, vendor, quantity);

		
	}
	
	public void updateExpiryDate(String name, String code, String vendor, String date) throws ClassNotFoundException, IOException{
		UpdateExpiryDate up=new UpdateExpiryDate();
		
	}
	
	public void updateReceivingDate(String name, String code, String vendor, String date) throws ClassNotFoundException, IOException{
		UpdateReceiveDate up=new UpdateReceiveDate();
		up.updateItem(name, code, vendor, date);

		
	}
	
	
	
	
	
	
	
}
