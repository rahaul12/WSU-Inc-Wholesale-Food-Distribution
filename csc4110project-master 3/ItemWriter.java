import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 *
 * ItemWriter.java
 * Purpose: Write to Item Detials text file from user input.
 *
 * @author Nolan Colter, go7391
 * @version 2.0 10/29/20
 */

public class ItemWriter {

    JTextField itemName, vendorName, creationDate, taxableStatus, itemCost, itemCategory, receivedDate, expiringDate, lastOrderDate,
            purchasedPrice, unitOfMeasurement, quantityOnHand, sellingUnitPrice, notes;

    public ItemWriter() {

        File file = new File("itemDetails.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JFrame frame = new JFrame("Item Details");
        JButton submit = new JButton("Submit");
        JButton backButton = new JButton("Back");
        JButton view = new JButton("View Item Details");
        JPanel panel = new JPanel();

        JLabel itemNameLabel = new JLabel("Item Name: ");
        itemName = new JTextField();
        JLabel vendorLabel = new JLabel("Vendor Name: ");
        vendorName = new JTextField();
        JLabel creationLabel = new JLabel("Creation Date: ");
        creationDate = new JTextField();
        JLabel taxableLabel = new JLabel("Taxable Status: ");
        taxableStatus = new JTextField();
        JLabel itemCostLabel = new JLabel("Item Cost: ");
        itemCost = new JTextField();
        JLabel itemCategoryLabel = new JLabel("Item Category: ");
        itemCategory = new JTextField();
        JLabel receivedDateLabel = new JLabel("Received Date: ");
        receivedDate = new JTextField();
        JLabel expiringDateLabel = new JLabel("Expiring Date: ");
        expiringDate = new JTextField();
        JLabel lastOrderDateLabel = new JLabel("Last Order Date: ");
        lastOrderDate = new JTextField();
        JLabel purchasedPriceLabel = new JLabel("Purchased Price: ");
        purchasedPrice = new JTextField();
        JLabel unitOfMeasurementLabel = new JLabel("Unit of Measurement: ");
        unitOfMeasurement = new JTextField();
        JLabel quantityOnHandLabel = new JLabel("Quantity on Hand: ");
        quantityOnHand = new JTextField();
        JLabel sellingUnitPriceLabel = new JLabel("Selling Unit Price: ");
        sellingUnitPrice = new JTextField();
        JLabel notesLabel = new JLabel("Notes: ");
        notes = new JTextField();

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout(0,1));

        panel.add(itemNameLabel);
        panel.add(itemName);
        panel.add(vendorLabel);
        panel.add(vendorName);
        panel.add(creationLabel);
        panel.add(creationDate);
        panel.add(taxableLabel);
        panel.add(taxableStatus);
        panel.add(itemCostLabel);
        panel.add(itemCost);
        panel.add(itemCategoryLabel);
        panel.add(itemCategory);
        panel.add(receivedDateLabel);
        panel.add(receivedDate);
        panel.add(expiringDateLabel);
        panel.add(expiringDate);
        panel.add(lastOrderDateLabel);
        panel.add(lastOrderDate);
        panel.add(purchasedPriceLabel);
        panel.add(purchasedPrice);
        panel.add(unitOfMeasurementLabel);
        panel.add(unitOfMeasurement);
        panel.add(quantityOnHandLabel);
        panel.add(quantityOnHand);
        panel.add(sellingUnitPriceLabel);
        panel.add(sellingUnitPrice);
        panel.add(notesLabel);
        panel.add(notes);

        panel.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PurchaserValidate validate = new PurchaserValidate();
                validate.setItemName(itemName.getText());
                validate.setVendorName(vendorName.getText());
                validate.setCreationDate(creationDate.getText());
                validate.setTaxableStatus(taxableStatus.getText());
                validate.setItemCost(itemCost.getText());
                validate.setItemCategory(itemCategory.getText());
                validate.setReceivedDate(receivedDate.getText());
                validate.setExpiringDate(expiringDate.getText());
                validate.setLastOrderDate(lastOrderDate.getText());
                validate.setPurchasedPrice(purchasedPrice.getText());
                validate.setUnitOfMeasurement(unitOfMeasurement.getText());
                validate.setQuantityOnHand(quantityOnHand.getText());
                validate.setSellingUnitPrice(sellingUnitPrice.getText());
                validate.setNotes(notes.getText());


                String text = itemName.getText() + ", " + vendorName.getText() + ", " +
                        creationDate.getText() + ", " + taxableStatus.getText() + ", " + "$" +
                        itemCost.getText() + ", " + itemCategory.getText() + ", " +
                        receivedDate.getText() + ", " + expiringDate.getText() + ", " +
                        lastOrderDate.getText() + ", " + "$" + purchasedPrice.getText() + ", " +
                        unitOfMeasurement.getText() + ", " + quantityOnHand.getText() + ", " + "$" +
                        sellingUnitPrice.getText() + ", " + notes.getText() + System.lineSeparator();
                System.out.println("Submitted");

                ItemWriter limitFile = new ItemWriter();
                try {
                    if (limitFile.LineCounter(frame)) {
                        try{
                            FileWriter writer = new FileWriter(file, true);
                            writer.write(text);
                            writer.close();
                            System.out.println("Submitted into Text File");
                        } catch (IOException ex){
                            ex.printStackTrace();
                        }
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                frame.dispose();
            }
        });

        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PurchaserLogin view = new PurchaserLogin();
                frame.setVisible(false);
            }
        });

        panel.add(view);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewItem viewItem = new ViewItem();
                viewItem.view(true);
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private boolean LineCounter(JFrame frame) throws IOException {
        boolean b = true;
        BufferedReader reader = new BufferedReader(new FileReader("itemDetails.txt"));
        int lineCount = 0;
        while (reader.readLine() != null)
            lineCount++;
        if (lineCount + 1 > 50) {
            JOptionPane.showMessageDialog(frame, "Item Limit Has Been Reached",
                    "Item Limit", JOptionPane.WARNING_MESSAGE);
            b = false;
        }
        reader.close();
        return b;
    }
}
