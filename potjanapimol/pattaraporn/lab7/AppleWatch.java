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

public class AppleWatch extends MobileDevice {
    private String modelName; // Model name of the AppleWatch

    // Constructor to initialize the AppleWatch object
    public AppleWatch(String color, double price, String modelName) {
        this.color = color;
        this.price = price;
        this.modelName = modelName;
    }

    // Method to check if it is a watch
    public boolean isWatch() {
        return true;
    }

    // Getter and setter for model name
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    // Return string representation of AppleWatch
    @Override
    public String toString() {
        return "AppleWatch [color=" + getColor() + ", price=" + getPrice() +
                ", modelName=" + getModelName() + "]";
    }
}
