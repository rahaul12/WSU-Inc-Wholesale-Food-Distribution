//package com.inventory.jd;
/**
 *
 *
 * Purpose: Use a login page, main page.
 *
 * @author Rahaul Das,
 * @version 3.0 11/16/20
 */
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InventoryClass {
	private String itemName;
	private String itemCode;
	private String expiryDate;
	private String quantityOfProduct;
	private String receivedDate;
	private String itemCategory;
	private String taxableStatus;
	private String notes;
	private String vendorName;


	public InventoryClass() {
		super();
	}



	//				Generating Constructor using fields

	public InventoryClass(String itemName, String itemCode, String expiryDate, String quantityOfProduct,
			String receivedDate, String itemCategory, String taxableStatus, String notes, String vendorName) {
		super();
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.expiryDate = expiryDate;
		this.quantityOfProduct = quantityOfProduct;
		this.receivedDate = receivedDate;
		this.itemCategory = itemCategory;
		this.taxableStatus = taxableStatus;
		this.notes = notes;
		this.vendorName = vendorName;
	}

	public void setItemName(String name){
		if(name.matches("[a-zA-Z]+")){
			itemName=name;
		}
	}

	public void setVendorName(String name){
		if(name.matches("[a-zA-Z]+")){
			vendorName=name;
		}
	}

	public void setItemCategory(String name){
		if(name.matches("[a-zA-Z]+")){
			itemCategory=name;
		}
	}

	public void setTaxableStatus(String name){
		if(name.matches("[a-zA-Z]+")){
			taxableStatus=name;
		}
	}

	public void setNotes(String name){
		if(name.matches("[a-zA-Z]+")){
			notes=name;
		}
	}

	public void setItemCode(String code){
		if(code.matches("[0-9]+")){
			itemCode=code;
		}
	}

	public void setQuantityOfProduct(String quan){
		if(quan.matches("[0-9]+")){
			quantityOfProduct=quan;
		}
	}

	public boolean  validateDate(String date){
		if(!date.trim().equals("")){
			return true;
		}else{
			SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
			format.setLenient(false);
			try{
				Date datePro=format.parse(date);
			}catch(ParseException ex){
				return false;
			}
			return true;
		}
	}

	public void setExpiryDate(String date){

		String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";

		if(date.matches(regex)) {
			expiryDate = date;
		}

	}

	public void setReceivedDate(String date){
		//String regex="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)";

		String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";

		if(date.matches(regex)) {
			receivedDate = date;
		}
	}

	//			Getting expiry Date
	public String getExpiryDate(){
		return expiryDate;
	}


	//			Getting Receiving Date
	public String getReceivedDate(){
		return receivedDate;
	}


	public String toString(){
		return  "	item Name :  			"+itemName+
				"\r\n	 Vendor Name : 			"+vendorName+
				"\r\n 	item Code : 			"+itemCode+
				"\r\n 	item Quantity : 		"+quantityOfProduct+
				"\r\n	 Expiry Date : 			"+expiryDate+
				"\r\n 	Receiving Date :	 	"+		receivedDate+
				"\r\n 	Tax : 					"+taxableStatus+
				"\r\n	 Notes : 				"+notes+
				"\r\n		----------------------------------------\r\n";
	}


	//		Getter for getting ItemName
	public String getItemName(){
		return itemName;
	}

	//					Getter for getting Vendor name
	public String getVendorName(){
		return vendorName;
	}


	//					Getter for getting item category
	public String getItemCategory(){
		return itemCategory;
	}


	//				Getter for getting Tax status
	public String getTaxableStatus(){
		return taxableStatus;
	}


	//				Getter for getting notes
	public String getNotes(){
		return notes;
	}



	//				Getter for getting item code
	public String getItemCode(){
		return itemCode;
	}

	//Getter for getting quantity of items
	public String getQuantityOfProduct(){
		return quantityOfProduct;
	}


}
