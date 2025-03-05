/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * 
 * MobileDeviceCompleteV3 is a JFrame extension that listens to component events.
 * It extends MobileDeviceCompleteV2 and implements the ComponentListener interface.
 * This class handles resizing, visibility, 
 * and moving events of the window, displaying appropriate messages.
 * 
 * Last-Update : 05/03/2568
 */
 
package potjanapimol.pattaraporn.lab11;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 implements ComponentListener {

    private Timer resizeTimer;
    private Timer moverTimer;

    public MobileDeviceCompleteV3(String title) {
        super(title);

        // Initialize resize timer with a delay of 300ms
        resizeTimer = new Timer(300, e -> {
            String msg = "Window resized to: " + this.getWidth() + " x " + this.getHeight();
            JOptionPane.showMessageDialog(this, msg, "Notification", JOptionPane.INFORMATION_MESSAGE);
            resizeTimer.stop(); // Stop the timer after showing the message
        });
        resizeTimer.setRepeats(false); // Ensure it only fires once per resize

        // Initialize move timer with a delay of 300ms
        moverTimer = new Timer(300, e -> {
            String msg = "Window moved to: X=" + this.getX() + " Y=" + this.getY();
            JOptionPane.showMessageDialog(this, msg, "Notification", JOptionPane.INFORMATION_MESSAGE);
            moverTimer.stop(); // Stop the timer after showing the message
        });
        moverTimer.setRepeats(false); // Ensure it only fires once per move
    }

    // Creates and shows the GUI
    public static void createAndShowGUI() {
        MobileDeviceCompleteV3 window3 = new MobileDeviceCompleteV3("Mobile Device CompleteV3");

        window3.addComponents(); // Add UI components
        window3.addMenus();
        window3.setFrameFeatures(); // Configure frame settings
        window3.addListeners(); // Register event listeners

        // Show only the "Window is now visible" message immediately
        window3.componentShown(null); // Show the visible message immediately
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    @Override
    public void componentResized(ComponentEvent e) {
        // Restart the timer whenever the window is resized
        resizeTimer.restart();
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        String msg = "Window is now invisible";
        JOptionPane.showMessageDialog(this, msg, "Notification", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // Restart the timer whenever the window is moved
        moverTimer.restart();
    }

    @Override
    public void componentShown(ComponentEvent e) {
        String msg = "Window is now visible";
        JOptionPane.showMessageDialog(this, msg, "Notification", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        this.addComponentListener(this); // Add the component listener to the frame
    }
}
