/*
 * Program to reverse a string using recursion.
 * @author Jakub Malhotra
 * @version 1.0
 * @since   2024-11-18
 */

/**
 * Recursively reverses a string.
 * @param {string} stringToReverse - The string to be reversed.
 * @returns {string} The reversed string.
 */
function reverseString(stringToReverse: string): string {
    if (stringToReverse === "") {
        return "";
    } else {
        const firstCharacterOfString = stringToReverse.charAt(0);
        const restOfString = stringToReverse.slice(1);

        // Reverse the rest of the string and append the first character.
        return reverseString(restOfString) + firstCharacterOfString;
    }
}

/**
 * Main function to execute the string reversal program.
 */
function main(): void {
    const aString = "Reverse";

    console.log("");
    console.log(`The original string is: ${aString}`);
    const theReversedString = reverseString(aString);
    console.log(`The reversed string is: ${theReversedString}`);

    console.log("\nDone.");
}
