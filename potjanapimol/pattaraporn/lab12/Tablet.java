/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * The Tablet class represents a tablet device with attributes 
 * such as name, brand, and price.
 * It extends the MobileDevice class and 
 * implements Serializable for object serialization.
 * This class provides constructors for creating tablet instances 
 * with or without a color specification,
 * along with getter and setter methods for its attributes.
 * 
 * Last-Update : 12/03/2568 
 */

package potjanapimol.pattaraporn.lab12;

import java.io.Serializable;
import potjanapimol.pattaraporn.lab7.MobileDevice;

public class Tablet extends MobileDevice implements Serializable {
    private String name; // Name of the tablet
    private String brand; // Brand of the tablet
    private double price; // Price of the tablet

    // Getter methods
    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public double getPrice() {
        return this.price;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Constructor with name, brand, price, and color
    public Tablet(String name, String brand, double price, String color) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color; // The color field is used but not declared, may cause an issue
    }

    // Constructor without color
    public Tablet(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    // Returns false as it is not a watch
    @Override
    public boolean isWatch() {
        return false;
    }

    // Returns a string representation of the tablet object
    @Override
    public String toString() {
        return "Tablet: " + name + " (" + brand + ") " + price + " Bath";
    }
}
