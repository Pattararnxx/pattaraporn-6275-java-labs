/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * The NumberGuessingOOPGameV2 Program
 * This program will replicate the functionality of Lab 4 Problem.
 * This driver class will contain the main method to manage the game and interact with the user
 * Use the GuessGameV2 class that inheritated from GuessGame class to configure and play the game.
 * Prompt the user to configure the game
 * After each game, display a game result.
 * New Features
 * In this program can check the error in min max maxtries the user to re-enter values 
 * until valid inputs are provided.
 * Last-Update : 03/01/2568 
 */
package potjanapimol.pattaraporn.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGameV2 {
    public static Scanner input = new Scanner(System.in);
    private GuessGameV2 game; // Instance variable for the game logic class

    public void configure() {
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        System.out.print("Enter the max value: ");
        int max = input.nextInt();
        // Initialize the game with default maxTries (1) and validate min/max values
        this.game = new GuessGameV2(min, max, 1);
        this.game.configureGame(min, max, 1);

        // Retrieve validated min and max values from the GuessGameV2 class
        min = this.game.getMin();
        max = this.game.getMax();
        System.out.print("Enter the maximum number of tries: ");
        int maxTries = input.nextInt();
        // Configure the game with the validated inputs
        this.game.configureGame(min, max, maxTries);
        // Display the game's configuration
        System.out.println(this.game.toString());

    }

    public void playGames() {
        // Check Loop
        boolean playAgain;
        do {
            boolean result = this.game.playSingleGame(); // Called method in GuessGame Java
            System.out.println(result ? "You win!" : "Better luck next time."); // if playSingleGame return true display
                                                                                // "You Win!"
            System.out.print("Do you want to play again? (y/n): ");
            // if user input "y or Y" playAgain is true
            playAgain = input.next().equalsIgnoreCase("y");
            if (playAgain) {
                configure();
            }
        } while (playAgain); // Stop Loop if playAgain is false
        System.out.println("Thank you for playing the Number Guessing Game V2!");
    }

    public static void main(String[] args) {
        // Create object
        NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2();
        // Display method
        program.configure();
        program.playGames();
        // close scanner
        input.close();
    }
}
