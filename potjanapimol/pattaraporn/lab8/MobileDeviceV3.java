/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This class extends MobileDeviceV2,
 * adding a menu bar with multiple menus and submenus.
 * Properly overrides addComponents() to 
 * include the new JMenuBar while 
 * keeping inherited components.
 * Uses a structured approach 
 * to organize menus, submenus, and menu items.
 * 
 * Last-Update : 04/02/2568
 */

package potjanapimol.pattaraporn.lab8;

import javax.swing.*;

public class MobileDeviceV3 extends MobileDeviceV2 {
    // Declare the JMenuBar and JMenu objects for menu and submenus
    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu, sizeMenu, colorMenu, fontMenu;

    // Declare JMenuItem objects for each menu item
    protected JMenuItem newItem, openItem, saveItem, exitItem;

    // Constructor that passes title to the superclass
    public MobileDeviceV3(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");

        mdv3.addComponents(); // Add components like buttons and menus
        mdv3.setFrameFeature(); // Set frame properties like size, close operation, etc.
    }

    // Main method to invoke the createAndShowGUI method in the Event Dispatch
    // Thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Override addComponents to add the menu bar to the existing layout
    @Override
    protected void addComponents() {
        super.addComponents(); // Call the superclass method to retain existing components
        addMenus(); // Add the menu bar and menus
        this.setJMenuBar(menuBar); // Set the created menu bar to the frame
    }

    // Method to create the menu bar and add menus/submenus
    protected void addMenus() {
        menuBar = new JMenuBar(); // Create a new menu bar

        // Create and add File menu with items
        fileMenu = new JMenu("File");
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        // Create and add Config menu with submenus (Size, Color, Font)
        configMenu = new JMenu("Config");

        sizeMenu = new JMenu("Size");
        sizeMenu.add(new JMenuItem("Small"));
        sizeMenu.add(new JMenuItem("Medium"));
        sizeMenu.add(new JMenuItem("Large"));
        sizeMenu.add(new JMenuItem("Extra Large"));

        colorMenu = new JMenu("Color");
        colorMenu.add(new JMenuItem("Black"));
        colorMenu.add(new JMenuItem("Red"));
        colorMenu.add(new JMenuItem("Green"));
        colorMenu.add(new JMenuItem("Blue"));

        fontMenu = new JMenu("Font");
        fontMenu.add(new JMenuItem("Font 1"));
        fontMenu.add(new JMenuItem("Font 2"));
        fontMenu.add(new JMenuItem("Font 3"));

        // Add submenus to the Config menu
        configMenu.add(sizeMenu);
        configMenu.add(colorMenu);
        configMenu.add(fontMenu);

        // Add File and Config menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(configMenu);
    }
}
