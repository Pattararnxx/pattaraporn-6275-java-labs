/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * Sec : 2
 * The MatrixOperations Program
 * The user starts by choosing a matrix creation option.
 * Input the number of rows and columns.
 * The user then chooses an operation.
 * The user can continue performing operations until choosing to exit the program.
 * Key Features in this program.
 * - Matrix Creation : Manaual input ,Random Numbers, All zeros, All Ones ,Diagonal Matrix
 * In method displayCreationMenu() , createMatrix(choice),  createDiagonalMatrix()
 * - Matrix Operations: Transpose of the Matrix, Sum of Rows and Columns, Find Minimum and Maximum Elements, Display Diagonal Elements
 * In method transposeMatrix(), calculateSums(), findMinMax(), displayDiagonal() 
 * Last - Update : 23/12/2567
 */

package potjanapimol.pattaraporn.lab5;

import java.util.Scanner;

public class MatrixOperations {
    // Declare variables
    private static int[][] matrix;
    private static int rows;
    private static int columns;
    private static final Scanner scanner = new Scanner(System.in);

    // Display the matrix creation menu
    public static void displayCreationMenu() {
        System.out.println("Matrix Creation Menu:");
        System.out.println("1. User Input Matrix");
        System.out.println("2. Random Matrix (0-9)");
        System.out.println("3. All Zeros Matrix");
        System.out.println("4. All Ones Matrix");
        System.out.println("5. Diagonal Matrix");
        System.out.print("Enter your choice: ");
    }

    // Create a matrix on the user's choice
    public static void createMatrix(int choice) {
        if (choice == 1) {
            // User inputs matrix elements
            System.out.println("Enter matrix elements:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        } else if (choice == 2) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    // Random matrix with values between 0 and 9
                    matrix[i][j] = (int) (Math.random() * 10);
                }
            }
        } else if (choice == 3) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = 0; // Set all elements to 0
                }
            }
        } else if (choice == 4) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = 1; // Set all elements to 1
                }
            }
        }
    }

    // Create a diagonal matrix
    public static void createDiagonalMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
                if (i == j) { // Position [0][0],[1][1],[2][2],...
                    matrix[i][j] = 1;
                }
            }
        }
    }

    // Display your choice
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(String.format("%4d", matrix[i][j])); // Align the distance
            }
            System.out.println();
        }
    }

    // Display the matrix operations menu
    public static void displayOperationsMenu() {
        System.out.println();
        System.out.println("Matrix Operations Menu:");
        System.out.println("1. Find Transpose of the Matrix");
        System.out.println("2. Calculate Sum of Rows and Columns");
        System.out.println("3. Find Minimum and Maximum Elements");
        System.out.println("4. Display Diagonal Elements");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void transposeMatrix() {
        System.out.println("Transposed Matrix:");
        int[][] transposeMatrix = new int[columns][rows]; // Create a new matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix[j][i] = matrix[i][j]; // Swap rows and columns
            }
        }
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                // Display the transposed matrix
                System.out.print(String.format("%4d", transposeMatrix[i][j]));
            }
            System.out.println();
        }
    }

    public static void calculateSums() {
        System.out.println("Row sums:");
        for (int i = 0; i < rows; i++) {
            int sum = 0, number;
            for (int j = 0; j < columns; j++) {
                number = matrix[i][j];
                sum += number; // Add the element
            }
            System.out.println("Row " + (i + 1) + " sum: " + sum);
        }
        System.out.println();
        System.out.println("Column sums:");
        for (int i = 0; i < columns; i++) {
            int sum = 0, number;
            for (int j = 0; j < rows; j++) {
                number = matrix[j][i];
                sum += number; // Add the element
            }
            System.out.println("Column " + (i + 1) + " sum: " + sum);
        }
    }

    public static void findMinMax() {
        int min = Integer.MAX_VALUE, max = 0; // Defined Variables
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j]; // Update minimum value
                }
                if (max < matrix[i][j]) {
                    max = matrix[i][j]; // Update maximum value
                }
            }
        }
        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);
    }

    public static void displayDiagonal() {
        // Error if matrix is not square
        if (rows != columns) {
            System.err.println("Matrix is not square. Cannot display diagonal elements");
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (i == j) {
                        System.out.print("Diagonal Elements: " + matrix[i][j] + " ");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean continueProgram = true;
        while (continueProgram) {
            displayCreationMenu();
            int choice = scanner.nextInt(); // Get the user's choice

            if (choice >= 1 && choice <= 4) {
                // For options 1-4, get matrix dimensions
                System.out.print("Enter number of rows: ");
                rows = scanner.nextInt();
                System.out.print("Enter number of columns: ");
                columns = scanner.nextInt();

                if (rows <= 0 || columns <= 0) {
                    System.out.println("Error: Dimensions must be greater than 0");
                    continue;
                }

                matrix = new int[rows][columns]; // Create matrix on user's choice
                createMatrix(choice);
            } else if (choice == 5) {
                // Diagonal matrix must be square
                System.out.print("Enter size of square matrix: ");
                rows = columns = scanner.nextInt();

                if (rows <= 0) {
                    System.out.println("Error: Size must be greater than 0");
                    continue;
                }

                matrix = new int[rows][rows];
                createDiagonalMatrix();
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.println("\nCreated Matrix:");
            displayMatrix(matrix);

            // Operations menu loop
            boolean continueOperations = true;
            while (continueOperations) {
                displayOperationsMenu();
                int operation = scanner.nextInt();
                System.out.println();

                // Display case by user input
                switch (operation) {
                    case 1:
                        transposeMatrix();
                        break;
                    case 2:
                        calculateSums();
                        break;
                    case 3:
                        findMinMax();
                        break;
                    case 4:
                        displayDiagonal();
                        break;
                    case 5:
                        continueOperations = false;
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Invalid operation choice.");
                }
            }
        }
        scanner.close(); // Close the scanner
    }
}
