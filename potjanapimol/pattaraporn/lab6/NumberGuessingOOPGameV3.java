/* Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * The NumberGuessingOOPGameV3 Program
 * 
 * This program implements an object-oriented number guessing game with 
 * enhanced features like configurable game settings, record-keeping for 
 * multiple games, and options to view all or specific game records.
 * 
 * Key Features:
 * - Allows users to configure min/max range and maximum attempts for each game.
 * - Keeps track of game records, including guesses, outcomes, and settings.
 * - Offers an option to view complete game records or a specific game record.
 * 
 * Last-Update : 22/01/2568
 */

package potjanapimol.pattaraporn.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGameV3 {
    public static Scanner input = new Scanner(System.in); // Scanner for user input
    private GuessGameV3 game; // Instance variable for game logic

    // Configure the game by setting up range and maximum tries.
    public void configure() {
        // Get min and max range from user
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        System.out.print("Enter the max value: ");
        int max = input.nextInt();

        // Initialize game with default values and validate inputs
        this.game = new GuessGameV3(min, max, 1);
        this.game.configureGame(min, max, 1);

        // Get validated min and max
        min = this.game.getMin();
        max = this.game.getMax();

        // Get the maximum number of tries
        System.out.print("Enter the maximum number of tries: ");
        int maxTries = input.nextInt();

        // Finalize game configuration
        this.game.configureGame(min, max, maxTries);
        GuessGameV3.addGameRecord(this.game); // Save this game to records
    }

    // Main game loop allowing play, viewing records, or quitting.

    public void playGames() {
        boolean playAgain, choiceAgain = false; // Loop controls
        do {
            this.game.playSingleGame(); // Play a single game round

            do {
                // Menu options
                System.out.println("Do you want to:");
                System.out.println("1. Play again");
                System.out.println("2. View game records");
                System.out.println("3. Quit");
                int choice = input.nextInt();

                if (choice == 1) {
                    configure(); // Reconfigure for a new game
                    choiceAgain = false;
                    playAgain = true;
                } else if (choice == 2) {
                    viewRecords(); // View game records
                    playAgain = true;
                    choiceAgain = true;
                } else if (choice == 3) {
                    // Exit the game
                    System.out.println("Thank you for playing Number Guessing Game V3!");
                    playAgain = false;
                    choiceAgain = false;
                } else {
                    // Invalid menu input
                    System.err.println("Invalid choice! Please enter 1, 2, or 3.");
                    playAgain = true;
                    choiceAgain = true;
                }
            } while (choiceAgain); // Repeat menu until a valid choice is made
        } while (playAgain); // Continue playing if the user selects "Play again"
    }

    // View all game records or a specific game record.

    public void viewRecords() {
        System.out.println("View:");
        System.out.println("1. Complete Records");
        System.out.println("2. Specific Game Record");
        int userView = input.nextInt();

        if (userView == 1) {
            // Show all game records
            for (int i = 0; i < GuessGameV3.getRecordCount(); i++) {
                System.out.println("Game " + (i + 1) + ": " + GuessGameV3.getGameRecords()[i].getGamelog());
            }
        } else if (userView == 2) {
            // Show specific game record
            System.out.print("Enter the game number to view: ");
            int gameView = input.nextInt() - 1;
            if (gameView < 0 || gameView >= GuessGameV3.getRecordCount()
                    || GuessGameV3.getGameRecords()[gameView] == null) {
                System.err.println("No game record found for game " + (gameView + 1) + ".");
            } else {
                System.out.println(GuessGameV3.getGameRecords()[gameView].getGamelog());
            }
        } else {
            System.err.println("Invalid choice! Please enter 1 or 2."); // Handle invalid input
        }
    }

    // Main method to start the program.

    public static void main(String[] args) {
        NumberGuessingOOPGameV3 program = new NumberGuessingOOPGameV3(); // Create game instance
        program.configure(); // Configure initial game
        program.playGames(); // Start game loop
        input.close(); // Close scanner
    }
}
