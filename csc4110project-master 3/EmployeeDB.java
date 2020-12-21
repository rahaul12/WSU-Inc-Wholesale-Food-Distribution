import java.io.*;
/**
 *
 *
 * Purpose: Singleton
 *
 * @author Salsabil Bakth,
 * @version 3.0 12/12/20
 *  * Implements Singleton Design Pattern
 *
 */
public class EmployeeDB {

    //Singleton object for the Singleton DESIGN PATTERN.
    private static final EmployeeDB employeeDB = new EmployeeDB();
    private File countFile;
    private File employeeFile;


    EmployeeDB() {
        employeeFile = openFile("Employee.txt");
        countFile = openFile("Employee-count.txt");
    }

    //Returns the Singleton instance.
    public static EmployeeDB getInstance() {
        return employeeDB;
    }


    public void incrementEmployeeCount(int count) {
        writeToFile(countFile, count + "", false);
    }


    public int getNextId() {
        return getEmployeeCount() + 1;
    }

    public int getEmployeeCount() {
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(countFile));
            String line = br.readLine();
            br.close();

            if (line != null) {
                count = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public File openFile(String name) {
        File file = new File(name);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }


    public void writeToFile(File file, String output, boolean append) {
        try {
            FileWriter writer = new FileWriter(file, append);
            writer.write(output);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeEmployee(String output) {
        writeToFile(employeeFile, output, true);
    }
}
