/*
* This program prints out
* the Magic Squares.
*
* @author  Nicholas B. , Mr. Coxall, Jakub Malhotra
* @version 2.0
* @since   2024-12-05
*/

final class Main {
    /**
     * Private constructor to prevent instantiation.
     *
     * @throws IllegalStateException if this class is instantiated.
     */
    private Main() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /** The top left index. */
    public static final int ZERO = 0;
    /** The top middle index. */
    public static final int ONE = 1;
    /** The top right index. */
    public static final int TWO = 2;
    /** The middle left index. */
    public static final int THREE = 3;
    /** The center index. */
    public static final int FOUR = 4;
    /** The middle right index. */
    public static final int FIVE = 5;
    /** The lower left index. */
    public static final int SIX = 6;
    /** The lower center index. */
    public static final int SEVEN = 7;
    /** The lower right index. */
    public static final int EIGHT = 8;
    /** The maximum number for magicNumbers. */
    public static final int NINE = 9;
    /** The magic number for rows, columns, and diagonals. */
    public static final int MAGICNUM = 15;

    /** Counter for the number of processes. */
    private static int numberOfProcess = 0;
    /** Counter for the number of magic squares generated. */
    private static int numberOfMagicSquares = 0;

    /**
     * Generates all possible 3x3 magic squares recursively.
     *
     * @param square        the current magic square array being built.
     * @param currentSquare a secondary array used for backtracking.
     * @param index         the current position being filled in the square.
     */
    public static void genSquare(final int[] square, final int[] currentSquare,
            final int index) {
        if (index == NINE) {
            // Base case: the square is fully filled
            if (isMagic(square)) {
                printMagicSquare(square);
                numberOfMagicSquares++;
            }
            numberOfProcess++;
            return;
        }

        // Try all numbers from 1 to 9 that haven't been used yet
        for (int number = 1; number <= NINE; number++) {
            boolean numberUsed = false;

            // Check if the number is already used
            for (int position = 0; position < index; position++) {
                if (square[position] == number) {
                    numberUsed = true;
                    break;
                }
            }

            if (!numberUsed) {
                // Assign number and recurse
                square[index] = number;
                genSquare(square, currentSquare, index + 1);
                // Backtrack
                square[index] = 0;
            }
        }
    }

    /**
     * Checks if a given array represents a valid magic square.
     *
     * @param preSquare the array to be checked.
     * @return true if the array forms a magic square, false otherwise.
     */
    public static boolean isMagic(final int[] preSquare) {
        int row1 = preSquare[ZERO] + preSquare[ONE] + preSquare[TWO];
        int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
        int col1 = preSquare[ZERO] + preSquare[THREE] + preSquare[SIX];
        int col2 = preSquare[ONE] + preSquare[FOUR] + preSquare[SEVEN];
        int col3 = preSquare[TWO] + preSquare[FIVE] + preSquare[EIGHT];
        int diag1 = preSquare[ZERO] + preSquare[FOUR] + preSquare[EIGHT];
        int diag2 = preSquare[TWO] + preSquare[FOUR] + preSquare[SIX];

        return row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
                && col1 == MAGICNUM && col2 == MAGICNUM
                && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM;
    }

    /**
     * Prints a magic square in a 3x3 format.
     *
     * @param outputSquare the array representing the magic square.
     */
    public static void printMagicSquare(final int[] outputSquare) {
        System.out.println("\n*****");
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            } else {
                System.out.print(outputSquare[count] + " ");
            }
        }
        System.out.println("\n*****");
    }

    /**
     * The main method where execution begins.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(final String[] args) {
        int[] magicSquare = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, extraArray, 0);

        System.out.println("Number of processes: " + numberOfProcess);
        System.out.println("Number of Magic Squares: " + numberOfMagicSquares);
        System.out.println("\nDone.");
    }
}
