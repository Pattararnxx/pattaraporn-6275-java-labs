/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * The SmartPhone class represents a mobile device,
 * specifically a smartphone,
 * and is designed to be serialized for saving and loading its state. 
 * It extends MobileDevice and implements Serializable. 
 * The class provides properties for name, brand, and price, 
 * as well as custom serialization methods for saving and restoring the state of the object.
 * 
 * Last - Update : 12/03/2568
 */

package potjanapimol.pattaraporn.lab12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import potjanapimol.pattaraporn.lab7.MobileDevice;

public class SmartPhone extends MobileDevice implements Serializable {
    private String name;
    private String brand;
    private double price;

    // Getters and setters for name, brand, and price
    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public double getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Constructor with color (color field not declared, may cause issues)
    public SmartPhone(String name, String brand, double price, String color) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    // Constructor without color
    public SmartPhone(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    // Returns false since it's not a watch
    @Override
    public boolean isWatch() {
        return false;
    }

    // Converts the object to a string format
    @Override
    public String toString() {
        return "SmartPhone: " + name + " (" + brand + ") " + price + " Bath";
    }

    // Custom serialization for saving the brand
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Default serialization
        out.writeObject(brand); // Save brand separately
    }

    // Custom deserialization for restoring the brand
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Default deserialization
        brand = (String) in.readObject(); // Restore brand
    }
}