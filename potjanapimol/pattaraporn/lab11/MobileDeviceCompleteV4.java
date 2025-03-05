/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * 
 * MobileDeviceCompleteV4 class extends MobileDeviceCompleteV2
 * - Adds a custom color option in the "Config" menu.
 * - Allows the user to select and apply a custom color to the text fields .
 * 
 * Last-Update : 05/03/2568
 */

package potjanapimol.pattaraporn.lab11;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV2{

    // Custom menu item for color selection
    protected JMenuItem customColor;

    public MobileDeviceCompleteV4(String title) {
        super(title);
    }
    // Creates and shows the GUI
    public static void createAndShowGUI() {
        MobileDeviceCompleteV4 window4 = new MobileDeviceCompleteV4("Mobile Device CompleteV4");

        window4.addComponents(); // Add UI components
        window4.addMenus();
        window4.setFrameFeatures(); // Configure frame settings
        window4.addListeners(); // Register event listeners
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            public void run(){
                createAndShowGUI();
            }
        }));
    }
    @Override
    public void addMenus(){
        super.addMenus();

        // Create a new "Config" menu and a "Color" submenu with a "Custom" item
        configMenu = new JMenu("Config");
        colorMenu = new JMenu("Color");
        customColor = new JMenuItem("Custom");
        colorMenu.add(customColor);
        configMenu.add(colorMenu);
        menuBar.add(configMenu);
    }
    @Override
    public void addListeners(){
        super.addListeners();
        customColor.addActionListener(this);
    } 
    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e); // Call parent action handler
        if (e.getSource() == customColor){
            Color newColor = JColorChooser.showDialog(this, "Chooser Text Color", getForeground());
            if (newColor != null) {  // If a new color is selected
                deviceNameField.setForeground(newColor);
                brandField.setForeground(newColor);
                priceField.setForeground(newColor);
            }
        }
    }
}
