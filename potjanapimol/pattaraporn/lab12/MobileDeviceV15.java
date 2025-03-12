package potjanapimol.pattaraporn.lab12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import potjanapimol.pattaraporn.lab7.MobileDevice;

public class MobileDeviceV15 extends MobileDeviceV14 {
    // Menu items for selecting the file format (text or binary)
    protected JMenu formatItem;
    protected JCheckBoxMenuItem text, binary;
    protected ButtonGroup itemGroup;

    public MobileDeviceV15(String title) {
        super(title);
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        MobileDeviceV15 mdv15 = new MobileDeviceV15("Mobile Device V15");

        mdv15.addComponents(); // Add UI components
        mdv15.setFrameFeature(); // Set JFrame properties
        mdv15.addListeners(); // Register event listeners
        mdv15.addKeys(); // Add keyboard shortcuts
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Override method to add components to the menu 
    @Override
    public void addComponents() {
        super.addComponents();
        formatItem = new JMenu("Format");
        text = new JCheckBoxMenuItem("Text", true);
        binary = new JCheckBoxMenuItem("Binary", false);
        formatItem.add(text);
        formatItem.add(binary);
        configMenu.add(formatItem);

        itemGroup = new ButtonGroup();
        itemGroup.add(text);
        itemGroup.add(binary);
    }

    // Override method to add listeners for the menu options
    @Override
    public void addListeners() {
        super.addListeners();
        text.addActionListener(this);
        binary.addActionListener(this);
    }

    @Override
    public void handleMenuSave() {
        fileChooser = new JFileChooser(); // Create a file chooser dialog
        int selected = fileChooser.showSaveDialog(this); // Show the save dialog
        if (selected == JFileChooser.APPROVE_OPTION) {
            File fileSelected = fileChooser.getSelectedFile(); // Get the selected file
            // Save the mobile devices to the file in the chosen format
            if (text.isSelected() ? WriteFile(fileSelected, mobileList) : WriteFileBinary(fileSelected, mobileList)) {
                String msg = "Data is saved to " + fileChooser.getSelectedFile().getAbsolutePath() + " successfully!";
                JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
            } else if (!text.isSelected() && !binary.isSelected()) {
                 // Show error if no format is selected
                JOptionPane.showMessageDialog(this, "Please provide format", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void handleMenuOpen() {
        fileChooser = new JFileChooser(); // Create a file chooser dialog
        int selected = fileChooser.showOpenDialog(this);
        if (selected == JFileChooser.APPROVE_OPTION) {
            File fileSelected = fileChooser.getSelectedFile();
            // Read the mobile devices from the file in the chosen format
            if (text.isSelected() ? ReadFile(fileSelected) : ReadFileBinary(fileSelected)) {
                String msg = "Opening: " + fileChooser.getSelectedFile().getAbsolutePath();
                JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE); // Show success message
                StringBuffer msg1 = new StringBuffer();
                msg1.append("Read devices from the file " + fileChooser.getSelectedFile().getAbsolutePath()
                         + "\n");
                msg1.append(newData); // Show the data read from the file
                JOptionPane.showMessageDialog(this, msg1.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
            } else if (!text.isSelected() && !binary.isSelected()) {
                 // Show error if no format is selected
                JOptionPane.showMessageDialog(this, "Please provide format", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to write mobile devices to a text file
    public boolean WriteFile(File file, ArrayList<MobileDevice> mobileDevices) {
        try {
            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file), "UTF-8"));
            // Loop through each mobile device and write it to the file
            for (MobileDevice mobileDevice : mobileDevices) {
                writer.println(mobileDevice);
            }
            writer.close();  // Close the file writer
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please provide a filename", "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found", "Message", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

     // Method to write mobile devices to a binary file
    public boolean WriteFileBinary(File file, ArrayList<MobileDevice> mobileDevices) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(mobileDevices);  // Write the list of mobile devices to the file
            writer.close(); // Close the file writer
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please provide a filename", "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found", "Message", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean ReadFileBinary(File file) {
        try {
            newData = new StringBuffer();
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file));
            @SuppressWarnings("unchecked")
             // Read the list of mobile devices from the binary file
            ArrayList<MobileDevice> newMobileDevices = (ArrayList<MobileDevice>) reader.readObject();
            for (MobileDevice newMobileDevice : newMobileDevices) {
                mobileList.add(newMobileDevice);
                newData.append(newMobileDevice.toString() + "/n");
            }
            reader.close(); // Close the file reader
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please provide a filename", "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found", "Message", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading to file", "Message", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Class MobileDevice not found in your file", "Message",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

}
