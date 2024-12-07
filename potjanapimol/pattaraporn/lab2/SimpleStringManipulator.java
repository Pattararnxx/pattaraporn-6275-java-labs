/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * The SimpleStringManipulator Program
 * This Program changes the first string to uppercase if the first character is a vowel.
 * and if the second string ends with a consanant convert the last character to lowercase.
 * and display result with first string and second string
 * Last-Update: 30/11/2567
 */
package potjanapimol.pattaraporn.lab2;

public class SimpleStringManipulator {
    public static void main(String[] args) {
        // Error message about number of arguments
        if (args.length != 2) {
            System.err.println("Error: Invalid number of arguments. Please provide exactly two strings as arguments");
            return; // Stop Program
        }
        String text1 = args[0];
        String text2 = args[1];
        // Output your input
        System.out.println("First String: " + text1);
        System.out.println("Second String: " + text2);
        // Declare a variable about condition
        String vowel = "aeiouAEIOU";
        // Condition First String
        if (vowel.contains(String.valueOf(text1.charAt(0)))) {
            text1 = text1.substring(0, 1).toUpperCase() + text1.substring(1);
            ;
        } else {
            text1 = text1.substring(0, 1).toLowerCase() + text1.substring(1);
        }
        // Condition Second String
        if (!(vowel.contains(String.valueOf(text2.charAt(text2.length() - 1))))) {
            text2 = text2.substring(0, text2.length() - 1) + Character.toUpperCase(text2.charAt(text2.length() - 1));

        } else {
            text2 = text2.substring(0, text2.length() - 1) + Character.toLowerCase(text2.charAt(text2.length() - 1));
        }
        // Output Resulting String
        System.out.println("Resulting String: " + text1 + text2);
    }
}
