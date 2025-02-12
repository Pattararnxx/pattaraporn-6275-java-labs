package potjanapimol.pattaraporn.lab9;
import java.awt.*;

import javax.swing.*;

public class MobileDeviceV5 extends MobileDeviceV4 {
    String vendor[] = {"AIS","True","DTAC","Shopee"};
    JList vendorList;
    JScrollPane vendorScroll;
    JPanel devicePanel,vendorPanel,ratePanel,combinedPanel;
    JLabel deviceLB,rateLB;
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
    protected void addComponents(){
        super.addComponents();

        devicePanel = new JPanel(new BorderLayout());
        deviceLB = new JLabel("The device is avalable at:");
        vendorPanel = new JPanel(new GridLayout(1,2));
        vendorList = new JList<>(vendor);
        vendorScroll = new JScrollPane(vendorList);
        ratePanel = new JPanel(new GridLayout(2,1));
        rateLB = new JLabel("Rate the device (0-10):");
        rateSlide = new JSlider(0,10,5);
        rateSlide.setLabelTable(rateSlide.createStandardLabels(1));
        rateSlide.setMajorTickSpacing(1);
        rateSlide.setPaintTicks(true);
        rateSlide.setPaintLabels(true);

        vendorPanel.add(deviceLB);
        vendorPanel.add(vendorScroll);
        vendorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        vendorList.setSelectedIndex(0);
        devicePanel.add(vendorPanel);
        ratePanel.add(rateLB);
        ratePanel.add(rateSlide);

        combinedPanel = new JPanel(new BorderLayout());
        combinedPanel.add(extraPanel, BorderLayout.NORTH);
        combinedPanel.add(devicePanel,BorderLayout.CENTER);
        combinedPanel.add(ratePanel,BorderLayout.SOUTH);
        mainPanel.add(combinedPanel,BorderLayout.CENTER);
        
    }
}
