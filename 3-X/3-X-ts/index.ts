/*
 * This program solves the Tower of Hanoi riddle.
 * @author Jakub Malhotra
 * @version 1.0
 * @since 2024-11-28
 */

/**
 * Recursively solves the Tower of Hanoi problem.
 * @param {number} nOfDisks - The number of disks to move.
 * @param {number} startPeg - The starting peg.
 * @param {number} endPeg - The target peg.
 */
function hanoi(nOfDisks: number, startPeg: number, endPeg: number): void {
    const pegNumber = 6; // Sum of peg numbers in a three-peg setup
    if (nOfDisks === 1) {
        console.log(`Move disk 1 from peg ${startPeg} to peg ${endPeg}`);
    } else {
        hanoi(nOfDisks - 1, startPeg, pegNumber - startPeg - endPeg);
        console.log(`Move disk ${nOfDisks} from peg ${startPeg} to peg ${endPeg}`);
        hanoi(nOfDisks - 1, pegNumber - startPeg - endPeg, endPeg);
    }
}

// Main logic
console.log("Tower of Hanoi\n");

// Constants
const START_PEG = 1;
const END_PEG = 3;

// Get user input using Deno prompt
const input = prompt("How many disks do you want?: ");

if (input === null) {
    console.log("Invalid Input");
} else {
    const nOfDisks = parseFloat(input);

    if (!Number.isInteger(nOfDisks) || nOfDisks <= 0) {
        console.log("\nPlease enter a positive integer");
    } else {
        // Process
        console.log();
        hanoi(nOfDisks, START_PEG, END_PEG);
    }
}

console.log("\nDone.");
