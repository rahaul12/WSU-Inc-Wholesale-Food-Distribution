import java.text.DateFormat;
import java.util.Date;

/**
 *
 * SalesValidation.java
 * Purpose: Setters, Getters
 *
 * @author Allen Paul, fw1067
 * @version 3.0 10/29/20
 */

public class SalesValidation {
    //CustomerOrderForm Variables
    String Customer;
    String ItemName;
    String OrderDate;
    int OrderQuantity;
    String NeedByDate;
    String ShippedInfo;
    String ONotes;

    //CustomerDetails Variables
    String Name;
    String ManagersName;
    String ManagersPhoneNumber;
    String CreationDate;
    String Address;
    String City;
    String State;
    int Zipcode;
    String Phone;
    String EmailId;
    int LastOrderAmount;
    String LastOrderDate;
    String LastPaymentDate;
    int BalanceAmount;
    int CreditAmount;
    String Status;
    String Notes;

    public String ReturnDate(String str) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        String date = dateFormat.format(new Date());
        return date;
    }


    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public int getOrderQuantity() {
        return OrderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        OrderQuantity = orderQuantity;
    }

    public String getNeedByDate() {
        return NeedByDate;
    }

    public void setNeedByDate(String needByDate) {
        NeedByDate = needByDate;
    }

    public String getShippedInfo() {
        return ShippedInfo;
    }

    public void setShippedInfo(String shippedInfo) {
        ShippedInfo = shippedInfo;
    }

    public String getONotes() {
        return ONotes;
    }

    public void setONotes(String ONotes) {
        this.ONotes = ONotes;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getManagersName() {
        return ManagersName;
    }

    public void setManagersName(String managersName) {
        ManagersName = managersName;
    }

    public String getManagersPhoneNumber() {
        return ManagersPhoneNumber;
    }

    public void setManagersPhoneNumber(String managersPhoneNumber) {
        ManagersPhoneNumber = managersPhoneNumber;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZipcode() {
        return Zipcode;
    }

    public void setZipcode(int zipcode) {
        Zipcode = zipcode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public int getLastOrderAmount() {
        return LastOrderAmount;
    }

    public void setLastOrderAmount(int lastOrderAmount) {
        LastOrderAmount = lastOrderAmount;
    }

    public String getLastOrderDate() {
        return LastOrderDate;
    }

    public void setLastOrderDate(String lastOrderDate) {
        LastOrderDate = lastOrderDate;
    }

    public String getLastPaymentDate() {
        return LastPaymentDate;
    }

    public void setLastPaymentDate(String lastPaymentDate) {
        LastPaymentDate = lastPaymentDate;
    }

    public int getBalanceAmount() {
        return BalanceAmount;
    }

    public void setBalanceAmount(int balanceAmount) {
        BalanceAmount = balanceAmount;
    }

    public int getCreditAmount() {
        return CreditAmount;
    }

    public void setCreditAmount(int creditAmount) {
        CreditAmount = creditAmount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}