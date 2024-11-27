/*
 * Program to perform binary search on a sorted array.
 * @author Jakub Malhotra
 * @version 1.0
 * @since   2024-11-26
 */

/**
 * Recursively performs binary search on an array.
 * @param {number[]} userArray - The sorted array to search through.
 * @param {number} userNumber - The number to search for.
 * @param {number} lowIndex - The lower bound of the search range.
 * @param {number} highIndex - The upper bound of the search range.
 * @returns {number} The index of the number, or -1 if not found.
 */
function binarySearch(
    userArray: number[],
    userNumber: number,
    lowIndex: number,
    highIndex: number
): number {
    // Base case: if range is invalid, number not found
    if (lowIndex > highIndex) {
        return -1;
    }

    // Calculate middle index
    const midIndex = Math.floor(lowIndex + (highIndex - lowIndex) / 2);

    // Check middle element
    if (userArray[midIndex] === userNumber) {
        return midIndex;
    } else if (userArray[midIndex] > userNumber) {
        // Search in the left half
        return binarySearch(userArray, userNumber, lowIndex, midIndex - 1);
    } else {
        // Search in the right half
        return binarySearch(userArray, userNumber, midIndex + 1, highIndex);
    }
}

// Main logic
console.log("Binary Search Program");

// Constants
const MIN = 0;
const MAX = 999;
const ARRAY_SIZE = 250;

// Generate random array
const randomNumberArray: number[] = Array.from(
    { length: ARRAY_SIZE },
    () => Math.floor(Math.random() * (MAX + 1))
);

// Sort the array
const sortedArray = randomNumberArray.sort((a, b) => a - b);

console.log("\nSorted list of numbers:");
console.log(sortedArray.map((num) => num.toString().padStart(3, "0")).join(", "));

console.log("\n");

// Get user input using Deno prompt
const input = prompt(`What number are you searching for (integer between ${MIN} and ${MAX}): `);

if (input === null) {
    console.log("Invalid Input");
} else {
    const userInput = parseFloat(input);

    if (!Number.isInteger(userInput) || userInput < MIN || userInput > MAX) {
        console.log("\nERROR: Invalid Input");
    } else {
        // Perform binary search
        const searchResult = binarySearch(sortedArray, userInput, 0, sortedArray.length - 1);

        // Output result
        if (searchResult === -1) {
            console.log("\nNumber not found in the array.");
        } else {
            console.log(`\nYour number is at index: ${searchResult}`);
        }
    }
}

console.log("\nDone.");
