/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This class extends MobileDeviceV6 and adds an image display feature.
 * It introduces the ReadImage class to load and display an image of the device.
 * The addComponents method has been overridden to include 
 * this image along with the other UI components,
 * keeping the layout consistent.
 * 
 * Last-Update : 14/02/2568
 */
package potjanapimol.pattaraporn.lab9;

import javax.swing.*;
import java.awt.*;

public class MobileDeviceV7 extends MobileDeviceV6 {
    protected ReadImage devicePic;
    protected JPanel imagePanel, combinedPanel2;

    public MobileDeviceV7(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");

        mdv7.addComponents(); // Add components like buttons and menus
        mdv7.setFrameFeature(); // Set frame properties like size, close operation, etc.
        mdv7.addMenus();
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
        // Pre-Fill the Form with Samsung Galaxy S25 Ultra Data
        deviceTF.setText("Samsung Galaxy S25 Ultra");
        brandTF.setText("Samsung");
        priceTF.setText("46900");
        textFeature.setText("- 200MP Camera\n" +
                "- 1TB Storage\n" +
                "- Snapdragon Gen 4 Processor\n" +
                "- 5000mAh Battery\n" +
                "- 6.8-inch AMOLED Display\n" +
                "- 120Hz Refresh Rate\n" +
                "- 5000mAh Battery with Fast Charging");
        rateSlide.setValue(9);

        devicePic = new ReadImage("S25-ultra.jpg"); // Creates a new ReadImage object

        imagePanel = new JPanel(new BorderLayout()); // Creates a new JPanel to hold the device image
        imagePanel.setPreferredSize(new Dimension(mainPanel.getWidth(), 300)); // Sets the preferred size
        imagePanel.add(devicePic, BorderLayout.CENTER); // Adds the image

        combinedPanel2 = new JPanel(new BorderLayout());
        combinedPanel2.add(combinedPanel, BorderLayout.NORTH);
        combinedPanel2.add(imagePanel, BorderLayout.CENTER);

        mainPanel.add(combinedPanel2, BorderLayout.CENTER); // Adds the new combined panel to the main panel
    }

}
