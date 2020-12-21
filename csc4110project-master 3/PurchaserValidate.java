import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Locale;

/**
 *
 * ItemValidate.java
 * Purpose: Getters & Setters
 *
 * @author Nolan Colter, go7391
 * @version 3.0 12/11/2020
 */

public class PurchaserValidate {

    String itemName;
    String vendorName;
    Date creationDate;
    double taxableStatus;
    double itemCost;
    String itemCategory;
    Date receivedDate;
    Date expiringDate;
    Date lastOrderDate;
    double purchasedPrice;
    String unitOfMeasurement;
    int quantityOnHand;
    double sellingUnitPrice;
    String notes;

    public PurchaserValidate() {
    }

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String text) {
        this.itemName = itemName;
    }

    public String getVendorName() {
        return vendorName;
    }
    public void setVendorName(String text) {
        this.vendorName = vendorName;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(String text) {
        this.creationDate = creationDate;
    }

    public Double getTaxableStatus() {
        return taxableStatus;
    }
    public void setTaxableStatus(String text) {
        this.taxableStatus = taxableStatus;
    }

    public Double getItemCost() {
        return itemCost;
    }
    public void setItemCost(String text) {
        this.itemCost = itemCost;
    }

    public String getItemCategory() {
        return itemCategory;
    }
    public void setItemCategory(String text) {
        this.itemCategory = itemCategory;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }
    public void setReceivedDate(String text) {
        this.receivedDate = receivedDate;
    }

    public Date getExpiringDate() {
        return expiringDate;
    }
    public void setExpiringDate(String text) {
        this.expiringDate = expiringDate;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }
    public void setLastOrderDate(String text) {
        this.lastOrderDate = lastOrderDate;
    }

    public Double getPurchasedPrice() {
        return purchasedPrice;
    }
    public void setPurchasedPrice(String text) {
        this.purchasedPrice = purchasedPrice;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }
    public void setUnitOfMeasurement(String text) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }
    public void setQuantityOnHand(String text) {
        this.quantityOnHand = quantityOnHand;
    }

    public Double getSellingUnitPrice() {
        return sellingUnitPrice;
    }
    public void setSellingUnitPrice(String text) {
        this.sellingUnitPrice = sellingUnitPrice;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String text) {
        this.notes = notes;
    }
}
