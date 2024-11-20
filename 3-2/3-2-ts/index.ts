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
    if (numberToFactorial < 0) {
        return -1;
    }
    if (numberToFactorial == 1 || 0) {
        return 1;
    }
        const lowerNumber = numberToFactorial - 1;

        // Multiply the lower number by the current number
        return calculateFactorial(lowerNumber) * numberToFactorial;
    }

// the main logic
const userInput = prompt("Enter a positive integer:");

console.log("");
const theProduct = calculateFactorial(userInput);
if (theProduct == -1) {
    console.log("Invalid input")
} else {
    console.log(`${userInput}! = ${theProduct}`);
}
console.log("\nDone.");
