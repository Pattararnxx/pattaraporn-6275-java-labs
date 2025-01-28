/* Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * TestAppleWatchNike class demonstrates the functionality of the AppleWatchNike class.
 * It creates an AppleWatchNike object, 
 * tests its methods, and verifies inheritance 
 * and polymorphism behavior.
 * 
 * Last-Update : 28/01/2568
 */
package potjanapimol.pattaraporn.lab7;

public class TestAppleWatchNike {
    public static void main(String[] args) {
        AppleWatchNike nikeWatch = new AppleWatchNike("Space Gray", 12900.0,
                "Nike SE GPS", 42.5, 75, 7.5);

        System.out.println(nikeWatch); // Display basic information

        // Display health and fitness metrics
        nikeWatch.displayRunningStats();
        nikeWatch.displayHeartRates();
        nikeWatch.displaySleepHours();

        // Test inheritance from AppleWatch
        System.out.println("Is this a watch? " + nikeWatch.isWatch()); // Should print true

        // Test polymorphism
        AppleWatch baseWatch = nikeWatch; // Upcasting
        System.out.println("Through base reference: " + baseWatch);
    }
}
