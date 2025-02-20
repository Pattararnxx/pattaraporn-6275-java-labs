/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * Extends MobileDeviceV10
 * New Features:
 * Keyboard Shortcuts (addKeys)
 * Assigns keyboard mnemonics and accelerators to menu items.
 * Displays a message when a user selects either "Smartphone" or "Tablet" radio button.
 * 
 * Last-Update : 20/02/2568
 */

package potjanapimol.pattaraporn.lab10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.*;

public class MobileDeviceV11 extends MobileDeviceV10 {
    public MobileDeviceV11(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV11 mdv11 = new MobileDeviceV11("Mobile Device V11");

        mdv11.addComponents(); // Add UI components
        mdv11.setFrameFeature(); // Set JFrame properties
        mdv11.addListeners(); // Register event listeners
        mdv11.addKeys(); // Add keyboard shortcuts
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Assigns mnemonics (alt key shortcuts) and keyboard accelerators (Ctrl+Key).
     * Used for quick access to menu items.
     */
    public void addKeys() {
        newItem.setMnemonic(KeyEvent.VK_N);
        newItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e); // Call parent event handler
        Object src = e.getSource();

        if (src == smartphoneRB) { // Smartphone radio button selected
            String msg = smartphoneRB.getText() + " is selected";
            JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if (src == tabletRB) { // Tablet radio button selected
            String msg = tabletRB.getText() + " is selected";
            JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Registers event listeners
    @Override
    public void addListeners() {
        super.addListeners();
        smartphoneRB.addActionListener(this);
        tabletRB.addActionListener(this);
    }
}
