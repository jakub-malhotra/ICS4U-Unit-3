/*
* This program prints out
* all possible 3x3 Magic Squares
* where the sum of rows, columns,
* and diagonals equals 15.
*
* @author  Jakub Malhotra
* @version 1.0
* @since   2024-12-03
*/

final class Main {

    /**
     * Prevent instantiation of this class.
     *
     * @throws IllegalStateException if instantiated
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
    /** The maximum number for magic square rows, columns, or diagonals. */
    public static final int MAGICNUM = 15;

    /** Tracks the number of processes performed. */
    private static int numberOfProcess = 0;

    /** Tracks the number of valid magic squares found. */
    private static int numberOfMagicSquares = 0;

    /**
     * Validates if the given array forms a magic square.
     *
     * @param preSquare the array representing the magic square
     * @return true if the array forms a valid magic square, false otherwise
     */
    public static boolean isMagic(final int[] preSquare) {
        if (preSquare.length != 9) {
            return false;
        }

        boolean[] seenNumbers = new boolean[10];
        for (int currentValue : preSquare) {
            if (currentValue < 1 || currentValue > 9 || seenNumbers[currentValue]) {
                return false;
            }
            seenNumbers[currentValue] = true;
        }

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
     * Generates all possible magic squares recursively using an additional array.
     *
     * @param square        the array representing the magic square
     * @param currentSquare an auxiliary array to track used numbers
     * @param index         the current index being processed
     */
    public static void genSquare(final int[] square, final int[] currentSquare,
            final int index) {
        if (index == 9) {
            numberOfProcess++;
            if (isMagic(square)) {
                numberOfMagicSquares++;
                printMagicSquare(square);
            }
            return;
        }

        for (int currentNumber = 1; currentNumber <= 9; currentNumber++) {
            if (currentSquare[currentNumber - 1] == 0) {
                square[index] = currentNumber;
                currentSquare[currentNumber - 1] = 1;
                genSquare(square, currentSquare, index + 1);
                currentSquare[currentNumber - 1] = 0; // backtracking
            }
        }
    }

    /**
     * Generates all possible magic squares recursively without an additional array.
     *
     * @param square the array representing the magic square
     * @param index  the current index being processed
     */
    public static void genSquare2(final int[] square, final int index) {
        if (index == 9) {
            numberOfProcess++;
            if (isMagic(square)) {
                numberOfMagicSquares++;
                printMagicSquare(square);
            }
            return;
        }

        for (int currentNumber = 1; currentNumber <= 9; currentNumber++) {
            boolean isUsed = false;
            for (int checkIndex = 0; checkIndex < index; checkIndex++) {
                if (square[checkIndex] == currentNumber) {
                    isUsed = true;
                    break;
                }
            }
            if (!isUsed) {
                square[index] = currentNumber;
                genSquare2(square, index + 1);
                square[index] = 0; // backtracking
            }
        }
    }

    /**
     * Prints a 3x3 magic square.
     *
     * @param outputSquare the array representing the magic square
     */
    public static void printMagicSquare(final int[] outputSquare) {
        System.out.println("\n*****");
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
            }
            System.out.print(outputSquare[count] + " ");
        }
        System.out.println("\n*****");
    }

    /**
     * The main entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        // main stub, get user input here
        int[] magicSquare = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] extraArray = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare2(magicSquare, 0);
        genSquare(magicSquare, extraArray, 0);

        System.out.println("Number of processes: " + numberOfProcess);
        System.out.println("Number of Magic Squares: " + numberOfMagicSquares);
        System.out.println("\nDone.");
    }
}
