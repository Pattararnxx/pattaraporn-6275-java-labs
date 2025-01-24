/* Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * Last-Update : 24/01/2568
 */
package potjanapimol.pattaraporn.lab7;

public abstract class MobileDevice {
    protected String color; // Color of the mobile device
    protected double price; // Price of the mobile device

    // Abstract method to check if the device is a watch
    abstract boolean isWatch();

    // Getter for color
    public String getColor() {
        return this.color;
    }

    // Setter for color
    public void setColors(String color) {
        this.color = color;
    }

    // Getter for price
    public double getPrice() {
        return this.price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }
}
