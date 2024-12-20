/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * The RecusiveMethods Program
 * This program used recusive methods with sumOfDigits(),reverseArray(),Ispalindrome()
 * instead of For Loop,While Loop
 * This program uses recursive methods for:
 * 1. Calculating the sum of digits of a number.
 * 2. Reversing an array.
 * 3. Checking if an array is a palindrome.
 * Last-Update : 20/12/2567
 */
package potjanapimol.pattaraporn.lab5;

public class RecusiveMethods {
    /**
     * Recursively finds the sum of digits in a number.
     * Example: For the number 123, the answer is 1+2+3 = 6
     * 
     * @param number the input number
     * @return sum of digits
     */
    public static int sumOfDigits(int number) {
        if (number < 10)
            return number;
        int count = number % 10;
        count += sumOfDigits(number / 10);
        return count;

    }

    /**
     * Recursively reverses an array between start and end indices.
     * 
     * @param arr   the array to reverse
     * @param start starting index
     * @param end   ending index
     */
    public static void reverseArray(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        System.out.print(arr[end] + " ");
        reverseArray(arr, start + 1, end - 1);
        if (start == end) {
            return;
        }
        System.out.print(arr[start] + " ");
    }

    /**
     * Recursively checks if an array is palindrome.
     * 
     * @param arr   the array to check
     * @param start starting index
     * @param end   ending index
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(int[] arr, int start, int end) {
        boolean yesIsPalindrome = arr[start] == arr[end]; // a boolean variable to check if the values are equal
        if (!yesIsPalindrome) { // Value is false
            return yesIsPalindrome;
        } else { // Value is True
            if (start + 1 <= end - 1) {
                yesIsPalindrome = isPalindrome(arr, start + 1, end - 1);
            }
        }
        return yesIsPalindrome;

    }

    public static void main(String[] args) {
        int number = 45, number1 = 12345;
        System.out.println("Sum of digits in" + number + ": " + sumOfDigits(number));
        System.out.println("Sum of digits in" + number1 + ": " + sumOfDigits(number1));
        System.out.println();
        System.out.println("Original array:");
        int[] arr = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.err.println();
        System.out.println("Reversed array:");
        reverseArray(arr, 0, 4);
        System.out.println();
        System.out.println();
        System.out.println("Testing palindrome:");
        int[] arr1 = { 1, 2, 3, 2, 1 };
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.println("Is palindrome: " + isPalindrome(arr1, 0, 4));
        System.out.println();
        System.out.println("Testing palindrome:");
        int[] arr2 = { 1, 2, 1, 2 };
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.println("Is palindrome: " + isPalindrome(arr2, 0, 3));
    }
}
