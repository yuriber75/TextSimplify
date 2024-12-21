package ie.atu.sw;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Prints debug information related all data loaded
 * 
 * <ul>
 *     <li>Logs simple messages</li>
 *     <li>Prints a sample of word embeddings and his size</li>
 *     <li>Prints a sample of Google-1000 and his size</li>
 *     <li>Displays text content and processed text.</li>
 * </ul>
 */
public class DebugLogger {

    /**
     * Logs a simple message to the console
     * 
     * @param message the message to print
     */
    public void log(String message) {//Big O = O(1)
        System.out.println(message);
    }

    /**
     * Prints size and vectors of the word wordEmbeddings Maps
     * Delegate the responsibility of print the vector to DebugVectorPrinter
     * 
     * @param wordEmbeddings a map containing embeddings
     */    
    public void printWordEmbeddings(Map<String, double[]> wordEmbeddings) {//Big O = O(n)
    	DebugPrinter.printVectors(wordEmbeddings, "word embeddings");//Big O = O(n) -> from DebugVectorPrinter 
    }

    /**
     * Prints size and words of the googleWords Set.
     * It calls a helper function to print the words
     * 
     * @param googleWords a set containing Google words
     */
    public void printGoogleWords(Set<String> googleWords) {//Big O = O(n)
        DebugPrinter.printWords(googleWords, "word Google");//Big O = O(n) 
    }

    /**
     * Prints the loaded text content as sequence of words
     * 
     * @param textWords a list of words from the loaded text
     */    
    public void printTextContent(List<String> textWords) {//Big O = O(n)
        System.out.println("Loaded text content:");
        for (String word : textWords) {                   //Big O = O(n)
            System.out.print(word + " ");                 //Big O = O(1)
        }
        System.out.println();
    }
    
    /**
     * Prints the processed text
     * 
     * @param processedText the processed version of the text
     */
    public void printProcessedText(String processedText) { //Big O = O(1)
        System.out.println("\nProcessed Text: ");          //Big O = O(1)
        System.out.println(processedText);                 //Big O = O(1)
    }
}
