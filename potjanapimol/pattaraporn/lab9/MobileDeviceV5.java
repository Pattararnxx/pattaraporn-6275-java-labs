/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This class extends MobileDeviceV4 and 
 * adds a list of vendors and a slider for rating the device.
 * The new components are added inside panels 
 * that are carefully organized using layout managers like BorderLayout and GridLayout.
 * The use of JList with JScrollPane allows for the display of multiple vendor options,
 * and the JSlider is customized for ratings.
 * 
 * Last-Update: 12/02/2568
 */

package potjanapimol.pattaraporn.lab9;

import java.awt.*;

import javax.swing.*;

public class MobileDeviceV5 extends MobileDeviceV4 {
    String vendor[] = { "AIS", "True", "DTAC", "Shopee" }; // Array of available vendors
    JList<String> vendorList;
    JScrollPane vendorScroll;
    JPanel devicePanel, vendorPanel, ratePanel, combinedPanel;
    JLabel deviceLB, rateLB;
    JSlider rateSlide;

    public MobileDeviceV5(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");

        mdv5.addComponents(); // Add components like buttons and menus
        mdv5.setFrameFeature(); // Set frame properties like size, close operation, etc.
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

        devicePanel = new JPanel(new BorderLayout());
        deviceLB = new JLabel("The device is avalable at:");
        vendorPanel = new JPanel(new GridLayout(1, 2));
        vendorList = new JList<>(vendor);
        vendorScroll = new JScrollPane(vendorList); // Adds scroll functionality for the list
        vendorScroll.setPreferredSize(new Dimension(120, 80));
        ratePanel = new JPanel(new GridLayout(2, 1));
        rateLB = new JLabel("Rate the device (0-10):"); // Creates a slider for rating from 0 to 10
        rateSlide = new JSlider(0, 10, 5); // Creates labels for each tick
        rateSlide.setLabelTable(rateSlide.createStandardLabels(1));
        rateSlide.setMajorTickSpacing(1); // Sets major tick spacing to 1
        rateSlide.setPaintTicks(true); // Paints the ticks
        rateSlide.setPaintLabels(true); // Paints the labels on the slider

        vendorPanel.add(deviceLB);
        vendorPanel.add(vendorScroll);
        vendorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Allows multiple selections in
                                                                                     // the vendor list
        vendorList.setSelectedIndex(0); // Sets the default selected vendor
        devicePanel.add(vendorPanel);
        ratePanel.add(rateLB);
        ratePanel.add(rateSlide);

        combinedPanel = new JPanel(new BorderLayout()); // Creates a panel with BorderLayout to combine the different
                                                        // sections
        combinedPanel.add(extraPanel, BorderLayout.NORTH);
        combinedPanel.add(devicePanel, BorderLayout.CENTER);
        combinedPanel.add(ratePanel, BorderLayout.SOUTH);
        mainPanel.add(combinedPanel, BorderLayout.CENTER); // Adds the combined panel to the main panel at the center

    }
}
