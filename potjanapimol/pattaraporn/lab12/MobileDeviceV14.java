/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * 
 * This class extends MobileDeviceV13 and adds file handling capabilities 
 * for saving and loading mobile device data. 
 * It uses Swing for UI components and event handling, 
 * allowing users to open and save mobile device data from files.
 * 
 * Last - Update : 13/03/2568
 */

package potjanapimol.pattaraporn.lab12;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import potjanapimol.pattaraporn.lab7.MobileDevice;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MobileDeviceV14 extends MobileDeviceV13 {
    protected StringBuffer newData;

    public MobileDeviceV14(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV14 mdv14 = new MobileDeviceV14("Mobile Device V14");

        mdv14.addComponents(); // Add UI components
        mdv14.setFrameFeature(); // Set JFrame properties
        mdv14.addListeners(); // Register event listeners
        mdv14.addKeys(); // Add keyboard shortcuts
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Handles button actions (open and save menu options)
    public void actionPerformed(ActionEvent event) {
        Object srcObj = event.getSource();
        if (srcObj == openItem) { // If 'Open' is clicked
            handleMenuOpen();
        } else if (srcObj == saveItem) { // If 'Save' is clicked
            handleMenuSave();
        } else { // Calls parent class action handler
            super.actionPerformed(event);
        }
    }

     // Handles file saving
    public void handleMenuSave() {
        fileChooser = new JFileChooser();
        int selected = fileChooser.showSaveDialog(this);
        if (selected == JFileChooser.APPROVE_OPTION) {
            File saveFile = fileChooser.getSelectedFile();

            try (PrintWriter writer = new PrintWriter(new FileWriter(saveFile))) {
                for (MobileDevice device : mobileList) {
                    writer.println(device); // Saves device details to file
                }
                writer.close(); // Explicit close (not needed with try-with-resources)
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(this, "Please provide a filename", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "File not found", "Message", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error writing to file", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Handles file opening
    public void handleMenuOpen() {
        fileChooser = new JFileChooser();
        int selected = fileChooser.showOpenDialog(this);
        if (selected == JFileChooser.APPROVE_OPTION) {
            if (ReadFile(fileChooser.getSelectedFile())) {  // Reads file content
                String msg = "Opening: " + fileChooser.getSelectedFile().getAbsolutePath();
                JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
                StringBuffer msg1 = new StringBuffer();
                msg1.append("Read devices from the file " + fileChooser.getSelectedFile().getAbsolutePath()
                        + " are as follows:" + "\n");
                msg1.append(newData);
                JOptionPane.showMessageDialog(this, msg1.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

     // Reads data from a file and parses mobile device details
    public boolean ReadFile(File file) {
        try {
            newData = new StringBuffer(); // Resets newData before reading
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(":");
                int brandStartIndex = data[1].indexOf('(');
                int brandEndIndex = data[1].indexOf(')');
                // Extracts name, brand, and price from file format
                String name = data[1].substring(1, brandStartIndex - 1);
                String brand = data[1].substring(brandStartIndex + 1, brandEndIndex);
                String price = data[1].substring(brandEndIndex + 2, data[1].length() - 5);
                double pricenum = Double.parseDouble(price);
                 // Determines if the device is a SmartPhone or Tablet and adds it to the list
                if (data[0].equalsIgnoreCase("SmartPhone")) {
                    mobileList.add(new SmartPhone(name, brand, pricenum));
                } else {
                    mobileList.add(new Tablet(name, brand, pricenum));
                }
                newData.append(mobileList.getLast().toString() + "\n");  // Appends the last added device
            }
            bufferedReader.close();
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please provide a filename", "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found", "Message", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading to file", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

}
