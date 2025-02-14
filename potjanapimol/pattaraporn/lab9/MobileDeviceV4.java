/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This class extends MobileDeviceV3 by adding icons to menu items 
 * and customizing fonts and colorsอ
 * Inherits all features from MobileDeviceV3.
 * Adds icons to New, Open, Save, and Exit menu items.
 * Changes text size for different size options
 * Changes text color for different color options
 * Uses different fonts for the font selection menu
 * 
 * Last-Update : 14/02/2568
 */

package potjanapimol.pattaraporn.lab9;

import javax.swing.*;
import java.awt.*;

import potjanapimol.pattaraporn.lab8.MobileDeviceV3;

public class MobileDeviceV4 extends MobileDeviceV3 {
    public MobileDeviceV4(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");

        mdv4.addComponents(); // Add components like buttons and menus
        mdv4.setFrameFeature(); // Set frame properties like size, close operation, etc.
        mdv4.addMenus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    protected void addComponents() {
        super.addComponents();
    }

    // Add menu items with icons and font settings
    @Override
    protected void addMenus() {
        super.addMenus();
        // Set icons
        newItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images\\new_icon.png")));
        openItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images\\open_icon.png")));
        saveItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images\\save_icon.png")));
        exitItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images\\exit_icon.png")));

        // Set sizes
        smallSizeItem.setFont(new Font("Arial", Font.PLAIN, 10));
        mediumSizeItem.setFont(new Font("Arial", Font.PLAIN, 14));
        largeSizeItem.setFont(new Font("Arial", Font.PLAIN, 18));
        extraLargeSizeItem.setFont(new Font("Arial", Font.PLAIN, 22));

        // Set colors
        blackColorItem.setForeground(Color.BLACK);
        redColorItem.setForeground(Color.RED);
        greenColorItem.setForeground(Color.GREEN);
        blueColorItem.setForeground(Color.BLUE);

        // Set fonts
        font1Item.setFont(new Font("Serif", Font.PLAIN, 14));
        font2Item.setFont(new Font("SansSerif", Font.PLAIN, 14));
        font3Item.setFont(new Font("Monospaced", Font.PLAIN, 14));
    }
}
