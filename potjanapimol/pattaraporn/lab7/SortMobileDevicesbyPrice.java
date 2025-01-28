/* Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * The main method creates a test case with four devices,
 * sorts them by price, and displays the results.
 * - Demonstrates sorting using Arrays.sort with a custom comparator.
 * - Supports sorting a mix of different MobileDevice subclasses,
 *  such as IPadAir and AppleWatch.
 * 
 * Last-Update : 28/01/2568
 */

package potjanapimol.pattaraporn.lab7;

import java.util.Arrays;
import java.util.Comparator;

// Comparator implementation for sorting MobileDevices by price
public class SortMobileDevicesbyPrice implements Comparator<MobileDevice> {
    public static void main(String[] args) {
        // Create array of mobile devices
        MobileDevice[] devices = new MobileDevice[4];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        devices[2] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        devices[3] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");

        // Sort the devices by price using our comparator
        Arrays.sort(devices, new SortMobileDevicesbyPrice());

        // Display sorted devices
        System.out.println("Mobile devices sorted by price:");
        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }

    // Comparison logic for sorting devices by price
    @Override
    public int compare(MobileDevice o1, MobileDevice o2) {
        // Convert prices to Double and compare
        return Double.valueOf(o1.getPrice()).compareTo(o2.getPrice());
    }
}
