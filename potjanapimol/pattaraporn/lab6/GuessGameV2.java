/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * The GuessGameV2 Class
 * This class extends the GuessGame class and overrides the methods to provide additional functionality.
 * It allows the user to configure the game with a minimum and maximum value and maximum number of tries.
 * The class validates the inputs to ensure they are valid.
 * It also contains the logic for playing a single game, including taking user input,
 * giving feedback, and determining whether the user has won or lost.
 * The configuration details of the game can be displayed using the `toString` method.
 * Last-Update : 03/01/2568
 */
package potjanapimol.pattaraporn.lab6;

public class GuessGameV2 extends GuessGame {
    public GuessGameV2() {
        super(); // Calls constructor of the superclass GuessGame
    }

    public GuessGameV2(int min, int max, int maxTries) {
        super(min, max, maxTries); // Calls the parameter
    }

    @Override
    public void configureGame(int min, int max, int maxTries) {
        // check valid input for min and max
        while (max < min) {
            System.err.println("Invalid input: max must be greater than or equal to min.");
            System.out.print("Enter the min value: ");
            min = NumberGuessingOOPGameV2.input.nextInt();
            System.out.print("Enter the max value: ");
            max = NumberGuessingOOPGameV2.input.nextInt();
        }

        // Ensure maxTries is positive
        while (maxTries <= 0) {
            System.err.println("Invalid input: maxTries must be greater than 0.");
            System.out.print("Enter the maximum number of tries: ");
            maxTries = NumberGuessingOOPGameV2.input.nextInt();
        }

        // Call the superclass's configureGame
        super.configureGame(min, max, maxTries);

    }

    @Override
    public boolean playSingleGame() {
        boolean check = true;
        int attempts = getAttempts();
        System.out.println("Welcome to the Number Guessing Game V2!");
        generateAnswer(); // called method
        for (int i = 1; i < getMaxTries() + 1; ++i) {
            int number = 0; // global variable in for loop
            while (true) {
                System.out.print("Enter an integer between " + getMin() + " and " + getMax() + ": ");
                number = NumberGuessingOOPGameV2.input.nextInt();
                /*
                 * Check your input number.Display Error messsage if number is not between min
                 * and max value
                 */
                if (number >= getMin() && number <= getMax()) {
                    break; // stop loop
                }
                System.err.println("Invalid input: guess must be between " + getMin() + " and " + getMax());
            }

            // condition check your answer and number
            attempts = i;
            if (number == getAnswer()) {
                System.out.print("Congratulations! ");
                if (i == 1) {
                    System.out.println("You've guessed the number in 1 attempt.");
                } else {
                    System.out.println("You've guessed the number in " + attempts + " attempts.");
                }
                check = false; // change boolean to false
                return true; // Stop loop
            } else if (number < getAnswer()) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }
        }
        // if input is incorrect display text and correct answer
        if (check) {
            if (attempts == 1) {
                System.out.println("Sorry, you've used all your attempt. The correct answer was: " + getAnswer());
            } else {
                System.out.println("Sorry, you've used all your attempts. The correct answer was: " + getAnswer());
            }
            return false;
        }
        return true;

    }

    @Override
    public String toString() {
        // Return a formatted string displaying the game's
        return "Game Configuration: " + "[" + "Min: " + getMin() +
                ", Max: " + getMax() + ", Max Tries: " + getMaxTries() + ", Attempts: " + getAttempts() +
                "]";
    }

}
