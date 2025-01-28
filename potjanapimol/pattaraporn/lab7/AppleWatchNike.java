/* Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2 
 * 
 * This program defines an extended class AppleWatchNike 
 * that inherits from the AppleWatch class 
 * and implements two interfaces: 
 * RunnerStatsCollector and HealthMonitorer.
 * 
 * Last-Update : 28/01/2568
 */

package potjanapimol.pattaraporn.lab7;

// Interface for displaying running statistics
interface RunnerStatsCollector {
    public void displayRunningStats();

    public void displayHeartRates();
}

// Interface for monitoring health information
interface HealthMonitorer {
    public void displaySleepHours();
}

// The AppleWatchNike class extends AppleWatch and implements
// RunnerStatsCollector and HealthMonitorer
public class AppleWatchNike extends AppleWatch implements RunnerStatsCollector, HealthMonitorer {
    private double pace;
    private double totalDistance;
    private double time;
    private double avgHeartRate;
    private double maxHeartRate;
    private double avgSleepHours;

    // Constructor to initialize color, price, and model name
    public AppleWatchNike(String color, double price, String modelName) {
        super(color, price, modelName);
    }

    // Constructor to initialize additional statistics: total distance, heart rate,
    // and sleep hours
    public AppleWatchNike(String color, double price, String modelName, double totalDistance, double avgHeartRate,
            double avgSleepHours) {
        super(color, price, modelName);
        this.totalDistance = totalDistance;
        this.avgHeartRate = avgHeartRate;
        this.avgSleepHours = avgSleepHours;
    }

    // Display total running statistics
    public void displayRunningStats() {
        System.out.print("Total distance run: ");
        System.out.printf("%.2f", totalDistance);
        System.out.println(" km");
    }

    // Display average heart rate
    public void displayHeartRates() {
        System.out.print("Average heart rate: ");
        System.out.printf("%.0f", avgHeartRate);
        System.out.println(" bpm");
    }

    // Display average sleep duration
    public void displaySleepHours() {
        System.out.print("Average sleep duration: ");
        System.out.printf("%.2f", avgSleepHours);
        System.out.println(" hours");
    }

    @Override
    public String toString() {
        return "AppleWatchNike" + "(" +
                "color: " + this.getColor() +
                " price:" + this.getPrice() +
                " model name:" + this.getModelName() +
                " distance:" + this.totalDistance + " km" +
                ")";
    }

}
