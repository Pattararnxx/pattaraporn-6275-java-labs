/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * The NumberGuessingOOPGame Program
 * This program will replicate the functionality of Lab 4 Problem.
 * This driver class will contain the main method to manage the game and interact with the user
 * Use the GuessGame class to configure and play the game.
 * Prompt the user to configure the game
 * After each game, display a game result.
 * Last-Update : 27/12/2567 
 */
package potjanapimol.pattaraporn.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGame {
    public static Scanner input = new Scanner(System.in);
    private GuessGame game; // Used Class Java

    public void configure() {
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        System.out.print("Enter the max value: ");
        int max = input.nextInt();
        System.out.print("Enter the maximum number of tries: ");
        int maxTries = input.nextInt();
        // Called constructor method in GuessGame
        this.game = new GuessGame(min, max, maxTries);
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
        System.out.println("Thank you for playing the Number Guessing Game!");
    }

    public static void main(String[] args) {
        // Create object
        NumberGuessingOOPGame program = new NumberGuessingOOPGame();
        // Display method
        program.configure();
        program.playGames();
    }

}
