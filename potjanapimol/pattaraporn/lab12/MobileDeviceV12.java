/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * MobileDeviceV12 extends MobileDeviceV11 and introduces new features such as:
 * Field validation for normal text fields (device name and brand).
 * Field validation for numeric fields (price must be a positive number).
 * Enhanced event handling (validations trigger before moving to the next field).
 * 
 * This version significantly improves input validation and user experience in a structured way.
 * By preventing invalid input and guiding the user step by step,
 * it ensures smooth data entry.
 * 
 * Last - Update: 06/03/2568
 */

package potjanapimol.pattaraporn.lab12;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.*;

import potjanapimol.pattaraporn.lab10.MobileDeviceV11;

public class MobileDeviceV12 extends MobileDeviceV11 {
    public MobileDeviceV12(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV12 mdv12 = new MobileDeviceV12("Mobile Device V12");

        mdv12.addComponents(); // Add UI components
        mdv12.setFrameFeature(); // Set JFrame properties
        mdv12.addListeners(); // Register event listeners
        mdv12.addKeys(); // Add keyboard shortcuts
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Method for handling normal text fields (like Device Name, Brand)
    public void handleNormalTextField(JTextField tf, JComponent nextComponent) {
        if (tf.getText().isEmpty()) {
            tf.requestFocusInWindow(); // Focus back to the current field
            nextComponent.setEnabled(false); // Disable next field until current one is filled
            JOptionPane.showMessageDialog(this, "Please enter some data in " + tf.getName(), "Message",
                    JOptionPane.INFORMATION_MESSAGE); // Inform the user to fill the field
        } else {
            nextComponent.requestFocusInWindow(); // Move focus to the next field
            nextComponent.setEnabled(true);
            JOptionPane.showMessageDialog(this, tf.getName() + " is changed to " + tf.getText(), "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method for handling positive number validation (like Price)
    public void handlePosNumTextField(JTextField tf, JComponent nextComponent) {
        try {
            if (tf.getText().isEmpty()) {
                tf.requestFocusInWindow();
                nextComponent.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Please enter some data in " + tf.getName(), "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                double checkPrice = Double.parseDouble(tf.getText());
                if (checkPrice < 0) { // Check if the price is negative
                    tf.requestFocusInWindow();
                    nextComponent.setEnabled(false);
                    JOptionPane.showMessageDialog(this, tf.getName() + " must be a positive number", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    tf.requestFocusInWindow();
                    nextComponent.setEnabled(true);
                    JOptionPane.showMessageDialog(this,
                            tf.getName() + " is changed to " + String.format("%.1f", checkPrice), "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Please enter a valid number in " + tf.getName(), "Message",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Assign name
    @Override
    public void addComponents() {
        super.addComponents();
        deviceTF.setName("Device Name");
        brandTF.setName("Brand");
        priceTF.setName("Price");
    }

    @Override
    public void addListeners() { // Register listeners
        super.addListeners();
        deviceTF.addActionListener(this);
        brandTF.addActionListener(this);
        priceTF.addActionListener(this);
    }

    // Handle user input and perform appropriate validation when 'Enter' is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object srcObject = e.getSource();
        if (srcObject == deviceTF) {
            handleNormalTextField(deviceTF, brandTF);
        } else if (srcObject == brandTF) {
            handleNormalTextField(brandTF, priceTF);
        } else if (srcObject == priceTF) {
            handlePosNumTextField(priceTF, smartphoneRB);
        }
    }

}
