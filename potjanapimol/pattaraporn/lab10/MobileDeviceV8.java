/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This class extends MobileDeviceV7 
 * and adds interactivity using ActionListener.
 * It includes resetButton and submitButton 
 * with corresponding event-handling logic.
 * The resetButton clears all input fields,
 *  while the submitButton displays the entered data in a message dialog.
 * 
 * Last-Update : 14/02/2568
 * 
 */

package potjanapimol.pattaraporn.lab10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import potjanapimol.pattaraporn.lab9.MobileDeviceV7;

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {
    // implements ActionListener to handle button clicks
    public MobileDeviceV8(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8");

        mdv8.addComponents(); // Add components like buttons and menus
        mdv8.setFrameFeature(); // Set frame properties like size, close operation, etc.
        mdv8.addMenus();
        mdv8.addListeners(); // Adds registers event listeners
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
        Object src = e.getSource();
        if (src == resetButton) {
            // Clears all fields when the reset button is clicked
            deviceTF.setText("");
            brandTF.setText("");
            priceTF.setText("");
            smartphoneRB.setSelected(true);
            optionBox.setSelectedItem(0);
            textFeature.setText("");
            vendorList.clearSelection();
            rateSlide.setValue(5);
        } else if (src == submitButton) {
            // Displays the entered device information in a popup dialog when the submit button is clicked
            JOptionPane.showMessageDialog(MobileDeviceV8.this, "Device Name: " + deviceTF.getText()
                    + "\nBrand: " + brandTF.getText()
                    + "\nPrice: " + priceTF.getText()
                    + "\nType: " + (smartphoneRB.isSelected() ? "Smartphone" : "Tablet")
                    + "\nOperating System: " + optionBox.getSelectedItem()
                    + "\nFeatures: " + textFeature.getText()
                    + "\nAvailable at: " + String.join(", ", vendorList.getSelectedValuesList())
                    + "\nRating: " + rateSlide.getValue(),
                    "Device Information", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    // Registers event listeners for the reset and submit buttons
    protected void addListeners() {
        resetButton.addActionListener(this);
        submitButton.addActionListener(this);
    }

}
