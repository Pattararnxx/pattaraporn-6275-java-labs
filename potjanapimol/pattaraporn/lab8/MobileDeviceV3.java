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
    protected JMenuBar menuBar;
    protected JMenu fileMenu,configMenu,sizeMenu,colorMenu,fontMenu;
    protected JMenuItem fileItem,configItem;

    public MobileDeviceV3 (String title){
        super(title);
    }
    public static void createAndShowGUI(){
        MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");
        
        mdv3.addComponents();
        mdv3.setFrameFeature();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                createAndShowGUI();
            }
        });
    }
    @Override
    protected void addComponents(){
        super.addComponents();
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        configMenu = new JMenu("Config");
        fileMenu.add(new JMenuItem("New"));
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Save"));
        fileMenu.add(new JMenuItem("Exit"));
        sizeMenu = (new JMenu("Size"));
        colorMenu = (new JMenu("Color"));
        fontMenu = (new JMenu("Font"));
        sizeMenu.add(new JMenuItem("Small"));
        sizeMenu.add(new JMenuItem("Medium"));
        sizeMenu.add(new JMenuItem("Large"));
        sizeMenu.add(new JMenuItem("Extra Large"));

        colorMenu.add(new JMenuItem("Black"));
        colorMenu.add(new JMenuItem("Red"));
        colorMenu.add(new JMenuItem("Green"));
        colorMenu.add(new JMenuItem("Blue"));

        fontMenu.add(new JMenuItem("Font 1"));
        fontMenu.add(new JMenuItem("Font 2"));
        fontMenu.add(new JMenuItem("Font 3"));

        menuBar.add(fileMenu);
        menuBar.add(configMenu);
        configMenu.add(sizeMenu);
        configMenu.add(colorMenu);
        configMenu.add(fontMenu);
        this.setJMenuBar(menuBar);
    }
}
