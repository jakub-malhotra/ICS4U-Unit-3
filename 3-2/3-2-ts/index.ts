/*
 * Program to calculate factorials using recursion.
 * @author Jakub Malhotra
 * @version 1.0
 * @since   2024-11-20
 */

/**
 * Recursively preforms factorial calculations
 * @param {number} numberToFactorial - The number to be calculated in factorial.
 * @returns {number} The output of the calculation.
 */
function calculateFactorial(numberToFactorial: number): number {
    // return -1 for error cases
    if (Number.isInteger(numberToFactorial) === false) {
        return -1;
    }
    if (numberToFactorial < 0) {
        return -1;
    }
    // base case and 0 case
    if (numberToFactorial == 1 || numberToFactorial == 0) {
        return 1;
    }

    // Multiply the lower number by the current number
    return calculateFactorial(numberToFactorial - 1) * numberToFactorial;
    }

// the main logic
const input = prompt("Enter a positive integer: ");
if (input === null) {
    console.log("Invalid Input");
} else {
    const userInput = parseFloat(input);

    console.log("");
    const theProduct = calculateFactorial(userInput);
    if (theProduct == -1) {
        console.log("Invalid input");
    } else {
        console.log(`${userInput}! = ${theProduct}`);
    }
}

console.log("\nDone.");
