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
    if (numberToFactorial == 1) {
        return 1;
    } else {
        const lowerNumber = numberToFactorial - 1;

        // Reverse the rest of the string and append the first character.
        return calculateFactorial(lowerNumber) * numberToFactorial;
    }
}

// the main logic
const aNumber = 5

console.log("");
console.log(`${aNumber}!`);
const theProduct = calculateFactorial(aNumber);
console.log(` = ${theProduct}`);

console.log("\nDone.");
