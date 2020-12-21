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
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

//import com.inventory.DB.SearchByExpiringDate;
//import com.inventory.DB.SearchByReceivingDate;
//import com.inventory.DB.inventoryDatabase;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/21/20
 * @version 3.0 11/22/20
 * @version 3.0 12/1/20
 * @version 3.0 12/2/20
 */
public class InventoryController {
	
	inventoryDatabase db=new inventoryDatabase();
	private ArrayList<InventoryClass> list=new ArrayList<InventoryClass>();

	public ArrayList<InventoryClass> itemsInList() throws ClassNotFoundException, IOException{
		return db.readFromFile("inventoryList.txt");
	}

	public InventoryController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<InventoryClass> outOfStockitemsInList() throws ClassNotFoundException, IOException{
		return db.search();
	}
	
	public ArrayList<InventoryClass> todayExpiringList() throws ClassNotFoundException, IOException{
		SearchByExpiringDate expire=new SearchByExpiringDate();
		LocalDate dt=LocalDate.now();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String date=dt.format(format);
		return expire.search(date);
	}
	
	public ArrayList<InventoryClass> RangeofExpireData(Date till, Date from) throws ClassNotFoundException, ParseException, IOException{
		SearchByExpiringDate expire=new SearchByExpiringDate();
		list=expire.searchRange(till, from);
		return list;
	}
	
	public ArrayList<InventoryClass> RangeofReceiveData(Date till,Date from) throws ClassNotFoundException, ParseException, IOException{
		SearchByReceivingDate expire=new SearchByReceivingDate();
		list=expire.searchRange(till, from);
		return list;
	}
	
	public ArrayList<InventoryClass> todayReceivingList() throws ClassNotFoundException, IOException{
		SearchByReceivingDate expire=new SearchByReceivingDate(); 
		LocalDate dt=LocalDate.now();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String date=dt.format(format);
		System.out.println(date);
		return expire.search(date);
	}
	
	
	
	
	
	
}
