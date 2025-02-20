/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This class extends MobileDeviceV8 to add file handling 
 * and menu customization functionality.
 * It implements additional actions for menu items,
 *  including new, open, save, exit, and several font customization options.
 * The code leverages a JFileChooser for file operations 
 * and methods to adjust font size, color, and style across UI components.
 * The resetValues method is used to clear all fields and reset selections.
 * 
 * Last-Update : 20/02/2568 
 */
package potjanapimol.pattaraporn.lab10;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MobileDeviceV9 extends MobileDeviceV8 {
    protected JFileChooser fileChooser;
    protected boolean isResetting = false;

    // implements ActionListener to handle button clicks
    public MobileDeviceV9(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV9 mdv9 = new MobileDeviceV9("Mobile Device V9");

        mdv9.addComponents(); // Add components like buttons and menus
        mdv9.setFrameFeature(); // Set frame properties like size, close operation, etc.
        mdv9.addListeners(); // Adds registers event listeners
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == newItem) {
            resetValues(); // Resets all input fields
            return;
        } else if (src == openItem) {
            fileChooser = new JFileChooser(); // Initializes a file chooser to open files
            int returnVal = fileChooser.showOpenDialog(this); // Opens the dialog to select a file for opening
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String msg = "Opening: " + (fileChooser.getSelectedFile().getName());
                JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                return;
            }
        } else if (src == saveItem) {
            fileChooser = new JFileChooser(); // Initializes a file chooser for saving files
            int returnVal = fileChooser.showSaveDialog(this); // Opens the dialog to select a file destination
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String msg = "Data is saved to " + (fileChooser.getSelectedFile().getName()) + " successfully!";
                JOptionPane.showMessageDialog(this, msg, "Save", JOptionPane.INFORMATION_MESSAGE);
            } else {
                return;
            }
        } else if (src == exitItem) {
            System.exit(0); // Exits the application
        } else if (src == smallSizeItem) {
            setFontSize(10); // Change the font size
        } else if (src == mediumSizeItem) {
            setFontSize(14);
        } else if (src == largeSizeItem) {
            setFontSize(18);
        } else if (src == extraLargeSizeItem) {
            setFontSize(22);
        } else if (src == blackColorItem) {
            setFontColor(java.awt.Color.BLACK); // Change the font color
        } else if (src == redColorItem) {
            setFontColor(java.awt.Color.RED);
        } else if (src == greenColorItem) {
            setFontColor(java.awt.Color.GREEN);
        } else if (src == blueColorItem) {
            setFontColor(java.awt.Color.BLUE);
        } else if (src == font1Item) {
            setFontStyle("Serif"); // Change the font style
        } else if (src == font2Item) {
            setFontStyle("SansSerif");
        } else if (src == font3Item) {
            setFontStyle("Monospaced");
        }
    }

    @Override
    protected void addListeners() {
        super.addListeners();

        JMenuItem[] menuItems = {
                newItem, openItem, saveItem, exitItem,
                smallSizeItem, mediumSizeItem, largeSizeItem, extraLargeSizeItem,
                blackColorItem, redColorItem, greenColorItem, blueColorItem,
                font1Item, font2Item, font3Item
        };

        for (JMenuItem item : menuItems) {
            item.addActionListener(this); // Registers action listeners
        }
    }

    protected void setFontSize(int size) {
        deviceTF.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, size));
        brandTF.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, size));
        priceTF.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, size));
        textFeature.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, size));
    }

    protected void setFontColor(java.awt.Color color) {
        deviceTF.setForeground(color);
        brandTF.setForeground(color);
        priceTF.setForeground(color);
        textFeature.setForeground(color);
    }

    protected void setFontStyle(String font) {
        deviceTF.setFont(new java.awt.Font(font, java.awt.Font.PLAIN, deviceTF.getFont().getSize()));
        brandTF.setFont(new java.awt.Font(font, java.awt.Font.PLAIN, brandTF.getFont().getSize()));
        priceTF.setFont(new java.awt.Font(font, java.awt.Font.PLAIN, priceTF.getFont().getSize()));
        textFeature.setFont(new java.awt.Font(font, java.awt.Font.PLAIN, textFeature.getFont().getSize()));
    }

    protected void resetValues() {
        isResetting = true; // Flag to indicate resetting is in progress
        // Clears all text fields and resets selections to default values
        deviceTF.setText("");
        brandTF.setText("");
        priceTF.setText("");
        smartphoneRB.setSelected(true);
        optionBox.setSelectedIndex(0);
        textFeature.setText("");
        vendorList.clearSelection();
        rateSlide.setValue(5);
        isResetting = false;
    }

}
