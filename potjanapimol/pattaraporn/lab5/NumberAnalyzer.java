/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * The NumberAnalyzer Program
 * This program designed to analyze and process numeric arrays. 
 * It provides functionalities for finding the minimum and maximum values, 
 * calculating running averages, and checking 
 * if an array is sorted in ascending order.
 * Displays results including:
 * The original array.
 * The minimum and maximum values.
 * The running averages.
 * Whether the arrays are sorted.
 * Last-Update : 22/12/2567
 */

package potjanapimol.pattaraporn.lab5;

public class NumberAnalyzer {
    // Finds both the minimum and maximum values in an array
    public static int[] findMinMax(int[] numbers) {
        int min = Integer.MAX_VALUE, max = 0; // Declared Value min and max
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        // return an array of two elements where index 0 is minimum and index 1 is
        // maximum
        return new int[] { min, max };
    }

    /*
     * Calculates the running average of numbers up to each position.
     * For example: input [1,2,3] returns [1.0, 1.5, 2.0]
     */
    public static double[] calculateRunningAverages(int[] numbers) {
        double valueNum = 0;
        double[] average = new double[numbers.length]; // create double array
        for (int i = 0; i < numbers.length; i++) {
            valueNum += numbers[i];
            double averageNum = valueNum / (i + 1);
            average[i] = averageNum; // input averageNum in array
        }
        return average;
    }

    /*
     * Checks if the array is sorted in ascending order.
     * input the array to check in parameter.
     * return true if sorted, false otherwise
     */
    public static boolean isSorted(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                return false; // return value if condition is true
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = { 4, 2, 7, 1, 9 };
        int[] maxmin = findMinMax(test); // called method
        double[] runningAvg = calculateRunningAverages(test); // called method
        int[] sort = { 1, 2, 3, 4, 5 };
        System.out.print("Testing with array: ");
        System.out.print("{");
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i]);
            if (i < test.length - 1) {
                System.out.print(", "); // Ensure the last number does not print a ','
            }
        }
        System.out.println("}");
        System.out.println("Minimum value: " + maxmin[0]);
        System.out.println("Maximum value: " + maxmin[1]);
        System.out.println();
        System.out.println("Running averages:");
        for (int i = 0; i < runningAvg.length; i++) {
            System.out.println("Position " + i + ": " + String.format("%.2f", runningAvg[i]));
        }
        System.out.println();
        System.out.println("Testing if arrays are sorted:");
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
        System.out.println();
        System.out.println("numbers1 is sorted: " + isSorted(test));
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + " ");
        }
        System.out.println();
        System.out.println("numbers2 is sorted: " + isSorted(sort));
    }
}
