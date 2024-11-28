/*
* This program solves
* the Tower of Hanoi riddle.
*
* @author  Jakub Malhotra
* @version 1.0
* @since   2024-11-28
*/

import java.util.Scanner;

final class TowerOfHanoi {
    private TowerOfHanoi() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    static void hanoi(final int nOfDisks, final int startPeg,
            final int endPeg) {
        // This function calculates where the disks should be placed in
        final int pegNumber = 6;
        if (nOfDisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg + " to peg "
                    + endPeg);
        } else {
            hanoi(nOfDisks -1, startPeg, 6 - startPeg - endPeg);
            System.out.println("Move disk " + nOfDisks + " from peg "
                    + startPeg + " to peg " + endPeg);
            hanoi(nOfDisks - 1 , 6 - startPeg - endPeg, endPeg);
        }
    }

    public static void main(final String[] args) {
        final int startPeg = 1;
        final int endPeg = 3;

        System.out.println("Tower of Hanoi");

        // input
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");

        try {
            int nOfDisks = userInput.nextInt();
            System.out.println();
            if (nOfDisks > 0) {
                // process
                hanoi(nOfDisks, startPeg, endPeg);
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (Exception ex) {
            System.err.print("\nThis is not an integer");
        }
    }
}
