/*
 * This program generates all possible 3x3 magic squares and checks which ones are valid.
 * @author Jakub Malhotra
 * @version 1.0
 * @since 2024-12-05
 */

// Constants
const MAGICNUM = 15; // The sum of numbers in each row, column, or diagonal in a 3x3 magic square
const ZERO = 0;
const ONE = 1;
const TWO = 2;
const THREE = 3;
const FOUR = 4;
const FIVE = 5;
const SIX = 6;
const SEVEN = 7;
const EIGHT = 8;
const NINE = 9;

// Global variables for counting processes
let numberOfMagicSquares = 0;
let numberOfProcess = 0;

/**
 * Recursively generates and checks magic squares.
 * @param {number[]} square - The current state of the magic square.
 * @param {number[]} currentSquare - The current square in progress.
 * @param {number} index - The current index being filled.
 */
function generateSquare(square: number[], currentSquare: number[], index: number): void {
    if (index === NINE) {
        // Base case: If all squares are filled, check if it's a magic square
        if (isMagic(square)) {
            printMagicSquare(square); // If magic, print the square
            numberOfMagicSquares++;
        }
        numberOfProcess++; // Count the process
        return;
    }

    // Try all numbers from 1 to 9 that haven't been used yet
    for (let number = 1; number <= NINE; number++) {
        let numberUsed = false;

        // Check if the number has already been used
        if (square.slice(0, index).includes(number)) {
            numberUsed = true;
        }

        if (!numberUsed) {
            // Assign number and recurse
            square[index] = number;
            generateSquare(square, currentSquare, index + 1);
            // Backtrack
            square[index] = 0;
        }
    }
}

/**
 * Checks if the given square is a magic square.
 * @param {number[]} preSquare - The array representing the square.
 * @returns {boolean} - Whether the square is a magic square.
 */
function isMagic(preSquare: number[]): boolean {
    const row1 = preSquare[ZERO] + preSquare[ONE] + preSquare[TWO];
    const row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
    const row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
    const col1 = preSquare[ZERO] + preSquare[THREE] + preSquare[SIX];
    const col2 = preSquare[ONE] + preSquare[FOUR] + preSquare[SEVEN];
    const col3 = preSquare[TWO] + preSquare[FIVE] + preSquare[EIGHT];
    const diag1 = preSquare[ZERO] + preSquare[FOUR] + preSquare[EIGHT];
    const diag2 = preSquare[TWO] + preSquare[FOUR] + preSquare[SIX];

    // Check if all rows, columns, and diagonals sum up to the MAGICNUM
    return row1 === MAGICNUM && row2 === MAGICNUM && row3 === MAGICNUM
        && col1 === MAGICNUM && col2 === MAGICNUM && col3 === MAGICNUM
        && diag1 === MAGICNUM && diag2 === MAGICNUM;
}

/**
 * Prints a magic square in the correct format.
 * @param {number[]} outputSquare - The array representing the magic square.
 */
function printMagicSquare(outputSquare: number[]): void {
    console.log("\n*****");
    // Loop through the outputSquare array and print it in a 3x3 grid
    for (let row = 0; row < 3; row++) {
        let rowOutput = "";
        for (let col = 0; col < 3; col++) {
            rowOutput += outputSquare[row * 3 + col] + " ";  // Access each element in the 3x3 grid
        }
        console.log(rowOutput.trim());  // Print the row without extra spaces at the end
    }
    console.log("*****\n");
}

// Main logic
console.log("All Possible Magic Squares (3x3):\n");

// Initialize square array
const magicSquare: number[] = Array(NINE).fill(0);
const extraArray: number[] = Array(NINE).fill(0);

// Generate and check all possible magic squares
generateSquare(magicSquare, extraArray, 0);

// Output the results
console.log("Number of processes: " + numberOfProcess);
console.log("Number of Magic Squares: " + numberOfMagicSquares);
console.log("\nDone.");
