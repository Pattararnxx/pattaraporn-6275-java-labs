/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * Use instance private variables to store the game's configuration (min, max, maxTries, and answer).
 * Defined variable in constructor
 * The default constructor initializes min to 1, max to 100,
 *  maxTries to 10, answer to 0, and attempts to 0, while setting up the guesses array.
 * A parameterized constructor that sets min, max, and maxTries to provided values
 * Instance Method
 * configureGame(int min, int max, int maxTries)
 * generateAnswer(), playSingleGame()
 * Called this class in NumberGuessingOOPGame 
 * Last-Update: 27/12/2567
 */
package potjanapimol.pattaraporn.lab6;

public class GuessGame {
    // Declared private variable
    private int min;
    private int max;
    private int maxTries;
    private int answer;
    private int attempts;

    // Default Constructor
    public GuessGame() {
        // Defined variable
        this.min = 1;
        this.max = 100;
        this.maxTries = 10;
        this.answer = 0;
        this.attempts = 0;
    }

    public GuessGame(int min, int max, int maxTries) {
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
    }

    // Getter and Setter Method
    public int getMin() {
        return this.min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMaxTries() {
        return this.maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    public int getAttempts(){
        return this.attempts;
    }

    public void setAttempts(){
        this.attempts = 0;
    }

    public void configureGame(int min, int max, int maxTries) {
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
    }

    public void generateAnswer() {
        // Generated answer
        this.answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    public int getAnswer() {
        return this.answer;
    }

    public void setAnswer(GuessGame guessGame) {
        this.answer =answer;
    }

    public boolean playSingleGame() {
        boolean check = true;
        System.out.println("Welcome to the Number Guessing Game!");
        generateAnswer(); // called method
        for (int i = 1; i < maxTries + 1; ++i) {
            int number = 0; // global variable in for loop
            System.out.print("Enter an integer between " + this.min + " and " + this.max + ": ");
            number = NumberGuessingOOPGame.input.nextInt();

            // condition check your answer and number
            this.attempts = i;
            if (number == this.answer) {
                System.out.print("Congratulations! ");
                if (i == 1) {
                    System.out.println("You've guessed the number in 1 attempt.");
                } else {
                    System.out.println("You've guessed the number in " + this.attempts + " attempts.");
                }
                check = false; // change boolean to false
                return true; // Stop loop
            } else if (number < this.answer) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }
        }
        // if input is incorrect display text and correct answer
        if (check) {
            if (this.attempts == 1) {
                System.out.println("Sorry, you've used all your attempt. The correct answer was: " + this.answer);
            } else {
                System.out.println("Sorry, you've used all your attempts. The correct answer was: " + this.answer);
            }
            return false;
        }
        return true;
    }

}
