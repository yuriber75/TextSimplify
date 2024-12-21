package ie.atu.sw;

import java.util.List;

/**
 * Utility class for string concatenation
 */

public class StringConcatenation {

    /**
     * Converts a list of strings 
     * 
     * @param processedText The list of strings (words) to be concatenated.
     * @return A single string, word separated by spaces and then trimmed
     */	
    public static String convertListToString(List<String> processedText) { 
    	// Big O = O(n) n. of words in cycle for
        StringBuilder processedTextString = new StringBuilder();
        for (String word : processedText) {
            processedTextString.append(word).append(" ");
        }
        return processedTextString.toString().trim();
    }
}