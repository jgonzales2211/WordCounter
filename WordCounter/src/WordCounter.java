public class WordCounter {

    public static void main(String[] args) {
        // Creates the Scanner object
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Enter string:");

        // Reads the input
        String input = scanner.nextLine();

        // Counts the number of words
        int wordCount = countWords(input);

        // Shows the word count
        System.out.println("Word count: " + wordCount);

        scanner.close();
    }

    /**
     * Finds the position of the next blank character in a String.
     * If none exists, the length of the string is returned.
     * @param str string containing characters to search
     * @param from character position where the search starts
     * @return character position of the next blank character
     */
    public static int nextSpacePosition(String str, int from) {
        int length = str.length(); // Gets the length of the string
        for (int i = from; i < length; i++) { // Loops through
            if (str.charAt(i) == ' ') { // Checks for space
                return i;
            }
        }
        return length;
    }

    /**
     * Finds the position of the next non-blank character in a String.
     * If none exists, the length of the string is returned.
     * @param str string containing characters to search
     * @param from character position where the search starts
     * @return character position of the next non-blank character
     */
    public static int nextNonSpacePosition(String str, int from) {
        int length = str.length(); // Gets the length of the string
        for (int i = from; i < length; i++) { // Loops through
            if (str.charAt(i) != ' ') { // Check for space
                return i;
            }
        }
        return length;
    }

    /**
     * Counts the number of words in a given string.
     * A word is a sequence of characters separated by any number of spaces.
     * @param str string to count words in
     * @return number of words in str
     */
    public static int countWords(String str) {
        int wordCount = 0; // Starts the word count at zero
        int position = 0; // Starts the starting position at zero
        int length = str.length(); // Gets the length of the string

        while (position < length) { // Loops through
            position = nextNonSpacePosition(str, position); // Looks for character
            if (position < length) {
                wordCount++; // Increments the word count
                position = nextSpacePosition(str, position); // Finds the next space character
            }
        }
        return wordCount;
    }
}
