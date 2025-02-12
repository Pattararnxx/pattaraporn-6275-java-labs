package potjanapimol.pattaraporn.lab9;

import javax.swing.*;
import java.awt.*;

public class MobileDeviceV6 extends MobileDeviceV5{
    protected Font labelFont = new Font("Arial", Font.BOLD, 14);
    protected Color DARK_BLUE = Color.decode("#000080");
    public MobileDeviceV6(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");

        mdv6.addComponents(); // Add components like buttons and menus
        mdv6.setFrameFeature(); // Set frame properties like size, close operation, etc.
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
        deviceLB.setFont(labelFont);
        deviceLB.setForeground(DARK_BLUE);
    }
}
