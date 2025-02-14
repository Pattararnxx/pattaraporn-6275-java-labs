/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This class extends MobileDeviceV5 and applies custom colors 
 * and fonts to various components for a more visually appealing interface.
 * The use of Font and Color to style components 
 * improves the readability and aesthetic of the UI.
 * It maintains the layout and functionality of the previous versions 
 * while enhancing the appearance.
 * 
 * Last-Update : 14/02/2568
 */

package potjanapimol.pattaraporn.lab9;

import javax.swing.*;
import java.awt.*;

public class MobileDeviceV6 extends MobileDeviceV5 {
    protected Font labelFont = new Font("Arial", Font.BOLD, 14); // Defines a font for labels
    protected final Color DARK_BLUE = Color.decode("#000080");
    protected final Color LIGHT_GRAY = Color.LIGHT_GRAY;
    protected final Color LIGHT_YELLOW = Color.decode("#FFFFE0");
    protected final Color DARK_GRAY = Color.DARK_GRAY;
    protected final Color DARK_GREEN = Color.decode("#006400");

    public MobileDeviceV6(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");

        mdv6.addComponents(); // Add components like buttons and menus
        mdv6.setFrameFeature(); // Set frame properties like size, close operation, etc.
        mdv6.addMenus();
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
        JLabel[] labels = { deviceLB1, brandLB, priceLB, typeLB, operateLB, featureLB, deviceLB, rateLB };

        for (JLabel label : labels) { // Iterates through the labels to apply consistent font and color
            label.setFont(labelFont);
            label.setForeground(DARK_BLUE);
        }

        JTextField[] textFields = { deviceTF, brandTF, priceTF };
        for (JTextField textField : textFields) { // Iterates through text fields to apply background and text colors
            textField.setBackground(LIGHT_GRAY);
            textField.setForeground(DARK_GRAY);
        }

        // Customize Text Fields & Text Areas
        textFeature.setBackground(LIGHT_YELLOW);
        textFeature.setForeground(DARK_GRAY);
        textFeature.setFont(new Font("Arial", Font.ITALIC, 14));
        textFeature.setWrapStyleWord(true);
        textFeature.setLineWrap(true);

        // Customize Vendor List Appearance
        vendorList.setBackground(LIGHT_GRAY);
        vendorList.setForeground(DARK_GREEN);
        vendorList.setFont(labelFont);
        vendorList.setSelectionBackground(Color.YELLOW);
        vendorList.setSelectionForeground(Color.BLACK);

        // Customize Buttons
        resetButton.setForeground(Color.RED);
        resetButton.setBackground(Color.WHITE);
        submitButton.setForeground(Color.GREEN);
        submitButton.setBackground(Color.WHITE);
    }
}
