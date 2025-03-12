/* Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This class represents an AppleWatch object with properties like color, 
 * price, and model name. It includes methods to check if it's a watch, 
 * get/set the model name, and display the device info.
 * 
 * Last-Update : 24/01/2568
 */
package potjanapimol.pattaraporn.lab7;

public class IPadAir extends MobileDevice {
    private double storage; // Storage of the iPad Air
    private static final String CHIP_NAME = "Apple M2"; // Static chip name for IPadAir

    // Constructor to initialize IPadAir object with color, price, and storage
    public IPadAir(String color, double price, double storage) {
        this.color = color;
        this.price = price;
        this.storage = storage;
    }

    // Getter for storage
    public double getStorage() {
        return this.storage;
    }

    // Setter for storage
    public void setStorage(double storage) {
        this.storage = storage;
    }

    // Static method to get the chip name
    public static String getChipName() {
        return CHIP_NAME;
    }

    // Method to return false as IPadAir is not a watch
    public boolean isWatch() {
        return false;
    }

    // Override toString method to return a string representation of the IPadAir
    // object
    @Override
    public String toString() {
        return "IPadAir " + "[" + "color=" + getColor() + ", price=" + getPrice() +
                ", storage=" + getStorage() + ", chip=" + CHIP_NAME + "]";
    }
}
