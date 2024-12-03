/*
* This program solves
* the Tower of Hanoi riddle.
*
* @author  Jakub Malhotra
* @version 1.0
* @since   2024-11-28
*/

import java.util.Scanner;

/**
 * The TowerOfHanoi class contains methods to solve the Tower of Hanoi puzzle.
 * This class cannot be instantiated.
 */
final class TowerOfHanoi {

    /**
     * Private constructor to prevent instantiation.
     * Throws an IllegalStateException if called.
     */
    private TowerOfHanoi() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Recursively solves the Tower of Hanoi puzzle.
     *
     * @param nOfDisks the number of disks to move.
     * @param startPeg the starting peg.
     * @param endPeg   the target peg.
     */
    static void hanoi(
            final int nOfDisks, final int startPeg, final int endPeg) {
        final int pegNumber = 6; // Sum of peg numbers in a three-peg setup
        if (nOfDisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg
                    + " to peg " + endPeg);
        } else {
            hanoi(nOfDisks - 1, startPeg, pegNumber - startPeg - endPeg);
            System.out.println("Move disk " + nOfDisks + " from peg "
                    + startPeg + " to peg " + endPeg);
            hanoi(nOfDisks - 1, pegNumber - startPeg - endPeg, endPeg);
        }
    }

    /**
     * The main method where the program starts.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(final String[] args) {
        final int startPeg = 1;
        final int endPeg = 3;

        System.out.println("Tower of Hanoi");

        // Input handling
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");

        try {
            int nOfDisks = userInput.nextInt();
            System.out.println();
            if (nOfDisks > 0) {
                // Process
                hanoi(nOfDisks, startPeg, endPeg);
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (Exception ex) {
            System.err.print("\nThis is not an integer\n");
        }
        System.out.print("\nDone.");
    }
}
