/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * 
 * This class is responsible for reading 
 * and displaying an image in a JPanel.
 * It loads an image from the resources folder (images/)
 * using ImageIO.read and displays it using 
 * the paintComponent method.
 * The image is resized to fit the size of the panel.
 * 
 * Last-Update : 12/02/2568
 */
package potjanapimol.pattaraporn.lab9;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ReadImage extends JPanel {
    private BufferedImage img;

    public ReadImage(String fileName) {
        try {
            InputStream imageStream = getClass().getClassLoader().getResourceAsStream("images/" + fileName);
            if (imageStream == null) {
                throw new IOException("Image file not found: images/" + fileName);
            }
            img = ImageIO.read(imageStream);
            revalidate();
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            int panelWidth = getWidth();
            int panelHeight = getHeight();

            g2d.drawImage(img, 0, 0, panelWidth, panelHeight, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return (img != null) ? new Dimension(600, 300) : new Dimension(600, 300);
    }
}
