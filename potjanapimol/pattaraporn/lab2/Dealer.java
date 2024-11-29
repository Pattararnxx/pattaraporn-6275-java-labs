package potjanapimol.pattaraporn.lab2;

/**
 * The Dealer Program
 * This program accepts three aeguments then processes
 * and displays dealer information
 * The output should be
 * Dealer's name : <dealer_name>.
 * Number of clients : <num_clients>
 * Gender : <dealer_gender>
 * 
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 1
 */
public class Dealer {
    public static void main(String[] args) {

        if (args.length == 3) {
            String name = args[0];
            String clients = args[1];
            String gender = args[2];
            System.out.println("Dealer's Name: " + name);
            System.out.println("Number of clients: " + clients);
            System.out.println("Gender: " + gender);
        } else {
            System.err.println("The error message will be displayed if exactly three arguments are not input.");
        }

    }
}
