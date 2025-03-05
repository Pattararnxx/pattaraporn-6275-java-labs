/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * 
 * MobileDeviceCompleteV2 extends MobileDeviceComplete 
 * and adds action listeners to text fields
 * to display notifications when the user presses Enter.
 * 
 * Last-Update : 05/03/2568
 */
package potjanapimol.pattaraporn.lab11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener {
    public MobileDeviceCompleteV2(String title) {
        super(title);
    }

    // Creates and shows the GUI
    public static void createAndShowGUI() {
        MobileDeviceCompleteV2 window2 = new MobileDeviceCompleteV2("Mobile Device CompleteV2");

        window2.addComponents(); // Add UI components
        window2.addMenus();
        window2.setFrameFeatures(); // Configure frame settings
        window2.addListeners(); // Register event listeners
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        }));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deviceNameField) {
            String msg = "You pressed Enter in Device Name field: " + deviceNameField.getText();
            JOptionPane.showMessageDialog(this, msg, "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == brandField) {
            String msg = "Brand field says: " + brandField.getText();
            JOptionPane.showMessageDialog(this, msg, "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == priceField) {
            String msg = "Price entered: " + priceField.getText();
            JOptionPane.showMessageDialog(this, msg, "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void addListeners() {
        deviceNameField.addActionListener(this);
        brandField.addActionListener(this);
        priceField.addActionListener(this);
    }
}
