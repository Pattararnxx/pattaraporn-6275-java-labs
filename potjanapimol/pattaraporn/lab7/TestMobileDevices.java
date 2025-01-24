/* Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * The TestMobileDevices Program
 * This program shows how to use different mobile device objects.
 * It checks some basic information like the chip name of IPadAir, if the IPadAir is a watch, 
 * and compares the prices of different devices.
 * This program implement all three classes (MobileDevice, IPadAir, and AppleWatch).
 * 
 * Last-Update : 24/01/2568
 */
package potjanapimol.pattaraporn.lab7;

public class TestMobileDevices {
    public static void main(String[] args) {
        // Create IPadAir object
        IPadAir ipadAir1 = new IPadAir("Rose Gold", 19900.0, 64);
        IPadAir ipadAir2 = new IPadAir("Silver", 24900.0, 256);
        // Create AppleWatch object
        AppleWatch appleWatch1 = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        // Print the chip name of IPadAir
        System.out.println("IPadAir chip name is " + IPadAir.getChipName());
        // Check if IPadAir is a watch
        if (ipadAir2.isWatch()) {
            System.out.println(ipadAir2 + " is a watch");
        } else {
            System.out.println(ipadAir2 + " is not a watch");
        }
        // Compare prices of devices
        comparePrice(ipadAir1, ipadAir2);
        comparePrice(ipadAir1, appleWatch1);
    }

    // Method to compare price
    public static void comparePrice(MobileDevice device1, MobileDevice device2) {
        if (device1.getPrice() == device2.getPrice()) {
            System.out.println(device1.toString() + "  is as cheap as " + device2.toString());
        } else if (device1.getPrice() < device2.getPrice()) {
            System.out.println(device1.toString() + " is cheaper than " + device2.toString());
        } else {
            System.out.println(device2.toString() + " is cheaper than " + device1.toString());
        }
    }
}
