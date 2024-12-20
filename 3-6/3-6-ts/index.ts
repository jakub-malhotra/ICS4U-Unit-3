/*
 * Program to preform merge sort using recursion.
 * @author Jakub Malhotra
 * @version 1.0
 * @since   2024-11-20
 */

/**
 * Recursively performs Merge Sort on an array.
 * @param {number[]} array - The array to sort.
 * @returns {number[]} The sorted array.
 */
function mergeSort(array: number[]): number[] {
    // Base case: array with 0 or 1 element is already sorted
    if (array.length <= 1) {
        return array;
    }

    // Split the array into two halves
    const midIndex = Math.floor(array.length / 2);
    const leftHalf = mergeSort(array.slice(0, midIndex));
    const rightHalf = mergeSort(array.slice(midIndex));

    // Merge the two halves
    const sortedArray: number[] = [];
    let leftIndex = 0;
    let rightIndex = 0;

    while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
        if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
            sortedArray.push(leftHalf[leftIndex]);
            leftIndex++;
        } else {
            sortedArray.push(rightHalf[rightIndex]);
            rightIndex++;
        }
    }

    // Add any remaining elements
    for (let counter = leftIndex; counter < leftHalf.length; counter++) {
        sortedArray.push(leftHalf[counter]);
    }
    for (let counter = rightIndex; counter < rightHalf.length; counter++) {
        sortedArray.push(rightHalf[counter]);
    }
    return sortedArray;

}

// Main logic
console.log("Merge Sort Program");

// Constants
const MAX = 100;
const ARRAY_SIZE = 20;

// Generate random array
const randomNumberArray: number[] = Array.from(
    { length: ARRAY_SIZE },
    () => Math.floor(Math.random() * (MAX + 1))
);

console.log("\nUnsorted list of numbers:");
console.log(randomNumberArray);

// Perform Merge Sort
const sortedArray = mergeSort(randomNumberArray);

console.log("\nSorted list of numbers:");
console.log(sortedArray);

console.log("\nDone.");
