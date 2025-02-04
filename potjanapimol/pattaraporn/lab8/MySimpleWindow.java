/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * The code creates a simple GUI window using Java Swing.
 * It defines a JFrame with two buttons ("Cancel" and "OK") inside a panel.
 * The GUI setup is done in a structured way,
 *  ensuring proper initialization and display.
 *  The window is centered and automatically resizes to fit its components.
 * 
 * Last-Update : 04/02/2568
 */

package potjanapimol.pattaraporn.lab8;

import javax.swing.*;

public class MySimpleWindow extends JFrame {
    protected JButton resetButton, submitButton;
    protected JPanel mainPanel, buttonPanel;

    public MySimpleWindow(String title) {
        super(title); // Set the title of the JFrame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // Create and display the GUI
            }
        });
    }

    public static void createAndShowGUI() {
        // Create window instance
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeature();
    }

    protected void addComponents() {
        resetButton = new JButton("Cancel"); // Create a "Cancel" button
        submitButton = new JButton("OK"); // Create an "OK" button
        buttonPanel = new JPanel(); // Create a panel for buttons
        mainPanel = new JPanel(); // Create the main panel
        buttonPanel.add(resetButton); // Add "Cancel" button to button panel
        buttonPanel.add(submitButton); // Add "OK" button to button panel
        mainPanel.add(buttonPanel); // Add button panel to the main panel
        add(mainPanel); // Add main panel to the JFrame
    }

    protected void setFrameFeature() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the window
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

}
