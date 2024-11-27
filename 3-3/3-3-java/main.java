/*
* This program generates 250 random numbers in an array
* and allows the user to search the array for a number.
*
* @author  Jakub Malhotra
* @version 1.0
* @since   2024-11-25
*/

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

final class BinarySearch {
    private BinarySearch() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The min number for array.
     */
    public static final int MIN = 0;
    /**
     * The max number for array.
     */
    public static final int MAX = 999;
    /**
     * The number of elements in the array.
     */
    public static final int ARRAY_SIZE = 250;

    /**
     * Function finds the index of a number, using Binary Search recursively.
     *
     * @param userArray  The array of integers to search through.
     * @param userNumber The number to find.
     * @param lowIndex   The starting index of the search range.
     * @param highIndex  The ending index of the search range.
     * @return The index of the number in the array, or -1 if not found.
     */
    static int binarySearch(final int[] userArray, final int userNumber,
            final int lowIndex, final int highIndex) {
        if (lowIndex > highIndex) {
            // Base case: if the range is invalid, the number is not found.
            return -1;
        }

        // Find the middle index
        int midIndex = lowIndex + (highIndex - lowIndex) / 2;

        // Check if the middle element is the target number
        if (userArray[midIndex] == userNumber) {
            return midIndex;
        } else if (userArray[midIndex] > userNumber) {
            // Search in the left half
            return binarySearch(userArray, userNumber, lowIndex, midIndex - 1);
        } else {
            // Search in the right half
            return binarySearch(userArray, userNumber, midIndex + 1, highIndex);
        }
    }

    public static void main(final String[] args) {
        System.out.println("Binary Search Program");
        try {
            // Initializing the random class
            Random randNumber = new Random();

            // Initializing array of numbers
            int[] randomNumberArray = new int[ARRAY_SIZE];

            // Adding numbers to the array
            for (int counter = 0; counter < randomNumberArray.length;
            counter++) {
                randomNumberArray[counter] = randNumber.nextInt(MAX) + 1;
            }

            // Sorting the array
            int[] numberArray = randomNumberArray;
            Arrays.sort(numberArray);

            System.out.print("\nSorted list of numbers:\n");
            for (int element : numberArray) {
                String padded = String.format("%03d", element);
                System.out.print(padded + ", ");
            }
            System.out.print("\n\n");

            // Getting user input as to what number they wish to search for
            Scanner userInput = new Scanner(System.in);
            System.out.print("What number are you searching for in the array");
            System.out.print(" (integer between 0 and 999): ");
            int searchNumber = userInput.nextInt();
            userInput.close();
            System.out.println();

            // Ensuring the user inputs an appropriate integer
            if (searchNumber > MAX || searchNumber < MIN) {
                throw new Exception();
            } else {
                // Using binary search to find the user's chosen number
                int searchResult = binarySearch(numberArray, searchNumber,
                        0, numberArray.length - 1);

                // Outputing the results of the search
                System.out.println();
                if (searchResult == -1) {
                    System.out.println("Number not found in the array");
                } else {
                    System.out.println("Your number is in index: " + searchResult);
                }
            }

            // Catches and tells the user that an error occured
        } catch (Exception e) {
            System.out.println();
            System.out.println("ERROR: Invalid Input");
        }
    }
}
