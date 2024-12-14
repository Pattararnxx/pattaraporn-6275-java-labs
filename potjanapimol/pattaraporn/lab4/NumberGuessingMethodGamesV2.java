/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * The NumberGuessingMethodGamesV2 Program
 * This program users can view all previous guesses 
 * or a specific guess and can choose to play again after each round.
 * We will store the user's input in an array 
 * and access the array elements through displayGuess() method
 * and displayGuessLoop(), which is called in the playGames() method
 * Last-Update: 14/12/2567
 */
package potjanapimol.pattaraporn.lab4;

import java.util.Scanner;

public class NumberGuessingMethodGamesV2 {
    // decleard variable
    static Scanner input = new Scanner(System.in); // user input
    static int min, max, count, answer, number, guessNum;
    static boolean check;
    static String newStart, key;
    static int[] guessing = new int[10]; // create array

    public static void main(String[] args) {
        // called method
        configure();
        playGames();

    }

    static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();
        System.out.print("Enter the max value:");
        max = input.nextInt();
        checkValidvalue(); // called method to check
        System.out.print("Enter the maximum number of tries:");
        count = input.nextInt();
        checkValidcount(); // called method to check
    }

    static void genAnswer() {
        // generate answers
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void checkValidvalue() {
        // Check your input.Display Error messsage if max<min
        while (max < min) {
            System.err.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max = input.nextInt();
        }
    }

    static void checkValidcount() {
        // Check your input.Display Error messsage if count<=0
        while (count <= 0) {
            System.err.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tries:");
            count = input.nextInt();
        }
    }

    static void playGame() {
        check = true;
        System.out.println("Welcome to a number guessing game!");
        genAnswer(); // called method
        for (int i = 1; i < count + 1; ++i) {
            int number = 0; // global variable in for loop
            while (true) {
                System.out.print("Enter an integer between " + min + " and " + max + ":");
                number = input.nextInt();
                /*
                 * Check your input number.Display Error messsage if number is not between min
                 * and max value
                 */
                if (number >= min && number <= max) {
                    break; // stop loop
                }
                System.err.println("The number must be between " + min + " and " + max);
            }
            guessing[i - 1] = number; // input user number in array index

            // condition check your answer and number
            if (number == answer) {
                System.out.println("Congratulations!");
                if (i == 1) {
                    System.out.println("You have tried 1 time");
                } else {
                    System.out.println("You have tried " + i + " times");
                }
                check = false; // change boolean to false
                break; // Stop loop
            } else if (number < answer) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }

        }
        // if input is incorrect display text and correct answer
        if (check) {
            if (count == 1) {
                System.out.println("You have tried " + count + " time.\nThe answer is " + answer);
            } else {
                System.out.println("You have tried " + count + " times.\nThe answer is " + answer);
            }
        }

    }

    static void displayGuesses() {
        System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit:");
        key = input.next(); // Reads the next token
        if (key.equals("a")) {
            // elements number
            for (int i = 0; i < guessing.length; i++) {
                if (guessing[i] == 0)
                    break; // Stop Loop
                System.out.println("Guess " + (i + 1) + ": " + guessing[i]);
            }
        } else if (key.equals("g")) {
            System.out.print("Enter the guess number:");
            guessNum = input.nextInt();
            input.nextLine(); // clear buffer
            System.out.println("Guess " + guessNum + ": " + guessing[guessNum - 1]);
        }
    }

    static void displayGuessesLoop() {
        while (true) {
            displayGuesses();
            // If user input 'a' or 'g' this loop is false
            if (!key.equals("a") && !key.equals("g")) {
                break; // Stop Loop
            }
        }
    }

    static void playGames() {
        do {
            // Do one cycle ignoring the conditions.
            playGame();
            displayGuessesLoop();
            System.out.print("Want to play again (Y or y):");
            input.nextLine(); // clear buffer
            newStart = input.nextLine();
            // if user want to close the program
            if (!newStart.equalsIgnoreCase("y")) {
                System.out.println("Thank you for playing our games. Bye!");
                break;
            }
        } while (true);
        // close scanner
        input.close();
    }
}
