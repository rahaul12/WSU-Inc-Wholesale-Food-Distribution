import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * AccountsPayableFileManager.java
 * Purpose: File is used to manage the counter and files
 *
 * @author Showrabh Dhar, ga5982
 * @version 3.0 10/29/20
 */

public class AccountsPayableFileManager {
     private static final String ACCOUNTS_PAYABLE_FILE_PATH = "AccountsPayableDB.txt";
     private static final String ACCOUNTS_PAYABLE_COUNT_FILE_PATH = "AccountsPayablesCount.txt";

     //SINGLETON Design Pattern.
     private static final AccountsPayableFileManager singletonObject = new AccountsPayableFileManager();

     private int count = 0;

     private File file = new File(ACCOUNTS_PAYABLE_FILE_PATH);
     private File countFile = new File(ACCOUNTS_PAYABLE_COUNT_FILE_PATH);

    private final ArrayList<AccountsPayable> accountsPayableList;


    //Constructor private, hence other classes can not directly instantiate.
    private AccountsPayableFileManager(){
        accountsPayableList = new ArrayList<>();
        //load the count at the beginning
        createFilesIfNotExists();
        //read count from the file and set it to count variable.
        readCount();
        //read the records and add them to the accountsPayableList
        readRecords();
    }

    //read count from the file and set it to count variable.
    private void readCount() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(countFile));
            String line = br.readLine();
            br.close();

            if(line == null){
                count = 0;
                return;
            }
            count = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AccountsPayableFileManager getInstance() {
        return singletonObject;
    }

    public void add(AccountsPayable accountsPayable) {

         accountsPayableList.add(accountsPayable);
         saveListToFile();

    }

    public void update(AccountsPayable accountsPayable) {

        for (int i = 0; i < accountsPayableList.size(); i++) {
            AccountsPayable payable = accountsPayableList.get(i);
            if(payable.getId() == accountsPayable.getId()){
                accountsPayableList.remove(i);
                break;
            }

        }
        accountsPayableList.add(accountsPayable);
         saveListToFile();
    }

    private void saveListToFile() {

        try{

            FileWriter writer = new FileWriter(file,false);
            int maxId = 0;

            for(AccountsPayable accountsPayable: accountsPayableList){
                 if(accountsPayable.getId() > maxId){
                     maxId = accountsPayable.getId();
                 }
                 String output = getString(accountsPayable);
                 writer.write(output);
             }
            writer.flush();;
            writer.close();
            //write the maximum id into the count file
            writeCount(maxId);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void writeCount(int id) {

        try{
            FileWriter writer = new FileWriter(countFile,false);
            writer.write(id + "");
            writer.flush();;
            writer.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public String getString(AccountsPayable accountsPayable) {
        String output = accountsPayable.getId() + ","
                + accountsPayable.getVendorName() + "," + accountsPayable.getPONumber() + ","
                +  accountsPayable.getBalance()  + "," + accountsPayable.getPaymentDate() + ","
                + accountsPayable.getCheckNumber()+ "," + accountsPayable.getPayment()+ ","
                +  accountsPayable.getTotalPayableAmount() + "," + accountsPayable.getTaxRate() + ","
                + accountsPayable.getTaxAmount()+ "\n";
        return output;
    }
    public static AccountsPayable createAccountsPayableFromString(String[] infoArr) {
        AccountsPayable accountsPayable = new AccountsPayable();
        accountsPayable.setId(Integer.parseInt(infoArr[0]));
        accountsPayable.setVendorName(infoArr[1]);
        accountsPayable.setPONumber(infoArr[2]);
        accountsPayable.setBalance(Double.parseDouble(infoArr[3]));
        accountsPayable.setPaymentDate(infoArr[4]);
        accountsPayable.setCheckNumber(infoArr[5]);
        accountsPayable.setPayment(Double.parseDouble(infoArr[6]));
        accountsPayable.setTotalPayableAmount(Double.parseDouble(infoArr[7]));
        accountsPayable.setTaxRate(Double.parseDouble(infoArr[8]));
        accountsPayable.setTaxAmount(Double.parseDouble(infoArr[9]));

        return accountsPayable;
    }


    //read the records and add them to the accountsPayableList
    private ArrayList<AccountsPayable> readRecords() {
        //Will create a file if it does not exists
        String line;
        BufferedReader reader;

    //Reads text file
        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                AccountsPayable accountsPayable = createAccountsPayableFromString(line.split(","));
                accountsPayableList.add(accountsPayable);
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
            e.printStackTrace();
        }
        return accountsPayableList;
    }

    private void createFilesIfNotExists(){

         if(!file.exists()){
             try {
                 file.createNewFile();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         if(!countFile.exists()){
             try {
                 countFile.createNewFile();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }

    public int getNextId() {
        count++;
        return count;
    }

    public ArrayList<AccountsPayable> getAccountsPayableList() {
        return accountsPayableList;
    }
}
