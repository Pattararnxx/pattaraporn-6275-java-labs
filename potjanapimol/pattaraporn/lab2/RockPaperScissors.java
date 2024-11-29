/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * The RockPaperScissors Program
 * This Program is about the game played by two players
 * Each player must input either 'Rock', 'Paper' or 'Scissors'
 * The program determines the winner based on the standard rules of Rock-Paper-Scissors:
 * Rock crushes Scissors: Rock wins.
 * Scissors cut Paper: Scissors win.
 * Paper covers Rock: Paper wins.
 * If both players choose the same option, the result is a tie
 * Last-Update: 30/11/2567
 */
package potjanapimol.pattaraporn.lab2;
    public class RockPaperScissors {
    public enum Choice{
        //Constant Value
        ROCK, PAPER, SCISSORS;
         }
         public static void main(String[] args) {
            //Error message about number of arguments
            if (args.length != 2) {
                System.err.println("Error: Invalid number of arguments. Please provide exactly two arguments.");
                return; //Stop program
            }
            String player1 = args[0];
            String player2 = args[1];
            //Change your answer to UPPERCASE
            String Upper1 = args[0].toUpperCase();
            String Upper2 = args[1].toUpperCase();
            try{
                //Change String to enum
                Choice choice1 = Choice.valueOf(Upper1);
                Choice choice2 = Choice.valueOf(Upper2);
                //Output your answer
                System.out.println("Player 1 chooses: "+player1);
                System.out.println("Player 2 chooses: "+player2);
                
                //Condition to check
                if (choice1.equals(choice2)) {
                    System.out.println("It's a tie!");
                } else if(choice1.equals(Choice.ROCK)&&choice2.equals(Choice.PAPER) || choice1.equals(Choice.PAPER)&&choice2.equals(Choice.SCISSORS)
                || choice1.equals(Choice.SCISSORS)&&choice2.equals(Choice.ROCK)){
                    System.out.println("Player 2 wins!");
                } else{
                    System.out.println("Player 1 wins!");
                }
                
            }//Error message about invalids choicese
            catch(IllegalArgumentException e){
                System.err.println("Error: Invalid choice(s). Valid choices are 'rock', 'paper', or 'scissors");
                return;//Stop program
            }
        }
    }
    


