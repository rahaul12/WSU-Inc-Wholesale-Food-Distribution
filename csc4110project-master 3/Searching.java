//package com.inventory.DB;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/12/20

 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

//import com.inventory.jd.InventoryClass;

/*
 * 
 * Interface following Open Closed Principle
 * and Factory Pattern
 * 
 * 
 */

public interface Searching {

	public  ArrayList<InventoryClass> search(String name) throws FileNotFoundException, ClassNotFoundException, IOException;
}
