/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * Extends MobileDeviceV9
 * Implements:
 * ListSelectionListener for vendor list selection.
 * ChangeListener for rating slider adjustments.
 * New Features:
 * Shows a message when the user selects an operating system.
 * Displays selected vendors when a selection is finalized.
 * Shows a new rating when the rating slider is adjusted.
 * 
 * Last-Update : 20/02/2568
 */

package potjanapimol.pattaraporn.lab10;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;

public class MobileDeviceV10 extends MobileDeviceV9 implements ListSelectionListener, ChangeListener {
    // Extends MobileDeviceV9 and implements ListSelectionListener & ChangeListener
    public MobileDeviceV10(String title) {
        super(title);
    }

    // Creates and shows the GUI
    public static void createAndShowGUI() {
        MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile Device V10");

        mdv10.addComponents(); // Add UI components
        mdv10.setFrameFeature(); // Configure frame settings
        mdv10.addListeners(); // Register event listeners
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
        if (isResetting)
            return; // Ignore events while resetting values
        super.actionPerformed(e); // Process common actions from parent class

        Object src = e.getSource();
        // Handle operating system selection change from combo box
        if (src == optionBox) {
            String selectedOS = (String) optionBox.getSelectedItem();
            String msg = "You selected Operating System: " + selectedOS;
            JOptionPane.showMessageDialog(this, msg, "OS Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (isResetting)
            return; // Ignore events during reset
        if (e.getSource() == vendorList && !e.getValueIsAdjusting()) {
            // When vendor list selection is finalized, display selected vendors
            java.util.List<?> vendors = vendorList.getSelectedValuesList();
            String msg = "Device is available at: ";
            for (Object vendor : vendors) {
                msg += vendor + " ";
            }
            JOptionPane.showMessageDialog(this, msg, "Vendor Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void stateChanged(ChangeEvent e) {
        if (isResetting)
            return; // Ignore changes during reset
        if (e.getSource() == rateSlide && !rateSlide.getValueIsAdjusting()) {
            // When slider adjustment is complete, display the new rating
            String msg = "New rating: " + rateSlide.getValue();
            JOptionPane.showMessageDialog(this, msg, "Rating Adjustment", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Registers event listeners for dropdown (OS), vendor list, and rating slider.
    @Override
    protected void addListeners() {
        super.addListeners();
        optionBox.addActionListener(this);
        vendorList.addListSelectionListener(this);
        rateSlide.addChangeListener(this);
    }
}
