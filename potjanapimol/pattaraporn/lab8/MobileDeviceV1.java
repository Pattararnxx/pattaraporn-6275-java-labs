
/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * The code extends MySimpleWindow to create a more detailed
 * form for mobile device information.
 * Uses GridLayout for form fields and BorderLayout 
 * to structure the main panel effectively.
 * Ensures that radio buttons are grouped properly using ButtonGroup,
 *  preventing multiple selections.
 * 
 * Last-Update : 04/02/2568
 * 
 */

 package potjanapimol.pattaraporn.lab8;

 import javax.swing.*;
 import java.awt.*;
 
 public class MobileDeviceV1 extends MySimpleWindow {
     // Extends MySimpleWindow to reuse its components
     protected JLabel deviceLB1, brandLB, priceLB, typeLB;
     protected JTextField deviceTF, brandTF, priceTF;
     protected JRadioButton smartphoneRB, tabletRB;
     protected JPanel formPanel, listPanel;
     protected ButtonGroup list;
 
     public MobileDeviceV1(String title) {
         super(title);
     }
 
     public static void createAndShowGUI() {
         MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1");
         mdv1.addComponents();
         mdv1.setFrameFeature();
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
         super.addComponents(); // Calls the parent method to add existing buttons
         deviceLB1 = new JLabel("Device Name:");
         deviceTF = new JTextField(15);
         brandLB = new JLabel("Brand:");
         brandTF = new JTextField(15);
         priceLB = new JLabel("Price:");
         priceTF = new JTextField(15);
         typeLB = new JLabel("Type:");
         smartphoneRB = new JRadioButton("Smartphone", true);
         tabletRB = new JRadioButton("Tablet");
         list = new ButtonGroup(); // Ensures only one radio button can be selected at a time
         formPanel = new JPanel();
         listPanel = new JPanel();
         formPanel.setLayout(new GridLayout(4, 2)); // Organizes form fields in a 4-row, 2-column grid
         formPanel.add(deviceLB1);
         formPanel.add(deviceTF);
         formPanel.add(brandLB);
         formPanel.add(brandTF);
         formPanel.add(priceLB);
         formPanel.add(priceTF);
         formPanel.add(typeLB);
         listPanel.add(smartphoneRB);
         listPanel.add(tabletRB);
         list.add(smartphoneRB);
         list.add(tabletRB);
         formPanel.add(listPanel);
 
         mainPanel.setLayout(new BorderLayout()); // Uses BorderLayout to arrange form and buttons
         mainPanel.add(formPanel, BorderLayout.NORTH); // Places form fields at the top
         mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Places buttons at the bottom
 
     }
 
 }
 