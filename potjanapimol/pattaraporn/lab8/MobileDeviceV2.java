/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This class extends MobileDeviceV1, adding more fields 
 * for operating system selection and device features.
 * Uses JScrollPane for the text area
 * GridLayout for the extra panel and integrating it 
 * into mainPanel using BorderLayout.CENTER.
 * 
 * Last-Update : 04/02/2568
 */

package potjanapimol.pattaraporn.lab8;

import javax.swing.*;
import java.awt.*;

public class MobileDeviceV2 extends MobileDeviceV1 {
    // Extends MobileDeviceV1 to add more details
    protected JLabel operateLB, featureLB;
    protected JComboBox<String> optionBox;
    protected JTextArea textFeature;
    protected JScrollPane textScroll;
    protected JPanel extraPanel;

    public MobileDeviceV2(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");

        mdv2.addComponents();
        mdv2.setFrameFeature();
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
        super.addComponents(); // Calls the parent method to reuse existing components
        operateLB = new JLabel("Operating System:");
        optionBox = new JComboBox<>(); // Dropdown menu for selecting an operating system
        optionBox.addItem("Android");
        optionBox.addItem("iOS");
        optionBox.addItem("Windows");
        optionBox.addItem("Others");
        featureLB = new JLabel("Features:");
        textFeature = new JTextArea(3, 25); // Text area for entering additional features
        textScroll = new JScrollPane(textFeature); // Adds a scroll bar to the text area
        extraPanel = new JPanel();
        extraPanel.setLayout(new GridLayout(2, 2)); // Arranges the new components in a grid
        extraPanel.add(operateLB);
        extraPanel.add(optionBox);
        extraPanel.add(featureLB);
        extraPanel.add(textScroll);
        mainPanel.add(extraPanel, BorderLayout.CENTER); // Adds the extra panel to the center of the main panel

    }

}
