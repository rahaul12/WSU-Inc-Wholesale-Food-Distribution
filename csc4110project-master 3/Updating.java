//package com.inventory.DB;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/30/20
 *  * Interface to update many items using single function
 *  * following open closed principle and
 *  * Factory pattern
 *
 */
import java.io.IOException;



public interface Updating {

	public void updateItem(String name,String code,String vendor,String quantity) throws ClassNotFoundException, IOException;
}
