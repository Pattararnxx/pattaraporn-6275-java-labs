/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This class MobileDeviceV13 extends MobileDeviceV12 
 * and adds functionality to manage a list of mobile devices. 
 * The main features added are: Buttons for adding and displaying mobile devices.
 * Handling of user input for mobile device information.
 * Displaying all added mobile devices in a dialog.
 * 
 * Last - Update: 12/03/2568
 */

package potjanapimol.pattaraporn.lab12;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import potjanapimol.pattaraporn.lab7.MobileDevice;

public class MobileDeviceV13 extends MobileDeviceV12 {
    protected JButton addButton, displayButton;
    protected ArrayList<MobileDevice> mobileList;

    public MobileDeviceV13(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV13 mdv13 = new MobileDeviceV13("Mobile Device V12");

        mdv13.addComponents(); // Add UI components
        mdv13.setFrameFeature(); // Set JFrame properties
        mdv13.addListeners(); // Register event listeners
        mdv13.addKeys(); // Add keyboard shortcuts
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Add buttons and set up the layout
    @Override
    public void addComponents() {
        super.addComponents();
        addButton = new JButton("Add");
        displayButton = new JButton("Display");
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);

        // maintain a consistent UI design
        addButton.setBackground(submitButton.getBackground());
        displayButton.setBackground(submitButton.getBackground());

        // Initialize the mobile devices list
        mobileList = new ArrayList<MobileDevice>();
    }

    // Register action listeners for both buttons
    @Override
    public void addListeners() {
        super.addListeners();
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
    }

    // Handle button clicks and call appropriate methods
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == addButton) {
            handleAddButton(); // Call add button handler
        } else if (src == displayButton) {
            handleDisplayButton(); // Call display button handler
        } else {
            super.actionPerformed(e); // Call superclass action for other actions
        }
    }

    // Add mobile device to the list
    protected void handleAddButton() {
        String name = deviceTF.getText();
        String brand = brandTF.getText();
        String priceText = priceTF.getText();
        String mobileType = smartphoneRB.isSelected() ? "Smartphone" : "Tablet";

        if (name.isEmpty() || brand.isEmpty() || priceText.isEmpty()) {
            return; // Return if any field is empty
        }
        double price;
        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid price input! Please enter a valid number.");
            return;
        }

        // Add device based on selected type (Smartphone or Tablet)
        if (smartphoneRB.isSelected()) {
            mobileList.add(new SmartPhone(name, brand, price));
        } else {
            mobileList.add(new Tablet(name, brand, price));
        }
        // Show confirmation message
        String msg = mobileType + " " + name + " is added";
        JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    // Display all added devices in a dialog
    protected void handleDisplayButton() {
        if (mobileList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No mobile devices added.", "Message", JOptionPane.INFORMATION_MESSAGE);
            return; // Show message if no devices were added
        }
        StringBuffer msg = new StringBuffer();
        for (MobileDevice mobileDevice : mobileList) {
            // Append device details
            msg.append(mobileDevice.toString() + "\n");
        }

        JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

}
