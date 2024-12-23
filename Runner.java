package ie.atu.sw;

import java.util.*;

/**
 * Simplifying Text with Word Embeddings 
 * is a text simplifier API and application UI in Java that converts
 * the words in a text file to the 1,000 most common words in English.
 * 
 * @author  Yuri Bertozzi G00439350@atu.ie 
 * @version 1.0
 * @since   1.9 
 */
public class Runner {
    
	/**
     * The main method, serve as the entry point of the application.
     *
     * @param args Arguments passed to the application.
     * @throws InterruptedException if any thread interruption occurs during execution.
     * @since 1.0
     */
    public static void main(String[] args) throws InterruptedException {
        // Initialize necessary services
        FilePathManager filePathManager = new FilePathManager();
        
        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Initialize MenuManager to handle menu-driven interactions
        MenuManager menuManager = new MenuManager(filePathManager, scanner);
        
        // Start the menu
        menuManager.displayMenu();
        
        // Close the scanner to release system resources
        scanner.close();
    }
}
        





