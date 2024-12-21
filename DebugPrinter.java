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

    private static final int WORD_COLUMN_WIDTH = 18;  
    
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
     * Prints a specified number of lines from Set or Map
     * 
     * @param <T> The type either a Set or a Map
     * @param data either Set<String> or Map<String, double[]>
     * @param label The label for the data
     * @param isMap check if it is a map
     */
    private static <T> void printLines(T data, String label, boolean isMap) { // Big O = O(n)
        int count = 0;
        
        int size;
        if (isMap) {
            Map<String, double[]> mapData = (Map<String, double[]>) data;//casting should be safe in this case...not optimal
            size = mapData.size();
        } else {
            Set<String> setData = (Set<String>) data;//casting should be safe in this case...not optimal
            size = setData.size();
        }
        
        getLinesToPrint(size, label);
        
        System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
        int lines = MenuProcessInput.processInput(size, new Scanner(System.in));
        System.out.println(ConsoleColour.GREEN);
        
        System.out.println("Debug: First " + lines + " " + label + " loaded:");
        
        // Print either the words or word vectors
        if (isMap) {
            Map<String, double[]> wordVectors = (Map<String, double[]>) data;
            for (Map.Entry<String, double[]> entry : wordVectors.entrySet()) { // Big O = O(n)
                System.out.printf("%-" + WORD_COLUMN_WIDTH + "s", "Word: " + entry.getKey());
                System.out.print(" Vector: [");

                double[] vector = entry.getValue();
                for (int i = 0; i < vector.length; i++) { // Big O = O(n)
                    System.out.printf("%.4f", vector[i]);
                    if (i < vector.length - 1) System.out.print(", ");
                }
                System.out.println("]");

                count++;
                if (count == lines) break;
            }
        } else {
            Set<String> words = (Set<String>) data; //casting should be safe in this case...not optimal
            for (String word : words) { // Big O = O(n)
                System.out.printf("%-" + WORD_COLUMN_WIDTH + "s", "Word: " + word);
                System.out.println();

                count++;
                if (count == lines) break;
            }
        }

        System.out.println("");
    }

    /**
     * Prints word vectors from the provided map.
     * 
     * @param wordVectors the map containing word vectors
     * @param label the label for the word vectors
     */
    public static void printVectors(Map<String, double[]> wordVectors, String label) { // Big O = O(n)
        printLines(wordVectors, label, true); // Use the generic method for printing maps
    }

    /**
     * Prints words from the provided set.
     * 
     * @param words the set containing words
     * @param label the label for the words
     */
    public static void printWords(Set<String> words, String label) { // Big O = O(n)
        printLines(words, label, false); // Use the generic method for printing sets
    }
}