/*
 * Program to perform Merge Sort using recursion.
 * @author Jakub Malhotra
 * @version 1.0
 * @since   2024-12-19
 */

import java.util.Arrays;
import java.util.Random;

final class MergeSort {
    private MergeSort() {
        // Prevent instantiation
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Recursively performs Merge Sort on an array.
     *
     * @param array The array to sort.
     * @return The sorted array.
     */
    public static int[] mergeSort(final int[] array) {
        // Base case: array with 0 or 1 element is already sorted
        if (array.length <= 1) {
            return array;
        }

        // Split the array into two halves
        final int midIndex = array.length / 2;
        final int[] leftHalf = Arrays.copyOfRange(array, 0, midIndex);
        final int[] rightHalf = Arrays.copyOfRange(array,
            midIndex, array.length);

        // Recursively sort the two halves
        final int[] sortedLeft = mergeSort(leftHalf);
        final int[] sortedRight = mergeSort(rightHalf);

        // Merge the two halves
        return merge(sortedLeft, sortedRight);
    }

    /**
     * Merges two sorted arrays into one sorted array.
     *
     * @param left  The left sorted array.
     * @param right The right sorted array.
     * @return The merged sorted array.
     */
    private static int[] merge(final int[] left, final int[] right) {
        final int[] sortedArray = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int sortedIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                sortedArray[sortedIndex++] = left[leftIndex++];
            } else {
                sortedArray[sortedIndex++] = right[rightIndex++];
            }
        }

        // Add any remaining elements from the left or right array
        while (leftIndex < left.length) {
            sortedArray[sortedIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            sortedArray[sortedIndex++] = right[rightIndex++];
        }

        return sortedArray;
    }

    public static void main(final String[] args) {
        System.out.println("Merge Sort Program");

        // Constants
        final int max = 100;
        final int arraySize = 20;

        // Generate random array
        final Random rand = new Random();
        final int[] randomNumberArray = new int[arraySize];
        for (int index = 0; index < randomNumberArray.length; index++) {
            randomNumberArray[index] = rand.nextInt(max + 1);
        }

        System.out.println("\nUnsorted list of numbers:");
        for (int num : randomNumberArray) {
            System.out.print(num + " ");
        }

        // Perform Merge Sort
        final int[] sortedArray = mergeSort(randomNumberArray);

        System.out.println("\n\nSorted list of numbers:");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }

        System.out.println("\n\nDone.");
    }
}
