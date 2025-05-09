package ie.atu.sw;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Visualises word vectors in order to understand if loaded correctly
 * 
 * Prints word vectors stored in a map in a formatted tabular way
 */
public class DebugPrinter {

    private static final int WORD_COLUMN_WIDTH = 22;  
    
    /**
     * Displays a message asking the user how many word vectors they want to print.
     * 
     * @param size The size of the Map
     * @param label The name of the Map
     */
    private static void getLinesToPrint(int size, String label) { // Big O = O(1)
        System.out.println("To verify the correct " + label + " loading,");
        System.out.println("how many lines would you like to see? ");
        System.out.println("from 1 to (max size) " + size);
    }

    /**
     * Requests to specify number of lines to be printed
     * 
     * @param size  Dimension of the Map or Set 
     * @param label The label for the data
     */
    private static int printLines(int size, String label) { // Big O = O(1)  
        System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
        int lines = MenuProcessInput.processInput(size, new Scanner(System.in));
        System.out.println(ConsoleColour.GREEN);
        
        System.out.println("Debug: First " + lines + " " + label + " loaded:");
        
        return lines;
    }

    /**
     * Prints words and vectors from the provided map.
     * 
     * @param wordVectors the map containing word vectors
     * @param label the label for the word vectors
     */
    public static void printVectors(Map<String, double[]> wordVectors, String label) { // Big O = O(n)
        int count = 0;                                // initialise a counter
        
        int size = wordVectors.size();                // get total size
        getLinesToPrint(size, label);                 // call a method to print
        
        int lines = printLines(size, label);          // get number of lines
        
        for (Map.Entry<String, double[]> key : wordVectors.entrySet()) { // Big O = O(n)
            System.out.printf("%-" + WORD_COLUMN_WIDTH + "s", "Word: " + key.getKey());
            System.out.print(" Vector: [");           // Print Word and Key tabulated [%-22s]

            double[] vector = key.getValue();         // get vector array of double
            for (int i = 0; i < vector.length; i++) { // Big O = O(n)- loop and print vectors
                System.out.printf("%.4f", vector[i]); // formatted 4 decimal places
                if (i < vector.length - 1) System.out.print(", ");
            }
            System.out.println("]");

            count++;                                  // update counter
            if (count == lines) break;                // stop loop
        }
        System.out.println("");
    }

    /**
     * Prints words from the provided set.
     * 
     * @param words the set containing words
     * @param label the label for the words
     */
    public static void printWords(Set<String> words, String label) { // Big O = O(n)
        int count = 0;
        
        int size = words.size();
        getLinesToPrint(size, label);
        
        int lines = printLines(size, label);
        
        for (String word : words) { // Big O = O(n)
            System.out.printf("%-" + WORD_COLUMN_WIDTH + "s", "Word: " + word);
            System.out.println();

            count++;
            if (count == lines) break;
        }
        System.out.println("");
    }
}