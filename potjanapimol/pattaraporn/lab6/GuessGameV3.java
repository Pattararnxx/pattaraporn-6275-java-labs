/* Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * GuessGameV3
 * 
 * This class adds game records to the number guessing game. 
 * It tracks each game's settings, guesses, and results.
 * 
 * Key Features:
 * - Keeps up to 100 game records.
 * - Tracks guesses, attempts, and if the game was won.
 * - Allows viewing detailed logs for each game.
 * 
 * Last-Update : 22/01/2568
 */

 package potjanapimol.pattaraporn.lab6;

 public class GuessGameV3 extends GuessGameV2 {
     private static final int MAX_GAMES = 100; // Max records
     private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAMES]; // Game records array
     private static int recordIndex = 0; // Current record count
     private int[] guesses; // Stores guesses for the game
     private int guessCount; // Number of guesses made
     private boolean win; // Whether the player won
 
     // Default constructor
     public GuessGameV3() {
         super(); // Use parent settings
         this.guessCount = 0;
         this.win = false;
         this.guesses = new int[getMaxTries()]; // Initialize guesses array
     }
 
     // Constructor with parameters
     public GuessGameV3(int min, int max, int maxTries) {
         super(min, max, maxTries);
         this.guessCount = 0;
         this.win = false;
         this.guesses = new int[getMaxTries()];
     }
 
     // Set up a new game
     @Override
     public void configureGame(int min, int max, int maxTries) {
         super.configureGame(min, max, maxTries);
         this.guessCount = 0;
         this.win = false;
         this.guesses = new int[getMaxTries()];
     }
 
     // Main game loop
     @Override
     public boolean playSingleGame() {
         boolean check = true; // To track if player guessed correctly
         int attempts = 0; // Count attempts
         System.out.println("Welcome to the Record-Keeping Number Guessing Game!");
         generateAnswer(); // Pick a random number
         this.win = false;
 
         // Loop through attempts
         for (int i = 1; i <= getMaxTries(); i++) {
             int number = 0; // User's guess
             while (true) {
                 System.out.print("Enter a number (" + getMin() + " to " + getMax() + "): ");
                 number = NumberGuessingOOPGameV2.input.nextInt(); // Get input
 
                 // Check if input is valid
                 if (number >= getMin() && number <= getMax()) break;
                 System.err.println("Invalid! Guess between " + getMin() + " and " + getMax());
             }
 
             guesses[guessCount] = number; // Save guess
             guessCount++; // Update guess count
             attempts = i;
             setAttempts(attempts); // Save attempts
 
             // Check if the guess is correct
             if (number == getAnswer()) {
                 System.out.println("Correct! You guessed in " + attempts + " attempt(s).");
                 win = true;
                 return true;
             } else if (number < getAnswer()) {
                 System.out.println("Try higher!");
             } else {
                 System.out.println("Try lower!");
             }
         }
 
         // If out of attempts
         System.out.println("Out of attempts! Answer was: " + getAnswer());
         return false;
     }
 
     // Generate game log
     public String getGamelog() {
         return "Range: [" + getMin() + "-" + getMax() + "], Max Tries: " + getMaxTries() +
                ", Attempts: " + getAttempts() + ", Result: " + (win ? "Win" : "Lose") +
                ", Guesses: " + guessList(guesses);
     }
 
     // Helper to format guesses
     public String guessList(int[] list) {
         String result = "";
         for (int i = 0; i < list.length; i++) {
             if (list[i] != 0) {
                 result += list[i];
                 if (i < list.length - 1 && list[i + 1] != 0) result += ", ";
             }
         }
         return result;
     }
 
     // Add a game record
     public static void addGameRecord(GuessGameV3 game) {
         if (recordIndex < MAX_GAMES) {
             gameRecords[recordIndex] = game;
             recordIndex++;
         } else {
             System.err.println("Max game records reached.");
         }
     }
 
     // Get all game records
     public static GuessGameV3[] getGameRecords() {
         return gameRecords;
     }
 
     // Get total record count
     public static int getRecordCount() {
         return recordIndex;
     }
 }
 