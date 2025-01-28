/* Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This program implements a custom comparator class SortMobileDevices 
 * to sort an array of MobileDevice objects
 * based on multiple criteria. 
 * The sorting is performed in the following order of priority
 * 1. Price
 * 2. Storage
 * 3. Model Name 
 * 4. Color
 * 
 * Last-Update : 28/01/2568
 */
package potjanapimol.pattaraporn.lab7;

import java.util.Arrays;
import java.util.Comparator;

public class SortMobileDevices implements Comparator<MobileDevice> {
    public static void main(String[] args) {
        // Create array of mobile devices with test cases
        MobileDevice[] devices = new MobileDevice[7];

        // Different prices
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        // Same price, different storage
        devices[2] = new IPadAir("Space Gray", 19900.0, 128);
        devices[3] = new IPadAir("Silver", 19900.0, 64);
        // AppleWatches with different prices
        devices[4] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        // Same price, different models
        devices[5] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
        devices[6] = new AppleWatch("Gold", 12900.0, "Apple Watch Series 7");

        // Sort the devices using our comparator
        Arrays.sort(devices, new SortMobileDevices());

        // Display sorted devices
        System.out.println("Mobile devices sorted by multiple criteria:");
        for (MobileDevice device : devices) {
            System.out.println(device);
        }

    }

    @Override
    public int compare(MobileDevice o1, MobileDevice o2) {
        // Compare devices by price first
        int priceCompare = Double.valueOf(o1.getPrice()).compareTo(o2.getPrice());
        if (priceCompare == 0) {
            // Check if both objects are IPadAir
            if (o1 instanceof IPadAir && o2 instanceof IPadAir) {
                IPadAir ipadAir1 = (IPadAir) o1;
                IPadAir ipadAir2 = (IPadAir) o2;
                // Compare by storage size
                int storageCompare = Double.valueOf(ipadAir1.getStorage()).compareTo(ipadAir2.getStorage());
                if (storageCompare == 0) { // If storage is the same, compare by color
                    int colorCompare = ipadAir1.getColor().compareTo(ipadAir2.getColor());
                    return colorCompare;
                }
                return storageCompare;
            }
            // Check if both objects are AppleWatch
            if (o1 instanceof AppleWatch && o2 instanceof AppleWatch) {
                AppleWatch appleWatch1 = (AppleWatch) o1;
                AppleWatch appleWatch2 = (AppleWatch) o2;
                // Compare by model name
                int modelNameCompare = appleWatch1.getModelName().compareTo(appleWatch2.getModelName());
                if (modelNameCompare == 0) { // If model names are the same, compare by color
                    int colorCompare = appleWatch1.getColor().compareTo(appleWatch2.getColor());
                    return colorCompare;
                }
                return modelNameCompare;
            }
            // If types are different or no specific criteria match, compare by color
            return o1.getColor().compareTo(o2.getColor());
        }
        return priceCompare; // Return result of price comparison
    }
}
